//
// Copyright Aliaksei Levin (levlam@telegram.org), Arseny Smirnov (arseny30@gmail.com) 2014-2022
//
// Distributed under the Boost Software License, Version 1.0. (See accompanying
// file LICENSE_1_0.txt or copy at http://www.boost.org/LICENSE_1_0.txt)
//
// Changed by Andrienko Eugene (evg.andrienko@gmail.com) 2022

package com.eugene_andrienko.telegram.impl;

import com.eugene_andrienko.telegram.api.TelegramOptions;
import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramUploadFileException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Example class for TDLib usage from Java.
 */
@SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
public class TelegramTDLibConnector implements AutoCloseable
{
    private final int apiId;
    private final String apiHash;
    private final boolean debug;
    private final String tdlibLog;
    private final String tdlibDir;

    private final Logger logger = LoggerFactory.getLogger(TelegramTDLibConnector.class);

    private static Client client = null;

    private static TdApi.AuthorizationState authorizationState = null;
    private static volatile boolean haveAuthorization = false;
    private static volatile boolean needQuit = false;

    private final Client.ResultHandler defaultHandler = new DefaultHandler();

    private static final Lock authorizationLock = new ReentrantLock();
    private static final Condition gotAuthorization = authorizationLock.newCondition();

    private static final ConcurrentMap<Long, TdApi.User> users = new ConcurrentHashMap<>();

    private static final ConcurrentMap<Long, TdApi.Chat> chats = new ConcurrentHashMap<>();
    private static final NavigableSet<OrderedChat> mainChatList = new TreeSet<>();
    private static boolean haveFullMainChatList = false;

    // key: local file ID
    // value: upload progress in percents
    private static final ConcurrentMap<Integer, Float> fileUploadProgress =
            new ConcurrentHashMap<>();
    // key: temporary message ID
    // value: server message ID
    private static final ConcurrentMap<Long, CompletableFuture<Long>> sentMessageIds =
            new ConcurrentHashMap<>();

    private static final String TDLIB_VERSION = "1.8.0";
    private static final String SAVED_MESSAGES_CHAT = "Saved Messages";

    public enum MessageSenderState
    {
        OK, FAIL, RETRY
    }

    public enum MessageType
    {
        TEXT, AUDIO, VIDEO
    }

    static
    {
        try
        {
            System.loadLibrary("tdjni");
        }
        catch(UnsatisfiedLinkError e)
        {
            loadTDLibFromJar();
        }
    }

