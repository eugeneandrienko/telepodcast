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
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;


/**
 * Example class for TDLib usage from Java.
 */
@SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
@Slf4j
public class TelegramTDLibConnector implements AutoCloseable
{
    private final int apiId;
    private final String apiHash;
    private final boolean debug;
    private final String tdlibLog;
    private final String tdlibDir;

    private static Client client = null;

    private static TdApi.AuthorizationState authorizationState = null;
    private static volatile boolean haveAuthorization = false;
    private static volatile boolean needQuit = false;

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
        try
        {
            @Cleanup
            InputStream is = TelegramTDLibConnector.class.getResourceAsStream(libraryJarPath);
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
            log.error("Telegram API ID or hash not provided!");
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
                log.error("Cannot SetLogStream(LogStreamFile(\"{}\"))", tdlibLog);
                throw new TelegramInitException("Failed to start TDLib debug log");
            }
        }
        else
        {
            Client.execute(new TdApi.SetLogVerbosityLevel(0));
            if(Client.execute(
                    new TdApi.SetLogStream(new TdApi.LogStreamEmpty())) instanceof TdApi.Error)
            {
                log.error("Cannot SetLogStream(LogStreamEmpty)");
                throw new TelegramInitException("Failed to setup TDLib logging");
            }
        }

        // Authorization:
        client = Client.create(new UpdateHandler(), null, null);
        log.debug("Created client");

        CompletableFuture<Boolean> versionCheck = new CompletableFuture<>();
        client.send(new TdApi.GetOption("version"), answer -> {
            if(answer instanceof TdApi.OptionValueString)
            {
                String version = ((TdApi.OptionValueString)answer).value;
                if(!TDLIB_VERSION.equals(version))
                {
                    log.error("Wrong TDLib version! Got: {}, need: {}", version, TDLIB_VERSION);
                    versionCheck.complete(false);
                }
                else
                {
                    log.debug("Got TDLib version: {}", version);
                }
                versionCheck.complete(true);
            }
            else
            {
                log.error("Wrong type of answer to version request: {}",
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
            log.debug("Waiting for authorization...");
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
            log.debug("Got authorization!");
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
                log.info("Logout completed");
            }
            else if(object.getConstructor() == TdApi.Error.CONSTRUCTOR)
            {
                TdApi.Error error = (TdApi.Error)object;
                log.error("Logout error. Code: {}, message: {}", error.code, error.message);
            }
            else
            {
                log.error("Got unknown message ({} code) when logout", object.getConstructor());
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
                log.debug("Send TdApi.LoadChats message");
                client.send(
                        new TdApi.LoadChats(new TdApi.ChatListMain(), limit - mainChatList.size()),
                        object -> {
                            switch(object.getConstructor())
                            {
                                case TdApi.Error.CONSTRUCTOR ->
                                {
                                    log.debug("TdApi.LoadChats error");
                                    if(((TdApi.Error)object).code == 404)
                                    {
                                        synchronized(mainChatList)
                                        {
                                            log.debug("Have full main chat list");
                                            haveFullMainChatList = true;
                                        }
                                    }
                                    else
                                    {
                                        log.error("Receive an error for LoadChats: {}", object);
                                    }
                                }
                                case TdApi.Ok.CONSTRUCTOR ->
                                {
                                    log.debug("TdApi.LoadChats Ok");
                                    // Chats already received through updates,
                                    // let's retry request:
                                    loadChatList(limit);
                                }
                                default ->
                                        log.error("Receive wrong response from TDLib: {}", object);
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
                        log.debug("Found chat: id={}, name={}", chatId, chat.title);
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

        log.debug("Computing \"Saved messages\" chat name");
        client.send(new TdApi.GetMe(), object -> {
            switch(object.getConstructor())
            {
                case TdApi.Error.CONSTRUCTOR -> log.error("Failed to load user metadata");
                case TdApi.User.CONSTRUCTOR ->
                {
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
                    log.debug("Got chat name: \"{}\"", savedMessagesName);
                    result.complete(savedMessagesName);
                }
                default -> log.error("Receive wrong response from TDLib: {}", object);
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
            case AUDIO -> fileType = new TdApi.FileTypeAudio();
            case VIDEO -> fileType = new TdApi.FileTypeVideo();
            default ->
            {
                log.error("Got unknown message type: {}", messageType);
                result.completeExceptionally(new TelegramUploadFileException(
                        "Unknown message type"));
                return result;
            }
        }

        client.send(
                new TdApi.UploadFile(new TdApi.InputFileLocal(file.getAbsolutePath()), fileType, 1),
                object -> {
                    int constructor = object.getConstructor();
                    switch(constructor)
                    {
                        case TdApi.File.CONSTRUCTOR ->
                        {
                            TdApi.File uploadingFile = (TdApi.File)object;
                            fileUploadProgress.put(uploadingFile.id, 0.0f);
                            log.debug("File {} uploading with id = {}", file.getAbsolutePath(),
                                    uploadingFile.id);
                            result.complete(uploadingFile.id);
                        }
                        case TdApi.Error.CONSTRUCTOR ->
                        {
                            TdApi.Error error = (TdApi.Error)object;
                            log.error("Failed to upload {}. Exists: {}, can read: {}",
                                    file.getAbsolutePath(), file.exists(), file.canRead());
                            log.error("Error code: {}. Message: {}", error.code, error.message);
                            result.completeExceptionally(new TelegramUploadFileException(
                                    "Got error"));
                        }
                        default ->
                        {
                            log.error("Got unknown answer when uploading file: {}", constructor);
                            result.completeExceptionally(new TelegramUploadFileException(
                                    "Unknown answer type"));
                        }
                    }
                });

        return result;
    }

    public float getUploadFileProgress(int localFileId) throws TelegramUploadFileException
    {
        Float progress = fileUploadProgress.get(localFileId);
        if(progress == null)
        {
            log.error("No data in upload progress table for file with local ID = {}",
                    localFileId);
            throw new TelegramUploadFileException("No progress info about given file");
        }
        else
        {
            return progress;
        }
    }

    public CompletableFuture<ImmutablePair<MessageSenderState, Long>> sendMessage(
            long chatId, MessageType messageType, Object message, long replyToId,
            ImmutablePair<String, Integer> additionalData)
    {
        CompletableFuture<ImmutablePair<MessageSenderState, Long>> result =
                new CompletableFuture<>();

        TdApi.InputMessageContent content;
        switch(messageType)
        {
            case TEXT ->
            {
                if(!(message instanceof String text))
                {
                    log.error("Got message type: {} but type of message is {}", messageType,
                            message.getClass().getCanonicalName());
                    result.complete(ImmutablePair.of(MessageSenderState.FAIL, 0L));
                    return result;
                }
                if(text.isEmpty())
                {
                    log.error("Got empty text to send as message!");
                    result.complete(ImmutablePair.of(MessageSenderState.FAIL, 0L));
                    return result;
                }
                content = new TdApi.InputMessageText(new TdApi.FormattedText(text, null), true,
                        true);
            }
            case AUDIO ->
            {
                if(!(message instanceof Integer audioFileId))
                {
                    log.error("Got message type: {} but type of message is not an Integer: {}",
                            messageType, message.getClass().getCanonicalName());
                    result.complete(ImmutablePair.of(MessageSenderState.FAIL, 0L));
                    return result;
                }
                TdApi.FormattedText audioCaption =
                        additionalData.getLeft() != null ?
                        new TdApi.FormattedText(additionalData.getLeft(), null) :
                        null;
                int audioDuration = additionalData.getRight();
                // TODO: send album cover thumbnail
                content = new TdApi.InputMessageAudio(new TdApi.InputFileId(audioFileId), null,
                        audioDuration, null, null, audioCaption);
            }
            case VIDEO ->
            {
                if(!(message instanceof Integer videoFileId))
                {
                    log.error("Got message type: {} but type of message is not an Integer: {}",
                            messageType, message.getClass().getCanonicalName());
                    result.complete(ImmutablePair.of(MessageSenderState.FAIL, 0L));
                    return result;
                }
                TdApi.FormattedText videoCaption =
                        additionalData.getLeft() != null ?
                        new TdApi.FormattedText(additionalData.getLeft(), null) :
                        null;
                int videoDuration = additionalData.getRight();
                content = new TdApi.InputMessageVideo(new TdApi.InputFileId(videoFileId), null,
                        new int[]{}, videoDuration, 0, 0, true, videoCaption, 0);
            }
            default ->
            {
                log.error("Got unknown message type: {}", messageType);
                result.complete(ImmutablePair.of(MessageSenderState.FAIL, 0L));
                return result;
            }
        }

        Client.ResultHandler messageHandler = answer -> {
            if(!(answer instanceof TdApi.Message sendingMessage))
            {
                log.error("Got unknown answer in message handler: {}", answer);
                log.error("Constructor: {}", answer.getConstructor());
                result.complete(ImmutablePair.of(MessageSenderState.FAIL, 0L));
                return;
            }

            TdApi.MessageSendingState state = sendingMessage.sendingState;
            switch(state.getConstructor())
            {
                case TdApi.MessageSendingStatePending.CONSTRUCTOR ->
                {
                    log.debug("Message sent pending");
                    sentMessageIds.put(sendingMessage.id, new CompletableFuture<>());
                    result.complete(ImmutablePair.of(MessageSenderState.OK, sendingMessage.id));
                }
                case TdApi.MessageSendingStateFailed.CONSTRUCTOR ->
                {
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
                                log.error("Failed to wait {} seconds before resending message",
                                        fail.retryAfter);
                                return ImmutablePair.of(MessageSenderState.FAIL, sendingMessage.id);
                            }
                            return ImmutablePair.of(MessageSenderState.RETRY, sendingMessage.id);
                        });
                    }
                    else
                    {
                        log.error("Failed to send message! Error code: {}. Error message: {}.",
                                fail.errorCode, fail.errorMessage);
                        result.complete(ImmutablePair.of(
                                MessageSenderState.FAIL, sendingMessage.id));
                    }
                }
                default ->
                {
                    log.error("Got unknown message state when sending message: {}", state);
                    log.error("Constructor: {}", state.getConstructor());
                    result.completeExceptionally(new TelegramSendMessageException());
                }
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
                log.info("Logging out from Telegram");
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
                        log.error("Failed to clean TDLib Client resources!");
                        throw new RuntimeException(e);
                    }
                }
                break;
            default:
                log.warn("Unsupported authorization state: {}",
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
            if(!(obj instanceof OrderedChat o))
            {
                return false;
            }
            return this.chatId == o.chatId && this.position.order == o.position.order;
        }
    }

    private class UpdateHandler implements Client.ResultHandler
    {
        @Override
        public void onResult(TdApi.Object object)
        {
            switch(object.getConstructor())
            {
                case TdApi.UpdateAuthorizationState.CONSTRUCTOR -> onAuthorizationStateUpdated(
                        ((TdApi.UpdateAuthorizationState)object).authorizationState);
                case TdApi.UpdateUser.CONSTRUCTOR ->
                {
                    TdApi.UpdateUser updateUser = (TdApi.UpdateUser)object;
                    users.put(updateUser.user.id, updateUser.user);
                }
                case TdApi.UpdateUserStatus.CONSTRUCTOR ->
                {
                    TdApi.UpdateUserStatus updateUserStatus = (TdApi.UpdateUserStatus)object;
                    TdApi.User user = users.get(updateUserStatus.userId);
                    synchronized(user)
                    {
                        user.status = updateUserStatus.status;
                    }
                }
                case TdApi.UpdateNewChat.CONSTRUCTOR ->
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
                }
                case TdApi.UpdateChatTitle.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatTitle updateChat = (TdApi.UpdateChatTitle)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.title = updateChat.title;
                    }
                }
                case TdApi.UpdateChatPhoto.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatPhoto updateChat = (TdApi.UpdateChatPhoto)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.photo = updateChat.photo;
                    }
                }
                case TdApi.UpdateChatLastMessage.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatLastMessage updateChat = (TdApi.UpdateChatLastMessage)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.lastMessage = updateChat.lastMessage;
                        setChatPositions(chat, updateChat.positions);
                    }
                }
                case TdApi.UpdateChatPosition.CONSTRUCTOR ->
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
                }
                case TdApi.UpdateChatReadInbox.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatReadInbox updateChat = (TdApi.UpdateChatReadInbox)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.lastReadInboxMessageId = updateChat.lastReadInboxMessageId;
                        chat.unreadCount = updateChat.unreadCount;
                    }
                }
                case TdApi.UpdateChatReadOutbox.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatReadOutbox updateChat = (TdApi.UpdateChatReadOutbox)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.lastReadOutboxMessageId = updateChat.lastReadOutboxMessageId;
                    }
                }
                case TdApi.UpdateChatUnreadMentionCount.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatUnreadMentionCount updateChat = (TdApi.UpdateChatUnreadMentionCount)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.unreadMentionCount = updateChat.unreadMentionCount;
                    }
                }
                case TdApi.UpdateMessageMentionRead.CONSTRUCTOR ->
                {
                    TdApi.UpdateMessageMentionRead updateChat = (TdApi.UpdateMessageMentionRead)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.unreadMentionCount = updateChat.unreadMentionCount;
                    }
                }
                case TdApi.UpdateChatReplyMarkup.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatReplyMarkup updateChat = (TdApi.UpdateChatReplyMarkup)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.replyMarkupMessageId = updateChat.replyMarkupMessageId;
                    }
                }
                case TdApi.UpdateChatDraftMessage.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatDraftMessage updateChat = (TdApi.UpdateChatDraftMessage)object;
                    TdApi.Chat chat = chats.get(updateChat.chatId);
                    synchronized(chat)
                    {
                        chat.draftMessage = updateChat.draftMessage;
                        setChatPositions(chat, updateChat.positions);
                    }
                }
                case TdApi.UpdateChatPermissions.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatPermissions update = (TdApi.UpdateChatPermissions)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.permissions = update.permissions;
                    }
                }
                case TdApi.UpdateChatNotificationSettings.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatNotificationSettings update = (TdApi.UpdateChatNotificationSettings)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.notificationSettings = update.notificationSettings;
                    }
                }
                case TdApi.UpdateChatDefaultDisableNotification.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatDefaultDisableNotification update = (TdApi.UpdateChatDefaultDisableNotification)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.defaultDisableNotification = update.defaultDisableNotification;
                    }
                }
                case TdApi.UpdateChatIsMarkedAsUnread.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatIsMarkedAsUnread update = (TdApi.UpdateChatIsMarkedAsUnread)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.isMarkedAsUnread = update.isMarkedAsUnread;
                    }
                }
                case TdApi.UpdateChatIsBlocked.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatIsBlocked update = (TdApi.UpdateChatIsBlocked)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.isBlocked = update.isBlocked;
                    }
                }
                case TdApi.UpdateChatHasScheduledMessages.CONSTRUCTOR ->
                {
                    TdApi.UpdateChatHasScheduledMessages update = (TdApi.UpdateChatHasScheduledMessages)object;
                    TdApi.Chat chat = chats.get(update.chatId);
                    synchronized(chat)
                    {
                        chat.hasScheduledMessages = update.hasScheduledMessages;
                    }
                }
                case TdApi.UpdateFile.CONSTRUCTOR ->
                {
                    TdApi.UpdateFile update = (TdApi.UpdateFile)object;
                    Float progress = update.file.remote.uploadedSize /
                                     (float)update.file.expectedSize * 100;
                    fileUploadProgress.put(update.file.id, progress);
                }
                case TdApi.UpdateMessageSendSucceeded.CONSTRUCTOR ->
                {
                    TdApi.UpdateMessageSendSucceeded succeeded =
                            (TdApi.UpdateMessageSendSucceeded)object;
                    log.debug("Message with local ID {} and server ID {} successfully sent",
                            succeeded.oldMessageId, succeeded.message.id);
                    CompletableFuture<Long> compl = sentMessageIds.get(succeeded.oldMessageId);
                    compl.complete(succeeded.message.id);
                }
                case TdApi.UpdateMessageSendFailed.CONSTRUCTOR ->
                {
                    TdApi.UpdateMessageSendFailed failed = (TdApi.UpdateMessageSendFailed)object;
                    log.error("Failed to send message, local ID: {}, message: {}," +
                              "error code = {}, error message = {}",
                            failed.oldMessageId, failed.message.content.toString(),
                            failed.errorCode, failed.errorMessage);
                }
                default ->
                {
                    //logger.debug("Unsupported update: {}", object);
                }
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
                    log.warn("Receive an error: {}", object);
                    onAuthorizationStateUpdated(null); // repeat last action
                    break;
                case TdApi.Ok.CONSTRUCTOR:
                    // result already received through UpdateAuthorizationState, nothing to do
                    break;
                default:
                    log.warn("Receive wrong response from TDLib: {}", object);
            }
        }
    }
}
