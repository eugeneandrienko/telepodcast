//
// Copyright Aliaksei Levin (levlam@telegram.org), Arseny Smirnov (arseny30@gmail.com) 2014-2022
//
// Distributed under the Boost Software License, Version 1.0. (See accompanying
// file LICENSE_1_0.txt or copy at http://www.boost.org/LICENSE_1_0.txt)
//
// Changed by Andrienko Eugene (evg.andrienko@gmail.com) 2022

package com.eugene_andrienko.telegram.impl;

import com.eugene_andrienko.telegram.api.exceptions.TelegramAuthException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import java.io.*;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Example class for TDLib usage from Java.
 */
public class Telegram implements AutoCloseable
{
    private final int apiId;
    private final String apiHash;
    private final boolean debug;

    private Logger logger = LoggerFactory.getLogger(Telegram.class);

    private static Client client = null;

    private static TdApi.AuthorizationState authorizationState = null;
    private static volatile boolean haveAuthorization = false;
    private static volatile boolean needQuit = false;

    private final Client.ResultHandler defaultHandler = new DefaultHandler();

    private static final Lock authorizationLock = new ReentrantLock();
    private static final Condition gotAuthorization = authorizationLock.newCondition();

    private static final ConcurrentMap<Long, TdApi.User> users = new ConcurrentHashMap<>();
    private static final ConcurrentMap<Long, TdApi.BasicGroup> basicGroups = new ConcurrentHashMap<>();
    private static final ConcurrentMap<Long, TdApi.Supergroup> supergroups = new ConcurrentHashMap<>();
    private static final ConcurrentMap<Integer, TdApi.SecretChat> secretChats = new ConcurrentHashMap<>();

    private static final ConcurrentMap<Long, TdApi.Chat> chats = new ConcurrentHashMap<>();
    private static final NavigableSet<OrderedChat> mainChatList = new TreeSet<>();
    private static boolean haveFullMainChatList = false;

    private static final ConcurrentMap<Long, TdApi.UserFullInfo> usersFullInfo = new ConcurrentHashMap<>();
    private static final ConcurrentMap<Long, TdApi.BasicGroupFullInfo> basicGroupsFullInfo = new ConcurrentHashMap<>();
    private static final ConcurrentMap<Long, TdApi.SupergroupFullInfo> supergroupsFullInfo = new ConcurrentHashMap<>();

    private static final String newLine = System.getProperty("line.separator");
    private static final String commandsLine = "Enter command (gcs - GetChats, gc <chatId> - GetChat, me - GetMe, sm <chatId> <message> - SendMessage, lo - LogOut, q - Quit): ";
    private static volatile String currentPrompt = null;

    private static final String SAVED_MESSAGES_CHAT = "Saved Messages";

    public enum MessageSenderState {OK, FAIL, RETRY};
    public enum MessageType {TEXT, AUDIO, VIDEO};

    // TODO: use 1.8.0 static library
    // TODO: load library from JAR
    static
    {
        try
        {
            System.loadLibrary("tdjni");
        }
        catch(UnsatisfiedLinkError e)
        {
            e.printStackTrace();
        }
    }

    public Telegram(int apiId, String apiHash, boolean debug) throws TelegramAuthException
    {
        if(apiId == 0 || apiHash == null || apiHash.isBlank())
        {
            logger.error("Telegram API ID or hash not provided!");
            throw new TelegramAuthException("Telegram API ID or hash not provided");
        }

        this.apiId = apiId;
        this.apiHash = apiHash;
        this.debug = debug;
    }