    private static void loadTDLibFromJar()
    {
        String tmpDir = System.getProperty("java.io.tmpdir");
        File tempDirectory = new File(tmpDir, "telegram" + System.nanoTime());
        if(!tempDirectory.mkdir())
        {
            throw new IOError(
                    new IOException(
                            "Failed to create temporary directory " + tmpDir + " for tdjni!"));
        }
        tempDirectory.deleteOnExit();

        final String libraryName = "libtdjni.so";
        final String libraryJarPath = "/lib/" + libraryName;
        File tempLibrary = new File(tempDirectory, libraryName);
        try(InputStream is = TelegramTDLibConnector.class.getResourceAsStream(libraryJarPath))
        {
            if(is == null)
            {
                //noinspection ResultOfMethodCallIgnored
                tempLibrary.delete();
                throw new IOError(new FileNotFoundException("Library " + libraryJarPath +
                                                            " not found in JAR!"));
            }
            Files.copy(is, tempLibrary.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        catch(NullPointerException npe)
        {
            //noinspection ResultOfMethodCallIgnored
            tempLibrary.delete();
            throw new IOError(new FileNotFoundException("Library " + libraryJarPath +
                                                        " not found in JAR!"));
        }
        catch(IOException ex)
        {
            //noinspection ResultOfMethodCallIgnored
            tempLibrary.delete();
            throw new IOError(ex);
        }

        try
        {
            System.load(tempLibrary.getAbsolutePath());
        }
        finally
        {
            tempLibrary.deleteOnExit();
        }
    }

    public TelegramTDLibConnector(TelegramOptions options) throws TelegramInitException
    {
        if(options.getApiId() == 0 || options.getApiHash().isBlank())
        {
            logger.error("Telegram API ID or hash not provided!");
            throw new TelegramInitException("Telegram API ID or hash not provided");
        }

        this.apiId = options.getApiId();
        this.apiHash = options.getApiHash();
        this.tdlibLog = options.getTdlibLog();
        this.tdlibDir = options.getTdlibDir();
        this.debug = options.isDebug();
    }

    public CompletableFuture<Boolean> init() throws TelegramInitException
    {
        // Setup TDLib logging:
        if(debug)
        {
            Client.execute(new TdApi.SetLogVerbosityLevel(4));
            TdApi.LogStreamFile logStreamFile = new TdApi.LogStreamFile(
                    tdlibLog, 5 * 1024 * 1024 /* 5 Mb */, false);
            if(Client.execute(new TdApi.SetLogStream(logStreamFile)) instanceof TdApi.Error)
            {
                logger.error("Cannot SetLogStream(LogStreamFile(\"{}\"))", tdlibLog);
                throw new TelegramInitException("Failed to start TDLib debug log");
            }
        }
        else
        {
            Client.execute(new TdApi.SetLogVerbosityLevel(0));
            if(Client.execute(
                    new TdApi.SetLogStream(new TdApi.LogStreamEmpty())) instanceof TdApi.Error)
            {
                logger.error("Cannot SetLogStream(LogStreamEmpty)");
                throw new TelegramInitException("Failed to setup TDLib logging");
            }
        }

        // Authorization:
        client = Client.create(new UpdateHandler(), null, null);
        logger.debug("Created client");

        CompletableFuture<Boolean> versionCheck = new CompletableFuture<>();
        client.send(new TdApi.GetOption("version"), answer -> {
            if(answer instanceof TdApi.OptionValueString)
            {
                String version = ((TdApi.OptionValueString)answer).value;
                if(!TDLIB_VERSION.equals(version))
                {
                    logger.error("Wrong TDLib version! Got: {}, need: {}", version, TDLIB_VERSION);
                    versionCheck.complete(false);
                }
                else
                {
                    logger.debug("Got TDLib version: {}", version);
                }
                versionCheck.complete(true);
            }
            else
            {
                logger.error("Wrong type of answer to version request: {}",
                        answer.getClass().getCanonicalName());
                versionCheck.complete(false);
            }
        });

        try
        {
            if(!versionCheck.get())
            {
                throw new TelegramInitException("Wrong TDLib version");
            }
        }
        catch(InterruptedException | ExecutionException e)
        {
            throw new TelegramInitException(e);
        }

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
        client.send(new TdApi.Close(), object -> {
            if(object.getConstructor() == TdApi.Ok.CONSTRUCTOR)
            {
                logger.info("Logout completed");
            }
            else if(object.getConstructor() == TdApi.Error.CONSTRUCTOR)
            {
                TdApi.Error error = (TdApi.Error)object;
                logger.error("Logout error. Code: {}, message: {}", error.code, error.message);
            }
            else
            {
                logger.error("Got unknown message ({} code) when logout", object.getConstructor());
            }
        });
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

    public CompletableFuture<Integer> uploadFile(File file, MessageType messageType)
    {
        CompletableFuture<Integer> result = new CompletableFuture<>();
        TdApi.FileType fileType;

        switch(messageType)
        {
            case AUDIO:
                fileType = new TdApi.FileTypeAudio();
                break;
            case VIDEO:
                fileType = new TdApi.FileTypeVideo();
                break;
            default:
                logger.error("Got unknown message type: {}", messageType);
                result.completeExceptionally(new TelegramUploadFileException(
                        "Unknown message type"));
                return result;
        }

        client.send(
                new TdApi.UploadFile(new TdApi.InputFileLocal(file.getAbsolutePath()), fileType, 1),
                object -> {
                    int constructor = object.getConstructor();
                    switch(constructor)
                    {
                        case TdApi.File.CONSTRUCTOR:
                            TdApi.File uploadingFile = (TdApi.File)object;
                            fileUploadProgress.put(uploadingFile.id, 0.0f);
                            logger.debug("File {} uploading with id = {}", file.getAbsolutePath(),
                                    uploadingFile.id);
                            result.complete(uploadingFile.id);
                            break;
                        case TdApi.Error.CONSTRUCTOR:
                            TdApi.Error error = (TdApi.Error)object;
                            logger.error("Failed to upload {}. Exists: {}, can read: {}",
                                    file.getAbsolutePath(), file.exists(), file.canRead());
                            logger.error("Error code: {}. Message: {}", error.code, error.message);
                            result.completeExceptionally(new TelegramUploadFileException(
                                    "Got error"));
                            break;
                        default:
                            logger.error("Got unknown answer when uploading file: {}", constructor);
                            result.completeExceptionally(new TelegramUploadFileException(
                                    "Unknown answer type"));
                            break;
                    }
                });

        return result;
    }

    public float getUploadFileProgress(int localFileId) throws TelegramUploadFileException
    {
        Float progress = fileUploadProgress.get(localFileId);
        if(progress == null)
        {
            logger.error("No data in upload progress table for file with local ID = {}",
                    localFileId);
            throw new TelegramUploadFileException("No progress info about given file");
        }
        else
        {
            return progress;
        }
    }

    public CompletableFuture<Pair<MessageSenderState, Long>> sendMessage(
            long chatId, MessageType messageType, Object message, long replyToId,
            Pair<String, Integer> additionalData)
    {
        CompletableFuture<Pair<MessageSenderState, Long>> result = new CompletableFuture<>();

        TdApi.InputMessageContent content;
        switch(messageType)
        {
            case TEXT:
                if(!(message instanceof String))
                {
                    logger.error("Got message type: {} but type of message is {}", messageType,
                            message.getClass().getCanonicalName());
                    result.complete(Pair.with(MessageSenderState.FAIL, 0L));
                    return result;
                }
                String text = (String)message;
                if(text.isEmpty())
                {
                    logger.error("Got empty text to send as message!");
                    result.complete(Pair.with(MessageSenderState.FAIL, 0L));
                    return result;
                }
                content = new TdApi.InputMessageText(new TdApi.FormattedText(text, null), true,
                        true);
                break;
            case AUDIO:
                if(!(message instanceof Integer))
                {
                    logger.error("Got message type: {} but type of message is not an Integer: {}",
                            messageType, message.getClass().getCanonicalName());
                    result.complete(Pair.with(MessageSenderState.FAIL, 0L));
                    return result;
                }
                Integer audioFileId = (Integer)message;
                TdApi.FormattedText audioCaption =
                        additionalData.getValue0() != null ?
                        new TdApi.FormattedText(additionalData.getValue0(), null) :
                        null;
                int audioDuration = additionalData.getValue1();
                // TODO: send album cover thumbnail
                content = new TdApi.InputMessageAudio(new TdApi.InputFileId(audioFileId), null,
                        audioDuration, null, null, audioCaption);
                break;
            case VIDEO:
                if(!(message instanceof Integer))
                {
                    logger.error("Got message type: {} but type of message is not an Integer: {}",
                            messageType, message.getClass().getCanonicalName());
                    result.complete(Pair.with(MessageSenderState.FAIL, 0L));
                    return result;
                }
                Integer videoFileId = (Integer)message;
                TdApi.FormattedText videoCaption =
                        additionalData.getValue0() != null ?
                        new TdApi.FormattedText(additionalData.getValue0(), null) :
                        null;
                int videoDuration = additionalData.getValue1();
                content = new TdApi.InputMessageVideo(new TdApi.InputFileId(videoFileId), null,
                        new int[]{}, videoDuration, 0, 0, true, videoCaption, 0);
                break;
            default:
                logger.error("Got unknown message type: {}", messageType);
                result.complete(Pair.with(MessageSenderState.FAIL, 0L));
                return result;
        }

        Client.ResultHandler messageHandler = answer -> {
            if(!(answer instanceof TdApi.Message))
            {
                logger.error("Got unknown answer in message handler: {}", answer);
                logger.error("Constructor: {}", answer.getConstructor());
                result.complete(Pair.with(MessageSenderState.FAIL, 0L));
                return;
            }

            TdApi.Message sendingMessage = (TdApi.Message)answer;
            TdApi.MessageSendingState state = sendingMessage.sendingState;
            switch(state.getConstructor())
            {
                case TdApi.MessageSendingStatePending.CONSTRUCTOR:
                    logger.debug("Message sent pending");
                    sentMessageIds.put(sendingMessage.id, new CompletableFuture<>());
                    result.complete(Pair.with(MessageSenderState.OK, sendingMessage.id));
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
                                return Pair.with(MessageSenderState.FAIL, sendingMessage.id);
                            }
                            return Pair.with(MessageSenderState.RETRY, sendingMessage.id);
                        });
                    }
                    else
                    {
                        logger.error("Failed to send message! Error code: {}. Error message: {}.",
                                fail.errorCode, fail.errorMessage);
                        result.complete(Pair.with(MessageSenderState.FAIL, sendingMessage.id));
                    }
                    break;
                default:
                    logger.error("Got unknown message state when sending message: {}", state);
                    logger.error("Constructor: {}", state.getConstructor());
                    result.completeExceptionally(new TelegramSendMessageException());
            }
        };