    public CompletableFuture<Boolean> init()
    {
        // Setup TDLib logging:
        if(debug)
        {
            Client.execute(new TdApi.SetLogVerbosityLevel(4));
            TdApi.LogStreamFile logStreamFile = new TdApi.LogStreamFile(
                    "tdlib.log", 5 * 1024 * 1024 /* 5 Mb */, false);
            if(Client.execute(new TdApi.SetLogStream(logStreamFile)) instanceof TdApi.Error)
            {
                logger.error("Cannot SetLogStream(LogStreamFile(\"./tdlib.log\"))");
                throw new IOError(new IOException("Failed to start TDLib debug log"));
            }
        }
        else
        {
            Client.execute(new TdApi.SetLogVerbosityLevel(0));
            if(Client.execute(
                    new TdApi.SetLogStream(new TdApi.LogStreamEmpty())) instanceof TdApi.Error)
            {
                logger.error("Cannot SetLogStream(LogStreamEmpty)");
                throw new IOError(new IOException("Failed to setup TDLib logging"));
            }
        }

        // Authorization:
        client = Client.create(new UpdateHandler(), null, null);
        logger.debug("Created client");
        return CompletableFuture.supplyAsync(() -> {
            logger.debug("Waiting for authorization...");
            while(!haveAuthorization)
            {
                // await authorization
                authorizationLock.lock();
                try
                {
                    while(!haveAuthorization)
                    {
                        try
                        {
                            gotAuthorization.await();
                        }
                        catch(InterruptedException e)
                        {
                            throw new RuntimeException(e);
                        }
                    }
                }
                finally
                {
                    authorizationLock.unlock();
                }
            }
            logger.debug("Got authorization!");
            return true;
        });
    }

    @Override
    public void close() throws Exception
    {
        needQuit = true;
        haveAuthorization = false;
        client.send(new TdApi.Close(), defaultHandler);
    }

    public void loadChatList(final int limit)
    {
        synchronized(mainChatList)
        {
            if(haveAuthorization && !haveFullMainChatList && limit > mainChatList.size())
            {
                // Send LoadChats request if there are some unknown chats and have not enough
                // known chats:
                logger.debug("Send TdApi.LoadChats message");
                client.send(
                        new TdApi.LoadChats(new TdApi.ChatListMain(), limit - mainChatList.size()),
                        object -> {
                            switch(object.getConstructor())
                            {
                                case TdApi.Error.CONSTRUCTOR:
                                    logger.debug("TdApi.LoadChats error");
                                    if(((TdApi.Error)object).code == 404)
                                    {
                                        synchronized(mainChatList)
                                        {
                                            logger.debug("Have full main chat list");
                                            haveFullMainChatList = true;
                                        }
                                    }
                                    else
                                    {
                                        logger.error("Receive an error for LoadChats: {}", object);
                                    }
                                    break;
                                case TdApi.Ok.CONSTRUCTOR:
                                    logger.debug("TdApi.LoadChats Ok");
                                    // Chats had already been received through updates,
                                    // let's retry request:
                                    loadChatList(limit);
                                    break;
                                default:
                                    logger.error("Receive wrong response from TDLib: {}", object);
                            }
                        });
            }
        }
    }

    public CompletableFuture<Boolean> isChatListLoaded(final int limit)
    {
        return CompletableFuture.supplyAsync(() ->
        {
            if(!haveAuthorization)
            {
                return false;
            }
            if(haveFullMainChatList)
            {
                return true;
            }

            int chatListSize = 0;
            while(limit > chatListSize)
            {
                synchronized(mainChatList)
                {
                    chatListSize = mainChatList.size();
                }
                Thread.yield();
            }
            return true;
        });
    }