        client.send(new TdApi.SendMessage(chatId, 0, replyToId, null, null, content),
                messageHandler);
        return result;
    }

    public CompletableFuture<Long> getServerMessageId(long localMessageId)
    {
        CompletableFuture<Long> result = sentMessageIds.get(localMessageId);
        if(result == null)
        {
            result = new CompletableFuture<>();
        }
        return result;
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
            TelegramTDLibConnector.authorizationState = authorizationState;
        }
        switch(TelegramTDLibConnector.authorizationState.getConstructor())
        {
            case TdApi.AuthorizationStateWaitTdlibParameters.CONSTRUCTOR:
                TdApi.TdlibParameters parameters = new TdApi.TdlibParameters();
                parameters.databaseDirectory = tdlibDir;
                parameters.useMessageDatabase = false;
                parameters.useFileDatabase = false;
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
                String link = ((TdApi.AuthorizationStateWaitOtherDeviceConfirmation)TelegramTDLibConnector.authorizationState).link;
                System.out.println("\nPlease confirm this login link on another device: " + link);
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
                logger.info("Logging out from Telegram");
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
                logger.warn("Unsupported authorization state: {}",
                        TelegramTDLibConnector.authorizationState);
        }
    }

    private static String promptString(String prompt)
    {
        System.out.print(prompt);
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
            logger.debug("Default handler got: {}", object.getConstructor());
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

                case TdApi.UpdateFile.CONSTRUCTOR:
                {
                    TdApi.UpdateFile update = (TdApi.UpdateFile)object;
                    Float progress = update.file.remote.uploadedSize /
                                     (float)update.file.expectedSize * 100;
                    fileUploadProgress.put(update.file.id, progress);
                    break;
                }
                case TdApi.UpdateMessageSendSucceeded.CONSTRUCTOR:
                    TdApi.UpdateMessageSendSucceeded succeeded =
                            (TdApi.UpdateMessageSendSucceeded)object;
                    logger.debug("Message with local ID {} and server ID {} successfully sent",
                            succeeded.oldMessageId, succeeded.message.id);
                    CompletableFuture<Long> compl = sentMessageIds.get(succeeded.oldMessageId);
                    compl.complete(succeeded.message.id);
                    break;
                case TdApi.UpdateMessageSendFailed.CONSTRUCTOR:
                    TdApi.UpdateMessageSendFailed failed = (TdApi.UpdateMessageSendFailed)object;
                    logger.error("Failed to send message, local ID: {}, message: {}," +
                                 "error code = {}, error message = {}",
                            failed.oldMessageId, failed.message.content.toString(),
                            failed.errorCode, failed.errorMessage);
                    break;

                default:
                    //logger.debug("Unsupported update: {}", object);
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
                    logger.warn("Receive an error: {}", object);
                    onAuthorizationStateUpdated(null); // repeat last action
                    break;
                case TdApi.Ok.CONSTRUCTOR:
                    // result already received through UpdateAuthorizationState, nothing to do
                    break;
                default:
                    logger.warn("Receive wrong response from TDLib: {}", object);
            }
        }
    }
}