    public CompletableFuture<Long> getSavedMessagesChatId(String chatName)
    {
        CompletableFuture<Long> result = new CompletableFuture<>();

        synchronized(mainChatList)
        {
            java.util.Iterator<OrderedChat> iter = mainChatList.iterator();
            for(int i = 0; i < mainChatList.size(); i++)
            {
                long chatId = iter.next().chatId;
                TdApi.Chat chat = chats.get(chatId);
                synchronized(chat)
                {
                    if(chat.title.equals(chatName) || chat.title.equals(SAVED_MESSAGES_CHAT))
                    {
                        logger.debug("Found chat: id={}, name={}", chatId, chat.title);
                        result.complete(chatId);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public CompletableFuture<String> getSavedMessagesChatName()
    {
        CompletableFuture<String> result = new CompletableFuture<>();

        logger.debug("Computing \"Saved messages\" chat name");
        client.send(new TdApi.GetMe(), object -> {
            switch(object.getConstructor())
            {
                case TdApi.Error.CONSTRUCTOR:
                    logger.error("Failed to load user metadata");
                    break;
                case TdApi.User.CONSTRUCTOR:
                    TdApi.User user = (TdApi.User)object;
                    String savedMessagesName;
                    if(user.lastName.isEmpty())
                    {
                        savedMessagesName = user.firstName;
                    }
                    else
                    {
                        savedMessagesName = user.firstName + " " + user.lastName;
                    }
                    logger.debug("Got chat name: \"{}\"", savedMessagesName);
                    result.complete(savedMessagesName);
                    break;
                default:
                    logger.error("Receive wrong response from TDLib: {}", object);
            }
        });
        return result;
    }

    public CompletableFuture<MessageSenderState> sendMessage(long chatId, MessageType messageType,
            Object message)
    {
        CompletableFuture<MessageSenderState> result = new CompletableFuture<>();

        TdApi.InputMessageContent content;
        switch(messageType)
        {
            case TEXT:
                if(!(message instanceof String))
                {
                    logger.error("Got message type: {} but type of message is {}", messageType,
                            message.getClass().getCanonicalName());
                    result.complete(MessageSenderState.FAIL);
                    return result;
                }
                content = new TdApi.InputMessageText(
                        new TdApi.FormattedText((String)message, null),
                        false, true);
                break;
            case AUDIO:
                if(!(message instanceof File))
                {
                    logger.error("Got message type: {} but type of message is not a File: {}",
                            messageType, message.getClass().getCanonicalName());
                    result.complete(MessageSenderState.FAIL);
                    return result;
                }
                File audio = (File)message;
                content = new TdApi.InputMessageAudio(
                        new TdApi.InputFileLocal(audio.getAbsolutePath()),
                        null, 0, audio.getName(), null, null);
                break;
            case VIDEO:
                if(!(message instanceof File))
                {
                    logger.error("Got message type: {} but type of message is not a File: {}",
                            messageType, message.getClass().getCanonicalName());
                    result.complete(MessageSenderState.FAIL);
                    return result;
                }
                File video = (File)message;
                content = new TdApi.InputMessageVideo(
                        new TdApi.InputFileLocal(video.getAbsolutePath()),
                        null, new int[]{}, 0, 0, 0, true, null, 0);
                break;
            default:
                logger.error("Got unknown message type: {}", messageType);
                result.complete(MessageSenderState.FAIL);
                return result;
        }

        Client.ResultHandler messageHandler = answer -> {
            if(!(answer instanceof TdApi.Message))
            {
                logger.error("Got unknown answer in message handler: {}", answer);
                logger.error("Constructor: {}", answer.getConstructor());
                result.complete(MessageSenderState.FAIL);
                return;
            }

            TdApi.MessageSendingState state = ((TdApi.Message)answer).sendingState;
            switch(state.getConstructor())
            {
                case TdApi.MessageSendingStatePending.CONSTRUCTOR:
                    logger.debug("Message sent to server");
                    result.complete(MessageSenderState.OK);
                    break;
                case TdApi.MessageSendingStateFailed.CONSTRUCTOR:
                    TdApi.MessageSendingStateFailed fail = (TdApi.MessageSendingStateFailed)state;
                    if(fail.canRetry)
                    {
                        result.completeAsync(() -> {
                            try
                            {
                                Thread.sleep(Math.round(fail.retryAfter));
                            }
                            catch(InterruptedException e)
                            {
                                logger.error("Failed to wait {} seconds before resending message",
                                        fail.retryAfter);
                                return MessageSenderState.FAIL;
                            }
                            return MessageSenderState.RETRY;
                        });
                    }
                    else
                    {
                        logger.error("Failed to send message! Error code: {}. Error message: {}.",
                                fail.errorCode, fail.errorMessage);
                        result.complete(MessageSenderState.FAIL);
                    }
                    break;
                default:
                    logger.error("Got unknown message state when sending message: {}", state);
                    logger.error("Constructor: {}", state.getConstructor());
                    result.completeExceptionally(new TelegramSendMessageException());
            }
        };

        client.send(new TdApi.SendMessage(chatId, 0, 0, null, null, content), messageHandler);
        return result;
    }

    private static void print(String str)
    {
        if(currentPrompt != null)
        {
            System.out.println();
        }
        System.out.println(str);
        if(currentPrompt != null)
        {
            System.out.print(currentPrompt);
        }
    }

    private static void setChatPositions(TdApi.Chat chat, TdApi.ChatPosition[] positions)
    {
        synchronized(mainChatList)
        {
            synchronized(chat)
            {
                for(TdApi.ChatPosition position : chat.positions)
                {
                    if(position.list.getConstructor() == TdApi.ChatListMain.CONSTRUCTOR)
                    {
                        boolean isRemoved = mainChatList.remove(new OrderedChat(chat.id, position));
                        assert isRemoved;
                    }
                }

                chat.positions = positions;

                for(TdApi.ChatPosition position : chat.positions)
                {
                    if(position.list.getConstructor() == TdApi.ChatListMain.CONSTRUCTOR)
                    {
                        boolean isAdded = mainChatList.add(new OrderedChat(chat.id, position));
                        assert isAdded;
                    }
                }
            }
        }
    }

    private void onAuthorizationStateUpdated(TdApi.AuthorizationState authorizationState)
    {
        if(authorizationState != null)
        {
            Telegram.authorizationState = authorizationState;
        }
        switch(Telegram.authorizationState.getConstructor())
        {
            case TdApi.AuthorizationStateWaitTdlibParameters.CONSTRUCTOR:
                TdApi.TdlibParameters parameters = new TdApi.TdlibParameters();
                parameters.databaseDirectory = "tdlib";
                parameters.useMessageDatabase = true;
                parameters.useChatInfoDatabase = true;
                parameters.useSecretChats = false;
                parameters.apiId = this.apiId;
                parameters.apiHash = this.apiHash;
                parameters.systemLanguageCode = "en";
                parameters.deviceModel = "Desktop";
                parameters.applicationVersion = "1.0";
                parameters.enableStorageOptimizer = true;

                client.send(new TdApi.SetTdlibParameters(parameters),
                        new AuthorizationRequestHandler());
                break;
            case TdApi.AuthorizationStateWaitEncryptionKey.CONSTRUCTOR:
                client.send(new TdApi.CheckDatabaseEncryptionKey(),
                        new AuthorizationRequestHandler());
                break;
            case TdApi.AuthorizationStateWaitPhoneNumber.CONSTRUCTOR:
            {
                String phoneNumber = promptString("Please enter phone number: ");
                client.send(new TdApi.SetAuthenticationPhoneNumber(phoneNumber, null),
                        new AuthorizationRequestHandler());
                break;
            }
            case TdApi.AuthorizationStateWaitOtherDeviceConfirmation.CONSTRUCTOR:
            {
                String link = ((TdApi.AuthorizationStateWaitOtherDeviceConfirmation)Telegram.authorizationState).link;
                System.out.println("Please confirm this login link on another device: " + link);
                break;
            }
            case TdApi.AuthorizationStateWaitCode.CONSTRUCTOR:
            {
                String code = promptString("Please enter authentication code: ");
                client.send(new TdApi.CheckAuthenticationCode(code),
                        new AuthorizationRequestHandler());
                break;
            }
            case TdApi.AuthorizationStateWaitRegistration.CONSTRUCTOR:
            {
                String firstName = promptString("Please enter your first name: ");
                String lastName = promptString("Please enter your last name: ");
                client.send(new TdApi.RegisterUser(firstName, lastName),
                        new AuthorizationRequestHandler());
                break;
            }
            case TdApi.AuthorizationStateWaitPassword.CONSTRUCTOR:
            {
                String password = promptString("Please enter password: ");
                client.send(new TdApi.CheckAuthenticationPassword(password),
                        new AuthorizationRequestHandler());
                break;
            }
            case TdApi.AuthorizationStateReady.CONSTRUCTOR:
                haveAuthorization = true;
                authorizationLock.lock();
                try
                {
                    gotAuthorization.signal();
                }
                finally
                {
                    authorizationLock.unlock();
                }
                break;
            case TdApi.AuthorizationStateLoggingOut.CONSTRUCTOR:
                haveAuthorization = false;
                print("Logging out");
                break;
            case TdApi.AuthorizationStateClosing.CONSTRUCTOR:
                haveAuthorization = false;
                break;
            case TdApi.AuthorizationStateClosed.CONSTRUCTOR:
                if(!needQuit)
                {
                    // Recreate the client after previous has closed:
                    client = Client.create(new UpdateHandler(), null, null);
                }
                else
                {
                    try
                    {
                        client.close();
                    }
                    catch(Exception e)
                    {
                        logger.error("Failed to clean TDLib Client resources!");
                        throw new RuntimeException(e);
                    }
                }
                break;
            default:
                System.err.println(
                        "Unsupported authorization state:" + newLine + Telegram.authorizationState);
        }
    }

    private static long getChatId(String arg)
    {
        long chatId = 0;
        try
        {
            chatId = Long.parseLong(arg);
        }
        catch(NumberFormatException ignored)
        {
        }
        return chatId;
    }

    private static String promptString(String prompt)
    {
        System.out.print(prompt);
        currentPrompt = prompt;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try
        {
            str = reader.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        currentPrompt = null;
        return str;
    }

    private static class OrderedChat implements Comparable<OrderedChat>
    {
        final long chatId;
        final TdApi.ChatPosition position;

        OrderedChat(long chatId, TdApi.ChatPosition position)
        {
            this.chatId = chatId;
            this.position = position;
        }

        @Override
        public int compareTo(OrderedChat o)
        {
            if(this.position.order != o.position.order)
            {
                return o.position.order < this.position.order ? -1 : 1;
            }
            if(this.chatId != o.chatId)
            {
                return o.chatId < this.chatId ? -1 : 1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj)
        {
            if(!(obj instanceof OrderedChat))
            {
                return false;
            }
            OrderedChat o = (OrderedChat)obj;
            return this.chatId == o.chatId && this.position.order == o.position.order;
        }
    }

    private class DefaultHandler implements Client.ResultHandler
    {
        @Override
        public void onResult(TdApi.Object object)
        {
            logger.debug("Default handler: {}", object);
        }
    }

    private class UpdateHandler implements Client.ResultHandler
    {
        @Override
        public void onResult(TdApi.Object object)
        {
            switch(object.getConstructor())
            {
                case TdApi.UpdateAuthorizationState.CONSTRUCTOR:
                    onAuthorizationStateUpdated(
                            ((TdApi.UpdateAuthorizationState)object).authorizationState);
                    break;

                case TdApi.UpdateUser.CONSTRUCTOR:
                    TdApi.UpdateUser updateUser = (TdApi.UpdateUser)object;
                    users.put(updateUser.user.id, updateUser.user);
                    break;
                case TdApi.UpdateUserStatus.CONSTRUCTOR:
                {
                    TdApi.UpdateUserStatus updateUserStatus = (TdApi.UpdateUserStatus)object;
                    TdApi.User user = users.get(updateUserStatus.userId);
                    synchronized(user)
                    {
                        user.status = updateUserStatus.status;
                    }
                    break;
                }
                case TdApi.UpdateBasicGroup.CONSTRUCTOR:
                    TdApi.UpdateBasicGroup updateBasicGroup = (TdApi.UpdateBasicGroup)object;
                    basicGroups.put(updateBasicGroup.basicGroup.id, updateBasicGroup.basicGroup);
                    break;
                case TdApi.UpdateSupergroup.CONSTRUCTOR:
                    TdApi.UpdateSupergroup updateSupergroup = (TdApi.UpdateSupergroup)object;
                    supergroups.put(updateSupergroup.supergroup.id, updateSupergroup.supergroup);
                    break;
                case TdApi.UpdateSecretChat.CONSTRUCTOR:
                    TdApi.UpdateSecretChat updateSecretChat = (TdApi.UpdateSecretChat)object;
                    secretChats.put(updateSecretChat.secretChat.id, updateSecretChat.secretChat);
                    break;

                case TdApi.UpdateNewChat.CONSTRUCTOR:
                {
                    TdApi.UpdateNewChat updateNewChat = (TdApi.UpdateNewChat)object;
                    TdApi.Chat chat = updateNewChat.chat;
                    synchronized(chat)
                    {
                        chats.put(chat.id, chat);

                        TdApi.ChatPosition[] positions = chat.positions;
                        chat.positions = new TdApi.ChatPosition[0];
                        setChatPositions(chat, positions);
                    }
                    break;
                }
                case TdApi.UpdateChatTitle.CONSTRUCTOR:
                {
                    TdApi.UpdateChatTitle updateChat = (TdApi.UpdateChatTitle)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.title = updateChat.title;
                    }
                    break;
                }
                case TdApi.UpdateChatPhoto.CONSTRUCTOR:
                {
                    TdApi.UpdateChatPhoto updateChat = (TdApi.UpdateChatPhoto)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.photo = updateChat.photo;
                    }
                    break;
                }
                case TdApi.UpdateChatLastMessage.CONSTRUCTOR:
                {
                    TdApi.UpdateChatLastMessage updateChat = (TdApi.UpdateChatLastMessage)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.lastMessage = updateChat.lastMessage;
                        setChatPositions(chat, updateChat.positions);
                    }
                    break;
                }
                case TdApi.UpdateChatPosition.CONSTRUCTOR:
                {
                    TdApi.UpdateChatPosition updateChat = (TdApi.UpdateChatPosition)object;
                    if(updateChat.position.list.getConstructor() != TdApi.ChatListMain.CONSTRUCTOR)
                    {
                        break;
                    }

                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        int i;
                        for(i = 0; i < chat.positions.length; i++)
                        {
                            if(chat.positions[i].list.getConstructor() ==
                               TdApi.ChatListMain.CONSTRUCTOR)
                            {
                                break;
                            }
                        }
                        TdApi.ChatPosition[] new_positions = new TdApi.ChatPosition[
                                chat.positions.length + (updateChat.position.order == 0 ? 0 : 1) -
                                (i < chat.positions.length ? 1 : 0)];
                        int pos = 0;
                        if(updateChat.position.order != 0)
                        {
                            new_positions[pos++] = updateChat.position;
                        }
                        for(int j = 0; j < chat.positions.length; j++)
                        {
                            if(j != i)
                            {
                                new_positions[pos++] = chat.positions[j];
                            }
                        }
                        assert pos == new_positions.length;

                        setChatPositions(chat, new_positions);
                    }
                    break;
                }
                case TdApi.UpdateChatReadInbox.CONSTRUCTOR:
                {
                    TdApi.UpdateChatReadInbox updateChat = (TdApi.UpdateChatReadInbox)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.lastReadInboxMessageId = updateChat.lastReadInboxMessageId;
                        chat.unreadCount = updateChat.unreadCount;
                    }
                    break;
                }
                case TdApi.UpdateChatReadOutbox.CONSTRUCTOR:
                {
                    TdApi.UpdateChatReadOutbox updateChat = (TdApi.UpdateChatReadOutbox)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.lastReadOutboxMessageId = updateChat.lastReadOutboxMessageId;
                    }
                    break;
                }
                case TdApi.UpdateChatUnreadMentionCount.CONSTRUCTOR:
                {
                    TdApi.UpdateChatUnreadMentionCount updateChat = (TdApi.UpdateChatUnreadMentionCount)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.unreadMentionCount = updateChat.unreadMentionCount;
                    }
                    break;
                }
                case TdApi.UpdateMessageMentionRead.CONSTRUCTOR:
                {
                    TdApi.UpdateMessageMentionRead updateChat = (TdApi.UpdateMessageMentionRead)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.unreadMentionCount = updateChat.unreadMentionCount;
                    }
                    break;
                }
                case TdApi.UpdateChatReplyMarkup.CONSTRUCTOR:
                {
                    TdApi.UpdateChatReplyMarkup updateChat = (TdApi.UpdateChatReplyMarkup)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.replyMarkupMessageId = updateChat.replyMarkupMessageId;
                    }
                    break;
                }
                case TdApi.UpdateChatDraftMessage.CONSTRUCTOR:
                {
                    TdApi.UpdateChatDraftMessage updateChat = (TdApi.UpdateChatDraftMessage)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.draftMessage = updateChat.draftMessage;
                        setChatPositions(chat, updateChat.positions);
                    }
                    break;
                }
                case TdApi.UpdateChatPermissions.CONSTRUCTOR:
                {
                    TdApi.UpdateChatPermissions update = (TdApi.UpdateChatPermissions)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.permissions = update.permissions;
                    }
                    break;
                }
                case TdApi.UpdateChatNotificationSettings.CONSTRUCTOR:
                {
                    TdApi.UpdateChatNotificationSettings update = (TdApi.UpdateChatNotificationSettings)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.notificationSettings = update.notificationSettings;
                    }
                    break;
                }
                case TdApi.UpdateChatDefaultDisableNotification.CONSTRUCTOR:
                {
                    TdApi.UpdateChatDefaultDisableNotification update = (TdApi.UpdateChatDefaultDisableNotification)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.defaultDisableNotification = update.defaultDisableNotification;
                    }
                    break;
                }
                case TdApi.UpdateChatIsMarkedAsUnread.CONSTRUCTOR:
                {
                    TdApi.UpdateChatIsMarkedAsUnread update = (TdApi.UpdateChatIsMarkedAsUnread)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.isMarkedAsUnread = update.isMarkedAsUnread;
                    }
                    break;
                }
                case TdApi.UpdateChatIsBlocked.CONSTRUCTOR:
                {
                    TdApi.UpdateChatIsBlocked update = (TdApi.UpdateChatIsBlocked)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.isBlocked = update.isBlocked;
                    }
                    break;
                }
                case TdApi.UpdateChatHasScheduledMessages.CONSTRUCTOR:
                {
                    TdApi.UpdateChatHasScheduledMessages update = (TdApi.UpdateChatHasScheduledMessages)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.hasScheduledMessages = update.hasScheduledMessages;
                    }
                    break;
                }

                case TdApi.UpdateUserFullInfo.CONSTRUCTOR:
                    TdApi.UpdateUserFullInfo updateUserFullInfo = (TdApi.UpdateUserFullInfo)object;
                    usersFullInfo.put(updateUserFullInfo.userId, updateUserFullInfo.userFullInfo);
                    break;
                case TdApi.UpdateBasicGroupFullInfo.CONSTRUCTOR:
                    TdApi.UpdateBasicGroupFullInfo updateBasicGroupFullInfo = (TdApi.UpdateBasicGroupFullInfo)object;
                    basicGroupsFullInfo.put(updateBasicGroupFullInfo.basicGroupId,
                            updateBasicGroupFullInfo.basicGroupFullInfo);
                    break;
                case TdApi.UpdateSupergroupFullInfo.CONSTRUCTOR:
                    TdApi.UpdateSupergroupFullInfo updateSupergroupFullInfo = (TdApi.UpdateSupergroupFullInfo)object;
                    supergroupsFullInfo.put(updateSupergroupFullInfo.supergroupId,
                            updateSupergroupFullInfo.supergroupFullInfo);
                    break;
                default:
                    // print("Unsupported update:" + newLine + object);
            }
        }
    }

    private class AuthorizationRequestHandler implements Client.ResultHandler
    {
        @Override
        public void onResult(TdApi.Object object)
        {
            switch(object.getConstructor())
            {
                case TdApi.Error.CONSTRUCTOR:
                    System.err.println("Receive an error:" + newLine + object);
                    onAuthorizationStateUpdated(null); // repeat last action
                    break;
                case TdApi.Ok.CONSTRUCTOR:
                    // result is already received through UpdateAuthorizationState, nothing to do
                    break;
                default:
                    System.err.println("Receive wrong response from TDLib:" + newLine + object);
            }
        }
    }
}
