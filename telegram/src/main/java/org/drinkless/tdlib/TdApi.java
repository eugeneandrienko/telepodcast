package org.drinkless.tdlib;

public class TdApi
{
    public abstract static class Object
    {
        public native String toString();

        public abstract int getConstructor();
    }

    public abstract static class Function extends Object
    {
        public native String toString();
    }

    public static class AccountTtl extends Object
    {
        public int days;

        public AccountTtl()
        {
        }

        public AccountTtl(int days)
        {
            this.days = days;
        }

        public static final int CONSTRUCTOR = 1324495492;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Address extends Object
    {
        public String countryCode;
        public String state;
        public String city;
        public String streetLine1;
        public String streetLine2;
        public String postalCode;

        public Address()
        {
        }

        public Address(String countryCode, String state, String city, String streetLine1,
                String streetLine2, String postalCode)
        {
            this.countryCode = countryCode;
            this.state = state;
            this.city = city;
            this.streetLine1 = streetLine1;
            this.streetLine2 = streetLine2;
            this.postalCode = postalCode;
        }

        public static final int CONSTRUCTOR = -2043654342;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AnimatedChatPhoto extends Object
    {
        public int length;
        public File file;
        public double mainFrameTimestamp;

        public AnimatedChatPhoto()
        {
        }

        public AnimatedChatPhoto(int length, File file, double mainFrameTimestamp)
        {
            this.length = length;
            this.file = file;
            this.mainFrameTimestamp = mainFrameTimestamp;
        }

        public static final int CONSTRUCTOR = 191994926;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AnimatedEmoji extends Object
    {
        public Sticker sticker;
        public int fitzpatrickType;
        public File sound;

        public AnimatedEmoji()
        {
        }

        public AnimatedEmoji(Sticker sticker, int fitzpatrickType, File sound)
        {
            this.sticker = sticker;
            this.fitzpatrickType = fitzpatrickType;
            this.sound = sound;
        }

        public static final int CONSTRUCTOR = -1816658231;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Animation extends Object
    {
        public int duration;
        public int width;
        public int height;
        public String fileName;
        public String mimeType;
        public boolean hasStickers;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File animation;

        public Animation()
        {
        }

        public Animation(int duration, int width, int height, String fileName, String mimeType,
                boolean hasStickers, Minithumbnail minithumbnail, Thumbnail thumbnail,
                File animation)
        {
            this.duration = duration;
            this.width = width;
            this.height = height;
            this.fileName = fileName;
            this.mimeType = mimeType;
            this.hasStickers = hasStickers;
            this.minithumbnail = minithumbnail;
            this.thumbnail = thumbnail;
            this.animation = animation;
        }

        public static final int CONSTRUCTOR = -872359106;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Animations extends Object
    {
        public Animation[] animations;

        public Animations()
        {
        }

        public Animations(Animation[] animations)
        {
            this.animations = animations;
        }

        public static final int CONSTRUCTOR = 344216945;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Audio extends Object
    {
        public int duration;
        public String title;
        public String performer;
        public String fileName;
        public String mimeType;
        public Minithumbnail albumCoverMinithumbnail;
        public Thumbnail albumCoverThumbnail;
        public File audio;

        public Audio()
        {
        }

        public Audio(int duration, String title, String performer, String fileName, String mimeType,
                Minithumbnail albumCoverMinithumbnail, Thumbnail albumCoverThumbnail, File audio)
        {
            this.duration = duration;
            this.title = title;
            this.performer = performer;
            this.fileName = fileName;
            this.mimeType = mimeType;
            this.albumCoverMinithumbnail = albumCoverMinithumbnail;
            this.albumCoverThumbnail = albumCoverThumbnail;
            this.audio = audio;
        }

        public static final int CONSTRUCTOR = -1179334690;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthenticationCodeInfo extends Object
    {
        public String phoneNumber;
        public AuthenticationCodeType type;
        public AuthenticationCodeType nextType;
        public int timeout;

        public AuthenticationCodeInfo()
        {
        }

        public AuthenticationCodeInfo(String phoneNumber, AuthenticationCodeType type,
                AuthenticationCodeType nextType, int timeout)
        {
            this.phoneNumber = phoneNumber;
            this.type = type;
            this.nextType = nextType;
            this.timeout = timeout;
        }

        public static final int CONSTRUCTOR = -860345416;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class AuthenticationCodeType extends Object
    {
    }

    public static class AuthenticationCodeTypeTelegramMessage extends AuthenticationCodeType
    {
        public int length;

        public AuthenticationCodeTypeTelegramMessage()
        {
        }

        public AuthenticationCodeTypeTelegramMessage(int length)
        {
            this.length = length;
        }

        public static final int CONSTRUCTOR = 2079628074;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthenticationCodeTypeSms extends AuthenticationCodeType
    {
        public int length;

        public AuthenticationCodeTypeSms()
        {
        }

        public AuthenticationCodeTypeSms(int length)
        {
            this.length = length;
        }

        public static final int CONSTRUCTOR = 962650760;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthenticationCodeTypeCall extends AuthenticationCodeType
    {
        public int length;

        public AuthenticationCodeTypeCall()
        {
        }

        public AuthenticationCodeTypeCall(int length)
        {
            this.length = length;
        }

        public static final int CONSTRUCTOR = 1636265063;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthenticationCodeTypeFlashCall extends AuthenticationCodeType
    {
        public String pattern;

        public AuthenticationCodeTypeFlashCall()
        {
        }

        public AuthenticationCodeTypeFlashCall(String pattern)
        {
            this.pattern = pattern;
        }

        public static final int CONSTRUCTOR = 1395882402;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthenticationCodeTypeMissedCall extends AuthenticationCodeType
    {
        public String phoneNumberPrefix;
        public int length;

        public AuthenticationCodeTypeMissedCall()
        {
        }

        public AuthenticationCodeTypeMissedCall(String phoneNumberPrefix, int length)
        {
            this.phoneNumberPrefix = phoneNumberPrefix;
            this.length = length;
        }

        public static final int CONSTRUCTOR = 700123783;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class AuthorizationState extends Object
    {
    }

    public static class AuthorizationStateWaitTdlibParameters extends AuthorizationState
    {

        public AuthorizationStateWaitTdlibParameters()
        {
        }

        public static final int CONSTRUCTOR = 904720988;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateWaitEncryptionKey extends AuthorizationState
    {
        public boolean isEncrypted;

        public AuthorizationStateWaitEncryptionKey()
        {
        }

        public AuthorizationStateWaitEncryptionKey(boolean isEncrypted)
        {
            this.isEncrypted = isEncrypted;
        }

        public static final int CONSTRUCTOR = 612103496;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateWaitPhoneNumber extends AuthorizationState
    {

        public AuthorizationStateWaitPhoneNumber()
        {
        }

        public static final int CONSTRUCTOR = 306402531;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateWaitCode extends AuthorizationState
    {
        public AuthenticationCodeInfo codeInfo;

        public AuthorizationStateWaitCode()
        {
        }

        public AuthorizationStateWaitCode(AuthenticationCodeInfo codeInfo)
        {
            this.codeInfo = codeInfo;
        }

        public static final int CONSTRUCTOR = 52643073;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateWaitOtherDeviceConfirmation extends AuthorizationState
    {
        public String link;

        public AuthorizationStateWaitOtherDeviceConfirmation()
        {
        }

        public AuthorizationStateWaitOtherDeviceConfirmation(String link)
        {
            this.link = link;
        }

        public static final int CONSTRUCTOR = 860166378;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateWaitRegistration extends AuthorizationState
    {
        public TermsOfService termsOfService;

        public AuthorizationStateWaitRegistration()
        {
        }

        public AuthorizationStateWaitRegistration(TermsOfService termsOfService)
        {
            this.termsOfService = termsOfService;
        }

        public static final int CONSTRUCTOR = 550350511;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateWaitPassword extends AuthorizationState
    {
        public String passwordHint;
        public boolean hasRecoveryEmailAddress;
        public String recoveryEmailAddressPattern;

        public AuthorizationStateWaitPassword()
        {
        }

        public AuthorizationStateWaitPassword(String passwordHint, boolean hasRecoveryEmailAddress,
                String recoveryEmailAddressPattern)
        {
            this.passwordHint = passwordHint;
            this.hasRecoveryEmailAddress = hasRecoveryEmailAddress;
            this.recoveryEmailAddressPattern = recoveryEmailAddressPattern;
        }

        public static final int CONSTRUCTOR = 187548796;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateReady extends AuthorizationState
    {

        public AuthorizationStateReady()
        {
        }

        public static final int CONSTRUCTOR = -1834871737;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateLoggingOut extends AuthorizationState
    {

        public AuthorizationStateLoggingOut()
        {
        }

        public static final int CONSTRUCTOR = 154449270;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateClosing extends AuthorizationState
    {

        public AuthorizationStateClosing()
        {
        }

        public static final int CONSTRUCTOR = 445855311;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AuthorizationStateClosed extends AuthorizationState
    {

        public AuthorizationStateClosed()
        {
        }

        public static final int CONSTRUCTOR = 1526047584;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AutoDownloadSettings extends Object
    {
        public boolean isAutoDownloadEnabled;
        public int maxPhotoFileSize;
        public int maxVideoFileSize;
        public int maxOtherFileSize;
        public int videoUploadBitrate;
        public boolean preloadLargeVideos;
        public boolean preloadNextAudio;
        public boolean useLessDataForCalls;

        public AutoDownloadSettings()
        {
        }

        public AutoDownloadSettings(boolean isAutoDownloadEnabled, int maxPhotoFileSize,
                int maxVideoFileSize, int maxOtherFileSize, int videoUploadBitrate,
                boolean preloadLargeVideos, boolean preloadNextAudio, boolean useLessDataForCalls)
        {
            this.isAutoDownloadEnabled = isAutoDownloadEnabled;
            this.maxPhotoFileSize = maxPhotoFileSize;
            this.maxVideoFileSize = maxVideoFileSize;
            this.maxOtherFileSize = maxOtherFileSize;
            this.videoUploadBitrate = videoUploadBitrate;
            this.preloadLargeVideos = preloadLargeVideos;
            this.preloadNextAudio = preloadNextAudio;
            this.useLessDataForCalls = useLessDataForCalls;
        }

        public static final int CONSTRUCTOR = -2144418333;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AutoDownloadSettingsPresets extends Object
    {
        public AutoDownloadSettings low;
        public AutoDownloadSettings medium;
        public AutoDownloadSettings high;

        public AutoDownloadSettingsPresets()
        {
        }

        public AutoDownloadSettingsPresets(AutoDownloadSettings low, AutoDownloadSettings medium,
                AutoDownloadSettings high)
        {
            this.low = low;
            this.medium = medium;
            this.high = high;
        }

        public static final int CONSTRUCTOR = -782099166;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Background extends Object
    {
        public long id;
        public boolean isDefault;
        public boolean isDark;
        public String name;
        public Document document;
        public BackgroundType type;

        public Background()
        {
        }

        public Background(long id, boolean isDefault, boolean isDark, String name,
                Document document, BackgroundType type)
        {
            this.id = id;
            this.isDefault = isDefault;
            this.isDark = isDark;
            this.name = name;
            this.document = document;
            this.type = type;
        }

        public static final int CONSTRUCTOR = -429971172;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class BackgroundFill extends Object
    {
    }

    public static class BackgroundFillSolid extends BackgroundFill
    {
        public int color;

        public BackgroundFillSolid()
        {
        }

        public BackgroundFillSolid(int color)
        {
            this.color = color;
        }

        public static final int CONSTRUCTOR = 1010678813;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BackgroundFillGradient extends BackgroundFill
    {
        public int topColor;
        public int bottomColor;
        public int rotationAngle;

        public BackgroundFillGradient()
        {
        }

        public BackgroundFillGradient(int topColor, int bottomColor, int rotationAngle)
        {
            this.topColor = topColor;
            this.bottomColor = bottomColor;
            this.rotationAngle = rotationAngle;
        }

        public static final int CONSTRUCTOR = -1839206017;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BackgroundFillFreeformGradient extends BackgroundFill
    {
        public int[] colors;

        public BackgroundFillFreeformGradient()
        {
        }

        public BackgroundFillFreeformGradient(int[] colors)
        {
            this.colors = colors;
        }

        public static final int CONSTRUCTOR = -1145469255;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class BackgroundType extends Object
    {
    }

    public static class BackgroundTypeWallpaper extends BackgroundType
    {
        public boolean isBlurred;
        public boolean isMoving;

        public BackgroundTypeWallpaper()
        {
        }

        public BackgroundTypeWallpaper(boolean isBlurred, boolean isMoving)
        {
            this.isBlurred = isBlurred;
            this.isMoving = isMoving;
        }

        public static final int CONSTRUCTOR = 1972128891;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BackgroundTypePattern extends BackgroundType
    {
        public BackgroundFill fill;
        public int intensity;
        public boolean isInverted;
        public boolean isMoving;

        public BackgroundTypePattern()
        {
        }

        public BackgroundTypePattern(BackgroundFill fill, int intensity, boolean isInverted,
                boolean isMoving)
        {
            this.fill = fill;
            this.intensity = intensity;
            this.isInverted = isInverted;
            this.isMoving = isMoving;
        }

        public static final int CONSTRUCTOR = 1290213117;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BackgroundTypeFill extends BackgroundType
    {
        public BackgroundFill fill;

        public BackgroundTypeFill()
        {
        }

        public BackgroundTypeFill(BackgroundFill fill)
        {
            this.fill = fill;
        }

        public static final int CONSTRUCTOR = 993008684;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Backgrounds extends Object
    {
        public Background[] backgrounds;

        public Backgrounds()
        {
        }

        public Backgrounds(Background[] backgrounds)
        {
            this.backgrounds = backgrounds;
        }

        public static final int CONSTRUCTOR = 724728704;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BankCardActionOpenUrl extends Object
    {
        public String text;
        public String url;

        public BankCardActionOpenUrl()
        {
        }

        public BankCardActionOpenUrl(String text, String url)
        {
            this.text = text;
            this.url = url;
        }

        public static final int CONSTRUCTOR = -196454267;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BankCardInfo extends Object
    {
        public String title;
        public BankCardActionOpenUrl[] actions;

        public BankCardInfo()
        {
        }

        public BankCardInfo(String title, BankCardActionOpenUrl[] actions)
        {
            this.title = title;
            this.actions = actions;
        }

        public static final int CONSTRUCTOR = -2116647730;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BasicGroup extends Object
    {
        public long id;
        public int memberCount;
        public ChatMemberStatus status;
        public boolean isActive;
        public long upgradedToSupergroupId;

        public BasicGroup()
        {
        }

        public BasicGroup(long id, int memberCount, ChatMemberStatus status, boolean isActive,
                long upgradedToSupergroupId)
        {
            this.id = id;
            this.memberCount = memberCount;
            this.status = status;
            this.isActive = isActive;
            this.upgradedToSupergroupId = upgradedToSupergroupId;
        }

        public static final int CONSTRUCTOR = -194767217;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BasicGroupFullInfo extends Object
    {
        public ChatPhoto photo;
        public String description;
        public long creatorUserId;
        public ChatMember[] members;
        public ChatInviteLink inviteLink;
        public BotCommands[] botCommands;

        public BasicGroupFullInfo()
        {
        }

        public BasicGroupFullInfo(ChatPhoto photo, String description, long creatorUserId,
                ChatMember[] members, ChatInviteLink inviteLink, BotCommands[] botCommands)
        {
            this.photo = photo;
            this.description = description;
            this.creatorUserId = creatorUserId;
            this.members = members;
            this.inviteLink = inviteLink;
            this.botCommands = botCommands;
        }

        public static final int CONSTRUCTOR = 2022233397;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BotCommand extends Object
    {
        public String command;
        public String description;

        public BotCommand()
        {
        }

        public BotCommand(String command, String description)
        {
            this.command = command;
            this.description = description;
        }

        public static final int CONSTRUCTOR = -1032140601;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class BotCommandScope extends Object
    {
    }

    public static class BotCommandScopeDefault extends BotCommandScope
    {

        public BotCommandScopeDefault()
        {
        }

        public static final int CONSTRUCTOR = 795652779;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BotCommandScopeAllPrivateChats extends BotCommandScope
    {

        public BotCommandScopeAllPrivateChats()
        {
        }

        public static final int CONSTRUCTOR = -344889543;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BotCommandScopeAllGroupChats extends BotCommandScope
    {

        public BotCommandScopeAllGroupChats()
        {
        }

        public static final int CONSTRUCTOR = -981088162;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BotCommandScopeAllChatAdministrators extends BotCommandScope
    {

        public BotCommandScopeAllChatAdministrators()
        {
        }

        public static final int CONSTRUCTOR = 1998329169;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BotCommandScopeChat extends BotCommandScope
    {
        public long chatId;

        public BotCommandScopeChat()
        {
        }

        public BotCommandScopeChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -430234971;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BotCommandScopeChatAdministrators extends BotCommandScope
    {
        public long chatId;

        public BotCommandScopeChatAdministrators()
        {
        }

        public BotCommandScopeChatAdministrators(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 1119682126;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BotCommandScopeChatMember extends BotCommandScope
    {
        public long chatId;
        public long userId;

        public BotCommandScopeChatMember()
        {
        }

        public BotCommandScopeChatMember(long chatId, long userId)
        {
            this.chatId = chatId;
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = -211380494;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BotCommands extends Object
    {
        public long botUserId;
        public BotCommand[] commands;

        public BotCommands()
        {
        }

        public BotCommands(long botUserId, BotCommand[] commands)
        {
            this.botUserId = botUserId;
            this.commands = commands;
        }

        public static final int CONSTRUCTOR = 1741364468;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Call extends Object
    {
        public int id;
        public long userId;
        public boolean isOutgoing;
        public boolean isVideo;
        public CallState state;

        public Call()
        {
        }

        public Call(int id, long userId, boolean isOutgoing, boolean isVideo, CallState state)
        {
            this.id = id;
            this.userId = userId;
            this.isOutgoing = isOutgoing;
            this.isVideo = isVideo;
            this.state = state;
        }

        public static final int CONSTRUCTOR = 920360804;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class CallDiscardReason extends Object
    {
    }

    public static class CallDiscardReasonEmpty extends CallDiscardReason
    {

        public CallDiscardReasonEmpty()
        {
        }

        public static final int CONSTRUCTOR = -1258917949;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallDiscardReasonMissed extends CallDiscardReason
    {

        public CallDiscardReasonMissed()
        {
        }

        public static final int CONSTRUCTOR = 1680358012;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallDiscardReasonDeclined extends CallDiscardReason
    {

        public CallDiscardReasonDeclined()
        {
        }

        public static final int CONSTRUCTOR = -1729926094;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallDiscardReasonDisconnected extends CallDiscardReason
    {

        public CallDiscardReasonDisconnected()
        {
        }

        public static final int CONSTRUCTOR = -1342872670;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallDiscardReasonHungUp extends CallDiscardReason
    {

        public CallDiscardReasonHungUp()
        {
        }

        public static final int CONSTRUCTOR = 438216166;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallId extends Object
    {
        public int id;

        public CallId()
        {
        }

        public CallId(int id)
        {
            this.id = id;
        }

        public static final int CONSTRUCTOR = 65717769;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class CallProblem extends Object
    {
    }

    public static class CallProblemEcho extends CallProblem
    {

        public CallProblemEcho()
        {
        }

        public static final int CONSTRUCTOR = 801116548;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallProblemNoise extends CallProblem
    {

        public CallProblemNoise()
        {
        }

        public static final int CONSTRUCTOR = 1053065359;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallProblemInterruptions extends CallProblem
    {

        public CallProblemInterruptions()
        {
        }

        public static final int CONSTRUCTOR = 1119493218;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallProblemDistortedSpeech extends CallProblem
    {

        public CallProblemDistortedSpeech()
        {
        }

        public static final int CONSTRUCTOR = 379960581;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallProblemSilentLocal extends CallProblem
    {

        public CallProblemSilentLocal()
        {
        }

        public static final int CONSTRUCTOR = 253652790;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallProblemSilentRemote extends CallProblem
    {

        public CallProblemSilentRemote()
        {
        }

        public static final int CONSTRUCTOR = 573634714;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallProblemDropped extends CallProblem
    {

        public CallProblemDropped()
        {
        }

        public static final int CONSTRUCTOR = -1207311487;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallProblemDistortedVideo extends CallProblem
    {

        public CallProblemDistortedVideo()
        {
        }

        public static final int CONSTRUCTOR = 385245706;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallProblemPixelatedVideo extends CallProblem
    {

        public CallProblemPixelatedVideo()
        {
        }

        public static final int CONSTRUCTOR = 2115315411;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallProtocol extends Object
    {
        public boolean udpP2p;
        public boolean udpReflector;
        public int minLayer;
        public int maxLayer;
        public String[] libraryVersions;

        public CallProtocol()
        {
        }

        public CallProtocol(boolean udpP2p, boolean udpReflector, int minLayer, int maxLayer,
                String[] libraryVersions)
        {
            this.udpP2p = udpP2p;
            this.udpReflector = udpReflector;
            this.minLayer = minLayer;
            this.maxLayer = maxLayer;
            this.libraryVersions = libraryVersions;
        }

        public static final int CONSTRUCTOR = -1075562897;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallServer extends Object
    {
        public long id;
        public String ipAddress;
        public String ipv6Address;
        public int port;
        public CallServerType type;

        public CallServer()
        {
        }

        public CallServer(long id, String ipAddress, String ipv6Address, int port,
                CallServerType type)
        {
            this.id = id;
            this.ipAddress = ipAddress;
            this.ipv6Address = ipv6Address;
            this.port = port;
            this.type = type;
        }

        public static final int CONSTRUCTOR = 1865932695;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class CallServerType extends Object
    {
    }

    public static class CallServerTypeTelegramReflector extends CallServerType
    {
        public byte[] peerTag;

        public CallServerTypeTelegramReflector()
        {
        }

        public CallServerTypeTelegramReflector(byte[] peerTag)
        {
            this.peerTag = peerTag;
        }

        public static final int CONSTRUCTOR = -1507850700;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallServerTypeWebrtc extends CallServerType
    {
        public String username;
        public String password;
        public boolean supportsTurn;
        public boolean supportsStun;

        public CallServerTypeWebrtc()
        {
        }

        public CallServerTypeWebrtc(String username, String password, boolean supportsTurn,
                boolean supportsStun)
        {
            this.username = username;
            this.password = password;
            this.supportsTurn = supportsTurn;
            this.supportsStun = supportsStun;
        }

        public static final int CONSTRUCTOR = 1250622821;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class CallState extends Object
    {
    }

    public static class CallStatePending extends CallState
    {
        public boolean isCreated;
        public boolean isReceived;

        public CallStatePending()
        {
        }

        public CallStatePending(boolean isCreated, boolean isReceived)
        {
            this.isCreated = isCreated;
            this.isReceived = isReceived;
        }

        public static final int CONSTRUCTOR = 1073048620;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallStateExchangingKeys extends CallState
    {

        public CallStateExchangingKeys()
        {
        }

        public static final int CONSTRUCTOR = -1848149403;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallStateReady extends CallState
    {
        public CallProtocol protocol;
        public CallServer[] servers;
        public String config;
        public byte[] encryptionKey;
        public String[] emojis;
        public boolean allowP2p;

        public CallStateReady()
        {
        }

        public CallStateReady(CallProtocol protocol, CallServer[] servers, String config,
                byte[] encryptionKey, String[] emojis, boolean allowP2p)
        {
            this.protocol = protocol;
            this.servers = servers;
            this.config = config;
            this.encryptionKey = encryptionKey;
            this.emojis = emojis;
            this.allowP2p = allowP2p;
        }

        public static final int CONSTRUCTOR = -2000107571;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallStateHangingUp extends CallState
    {

        public CallStateHangingUp()
        {
        }

        public static final int CONSTRUCTOR = -2133790038;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallStateDiscarded extends CallState
    {
        public CallDiscardReason reason;
        public boolean needRating;
        public boolean needDebugInformation;

        public CallStateDiscarded()
        {
        }

        public CallStateDiscarded(CallDiscardReason reason, boolean needRating,
                boolean needDebugInformation)
        {
            this.reason = reason;
            this.needRating = needRating;
            this.needDebugInformation = needDebugInformation;
        }

        public static final int CONSTRUCTOR = -190853167;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallStateError extends CallState
    {
        public Error error;

        public CallStateError()
        {
        }

        public CallStateError(Error error)
        {
            this.error = error;
        }

        public static final int CONSTRUCTOR = -975215467;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallbackQueryAnswer extends Object
    {
        public String text;
        public boolean showAlert;
        public String url;

        public CallbackQueryAnswer()
        {
        }

        public CallbackQueryAnswer(String text, boolean showAlert, String url)
        {
            this.text = text;
            this.showAlert = showAlert;
            this.url = url;
        }

        public static final int CONSTRUCTOR = 360867933;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class CallbackQueryPayload extends Object
    {
    }

    public static class CallbackQueryPayloadData extends CallbackQueryPayload
    {
        public byte[] data;

        public CallbackQueryPayloadData()
        {
        }

        public CallbackQueryPayloadData(byte[] data)
        {
            this.data = data;
        }

        public static final int CONSTRUCTOR = -1977729946;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallbackQueryPayloadDataWithPassword extends CallbackQueryPayload
    {
        public String password;
        public byte[] data;

        public CallbackQueryPayloadDataWithPassword()
        {
        }

        public CallbackQueryPayloadDataWithPassword(String password, byte[] data)
        {
            this.password = password;
            this.data = data;
        }

        public static final int CONSTRUCTOR = 1340266738;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CallbackQueryPayloadGame extends CallbackQueryPayload
    {
        public String gameShortName;

        public CallbackQueryPayloadGame()
        {
        }

        public CallbackQueryPayloadGame(String gameShortName)
        {
            this.gameShortName = gameShortName;
        }

        public static final int CONSTRUCTOR = 1303571512;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class CanTransferOwnershipResult extends Object
    {
    }

    public static class CanTransferOwnershipResultOk extends CanTransferOwnershipResult
    {

        public CanTransferOwnershipResultOk()
        {
        }

        public static final int CONSTRUCTOR = -89881021;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CanTransferOwnershipResultPasswordNeeded extends CanTransferOwnershipResult
    {

        public CanTransferOwnershipResultPasswordNeeded()
        {
        }

        public static final int CONSTRUCTOR = 1548372703;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CanTransferOwnershipResultPasswordTooFresh
            extends CanTransferOwnershipResult
    {
        public int retryAfter;

        public CanTransferOwnershipResultPasswordTooFresh()
        {
        }

        public CanTransferOwnershipResultPasswordTooFresh(int retryAfter)
        {
            this.retryAfter = retryAfter;
        }

        public static final int CONSTRUCTOR = 811440913;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CanTransferOwnershipResultSessionTooFresh extends CanTransferOwnershipResult
    {
        public int retryAfter;

        public CanTransferOwnershipResultSessionTooFresh()
        {
        }

        public CanTransferOwnershipResultSessionTooFresh(int retryAfter)
        {
            this.retryAfter = retryAfter;
        }

        public static final int CONSTRUCTOR = 984664289;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Chat extends Object
    {
        public long id;
        public ChatType type;
        public String title;
        public ChatPhotoInfo photo;
        public ChatPermissions permissions;
        public Message lastMessage;
        public ChatPosition[] positions;
        public MessageSender messageSenderId;
        public boolean hasProtectedContent;
        public boolean isMarkedAsUnread;
        public boolean isBlocked;
        public boolean hasScheduledMessages;
        public boolean canBeDeletedOnlyForSelf;
        public boolean canBeDeletedForAllUsers;
        public boolean canBeReported;
        public boolean defaultDisableNotification;
        public int unreadCount;
        public long lastReadInboxMessageId;
        public long lastReadOutboxMessageId;
        public int unreadMentionCount;
        public ChatNotificationSettings notificationSettings;
        public int messageTtl;
        public String themeName;
        public ChatActionBar actionBar;
        public VideoChat videoChat;
        public ChatJoinRequestsInfo pendingJoinRequests;
        public long replyMarkupMessageId;
        public DraftMessage draftMessage;
        public String clientData;

        public Chat()
        {
        }

        public Chat(long id, ChatType type, String title, ChatPhotoInfo photo,
                ChatPermissions permissions, Message lastMessage, ChatPosition[] positions,
                MessageSender messageSenderId, boolean hasProtectedContent,
                boolean isMarkedAsUnread, boolean isBlocked, boolean hasScheduledMessages,
                boolean canBeDeletedOnlyForSelf, boolean canBeDeletedForAllUsers,
                boolean canBeReported, boolean defaultDisableNotification, int unreadCount,
                long lastReadInboxMessageId, long lastReadOutboxMessageId, int unreadMentionCount,
                ChatNotificationSettings notificationSettings, int messageTtl, String themeName,
                ChatActionBar actionBar, VideoChat videoChat,
                ChatJoinRequestsInfo pendingJoinRequests, long replyMarkupMessageId,
                DraftMessage draftMessage, String clientData)
        {
            this.id = id;
            this.type = type;
            this.title = title;
            this.photo = photo;
            this.permissions = permissions;
            this.lastMessage = lastMessage;
            this.positions = positions;
            this.messageSenderId = messageSenderId;
            this.hasProtectedContent = hasProtectedContent;
            this.isMarkedAsUnread = isMarkedAsUnread;
            this.isBlocked = isBlocked;
            this.hasScheduledMessages = hasScheduledMessages;
            this.canBeDeletedOnlyForSelf = canBeDeletedOnlyForSelf;
            this.canBeDeletedForAllUsers = canBeDeletedForAllUsers;
            this.canBeReported = canBeReported;
            this.defaultDisableNotification = defaultDisableNotification;
            this.unreadCount = unreadCount;
            this.lastReadInboxMessageId = lastReadInboxMessageId;
            this.lastReadOutboxMessageId = lastReadOutboxMessageId;
            this.unreadMentionCount = unreadMentionCount;
            this.notificationSettings = notificationSettings;
            this.messageTtl = messageTtl;
            this.themeName = themeName;
            this.actionBar = actionBar;
            this.videoChat = videoChat;
            this.pendingJoinRequests = pendingJoinRequests;
            this.replyMarkupMessageId = replyMarkupMessageId;
            this.draftMessage = draftMessage;
            this.clientData = clientData;
        }

        public static final int CONSTRUCTOR = 1617921149;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatAction extends Object
    {
    }

    public static class ChatActionTyping extends ChatAction
    {

        public ChatActionTyping()
        {
        }

        public static final int CONSTRUCTOR = 380122167;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionRecordingVideo extends ChatAction
    {

        public ChatActionRecordingVideo()
        {
        }

        public static final int CONSTRUCTOR = 216553362;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionUploadingVideo extends ChatAction
    {
        public int progress;

        public ChatActionUploadingVideo()
        {
        }

        public ChatActionUploadingVideo(int progress)
        {
            this.progress = progress;
        }

        public static final int CONSTRUCTOR = 1234185270;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionRecordingVoiceNote extends ChatAction
    {

        public ChatActionRecordingVoiceNote()
        {
        }

        public static final int CONSTRUCTOR = -808850058;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionUploadingVoiceNote extends ChatAction
    {
        public int progress;

        public ChatActionUploadingVoiceNote()
        {
        }

        public ChatActionUploadingVoiceNote(int progress)
        {
            this.progress = progress;
        }

        public static final int CONSTRUCTOR = -613643666;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionUploadingPhoto extends ChatAction
    {
        public int progress;

        public ChatActionUploadingPhoto()
        {
        }

        public ChatActionUploadingPhoto(int progress)
        {
            this.progress = progress;
        }

        public static final int CONSTRUCTOR = 654240583;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionUploadingDocument extends ChatAction
    {
        public int progress;

        public ChatActionUploadingDocument()
        {
        }

        public ChatActionUploadingDocument(int progress)
        {
            this.progress = progress;
        }

        public static final int CONSTRUCTOR = 167884362;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionChoosingSticker extends ChatAction
    {

        public ChatActionChoosingSticker()
        {
        }

        public static final int CONSTRUCTOR = 372753697;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionChoosingLocation extends ChatAction
    {

        public ChatActionChoosingLocation()
        {
        }

        public static final int CONSTRUCTOR = -2017893596;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionChoosingContact extends ChatAction
    {

        public ChatActionChoosingContact()
        {
        }

        public static final int CONSTRUCTOR = -1222507496;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionStartPlayingGame extends ChatAction
    {

        public ChatActionStartPlayingGame()
        {
        }

        public static final int CONSTRUCTOR = -865884164;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionRecordingVideoNote extends ChatAction
    {

        public ChatActionRecordingVideoNote()
        {
        }

        public static final int CONSTRUCTOR = 16523393;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionUploadingVideoNote extends ChatAction
    {
        public int progress;

        public ChatActionUploadingVideoNote()
        {
        }

        public ChatActionUploadingVideoNote(int progress)
        {
            this.progress = progress;
        }

        public static final int CONSTRUCTOR = 1172364918;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionWatchingAnimations extends ChatAction
    {
        public String emoji;

        public ChatActionWatchingAnimations()
        {
        }

        public ChatActionWatchingAnimations(String emoji)
        {
            this.emoji = emoji;
        }

        public static final int CONSTRUCTOR = 2052990641;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionCancel extends ChatAction
    {

        public ChatActionCancel()
        {
        }

        public static final int CONSTRUCTOR = 1160523958;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatActionBar extends Object
    {
    }

    public static class ChatActionBarReportSpam extends ChatActionBar
    {
        public boolean canUnarchive;

        public ChatActionBarReportSpam()
        {
        }

        public ChatActionBarReportSpam(boolean canUnarchive)
        {
            this.canUnarchive = canUnarchive;
        }

        public static final int CONSTRUCTOR = -1312758246;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionBarReportUnrelatedLocation extends ChatActionBar
    {

        public ChatActionBarReportUnrelatedLocation()
        {
        }

        public static final int CONSTRUCTOR = 758175489;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionBarInviteMembers extends ChatActionBar
    {

        public ChatActionBarInviteMembers()
        {
        }

        public static final int CONSTRUCTOR = 1985313904;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionBarReportAddBlock extends ChatActionBar
    {
        public boolean canUnarchive;
        public int distance;

        public ChatActionBarReportAddBlock()
        {
        }

        public ChatActionBarReportAddBlock(boolean canUnarchive, int distance)
        {
            this.canUnarchive = canUnarchive;
            this.distance = distance;
        }

        public static final int CONSTRUCTOR = -914150419;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionBarAddContact extends ChatActionBar
    {

        public ChatActionBarAddContact()
        {
        }

        public static final int CONSTRUCTOR = -733325295;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionBarSharePhoneNumber extends ChatActionBar
    {

        public ChatActionBarSharePhoneNumber()
        {
        }

        public static final int CONSTRUCTOR = 35188697;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatActionBarJoinRequest extends ChatActionBar
    {
        public String title;
        public boolean isChannel;
        public int requestDate;

        public ChatActionBarJoinRequest()
        {
        }

        public ChatActionBarJoinRequest(String title, boolean isChannel, int requestDate)
        {
            this.title = title;
            this.isChannel = isChannel;
            this.requestDate = requestDate;
        }

        public static final int CONSTRUCTOR = 1037140744;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatAdministrator extends Object
    {
        public long userId;
        public String customTitle;
        public boolean isOwner;

        public ChatAdministrator()
        {
        }

        public ChatAdministrator(long userId, String customTitle, boolean isOwner)
        {
            this.userId = userId;
            this.customTitle = customTitle;
            this.isOwner = isOwner;
        }

        public static final int CONSTRUCTOR = 1920449836;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatAdministrators extends Object
    {
        public ChatAdministrator[] administrators;

        public ChatAdministrators()
        {
        }

        public ChatAdministrators(ChatAdministrator[] administrators)
        {
            this.administrators = administrators;
        }

        public static final int CONSTRUCTOR = -2126186435;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEvent extends Object
    {
        public long id;
        public int date;
        public MessageSender memberId;
        public ChatEventAction action;

        public ChatEvent()
        {
        }

        public ChatEvent(long id, int date, MessageSender memberId, ChatEventAction action)
        {
            this.id = id;
            this.date = date;
            this.memberId = memberId;
            this.action = action;
        }

        public static final int CONSTRUCTOR = -652102704;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatEventAction extends Object
    {
    }

    public static class ChatEventMessageEdited extends ChatEventAction
    {
        public Message oldMessage;
        public Message newMessage;

        public ChatEventMessageEdited()
        {
        }

        public ChatEventMessageEdited(Message oldMessage, Message newMessage)
        {
            this.oldMessage = oldMessage;
            this.newMessage = newMessage;
        }

        public static final int CONSTRUCTOR = -430967304;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMessageDeleted extends ChatEventAction
    {
        public Message message;

        public ChatEventMessageDeleted()
        {
        }

        public ChatEventMessageDeleted(Message message)
        {
            this.message = message;
        }

        public static final int CONSTRUCTOR = -892974601;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventPollStopped extends ChatEventAction
    {
        public Message message;

        public ChatEventPollStopped()
        {
        }

        public ChatEventPollStopped(Message message)
        {
            this.message = message;
        }

        public static final int CONSTRUCTOR = 2009893861;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMessagePinned extends ChatEventAction
    {
        public Message message;

        public ChatEventMessagePinned()
        {
        }

        public ChatEventMessagePinned(Message message)
        {
            this.message = message;
        }

        public static final int CONSTRUCTOR = 438742298;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMessageUnpinned extends ChatEventAction
    {
        public Message message;

        public ChatEventMessageUnpinned()
        {
        }

        public ChatEventMessageUnpinned(Message message)
        {
            this.message = message;
        }

        public static final int CONSTRUCTOR = -376161513;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMemberJoined extends ChatEventAction
    {

        public ChatEventMemberJoined()
        {
        }

        public static final int CONSTRUCTOR = -235468508;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMemberJoinedByInviteLink extends ChatEventAction
    {
        public ChatInviteLink inviteLink;

        public ChatEventMemberJoinedByInviteLink()
        {
        }

        public ChatEventMemberJoinedByInviteLink(ChatInviteLink inviteLink)
        {
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = -253307459;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMemberJoinedByRequest extends ChatEventAction
    {
        public long approverUserId;
        public ChatInviteLink inviteLink;

        public ChatEventMemberJoinedByRequest()
        {
        }

        public ChatEventMemberJoinedByRequest(long approverUserId, ChatInviteLink inviteLink)
        {
            this.approverUserId = approverUserId;
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = -1647804865;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMemberLeft extends ChatEventAction
    {

        public ChatEventMemberLeft()
        {
        }

        public static final int CONSTRUCTOR = -948420593;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMemberInvited extends ChatEventAction
    {
        public long userId;
        public ChatMemberStatus status;

        public ChatEventMemberInvited()
        {
        }

        public ChatEventMemberInvited(long userId, ChatMemberStatus status)
        {
            this.userId = userId;
            this.status = status;
        }

        public static final int CONSTRUCTOR = 953663433;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMemberPromoted extends ChatEventAction
    {
        public long userId;
        public ChatMemberStatus oldStatus;
        public ChatMemberStatus newStatus;

        public ChatEventMemberPromoted()
        {
        }

        public ChatEventMemberPromoted(long userId, ChatMemberStatus oldStatus,
                ChatMemberStatus newStatus)
        {
            this.userId = userId;
            this.oldStatus = oldStatus;
            this.newStatus = newStatus;
        }

        public static final int CONSTRUCTOR = 525297761;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMemberRestricted extends ChatEventAction
    {
        public MessageSender memberId;
        public ChatMemberStatus oldStatus;
        public ChatMemberStatus newStatus;

        public ChatEventMemberRestricted()
        {
        }

        public ChatEventMemberRestricted(MessageSender memberId, ChatMemberStatus oldStatus,
                ChatMemberStatus newStatus)
        {
            this.memberId = memberId;
            this.oldStatus = oldStatus;
            this.newStatus = newStatus;
        }

        public static final int CONSTRUCTOR = 1603608069;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventTitleChanged extends ChatEventAction
    {
        public String oldTitle;
        public String newTitle;

        public ChatEventTitleChanged()
        {
        }

        public ChatEventTitleChanged(String oldTitle, String newTitle)
        {
            this.oldTitle = oldTitle;
            this.newTitle = newTitle;
        }

        public static final int CONSTRUCTOR = 1134103250;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventPermissionsChanged extends ChatEventAction
    {
        public ChatPermissions oldPermissions;
        public ChatPermissions newPermissions;

        public ChatEventPermissionsChanged()
        {
        }

        public ChatEventPermissionsChanged(ChatPermissions oldPermissions,
                ChatPermissions newPermissions)
        {
            this.oldPermissions = oldPermissions;
            this.newPermissions = newPermissions;
        }

        public static final int CONSTRUCTOR = -1311557720;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventDescriptionChanged extends ChatEventAction
    {
        public String oldDescription;
        public String newDescription;

        public ChatEventDescriptionChanged()
        {
        }

        public ChatEventDescriptionChanged(String oldDescription, String newDescription)
        {
            this.oldDescription = oldDescription;
            this.newDescription = newDescription;
        }

        public static final int CONSTRUCTOR = 39112478;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventUsernameChanged extends ChatEventAction
    {
        public String oldUsername;
        public String newUsername;

        public ChatEventUsernameChanged()
        {
        }

        public ChatEventUsernameChanged(String oldUsername, String newUsername)
        {
            this.oldUsername = oldUsername;
            this.newUsername = newUsername;
        }

        public static final int CONSTRUCTOR = 1728558443;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventPhotoChanged extends ChatEventAction
    {
        public ChatPhoto oldPhoto;
        public ChatPhoto newPhoto;

        public ChatEventPhotoChanged()
        {
        }

        public ChatEventPhotoChanged(ChatPhoto oldPhoto, ChatPhoto newPhoto)
        {
            this.oldPhoto = oldPhoto;
            this.newPhoto = newPhoto;
        }

        public static final int CONSTRUCTOR = -811572541;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventInvitesToggled extends ChatEventAction
    {
        public boolean canInviteUsers;

        public ChatEventInvitesToggled()
        {
        }

        public ChatEventInvitesToggled(boolean canInviteUsers)
        {
            this.canInviteUsers = canInviteUsers;
        }

        public static final int CONSTRUCTOR = -62548373;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventLinkedChatChanged extends ChatEventAction
    {
        public long oldLinkedChatId;
        public long newLinkedChatId;

        public ChatEventLinkedChatChanged()
        {
        }

        public ChatEventLinkedChatChanged(long oldLinkedChatId, long newLinkedChatId)
        {
            this.oldLinkedChatId = oldLinkedChatId;
            this.newLinkedChatId = newLinkedChatId;
        }

        public static final int CONSTRUCTOR = 1797419439;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventSlowModeDelayChanged extends ChatEventAction
    {
        public int oldSlowModeDelay;
        public int newSlowModeDelay;

        public ChatEventSlowModeDelayChanged()
        {
        }

        public ChatEventSlowModeDelayChanged(int oldSlowModeDelay, int newSlowModeDelay)
        {
            this.oldSlowModeDelay = oldSlowModeDelay;
            this.newSlowModeDelay = newSlowModeDelay;
        }

        public static final int CONSTRUCTOR = -1653195765;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventMessageTtlChanged extends ChatEventAction
    {
        public int oldMessageTtl;
        public int newMessageTtl;

        public ChatEventMessageTtlChanged()
        {
        }

        public ChatEventMessageTtlChanged(int oldMessageTtl, int newMessageTtl)
        {
            this.oldMessageTtl = oldMessageTtl;
            this.newMessageTtl = newMessageTtl;
        }

        public static final int CONSTRUCTOR = 776386995;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventSignMessagesToggled extends ChatEventAction
    {
        public boolean signMessages;

        public ChatEventSignMessagesToggled()
        {
        }

        public ChatEventSignMessagesToggled(boolean signMessages)
        {
            this.signMessages = signMessages;
        }

        public static final int CONSTRUCTOR = -1313265634;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventHasProtectedContentToggled extends ChatEventAction
    {
        public boolean hasProtectedContent;

        public ChatEventHasProtectedContentToggled()
        {
        }

        public ChatEventHasProtectedContentToggled(boolean hasProtectedContent)
        {
            this.hasProtectedContent = hasProtectedContent;
        }

        public static final int CONSTRUCTOR = -184270335;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventStickerSetChanged extends ChatEventAction
    {
        public long oldStickerSetId;
        public long newStickerSetId;

        public ChatEventStickerSetChanged()
        {
        }

        public ChatEventStickerSetChanged(long oldStickerSetId, long newStickerSetId)
        {
            this.oldStickerSetId = oldStickerSetId;
            this.newStickerSetId = newStickerSetId;
        }

        public static final int CONSTRUCTOR = -1243130481;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventLocationChanged extends ChatEventAction
    {
        public ChatLocation oldLocation;
        public ChatLocation newLocation;

        public ChatEventLocationChanged()
        {
        }

        public ChatEventLocationChanged(ChatLocation oldLocation, ChatLocation newLocation)
        {
            this.oldLocation = oldLocation;
            this.newLocation = newLocation;
        }

        public static final int CONSTRUCTOR = -405930674;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventIsAllHistoryAvailableToggled extends ChatEventAction
    {
        public boolean isAllHistoryAvailable;

        public ChatEventIsAllHistoryAvailableToggled()
        {
        }

        public ChatEventIsAllHistoryAvailableToggled(boolean isAllHistoryAvailable)
        {
            this.isAllHistoryAvailable = isAllHistoryAvailable;
        }

        public static final int CONSTRUCTOR = -1599063019;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventInviteLinkEdited extends ChatEventAction
    {
        public ChatInviteLink oldInviteLink;
        public ChatInviteLink newInviteLink;

        public ChatEventInviteLinkEdited()
        {
        }

        public ChatEventInviteLinkEdited(ChatInviteLink oldInviteLink, ChatInviteLink newInviteLink)
        {
            this.oldInviteLink = oldInviteLink;
            this.newInviteLink = newInviteLink;
        }

        public static final int CONSTRUCTOR = -460190366;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventInviteLinkRevoked extends ChatEventAction
    {
        public ChatInviteLink inviteLink;

        public ChatEventInviteLinkRevoked()
        {
        }

        public ChatEventInviteLinkRevoked(ChatInviteLink inviteLink)
        {
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = -1579417629;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventInviteLinkDeleted extends ChatEventAction
    {
        public ChatInviteLink inviteLink;

        public ChatEventInviteLinkDeleted()
        {
        }

        public ChatEventInviteLinkDeleted(ChatInviteLink inviteLink)
        {
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = -1394974361;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventVideoChatCreated extends ChatEventAction
    {
        public int groupCallId;

        public ChatEventVideoChatCreated()
        {
        }

        public ChatEventVideoChatCreated(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = 1822853755;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventVideoChatEnded extends ChatEventAction
    {
        public int groupCallId;

        public ChatEventVideoChatEnded()
        {
        }

        public ChatEventVideoChatEnded(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = 1630039112;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventVideoChatParticipantIsMutedToggled extends ChatEventAction
    {
        public MessageSender participantId;
        public boolean isMuted;

        public ChatEventVideoChatParticipantIsMutedToggled()
        {
        }

        public ChatEventVideoChatParticipantIsMutedToggled(MessageSender participantId,
                boolean isMuted)
        {
            this.participantId = participantId;
            this.isMuted = isMuted;
        }

        public static final int CONSTRUCTOR = 521165047;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventVideoChatParticipantVolumeLevelChanged extends ChatEventAction
    {
        public MessageSender participantId;
        public int volumeLevel;

        public ChatEventVideoChatParticipantVolumeLevelChanged()
        {
        }

        public ChatEventVideoChatParticipantVolumeLevelChanged(MessageSender participantId,
                int volumeLevel)
        {
            this.participantId = participantId;
            this.volumeLevel = volumeLevel;
        }

        public static final int CONSTRUCTOR = 1131385534;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventVideoChatMuteNewParticipantsToggled extends ChatEventAction
    {
        public boolean muteNewParticipants;

        public ChatEventVideoChatMuteNewParticipantsToggled()
        {
        }

        public ChatEventVideoChatMuteNewParticipantsToggled(boolean muteNewParticipants)
        {
            this.muteNewParticipants = muteNewParticipants;
        }

        public static final int CONSTRUCTOR = -126547970;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEventLogFilters extends Object
    {
        public boolean messageEdits;
        public boolean messageDeletions;
        public boolean messagePins;
        public boolean memberJoins;
        public boolean memberLeaves;
        public boolean memberInvites;
        public boolean memberPromotions;
        public boolean memberRestrictions;
        public boolean infoChanges;
        public boolean settingChanges;
        public boolean inviteLinkChanges;
        public boolean videoChatChanges;

        public ChatEventLogFilters()
        {
        }

        public ChatEventLogFilters(boolean messageEdits, boolean messageDeletions,
                boolean messagePins, boolean memberJoins, boolean memberLeaves,
                boolean memberInvites, boolean memberPromotions, boolean memberRestrictions,
                boolean infoChanges, boolean settingChanges, boolean inviteLinkChanges,
                boolean videoChatChanges)
        {
            this.messageEdits = messageEdits;
            this.messageDeletions = messageDeletions;
            this.messagePins = messagePins;
            this.memberJoins = memberJoins;
            this.memberLeaves = memberLeaves;
            this.memberInvites = memberInvites;
            this.memberPromotions = memberPromotions;
            this.memberRestrictions = memberRestrictions;
            this.infoChanges = infoChanges;
            this.settingChanges = settingChanges;
            this.inviteLinkChanges = inviteLinkChanges;
            this.videoChatChanges = videoChatChanges;
        }

        public static final int CONSTRUCTOR = 1251197299;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatEvents extends Object
    {
        public ChatEvent[] events;

        public ChatEvents()
        {
        }

        public ChatEvents(ChatEvent[] events)
        {
            this.events = events;
        }

        public static final int CONSTRUCTOR = -585329664;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatFilter extends Object
    {
        public String title;
        public String iconName;
        public long[] pinnedChatIds;
        public long[] includedChatIds;
        public long[] excludedChatIds;
        public boolean excludeMuted;
        public boolean excludeRead;
        public boolean excludeArchived;
        public boolean includeContacts;
        public boolean includeNonContacts;
        public boolean includeBots;
        public boolean includeGroups;
        public boolean includeChannels;

        public ChatFilter()
        {
        }

        public ChatFilter(String title, String iconName, long[] pinnedChatIds,
                long[] includedChatIds, long[] excludedChatIds, boolean excludeMuted,
                boolean excludeRead, boolean excludeArchived, boolean includeContacts,
                boolean includeNonContacts, boolean includeBots, boolean includeGroups,
                boolean includeChannels)
        {
            this.title = title;
            this.iconName = iconName;
            this.pinnedChatIds = pinnedChatIds;
            this.includedChatIds = includedChatIds;
            this.excludedChatIds = excludedChatIds;
            this.excludeMuted = excludeMuted;
            this.excludeRead = excludeRead;
            this.excludeArchived = excludeArchived;
            this.includeContacts = includeContacts;
            this.includeNonContacts = includeNonContacts;
            this.includeBots = includeBots;
            this.includeGroups = includeGroups;
            this.includeChannels = includeChannels;
        }

        public static final int CONSTRUCTOR = -664815123;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatFilterInfo extends Object
    {
        public int id;
        public String title;
        public String iconName;

        public ChatFilterInfo()
        {
        }

        public ChatFilterInfo(int id, String title, String iconName)
        {
            this.id = id;
            this.title = title;
            this.iconName = iconName;
        }

        public static final int CONSTRUCTOR = -943721165;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatInviteLink extends Object
    {
        public String inviteLink;
        public String name;
        public long creatorUserId;
        public int date;
        public int editDate;
        public int expirationDate;
        public int memberLimit;
        public int memberCount;
        public int pendingJoinRequestCount;
        public boolean createsJoinRequest;
        public boolean isPrimary;
        public boolean isRevoked;

        public ChatInviteLink()
        {
        }

        public ChatInviteLink(String inviteLink, String name, long creatorUserId, int date,
                int editDate, int expirationDate, int memberLimit, int memberCount,
                int pendingJoinRequestCount, boolean createsJoinRequest, boolean isPrimary,
                boolean isRevoked)
        {
            this.inviteLink = inviteLink;
            this.name = name;
            this.creatorUserId = creatorUserId;
            this.date = date;
            this.editDate = editDate;
            this.expirationDate = expirationDate;
            this.memberLimit = memberLimit;
            this.memberCount = memberCount;
            this.pendingJoinRequestCount = pendingJoinRequestCount;
            this.createsJoinRequest = createsJoinRequest;
            this.isPrimary = isPrimary;
            this.isRevoked = isRevoked;
        }

        public static final int CONSTRUCTOR = -205812476;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatInviteLinkCount extends Object
    {
        public long userId;
        public int inviteLinkCount;
        public int revokedInviteLinkCount;

        public ChatInviteLinkCount()
        {
        }

        public ChatInviteLinkCount(long userId, int inviteLinkCount, int revokedInviteLinkCount)
        {
            this.userId = userId;
            this.inviteLinkCount = inviteLinkCount;
            this.revokedInviteLinkCount = revokedInviteLinkCount;
        }

        public static final int CONSTRUCTOR = -1021999210;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatInviteLinkCounts extends Object
    {
        public ChatInviteLinkCount[] inviteLinkCounts;

        public ChatInviteLinkCounts()
        {
        }

        public ChatInviteLinkCounts(ChatInviteLinkCount[] inviteLinkCounts)
        {
            this.inviteLinkCounts = inviteLinkCounts;
        }

        public static final int CONSTRUCTOR = 920326637;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatInviteLinkInfo extends Object
    {
        public long chatId;
        public int accessibleFor;
        public ChatType type;
        public String title;
        public ChatPhotoInfo photo;
        public String description;
        public int memberCount;
        public long[] memberUserIds;
        public boolean createsJoinRequest;
        public boolean isPublic;

        public ChatInviteLinkInfo()
        {
        }

        public ChatInviteLinkInfo(long chatId, int accessibleFor, ChatType type, String title,
                ChatPhotoInfo photo, String description, int memberCount, long[] memberUserIds,
                boolean createsJoinRequest, boolean isPublic)
        {
            this.chatId = chatId;
            this.accessibleFor = accessibleFor;
            this.type = type;
            this.title = title;
            this.photo = photo;
            this.description = description;
            this.memberCount = memberCount;
            this.memberUserIds = memberUserIds;
            this.createsJoinRequest = createsJoinRequest;
            this.isPublic = isPublic;
        }

        public static final int CONSTRUCTOR = 546234276;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatInviteLinkMember extends Object
    {
        public long userId;
        public int joinedChatDate;
        public long approverUserId;

        public ChatInviteLinkMember()
        {
        }

        public ChatInviteLinkMember(long userId, int joinedChatDate, long approverUserId)
        {
            this.userId = userId;
            this.joinedChatDate = joinedChatDate;
            this.approverUserId = approverUserId;
        }

        public static final int CONSTRUCTOR = -1409060582;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatInviteLinkMembers extends Object
    {
        public int totalCount;
        public ChatInviteLinkMember[] members;

        public ChatInviteLinkMembers()
        {
        }

        public ChatInviteLinkMembers(int totalCount, ChatInviteLinkMember[] members)
        {
            this.totalCount = totalCount;
            this.members = members;
        }

        public static final int CONSTRUCTOR = 315635051;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatInviteLinks extends Object
    {
        public int totalCount;
        public ChatInviteLink[] inviteLinks;

        public ChatInviteLinks()
        {
        }

        public ChatInviteLinks(int totalCount, ChatInviteLink[] inviteLinks)
        {
            this.totalCount = totalCount;
            this.inviteLinks = inviteLinks;
        }

        public static final int CONSTRUCTOR = 112891427;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatJoinRequest extends Object
    {
        public long userId;
        public int date;
        public String bio;

        public ChatJoinRequest()
        {
        }

        public ChatJoinRequest(long userId, int date, String bio)
        {
            this.userId = userId;
            this.date = date;
            this.bio = bio;
        }

        public static final int CONSTRUCTOR = 59341416;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatJoinRequests extends Object
    {
        public int totalCount;
        public ChatJoinRequest[] requests;

        public ChatJoinRequests()
        {
        }

        public ChatJoinRequests(int totalCount, ChatJoinRequest[] requests)
        {
            this.totalCount = totalCount;
            this.requests = requests;
        }

        public static final int CONSTRUCTOR = 1291680519;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatJoinRequestsInfo extends Object
    {
        public int totalCount;
        public long[] userIds;

        public ChatJoinRequestsInfo()
        {
        }

        public ChatJoinRequestsInfo(int totalCount, long[] userIds)
        {
            this.totalCount = totalCount;
            this.userIds = userIds;
        }

        public static final int CONSTRUCTOR = 888534463;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatList extends Object
    {
    }

    public static class ChatListMain extends ChatList
    {

        public ChatListMain()
        {
        }

        public static final int CONSTRUCTOR = -400991316;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatListArchive extends ChatList
    {

        public ChatListArchive()
        {
        }

        public static final int CONSTRUCTOR = 362770115;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatListFilter extends ChatList
    {
        public int chatFilterId;

        public ChatListFilter()
        {
        }

        public ChatListFilter(int chatFilterId)
        {
            this.chatFilterId = chatFilterId;
        }

        public static final int CONSTRUCTOR = -2022707655;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatLists extends Object
    {
        public ChatList[] chatLists;

        public ChatLists()
        {
        }

        public ChatLists(ChatList[] chatLists)
        {
            this.chatLists = chatLists;
        }

        public static final int CONSTRUCTOR = -258292771;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatLocation extends Object
    {
        public Location location;
        public String address;

        public ChatLocation()
        {
        }

        public ChatLocation(Location location, String address)
        {
            this.location = location;
            this.address = address;
        }

        public static final int CONSTRUCTOR = -1566863583;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMember extends Object
    {
        public MessageSender memberId;
        public long inviterUserId;
        public int joinedChatDate;
        public ChatMemberStatus status;

        public ChatMember()
        {
        }

        public ChatMember(MessageSender memberId, long inviterUserId, int joinedChatDate,
                ChatMemberStatus status)
        {
            this.memberId = memberId;
            this.inviterUserId = inviterUserId;
            this.joinedChatDate = joinedChatDate;
            this.status = status;
        }

        public static final int CONSTRUCTOR = 1829953909;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatMemberStatus extends Object
    {
    }

    public static class ChatMemberStatusCreator extends ChatMemberStatus
    {
        public String customTitle;
        public boolean isAnonymous;
        public boolean isMember;

        public ChatMemberStatusCreator()
        {
        }

        public ChatMemberStatusCreator(String customTitle, boolean isAnonymous, boolean isMember)
        {
            this.customTitle = customTitle;
            this.isAnonymous = isAnonymous;
            this.isMember = isMember;
        }

        public static final int CONSTRUCTOR = -160019714;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMemberStatusAdministrator extends ChatMemberStatus
    {
        public String customTitle;
        public boolean canBeEdited;
        public boolean canManageChat;
        public boolean canChangeInfo;
        public boolean canPostMessages;
        public boolean canEditMessages;
        public boolean canDeleteMessages;
        public boolean canInviteUsers;
        public boolean canRestrictMembers;
        public boolean canPinMessages;
        public boolean canPromoteMembers;
        public boolean canManageVideoChats;
        public boolean isAnonymous;

        public ChatMemberStatusAdministrator()
        {
        }

        public ChatMemberStatusAdministrator(String customTitle, boolean canBeEdited,
                boolean canManageChat, boolean canChangeInfo, boolean canPostMessages,
                boolean canEditMessages, boolean canDeleteMessages, boolean canInviteUsers,
                boolean canRestrictMembers, boolean canPinMessages, boolean canPromoteMembers,
                boolean canManageVideoChats, boolean isAnonymous)
        {
            this.customTitle = customTitle;
            this.canBeEdited = canBeEdited;
            this.canManageChat = canManageChat;
            this.canChangeInfo = canChangeInfo;
            this.canPostMessages = canPostMessages;
            this.canEditMessages = canEditMessages;
            this.canDeleteMessages = canDeleteMessages;
            this.canInviteUsers = canInviteUsers;
            this.canRestrictMembers = canRestrictMembers;
            this.canPinMessages = canPinMessages;
            this.canPromoteMembers = canPromoteMembers;
            this.canManageVideoChats = canManageVideoChats;
            this.isAnonymous = isAnonymous;
        }

        public static final int CONSTRUCTOR = 82243562;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMemberStatusMember extends ChatMemberStatus
    {

        public ChatMemberStatusMember()
        {
        }

        public static final int CONSTRUCTOR = 844723285;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMemberStatusRestricted extends ChatMemberStatus
    {
        public boolean isMember;
        public int restrictedUntilDate;
        public ChatPermissions permissions;

        public ChatMemberStatusRestricted()
        {
        }

        public ChatMemberStatusRestricted(boolean isMember, int restrictedUntilDate,
                ChatPermissions permissions)
        {
            this.isMember = isMember;
            this.restrictedUntilDate = restrictedUntilDate;
            this.permissions = permissions;
        }

        public static final int CONSTRUCTOR = 1661432998;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMemberStatusLeft extends ChatMemberStatus
    {

        public ChatMemberStatusLeft()
        {
        }

        public static final int CONSTRUCTOR = -5815259;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMemberStatusBanned extends ChatMemberStatus
    {
        public int bannedUntilDate;

        public ChatMemberStatusBanned()
        {
        }

        public ChatMemberStatusBanned(int bannedUntilDate)
        {
            this.bannedUntilDate = bannedUntilDate;
        }

        public static final int CONSTRUCTOR = -1653518666;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMembers extends Object
    {
        public int totalCount;
        public ChatMember[] members;

        public ChatMembers()
        {
        }

        public ChatMembers(int totalCount, ChatMember[] members)
        {
            this.totalCount = totalCount;
            this.members = members;
        }

        public static final int CONSTRUCTOR = -497558622;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatMembersFilter extends Object
    {
    }

    public static class ChatMembersFilterContacts extends ChatMembersFilter
    {

        public ChatMembersFilterContacts()
        {
        }

        public static final int CONSTRUCTOR = 1774485671;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMembersFilterAdministrators extends ChatMembersFilter
    {

        public ChatMembersFilterAdministrators()
        {
        }

        public static final int CONSTRUCTOR = -1266893796;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMembersFilterMembers extends ChatMembersFilter
    {

        public ChatMembersFilterMembers()
        {
        }

        public static final int CONSTRUCTOR = 670504342;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMembersFilterMention extends ChatMembersFilter
    {
        public long messageThreadId;

        public ChatMembersFilterMention()
        {
        }

        public ChatMembersFilterMention(long messageThreadId)
        {
            this.messageThreadId = messageThreadId;
        }

        public static final int CONSTRUCTOR = 856419831;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMembersFilterRestricted extends ChatMembersFilter
    {

        public ChatMembersFilterRestricted()
        {
        }

        public static final int CONSTRUCTOR = 1256282813;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMembersFilterBanned extends ChatMembersFilter
    {

        public ChatMembersFilterBanned()
        {
        }

        public static final int CONSTRUCTOR = -1863102648;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatMembersFilterBots extends ChatMembersFilter
    {

        public ChatMembersFilterBots()
        {
        }

        public static final int CONSTRUCTOR = -1422567288;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatNearby extends Object
    {
        public long chatId;
        public int distance;

        public ChatNearby()
        {
        }

        public ChatNearby(long chatId, int distance)
        {
            this.chatId = chatId;
            this.distance = distance;
        }

        public static final int CONSTRUCTOR = 48120405;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatNotificationSettings extends Object
    {
        public boolean useDefaultMuteFor;
        public int muteFor;
        public boolean useDefaultSound;
        public String sound;
        public boolean useDefaultShowPreview;
        public boolean showPreview;
        public boolean useDefaultDisablePinnedMessageNotifications;
        public boolean disablePinnedMessageNotifications;
        public boolean useDefaultDisableMentionNotifications;
        public boolean disableMentionNotifications;

        public ChatNotificationSettings()
        {
        }

        public ChatNotificationSettings(boolean useDefaultMuteFor, int muteFor,
                boolean useDefaultSound, String sound, boolean useDefaultShowPreview,
                boolean showPreview, boolean useDefaultDisablePinnedMessageNotifications,
                boolean disablePinnedMessageNotifications,
                boolean useDefaultDisableMentionNotifications, boolean disableMentionNotifications)
        {
            this.useDefaultMuteFor = useDefaultMuteFor;
            this.muteFor = muteFor;
            this.useDefaultSound = useDefaultSound;
            this.sound = sound;
            this.useDefaultShowPreview = useDefaultShowPreview;
            this.showPreview = showPreview;
            this.useDefaultDisablePinnedMessageNotifications = useDefaultDisablePinnedMessageNotifications;
            this.disablePinnedMessageNotifications = disablePinnedMessageNotifications;
            this.useDefaultDisableMentionNotifications = useDefaultDisableMentionNotifications;
            this.disableMentionNotifications = disableMentionNotifications;
        }

        public static final int CONSTRUCTOR = 1503183218;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatPermissions extends Object
    {
        public boolean canSendMessages;
        public boolean canSendMediaMessages;
        public boolean canSendPolls;
        public boolean canSendOtherMessages;
        public boolean canAddWebPagePreviews;
        public boolean canChangeInfo;
        public boolean canInviteUsers;
        public boolean canPinMessages;

        public ChatPermissions()
        {
        }

        public ChatPermissions(boolean canSendMessages, boolean canSendMediaMessages,
                boolean canSendPolls, boolean canSendOtherMessages, boolean canAddWebPagePreviews,
                boolean canChangeInfo, boolean canInviteUsers, boolean canPinMessages)
        {
            this.canSendMessages = canSendMessages;
            this.canSendMediaMessages = canSendMediaMessages;
            this.canSendPolls = canSendPolls;
            this.canSendOtherMessages = canSendOtherMessages;
            this.canAddWebPagePreviews = canAddWebPagePreviews;
            this.canChangeInfo = canChangeInfo;
            this.canInviteUsers = canInviteUsers;
            this.canPinMessages = canPinMessages;
        }

        public static final int CONSTRUCTOR = 1584650463;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatPhoto extends Object
    {
        public long id;
        public int addedDate;
        public Minithumbnail minithumbnail;
        public PhotoSize[] sizes;
        public AnimatedChatPhoto animation;

        public ChatPhoto()
        {
        }

        public ChatPhoto(long id, int addedDate, Minithumbnail minithumbnail, PhotoSize[] sizes,
                AnimatedChatPhoto animation)
        {
            this.id = id;
            this.addedDate = addedDate;
            this.minithumbnail = minithumbnail;
            this.sizes = sizes;
            this.animation = animation;
        }

        public static final int CONSTRUCTOR = -113003577;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatPhotoInfo extends Object
    {
        public File small;
        public File big;
        public Minithumbnail minithumbnail;
        public boolean hasAnimation;

        public ChatPhotoInfo()
        {
        }

        public ChatPhotoInfo(File small, File big, Minithumbnail minithumbnail,
                boolean hasAnimation)
        {
            this.small = small;
            this.big = big;
            this.minithumbnail = minithumbnail;
            this.hasAnimation = hasAnimation;
        }

        public static final int CONSTRUCTOR = 167058358;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatPhotos extends Object
    {
        public int totalCount;
        public ChatPhoto[] photos;

        public ChatPhotos()
        {
        }

        public ChatPhotos(int totalCount, ChatPhoto[] photos)
        {
            this.totalCount = totalCount;
            this.photos = photos;
        }

        public static final int CONSTRUCTOR = -1510699180;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatPosition extends Object
    {
        public ChatList list;
        public long order;
        public boolean isPinned;
        public ChatSource source;

        public ChatPosition()
        {
        }

        public ChatPosition(ChatList list, long order, boolean isPinned, ChatSource source)
        {
            this.list = list;
            this.order = order;
            this.isPinned = isPinned;
            this.source = source;
        }

        public static final int CONSTRUCTOR = -622557355;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatReportReason extends Object
    {
    }

    public static class ChatReportReasonSpam extends ChatReportReason
    {

        public ChatReportReasonSpam()
        {
        }

        public static final int CONSTRUCTOR = -510848863;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatReportReasonViolence extends ChatReportReason
    {

        public ChatReportReasonViolence()
        {
        }

        public static final int CONSTRUCTOR = -1330235395;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatReportReasonPornography extends ChatReportReason
    {

        public ChatReportReasonPornography()
        {
        }

        public static final int CONSTRUCTOR = 722614385;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatReportReasonChildAbuse extends ChatReportReason
    {

        public ChatReportReasonChildAbuse()
        {
        }

        public static final int CONSTRUCTOR = -1070686531;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatReportReasonCopyright extends ChatReportReason
    {

        public ChatReportReasonCopyright()
        {
        }

        public static final int CONSTRUCTOR = 986898080;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatReportReasonUnrelatedLocation extends ChatReportReason
    {

        public ChatReportReasonUnrelatedLocation()
        {
        }

        public static final int CONSTRUCTOR = 2632403;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatReportReasonFake extends ChatReportReason
    {

        public ChatReportReasonFake()
        {
        }

        public static final int CONSTRUCTOR = -1713230446;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatReportReasonCustom extends ChatReportReason
    {

        public ChatReportReasonCustom()
        {
        }

        public static final int CONSTRUCTOR = 1288925974;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatSource extends Object
    {
    }

    public static class ChatSourceMtprotoProxy extends ChatSource
    {

        public ChatSourceMtprotoProxy()
        {
        }

        public static final int CONSTRUCTOR = 394074115;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatSourcePublicServiceAnnouncement extends ChatSource
    {
        public String type;
        public String text;

        public ChatSourcePublicServiceAnnouncement()
        {
        }

        public ChatSourcePublicServiceAnnouncement(String type, String text)
        {
            this.type = type;
            this.text = text;
        }

        public static final int CONSTRUCTOR = -328571244;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatStatistics extends Object
    {
    }

    public static class ChatStatisticsSupergroup extends ChatStatistics
    {
        public DateRange period;
        public StatisticalValue memberCount;
        public StatisticalValue messageCount;
        public StatisticalValue viewerCount;
        public StatisticalValue senderCount;
        public StatisticalGraph memberCountGraph;
        public StatisticalGraph joinGraph;
        public StatisticalGraph joinBySourceGraph;
        public StatisticalGraph languageGraph;
        public StatisticalGraph messageContentGraph;
        public StatisticalGraph actionGraph;
        public StatisticalGraph dayGraph;
        public StatisticalGraph weekGraph;
        public ChatStatisticsMessageSenderInfo[] topSenders;
        public ChatStatisticsAdministratorActionsInfo[] topAdministrators;
        public ChatStatisticsInviterInfo[] topInviters;

        public ChatStatisticsSupergroup()
        {
        }

        public ChatStatisticsSupergroup(DateRange period, StatisticalValue memberCount,
                StatisticalValue messageCount, StatisticalValue viewerCount,
                StatisticalValue senderCount, StatisticalGraph memberCountGraph,
                StatisticalGraph joinGraph, StatisticalGraph joinBySourceGraph,
                StatisticalGraph languageGraph, StatisticalGraph messageContentGraph,
                StatisticalGraph actionGraph, StatisticalGraph dayGraph, StatisticalGraph weekGraph,
                ChatStatisticsMessageSenderInfo[] topSenders,
                ChatStatisticsAdministratorActionsInfo[] topAdministrators,
                ChatStatisticsInviterInfo[] topInviters)
        {
            this.period = period;
            this.memberCount = memberCount;
            this.messageCount = messageCount;
            this.viewerCount = viewerCount;
            this.senderCount = senderCount;
            this.memberCountGraph = memberCountGraph;
            this.joinGraph = joinGraph;
            this.joinBySourceGraph = joinBySourceGraph;
            this.languageGraph = languageGraph;
            this.messageContentGraph = messageContentGraph;
            this.actionGraph = actionGraph;
            this.dayGraph = dayGraph;
            this.weekGraph = weekGraph;
            this.topSenders = topSenders;
            this.topAdministrators = topAdministrators;
            this.topInviters = topInviters;
        }

        public static final int CONSTRUCTOR = -17244633;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatStatisticsChannel extends ChatStatistics
    {
        public DateRange period;
        public StatisticalValue memberCount;
        public StatisticalValue meanViewCount;
        public StatisticalValue meanShareCount;
        public double enabledNotificationsPercentage;
        public StatisticalGraph memberCountGraph;
        public StatisticalGraph joinGraph;
        public StatisticalGraph muteGraph;
        public StatisticalGraph viewCountByHourGraph;
        public StatisticalGraph viewCountBySourceGraph;
        public StatisticalGraph joinBySourceGraph;
        public StatisticalGraph languageGraph;
        public StatisticalGraph messageInteractionGraph;
        public StatisticalGraph instantViewInteractionGraph;
        public ChatStatisticsMessageInteractionInfo[] recentMessageInteractions;

        public ChatStatisticsChannel()
        {
        }

        public ChatStatisticsChannel(DateRange period, StatisticalValue memberCount,
                StatisticalValue meanViewCount, StatisticalValue meanShareCount,
                double enabledNotificationsPercentage, StatisticalGraph memberCountGraph,
                StatisticalGraph joinGraph, StatisticalGraph muteGraph,
                StatisticalGraph viewCountByHourGraph, StatisticalGraph viewCountBySourceGraph,
                StatisticalGraph joinBySourceGraph, StatisticalGraph languageGraph,
                StatisticalGraph messageInteractionGraph,
                StatisticalGraph instantViewInteractionGraph,
                ChatStatisticsMessageInteractionInfo[] recentMessageInteractions)
        {
            this.period = period;
            this.memberCount = memberCount;
            this.meanViewCount = meanViewCount;
            this.meanShareCount = meanShareCount;
            this.enabledNotificationsPercentage = enabledNotificationsPercentage;
            this.memberCountGraph = memberCountGraph;
            this.joinGraph = joinGraph;
            this.muteGraph = muteGraph;
            this.viewCountByHourGraph = viewCountByHourGraph;
            this.viewCountBySourceGraph = viewCountBySourceGraph;
            this.joinBySourceGraph = joinBySourceGraph;
            this.languageGraph = languageGraph;
            this.messageInteractionGraph = messageInteractionGraph;
            this.instantViewInteractionGraph = instantViewInteractionGraph;
            this.recentMessageInteractions = recentMessageInteractions;
        }

        public static final int CONSTRUCTOR = -825434183;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatStatisticsAdministratorActionsInfo extends Object
    {
        public long userId;
        public int deletedMessageCount;
        public int bannedUserCount;
        public int restrictedUserCount;

        public ChatStatisticsAdministratorActionsInfo()
        {
        }

        public ChatStatisticsAdministratorActionsInfo(long userId, int deletedMessageCount,
                int bannedUserCount, int restrictedUserCount)
        {
            this.userId = userId;
            this.deletedMessageCount = deletedMessageCount;
            this.bannedUserCount = bannedUserCount;
            this.restrictedUserCount = restrictedUserCount;
        }

        public static final int CONSTRUCTOR = -406467202;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatStatisticsInviterInfo extends Object
    {
        public long userId;
        public int addedMemberCount;

        public ChatStatisticsInviterInfo()
        {
        }

        public ChatStatisticsInviterInfo(long userId, int addedMemberCount)
        {
            this.userId = userId;
            this.addedMemberCount = addedMemberCount;
        }

        public static final int CONSTRUCTOR = 629396619;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatStatisticsMessageInteractionInfo extends Object
    {
        public long messageId;
        public int viewCount;
        public int forwardCount;

        public ChatStatisticsMessageInteractionInfo()
        {
        }

        public ChatStatisticsMessageInteractionInfo(long messageId, int viewCount, int forwardCount)
        {
            this.messageId = messageId;
            this.viewCount = viewCount;
            this.forwardCount = forwardCount;
        }

        public static final int CONSTRUCTOR = -765580756;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatStatisticsMessageSenderInfo extends Object
    {
        public long userId;
        public int sentMessageCount;
        public int averageCharacterCount;

        public ChatStatisticsMessageSenderInfo()
        {
        }

        public ChatStatisticsMessageSenderInfo(long userId, int sentMessageCount,
                int averageCharacterCount)
        {
            this.userId = userId;
            this.sentMessageCount = sentMessageCount;
            this.averageCharacterCount = averageCharacterCount;
        }

        public static final int CONSTRUCTOR = 1762295371;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatTheme extends Object
    {
        public String name;
        public ThemeSettings lightSettings;
        public ThemeSettings darkSettings;

        public ChatTheme()
        {
        }

        public ChatTheme(String name, ThemeSettings lightSettings, ThemeSettings darkSettings)
        {
            this.name = name;
            this.lightSettings = lightSettings;
            this.darkSettings = darkSettings;
        }

        public static final int CONSTRUCTOR = -113218503;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ChatType extends Object
    {
    }

    public static class ChatTypePrivate extends ChatType
    {
        public long userId;

        public ChatTypePrivate()
        {
        }

        public ChatTypePrivate(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = 1579049844;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatTypeBasicGroup extends ChatType
    {
        public long basicGroupId;

        public ChatTypeBasicGroup()
        {
        }

        public ChatTypeBasicGroup(long basicGroupId)
        {
            this.basicGroupId = basicGroupId;
        }

        public static final int CONSTRUCTOR = 973884508;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatTypeSupergroup extends ChatType
    {
        public long supergroupId;
        public boolean isChannel;

        public ChatTypeSupergroup()
        {
        }

        public ChatTypeSupergroup(long supergroupId, boolean isChannel)
        {
            this.supergroupId = supergroupId;
            this.isChannel = isChannel;
        }

        public static final int CONSTRUCTOR = -1472570774;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatTypeSecret extends ChatType
    {
        public int secretChatId;
        public long userId;

        public ChatTypeSecret()
        {
        }

        public ChatTypeSecret(int secretChatId, long userId)
        {
            this.secretChatId = secretChatId;
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = 862366513;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Chats extends Object
    {
        public int totalCount;
        public long[] chatIds;

        public Chats()
        {
        }

        public Chats(int totalCount, long[] chatIds)
        {
            this.totalCount = totalCount;
            this.chatIds = chatIds;
        }

        public static final int CONSTRUCTOR = 1809654812;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChatsNearby extends Object
    {
        public ChatNearby[] usersNearby;
        public ChatNearby[] supergroupsNearby;

        public ChatsNearby()
        {
        }

        public ChatsNearby(ChatNearby[] usersNearby, ChatNearby[] supergroupsNearby)
        {
            this.usersNearby = usersNearby;
            this.supergroupsNearby = supergroupsNearby;
        }

        public static final int CONSTRUCTOR = 187746081;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class CheckChatUsernameResult extends Object
    {
    }

    public static class CheckChatUsernameResultOk extends CheckChatUsernameResult
    {

        public CheckChatUsernameResultOk()
        {
        }

        public static final int CONSTRUCTOR = -1498956964;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckChatUsernameResultUsernameInvalid extends CheckChatUsernameResult
    {

        public CheckChatUsernameResultUsernameInvalid()
        {
        }

        public static final int CONSTRUCTOR = -636979370;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckChatUsernameResultUsernameOccupied extends CheckChatUsernameResult
    {

        public CheckChatUsernameResultUsernameOccupied()
        {
        }

        public static final int CONSTRUCTOR = 1320892201;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckChatUsernameResultPublicChatsTooMuch extends CheckChatUsernameResult
    {

        public CheckChatUsernameResultPublicChatsTooMuch()
        {
        }

        public static final int CONSTRUCTOR = 858247741;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckChatUsernameResultPublicGroupsUnavailable
            extends CheckChatUsernameResult
    {

        public CheckChatUsernameResultPublicGroupsUnavailable()
        {
        }

        public static final int CONSTRUCTOR = -51833641;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class CheckStickerSetNameResult extends Object
    {
    }

    public static class CheckStickerSetNameResultOk extends CheckStickerSetNameResult
    {

        public CheckStickerSetNameResultOk()
        {
        }

        public static final int CONSTRUCTOR = -1404308904;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckStickerSetNameResultNameInvalid extends CheckStickerSetNameResult
    {

        public CheckStickerSetNameResultNameInvalid()
        {
        }

        public static final int CONSTRUCTOR = 177992244;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckStickerSetNameResultNameOccupied extends CheckStickerSetNameResult
    {

        public CheckStickerSetNameResultNameOccupied()
        {
        }

        public static final int CONSTRUCTOR = 1012980872;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ClosedVectorPath extends Object
    {
        public VectorPathCommand[] commands;

        public ClosedVectorPath()
        {
        }

        public ClosedVectorPath(VectorPathCommand[] commands)
        {
            this.commands = commands;
        }

        public static final int CONSTRUCTOR = 589951657;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ConnectedWebsite extends Object
    {
        public long id;
        public String domainName;
        public long botUserId;
        public String browser;
        public String platform;
        public int logInDate;
        public int lastActiveDate;
        public String ip;
        public String location;

        public ConnectedWebsite()
        {
        }

        public ConnectedWebsite(long id, String domainName, long botUserId, String browser,
                String platform, int logInDate, int lastActiveDate, String ip, String location)
        {
            this.id = id;
            this.domainName = domainName;
            this.botUserId = botUserId;
            this.browser = browser;
            this.platform = platform;
            this.logInDate = logInDate;
            this.lastActiveDate = lastActiveDate;
            this.ip = ip;
            this.location = location;
        }

        public static final int CONSTRUCTOR = 844014445;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ConnectedWebsites extends Object
    {
        public ConnectedWebsite[] websites;

        public ConnectedWebsites()
        {
        }

        public ConnectedWebsites(ConnectedWebsite[] websites)
        {
            this.websites = websites;
        }

        public static final int CONSTRUCTOR = -1727949694;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ConnectionState extends Object
    {
    }

    public static class ConnectionStateWaitingForNetwork extends ConnectionState
    {

        public ConnectionStateWaitingForNetwork()
        {
        }

        public static final int CONSTRUCTOR = 1695405912;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ConnectionStateConnectingToProxy extends ConnectionState
    {

        public ConnectionStateConnectingToProxy()
        {
        }

        public static final int CONSTRUCTOR = -93187239;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ConnectionStateConnecting extends ConnectionState
    {

        public ConnectionStateConnecting()
        {
        }

        public static final int CONSTRUCTOR = -1298400670;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ConnectionStateUpdating extends ConnectionState
    {

        public ConnectionStateUpdating()
        {
        }

        public static final int CONSTRUCTOR = -188104009;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ConnectionStateReady extends ConnectionState
    {

        public ConnectionStateReady()
        {
        }

        public static final int CONSTRUCTOR = 48608492;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Contact extends Object
    {
        public String phoneNumber;
        public String firstName;
        public String lastName;
        public String vcard;
        public long userId;

        public Contact()
        {
        }

        public Contact(String phoneNumber, String firstName, String lastName, String vcard,
                long userId)
        {
            this.phoneNumber = phoneNumber;
            this.firstName = firstName;
            this.lastName = lastName;
            this.vcard = vcard;
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = -1993844876;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Count extends Object
    {
        public int count;

        public Count()
        {
        }

        public Count(int count)
        {
            this.count = count;
        }

        public static final int CONSTRUCTOR = 1295577348;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Countries extends Object
    {
        public CountryInfo[] countries;

        public Countries()
        {
        }

        public Countries(CountryInfo[] countries)
        {
            this.countries = countries;
        }

        public static final int CONSTRUCTOR = 1854211813;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CountryInfo extends Object
    {
        public String countryCode;
        public String name;
        public String englishName;
        public boolean isHidden;
        public String[] callingCodes;

        public CountryInfo()
        {
        }

        public CountryInfo(String countryCode, String name, String englishName, boolean isHidden,
                String[] callingCodes)
        {
            this.countryCode = countryCode;
            this.name = name;
            this.englishName = englishName;
            this.isHidden = isHidden;
            this.callingCodes = callingCodes;
        }

        public static final int CONSTRUCTOR = 1617195722;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CustomRequestResult extends Object
    {
        public String result;

        public CustomRequestResult()
        {
        }

        public CustomRequestResult(String result)
        {
            this.result = result;
        }

        public static final int CONSTRUCTOR = -2009960452;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DatabaseStatistics extends Object
    {
        public String statistics;

        public DatabaseStatistics()
        {
        }

        public DatabaseStatistics(String statistics)
        {
            this.statistics = statistics;
        }

        public static final int CONSTRUCTOR = -1123912880;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Date extends Object
    {
        public int day;
        public int month;
        public int year;

        public Date()
        {
        }

        public Date(int day, int month, int year)
        {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public static final int CONSTRUCTOR = -277956960;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DateRange extends Object
    {
        public int startDate;
        public int endDate;

        public DateRange()
        {
        }

        public DateRange(int startDate, int endDate)
        {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public static final int CONSTRUCTOR = 1360333926;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DatedFile extends Object
    {
        public File file;
        public int date;

        public DatedFile()
        {
        }

        public DatedFile(File file, int date)
        {
            this.file = file;
            this.date = date;
        }

        public static final int CONSTRUCTOR = -1840795491;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeepLinkInfo extends Object
    {
        public FormattedText text;
        public boolean needUpdateApplication;

        public DeepLinkInfo()
        {
        }

        public DeepLinkInfo(FormattedText text, boolean needUpdateApplication)
        {
            this.text = text;
            this.needUpdateApplication = needUpdateApplication;
        }

        public static final int CONSTRUCTOR = 1864081662;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class DeviceToken extends Object
    {
    }

    public static class DeviceTokenFirebaseCloudMessaging extends DeviceToken
    {
        public String token;
        public boolean encrypt;

        public DeviceTokenFirebaseCloudMessaging()
        {
        }

        public DeviceTokenFirebaseCloudMessaging(String token, boolean encrypt)
        {
            this.token = token;
            this.encrypt = encrypt;
        }

        public static final int CONSTRUCTOR = -797881849;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenApplePush extends DeviceToken
    {
        public String deviceToken;
        public boolean isAppSandbox;

        public DeviceTokenApplePush()
        {
        }

        public DeviceTokenApplePush(String deviceToken, boolean isAppSandbox)
        {
            this.deviceToken = deviceToken;
            this.isAppSandbox = isAppSandbox;
        }

        public static final int CONSTRUCTOR = 387541955;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenApplePushVoIP extends DeviceToken
    {
        public String deviceToken;
        public boolean isAppSandbox;
        public boolean encrypt;

        public DeviceTokenApplePushVoIP()
        {
        }

        public DeviceTokenApplePushVoIP(String deviceToken, boolean isAppSandbox, boolean encrypt)
        {
            this.deviceToken = deviceToken;
            this.isAppSandbox = isAppSandbox;
            this.encrypt = encrypt;
        }

        public static final int CONSTRUCTOR = 804275689;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenWindowsPush extends DeviceToken
    {
        public String accessToken;

        public DeviceTokenWindowsPush()
        {
        }

        public DeviceTokenWindowsPush(String accessToken)
        {
            this.accessToken = accessToken;
        }

        public static final int CONSTRUCTOR = -1410514289;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenMicrosoftPush extends DeviceToken
    {
        public String channelUri;

        public DeviceTokenMicrosoftPush()
        {
        }

        public DeviceTokenMicrosoftPush(String channelUri)
        {
            this.channelUri = channelUri;
        }

        public static final int CONSTRUCTOR = 1224269900;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenMicrosoftPushVoIP extends DeviceToken
    {
        public String channelUri;

        public DeviceTokenMicrosoftPushVoIP()
        {
        }

        public DeviceTokenMicrosoftPushVoIP(String channelUri)
        {
            this.channelUri = channelUri;
        }

        public static final int CONSTRUCTOR = -785603759;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenWebPush extends DeviceToken
    {
        public String endpoint;
        public String p256dhBase64url;
        public String authBase64url;

        public DeviceTokenWebPush()
        {
        }

        public DeviceTokenWebPush(String endpoint, String p256dhBase64url, String authBase64url)
        {
            this.endpoint = endpoint;
            this.p256dhBase64url = p256dhBase64url;
            this.authBase64url = authBase64url;
        }

        public static final int CONSTRUCTOR = -1694507273;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenSimplePush extends DeviceToken
    {
        public String endpoint;

        public DeviceTokenSimplePush()
        {
        }

        public DeviceTokenSimplePush(String endpoint)
        {
            this.endpoint = endpoint;
        }

        public static final int CONSTRUCTOR = 49584736;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenUbuntuPush extends DeviceToken
    {
        public String token;

        public DeviceTokenUbuntuPush()
        {
        }

        public DeviceTokenUbuntuPush(String token)
        {
            this.token = token;
        }

        public static final int CONSTRUCTOR = 1782320422;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenBlackBerryPush extends DeviceToken
    {
        public String token;

        public DeviceTokenBlackBerryPush()
        {
        }

        public DeviceTokenBlackBerryPush(String token)
        {
            this.token = token;
        }

        public static final int CONSTRUCTOR = 1559167234;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeviceTokenTizenPush extends DeviceToken
    {
        public String regId;

        public DeviceTokenTizenPush()
        {
        }

        public DeviceTokenTizenPush(String regId)
        {
            this.regId = regId;
        }

        public static final int CONSTRUCTOR = -1359947213;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class DiceStickers extends Object
    {
    }

    public static class DiceStickersRegular extends DiceStickers
    {
        public Sticker sticker;

        public DiceStickersRegular()
        {
        }

        public DiceStickersRegular(Sticker sticker)
        {
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = -740299570;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DiceStickersSlotMachine extends DiceStickers
    {
        public Sticker background;
        public Sticker lever;
        public Sticker leftReel;
        public Sticker centerReel;
        public Sticker rightReel;

        public DiceStickersSlotMachine()
        {
        }

        public DiceStickersSlotMachine(Sticker background, Sticker lever, Sticker leftReel,
                Sticker centerReel, Sticker rightReel)
        {
            this.background = background;
            this.lever = lever;
            this.leftReel = leftReel;
            this.centerReel = centerReel;
            this.rightReel = rightReel;
        }

        public static final int CONSTRUCTOR = -375223124;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Document extends Object
    {
        public String fileName;
        public String mimeType;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File document;

        public Document()
        {
        }

        public Document(String fileName, String mimeType, Minithumbnail minithumbnail,
                Thumbnail thumbnail, File document)
        {
            this.fileName = fileName;
            this.mimeType = mimeType;
            this.minithumbnail = minithumbnail;
            this.thumbnail = thumbnail;
            this.document = document;
        }

        public static final int CONSTRUCTOR = -1357271080;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DraftMessage extends Object
    {
        public long replyToMessageId;
        public int date;
        public InputMessageContent inputMessageText;

        public DraftMessage()
        {
        }

        public DraftMessage(long replyToMessageId, int date, InputMessageContent inputMessageText)
        {
            this.replyToMessageId = replyToMessageId;
            this.date = date;
            this.inputMessageText = inputMessageText;
        }

        public static final int CONSTRUCTOR = 1373050112;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EmailAddressAuthenticationCodeInfo extends Object
    {
        public String emailAddressPattern;
        public int length;

        public EmailAddressAuthenticationCodeInfo()
        {
        }

        public EmailAddressAuthenticationCodeInfo(String emailAddressPattern, int length)
        {
            this.emailAddressPattern = emailAddressPattern;
            this.length = length;
        }

        public static final int CONSTRUCTOR = 1151066659;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Emojis extends Object
    {
        public String[] emojis;

        public Emojis()
        {
        }

        public Emojis(String[] emojis)
        {
            this.emojis = emojis;
        }

        public static final int CONSTRUCTOR = 950339552;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EncryptedCredentials extends Object
    {
        public byte[] data;
        public byte[] hash;
        public byte[] secret;

        public EncryptedCredentials()
        {
        }

        public EncryptedCredentials(byte[] data, byte[] hash, byte[] secret)
        {
            this.data = data;
            this.hash = hash;
            this.secret = secret;
        }

        public static final int CONSTRUCTOR = 1331106766;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EncryptedPassportElement extends Object
    {
        public PassportElementType type;
        public byte[] data;
        public DatedFile frontSide;
        public DatedFile reverseSide;
        public DatedFile selfie;
        public DatedFile[] translation;
        public DatedFile[] files;
        public String value;
        public String hash;

        public EncryptedPassportElement()
        {
        }

        public EncryptedPassportElement(PassportElementType type, byte[] data, DatedFile frontSide,
                DatedFile reverseSide, DatedFile selfie, DatedFile[] translation, DatedFile[] files,
                String value, String hash)
        {
            this.type = type;
            this.data = data;
            this.frontSide = frontSide;
            this.reverseSide = reverseSide;
            this.selfie = selfie;
            this.translation = translation;
            this.files = files;
            this.value = value;
            this.hash = hash;
        }

        public static final int CONSTRUCTOR = 2002386193;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Error extends Object
    {
        public int code;
        public String message;

        public Error()
        {
        }

        public Error(int code, String message)
        {
            this.code = code;
            this.message = message;
        }

        public static final int CONSTRUCTOR = -1679978726;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class File extends Object
    {
        public int id;
        public int size;
        public int expectedSize;
        public LocalFile local;
        public RemoteFile remote;

        public File()
        {
        }

        public File(int id, int size, int expectedSize, LocalFile local, RemoteFile remote)
        {
            this.id = id;
            this.size = size;
            this.expectedSize = expectedSize;
            this.local = local;
            this.remote = remote;
        }

        public static final int CONSTRUCTOR = 766337656;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FilePart extends Object
    {
        public byte[] data;

        public FilePart()
        {
        }

        public FilePart(byte[] data)
        {
            this.data = data;
        }

        public static final int CONSTRUCTOR = 911821878;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class FileType extends Object
    {
    }

    public static class FileTypeNone extends FileType
    {

        public FileTypeNone()
        {
        }

        public static final int CONSTRUCTOR = 2003009189;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeAnimation extends FileType
    {

        public FileTypeAnimation()
        {
        }

        public static final int CONSTRUCTOR = -290816582;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeAudio extends FileType
    {

        public FileTypeAudio()
        {
        }

        public static final int CONSTRUCTOR = -709112160;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeDocument extends FileType
    {

        public FileTypeDocument()
        {
        }

        public static final int CONSTRUCTOR = -564722929;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypePhoto extends FileType
    {

        public FileTypePhoto()
        {
        }

        public static final int CONSTRUCTOR = -1718914651;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeProfilePhoto extends FileType
    {

        public FileTypeProfilePhoto()
        {
        }

        public static final int CONSTRUCTOR = 1795089315;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeSecret extends FileType
    {

        public FileTypeSecret()
        {
        }

        public static final int CONSTRUCTOR = -1871899401;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeSecretThumbnail extends FileType
    {

        public FileTypeSecretThumbnail()
        {
        }

        public static final int CONSTRUCTOR = -1401326026;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeSecure extends FileType
    {

        public FileTypeSecure()
        {
        }

        public static final int CONSTRUCTOR = -1419133146;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeSticker extends FileType
    {

        public FileTypeSticker()
        {
        }

        public static final int CONSTRUCTOR = 475233385;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeThumbnail extends FileType
    {

        public FileTypeThumbnail()
        {
        }

        public static final int CONSTRUCTOR = -12443298;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeUnknown extends FileType
    {

        public FileTypeUnknown()
        {
        }

        public static final int CONSTRUCTOR = -2011566768;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeVideo extends FileType
    {

        public FileTypeVideo()
        {
        }

        public static final int CONSTRUCTOR = 1430816539;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeVideoNote extends FileType
    {

        public FileTypeVideoNote()
        {
        }

        public static final int CONSTRUCTOR = -518412385;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeVoiceNote extends FileType
    {

        public FileTypeVoiceNote()
        {
        }

        public static final int CONSTRUCTOR = -588681661;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FileTypeWallpaper extends FileType
    {

        public FileTypeWallpaper()
        {
        }

        public static final int CONSTRUCTOR = 1854930076;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FormattedText extends Object
    {
        public String text;
        public TextEntity[] entities;

        public FormattedText()
        {
        }

        public FormattedText(String text, TextEntity[] entities)
        {
            this.text = text;
            this.entities = entities;
        }

        public static final int CONSTRUCTOR = -252624564;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FoundMessages extends Object
    {
        public int totalCount;
        public Message[] messages;
        public String nextOffset;

        public FoundMessages()
        {
        }

        public FoundMessages(int totalCount, Message[] messages, String nextOffset)
        {
            this.totalCount = totalCount;
            this.messages = messages;
            this.nextOffset = nextOffset;
        }

        public static final int CONSTRUCTOR = -529809608;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Game extends Object
    {
        public long id;
        public String shortName;
        public String title;
        public FormattedText text;
        public String description;
        public Photo photo;
        public Animation animation;

        public Game()
        {
        }

        public Game(long id, String shortName, String title, FormattedText text, String description,
                Photo photo, Animation animation)
        {
            this.id = id;
            this.shortName = shortName;
            this.title = title;
            this.text = text;
            this.description = description;
            this.photo = photo;
            this.animation = animation;
        }

        public static final int CONSTRUCTOR = -1565597752;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GameHighScore extends Object
    {
        public int position;
        public long userId;
        public int score;

        public GameHighScore()
        {
        }

        public GameHighScore(int position, long userId, int score)
        {
            this.position = position;
            this.userId = userId;
            this.score = score;
        }

        public static final int CONSTRUCTOR = 342871838;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GameHighScores extends Object
    {
        public GameHighScore[] scores;

        public GameHighScores()
        {
        }

        public GameHighScores(GameHighScore[] scores)
        {
            this.scores = scores;
        }

        public static final int CONSTRUCTOR = -725770727;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GroupCall extends Object
    {
        public int id;
        public String title;
        public int scheduledStartDate;
        public boolean enabledStartNotification;
        public boolean isActive;
        public boolean isJoined;
        public boolean needRejoin;
        public boolean canBeManaged;
        public int participantCount;
        public boolean loadedAllParticipants;
        public GroupCallRecentSpeaker[] recentSpeakers;
        public boolean isMyVideoEnabled;
        public boolean isMyVideoPaused;
        public boolean canEnableVideo;
        public boolean muteNewParticipants;
        public boolean canToggleMuteNewParticipants;
        public int recordDuration;
        public boolean isVideoRecorded;
        public int duration;

        public GroupCall()
        {
        }

        public GroupCall(int id, String title, int scheduledStartDate,
                boolean enabledStartNotification, boolean isActive, boolean isJoined,
                boolean needRejoin, boolean canBeManaged, int participantCount,
                boolean loadedAllParticipants, GroupCallRecentSpeaker[] recentSpeakers,
                boolean isMyVideoEnabled, boolean isMyVideoPaused, boolean canEnableVideo,
                boolean muteNewParticipants, boolean canToggleMuteNewParticipants,
                int recordDuration, boolean isVideoRecorded, int duration)
        {
            this.id = id;
            this.title = title;
            this.scheduledStartDate = scheduledStartDate;
            this.enabledStartNotification = enabledStartNotification;
            this.isActive = isActive;
            this.isJoined = isJoined;
            this.needRejoin = needRejoin;
            this.canBeManaged = canBeManaged;
            this.participantCount = participantCount;
            this.loadedAllParticipants = loadedAllParticipants;
            this.recentSpeakers = recentSpeakers;
            this.isMyVideoEnabled = isMyVideoEnabled;
            this.isMyVideoPaused = isMyVideoPaused;
            this.canEnableVideo = canEnableVideo;
            this.muteNewParticipants = muteNewParticipants;
            this.canToggleMuteNewParticipants = canToggleMuteNewParticipants;
            this.recordDuration = recordDuration;
            this.isVideoRecorded = isVideoRecorded;
            this.duration = duration;
        }

        public static final int CONSTRUCTOR = 1548892209;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GroupCallId extends Object
    {
        public int id;

        public GroupCallId()
        {
        }

        public GroupCallId(int id)
        {
            this.id = id;
        }

        public static final int CONSTRUCTOR = 350534469;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GroupCallParticipant extends Object
    {
        public MessageSender participantId;
        public int audioSourceId;
        public int screenSharingAudioSourceId;
        public GroupCallParticipantVideoInfo videoInfo;
        public GroupCallParticipantVideoInfo screenSharingVideoInfo;
        public String bio;
        public boolean isCurrentUser;
        public boolean isSpeaking;
        public boolean isHandRaised;
        public boolean canBeMutedForAllUsers;
        public boolean canBeUnmutedForAllUsers;
        public boolean canBeMutedForCurrentUser;
        public boolean canBeUnmutedForCurrentUser;
        public boolean isMutedForAllUsers;
        public boolean isMutedForCurrentUser;
        public boolean canUnmuteSelf;
        public int volumeLevel;
        public String order;

        public GroupCallParticipant()
        {
        }

        public GroupCallParticipant(MessageSender participantId, int audioSourceId,
                int screenSharingAudioSourceId, GroupCallParticipantVideoInfo videoInfo,
                GroupCallParticipantVideoInfo screenSharingVideoInfo, String bio,
                boolean isCurrentUser, boolean isSpeaking, boolean isHandRaised,
                boolean canBeMutedForAllUsers, boolean canBeUnmutedForAllUsers,
                boolean canBeMutedForCurrentUser, boolean canBeUnmutedForCurrentUser,
                boolean isMutedForAllUsers, boolean isMutedForCurrentUser, boolean canUnmuteSelf,
                int volumeLevel, String order)
        {
            this.participantId = participantId;
            this.audioSourceId = audioSourceId;
            this.screenSharingAudioSourceId = screenSharingAudioSourceId;
            this.videoInfo = videoInfo;
            this.screenSharingVideoInfo = screenSharingVideoInfo;
            this.bio = bio;
            this.isCurrentUser = isCurrentUser;
            this.isSpeaking = isSpeaking;
            this.isHandRaised = isHandRaised;
            this.canBeMutedForAllUsers = canBeMutedForAllUsers;
            this.canBeUnmutedForAllUsers = canBeUnmutedForAllUsers;
            this.canBeMutedForCurrentUser = canBeMutedForCurrentUser;
            this.canBeUnmutedForCurrentUser = canBeUnmutedForCurrentUser;
            this.isMutedForAllUsers = isMutedForAllUsers;
            this.isMutedForCurrentUser = isMutedForCurrentUser;
            this.canUnmuteSelf = canUnmuteSelf;
            this.volumeLevel = volumeLevel;
            this.order = order;
        }

        public static final int CONSTRUCTOR = 2059182571;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GroupCallParticipantVideoInfo extends Object
    {
        public GroupCallVideoSourceGroup[] sourceGroups;
        public String endpointId;
        public boolean isPaused;

        public GroupCallParticipantVideoInfo()
        {
        }

        public GroupCallParticipantVideoInfo(GroupCallVideoSourceGroup[] sourceGroups,
                String endpointId, boolean isPaused)
        {
            this.sourceGroups = sourceGroups;
            this.endpointId = endpointId;
            this.isPaused = isPaused;
        }

        public static final int CONSTRUCTOR = -14294645;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GroupCallRecentSpeaker extends Object
    {
        public MessageSender participantId;
        public boolean isSpeaking;

        public GroupCallRecentSpeaker()
        {
        }

        public GroupCallRecentSpeaker(MessageSender participantId, boolean isSpeaking)
        {
            this.participantId = participantId;
            this.isSpeaking = isSpeaking;
        }

        public static final int CONSTRUCTOR = 1819519436;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class GroupCallVideoQuality extends Object
    {
    }

    public static class GroupCallVideoQualityThumbnail extends GroupCallVideoQuality
    {

        public GroupCallVideoQualityThumbnail()
        {
        }

        public static final int CONSTRUCTOR = -379186304;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GroupCallVideoQualityMedium extends GroupCallVideoQuality
    {

        public GroupCallVideoQualityMedium()
        {
        }

        public static final int CONSTRUCTOR = 394968234;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GroupCallVideoQualityFull extends GroupCallVideoQuality
    {

        public GroupCallVideoQualityFull()
        {
        }

        public static final int CONSTRUCTOR = -2125916617;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GroupCallVideoSourceGroup extends Object
    {
        public String semantics;
        public int[] sourceIds;

        public GroupCallVideoSourceGroup()
        {
        }

        public GroupCallVideoSourceGroup(String semantics, int[] sourceIds)
        {
            this.semantics = semantics;
            this.sourceIds = sourceIds;
        }

        public static final int CONSTRUCTOR = -1190900785;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Hashtags extends Object
    {
        public String[] hashtags;

        public Hashtags()
        {
        }

        public Hashtags(String[] hashtags)
        {
            this.hashtags = hashtags;
        }

        public static final int CONSTRUCTOR = 676798885;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class HttpUrl extends Object
    {
        public String url;

        public HttpUrl()
        {
        }

        public HttpUrl(String url)
        {
            this.url = url;
        }

        public static final int CONSTRUCTOR = -2018019930;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class IdentityDocument extends Object
    {
        public String number;
        public Date expiryDate;
        public DatedFile frontSide;
        public DatedFile reverseSide;
        public DatedFile selfie;
        public DatedFile[] translation;

        public IdentityDocument()
        {
        }

        public IdentityDocument(String number, Date expiryDate, DatedFile frontSide,
                DatedFile reverseSide, DatedFile selfie, DatedFile[] translation)
        {
            this.number = number;
            this.expiryDate = expiryDate;
            this.frontSide = frontSide;
            this.reverseSide = reverseSide;
            this.selfie = selfie;
            this.translation = translation;
        }

        public static final int CONSTRUCTOR = 445952972;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ImportedContacts extends Object
    {
        public long[] userIds;
        public int[] importerCount;

        public ImportedContacts()
        {
        }

        public ImportedContacts(long[] userIds, int[] importerCount)
        {
            this.userIds = userIds;
            this.importerCount = importerCount;
        }

        public static final int CONSTRUCTOR = 2068432290;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineKeyboardButton extends Object
    {
        public String text;
        public InlineKeyboardButtonType type;

        public InlineKeyboardButton()
        {
        }

        public InlineKeyboardButton(String text, InlineKeyboardButtonType type)
        {
            this.text = text;
            this.type = type;
        }

        public static final int CONSTRUCTOR = -372105704;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InlineKeyboardButtonType extends Object
    {
    }

    public static class InlineKeyboardButtonTypeUrl extends InlineKeyboardButtonType
    {
        public String url;

        public InlineKeyboardButtonTypeUrl()
        {
        }

        public InlineKeyboardButtonTypeUrl(String url)
        {
            this.url = url;
        }

        public static final int CONSTRUCTOR = 1130741420;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineKeyboardButtonTypeLoginUrl extends InlineKeyboardButtonType
    {
        public String url;
        public long id;
        public String forwardText;

        public InlineKeyboardButtonTypeLoginUrl()
        {
        }

        public InlineKeyboardButtonTypeLoginUrl(String url, long id, String forwardText)
        {
            this.url = url;
            this.id = id;
            this.forwardText = forwardText;
        }

        public static final int CONSTRUCTOR = -1203413081;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineKeyboardButtonTypeCallback extends InlineKeyboardButtonType
    {
        public byte[] data;

        public InlineKeyboardButtonTypeCallback()
        {
        }

        public InlineKeyboardButtonTypeCallback(byte[] data)
        {
            this.data = data;
        }

        public static final int CONSTRUCTOR = -1127515139;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineKeyboardButtonTypeCallbackWithPassword
            extends InlineKeyboardButtonType
    {
        public byte[] data;

        public InlineKeyboardButtonTypeCallbackWithPassword()
        {
        }

        public InlineKeyboardButtonTypeCallbackWithPassword(byte[] data)
        {
            this.data = data;
        }

        public static final int CONSTRUCTOR = 908018248;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineKeyboardButtonTypeCallbackGame extends InlineKeyboardButtonType
    {

        public InlineKeyboardButtonTypeCallbackGame()
        {
        }

        public static final int CONSTRUCTOR = -383429528;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineKeyboardButtonTypeSwitchInline extends InlineKeyboardButtonType
    {
        public String query;
        public boolean inCurrentChat;

        public InlineKeyboardButtonTypeSwitchInline()
        {
        }

        public InlineKeyboardButtonTypeSwitchInline(String query, boolean inCurrentChat)
        {
            this.query = query;
            this.inCurrentChat = inCurrentChat;
        }

        public static final int CONSTRUCTOR = -2035563307;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineKeyboardButtonTypeBuy extends InlineKeyboardButtonType
    {

        public InlineKeyboardButtonTypeBuy()
        {
        }

        public static final int CONSTRUCTOR = 1360739440;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineKeyboardButtonTypeUser extends InlineKeyboardButtonType
    {
        public long userId;

        public InlineKeyboardButtonTypeUser()
        {
        }

        public InlineKeyboardButtonTypeUser(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = 1836574114;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InlineQueryResult extends Object
    {
    }

    public static class InlineQueryResultArticle extends InlineQueryResult
    {
        public String id;
        public String url;
        public boolean hideUrl;
        public String title;
        public String description;
        public Thumbnail thumbnail;

        public InlineQueryResultArticle()
        {
        }

        public InlineQueryResultArticle(String id, String url, boolean hideUrl, String title,
                String description, Thumbnail thumbnail)
        {
            this.id = id;
            this.url = url;
            this.hideUrl = hideUrl;
            this.title = title;
            this.description = description;
            this.thumbnail = thumbnail;
        }

        public static final int CONSTRUCTOR = 206340825;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultContact extends InlineQueryResult
    {
        public String id;
        public Contact contact;
        public Thumbnail thumbnail;

        public InlineQueryResultContact()
        {
        }

        public InlineQueryResultContact(String id, Contact contact, Thumbnail thumbnail)
        {
            this.id = id;
            this.contact = contact;
            this.thumbnail = thumbnail;
        }

        public static final int CONSTRUCTOR = -181960174;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultLocation extends InlineQueryResult
    {
        public String id;
        public Location location;
        public String title;
        public Thumbnail thumbnail;

        public InlineQueryResultLocation()
        {
        }

        public InlineQueryResultLocation(String id, Location location, String title,
                Thumbnail thumbnail)
        {
            this.id = id;
            this.location = location;
            this.title = title;
            this.thumbnail = thumbnail;
        }

        public static final int CONSTRUCTOR = 466004752;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultVenue extends InlineQueryResult
    {
        public String id;
        public Venue venue;
        public Thumbnail thumbnail;

        public InlineQueryResultVenue()
        {
        }

        public InlineQueryResultVenue(String id, Venue venue, Thumbnail thumbnail)
        {
            this.id = id;
            this.venue = venue;
            this.thumbnail = thumbnail;
        }

        public static final int CONSTRUCTOR = 1281036382;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultGame extends InlineQueryResult
    {
        public String id;
        public Game game;

        public InlineQueryResultGame()
        {
        }

        public InlineQueryResultGame(String id, Game game)
        {
            this.id = id;
            this.game = game;
        }

        public static final int CONSTRUCTOR = 1706916987;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultAnimation extends InlineQueryResult
    {
        public String id;
        public Animation animation;
        public String title;

        public InlineQueryResultAnimation()
        {
        }

        public InlineQueryResultAnimation(String id, Animation animation, String title)
        {
            this.id = id;
            this.animation = animation;
            this.title = title;
        }

        public static final int CONSTRUCTOR = 2009984267;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultAudio extends InlineQueryResult
    {
        public String id;
        public Audio audio;

        public InlineQueryResultAudio()
        {
        }

        public InlineQueryResultAudio(String id, Audio audio)
        {
            this.id = id;
            this.audio = audio;
        }

        public static final int CONSTRUCTOR = 842650360;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultDocument extends InlineQueryResult
    {
        public String id;
        public Document document;
        public String title;
        public String description;

        public InlineQueryResultDocument()
        {
        }

        public InlineQueryResultDocument(String id, Document document, String title,
                String description)
        {
            this.id = id;
            this.document = document;
            this.title = title;
            this.description = description;
        }

        public static final int CONSTRUCTOR = -1491268539;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultPhoto extends InlineQueryResult
    {
        public String id;
        public Photo photo;
        public String title;
        public String description;

        public InlineQueryResultPhoto()
        {
        }

        public InlineQueryResultPhoto(String id, Photo photo, String title, String description)
        {
            this.id = id;
            this.photo = photo;
            this.title = title;
            this.description = description;
        }

        public static final int CONSTRUCTOR = 1848319440;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultSticker extends InlineQueryResult
    {
        public String id;
        public Sticker sticker;

        public InlineQueryResultSticker()
        {
        }

        public InlineQueryResultSticker(String id, Sticker sticker)
        {
            this.id = id;
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = -1848224245;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultVideo extends InlineQueryResult
    {
        public String id;
        public Video video;
        public String title;
        public String description;

        public InlineQueryResultVideo()
        {
        }

        public InlineQueryResultVideo(String id, Video video, String title, String description)
        {
            this.id = id;
            this.video = video;
            this.title = title;
            this.description = description;
        }

        public static final int CONSTRUCTOR = -1373158683;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResultVoiceNote extends InlineQueryResult
    {
        public String id;
        public VoiceNote voiceNote;
        public String title;

        public InlineQueryResultVoiceNote()
        {
        }

        public InlineQueryResultVoiceNote(String id, VoiceNote voiceNote, String title)
        {
            this.id = id;
            this.voiceNote = voiceNote;
            this.title = title;
        }

        public static final int CONSTRUCTOR = -1897393105;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InlineQueryResults extends Object
    {
        public long inlineQueryId;
        public String nextOffset;
        public InlineQueryResult[] results;
        public String switchPmText;
        public String switchPmParameter;

        public InlineQueryResults()
        {
        }

        public InlineQueryResults(long inlineQueryId, String nextOffset,
                InlineQueryResult[] results, String switchPmText, String switchPmParameter)
        {
            this.inlineQueryId = inlineQueryId;
            this.nextOffset = nextOffset;
            this.results = results;
            this.switchPmText = switchPmText;
            this.switchPmParameter = switchPmParameter;
        }

        public static final int CONSTRUCTOR = 1000709656;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InputBackground extends Object
    {
    }

    public static class InputBackgroundLocal extends InputBackground
    {
        public InputFile background;

        public InputBackgroundLocal()
        {
        }

        public InputBackgroundLocal(InputFile background)
        {
            this.background = background;
        }

        public static final int CONSTRUCTOR = -1747094364;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputBackgroundRemote extends InputBackground
    {
        public long backgroundId;

        public InputBackgroundRemote()
        {
        }

        public InputBackgroundRemote(long backgroundId)
        {
            this.backgroundId = backgroundId;
        }

        public static final int CONSTRUCTOR = -274976231;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InputChatPhoto extends Object
    {
    }

    public static class InputChatPhotoPrevious extends InputChatPhoto
    {
        public long chatPhotoId;

        public InputChatPhotoPrevious()
        {
        }

        public InputChatPhotoPrevious(long chatPhotoId)
        {
            this.chatPhotoId = chatPhotoId;
        }

        public static final int CONSTRUCTOR = 23128529;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputChatPhotoStatic extends InputChatPhoto
    {
        public InputFile photo;

        public InputChatPhotoStatic()
        {
        }

        public InputChatPhotoStatic(InputFile photo)
        {
            this.photo = photo;
        }

        public static final int CONSTRUCTOR = 1979179699;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputChatPhotoAnimation extends InputChatPhoto
    {
        public InputFile animation;
        public double mainFrameTimestamp;

        public InputChatPhotoAnimation()
        {
        }

        public InputChatPhotoAnimation(InputFile animation, double mainFrameTimestamp)
        {
            this.animation = animation;
            this.mainFrameTimestamp = mainFrameTimestamp;
        }

        public static final int CONSTRUCTOR = 90846242;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InputCredentials extends Object
    {
    }

    public static class InputCredentialsSaved extends InputCredentials
    {
        public String savedCredentialsId;

        public InputCredentialsSaved()
        {
        }

        public InputCredentialsSaved(String savedCredentialsId)
        {
            this.savedCredentialsId = savedCredentialsId;
        }

        public static final int CONSTRUCTOR = -2034385364;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputCredentialsNew extends InputCredentials
    {
        public String data;
        public boolean allowSave;

        public InputCredentialsNew()
        {
        }

        public InputCredentialsNew(String data, boolean allowSave)
        {
            this.data = data;
            this.allowSave = allowSave;
        }

        public static final int CONSTRUCTOR = -829689558;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputCredentialsApplePay extends InputCredentials
    {
        public String data;

        public InputCredentialsApplePay()
        {
        }

        public InputCredentialsApplePay(String data)
        {
            this.data = data;
        }

        public static final int CONSTRUCTOR = -1246570799;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputCredentialsGooglePay extends InputCredentials
    {
        public String data;

        public InputCredentialsGooglePay()
        {
        }

        public InputCredentialsGooglePay(String data)
        {
            this.data = data;
        }

        public static final int CONSTRUCTOR = 844384100;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InputFile extends Object
    {
    }

    public static class InputFileId extends InputFile
    {
        public int id;

        public InputFileId()
        {
        }

        public InputFileId(int id)
        {
            this.id = id;
        }

        public static final int CONSTRUCTOR = 1788906253;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputFileRemote extends InputFile
    {
        public String id;

        public InputFileRemote()
        {
        }

        public InputFileRemote(String id)
        {
            this.id = id;
        }

        public static final int CONSTRUCTOR = -107574466;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputFileLocal extends InputFile
    {
        public String path;

        public InputFileLocal()
        {
        }

        public InputFileLocal(String path)
        {
            this.path = path;
        }

        public static final int CONSTRUCTOR = 2056030919;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputFileGenerated extends InputFile
    {
        public String originalPath;
        public String conversion;
        public int expectedSize;

        public InputFileGenerated()
        {
        }

        public InputFileGenerated(String originalPath, String conversion, int expectedSize)
        {
            this.originalPath = originalPath;
            this.conversion = conversion;
            this.expectedSize = expectedSize;
        }

        public static final int CONSTRUCTOR = -1781351885;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputIdentityDocument extends Object
    {
        public String number;
        public Date expiryDate;
        public InputFile frontSide;
        public InputFile reverseSide;
        public InputFile selfie;
        public InputFile[] translation;

        public InputIdentityDocument()
        {
        }

        public InputIdentityDocument(String number, Date expiryDate, InputFile frontSide,
                InputFile reverseSide, InputFile selfie, InputFile[] translation)
        {
            this.number = number;
            this.expiryDate = expiryDate;
            this.frontSide = frontSide;
            this.reverseSide = reverseSide;
            this.selfie = selfie;
            this.translation = translation;
        }

        public static final int CONSTRUCTOR = -381776063;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InputInlineQueryResult extends Object
    {
    }

    public static class InputInlineQueryResultAnimation extends InputInlineQueryResult
    {
        public String id;
        public String title;
        public String thumbnailUrl;
        public String thumbnailMimeType;
        public String videoUrl;
        public String videoMimeType;
        public int videoDuration;
        public int videoWidth;
        public int videoHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultAnimation()
        {
        }

        public InputInlineQueryResultAnimation(String id, String title, String thumbnailUrl,
                String thumbnailMimeType, String videoUrl, String videoMimeType, int videoDuration,
                int videoWidth, int videoHeight, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.title = title;
            this.thumbnailUrl = thumbnailUrl;
            this.thumbnailMimeType = thumbnailMimeType;
            this.videoUrl = videoUrl;
            this.videoMimeType = videoMimeType;
            this.videoDuration = videoDuration;
            this.videoWidth = videoWidth;
            this.videoHeight = videoHeight;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = -1489808874;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultArticle extends InputInlineQueryResult
    {
        public String id;
        public String url;
        public boolean hideUrl;
        public String title;
        public String description;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultArticle()
        {
        }

        public InputInlineQueryResultArticle(String id, String url, boolean hideUrl, String title,
                String description, String thumbnailUrl, int thumbnailWidth, int thumbnailHeight,
                ReplyMarkup replyMarkup, InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.url = url;
            this.hideUrl = hideUrl;
            this.title = title;
            this.description = description;
            this.thumbnailUrl = thumbnailUrl;
            this.thumbnailWidth = thumbnailWidth;
            this.thumbnailHeight = thumbnailHeight;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 1973670156;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultAudio extends InputInlineQueryResult
    {
        public String id;
        public String title;
        public String performer;
        public String audioUrl;
        public int audioDuration;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultAudio()
        {
        }

        public InputInlineQueryResultAudio(String id, String title, String performer,
                String audioUrl, int audioDuration, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.title = title;
            this.performer = performer;
            this.audioUrl = audioUrl;
            this.audioDuration = audioDuration;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 1260139988;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultContact extends InputInlineQueryResult
    {
        public String id;
        public Contact contact;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultContact()
        {
        }

        public InputInlineQueryResultContact(String id, Contact contact, String thumbnailUrl,
                int thumbnailWidth, int thumbnailHeight, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.contact = contact;
            this.thumbnailUrl = thumbnailUrl;
            this.thumbnailWidth = thumbnailWidth;
            this.thumbnailHeight = thumbnailHeight;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 1846064594;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultDocument extends InputInlineQueryResult
    {
        public String id;
        public String title;
        public String description;
        public String documentUrl;
        public String mimeType;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultDocument()
        {
        }

        public InputInlineQueryResultDocument(String id, String title, String description,
                String documentUrl, String mimeType, String thumbnailUrl, int thumbnailWidth,
                int thumbnailHeight, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.title = title;
            this.description = description;
            this.documentUrl = documentUrl;
            this.mimeType = mimeType;
            this.thumbnailUrl = thumbnailUrl;
            this.thumbnailWidth = thumbnailWidth;
            this.thumbnailHeight = thumbnailHeight;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 578801869;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultGame extends InputInlineQueryResult
    {
        public String id;
        public String gameShortName;
        public ReplyMarkup replyMarkup;

        public InputInlineQueryResultGame()
        {
        }

        public InputInlineQueryResultGame(String id, String gameShortName, ReplyMarkup replyMarkup)
        {
            this.id = id;
            this.gameShortName = gameShortName;
            this.replyMarkup = replyMarkup;
        }

        public static final int CONSTRUCTOR = 966074327;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultLocation extends InputInlineQueryResult
    {
        public String id;
        public Location location;
        public int livePeriod;
        public String title;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultLocation()
        {
        }

        public InputInlineQueryResultLocation(String id, Location location, int livePeriod,
                String title, String thumbnailUrl, int thumbnailWidth, int thumbnailHeight,
                ReplyMarkup replyMarkup, InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.location = location;
            this.livePeriod = livePeriod;
            this.title = title;
            this.thumbnailUrl = thumbnailUrl;
            this.thumbnailWidth = thumbnailWidth;
            this.thumbnailHeight = thumbnailHeight;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = -1887650218;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultPhoto extends InputInlineQueryResult
    {
        public String id;
        public String title;
        public String description;
        public String thumbnailUrl;
        public String photoUrl;
        public int photoWidth;
        public int photoHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultPhoto()
        {
        }

        public InputInlineQueryResultPhoto(String id, String title, String description,
                String thumbnailUrl, String photoUrl, int photoWidth, int photoHeight,
                ReplyMarkup replyMarkup, InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.title = title;
            this.description = description;
            this.thumbnailUrl = thumbnailUrl;
            this.photoUrl = photoUrl;
            this.photoWidth = photoWidth;
            this.photoHeight = photoHeight;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = -1123338721;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultSticker extends InputInlineQueryResult
    {
        public String id;
        public String thumbnailUrl;
        public String stickerUrl;
        public int stickerWidth;
        public int stickerHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultSticker()
        {
        }

        public InputInlineQueryResultSticker(String id, String thumbnailUrl, String stickerUrl,
                int stickerWidth, int stickerHeight, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.thumbnailUrl = thumbnailUrl;
            this.stickerUrl = stickerUrl;
            this.stickerWidth = stickerWidth;
            this.stickerHeight = stickerHeight;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 274007129;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultVenue extends InputInlineQueryResult
    {
        public String id;
        public Venue venue;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultVenue()
        {
        }

        public InputInlineQueryResultVenue(String id, Venue venue, String thumbnailUrl,
                int thumbnailWidth, int thumbnailHeight, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.venue = venue;
            this.thumbnailUrl = thumbnailUrl;
            this.thumbnailWidth = thumbnailWidth;
            this.thumbnailHeight = thumbnailHeight;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 541704509;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultVideo extends InputInlineQueryResult
    {
        public String id;
        public String title;
        public String description;
        public String thumbnailUrl;
        public String videoUrl;
        public String mimeType;
        public int videoWidth;
        public int videoHeight;
        public int videoDuration;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultVideo()
        {
        }

        public InputInlineQueryResultVideo(String id, String title, String description,
                String thumbnailUrl, String videoUrl, String mimeType, int videoWidth,
                int videoHeight, int videoDuration, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.title = title;
            this.description = description;
            this.thumbnailUrl = thumbnailUrl;
            this.videoUrl = videoUrl;
            this.mimeType = mimeType;
            this.videoWidth = videoWidth;
            this.videoHeight = videoHeight;
            this.videoDuration = videoDuration;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 1724073191;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputInlineQueryResultVoiceNote extends InputInlineQueryResult
    {
        public String id;
        public String title;
        public String voiceNoteUrl;
        public int voiceNoteDuration;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public InputInlineQueryResultVoiceNote()
        {
        }

        public InputInlineQueryResultVoiceNote(String id, String title, String voiceNoteUrl,
                int voiceNoteDuration, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.id = id;
            this.title = title;
            this.voiceNoteUrl = voiceNoteUrl;
            this.voiceNoteDuration = voiceNoteDuration;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = -1790072503;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InputMessageContent extends Object
    {
    }

    public static class InputMessageText extends InputMessageContent
    {
        public FormattedText text;
        public boolean disableWebPagePreview;
        public boolean clearDraft;

        public InputMessageText()
        {
        }

        public InputMessageText(FormattedText text, boolean disableWebPagePreview,
                boolean clearDraft)
        {
            this.text = text;
            this.disableWebPagePreview = disableWebPagePreview;
            this.clearDraft = clearDraft;
        }

        public static final int CONSTRUCTOR = 247050392;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageAnimation extends InputMessageContent
    {
        public InputFile animation;
        public InputThumbnail thumbnail;
        public int[] addedStickerFileIds;
        public int duration;
        public int width;
        public int height;
        public FormattedText caption;

        public InputMessageAnimation()
        {
        }

        public InputMessageAnimation(InputFile animation, InputThumbnail thumbnail,
                int[] addedStickerFileIds, int duration, int width, int height,
                FormattedText caption)
        {
            this.animation = animation;
            this.thumbnail = thumbnail;
            this.addedStickerFileIds = addedStickerFileIds;
            this.duration = duration;
            this.width = width;
            this.height = height;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 1208433535;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageAudio extends InputMessageContent
    {
        public InputFile audio;
        public InputThumbnail albumCoverThumbnail;
        public int duration;
        public String title;
        public String performer;
        public FormattedText caption;

        public InputMessageAudio()
        {
        }

        public InputMessageAudio(InputFile audio, InputThumbnail albumCoverThumbnail, int duration,
                String title, String performer, FormattedText caption)
        {
            this.audio = audio;
            this.albumCoverThumbnail = albumCoverThumbnail;
            this.duration = duration;
            this.title = title;
            this.performer = performer;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = -626786126;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageDocument extends InputMessageContent
    {
        public InputFile document;
        public InputThumbnail thumbnail;
        public boolean disableContentTypeDetection;
        public FormattedText caption;

        public InputMessageDocument()
        {
        }

        public InputMessageDocument(InputFile document, InputThumbnail thumbnail,
                boolean disableContentTypeDetection, FormattedText caption)
        {
            this.document = document;
            this.thumbnail = thumbnail;
            this.disableContentTypeDetection = disableContentTypeDetection;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 1633383097;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessagePhoto extends InputMessageContent
    {
        public InputFile photo;
        public InputThumbnail thumbnail;
        public int[] addedStickerFileIds;
        public int width;
        public int height;
        public FormattedText caption;
        public int ttl;

        public InputMessagePhoto()
        {
        }

        public InputMessagePhoto(InputFile photo, InputThumbnail thumbnail,
                int[] addedStickerFileIds, int width, int height, FormattedText caption, int ttl)
        {
            this.photo = photo;
            this.thumbnail = thumbnail;
            this.addedStickerFileIds = addedStickerFileIds;
            this.width = width;
            this.height = height;
            this.caption = caption;
            this.ttl = ttl;
        }

        public static final int CONSTRUCTOR = 1648801584;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageSticker extends InputMessageContent
    {
        public InputFile sticker;
        public InputThumbnail thumbnail;
        public int width;
        public int height;
        public String emoji;

        public InputMessageSticker()
        {
        }

        public InputMessageSticker(InputFile sticker, InputThumbnail thumbnail, int width,
                int height, String emoji)
        {
            this.sticker = sticker;
            this.thumbnail = thumbnail;
            this.width = width;
            this.height = height;
            this.emoji = emoji;
        }

        public static final int CONSTRUCTOR = 1072805625;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageVideo extends InputMessageContent
    {
        public InputFile video;
        public InputThumbnail thumbnail;
        public int[] addedStickerFileIds;
        public int duration;
        public int width;
        public int height;
        public boolean supportsStreaming;
        public FormattedText caption;
        public int ttl;

        public InputMessageVideo()
        {
        }

        public InputMessageVideo(InputFile video, InputThumbnail thumbnail,
                int[] addedStickerFileIds, int duration, int width, int height,
                boolean supportsStreaming, FormattedText caption, int ttl)
        {
            this.video = video;
            this.thumbnail = thumbnail;
            this.addedStickerFileIds = addedStickerFileIds;
            this.duration = duration;
            this.width = width;
            this.height = height;
            this.supportsStreaming = supportsStreaming;
            this.caption = caption;
            this.ttl = ttl;
        }

        public static final int CONSTRUCTOR = -2108486755;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageVideoNote extends InputMessageContent
    {
        public InputFile videoNote;
        public InputThumbnail thumbnail;
        public int duration;
        public int length;

        public InputMessageVideoNote()
        {
        }

        public InputMessageVideoNote(InputFile videoNote, InputThumbnail thumbnail, int duration,
                int length)
        {
            this.videoNote = videoNote;
            this.thumbnail = thumbnail;
            this.duration = duration;
            this.length = length;
        }

        public static final int CONSTRUCTOR = 279108859;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageVoiceNote extends InputMessageContent
    {
        public InputFile voiceNote;
        public int duration;
        public byte[] waveform;
        public FormattedText caption;

        public InputMessageVoiceNote()
        {
        }

        public InputMessageVoiceNote(InputFile voiceNote, int duration, byte[] waveform,
                FormattedText caption)
        {
            this.voiceNote = voiceNote;
            this.duration = duration;
            this.waveform = waveform;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 2136519657;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageLocation extends InputMessageContent
    {
        public Location location;
        public int livePeriod;
        public int heading;
        public int proximityAlertRadius;

        public InputMessageLocation()
        {
        }

        public InputMessageLocation(Location location, int livePeriod, int heading,
                int proximityAlertRadius)
        {
            this.location = location;
            this.livePeriod = livePeriod;
            this.heading = heading;
            this.proximityAlertRadius = proximityAlertRadius;
        }

        public static final int CONSTRUCTOR = 648735088;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageVenue extends InputMessageContent
    {
        public Venue venue;

        public InputMessageVenue()
        {
        }

        public InputMessageVenue(Venue venue)
        {
            this.venue = venue;
        }

        public static final int CONSTRUCTOR = 1447926269;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageContact extends InputMessageContent
    {
        public Contact contact;

        public InputMessageContact()
        {
        }

        public InputMessageContact(Contact contact)
        {
            this.contact = contact;
        }

        public static final int CONSTRUCTOR = -982446849;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageDice extends InputMessageContent
    {
        public String emoji;
        public boolean clearDraft;

        public InputMessageDice()
        {
        }

        public InputMessageDice(String emoji, boolean clearDraft)
        {
            this.emoji = emoji;
            this.clearDraft = clearDraft;
        }

        public static final int CONSTRUCTOR = 841574313;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageGame extends InputMessageContent
    {
        public long botUserId;
        public String gameShortName;

        public InputMessageGame()
        {
        }

        public InputMessageGame(long botUserId, String gameShortName)
        {
            this.botUserId = botUserId;
            this.gameShortName = gameShortName;
        }

        public static final int CONSTRUCTOR = 1252944610;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageInvoice extends InputMessageContent
    {
        public Invoice invoice;
        public String title;
        public String description;
        public String photoUrl;
        public int photoSize;
        public int photoWidth;
        public int photoHeight;
        public byte[] payload;
        public String providerToken;
        public String providerData;
        public String startParameter;

        public InputMessageInvoice()
        {
        }

        public InputMessageInvoice(Invoice invoice, String title, String description,
                String photoUrl, int photoSize, int photoWidth, int photoHeight, byte[] payload,
                String providerToken, String providerData, String startParameter)
        {
            this.invoice = invoice;
            this.title = title;
            this.description = description;
            this.photoUrl = photoUrl;
            this.photoSize = photoSize;
            this.photoWidth = photoWidth;
            this.photoHeight = photoHeight;
            this.payload = payload;
            this.providerToken = providerToken;
            this.providerData = providerData;
            this.startParameter = startParameter;
        }

        public static final int CONSTRUCTOR = 1038812175;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessagePoll extends InputMessageContent
    {
        public String question;
        public String[] options;
        public boolean isAnonymous;
        public PollType type;
        public int openPeriod;
        public int closeDate;
        public boolean isClosed;

        public InputMessagePoll()
        {
        }

        public InputMessagePoll(String question, String[] options, boolean isAnonymous,
                PollType type, int openPeriod, int closeDate, boolean isClosed)
        {
            this.question = question;
            this.options = options;
            this.isAnonymous = isAnonymous;
            this.type = type;
            this.openPeriod = openPeriod;
            this.closeDate = closeDate;
            this.isClosed = isClosed;
        }

        public static final int CONSTRUCTOR = 2054629900;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputMessageForwarded extends InputMessageContent
    {
        public long fromChatId;
        public long messageId;
        public boolean inGameShare;
        public MessageCopyOptions copyOptions;

        public InputMessageForwarded()
        {
        }

        public InputMessageForwarded(long fromChatId, long messageId, boolean inGameShare,
                MessageCopyOptions copyOptions)
        {
            this.fromChatId = fromChatId;
            this.messageId = messageId;
            this.inGameShare = inGameShare;
            this.copyOptions = copyOptions;
        }

        public static final int CONSTRUCTOR = 1696232440;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InputPassportElement extends Object
    {
    }

    public static class InputPassportElementPersonalDetails extends InputPassportElement
    {
        public PersonalDetails personalDetails;

        public InputPassportElementPersonalDetails()
        {
        }

        public InputPassportElementPersonalDetails(PersonalDetails personalDetails)
        {
            this.personalDetails = personalDetails;
        }

        public static final int CONSTRUCTOR = 164791359;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementPassport extends InputPassportElement
    {
        public InputIdentityDocument passport;

        public InputPassportElementPassport()
        {
        }

        public InputPassportElementPassport(InputIdentityDocument passport)
        {
            this.passport = passport;
        }

        public static final int CONSTRUCTOR = -497011356;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementDriverLicense extends InputPassportElement
    {
        public InputIdentityDocument driverLicense;

        public InputPassportElementDriverLicense()
        {
        }

        public InputPassportElementDriverLicense(InputIdentityDocument driverLicense)
        {
            this.driverLicense = driverLicense;
        }

        public static final int CONSTRUCTOR = 304813264;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementIdentityCard extends InputPassportElement
    {
        public InputIdentityDocument identityCard;

        public InputPassportElementIdentityCard()
        {
        }

        public InputPassportElementIdentityCard(InputIdentityDocument identityCard)
        {
            this.identityCard = identityCard;
        }

        public static final int CONSTRUCTOR = -9963390;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementInternalPassport extends InputPassportElement
    {
        public InputIdentityDocument internalPassport;

        public InputPassportElementInternalPassport()
        {
        }

        public InputPassportElementInternalPassport(InputIdentityDocument internalPassport)
        {
            this.internalPassport = internalPassport;
        }

        public static final int CONSTRUCTOR = 715360043;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementAddress extends InputPassportElement
    {
        public Address address;

        public InputPassportElementAddress()
        {
        }

        public InputPassportElementAddress(Address address)
        {
            this.address = address;
        }

        public static final int CONSTRUCTOR = 461630480;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementUtilityBill extends InputPassportElement
    {
        public InputPersonalDocument utilityBill;

        public InputPassportElementUtilityBill()
        {
        }

        public InputPassportElementUtilityBill(InputPersonalDocument utilityBill)
        {
            this.utilityBill = utilityBill;
        }

        public static final int CONSTRUCTOR = 1389203841;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementBankStatement extends InputPassportElement
    {
        public InputPersonalDocument bankStatement;

        public InputPassportElementBankStatement()
        {
        }

        public InputPassportElementBankStatement(InputPersonalDocument bankStatement)
        {
            this.bankStatement = bankStatement;
        }

        public static final int CONSTRUCTOR = -26585208;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementRentalAgreement extends InputPassportElement
    {
        public InputPersonalDocument rentalAgreement;

        public InputPassportElementRentalAgreement()
        {
        }

        public InputPassportElementRentalAgreement(InputPersonalDocument rentalAgreement)
        {
            this.rentalAgreement = rentalAgreement;
        }

        public static final int CONSTRUCTOR = 1736154155;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementPassportRegistration extends InputPassportElement
    {
        public InputPersonalDocument passportRegistration;

        public InputPassportElementPassportRegistration()
        {
        }

        public InputPassportElementPassportRegistration(InputPersonalDocument passportRegistration)
        {
            this.passportRegistration = passportRegistration;
        }

        public static final int CONSTRUCTOR = 1314562128;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementTemporaryRegistration extends InputPassportElement
    {
        public InputPersonalDocument temporaryRegistration;

        public InputPassportElementTemporaryRegistration()
        {
        }

        public InputPassportElementTemporaryRegistration(
                InputPersonalDocument temporaryRegistration)
        {
            this.temporaryRegistration = temporaryRegistration;
        }

        public static final int CONSTRUCTOR = -1913238047;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementPhoneNumber extends InputPassportElement
    {
        public String phoneNumber;

        public InputPassportElementPhoneNumber()
        {
        }

        public InputPassportElementPhoneNumber(String phoneNumber)
        {
            this.phoneNumber = phoneNumber;
        }

        public static final int CONSTRUCTOR = 1319357497;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementEmailAddress extends InputPassportElement
    {
        public String emailAddress;

        public InputPassportElementEmailAddress()
        {
        }

        public InputPassportElementEmailAddress(String emailAddress)
        {
            this.emailAddress = emailAddress;
        }

        public static final int CONSTRUCTOR = -248605659;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementError extends Object
    {
        public PassportElementType type;
        public String message;
        public InputPassportElementErrorSource source;

        public InputPassportElementError()
        {
        }

        public InputPassportElementError(PassportElementType type, String message,
                InputPassportElementErrorSource source)
        {
            this.type = type;
            this.message = message;
            this.source = source;
        }

        public static final int CONSTRUCTOR = 285756898;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InputPassportElementErrorSource extends Object
    {
    }

    public static class InputPassportElementErrorSourceUnspecified
            extends InputPassportElementErrorSource
    {
        public byte[] elementHash;

        public InputPassportElementErrorSourceUnspecified()
        {
        }

        public InputPassportElementErrorSourceUnspecified(byte[] elementHash)
        {
            this.elementHash = elementHash;
        }

        public static final int CONSTRUCTOR = 267230319;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementErrorSourceDataField
            extends InputPassportElementErrorSource
    {
        public String fieldName;
        public byte[] dataHash;

        public InputPassportElementErrorSourceDataField()
        {
        }

        public InputPassportElementErrorSourceDataField(String fieldName, byte[] dataHash)
        {
            this.fieldName = fieldName;
            this.dataHash = dataHash;
        }

        public static final int CONSTRUCTOR = -426795002;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementErrorSourceFrontSide
            extends InputPassportElementErrorSource
    {
        public byte[] fileHash;

        public InputPassportElementErrorSourceFrontSide()
        {
        }

        public InputPassportElementErrorSourceFrontSide(byte[] fileHash)
        {
            this.fileHash = fileHash;
        }

        public static final int CONSTRUCTOR = 588023741;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementErrorSourceReverseSide
            extends InputPassportElementErrorSource
    {
        public byte[] fileHash;

        public InputPassportElementErrorSourceReverseSide()
        {
        }

        public InputPassportElementErrorSourceReverseSide(byte[] fileHash)
        {
            this.fileHash = fileHash;
        }

        public static final int CONSTRUCTOR = 413072891;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementErrorSourceSelfie
            extends InputPassportElementErrorSource
    {
        public byte[] fileHash;

        public InputPassportElementErrorSourceSelfie()
        {
        }

        public InputPassportElementErrorSourceSelfie(byte[] fileHash)
        {
            this.fileHash = fileHash;
        }

        public static final int CONSTRUCTOR = -773575528;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementErrorSourceTranslationFile
            extends InputPassportElementErrorSource
    {
        public byte[] fileHash;

        public InputPassportElementErrorSourceTranslationFile()
        {
        }

        public InputPassportElementErrorSourceTranslationFile(byte[] fileHash)
        {
            this.fileHash = fileHash;
        }

        public static final int CONSTRUCTOR = 505842299;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementErrorSourceTranslationFiles
            extends InputPassportElementErrorSource
    {
        public byte[][] fileHashes;

        public InputPassportElementErrorSourceTranslationFiles()
        {
        }

        public InputPassportElementErrorSourceTranslationFiles(byte[][] fileHashes)
        {
            this.fileHashes = fileHashes;
        }

        public static final int CONSTRUCTOR = -527254048;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementErrorSourceFile extends InputPassportElementErrorSource
    {
        public byte[] fileHash;

        public InputPassportElementErrorSourceFile()
        {
        }

        public InputPassportElementErrorSourceFile(byte[] fileHash)
        {
            this.fileHash = fileHash;
        }

        public static final int CONSTRUCTOR = -298492469;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPassportElementErrorSourceFiles extends InputPassportElementErrorSource
    {
        public byte[][] fileHashes;

        public InputPassportElementErrorSourceFiles()
        {
        }

        public InputPassportElementErrorSourceFiles(byte[][] fileHashes)
        {
            this.fileHashes = fileHashes;
        }

        public static final int CONSTRUCTOR = -2008541640;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputPersonalDocument extends Object
    {
        public InputFile[] files;
        public InputFile[] translation;

        public InputPersonalDocument()
        {
        }

        public InputPersonalDocument(InputFile[] files, InputFile[] translation)
        {
            this.files = files;
            this.translation = translation;
        }

        public static final int CONSTRUCTOR = 1676966826;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InputSticker extends Object
    {
    }

    public static class InputStickerStatic extends InputSticker
    {
        public InputFile sticker;
        public String emojis;
        public MaskPosition maskPosition;

        public InputStickerStatic()
        {
        }

        public InputStickerStatic(InputFile sticker, String emojis, MaskPosition maskPosition)
        {
            this.sticker = sticker;
            this.emojis = emojis;
            this.maskPosition = maskPosition;
        }

        public static final int CONSTRUCTOR = 1409680603;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputStickerAnimated extends InputSticker
    {
        public InputFile sticker;
        public String emojis;

        public InputStickerAnimated()
        {
        }

        public InputStickerAnimated(InputFile sticker, String emojis)
        {
            this.sticker = sticker;
            this.emojis = emojis;
        }

        public static final int CONSTRUCTOR = -1127265952;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InputThumbnail extends Object
    {
        public InputFile thumbnail;
        public int width;
        public int height;

        public InputThumbnail()
        {
        }

        public InputThumbnail(InputFile thumbnail, int width, int height)
        {
            this.thumbnail = thumbnail;
            this.width = width;
            this.height = height;
        }

        public static final int CONSTRUCTOR = 1582387236;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class InternalLinkType extends Object
    {
    }

    public static class InternalLinkTypeActiveSessions extends InternalLinkType
    {

        public InternalLinkTypeActiveSessions()
        {
        }

        public static final int CONSTRUCTOR = 1886108589;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeAuthenticationCode extends InternalLinkType
    {
        public String code;

        public InternalLinkTypeAuthenticationCode()
        {
        }

        public InternalLinkTypeAuthenticationCode(String code)
        {
            this.code = code;
        }

        public static final int CONSTRUCTOR = -209235982;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeBackground extends InternalLinkType
    {
        public String backgroundName;

        public InternalLinkTypeBackground()
        {
        }

        public InternalLinkTypeBackground(String backgroundName)
        {
            this.backgroundName = backgroundName;
        }

        public static final int CONSTRUCTOR = 185411848;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeBotStart extends InternalLinkType
    {
        public String botUsername;
        public String startParameter;

        public InternalLinkTypeBotStart()
        {
        }

        public InternalLinkTypeBotStart(String botUsername, String startParameter)
        {
            this.botUsername = botUsername;
            this.startParameter = startParameter;
        }

        public static final int CONSTRUCTOR = -1206724291;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeBotStartInGroup extends InternalLinkType
    {
        public String botUsername;
        public String startParameter;

        public InternalLinkTypeBotStartInGroup()
        {
        }

        public InternalLinkTypeBotStartInGroup(String botUsername, String startParameter)
        {
            this.botUsername = botUsername;
            this.startParameter = startParameter;
        }

        public static final int CONSTRUCTOR = -1040096100;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeChangePhoneNumber extends InternalLinkType
    {

        public InternalLinkTypeChangePhoneNumber()
        {
        }

        public static final int CONSTRUCTOR = -265856255;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeChatInvite extends InternalLinkType
    {
        public String inviteLink;

        public InternalLinkTypeChatInvite()
        {
        }

        public InternalLinkTypeChatInvite(String inviteLink)
        {
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = 428621017;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeFilterSettings extends InternalLinkType
    {

        public InternalLinkTypeFilterSettings()
        {
        }

        public static final int CONSTRUCTOR = 1501632411;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeGame extends InternalLinkType
    {
        public String botUsername;
        public String gameShortName;

        public InternalLinkTypeGame()
        {
        }

        public InternalLinkTypeGame(String botUsername, String gameShortName)
        {
            this.botUsername = botUsername;
            this.gameShortName = gameShortName;
        }

        public static final int CONSTRUCTOR = -260788787;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeLanguagePack extends InternalLinkType
    {
        public String languagePackId;

        public InternalLinkTypeLanguagePack()
        {
        }

        public InternalLinkTypeLanguagePack(String languagePackId)
        {
            this.languagePackId = languagePackId;
        }

        public static final int CONSTRUCTOR = -1450766996;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeMessage extends InternalLinkType
    {
        public String url;

        public InternalLinkTypeMessage()
        {
        }

        public InternalLinkTypeMessage(String url)
        {
            this.url = url;
        }

        public static final int CONSTRUCTOR = 978541650;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeMessageDraft extends InternalLinkType
    {
        public FormattedText text;
        public boolean containsLink;

        public InternalLinkTypeMessageDraft()
        {
        }

        public InternalLinkTypeMessageDraft(FormattedText text, boolean containsLink)
        {
            this.text = text;
            this.containsLink = containsLink;
        }

        public static final int CONSTRUCTOR = 661633749;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypePassportDataRequest extends InternalLinkType
    {
        public long botUserId;
        public String scope;
        public String publicKey;
        public String nonce;
        public String callbackUrl;

        public InternalLinkTypePassportDataRequest()
        {
        }

        public InternalLinkTypePassportDataRequest(long botUserId, String scope, String publicKey,
                String nonce, String callbackUrl)
        {
            this.botUserId = botUserId;
            this.scope = scope;
            this.publicKey = publicKey;
            this.nonce = nonce;
            this.callbackUrl = callbackUrl;
        }

        public static final int CONSTRUCTOR = -988819839;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypePhoneNumberConfirmation extends InternalLinkType
    {
        public String hash;
        public String phoneNumber;

        public InternalLinkTypePhoneNumberConfirmation()
        {
        }

        public InternalLinkTypePhoneNumberConfirmation(String hash, String phoneNumber)
        {
            this.hash = hash;
            this.phoneNumber = phoneNumber;
        }

        public static final int CONSTRUCTOR = 1757375254;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeProxy extends InternalLinkType
    {
        public String server;
        public int port;
        public ProxyType type;

        public InternalLinkTypeProxy()
        {
        }

        public InternalLinkTypeProxy(String server, int port, ProxyType type)
        {
            this.server = server;
            this.port = port;
            this.type = type;
        }

        public static final int CONSTRUCTOR = -1313788694;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypePublicChat extends InternalLinkType
    {
        public String chatUsername;

        public InternalLinkTypePublicChat()
        {
        }

        public InternalLinkTypePublicChat(String chatUsername)
        {
            this.chatUsername = chatUsername;
        }

        public static final int CONSTRUCTOR = -1485547717;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeQrCodeAuthentication extends InternalLinkType
    {

        public InternalLinkTypeQrCodeAuthentication()
        {
        }

        public static final int CONSTRUCTOR = -1089332956;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeSettings extends InternalLinkType
    {

        public InternalLinkTypeSettings()
        {
        }

        public static final int CONSTRUCTOR = 393561524;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeStickerSet extends InternalLinkType
    {
        public String stickerSetName;

        public InternalLinkTypeStickerSet()
        {
        }

        public InternalLinkTypeStickerSet(String stickerSetName)
        {
            this.stickerSetName = stickerSetName;
        }

        public static final int CONSTRUCTOR = -529639751;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeTheme extends InternalLinkType
    {
        public String themeName;

        public InternalLinkTypeTheme()
        {
        }

        public InternalLinkTypeTheme(String themeName)
        {
            this.themeName = themeName;
        }

        public static final int CONSTRUCTOR = -200935417;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeThemeSettings extends InternalLinkType
    {

        public InternalLinkTypeThemeSettings()
        {
        }

        public static final int CONSTRUCTOR = -1051903722;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeUnknownDeepLink extends InternalLinkType
    {
        public String link;

        public InternalLinkTypeUnknownDeepLink()
        {
        }

        public InternalLinkTypeUnknownDeepLink(String link)
        {
            this.link = link;
        }

        public static final int CONSTRUCTOR = 625596379;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeUnsupportedProxy extends InternalLinkType
    {

        public InternalLinkTypeUnsupportedProxy()
        {
        }

        public static final int CONSTRUCTOR = -566649079;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InternalLinkTypeVideoChat extends InternalLinkType
    {
        public String chatUsername;
        public String inviteHash;
        public boolean isLiveStream;

        public InternalLinkTypeVideoChat()
        {
        }

        public InternalLinkTypeVideoChat(String chatUsername, String inviteHash,
                boolean isLiveStream)
        {
            this.chatUsername = chatUsername;
            this.inviteHash = inviteHash;
            this.isLiveStream = isLiveStream;
        }

        public static final int CONSTRUCTOR = -2020149068;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Invoice extends Object
    {
        public String currency;
        public LabeledPricePart[] priceParts;
        public long maxTipAmount;
        public long[] suggestedTipAmounts;
        public boolean isTest;
        public boolean needName;
        public boolean needPhoneNumber;
        public boolean needEmailAddress;
        public boolean needShippingAddress;
        public boolean sendPhoneNumberToProvider;
        public boolean sendEmailAddressToProvider;
        public boolean isFlexible;

        public Invoice()
        {
        }

        public Invoice(String currency, LabeledPricePart[] priceParts, long maxTipAmount,
                long[] suggestedTipAmounts, boolean isTest, boolean needName,
                boolean needPhoneNumber, boolean needEmailAddress, boolean needShippingAddress,
                boolean sendPhoneNumberToProvider, boolean sendEmailAddressToProvider,
                boolean isFlexible)
        {
            this.currency = currency;
            this.priceParts = priceParts;
            this.maxTipAmount = maxTipAmount;
            this.suggestedTipAmounts = suggestedTipAmounts;
            this.isTest = isTest;
            this.needName = needName;
            this.needPhoneNumber = needPhoneNumber;
            this.needEmailAddress = needEmailAddress;
            this.needShippingAddress = needShippingAddress;
            this.sendPhoneNumberToProvider = sendPhoneNumberToProvider;
            this.sendEmailAddressToProvider = sendEmailAddressToProvider;
            this.isFlexible = isFlexible;
        }

        public static final int CONSTRUCTOR = 1479250728;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class JsonObjectMember extends Object
    {
        public String key;
        public JsonValue value;

        public JsonObjectMember()
        {
        }

        public JsonObjectMember(String key, JsonValue value)
        {
            this.key = key;
            this.value = value;
        }

        public static final int CONSTRUCTOR = -1803309418;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class JsonValue extends Object
    {
    }

    public static class JsonValueNull extends JsonValue
    {

        public JsonValueNull()
        {
        }

        public static final int CONSTRUCTOR = -92872499;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class JsonValueBoolean extends JsonValue
    {
        public boolean value;

        public JsonValueBoolean()
        {
        }

        public JsonValueBoolean(boolean value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = -2142186576;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class JsonValueNumber extends JsonValue
    {
        public double value;

        public JsonValueNumber()
        {
        }

        public JsonValueNumber(double value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = -1010822033;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class JsonValueString extends JsonValue
    {
        public String value;

        public JsonValueString()
        {
        }

        public JsonValueString(String value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = 1597947313;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class JsonValueArray extends JsonValue
    {
        public JsonValue[] values;

        public JsonValueArray()
        {
        }

        public JsonValueArray(JsonValue[] values)
        {
            this.values = values;
        }

        public static final int CONSTRUCTOR = -183913546;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class JsonValueObject extends JsonValue
    {
        public JsonObjectMember[] members;

        public JsonValueObject()
        {
        }

        public JsonValueObject(JsonObjectMember[] members)
        {
            this.members = members;
        }

        public static final int CONSTRUCTOR = 520252026;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class KeyboardButton extends Object
    {
        public String text;
        public KeyboardButtonType type;

        public KeyboardButton()
        {
        }

        public KeyboardButton(String text, KeyboardButtonType type)
        {
            this.text = text;
            this.type = type;
        }

        public static final int CONSTRUCTOR = -2069836172;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class KeyboardButtonType extends Object
    {
    }

    public static class KeyboardButtonTypeText extends KeyboardButtonType
    {

        public KeyboardButtonTypeText()
        {
        }

        public static final int CONSTRUCTOR = -1773037256;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class KeyboardButtonTypeRequestPhoneNumber extends KeyboardButtonType
    {

        public KeyboardButtonTypeRequestPhoneNumber()
        {
        }

        public static final int CONSTRUCTOR = -1529235527;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class KeyboardButtonTypeRequestLocation extends KeyboardButtonType
    {

        public KeyboardButtonTypeRequestLocation()
        {
        }

        public static final int CONSTRUCTOR = -125661955;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class KeyboardButtonTypeRequestPoll extends KeyboardButtonType
    {
        public boolean forceRegular;
        public boolean forceQuiz;

        public KeyboardButtonTypeRequestPoll()
        {
        }

        public KeyboardButtonTypeRequestPoll(boolean forceRegular, boolean forceQuiz)
        {
            this.forceRegular = forceRegular;
            this.forceQuiz = forceQuiz;
        }

        public static final int CONSTRUCTOR = 1902435512;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LabeledPricePart extends Object
    {
        public String label;
        public long amount;

        public LabeledPricePart()
        {
        }

        public LabeledPricePart(String label, long amount)
        {
            this.label = label;
            this.amount = amount;
        }

        public static final int CONSTRUCTOR = 552789798;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LanguagePackInfo extends Object
    {
        public String id;
        public String baseLanguagePackId;
        public String name;
        public String nativeName;
        public String pluralCode;
        public boolean isOfficial;
        public boolean isRtl;
        public boolean isBeta;
        public boolean isInstalled;
        public int totalStringCount;
        public int translatedStringCount;
        public int localStringCount;
        public String translationUrl;

        public LanguagePackInfo()
        {
        }

        public LanguagePackInfo(String id, String baseLanguagePackId, String name,
                String nativeName, String pluralCode, boolean isOfficial, boolean isRtl,
                boolean isBeta, boolean isInstalled, int totalStringCount,
                int translatedStringCount, int localStringCount, String translationUrl)
        {
            this.id = id;
            this.baseLanguagePackId = baseLanguagePackId;
            this.name = name;
            this.nativeName = nativeName;
            this.pluralCode = pluralCode;
            this.isOfficial = isOfficial;
            this.isRtl = isRtl;
            this.isBeta = isBeta;
            this.isInstalled = isInstalled;
            this.totalStringCount = totalStringCount;
            this.translatedStringCount = translatedStringCount;
            this.localStringCount = localStringCount;
            this.translationUrl = translationUrl;
        }

        public static final int CONSTRUCTOR = 542199642;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LanguagePackString extends Object
    {
        public String key;
        public LanguagePackStringValue value;

        public LanguagePackString()
        {
        }

        public LanguagePackString(String key, LanguagePackStringValue value)
        {
            this.key = key;
            this.value = value;
        }

        public static final int CONSTRUCTOR = 1307632736;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class LanguagePackStringValue extends Object
    {
    }

    public static class LanguagePackStringValueOrdinary extends LanguagePackStringValue
    {
        public String value;

        public LanguagePackStringValueOrdinary()
        {
        }

        public LanguagePackStringValueOrdinary(String value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = -249256352;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LanguagePackStringValuePluralized extends LanguagePackStringValue
    {
        public String zeroValue;
        public String oneValue;
        public String twoValue;
        public String fewValue;
        public String manyValue;
        public String otherValue;

        public LanguagePackStringValuePluralized()
        {
        }

        public LanguagePackStringValuePluralized(String zeroValue, String oneValue, String twoValue,
                String fewValue, String manyValue, String otherValue)
        {
            this.zeroValue = zeroValue;
            this.oneValue = oneValue;
            this.twoValue = twoValue;
            this.fewValue = fewValue;
            this.manyValue = manyValue;
            this.otherValue = otherValue;
        }

        public static final int CONSTRUCTOR = 1906840261;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LanguagePackStringValueDeleted extends LanguagePackStringValue
    {

        public LanguagePackStringValueDeleted()
        {
        }

        public static final int CONSTRUCTOR = 1834792698;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LanguagePackStrings extends Object
    {
        public LanguagePackString[] strings;

        public LanguagePackStrings()
        {
        }

        public LanguagePackStrings(LanguagePackString[] strings)
        {
            this.strings = strings;
        }

        public static final int CONSTRUCTOR = 1172082922;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LocalFile extends Object
    {
        public String path;
        public boolean canBeDownloaded;
        public boolean canBeDeleted;
        public boolean isDownloadingActive;
        public boolean isDownloadingCompleted;
        public int downloadOffset;
        public int downloadedPrefixSize;
        public int downloadedSize;

        public LocalFile()
        {
        }

        public LocalFile(String path, boolean canBeDownloaded, boolean canBeDeleted,
                boolean isDownloadingActive, boolean isDownloadingCompleted, int downloadOffset,
                int downloadedPrefixSize, int downloadedSize)
        {
            this.path = path;
            this.canBeDownloaded = canBeDownloaded;
            this.canBeDeleted = canBeDeleted;
            this.isDownloadingActive = isDownloadingActive;
            this.isDownloadingCompleted = isDownloadingCompleted;
            this.downloadOffset = downloadOffset;
            this.downloadedPrefixSize = downloadedPrefixSize;
            this.downloadedSize = downloadedSize;
        }

        public static final int CONSTRUCTOR = -1166400317;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LocalizationTargetInfo extends Object
    {
        public LanguagePackInfo[] languagePacks;

        public LocalizationTargetInfo()
        {
        }

        public LocalizationTargetInfo(LanguagePackInfo[] languagePacks)
        {
            this.languagePacks = languagePacks;
        }

        public static final int CONSTRUCTOR = -2048670809;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Location extends Object
    {
        public double latitude;
        public double longitude;
        public double horizontalAccuracy;

        public Location()
        {
        }

        public Location(double latitude, double longitude, double horizontalAccuracy)
        {
            this.latitude = latitude;
            this.longitude = longitude;
            this.horizontalAccuracy = horizontalAccuracy;
        }

        public static final int CONSTRUCTOR = -443392141;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class LogStream extends Object
    {
    }

    public static class LogStreamDefault extends LogStream
    {

        public LogStreamDefault()
        {
        }

        public static final int CONSTRUCTOR = 1390581436;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LogStreamFile extends LogStream
    {
        public String path;
        public long maxFileSize;
        public boolean redirectStderr;

        public LogStreamFile()
        {
        }

        public LogStreamFile(String path, long maxFileSize, boolean redirectStderr)
        {
            this.path = path;
            this.maxFileSize = maxFileSize;
            this.redirectStderr = redirectStderr;
        }

        public static final int CONSTRUCTOR = 1532136933;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LogStreamEmpty extends LogStream
    {

        public LogStreamEmpty()
        {
        }

        public static final int CONSTRUCTOR = -499912244;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LogTags extends Object
    {
        public String[] tags;

        public LogTags()
        {
        }

        public LogTags(String[] tags)
        {
            this.tags = tags;
        }

        public static final int CONSTRUCTOR = -1604930601;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LogVerbosityLevel extends Object
    {
        public int verbosityLevel;

        public LogVerbosityLevel()
        {
        }

        public LogVerbosityLevel(int verbosityLevel)
        {
            this.verbosityLevel = verbosityLevel;
        }

        public static final int CONSTRUCTOR = 1734624234;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class LoginUrlInfo extends Object
    {
    }

    public static class LoginUrlInfoOpen extends LoginUrlInfo
    {
        public String url;
        public boolean skipConfirm;

        public LoginUrlInfoOpen()
        {
        }

        public LoginUrlInfoOpen(String url, boolean skipConfirm)
        {
            this.url = url;
            this.skipConfirm = skipConfirm;
        }

        public static final int CONSTRUCTOR = -1079045420;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LoginUrlInfoRequestConfirmation extends LoginUrlInfo
    {
        public String url;
        public String domain;
        public long botUserId;
        public boolean requestWriteAccess;

        public LoginUrlInfoRequestConfirmation()
        {
        }

        public LoginUrlInfoRequestConfirmation(String url, String domain, long botUserId,
                boolean requestWriteAccess)
        {
            this.url = url;
            this.domain = domain;
            this.botUserId = botUserId;
            this.requestWriteAccess = requestWriteAccess;
        }

        public static final int CONSTRUCTOR = 2128290863;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class MaskPoint extends Object
    {
    }

    public static class MaskPointForehead extends MaskPoint
    {

        public MaskPointForehead()
        {
        }

        public static final int CONSTRUCTOR = 1027512005;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MaskPointEyes extends MaskPoint
    {

        public MaskPointEyes()
        {
        }

        public static final int CONSTRUCTOR = 1748310861;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MaskPointMouth extends MaskPoint
    {

        public MaskPointMouth()
        {
        }

        public static final int CONSTRUCTOR = 411773406;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MaskPointChin extends MaskPoint
    {

        public MaskPointChin()
        {
        }

        public static final int CONSTRUCTOR = 534995335;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MaskPosition extends Object
    {
        public MaskPoint point;
        public double xShift;
        public double yShift;
        public double scale;

        public MaskPosition()
        {
        }

        public MaskPosition(MaskPoint point, double xShift, double yShift, double scale)
        {
            this.point = point;
            this.xShift = xShift;
            this.yShift = yShift;
            this.scale = scale;
        }

        public static final int CONSTRUCTOR = -2097433026;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Message extends Object
    {
        public long id;
        public MessageSender senderId;
        public long chatId;
        public MessageSendingState sendingState;
        public MessageSchedulingState schedulingState;
        public boolean isOutgoing;
        public boolean isPinned;
        public boolean canBeEdited;
        public boolean canBeForwarded;
        public boolean canBeSaved;
        public boolean canBeDeletedOnlyForSelf;
        public boolean canBeDeletedForAllUsers;
        public boolean canGetStatistics;
        public boolean canGetMessageThread;
        public boolean canGetViewers;
        public boolean canGetMediaTimestampLinks;
        public boolean hasTimestampedMedia;
        public boolean isChannelPost;
        public boolean containsUnreadMention;
        public int date;
        public int editDate;
        public MessageForwardInfo forwardInfo;
        public MessageInteractionInfo interactionInfo;
        public long replyInChatId;
        public long replyToMessageId;
        public long messageThreadId;
        public int ttl;
        public double ttlExpiresIn;
        public long viaBotUserId;
        public String authorSignature;
        public long mediaAlbumId;
        public String restrictionReason;
        public MessageContent content;
        public ReplyMarkup replyMarkup;

        public Message()
        {
        }

        public Message(long id, MessageSender senderId, long chatId,
                MessageSendingState sendingState, MessageSchedulingState schedulingState,
                boolean isOutgoing, boolean isPinned, boolean canBeEdited, boolean canBeForwarded,
                boolean canBeSaved, boolean canBeDeletedOnlyForSelf,
                boolean canBeDeletedForAllUsers, boolean canGetStatistics,
                boolean canGetMessageThread, boolean canGetViewers,
                boolean canGetMediaTimestampLinks, boolean hasTimestampedMedia,
                boolean isChannelPost, boolean containsUnreadMention, int date, int editDate,
                MessageForwardInfo forwardInfo, MessageInteractionInfo interactionInfo,
                long replyInChatId, long replyToMessageId, long messageThreadId, int ttl,
                double ttlExpiresIn, long viaBotUserId, String authorSignature, long mediaAlbumId,
                String restrictionReason, MessageContent content, ReplyMarkup replyMarkup)
        {
            this.id = id;
            this.senderId = senderId;
            this.chatId = chatId;
            this.sendingState = sendingState;
            this.schedulingState = schedulingState;
            this.isOutgoing = isOutgoing;
            this.isPinned = isPinned;
            this.canBeEdited = canBeEdited;
            this.canBeForwarded = canBeForwarded;
            this.canBeSaved = canBeSaved;
            this.canBeDeletedOnlyForSelf = canBeDeletedOnlyForSelf;
            this.canBeDeletedForAllUsers = canBeDeletedForAllUsers;
            this.canGetStatistics = canGetStatistics;
            this.canGetMessageThread = canGetMessageThread;
            this.canGetViewers = canGetViewers;
            this.canGetMediaTimestampLinks = canGetMediaTimestampLinks;
            this.hasTimestampedMedia = hasTimestampedMedia;
            this.isChannelPost = isChannelPost;
            this.containsUnreadMention = containsUnreadMention;
            this.date = date;
            this.editDate = editDate;
            this.forwardInfo = forwardInfo;
            this.interactionInfo = interactionInfo;
            this.replyInChatId = replyInChatId;
            this.replyToMessageId = replyToMessageId;
            this.messageThreadId = messageThreadId;
            this.ttl = ttl;
            this.ttlExpiresIn = ttlExpiresIn;
            this.viaBotUserId = viaBotUserId;
            this.authorSignature = authorSignature;
            this.mediaAlbumId = mediaAlbumId;
            this.restrictionReason = restrictionReason;
            this.content = content;
            this.replyMarkup = replyMarkup;
        }

        public static final int CONSTRUCTOR = -961280585;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageCalendar extends Object
    {
        public int totalCount;
        public MessageCalendarDay[] days;

        public MessageCalendar()
        {
        }

        public MessageCalendar(int totalCount, MessageCalendarDay[] days)
        {
            this.totalCount = totalCount;
            this.days = days;
        }

        public static final int CONSTRUCTOR = -1682890519;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageCalendarDay extends Object
    {
        public int totalCount;
        public Message message;

        public MessageCalendarDay()
        {
        }

        public MessageCalendarDay(int totalCount, Message message)
        {
            this.totalCount = totalCount;
            this.message = message;
        }

        public static final int CONSTRUCTOR = -376467614;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class MessageContent extends Object
    {
    }

    public static class MessageText extends MessageContent
    {
        public FormattedText text;
        public WebPage webPage;

        public MessageText()
        {
        }

        public MessageText(FormattedText text, WebPage webPage)
        {
            this.text = text;
            this.webPage = webPage;
        }

        public static final int CONSTRUCTOR = 1989037971;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageAnimation extends MessageContent
    {
        public Animation animation;
        public FormattedText caption;
        public boolean isSecret;

        public MessageAnimation()
        {
        }

        public MessageAnimation(Animation animation, FormattedText caption, boolean isSecret)
        {
            this.animation = animation;
            this.caption = caption;
            this.isSecret = isSecret;
        }

        public static final int CONSTRUCTOR = 1306939396;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageAudio extends MessageContent
    {
        public Audio audio;
        public FormattedText caption;

        public MessageAudio()
        {
        }

        public MessageAudio(Audio audio, FormattedText caption)
        {
            this.audio = audio;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 276722716;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageDocument extends MessageContent
    {
        public Document document;
        public FormattedText caption;

        public MessageDocument()
        {
        }

        public MessageDocument(Document document, FormattedText caption)
        {
            this.document = document;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 596945783;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessagePhoto extends MessageContent
    {
        public Photo photo;
        public FormattedText caption;
        public boolean isSecret;

        public MessagePhoto()
        {
        }

        public MessagePhoto(Photo photo, FormattedText caption, boolean isSecret)
        {
            this.photo = photo;
            this.caption = caption;
            this.isSecret = isSecret;
        }

        public static final int CONSTRUCTOR = -1851395174;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageExpiredPhoto extends MessageContent
    {

        public MessageExpiredPhoto()
        {
        }

        public static final int CONSTRUCTOR = -1404641801;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageSticker extends MessageContent
    {
        public Sticker sticker;

        public MessageSticker()
        {
        }

        public MessageSticker(Sticker sticker)
        {
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = 1779022878;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageVideo extends MessageContent
    {
        public Video video;
        public FormattedText caption;
        public boolean isSecret;

        public MessageVideo()
        {
        }

        public MessageVideo(Video video, FormattedText caption, boolean isSecret)
        {
            this.video = video;
            this.caption = caption;
            this.isSecret = isSecret;
        }

        public static final int CONSTRUCTOR = 2021281344;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageExpiredVideo extends MessageContent
    {

        public MessageExpiredVideo()
        {
        }

        public static final int CONSTRUCTOR = -1212209981;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageVideoNote extends MessageContent
    {
        public VideoNote videoNote;
        public boolean isViewed;
        public boolean isSecret;

        public MessageVideoNote()
        {
        }

        public MessageVideoNote(VideoNote videoNote, boolean isViewed, boolean isSecret)
        {
            this.videoNote = videoNote;
            this.isViewed = isViewed;
            this.isSecret = isSecret;
        }

        public static final int CONSTRUCTOR = 963323014;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageVoiceNote extends MessageContent
    {
        public VoiceNote voiceNote;
        public FormattedText caption;
        public boolean isListened;

        public MessageVoiceNote()
        {
        }

        public MessageVoiceNote(VoiceNote voiceNote, FormattedText caption, boolean isListened)
        {
            this.voiceNote = voiceNote;
            this.caption = caption;
            this.isListened = isListened;
        }

        public static final int CONSTRUCTOR = 527777781;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageLocation extends MessageContent
    {
        public Location location;
        public int livePeriod;
        public int expiresIn;
        public int heading;
        public int proximityAlertRadius;

        public MessageLocation()
        {
        }

        public MessageLocation(Location location, int livePeriod, int expiresIn, int heading,
                int proximityAlertRadius)
        {
            this.location = location;
            this.livePeriod = livePeriod;
            this.expiresIn = expiresIn;
            this.heading = heading;
            this.proximityAlertRadius = proximityAlertRadius;
        }

        public static final int CONSTRUCTOR = 303973492;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageVenue extends MessageContent
    {
        public Venue venue;

        public MessageVenue()
        {
        }

        public MessageVenue(Venue venue)
        {
            this.venue = venue;
        }

        public static final int CONSTRUCTOR = -2146492043;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageContact extends MessageContent
    {
        public Contact contact;

        public MessageContact()
        {
        }

        public MessageContact(Contact contact)
        {
            this.contact = contact;
        }

        public static final int CONSTRUCTOR = -512684966;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageAnimatedEmoji extends MessageContent
    {
        public AnimatedEmoji animatedEmoji;
        public String emoji;

        public MessageAnimatedEmoji()
        {
        }

        public MessageAnimatedEmoji(AnimatedEmoji animatedEmoji, String emoji)
        {
            this.animatedEmoji = animatedEmoji;
            this.emoji = emoji;
        }

        public static final int CONSTRUCTOR = 908195298;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageDice extends MessageContent
    {
        public DiceStickers initialState;
        public DiceStickers finalState;
        public String emoji;
        public int value;
        public int successAnimationFrameNumber;

        public MessageDice()
        {
        }

        public MessageDice(DiceStickers initialState, DiceStickers finalState, String emoji,
                int value, int successAnimationFrameNumber)
        {
            this.initialState = initialState;
            this.finalState = finalState;
            this.emoji = emoji;
            this.value = value;
            this.successAnimationFrameNumber = successAnimationFrameNumber;
        }

        public static final int CONSTRUCTOR = 1115779641;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageGame extends MessageContent
    {
        public Game game;

        public MessageGame()
        {
        }

        public MessageGame(Game game)
        {
            this.game = game;
        }

        public static final int CONSTRUCTOR = -69441162;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessagePoll extends MessageContent
    {
        public Poll poll;

        public MessagePoll()
        {
        }

        public MessagePoll(Poll poll)
        {
            this.poll = poll;
        }

        public static final int CONSTRUCTOR = -662130099;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageInvoice extends MessageContent
    {
        public String title;
        public String description;
        public Photo photo;
        public String currency;
        public long totalAmount;
        public String startParameter;
        public boolean isTest;
        public boolean needShippingAddress;
        public long receiptMessageId;

        public MessageInvoice()
        {
        }

        public MessageInvoice(String title, String description, Photo photo, String currency,
                long totalAmount, String startParameter, boolean isTest,
                boolean needShippingAddress, long receiptMessageId)
        {
            this.title = title;
            this.description = description;
            this.photo = photo;
            this.currency = currency;
            this.totalAmount = totalAmount;
            this.startParameter = startParameter;
            this.isTest = isTest;
            this.needShippingAddress = needShippingAddress;
            this.receiptMessageId = receiptMessageId;
        }

        public static final int CONSTRUCTOR = -1916671476;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageCall extends MessageContent
    {
        public boolean isVideo;
        public CallDiscardReason discardReason;
        public int duration;

        public MessageCall()
        {
        }

        public MessageCall(boolean isVideo, CallDiscardReason discardReason, int duration)
        {
            this.isVideo = isVideo;
            this.discardReason = discardReason;
            this.duration = duration;
        }

        public static final int CONSTRUCTOR = 538893824;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageVideoChatScheduled extends MessageContent
    {
        public int groupCallId;
        public int startDate;

        public MessageVideoChatScheduled()
        {
        }

        public MessageVideoChatScheduled(int groupCallId, int startDate)
        {
            this.groupCallId = groupCallId;
            this.startDate = startDate;
        }

        public static final int CONSTRUCTOR = -1855185481;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageVideoChatStarted extends MessageContent
    {
        public int groupCallId;

        public MessageVideoChatStarted()
        {
        }

        public MessageVideoChatStarted(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = 521225561;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageVideoChatEnded extends MessageContent
    {
        public int duration;

        public MessageVideoChatEnded()
        {
        }

        public MessageVideoChatEnded(int duration)
        {
            this.duration = duration;
        }

        public static final int CONSTRUCTOR = 2032544855;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageInviteVideoChatParticipants extends MessageContent
    {
        public int groupCallId;
        public long[] userIds;

        public MessageInviteVideoChatParticipants()
        {
        }

        public MessageInviteVideoChatParticipants(int groupCallId, long[] userIds)
        {
            this.groupCallId = groupCallId;
            this.userIds = userIds;
        }

        public static final int CONSTRUCTOR = -1459065585;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageBasicGroupChatCreate extends MessageContent
    {
        public String title;
        public long[] memberUserIds;

        public MessageBasicGroupChatCreate()
        {
        }

        public MessageBasicGroupChatCreate(String title, long[] memberUserIds)
        {
            this.title = title;
            this.memberUserIds = memberUserIds;
        }

        public static final int CONSTRUCTOR = 795404060;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageSupergroupChatCreate extends MessageContent
    {
        public String title;

        public MessageSupergroupChatCreate()
        {
        }

        public MessageSupergroupChatCreate(String title)
        {
            this.title = title;
        }

        public static final int CONSTRUCTOR = -434325733;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatChangeTitle extends MessageContent
    {
        public String title;

        public MessageChatChangeTitle()
        {
        }

        public MessageChatChangeTitle(String title)
        {
            this.title = title;
        }

        public static final int CONSTRUCTOR = 748272449;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatChangePhoto extends MessageContent
    {
        public ChatPhoto photo;

        public MessageChatChangePhoto()
        {
        }

        public MessageChatChangePhoto(ChatPhoto photo)
        {
            this.photo = photo;
        }

        public static final int CONSTRUCTOR = -813415093;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatDeletePhoto extends MessageContent
    {

        public MessageChatDeletePhoto()
        {
        }

        public static final int CONSTRUCTOR = -184374809;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatAddMembers extends MessageContent
    {
        public long[] memberUserIds;

        public MessageChatAddMembers()
        {
        }

        public MessageChatAddMembers(long[] memberUserIds)
        {
            this.memberUserIds = memberUserIds;
        }

        public static final int CONSTRUCTOR = 1701117908;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatJoinByLink extends MessageContent
    {

        public MessageChatJoinByLink()
        {
        }

        public static final int CONSTRUCTOR = 1846493311;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatJoinByRequest extends MessageContent
    {

        public MessageChatJoinByRequest()
        {
        }

        public static final int CONSTRUCTOR = 1195428732;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatDeleteMember extends MessageContent
    {
        public long userId;

        public MessageChatDeleteMember()
        {
        }

        public MessageChatDeleteMember(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = 938029481;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatUpgradeTo extends MessageContent
    {
        public long supergroupId;

        public MessageChatUpgradeTo()
        {
        }

        public MessageChatUpgradeTo(long supergroupId)
        {
            this.supergroupId = supergroupId;
        }

        public static final int CONSTRUCTOR = 104813723;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatUpgradeFrom extends MessageContent
    {
        public String title;
        public long basicGroupId;

        public MessageChatUpgradeFrom()
        {
        }

        public MessageChatUpgradeFrom(String title, long basicGroupId)
        {
            this.title = title;
            this.basicGroupId = basicGroupId;
        }

        public static final int CONSTRUCTOR = 325954268;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessagePinMessage extends MessageContent
    {
        public long messageId;

        public MessagePinMessage()
        {
        }

        public MessagePinMessage(long messageId)
        {
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = 953503801;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageScreenshotTaken extends MessageContent
    {

        public MessageScreenshotTaken()
        {
        }

        public static final int CONSTRUCTOR = -1564971605;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatSetTheme extends MessageContent
    {
        public String themeName;

        public MessageChatSetTheme()
        {
        }

        public MessageChatSetTheme(String themeName)
        {
            this.themeName = themeName;
        }

        public static final int CONSTRUCTOR = -1716612088;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageChatSetTtl extends MessageContent
    {
        public int ttl;

        public MessageChatSetTtl()
        {
        }

        public MessageChatSetTtl(int ttl)
        {
            this.ttl = ttl;
        }

        public static final int CONSTRUCTOR = 1810060209;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageCustomServiceAction extends MessageContent
    {
        public String text;

        public MessageCustomServiceAction()
        {
        }

        public MessageCustomServiceAction(String text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 1435879282;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageGameScore extends MessageContent
    {
        public long gameMessageId;
        public long gameId;
        public int score;

        public MessageGameScore()
        {
        }

        public MessageGameScore(long gameMessageId, long gameId, int score)
        {
            this.gameMessageId = gameMessageId;
            this.gameId = gameId;
            this.score = score;
        }

        public static final int CONSTRUCTOR = 1344904575;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessagePaymentSuccessful extends MessageContent
    {
        public long invoiceChatId;
        public long invoiceMessageId;
        public String currency;
        public long totalAmount;

        public MessagePaymentSuccessful()
        {
        }

        public MessagePaymentSuccessful(long invoiceChatId, long invoiceMessageId, String currency,
                long totalAmount)
        {
            this.invoiceChatId = invoiceChatId;
            this.invoiceMessageId = invoiceMessageId;
            this.currency = currency;
            this.totalAmount = totalAmount;
        }

        public static final int CONSTRUCTOR = 1442934098;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessagePaymentSuccessfulBot extends MessageContent
    {
        public String currency;
        public long totalAmount;
        public byte[] invoicePayload;
        public String shippingOptionId;
        public OrderInfo orderInfo;
        public String telegramPaymentChargeId;
        public String providerPaymentChargeId;

        public MessagePaymentSuccessfulBot()
        {
        }

        public MessagePaymentSuccessfulBot(String currency, long totalAmount, byte[] invoicePayload,
                String shippingOptionId, OrderInfo orderInfo, String telegramPaymentChargeId,
                String providerPaymentChargeId)
        {
            this.currency = currency;
            this.totalAmount = totalAmount;
            this.invoicePayload = invoicePayload;
            this.shippingOptionId = shippingOptionId;
            this.orderInfo = orderInfo;
            this.telegramPaymentChargeId = telegramPaymentChargeId;
            this.providerPaymentChargeId = providerPaymentChargeId;
        }

        public static final int CONSTRUCTOR = -438430050;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageContactRegistered extends MessageContent
    {

        public MessageContactRegistered()
        {
        }

        public static final int CONSTRUCTOR = -1502020353;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageWebsiteConnected extends MessageContent
    {
        public String domainName;

        public MessageWebsiteConnected()
        {
        }

        public MessageWebsiteConnected(String domainName)
        {
            this.domainName = domainName;
        }

        public static final int CONSTRUCTOR = -1074551800;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessagePassportDataSent extends MessageContent
    {
        public PassportElementType[] types;

        public MessagePassportDataSent()
        {
        }

        public MessagePassportDataSent(PassportElementType[] types)
        {
            this.types = types;
        }

        public static final int CONSTRUCTOR = 1017405171;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessagePassportDataReceived extends MessageContent
    {
        public EncryptedPassportElement[] elements;
        public EncryptedCredentials credentials;

        public MessagePassportDataReceived()
        {
        }

        public MessagePassportDataReceived(EncryptedPassportElement[] elements,
                EncryptedCredentials credentials)
        {
            this.elements = elements;
            this.credentials = credentials;
        }

        public static final int CONSTRUCTOR = -1367863624;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageProximityAlertTriggered extends MessageContent
    {
        public MessageSender travelerId;
        public MessageSender watcherId;
        public int distance;

        public MessageProximityAlertTriggered()
        {
        }

        public MessageProximityAlertTriggered(MessageSender travelerId, MessageSender watcherId,
                int distance)
        {
            this.travelerId = travelerId;
            this.watcherId = watcherId;
            this.distance = distance;
        }

        public static final int CONSTRUCTOR = 67761875;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageUnsupported extends MessageContent
    {

        public MessageUnsupported()
        {
        }

        public static final int CONSTRUCTOR = -1816726139;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageCopyOptions extends Object
    {
        public boolean sendCopy;
        public boolean replaceCaption;
        public FormattedText newCaption;

        public MessageCopyOptions()
        {
        }

        public MessageCopyOptions(boolean sendCopy, boolean replaceCaption,
                FormattedText newCaption)
        {
            this.sendCopy = sendCopy;
            this.replaceCaption = replaceCaption;
            this.newCaption = newCaption;
        }

        public static final int CONSTRUCTOR = 1208442937;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class MessageFileType extends Object
    {
    }

    public static class MessageFileTypePrivate extends MessageFileType
    {
        public String name;

        public MessageFileTypePrivate()
        {
        }

        public MessageFileTypePrivate(String name)
        {
            this.name = name;
        }

        public static final int CONSTRUCTOR = -521908524;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageFileTypeGroup extends MessageFileType
    {
        public String title;

        public MessageFileTypeGroup()
        {
        }

        public MessageFileTypeGroup(String title)
        {
            this.title = title;
        }

        public static final int CONSTRUCTOR = -219836568;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageFileTypeUnknown extends MessageFileType
    {

        public MessageFileTypeUnknown()
        {
        }

        public static final int CONSTRUCTOR = 1176353458;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageForwardInfo extends Object
    {
        public MessageForwardOrigin origin;
        public int date;
        public String publicServiceAnnouncementType;
        public long fromChatId;
        public long fromMessageId;

        public MessageForwardInfo()
        {
        }

        public MessageForwardInfo(MessageForwardOrigin origin, int date,
                String publicServiceAnnouncementType, long fromChatId, long fromMessageId)
        {
            this.origin = origin;
            this.date = date;
            this.publicServiceAnnouncementType = publicServiceAnnouncementType;
            this.fromChatId = fromChatId;
            this.fromMessageId = fromMessageId;
        }

        public static final int CONSTRUCTOR = -327300408;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class MessageForwardOrigin extends Object
    {
    }

    public static class MessageForwardOriginUser extends MessageForwardOrigin
    {
        public long senderUserId;

        public MessageForwardOriginUser()
        {
        }

        public MessageForwardOriginUser(long senderUserId)
        {
            this.senderUserId = senderUserId;
        }

        public static final int CONSTRUCTOR = -355174191;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageForwardOriginChat extends MessageForwardOrigin
    {
        public long senderChatId;
        public String authorSignature;

        public MessageForwardOriginChat()
        {
        }

        public MessageForwardOriginChat(long senderChatId, String authorSignature)
        {
            this.senderChatId = senderChatId;
            this.authorSignature = authorSignature;
        }

        public static final int CONSTRUCTOR = 1526010724;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageForwardOriginHiddenUser extends MessageForwardOrigin
    {
        public String senderName;

        public MessageForwardOriginHiddenUser()
        {
        }

        public MessageForwardOriginHiddenUser(String senderName)
        {
            this.senderName = senderName;
        }

        public static final int CONSTRUCTOR = -271257885;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageForwardOriginChannel extends MessageForwardOrigin
    {
        public long chatId;
        public long messageId;
        public String authorSignature;

        public MessageForwardOriginChannel()
        {
        }

        public MessageForwardOriginChannel(long chatId, long messageId, String authorSignature)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.authorSignature = authorSignature;
        }

        public static final int CONSTRUCTOR = 1490730723;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageForwardOriginMessageImport extends MessageForwardOrigin
    {
        public String senderName;

        public MessageForwardOriginMessageImport()
        {
        }

        public MessageForwardOriginMessageImport(String senderName)
        {
            this.senderName = senderName;
        }

        public static final int CONSTRUCTOR = -739561951;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageInteractionInfo extends Object
    {
        public int viewCount;
        public int forwardCount;
        public MessageReplyInfo replyInfo;

        public MessageInteractionInfo()
        {
        }

        public MessageInteractionInfo(int viewCount, int forwardCount, MessageReplyInfo replyInfo)
        {
            this.viewCount = viewCount;
            this.forwardCount = forwardCount;
            this.replyInfo = replyInfo;
        }

        public static final int CONSTRUCTOR = -620714966;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageLink extends Object
    {
        public String link;
        public boolean isPublic;

        public MessageLink()
        {
        }

        public MessageLink(String link, boolean isPublic)
        {
            this.link = link;
            this.isPublic = isPublic;
        }

        public static final int CONSTRUCTOR = -1354089818;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageLinkInfo extends Object
    {
        public boolean isPublic;
        public long chatId;
        public Message message;
        public int mediaTimestamp;
        public boolean forAlbum;
        public boolean forComment;

        public MessageLinkInfo()
        {
        }

        public MessageLinkInfo(boolean isPublic, long chatId, Message message, int mediaTimestamp,
                boolean forAlbum, boolean forComment)
        {
            this.isPublic = isPublic;
            this.chatId = chatId;
            this.message = message;
            this.mediaTimestamp = mediaTimestamp;
            this.forAlbum = forAlbum;
            this.forComment = forComment;
        }

        public static final int CONSTRUCTOR = -981646294;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessagePosition extends Object
    {
        public int position;
        public long messageId;
        public int date;

        public MessagePosition()
        {
        }

        public MessagePosition(int position, long messageId, int date)
        {
            this.position = position;
            this.messageId = messageId;
            this.date = date;
        }

        public static final int CONSTRUCTOR = 1292189935;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessagePositions extends Object
    {
        public int totalCount;
        public MessagePosition[] positions;

        public MessagePositions()
        {
        }

        public MessagePositions(int totalCount, MessagePosition[] positions)
        {
            this.totalCount = totalCount;
            this.positions = positions;
        }

        public static final int CONSTRUCTOR = -1930466649;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageReplyInfo extends Object
    {
        public int replyCount;
        public MessageSender[] recentReplierIds;
        public long lastReadInboxMessageId;
        public long lastReadOutboxMessageId;
        public long lastMessageId;

        public MessageReplyInfo()
        {
        }

        public MessageReplyInfo(int replyCount, MessageSender[] recentReplierIds,
                long lastReadInboxMessageId, long lastReadOutboxMessageId, long lastMessageId)
        {
            this.replyCount = replyCount;
            this.recentReplierIds = recentReplierIds;
            this.lastReadInboxMessageId = lastReadInboxMessageId;
            this.lastReadOutboxMessageId = lastReadOutboxMessageId;
            this.lastMessageId = lastMessageId;
        }

        public static final int CONSTRUCTOR = -2093702263;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class MessageSchedulingState extends Object
    {
    }

    public static class MessageSchedulingStateSendAtDate extends MessageSchedulingState
    {
        public int sendDate;

        public MessageSchedulingStateSendAtDate()
        {
        }

        public MessageSchedulingStateSendAtDate(int sendDate)
        {
            this.sendDate = sendDate;
        }

        public static final int CONSTRUCTOR = -1485570073;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageSchedulingStateSendWhenOnline extends MessageSchedulingState
    {

        public MessageSchedulingStateSendWhenOnline()
        {
        }

        public static final int CONSTRUCTOR = 2092947464;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageSendOptions extends Object
    {
        public boolean disableNotification;
        public boolean fromBackground;
        public MessageSchedulingState schedulingState;

        public MessageSendOptions()
        {
        }

        public MessageSendOptions(boolean disableNotification, boolean fromBackground,
                MessageSchedulingState schedulingState)
        {
            this.disableNotification = disableNotification;
            this.fromBackground = fromBackground;
            this.schedulingState = schedulingState;
        }

        public static final int CONSTRUCTOR = 914544314;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class MessageSender extends Object
    {
    }

    public static class MessageSenderUser extends MessageSender
    {
        public long userId;

        public MessageSenderUser()
        {
        }

        public MessageSenderUser(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = -336109341;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageSenderChat extends MessageSender
    {
        public long chatId;

        public MessageSenderChat()
        {
        }

        public MessageSenderChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -239660751;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageSenders extends Object
    {
        public int totalCount;
        public MessageSender[] senders;

        public MessageSenders()
        {
        }

        public MessageSenders(int totalCount, MessageSender[] senders)
        {
            this.totalCount = totalCount;
            this.senders = senders;
        }

        public static final int CONSTRUCTOR = -690158467;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class MessageSendingState extends Object
    {
    }

    public static class MessageSendingStatePending extends MessageSendingState
    {

        public MessageSendingStatePending()
        {
        }

        public static final int CONSTRUCTOR = -1381803582;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageSendingStateFailed extends MessageSendingState
    {
        public int errorCode;
        public String errorMessage;
        public boolean canRetry;
        public boolean needAnotherSender;
        public double retryAfter;

        public MessageSendingStateFailed()
        {
        }

        public MessageSendingStateFailed(int errorCode, String errorMessage, boolean canRetry,
                boolean needAnotherSender, double retryAfter)
        {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
            this.canRetry = canRetry;
            this.needAnotherSender = needAnotherSender;
            this.retryAfter = retryAfter;
        }

        public static final int CONSTRUCTOR = -1741887228;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageStatistics extends Object
    {
        public StatisticalGraph messageInteractionGraph;

        public MessageStatistics()
        {
        }

        public MessageStatistics(StatisticalGraph messageInteractionGraph)
        {
            this.messageInteractionGraph = messageInteractionGraph;
        }

        public static final int CONSTRUCTOR = -1011383888;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class MessageThreadInfo extends Object
    {
        public long chatId;
        public long messageThreadId;
        public MessageReplyInfo replyInfo;
        public int unreadMessageCount;
        public Message[] messages;
        public DraftMessage draftMessage;

        public MessageThreadInfo()
        {
        }

        public MessageThreadInfo(long chatId, long messageThreadId, MessageReplyInfo replyInfo,
                int unreadMessageCount, Message[] messages, DraftMessage draftMessage)
        {
            this.chatId = chatId;
            this.messageThreadId = messageThreadId;
            this.replyInfo = replyInfo;
            this.unreadMessageCount = unreadMessageCount;
            this.messages = messages;
            this.draftMessage = draftMessage;
        }

        public static final int CONSTRUCTOR = -248536056;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Messages extends Object
    {
        public int totalCount;
        public Message[] messages;

        public Messages()
        {
        }

        public Messages(int totalCount, Message[] messages)
        {
            this.totalCount = totalCount;
            this.messages = messages;
        }

        public static final int CONSTRUCTOR = -16498159;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Minithumbnail extends Object
    {
        public int width;
        public int height;
        public byte[] data;

        public Minithumbnail()
        {
        }

        public Minithumbnail(int width, int height, byte[] data)
        {
            this.width = width;
            this.height = height;
            this.data = data;
        }

        public static final int CONSTRUCTOR = -328540758;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NetworkStatistics extends Object
    {
        public int sinceDate;
        public NetworkStatisticsEntry[] entries;

        public NetworkStatistics()
        {
        }

        public NetworkStatistics(int sinceDate, NetworkStatisticsEntry[] entries)
        {
            this.sinceDate = sinceDate;
            this.entries = entries;
        }

        public static final int CONSTRUCTOR = 1615554212;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class NetworkStatisticsEntry extends Object
    {
    }

    public static class NetworkStatisticsEntryFile extends NetworkStatisticsEntry
    {
        public FileType fileType;
        public NetworkType networkType;
        public long sentBytes;
        public long receivedBytes;

        public NetworkStatisticsEntryFile()
        {
        }

        public NetworkStatisticsEntryFile(FileType fileType, NetworkType networkType,
                long sentBytes, long receivedBytes)
        {
            this.fileType = fileType;
            this.networkType = networkType;
            this.sentBytes = sentBytes;
            this.receivedBytes = receivedBytes;
        }

        public static final int CONSTRUCTOR = 188452706;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NetworkStatisticsEntryCall extends NetworkStatisticsEntry
    {
        public NetworkType networkType;
        public long sentBytes;
        public long receivedBytes;
        public double duration;

        public NetworkStatisticsEntryCall()
        {
        }

        public NetworkStatisticsEntryCall(NetworkType networkType, long sentBytes,
                long receivedBytes, double duration)
        {
            this.networkType = networkType;
            this.sentBytes = sentBytes;
            this.receivedBytes = receivedBytes;
            this.duration = duration;
        }

        public static final int CONSTRUCTOR = 737000365;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class NetworkType extends Object
    {
    }

    public static class NetworkTypeNone extends NetworkType
    {

        public NetworkTypeNone()
        {
        }

        public static final int CONSTRUCTOR = -1971691759;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NetworkTypeMobile extends NetworkType
    {

        public NetworkTypeMobile()
        {
        }

        public static final int CONSTRUCTOR = 819228239;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NetworkTypeMobileRoaming extends NetworkType
    {

        public NetworkTypeMobileRoaming()
        {
        }

        public static final int CONSTRUCTOR = -1435199760;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NetworkTypeWiFi extends NetworkType
    {

        public NetworkTypeWiFi()
        {
        }

        public static final int CONSTRUCTOR = -633872070;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NetworkTypeOther extends NetworkType
    {

        public NetworkTypeOther()
        {
        }

        public static final int CONSTRUCTOR = 1942128539;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Notification extends Object
    {
        public int id;
        public int date;
        public boolean isSilent;
        public NotificationType type;

        public Notification()
        {
        }

        public Notification(int id, int date, boolean isSilent, NotificationType type)
        {
            this.id = id;
            this.date = date;
            this.isSilent = isSilent;
            this.type = type;
        }

        public static final int CONSTRUCTOR = 788743120;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NotificationGroup extends Object
    {
        public int id;
        public NotificationGroupType type;
        public long chatId;
        public int totalCount;
        public Notification[] notifications;

        public NotificationGroup()
        {
        }

        public NotificationGroup(int id, NotificationGroupType type, long chatId, int totalCount,
                Notification[] notifications)
        {
            this.id = id;
            this.type = type;
            this.chatId = chatId;
            this.totalCount = totalCount;
            this.notifications = notifications;
        }

        public static final int CONSTRUCTOR = 780691541;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class NotificationGroupType extends Object
    {
    }

    public static class NotificationGroupTypeMessages extends NotificationGroupType
    {

        public NotificationGroupTypeMessages()
        {
        }

        public static final int CONSTRUCTOR = -1702481123;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NotificationGroupTypeMentions extends NotificationGroupType
    {

        public NotificationGroupTypeMentions()
        {
        }

        public static final int CONSTRUCTOR = -2050324051;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NotificationGroupTypeSecretChat extends NotificationGroupType
    {

        public NotificationGroupTypeSecretChat()
        {
        }

        public static final int CONSTRUCTOR = 1390759476;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NotificationGroupTypeCalls extends NotificationGroupType
    {

        public NotificationGroupTypeCalls()
        {
        }

        public static final int CONSTRUCTOR = 1379123538;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class NotificationSettingsScope extends Object
    {
    }

    public static class NotificationSettingsScopePrivateChats extends NotificationSettingsScope
    {

        public NotificationSettingsScopePrivateChats()
        {
        }

        public static final int CONSTRUCTOR = 937446759;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NotificationSettingsScopeGroupChats extends NotificationSettingsScope
    {

        public NotificationSettingsScopeGroupChats()
        {
        }

        public static final int CONSTRUCTOR = 1212142067;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NotificationSettingsScopeChannelChats extends NotificationSettingsScope
    {

        public NotificationSettingsScopeChannelChats()
        {
        }

        public static final int CONSTRUCTOR = 548013448;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class NotificationType extends Object
    {
    }

    public static class NotificationTypeNewMessage extends NotificationType
    {
        public Message message;

        public NotificationTypeNewMessage()
        {
        }

        public NotificationTypeNewMessage(Message message)
        {
            this.message = message;
        }

        public static final int CONSTRUCTOR = 1885935159;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NotificationTypeNewSecretChat extends NotificationType
    {

        public NotificationTypeNewSecretChat()
        {
        }

        public static final int CONSTRUCTOR = 1198638768;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NotificationTypeNewCall extends NotificationType
    {
        public int callId;

        public NotificationTypeNewCall()
        {
        }

        public NotificationTypeNewCall(int callId)
        {
            this.callId = callId;
        }

        public static final int CONSTRUCTOR = 1712734585;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class NotificationTypeNewPushMessage extends NotificationType
    {
        public long messageId;
        public MessageSender senderId;
        public String senderName;
        public boolean isOutgoing;
        public PushMessageContent content;

        public NotificationTypeNewPushMessage()
        {
        }

        public NotificationTypeNewPushMessage(long messageId, MessageSender senderId,
                String senderName, boolean isOutgoing, PushMessageContent content)
        {
            this.messageId = messageId;
            this.senderId = senderId;
            this.senderName = senderName;
            this.isOutgoing = isOutgoing;
            this.content = content;
        }

        public static final int CONSTRUCTOR = -711680462;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Ok extends Object
    {

        public Ok()
        {
        }

        public static final int CONSTRUCTOR = -722616727;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class OptionValue extends Object
    {
    }

    public static class OptionValueBoolean extends OptionValue
    {
        public boolean value;

        public OptionValueBoolean()
        {
        }

        public OptionValueBoolean(boolean value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = 63135518;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class OptionValueEmpty extends OptionValue
    {

        public OptionValueEmpty()
        {
        }

        public static final int CONSTRUCTOR = 918955155;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class OptionValueInteger extends OptionValue
    {
        public long value;

        public OptionValueInteger()
        {
        }

        public OptionValueInteger(long value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = -186858780;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class OptionValueString extends OptionValue
    {
        public String value;

        public OptionValueString()
        {
        }

        public OptionValueString(String value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = 756248212;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class OrderInfo extends Object
    {
        public String name;
        public String phoneNumber;
        public String emailAddress;
        public Address shippingAddress;

        public OrderInfo()
        {
        }

        public OrderInfo(String name, String phoneNumber, String emailAddress,
                Address shippingAddress)
        {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.shippingAddress = shippingAddress;
        }

        public static final int CONSTRUCTOR = 783997294;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class PageBlock extends Object
    {
    }

    public static class PageBlockTitle extends PageBlock
    {
        public RichText title;

        public PageBlockTitle()
        {
        }

        public PageBlockTitle(RichText title)
        {
            this.title = title;
        }

        public static final int CONSTRUCTOR = 1629664784;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockSubtitle extends PageBlock
    {
        public RichText subtitle;

        public PageBlockSubtitle()
        {
        }

        public PageBlockSubtitle(RichText subtitle)
        {
            this.subtitle = subtitle;
        }

        public static final int CONSTRUCTOR = 264524263;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockAuthorDate extends PageBlock
    {
        public RichText author;
        public int publishDate;

        public PageBlockAuthorDate()
        {
        }

        public PageBlockAuthorDate(RichText author, int publishDate)
        {
            this.author = author;
            this.publishDate = publishDate;
        }

        public static final int CONSTRUCTOR = 1300231184;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockHeader extends PageBlock
    {
        public RichText header;

        public PageBlockHeader()
        {
        }

        public PageBlockHeader(RichText header)
        {
            this.header = header;
        }

        public static final int CONSTRUCTOR = 1402854811;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockSubheader extends PageBlock
    {
        public RichText subheader;

        public PageBlockSubheader()
        {
        }

        public PageBlockSubheader(RichText subheader)
        {
            this.subheader = subheader;
        }

        public static final int CONSTRUCTOR = 1263956774;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockKicker extends PageBlock
    {
        public RichText kicker;

        public PageBlockKicker()
        {
        }

        public PageBlockKicker(RichText kicker)
        {
            this.kicker = kicker;
        }

        public static final int CONSTRUCTOR = 1361282635;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockParagraph extends PageBlock
    {
        public RichText text;

        public PageBlockParagraph()
        {
        }

        public PageBlockParagraph(RichText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 1182402406;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockPreformatted extends PageBlock
    {
        public RichText text;
        public String language;

        public PageBlockPreformatted()
        {
        }

        public PageBlockPreformatted(RichText text, String language)
        {
            this.text = text;
            this.language = language;
        }

        public static final int CONSTRUCTOR = -1066346178;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockFooter extends PageBlock
    {
        public RichText footer;

        public PageBlockFooter()
        {
        }

        public PageBlockFooter(RichText footer)
        {
            this.footer = footer;
        }

        public static final int CONSTRUCTOR = 886429480;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockDivider extends PageBlock
    {

        public PageBlockDivider()
        {
        }

        public static final int CONSTRUCTOR = -618614392;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockAnchor extends PageBlock
    {
        public String name;

        public PageBlockAnchor()
        {
        }

        public PageBlockAnchor(String name)
        {
            this.name = name;
        }

        public static final int CONSTRUCTOR = -837994576;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockList extends PageBlock
    {
        public PageBlockListItem[] items;

        public PageBlockList()
        {
        }

        public PageBlockList(PageBlockListItem[] items)
        {
            this.items = items;
        }

        public static final int CONSTRUCTOR = -1037074852;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockBlockQuote extends PageBlock
    {
        public RichText text;
        public RichText credit;

        public PageBlockBlockQuote()
        {
        }

        public PageBlockBlockQuote(RichText text, RichText credit)
        {
            this.text = text;
            this.credit = credit;
        }

        public static final int CONSTRUCTOR = 1657834142;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockPullQuote extends PageBlock
    {
        public RichText text;
        public RichText credit;

        public PageBlockPullQuote()
        {
        }

        public PageBlockPullQuote(RichText text, RichText credit)
        {
            this.text = text;
            this.credit = credit;
        }

        public static final int CONSTRUCTOR = 490242317;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockAnimation extends PageBlock
    {
        public Animation animation;
        public PageBlockCaption caption;
        public boolean needAutoplay;

        public PageBlockAnimation()
        {
        }

        public PageBlockAnimation(Animation animation, PageBlockCaption caption,
                boolean needAutoplay)
        {
            this.animation = animation;
            this.caption = caption;
            this.needAutoplay = needAutoplay;
        }

        public static final int CONSTRUCTOR = 1355669513;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockAudio extends PageBlock
    {
        public Audio audio;
        public PageBlockCaption caption;

        public PageBlockAudio()
        {
        }

        public PageBlockAudio(Audio audio, PageBlockCaption caption)
        {
            this.audio = audio;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = -63371245;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockPhoto extends PageBlock
    {
        public Photo photo;
        public PageBlockCaption caption;
        public String url;

        public PageBlockPhoto()
        {
        }

        public PageBlockPhoto(Photo photo, PageBlockCaption caption, String url)
        {
            this.photo = photo;
            this.caption = caption;
            this.url = url;
        }

        public static final int CONSTRUCTOR = 417601156;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockVideo extends PageBlock
    {
        public Video video;
        public PageBlockCaption caption;
        public boolean needAutoplay;
        public boolean isLooped;

        public PageBlockVideo()
        {
        }

        public PageBlockVideo(Video video, PageBlockCaption caption, boolean needAutoplay,
                boolean isLooped)
        {
            this.video = video;
            this.caption = caption;
            this.needAutoplay = needAutoplay;
            this.isLooped = isLooped;
        }

        public static final int CONSTRUCTOR = 510041394;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockVoiceNote extends PageBlock
    {
        public VoiceNote voiceNote;
        public PageBlockCaption caption;

        public PageBlockVoiceNote()
        {
        }

        public PageBlockVoiceNote(VoiceNote voiceNote, PageBlockCaption caption)
        {
            this.voiceNote = voiceNote;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 1823310463;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockCover extends PageBlock
    {
        public PageBlock cover;

        public PageBlockCover()
        {
        }

        public PageBlockCover(PageBlock cover)
        {
            this.cover = cover;
        }

        public static final int CONSTRUCTOR = 972174080;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockEmbedded extends PageBlock
    {
        public String url;
        public String html;
        public Photo posterPhoto;
        public int width;
        public int height;
        public PageBlockCaption caption;
        public boolean isFullWidth;
        public boolean allowScrolling;

        public PageBlockEmbedded()
        {
        }

        public PageBlockEmbedded(String url, String html, Photo posterPhoto, int width, int height,
                PageBlockCaption caption, boolean isFullWidth, boolean allowScrolling)
        {
            this.url = url;
            this.html = html;
            this.posterPhoto = posterPhoto;
            this.width = width;
            this.height = height;
            this.caption = caption;
            this.isFullWidth = isFullWidth;
            this.allowScrolling = allowScrolling;
        }

        public static final int CONSTRUCTOR = -1942577763;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockEmbeddedPost extends PageBlock
    {
        public String url;
        public String author;
        public Photo authorPhoto;
        public int date;
        public PageBlock[] pageBlocks;
        public PageBlockCaption caption;

        public PageBlockEmbeddedPost()
        {
        }

        public PageBlockEmbeddedPost(String url, String author, Photo authorPhoto, int date,
                PageBlock[] pageBlocks, PageBlockCaption caption)
        {
            this.url = url;
            this.author = author;
            this.authorPhoto = authorPhoto;
            this.date = date;
            this.pageBlocks = pageBlocks;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 397600949;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockCollage extends PageBlock
    {
        public PageBlock[] pageBlocks;
        public PageBlockCaption caption;

        public PageBlockCollage()
        {
        }

        public PageBlockCollage(PageBlock[] pageBlocks, PageBlockCaption caption)
        {
            this.pageBlocks = pageBlocks;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 1163760110;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockSlideshow extends PageBlock
    {
        public PageBlock[] pageBlocks;
        public PageBlockCaption caption;

        public PageBlockSlideshow()
        {
        }

        public PageBlockSlideshow(PageBlock[] pageBlocks, PageBlockCaption caption)
        {
            this.pageBlocks = pageBlocks;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 539217375;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockChatLink extends PageBlock
    {
        public String title;
        public ChatPhotoInfo photo;
        public String username;

        public PageBlockChatLink()
        {
        }

        public PageBlockChatLink(String title, ChatPhotoInfo photo, String username)
        {
            this.title = title;
            this.photo = photo;
            this.username = username;
        }

        public static final int CONSTRUCTOR = -202091253;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockTable extends PageBlock
    {
        public RichText caption;
        public PageBlockTableCell[][] cells;
        public boolean isBordered;
        public boolean isStriped;

        public PageBlockTable()
        {
        }

        public PageBlockTable(RichText caption, PageBlockTableCell[][] cells, boolean isBordered,
                boolean isStriped)
        {
            this.caption = caption;
            this.cells = cells;
            this.isBordered = isBordered;
            this.isStriped = isStriped;
        }

        public static final int CONSTRUCTOR = -942649288;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockDetails extends PageBlock
    {
        public RichText header;
        public PageBlock[] pageBlocks;
        public boolean isOpen;

        public PageBlockDetails()
        {
        }

        public PageBlockDetails(RichText header, PageBlock[] pageBlocks, boolean isOpen)
        {
            this.header = header;
            this.pageBlocks = pageBlocks;
            this.isOpen = isOpen;
        }

        public static final int CONSTRUCTOR = -1599869809;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockRelatedArticles extends PageBlock
    {
        public RichText header;
        public PageBlockRelatedArticle[] articles;

        public PageBlockRelatedArticles()
        {
        }

        public PageBlockRelatedArticles(RichText header, PageBlockRelatedArticle[] articles)
        {
            this.header = header;
            this.articles = articles;
        }

        public static final int CONSTRUCTOR = -1807324374;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockMap extends PageBlock
    {
        public Location location;
        public int zoom;
        public int width;
        public int height;
        public PageBlockCaption caption;

        public PageBlockMap()
        {
        }

        public PageBlockMap(Location location, int zoom, int width, int height,
                PageBlockCaption caption)
        {
            this.location = location;
            this.zoom = zoom;
            this.width = width;
            this.height = height;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 1510961171;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockCaption extends Object
    {
        public RichText text;
        public RichText credit;

        public PageBlockCaption()
        {
        }

        public PageBlockCaption(RichText text, RichText credit)
        {
            this.text = text;
            this.credit = credit;
        }

        public static final int CONSTRUCTOR = -1180064650;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class PageBlockHorizontalAlignment extends Object
    {
    }

    public static class PageBlockHorizontalAlignmentLeft extends PageBlockHorizontalAlignment
    {

        public PageBlockHorizontalAlignmentLeft()
        {
        }

        public static final int CONSTRUCTOR = 848701417;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockHorizontalAlignmentCenter extends PageBlockHorizontalAlignment
    {

        public PageBlockHorizontalAlignmentCenter()
        {
        }

        public static final int CONSTRUCTOR = -1009203990;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockHorizontalAlignmentRight extends PageBlockHorizontalAlignment
    {

        public PageBlockHorizontalAlignmentRight()
        {
        }

        public static final int CONSTRUCTOR = 1371369214;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockListItem extends Object
    {
        public String label;
        public PageBlock[] pageBlocks;

        public PageBlockListItem()
        {
        }

        public PageBlockListItem(String label, PageBlock[] pageBlocks)
        {
            this.label = label;
            this.pageBlocks = pageBlocks;
        }

        public static final int CONSTRUCTOR = 323186259;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockRelatedArticle extends Object
    {
        public String url;
        public String title;
        public String description;
        public Photo photo;
        public String author;
        public int publishDate;

        public PageBlockRelatedArticle()
        {
        }

        public PageBlockRelatedArticle(String url, String title, String description, Photo photo,
                String author, int publishDate)
        {
            this.url = url;
            this.title = title;
            this.description = description;
            this.photo = photo;
            this.author = author;
            this.publishDate = publishDate;
        }

        public static final int CONSTRUCTOR = 481199251;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockTableCell extends Object
    {
        public RichText text;
        public boolean isHeader;
        public int colspan;
        public int rowspan;
        public PageBlockHorizontalAlignment align;
        public PageBlockVerticalAlignment valign;

        public PageBlockTableCell()
        {
        }

        public PageBlockTableCell(RichText text, boolean isHeader, int colspan, int rowspan,
                PageBlockHorizontalAlignment align, PageBlockVerticalAlignment valign)
        {
            this.text = text;
            this.isHeader = isHeader;
            this.colspan = colspan;
            this.rowspan = rowspan;
            this.align = align;
            this.valign = valign;
        }

        public static final int CONSTRUCTOR = 1417658214;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class PageBlockVerticalAlignment extends Object
    {
    }

    public static class PageBlockVerticalAlignmentTop extends PageBlockVerticalAlignment
    {

        public PageBlockVerticalAlignmentTop()
        {
        }

        public static final int CONSTRUCTOR = 195500454;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockVerticalAlignmentMiddle extends PageBlockVerticalAlignment
    {

        public PageBlockVerticalAlignmentMiddle()
        {
        }

        public static final int CONSTRUCTOR = -2123096587;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PageBlockVerticalAlignmentBottom extends PageBlockVerticalAlignment
    {

        public PageBlockVerticalAlignmentBottom()
        {
        }

        public static final int CONSTRUCTOR = 2092531158;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportAuthorizationForm extends Object
    {
        public int id;
        public PassportRequiredElement[] requiredElements;
        public String privacyPolicyUrl;

        public PassportAuthorizationForm()
        {
        }

        public PassportAuthorizationForm(int id, PassportRequiredElement[] requiredElements,
                String privacyPolicyUrl)
        {
            this.id = id;
            this.requiredElements = requiredElements;
            this.privacyPolicyUrl = privacyPolicyUrl;
        }

        public static final int CONSTRUCTOR = -1070673218;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class PassportElement extends Object
    {
    }

    public static class PassportElementPersonalDetails extends PassportElement
    {
        public PersonalDetails personalDetails;

        public PassportElementPersonalDetails()
        {
        }

        public PassportElementPersonalDetails(PersonalDetails personalDetails)
        {
            this.personalDetails = personalDetails;
        }

        public static final int CONSTRUCTOR = 1217724035;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementPassport extends PassportElement
    {
        public IdentityDocument passport;

        public PassportElementPassport()
        {
        }

        public PassportElementPassport(IdentityDocument passport)
        {
            this.passport = passport;
        }

        public static final int CONSTRUCTOR = -263985373;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementDriverLicense extends PassportElement
    {
        public IdentityDocument driverLicense;

        public PassportElementDriverLicense()
        {
        }

        public PassportElementDriverLicense(IdentityDocument driverLicense)
        {
            this.driverLicense = driverLicense;
        }

        public static final int CONSTRUCTOR = 1643580589;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementIdentityCard extends PassportElement
    {
        public IdentityDocument identityCard;

        public PassportElementIdentityCard()
        {
        }

        public PassportElementIdentityCard(IdentityDocument identityCard)
        {
            this.identityCard = identityCard;
        }

        public static final int CONSTRUCTOR = 2083775797;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementInternalPassport extends PassportElement
    {
        public IdentityDocument internalPassport;

        public PassportElementInternalPassport()
        {
        }

        public PassportElementInternalPassport(IdentityDocument internalPassport)
        {
            this.internalPassport = internalPassport;
        }

        public static final int CONSTRUCTOR = 36220295;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementAddress extends PassportElement
    {
        public Address address;

        public PassportElementAddress()
        {
        }

        public PassportElementAddress(Address address)
        {
            this.address = address;
        }

        public static final int CONSTRUCTOR = -782625232;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementUtilityBill extends PassportElement
    {
        public PersonalDocument utilityBill;

        public PassportElementUtilityBill()
        {
        }

        public PassportElementUtilityBill(PersonalDocument utilityBill)
        {
            this.utilityBill = utilityBill;
        }

        public static final int CONSTRUCTOR = -234611246;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementBankStatement extends PassportElement
    {
        public PersonalDocument bankStatement;

        public PassportElementBankStatement()
        {
        }

        public PassportElementBankStatement(PersonalDocument bankStatement)
        {
            this.bankStatement = bankStatement;
        }

        public static final int CONSTRUCTOR = -366464408;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementRentalAgreement extends PassportElement
    {
        public PersonalDocument rentalAgreement;

        public PassportElementRentalAgreement()
        {
        }

        public PassportElementRentalAgreement(PersonalDocument rentalAgreement)
        {
            this.rentalAgreement = rentalAgreement;
        }

        public static final int CONSTRUCTOR = -290141400;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementPassportRegistration extends PassportElement
    {
        public PersonalDocument passportRegistration;

        public PassportElementPassportRegistration()
        {
        }

        public PassportElementPassportRegistration(PersonalDocument passportRegistration)
        {
            this.passportRegistration = passportRegistration;
        }

        public static final int CONSTRUCTOR = 618323071;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTemporaryRegistration extends PassportElement
    {
        public PersonalDocument temporaryRegistration;

        public PassportElementTemporaryRegistration()
        {
        }

        public PassportElementTemporaryRegistration(PersonalDocument temporaryRegistration)
        {
            this.temporaryRegistration = temporaryRegistration;
        }

        public static final int CONSTRUCTOR = 1237626864;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementPhoneNumber extends PassportElement
    {
        public String phoneNumber;

        public PassportElementPhoneNumber()
        {
        }

        public PassportElementPhoneNumber(String phoneNumber)
        {
            this.phoneNumber = phoneNumber;
        }

        public static final int CONSTRUCTOR = -1320118375;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementEmailAddress extends PassportElement
    {
        public String emailAddress;

        public PassportElementEmailAddress()
        {
        }

        public PassportElementEmailAddress(String emailAddress)
        {
            this.emailAddress = emailAddress;
        }

        public static final int CONSTRUCTOR = -1528129531;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementError extends Object
    {
        public PassportElementType type;
        public String message;
        public PassportElementErrorSource source;

        public PassportElementError()
        {
        }

        public PassportElementError(PassportElementType type, String message,
                PassportElementErrorSource source)
        {
            this.type = type;
            this.message = message;
            this.source = source;
        }

        public static final int CONSTRUCTOR = -1861902395;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class PassportElementErrorSource extends Object
    {
    }

    public static class PassportElementErrorSourceUnspecified extends PassportElementErrorSource
    {

        public PassportElementErrorSourceUnspecified()
        {
        }

        public static final int CONSTRUCTOR = -378320830;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementErrorSourceDataField extends PassportElementErrorSource
    {
        public String fieldName;

        public PassportElementErrorSourceDataField()
        {
        }

        public PassportElementErrorSourceDataField(String fieldName)
        {
            this.fieldName = fieldName;
        }

        public static final int CONSTRUCTOR = -308650776;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementErrorSourceFrontSide extends PassportElementErrorSource
    {

        public PassportElementErrorSourceFrontSide()
        {
        }

        public static final int CONSTRUCTOR = 1895658292;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementErrorSourceReverseSide extends PassportElementErrorSource
    {

        public PassportElementErrorSourceReverseSide()
        {
        }

        public static final int CONSTRUCTOR = 1918630391;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementErrorSourceSelfie extends PassportElementErrorSource
    {

        public PassportElementErrorSourceSelfie()
        {
        }

        public static final int CONSTRUCTOR = -797043672;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementErrorSourceTranslationFile extends PassportElementErrorSource
    {
        public int fileIndex;

        public PassportElementErrorSourceTranslationFile()
        {
        }

        public PassportElementErrorSourceTranslationFile(int fileIndex)
        {
            this.fileIndex = fileIndex;
        }

        public static final int CONSTRUCTOR = -689621228;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementErrorSourceTranslationFiles
            extends PassportElementErrorSource
    {

        public PassportElementErrorSourceTranslationFiles()
        {
        }

        public static final int CONSTRUCTOR = 581280796;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementErrorSourceFile extends PassportElementErrorSource
    {
        public int fileIndex;

        public PassportElementErrorSourceFile()
        {
        }

        public PassportElementErrorSourceFile(int fileIndex)
        {
            this.fileIndex = fileIndex;
        }

        public static final int CONSTRUCTOR = 2020358960;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementErrorSourceFiles extends PassportElementErrorSource
    {

        public PassportElementErrorSourceFiles()
        {
        }

        public static final int CONSTRUCTOR = 1894164178;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class PassportElementType extends Object
    {
    }

    public static class PassportElementTypePersonalDetails extends PassportElementType
    {

        public PassportElementTypePersonalDetails()
        {
        }

        public static final int CONSTRUCTOR = -1032136365;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypePassport extends PassportElementType
    {

        public PassportElementTypePassport()
        {
        }

        public static final int CONSTRUCTOR = -436360376;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypeDriverLicense extends PassportElementType
    {

        public PassportElementTypeDriverLicense()
        {
        }

        public static final int CONSTRUCTOR = 1827298379;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypeIdentityCard extends PassportElementType
    {

        public PassportElementTypeIdentityCard()
        {
        }

        public static final int CONSTRUCTOR = -502356132;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypeInternalPassport extends PassportElementType
    {

        public PassportElementTypeInternalPassport()
        {
        }

        public static final int CONSTRUCTOR = -793781959;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypeAddress extends PassportElementType
    {

        public PassportElementTypeAddress()
        {
        }

        public static final int CONSTRUCTOR = 496327874;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypeUtilityBill extends PassportElementType
    {

        public PassportElementTypeUtilityBill()
        {
        }

        public static final int CONSTRUCTOR = 627084906;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypeBankStatement extends PassportElementType
    {

        public PassportElementTypeBankStatement()
        {
        }

        public static final int CONSTRUCTOR = 574095667;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypeRentalAgreement extends PassportElementType
    {

        public PassportElementTypeRentalAgreement()
        {
        }

        public static final int CONSTRUCTOR = -2060583280;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypePassportRegistration extends PassportElementType
    {

        public PassportElementTypePassportRegistration()
        {
        }

        public static final int CONSTRUCTOR = -159478209;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypeTemporaryRegistration extends PassportElementType
    {

        public PassportElementTypeTemporaryRegistration()
        {
        }

        public static final int CONSTRUCTOR = 1092498527;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypePhoneNumber extends PassportElementType
    {

        public PassportElementTypePhoneNumber()
        {
        }

        public static final int CONSTRUCTOR = -995361172;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementTypeEmailAddress extends PassportElementType
    {

        public PassportElementTypeEmailAddress()
        {
        }

        public static final int CONSTRUCTOR = -79321405;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElements extends Object
    {
        public PassportElement[] elements;

        public PassportElements()
        {
        }

        public PassportElements(PassportElement[] elements)
        {
            this.elements = elements;
        }

        public static final int CONSTRUCTOR = 1264617556;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportElementsWithErrors extends Object
    {
        public PassportElement[] elements;
        public PassportElementError[] errors;

        public PassportElementsWithErrors()
        {
        }

        public PassportElementsWithErrors(PassportElement[] elements, PassportElementError[] errors)
        {
            this.elements = elements;
            this.errors = errors;
        }

        public static final int CONSTRUCTOR = 1308923044;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportRequiredElement extends Object
    {
        public PassportSuitableElement[] suitableElements;

        public PassportRequiredElement()
        {
        }

        public PassportRequiredElement(PassportSuitableElement[] suitableElements)
        {
            this.suitableElements = suitableElements;
        }

        public static final int CONSTRUCTOR = -1983641651;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PassportSuitableElement extends Object
    {
        public PassportElementType type;
        public boolean isSelfieRequired;
        public boolean isTranslationRequired;
        public boolean isNativeNameRequired;

        public PassportSuitableElement()
        {
        }

        public PassportSuitableElement(PassportElementType type, boolean isSelfieRequired,
                boolean isTranslationRequired, boolean isNativeNameRequired)
        {
            this.type = type;
            this.isSelfieRequired = isSelfieRequired;
            this.isTranslationRequired = isTranslationRequired;
            this.isNativeNameRequired = isNativeNameRequired;
        }

        public static final int CONSTRUCTOR = -789019876;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PasswordState extends Object
    {
        public boolean hasPassword;
        public String passwordHint;
        public boolean hasRecoveryEmailAddress;
        public boolean hasPassportData;
        public EmailAddressAuthenticationCodeInfo recoveryEmailAddressCodeInfo;
        public int pendingResetDate;

        public PasswordState()
        {
        }

        public PasswordState(boolean hasPassword, String passwordHint,
                boolean hasRecoveryEmailAddress, boolean hasPassportData,
                EmailAddressAuthenticationCodeInfo recoveryEmailAddressCodeInfo,
                int pendingResetDate)
        {
            this.hasPassword = hasPassword;
            this.passwordHint = passwordHint;
            this.hasRecoveryEmailAddress = hasRecoveryEmailAddress;
            this.hasPassportData = hasPassportData;
            this.recoveryEmailAddressCodeInfo = recoveryEmailAddressCodeInfo;
            this.pendingResetDate = pendingResetDate;
        }

        public static final int CONSTRUCTOR = -2001619202;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PaymentForm extends Object
    {
        public long id;
        public Invoice invoice;
        public String url;
        public long sellerBotUserId;
        public long paymentsProviderUserId;
        public PaymentsProviderStripe paymentsProvider;
        public OrderInfo savedOrderInfo;
        public SavedCredentials savedCredentials;
        public boolean canSaveCredentials;
        public boolean needPassword;

        public PaymentForm()
        {
        }

        public PaymentForm(long id, Invoice invoice, String url, long sellerBotUserId,
                long paymentsProviderUserId, PaymentsProviderStripe paymentsProvider,
                OrderInfo savedOrderInfo, SavedCredentials savedCredentials,
                boolean canSaveCredentials, boolean needPassword)
        {
            this.id = id;
            this.invoice = invoice;
            this.url = url;
            this.sellerBotUserId = sellerBotUserId;
            this.paymentsProviderUserId = paymentsProviderUserId;
            this.paymentsProvider = paymentsProvider;
            this.savedOrderInfo = savedOrderInfo;
            this.savedCredentials = savedCredentials;
            this.canSaveCredentials = canSaveCredentials;
            this.needPassword = needPassword;
        }

        public static final int CONSTRUCTOR = 1462608358;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PaymentFormTheme extends Object
    {
        public int backgroundColor;
        public int textColor;
        public int hintColor;
        public int linkColor;
        public int buttonColor;
        public int buttonTextColor;

        public PaymentFormTheme()
        {
        }

        public PaymentFormTheme(int backgroundColor, int textColor, int hintColor, int linkColor,
                int buttonColor, int buttonTextColor)
        {
            this.backgroundColor = backgroundColor;
            this.textColor = textColor;
            this.hintColor = hintColor;
            this.linkColor = linkColor;
            this.buttonColor = buttonColor;
            this.buttonTextColor = buttonTextColor;
        }

        public static final int CONSTRUCTOR = -1760030833;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PaymentReceipt extends Object
    {
        public String title;
        public String description;
        public Photo photo;
        public int date;
        public long sellerBotUserId;
        public long paymentsProviderUserId;
        public Invoice invoice;
        public OrderInfo orderInfo;
        public ShippingOption shippingOption;
        public String credentialsTitle;
        public long tipAmount;

        public PaymentReceipt()
        {
        }

        public PaymentReceipt(String title, String description, Photo photo, int date,
                long sellerBotUserId, long paymentsProviderUserId, Invoice invoice,
                OrderInfo orderInfo, ShippingOption shippingOption, String credentialsTitle,
                long tipAmount)
        {
            this.title = title;
            this.description = description;
            this.photo = photo;
            this.date = date;
            this.sellerBotUserId = sellerBotUserId;
            this.paymentsProviderUserId = paymentsProviderUserId;
            this.invoice = invoice;
            this.orderInfo = orderInfo;
            this.shippingOption = shippingOption;
            this.credentialsTitle = credentialsTitle;
            this.tipAmount = tipAmount;
        }

        public static final int CONSTRUCTOR = -401796169;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PaymentResult extends Object
    {
        public boolean success;
        public String verificationUrl;

        public PaymentResult()
        {
        }

        public PaymentResult(boolean success, String verificationUrl)
        {
            this.success = success;
            this.verificationUrl = verificationUrl;
        }

        public static final int CONSTRUCTOR = -804263843;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PaymentsProviderStripe extends Object
    {
        public String publishableKey;
        public boolean needCountry;
        public boolean needPostalCode;
        public boolean needCardholderName;

        public PaymentsProviderStripe()
        {
        }

        public PaymentsProviderStripe(String publishableKey, boolean needCountry,
                boolean needPostalCode, boolean needCardholderName)
        {
            this.publishableKey = publishableKey;
            this.needCountry = needCountry;
            this.needPostalCode = needPostalCode;
            this.needCardholderName = needCardholderName;
        }

        public static final int CONSTRUCTOR = 1090791032;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PersonalDetails extends Object
    {
        public String firstName;
        public String middleName;
        public String lastName;
        public String nativeFirstName;
        public String nativeMiddleName;
        public String nativeLastName;
        public Date birthdate;
        public String gender;
        public String countryCode;
        public String residenceCountryCode;

        public PersonalDetails()
        {
        }

        public PersonalDetails(String firstName, String middleName, String lastName,
                String nativeFirstName, String nativeMiddleName, String nativeLastName,
                Date birthdate, String gender, String countryCode, String residenceCountryCode)
        {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.nativeFirstName = nativeFirstName;
            this.nativeMiddleName = nativeMiddleName;
            this.nativeLastName = nativeLastName;
            this.birthdate = birthdate;
            this.gender = gender;
            this.countryCode = countryCode;
            this.residenceCountryCode = residenceCountryCode;
        }

        public static final int CONSTRUCTOR = -1061656137;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PersonalDocument extends Object
    {
        public DatedFile[] files;
        public DatedFile[] translation;

        public PersonalDocument()
        {
        }

        public PersonalDocument(DatedFile[] files, DatedFile[] translation)
        {
            this.files = files;
            this.translation = translation;
        }

        public static final int CONSTRUCTOR = -1011634661;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PhoneNumberAuthenticationSettings extends Object
    {
        public boolean allowFlashCall;
        public boolean allowMissedCall;
        public boolean isCurrentPhoneNumber;
        public boolean allowSmsRetrieverApi;
        public String[] authenticationTokens;

        public PhoneNumberAuthenticationSettings()
        {
        }

        public PhoneNumberAuthenticationSettings(boolean allowFlashCall, boolean allowMissedCall,
                boolean isCurrentPhoneNumber, boolean allowSmsRetrieverApi,
                String[] authenticationTokens)
        {
            this.allowFlashCall = allowFlashCall;
            this.allowMissedCall = allowMissedCall;
            this.isCurrentPhoneNumber = isCurrentPhoneNumber;
            this.allowSmsRetrieverApi = allowSmsRetrieverApi;
            this.authenticationTokens = authenticationTokens;
        }

        public static final int CONSTRUCTOR = -421219756;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PhoneNumberInfo extends Object
    {
        public CountryInfo country;
        public String countryCallingCode;
        public String formattedPhoneNumber;

        public PhoneNumberInfo()
        {
        }

        public PhoneNumberInfo(CountryInfo country, String countryCallingCode,
                String formattedPhoneNumber)
        {
            this.country = country;
            this.countryCallingCode = countryCallingCode;
            this.formattedPhoneNumber = formattedPhoneNumber;
        }

        public static final int CONSTRUCTOR = 560180961;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Photo extends Object
    {
        public boolean hasStickers;
        public Minithumbnail minithumbnail;
        public PhotoSize[] sizes;

        public Photo()
        {
        }

        public Photo(boolean hasStickers, Minithumbnail minithumbnail, PhotoSize[] sizes)
        {
            this.hasStickers = hasStickers;
            this.minithumbnail = minithumbnail;
            this.sizes = sizes;
        }

        public static final int CONSTRUCTOR = -2022871583;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PhotoSize extends Object
    {
        public String type;
        public File photo;
        public int width;
        public int height;
        public int[] progressiveSizes;

        public PhotoSize()
        {
        }

        public PhotoSize(String type, File photo, int width, int height, int[] progressiveSizes)
        {
            this.type = type;
            this.photo = photo;
            this.width = width;
            this.height = height;
            this.progressiveSizes = progressiveSizes;
        }

        public static final int CONSTRUCTOR = 1609182352;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Point extends Object
    {
        public double x;
        public double y;

        public Point()
        {
        }

        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }

        public static final int CONSTRUCTOR = 437515705;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Poll extends Object
    {
        public long id;
        public String question;
        public PollOption[] options;
        public int totalVoterCount;
        public long[] recentVoterUserIds;
        public boolean isAnonymous;
        public PollType type;
        public int openPeriod;
        public int closeDate;
        public boolean isClosed;

        public Poll()
        {
        }

        public Poll(long id, String question, PollOption[] options, int totalVoterCount,
                long[] recentVoterUserIds, boolean isAnonymous, PollType type, int openPeriod,
                int closeDate, boolean isClosed)
        {
            this.id = id;
            this.question = question;
            this.options = options;
            this.totalVoterCount = totalVoterCount;
            this.recentVoterUserIds = recentVoterUserIds;
            this.isAnonymous = isAnonymous;
            this.type = type;
            this.openPeriod = openPeriod;
            this.closeDate = closeDate;
            this.isClosed = isClosed;
        }

        public static final int CONSTRUCTOR = 116940085;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PollOption extends Object
    {
        public String text;
        public int voterCount;
        public int votePercentage;
        public boolean isChosen;
        public boolean isBeingChosen;

        public PollOption()
        {
        }

        public PollOption(String text, int voterCount, int votePercentage, boolean isChosen,
                boolean isBeingChosen)
        {
            this.text = text;
            this.voterCount = voterCount;
            this.votePercentage = votePercentage;
            this.isChosen = isChosen;
            this.isBeingChosen = isBeingChosen;
        }

        public static final int CONSTRUCTOR = 1473893797;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class PollType extends Object
    {
    }

    public static class PollTypeRegular extends PollType
    {
        public boolean allowMultipleAnswers;

        public PollTypeRegular()
        {
        }

        public PollTypeRegular(boolean allowMultipleAnswers)
        {
            this.allowMultipleAnswers = allowMultipleAnswers;
        }

        public static final int CONSTRUCTOR = 641265698;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PollTypeQuiz extends PollType
    {
        public int correctOptionId;
        public FormattedText explanation;

        public PollTypeQuiz()
        {
        }

        public PollTypeQuiz(int correctOptionId, FormattedText explanation)
        {
            this.correctOptionId = correctOptionId;
            this.explanation = explanation;
        }

        public static final int CONSTRUCTOR = 657013913;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ProfilePhoto extends Object
    {
        public long id;
        public File small;
        public File big;
        public Minithumbnail minithumbnail;
        public boolean hasAnimation;

        public ProfilePhoto()
        {
        }

        public ProfilePhoto(long id, File small, File big, Minithumbnail minithumbnail,
                boolean hasAnimation)
        {
            this.id = id;
            this.small = small;
            this.big = big;
            this.minithumbnail = minithumbnail;
            this.hasAnimation = hasAnimation;
        }

        public static final int CONSTRUCTOR = -131097523;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Proxies extends Object
    {
        public Proxy[] proxies;

        public Proxies()
        {
        }

        public Proxies(Proxy[] proxies)
        {
            this.proxies = proxies;
        }

        public static final int CONSTRUCTOR = 1200447205;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Proxy extends Object
    {
        public int id;
        public String server;
        public int port;
        public int lastUsedDate;
        public boolean isEnabled;
        public ProxyType type;

        public Proxy()
        {
        }

        public Proxy(int id, String server, int port, int lastUsedDate, boolean isEnabled,
                ProxyType type)
        {
            this.id = id;
            this.server = server;
            this.port = port;
            this.lastUsedDate = lastUsedDate;
            this.isEnabled = isEnabled;
            this.type = type;
        }

        public static final int CONSTRUCTOR = 196049779;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ProxyType extends Object
    {
    }

    public static class ProxyTypeSocks5 extends ProxyType
    {
        public String username;
        public String password;

        public ProxyTypeSocks5()
        {
        }

        public ProxyTypeSocks5(String username, String password)
        {
            this.username = username;
            this.password = password;
        }

        public static final int CONSTRUCTOR = -890027341;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ProxyTypeHttp extends ProxyType
    {
        public String username;
        public String password;
        public boolean httpOnly;

        public ProxyTypeHttp()
        {
        }

        public ProxyTypeHttp(String username, String password, boolean httpOnly)
        {
            this.username = username;
            this.password = password;
            this.httpOnly = httpOnly;
        }

        public static final int CONSTRUCTOR = -1547188361;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ProxyTypeMtproto extends ProxyType
    {
        public String secret;

        public ProxyTypeMtproto()
        {
        }

        public ProxyTypeMtproto(String secret)
        {
            this.secret = secret;
        }

        public static final int CONSTRUCTOR = -1964826627;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class PublicChatType extends Object
    {
    }

    public static class PublicChatTypeHasUsername extends PublicChatType
    {

        public PublicChatTypeHasUsername()
        {
        }

        public static final int CONSTRUCTOR = 350789758;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PublicChatTypeIsLocationBased extends PublicChatType
    {

        public PublicChatTypeIsLocationBased()
        {
        }

        public static final int CONSTRUCTOR = 1183735952;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class PushMessageContent extends Object
    {
    }

    public static class PushMessageContentHidden extends PushMessageContent
    {
        public boolean isPinned;

        public PushMessageContentHidden()
        {
        }

        public PushMessageContentHidden(boolean isPinned)
        {
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = -316950436;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentAnimation extends PushMessageContent
    {
        public Animation animation;
        public String caption;
        public boolean isPinned;

        public PushMessageContentAnimation()
        {
        }

        public PushMessageContentAnimation(Animation animation, String caption, boolean isPinned)
        {
            this.animation = animation;
            this.caption = caption;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = 1034215396;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentAudio extends PushMessageContent
    {
        public Audio audio;
        public boolean isPinned;

        public PushMessageContentAudio()
        {
        }

        public PushMessageContentAudio(Audio audio, boolean isPinned)
        {
            this.audio = audio;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = 381581426;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentContact extends PushMessageContent
    {
        public String name;
        public boolean isPinned;

        public PushMessageContentContact()
        {
        }

        public PushMessageContentContact(String name, boolean isPinned)
        {
            this.name = name;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = -12219820;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentContactRegistered extends PushMessageContent
    {

        public PushMessageContentContactRegistered()
        {
        }

        public static final int CONSTRUCTOR = -303962720;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentDocument extends PushMessageContent
    {
        public Document document;
        public boolean isPinned;

        public PushMessageContentDocument()
        {
        }

        public PushMessageContentDocument(Document document, boolean isPinned)
        {
            this.document = document;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = -458379775;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentGame extends PushMessageContent
    {
        public String title;
        public boolean isPinned;

        public PushMessageContentGame()
        {
        }

        public PushMessageContentGame(String title, boolean isPinned)
        {
            this.title = title;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = -515131109;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentGameScore extends PushMessageContent
    {
        public String title;
        public int score;
        public boolean isPinned;

        public PushMessageContentGameScore()
        {
        }

        public PushMessageContentGameScore(String title, int score, boolean isPinned)
        {
            this.title = title;
            this.score = score;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = 901303688;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentInvoice extends PushMessageContent
    {
        public String price;
        public boolean isPinned;

        public PushMessageContentInvoice()
        {
        }

        public PushMessageContentInvoice(String price, boolean isPinned)
        {
            this.price = price;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = -1731687492;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentLocation extends PushMessageContent
    {
        public boolean isLive;
        public boolean isPinned;

        public PushMessageContentLocation()
        {
        }

        public PushMessageContentLocation(boolean isLive, boolean isPinned)
        {
            this.isLive = isLive;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = -1288005709;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentPhoto extends PushMessageContent
    {
        public Photo photo;
        public String caption;
        public boolean isSecret;
        public boolean isPinned;

        public PushMessageContentPhoto()
        {
        }

        public PushMessageContentPhoto(Photo photo, String caption, boolean isSecret,
                boolean isPinned)
        {
            this.photo = photo;
            this.caption = caption;
            this.isSecret = isSecret;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = 140631122;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentPoll extends PushMessageContent
    {
        public String question;
        public boolean isRegular;
        public boolean isPinned;

        public PushMessageContentPoll()
        {
        }

        public PushMessageContentPoll(String question, boolean isRegular, boolean isPinned)
        {
            this.question = question;
            this.isRegular = isRegular;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = -44403654;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentScreenshotTaken extends PushMessageContent
    {

        public PushMessageContentScreenshotTaken()
        {
        }

        public static final int CONSTRUCTOR = 214245369;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentSticker extends PushMessageContent
    {
        public Sticker sticker;
        public String emoji;
        public boolean isPinned;

        public PushMessageContentSticker()
        {
        }

        public PushMessageContentSticker(Sticker sticker, String emoji, boolean isPinned)
        {
            this.sticker = sticker;
            this.emoji = emoji;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = 1553513939;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentText extends PushMessageContent
    {
        public String text;
        public boolean isPinned;

        public PushMessageContentText()
        {
        }

        public PushMessageContentText(String text, boolean isPinned)
        {
            this.text = text;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = 274587305;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentVideo extends PushMessageContent
    {
        public Video video;
        public String caption;
        public boolean isSecret;
        public boolean isPinned;

        public PushMessageContentVideo()
        {
        }

        public PushMessageContentVideo(Video video, String caption, boolean isSecret,
                boolean isPinned)
        {
            this.video = video;
            this.caption = caption;
            this.isSecret = isSecret;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = 310038831;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentVideoNote extends PushMessageContent
    {
        public VideoNote videoNote;
        public boolean isPinned;

        public PushMessageContentVideoNote()
        {
        }

        public PushMessageContentVideoNote(VideoNote videoNote, boolean isPinned)
        {
            this.videoNote = videoNote;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = -1122764417;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentVoiceNote extends PushMessageContent
    {
        public VoiceNote voiceNote;
        public boolean isPinned;

        public PushMessageContentVoiceNote()
        {
        }

        public PushMessageContentVoiceNote(VoiceNote voiceNote, boolean isPinned)
        {
            this.voiceNote = voiceNote;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = 88910987;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentBasicGroupChatCreate extends PushMessageContent
    {

        public PushMessageContentBasicGroupChatCreate()
        {
        }

        public static final int CONSTRUCTOR = -2114855172;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentChatAddMembers extends PushMessageContent
    {
        public String memberName;
        public boolean isCurrentUser;
        public boolean isReturned;

        public PushMessageContentChatAddMembers()
        {
        }

        public PushMessageContentChatAddMembers(String memberName, boolean isCurrentUser,
                boolean isReturned)
        {
            this.memberName = memberName;
            this.isCurrentUser = isCurrentUser;
            this.isReturned = isReturned;
        }

        public static final int CONSTRUCTOR = -1087145158;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentChatChangePhoto extends PushMessageContent
    {

        public PushMessageContentChatChangePhoto()
        {
        }

        public static final int CONSTRUCTOR = -1114222051;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentChatChangeTitle extends PushMessageContent
    {
        public String title;

        public PushMessageContentChatChangeTitle()
        {
        }

        public PushMessageContentChatChangeTitle(String title)
        {
            this.title = title;
        }

        public static final int CONSTRUCTOR = -1964902749;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentChatSetTheme extends PushMessageContent
    {
        public String themeName;

        public PushMessageContentChatSetTheme()
        {
        }

        public PushMessageContentChatSetTheme(String themeName)
        {
            this.themeName = themeName;
        }

        public static final int CONSTRUCTOR = 173882216;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentChatDeleteMember extends PushMessageContent
    {
        public String memberName;
        public boolean isCurrentUser;
        public boolean isLeft;

        public PushMessageContentChatDeleteMember()
        {
        }

        public PushMessageContentChatDeleteMember(String memberName, boolean isCurrentUser,
                boolean isLeft)
        {
            this.memberName = memberName;
            this.isCurrentUser = isCurrentUser;
            this.isLeft = isLeft;
        }

        public static final int CONSTRUCTOR = 598714783;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentChatJoinByLink extends PushMessageContent
    {

        public PushMessageContentChatJoinByLink()
        {
        }

        public static final int CONSTRUCTOR = 1553719113;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentChatJoinByRequest extends PushMessageContent
    {

        public PushMessageContentChatJoinByRequest()
        {
        }

        public static final int CONSTRUCTOR = -205823627;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentMessageForwards extends PushMessageContent
    {
        public int totalCount;

        public PushMessageContentMessageForwards()
        {
        }

        public PushMessageContentMessageForwards(int totalCount)
        {
            this.totalCount = totalCount;
        }

        public static final int CONSTRUCTOR = -1913083876;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushMessageContentMediaAlbum extends PushMessageContent
    {
        public int totalCount;
        public boolean hasPhotos;
        public boolean hasVideos;
        public boolean hasAudios;
        public boolean hasDocuments;

        public PushMessageContentMediaAlbum()
        {
        }

        public PushMessageContentMediaAlbum(int totalCount, boolean hasPhotos, boolean hasVideos,
                boolean hasAudios, boolean hasDocuments)
        {
            this.totalCount = totalCount;
            this.hasPhotos = hasPhotos;
            this.hasVideos = hasVideos;
            this.hasAudios = hasAudios;
            this.hasDocuments = hasDocuments;
        }

        public static final int CONSTRUCTOR = -748426897;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PushReceiverId extends Object
    {
        public long id;

        public PushReceiverId()
        {
        }

        public PushReceiverId(long id)
        {
            this.id = id;
        }

        public static final int CONSTRUCTOR = 371056428;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RecommendedChatFilter extends Object
    {
        public ChatFilter filter;
        public String description;

        public RecommendedChatFilter()
        {
        }

        public RecommendedChatFilter(ChatFilter filter, String description)
        {
            this.filter = filter;
            this.description = description;
        }

        public static final int CONSTRUCTOR = 36048610;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RecommendedChatFilters extends Object
    {
        public RecommendedChatFilter[] chatFilters;

        public RecommendedChatFilters()
        {
        }

        public RecommendedChatFilters(RecommendedChatFilter[] chatFilters)
        {
            this.chatFilters = chatFilters;
        }

        public static final int CONSTRUCTOR = -263416880;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RecoveryEmailAddress extends Object
    {
        public String recoveryEmailAddress;

        public RecoveryEmailAddress()
        {
        }

        public RecoveryEmailAddress(String recoveryEmailAddress)
        {
            this.recoveryEmailAddress = recoveryEmailAddress;
        }

        public static final int CONSTRUCTOR = 1290526187;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoteFile extends Object
    {
        public String id;
        public String uniqueId;
        public boolean isUploadingActive;
        public boolean isUploadingCompleted;
        public int uploadedSize;

        public RemoteFile()
        {
        }

        public RemoteFile(String id, String uniqueId, boolean isUploadingActive,
                boolean isUploadingCompleted, int uploadedSize)
        {
            this.id = id;
            this.uniqueId = uniqueId;
            this.isUploadingActive = isUploadingActive;
            this.isUploadingCompleted = isUploadingCompleted;
            this.uploadedSize = uploadedSize;
        }

        public static final int CONSTRUCTOR = -1822143022;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ReplyMarkup extends Object
    {
    }

    public static class ReplyMarkupRemoveKeyboard extends ReplyMarkup
    {
        public boolean isPersonal;

        public ReplyMarkupRemoveKeyboard()
        {
        }

        public ReplyMarkupRemoveKeyboard(boolean isPersonal)
        {
            this.isPersonal = isPersonal;
        }

        public static final int CONSTRUCTOR = -691252879;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReplyMarkupForceReply extends ReplyMarkup
    {
        public boolean isPersonal;
        public String inputFieldPlaceholder;

        public ReplyMarkupForceReply()
        {
        }

        public ReplyMarkupForceReply(boolean isPersonal, String inputFieldPlaceholder)
        {
            this.isPersonal = isPersonal;
            this.inputFieldPlaceholder = inputFieldPlaceholder;
        }

        public static final int CONSTRUCTOR = 1101461919;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReplyMarkupShowKeyboard extends ReplyMarkup
    {
        public KeyboardButton[][] rows;
        public boolean resizeKeyboard;
        public boolean oneTime;
        public boolean isPersonal;
        public String inputFieldPlaceholder;

        public ReplyMarkupShowKeyboard()
        {
        }

        public ReplyMarkupShowKeyboard(KeyboardButton[][] rows, boolean resizeKeyboard,
                boolean oneTime, boolean isPersonal, String inputFieldPlaceholder)
        {
            this.rows = rows;
            this.resizeKeyboard = resizeKeyboard;
            this.oneTime = oneTime;
            this.isPersonal = isPersonal;
            this.inputFieldPlaceholder = inputFieldPlaceholder;
        }

        public static final int CONSTRUCTOR = -64985802;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReplyMarkupInlineKeyboard extends ReplyMarkup
    {
        public InlineKeyboardButton[][] rows;

        public ReplyMarkupInlineKeyboard()
        {
        }

        public ReplyMarkupInlineKeyboard(InlineKeyboardButton[][] rows)
        {
            this.rows = rows;
        }

        public static final int CONSTRUCTOR = -619317658;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ResetPasswordResult extends Object
    {
    }

    public static class ResetPasswordResultOk extends ResetPasswordResult
    {

        public ResetPasswordResultOk()
        {
        }

        public static final int CONSTRUCTOR = -1397267463;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResetPasswordResultPending extends ResetPasswordResult
    {
        public int pendingResetDate;

        public ResetPasswordResultPending()
        {
        }

        public ResetPasswordResultPending(int pendingResetDate)
        {
            this.pendingResetDate = pendingResetDate;
        }

        public static final int CONSTRUCTOR = 1193925721;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResetPasswordResultDeclined extends ResetPasswordResult
    {
        public int retryDate;

        public ResetPasswordResultDeclined()
        {
        }

        public ResetPasswordResultDeclined(int retryDate)
        {
            this.retryDate = retryDate;
        }

        public static final int CONSTRUCTOR = -1202200373;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class RichText extends Object
    {
    }

    public static class RichTextPlain extends RichText
    {
        public String text;

        public RichTextPlain()
        {
        }

        public RichTextPlain(String text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 482617702;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextBold extends RichText
    {
        public RichText text;

        public RichTextBold()
        {
        }

        public RichTextBold(RichText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 1670844268;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextItalic extends RichText
    {
        public RichText text;

        public RichTextItalic()
        {
        }

        public RichTextItalic(RichText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 1853354047;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextUnderline extends RichText
    {
        public RichText text;

        public RichTextUnderline()
        {
        }

        public RichTextUnderline(RichText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = -536019572;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextStrikethrough extends RichText
    {
        public RichText text;

        public RichTextStrikethrough()
        {
        }

        public RichTextStrikethrough(RichText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 723413585;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextFixed extends RichText
    {
        public RichText text;

        public RichTextFixed()
        {
        }

        public RichTextFixed(RichText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = -1271496249;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextUrl extends RichText
    {
        public RichText text;
        public String url;
        public boolean isCached;

        public RichTextUrl()
        {
        }

        public RichTextUrl(RichText text, String url, boolean isCached)
        {
            this.text = text;
            this.url = url;
            this.isCached = isCached;
        }

        public static final int CONSTRUCTOR = 83939092;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextEmailAddress extends RichText
    {
        public RichText text;
        public String emailAddress;

        public RichTextEmailAddress()
        {
        }

        public RichTextEmailAddress(RichText text, String emailAddress)
        {
            this.text = text;
            this.emailAddress = emailAddress;
        }

        public static final int CONSTRUCTOR = 40018679;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextSubscript extends RichText
    {
        public RichText text;

        public RichTextSubscript()
        {
        }

        public RichTextSubscript(RichText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = -868197812;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextSuperscript extends RichText
    {
        public RichText text;

        public RichTextSuperscript()
        {
        }

        public RichTextSuperscript(RichText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = -382241437;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextMarked extends RichText
    {
        public RichText text;

        public RichTextMarked()
        {
        }

        public RichTextMarked(RichText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = -1271999614;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextPhoneNumber extends RichText
    {
        public RichText text;
        public String phoneNumber;

        public RichTextPhoneNumber()
        {
        }

        public RichTextPhoneNumber(RichText text, String phoneNumber)
        {
            this.text = text;
            this.phoneNumber = phoneNumber;
        }

        public static final int CONSTRUCTOR = 128521539;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextIcon extends RichText
    {
        public Document document;
        public int width;
        public int height;

        public RichTextIcon()
        {
        }

        public RichTextIcon(Document document, int width, int height)
        {
            this.document = document;
            this.width = width;
            this.height = height;
        }

        public static final int CONSTRUCTOR = -1480316158;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextReference extends RichText
    {
        public RichText text;
        public String anchorName;
        public String url;

        public RichTextReference()
        {
        }

        public RichTextReference(RichText text, String anchorName, String url)
        {
            this.text = text;
            this.anchorName = anchorName;
            this.url = url;
        }

        public static final int CONSTRUCTOR = -1147530634;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextAnchor extends RichText
    {
        public String name;

        public RichTextAnchor()
        {
        }

        public RichTextAnchor(String name)
        {
            this.name = name;
        }

        public static final int CONSTRUCTOR = 1316950068;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTextAnchorLink extends RichText
    {
        public RichText text;
        public String anchorName;
        public String url;

        public RichTextAnchorLink()
        {
        }

        public RichTextAnchorLink(RichText text, String anchorName, String url)
        {
            this.text = text;
            this.anchorName = anchorName;
            this.url = url;
        }

        public static final int CONSTRUCTOR = -1541418282;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RichTexts extends RichText
    {
        public RichText[] texts;

        public RichTexts()
        {
        }

        public RichTexts(RichText[] texts)
        {
            this.texts = texts;
        }

        public static final int CONSTRUCTOR = 1647457821;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SavedCredentials extends Object
    {
        public String id;
        public String title;

        public SavedCredentials()
        {
        }

        public SavedCredentials(String id, String title)
        {
            this.id = id;
            this.title = title;
        }

        public static final int CONSTRUCTOR = -370273060;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ScopeNotificationSettings extends Object
    {
        public int muteFor;
        public String sound;
        public boolean showPreview;
        public boolean disablePinnedMessageNotifications;
        public boolean disableMentionNotifications;

        public ScopeNotificationSettings()
        {
        }

        public ScopeNotificationSettings(int muteFor, String sound, boolean showPreview,
                boolean disablePinnedMessageNotifications, boolean disableMentionNotifications)
        {
            this.muteFor = muteFor;
            this.sound = sound;
            this.showPreview = showPreview;
            this.disablePinnedMessageNotifications = disablePinnedMessageNotifications;
            this.disableMentionNotifications = disableMentionNotifications;
        }

        public static final int CONSTRUCTOR = -426103745;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class SearchMessagesFilter extends Object
    {
    }

    public static class SearchMessagesFilterEmpty extends SearchMessagesFilter
    {

        public SearchMessagesFilterEmpty()
        {
        }

        public static final int CONSTRUCTOR = -869395657;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterAnimation extends SearchMessagesFilter
    {

        public SearchMessagesFilterAnimation()
        {
        }

        public static final int CONSTRUCTOR = -155713339;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterAudio extends SearchMessagesFilter
    {

        public SearchMessagesFilterAudio()
        {
        }

        public static final int CONSTRUCTOR = 867505275;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterDocument extends SearchMessagesFilter
    {

        public SearchMessagesFilterDocument()
        {
        }

        public static final int CONSTRUCTOR = 1526331215;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterPhoto extends SearchMessagesFilter
    {

        public SearchMessagesFilterPhoto()
        {
        }

        public static final int CONSTRUCTOR = 925932293;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterVideo extends SearchMessagesFilter
    {

        public SearchMessagesFilterVideo()
        {
        }

        public static final int CONSTRUCTOR = 115538222;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterVoiceNote extends SearchMessagesFilter
    {

        public SearchMessagesFilterVoiceNote()
        {
        }

        public static final int CONSTRUCTOR = 1841439357;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterPhotoAndVideo extends SearchMessagesFilter
    {

        public SearchMessagesFilterPhotoAndVideo()
        {
        }

        public static final int CONSTRUCTOR = 1352130963;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterUrl extends SearchMessagesFilter
    {

        public SearchMessagesFilterUrl()
        {
        }

        public static final int CONSTRUCTOR = -1828724341;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterChatPhoto extends SearchMessagesFilter
    {

        public SearchMessagesFilterChatPhoto()
        {
        }

        public static final int CONSTRUCTOR = -1247751329;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterVideoNote extends SearchMessagesFilter
    {

        public SearchMessagesFilterVideoNote()
        {
        }

        public static final int CONSTRUCTOR = 564323321;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterVoiceAndVideoNote extends SearchMessagesFilter
    {

        public SearchMessagesFilterVoiceAndVideoNote()
        {
        }

        public static final int CONSTRUCTOR = 664174819;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterMention extends SearchMessagesFilter
    {

        public SearchMessagesFilterMention()
        {
        }

        public static final int CONSTRUCTOR = 2001258652;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterUnreadMention extends SearchMessagesFilter
    {

        public SearchMessagesFilterUnreadMention()
        {
        }

        public static final int CONSTRUCTOR = -95769149;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterFailedToSend extends SearchMessagesFilter
    {

        public SearchMessagesFilterFailedToSend()
        {
        }

        public static final int CONSTRUCTOR = -596322564;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessagesFilterPinned extends SearchMessagesFilter
    {

        public SearchMessagesFilterPinned()
        {
        }

        public static final int CONSTRUCTOR = 371805512;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Seconds extends Object
    {
        public double seconds;

        public Seconds()
        {
        }

        public Seconds(double seconds)
        {
            this.seconds = seconds;
        }

        public static final int CONSTRUCTOR = 959899022;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SecretChat extends Object
    {
        public int id;
        public long userId;
        public SecretChatState state;
        public boolean isOutbound;
        public byte[] keyHash;
        public int layer;

        public SecretChat()
        {
        }

        public SecretChat(int id, long userId, SecretChatState state, boolean isOutbound,
                byte[] keyHash, int layer)
        {
            this.id = id;
            this.userId = userId;
            this.state = state;
            this.isOutbound = isOutbound;
            this.keyHash = keyHash;
            this.layer = layer;
        }

        public static final int CONSTRUCTOR = -676918325;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class SecretChatState extends Object
    {
    }

    public static class SecretChatStatePending extends SecretChatState
    {

        public SecretChatStatePending()
        {
        }

        public static final int CONSTRUCTOR = -1637050756;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SecretChatStateReady extends SecretChatState
    {

        public SecretChatStateReady()
        {
        }

        public static final int CONSTRUCTOR = -1611352087;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SecretChatStateClosed extends SecretChatState
    {

        public SecretChatStateClosed()
        {
        }

        public static final int CONSTRUCTOR = -1945106707;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Session extends Object
    {
        public long id;
        public boolean isCurrent;
        public boolean isPasswordPending;
        public boolean canAcceptSecretChats;
        public boolean canAcceptCalls;
        public int apiId;
        public String applicationName;
        public String applicationVersion;
        public boolean isOfficialApplication;
        public String deviceModel;
        public String platform;
        public String systemVersion;
        public int logInDate;
        public int lastActiveDate;
        public String ip;
        public String country;
        public String region;

        public Session()
        {
        }

        public Session(long id, boolean isCurrent, boolean isPasswordPending,
                boolean canAcceptSecretChats, boolean canAcceptCalls, int apiId,
                String applicationName, String applicationVersion, boolean isOfficialApplication,
                String deviceModel, String platform, String systemVersion, int logInDate,
                int lastActiveDate, String ip, String country, String region)
        {
            this.id = id;
            this.isCurrent = isCurrent;
            this.isPasswordPending = isPasswordPending;
            this.canAcceptSecretChats = canAcceptSecretChats;
            this.canAcceptCalls = canAcceptCalls;
            this.apiId = apiId;
            this.applicationName = applicationName;
            this.applicationVersion = applicationVersion;
            this.isOfficialApplication = isOfficialApplication;
            this.deviceModel = deviceModel;
            this.platform = platform;
            this.systemVersion = systemVersion;
            this.logInDate = logInDate;
            this.lastActiveDate = lastActiveDate;
            this.ip = ip;
            this.country = country;
            this.region = region;
        }

        public static final int CONSTRUCTOR = 1068672887;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Sessions extends Object
    {
        public Session[] sessions;
        public int inactiveSessionTtlDays;

        public Sessions()
        {
        }

        public Sessions(Session[] sessions, int inactiveSessionTtlDays)
        {
            this.sessions = sessions;
            this.inactiveSessionTtlDays = inactiveSessionTtlDays;
        }

        public static final int CONSTRUCTOR = 842912274;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ShippingOption extends Object
    {
        public String id;
        public String title;
        public LabeledPricePart[] priceParts;

        public ShippingOption()
        {
        }

        public ShippingOption(String id, String title, LabeledPricePart[] priceParts)
        {
            this.id = id;
            this.title = title;
            this.priceParts = priceParts;
        }

        public static final int CONSTRUCTOR = 1425690001;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SponsoredMessage extends Object
    {
        public long messageId;
        public long sponsorChatId;
        public InternalLinkType link;
        public MessageContent content;

        public SponsoredMessage()
        {
        }

        public SponsoredMessage(long messageId, long sponsorChatId, InternalLinkType link,
                MessageContent content)
        {
            this.messageId = messageId;
            this.sponsorChatId = sponsorChatId;
            this.link = link;
            this.content = content;
        }

        public static final int CONSTRUCTOR = -1734768993;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class StatisticalGraph extends Object
    {
    }

    public static class StatisticalGraphData extends StatisticalGraph
    {
        public String jsonData;
        public String zoomToken;

        public StatisticalGraphData()
        {
        }

        public StatisticalGraphData(String jsonData, String zoomToken)
        {
            this.jsonData = jsonData;
            this.zoomToken = zoomToken;
        }

        public static final int CONSTRUCTOR = -1988940244;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StatisticalGraphAsync extends StatisticalGraph
    {
        public String token;

        public StatisticalGraphAsync()
        {
        }

        public StatisticalGraphAsync(String token)
        {
            this.token = token;
        }

        public static final int CONSTRUCTOR = 435891103;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StatisticalGraphError extends StatisticalGraph
    {
        public String errorMessage;

        public StatisticalGraphError()
        {
        }

        public StatisticalGraphError(String errorMessage)
        {
            this.errorMessage = errorMessage;
        }

        public static final int CONSTRUCTOR = -1006788526;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StatisticalValue extends Object
    {
        public double value;
        public double previousValue;
        public double growthRatePercentage;

        public StatisticalValue()
        {
        }

        public StatisticalValue(double value, double previousValue, double growthRatePercentage)
        {
            this.value = value;
            this.previousValue = previousValue;
            this.growthRatePercentage = growthRatePercentage;
        }

        public static final int CONSTRUCTOR = 1651337846;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Sticker extends Object
    {
        public long setId;
        public int width;
        public int height;
        public String emoji;
        public boolean isAnimated;
        public boolean isMask;
        public MaskPosition maskPosition;
        public ClosedVectorPath[] outline;
        public Thumbnail thumbnail;
        public File sticker;

        public Sticker()
        {
        }

        public Sticker(long setId, int width, int height, String emoji, boolean isAnimated,
                boolean isMask, MaskPosition maskPosition, ClosedVectorPath[] outline,
                Thumbnail thumbnail, File sticker)
        {
            this.setId = setId;
            this.width = width;
            this.height = height;
            this.emoji = emoji;
            this.isAnimated = isAnimated;
            this.isMask = isMask;
            this.maskPosition = maskPosition;
            this.outline = outline;
            this.thumbnail = thumbnail;
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = 45883239;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StickerSet extends Object
    {
        public long id;
        public String title;
        public String name;
        public Thumbnail thumbnail;
        public ClosedVectorPath[] thumbnailOutline;
        public boolean isInstalled;
        public boolean isArchived;
        public boolean isOfficial;
        public boolean isAnimated;
        public boolean isMasks;
        public boolean isViewed;
        public Sticker[] stickers;
        public Emojis[] emojis;

        public StickerSet()
        {
        }

        public StickerSet(long id, String title, String name, Thumbnail thumbnail,
                ClosedVectorPath[] thumbnailOutline, boolean isInstalled, boolean isArchived,
                boolean isOfficial, boolean isAnimated, boolean isMasks, boolean isViewed,
                Sticker[] stickers, Emojis[] emojis)
        {
            this.id = id;
            this.title = title;
            this.name = name;
            this.thumbnail = thumbnail;
            this.thumbnailOutline = thumbnailOutline;
            this.isInstalled = isInstalled;
            this.isArchived = isArchived;
            this.isOfficial = isOfficial;
            this.isAnimated = isAnimated;
            this.isMasks = isMasks;
            this.isViewed = isViewed;
            this.stickers = stickers;
            this.emojis = emojis;
        }

        public static final int CONSTRUCTOR = -79542167;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StickerSetInfo extends Object
    {
        public long id;
        public String title;
        public String name;
        public Thumbnail thumbnail;
        public ClosedVectorPath[] thumbnailOutline;
        public boolean isInstalled;
        public boolean isArchived;
        public boolean isOfficial;
        public boolean isAnimated;
        public boolean isMasks;
        public boolean isViewed;
        public int size;
        public Sticker[] covers;

        public StickerSetInfo()
        {
        }

        public StickerSetInfo(long id, String title, String name, Thumbnail thumbnail,
                ClosedVectorPath[] thumbnailOutline, boolean isInstalled, boolean isArchived,
                boolean isOfficial, boolean isAnimated, boolean isMasks, boolean isViewed, int size,
                Sticker[] covers)
        {
            this.id = id;
            this.title = title;
            this.name = name;
            this.thumbnail = thumbnail;
            this.thumbnailOutline = thumbnailOutline;
            this.isInstalled = isInstalled;
            this.isArchived = isArchived;
            this.isOfficial = isOfficial;
            this.isAnimated = isAnimated;
            this.isMasks = isMasks;
            this.isViewed = isViewed;
            this.size = size;
            this.covers = covers;
        }

        public static final int CONSTRUCTOR = 1307322248;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StickerSets extends Object
    {
        public int totalCount;
        public StickerSetInfo[] sets;

        public StickerSets()
        {
        }

        public StickerSets(int totalCount, StickerSetInfo[] sets)
        {
            this.totalCount = totalCount;
            this.sets = sets;
        }

        public static final int CONSTRUCTOR = -1883828812;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Stickers extends Object
    {
        public Sticker[] stickers;

        public Stickers()
        {
        }

        public Stickers(Sticker[] stickers)
        {
            this.stickers = stickers;
        }

        public static final int CONSTRUCTOR = 1974859260;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StorageStatistics extends Object
    {
        public long size;
        public int count;
        public StorageStatisticsByChat[] byChat;

        public StorageStatistics()
        {
        }

        public StorageStatistics(long size, int count, StorageStatisticsByChat[] byChat)
        {
            this.size = size;
            this.count = count;
            this.byChat = byChat;
        }

        public static final int CONSTRUCTOR = 217237013;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StorageStatisticsByChat extends Object
    {
        public long chatId;
        public long size;
        public int count;
        public StorageStatisticsByFileType[] byFileType;

        public StorageStatisticsByChat()
        {
        }

        public StorageStatisticsByChat(long chatId, long size, int count,
                StorageStatisticsByFileType[] byFileType)
        {
            this.chatId = chatId;
            this.size = size;
            this.count = count;
            this.byFileType = byFileType;
        }

        public static final int CONSTRUCTOR = 635434531;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StorageStatisticsByFileType extends Object
    {
        public FileType fileType;
        public long size;
        public int count;

        public StorageStatisticsByFileType()
        {
        }

        public StorageStatisticsByFileType(FileType fileType, long size, int count)
        {
            this.fileType = fileType;
            this.size = size;
            this.count = count;
        }

        public static final int CONSTRUCTOR = 714012840;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StorageStatisticsFast extends Object
    {
        public long filesSize;
        public int fileCount;
        public long databaseSize;
        public long languagePackDatabaseSize;
        public long logSize;

        public StorageStatisticsFast()
        {
        }

        public StorageStatisticsFast(long filesSize, int fileCount, long databaseSize,
                long languagePackDatabaseSize, long logSize)
        {
            this.filesSize = filesSize;
            this.fileCount = fileCount;
            this.databaseSize = databaseSize;
            this.languagePackDatabaseSize = languagePackDatabaseSize;
            this.logSize = logSize;
        }

        public static final int CONSTRUCTOR = -884922271;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class SuggestedAction extends Object
    {
    }

    public static class SuggestedActionEnableArchiveAndMuteNewChats extends SuggestedAction
    {

        public SuggestedActionEnableArchiveAndMuteNewChats()
        {
        }

        public static final int CONSTRUCTOR = 2017586255;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SuggestedActionCheckPassword extends SuggestedAction
    {

        public SuggestedActionCheckPassword()
        {
        }

        public static final int CONSTRUCTOR = 1910534839;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SuggestedActionCheckPhoneNumber extends SuggestedAction
    {

        public SuggestedActionCheckPhoneNumber()
        {
        }

        public static final int CONSTRUCTOR = 648771563;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SuggestedActionViewChecksHint extends SuggestedAction
    {

        public SuggestedActionViewChecksHint()
        {
        }

        public static final int CONSTRUCTOR = 891303239;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SuggestedActionConvertToBroadcastGroup extends SuggestedAction
    {
        public long supergroupId;

        public SuggestedActionConvertToBroadcastGroup()
        {
        }

        public SuggestedActionConvertToBroadcastGroup(long supergroupId)
        {
            this.supergroupId = supergroupId;
        }

        public static final int CONSTRUCTOR = -965071304;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SuggestedActionSetPassword extends SuggestedAction
    {
        public int authorizationDelay;

        public SuggestedActionSetPassword()
        {
        }

        public SuggestedActionSetPassword(int authorizationDelay)
        {
            this.authorizationDelay = authorizationDelay;
        }

        public static final int CONSTRUCTOR = 1863613848;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Supergroup extends Object
    {
        public long id;
        public String username;
        public int date;
        public ChatMemberStatus status;
        public int memberCount;
        public boolean hasLinkedChat;
        public boolean hasLocation;
        public boolean signMessages;
        public boolean isSlowModeEnabled;
        public boolean isChannel;
        public boolean isBroadcastGroup;
        public boolean isVerified;
        public String restrictionReason;
        public boolean isScam;
        public boolean isFake;

        public Supergroup()
        {
        }

        public Supergroup(long id, String username, int date, ChatMemberStatus status,
                int memberCount, boolean hasLinkedChat, boolean hasLocation, boolean signMessages,
                boolean isSlowModeEnabled, boolean isChannel, boolean isBroadcastGroup,
                boolean isVerified, String restrictionReason, boolean isScam, boolean isFake)
        {
            this.id = id;
            this.username = username;
            this.date = date;
            this.status = status;
            this.memberCount = memberCount;
            this.hasLinkedChat = hasLinkedChat;
            this.hasLocation = hasLocation;
            this.signMessages = signMessages;
            this.isSlowModeEnabled = isSlowModeEnabled;
            this.isChannel = isChannel;
            this.isBroadcastGroup = isBroadcastGroup;
            this.isVerified = isVerified;
            this.restrictionReason = restrictionReason;
            this.isScam = isScam;
            this.isFake = isFake;
        }

        public static final int CONSTRUCTOR = -722213067;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SupergroupFullInfo extends Object
    {
        public ChatPhoto photo;
        public String description;
        public int memberCount;
        public int administratorCount;
        public int restrictedCount;
        public int bannedCount;
        public long linkedChatId;
        public int slowModeDelay;
        public double slowModeDelayExpiresIn;
        public boolean canGetMembers;
        public boolean canSetUsername;
        public boolean canSetStickerSet;
        public boolean canSetLocation;
        public boolean canGetStatistics;
        public boolean isAllHistoryAvailable;
        public long stickerSetId;
        public ChatLocation location;
        public ChatInviteLink inviteLink;
        public BotCommands[] botCommands;
        public long upgradedFromBasicGroupId;
        public long upgradedFromMaxMessageId;

        public SupergroupFullInfo()
        {
        }

        public SupergroupFullInfo(ChatPhoto photo, String description, int memberCount,
                int administratorCount, int restrictedCount, int bannedCount, long linkedChatId,
                int slowModeDelay, double slowModeDelayExpiresIn, boolean canGetMembers,
                boolean canSetUsername, boolean canSetStickerSet, boolean canSetLocation,
                boolean canGetStatistics, boolean isAllHistoryAvailable, long stickerSetId,
                ChatLocation location, ChatInviteLink inviteLink, BotCommands[] botCommands,
                long upgradedFromBasicGroupId, long upgradedFromMaxMessageId)
        {
            this.photo = photo;
            this.description = description;
            this.memberCount = memberCount;
            this.administratorCount = administratorCount;
            this.restrictedCount = restrictedCount;
            this.bannedCount = bannedCount;
            this.linkedChatId = linkedChatId;
            this.slowModeDelay = slowModeDelay;
            this.slowModeDelayExpiresIn = slowModeDelayExpiresIn;
            this.canGetMembers = canGetMembers;
            this.canSetUsername = canSetUsername;
            this.canSetStickerSet = canSetStickerSet;
            this.canSetLocation = canSetLocation;
            this.canGetStatistics = canGetStatistics;
            this.isAllHistoryAvailable = isAllHistoryAvailable;
            this.stickerSetId = stickerSetId;
            this.location = location;
            this.inviteLink = inviteLink;
            this.botCommands = botCommands;
            this.upgradedFromBasicGroupId = upgradedFromBasicGroupId;
            this.upgradedFromMaxMessageId = upgradedFromMaxMessageId;
        }

        public static final int CONSTRUCTOR = -1035719349;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class SupergroupMembersFilter extends Object
    {
    }

    public static class SupergroupMembersFilterRecent extends SupergroupMembersFilter
    {

        public SupergroupMembersFilterRecent()
        {
        }

        public static final int CONSTRUCTOR = 1178199509;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SupergroupMembersFilterContacts extends SupergroupMembersFilter
    {
        public String query;

        public SupergroupMembersFilterContacts()
        {
        }

        public SupergroupMembersFilterContacts(String query)
        {
            this.query = query;
        }

        public static final int CONSTRUCTOR = -1282910856;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SupergroupMembersFilterAdministrators extends SupergroupMembersFilter
    {

        public SupergroupMembersFilterAdministrators()
        {
        }

        public static final int CONSTRUCTOR = -2097380265;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SupergroupMembersFilterSearch extends SupergroupMembersFilter
    {
        public String query;

        public SupergroupMembersFilterSearch()
        {
        }

        public SupergroupMembersFilterSearch(String query)
        {
            this.query = query;
        }

        public static final int CONSTRUCTOR = -1696358469;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SupergroupMembersFilterRestricted extends SupergroupMembersFilter
    {
        public String query;

        public SupergroupMembersFilterRestricted()
        {
        }

        public SupergroupMembersFilterRestricted(String query)
        {
            this.query = query;
        }

        public static final int CONSTRUCTOR = -1107800034;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SupergroupMembersFilterBanned extends SupergroupMembersFilter
    {
        public String query;

        public SupergroupMembersFilterBanned()
        {
        }

        public SupergroupMembersFilterBanned(String query)
        {
            this.query = query;
        }

        public static final int CONSTRUCTOR = -1210621683;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SupergroupMembersFilterMention extends SupergroupMembersFilter
    {
        public String query;
        public long messageThreadId;

        public SupergroupMembersFilterMention()
        {
        }

        public SupergroupMembersFilterMention(String query, long messageThreadId)
        {
            this.query = query;
            this.messageThreadId = messageThreadId;
        }

        public static final int CONSTRUCTOR = 947915036;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SupergroupMembersFilterBots extends SupergroupMembersFilter
    {

        public SupergroupMembersFilterBots()
        {
        }

        public static final int CONSTRUCTOR = 492138918;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TMeUrl extends Object
    {
        public String url;
        public TMeUrlType type;

        public TMeUrl()
        {
        }

        public TMeUrl(String url, TMeUrlType type)
        {
            this.url = url;
            this.type = type;
        }

        public static final int CONSTRUCTOR = -1140786622;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class TMeUrlType extends Object
    {
    }

    public static class TMeUrlTypeUser extends TMeUrlType
    {
        public long userId;

        public TMeUrlTypeUser()
        {
        }

        public TMeUrlTypeUser(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = 125336602;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TMeUrlTypeSupergroup extends TMeUrlType
    {
        public long supergroupId;

        public TMeUrlTypeSupergroup()
        {
        }

        public TMeUrlTypeSupergroup(long supergroupId)
        {
            this.supergroupId = supergroupId;
        }

        public static final int CONSTRUCTOR = -1353369944;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TMeUrlTypeChatInvite extends TMeUrlType
    {
        public ChatInviteLinkInfo info;

        public TMeUrlTypeChatInvite()
        {
        }

        public TMeUrlTypeChatInvite(ChatInviteLinkInfo info)
        {
            this.info = info;
        }

        public static final int CONSTRUCTOR = 313907785;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TMeUrlTypeStickerSet extends TMeUrlType
    {
        public long stickerSetId;

        public TMeUrlTypeStickerSet()
        {
        }

        public TMeUrlTypeStickerSet(long stickerSetId)
        {
            this.stickerSetId = stickerSetId;
        }

        public static final int CONSTRUCTOR = 1602473196;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TMeUrls extends Object
    {
        public TMeUrl[] urls;

        public TMeUrls()
        {
        }

        public TMeUrls(TMeUrl[] urls)
        {
            this.urls = urls;
        }

        public static final int CONSTRUCTOR = -1130595098;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TdlibParameters extends Object
    {
        public boolean useTestDc;
        public String databaseDirectory;
        public String filesDirectory;
        public boolean useFileDatabase;
        public boolean useChatInfoDatabase;
        public boolean useMessageDatabase;
        public boolean useSecretChats;
        public int apiId;
        public String apiHash;
        public String systemLanguageCode;
        public String deviceModel;
        public String systemVersion;
        public String applicationVersion;
        public boolean enableStorageOptimizer;
        public boolean ignoreFileNames;

        public TdlibParameters()
        {
        }

        public TdlibParameters(boolean useTestDc, String databaseDirectory, String filesDirectory,
                boolean useFileDatabase, boolean useChatInfoDatabase, boolean useMessageDatabase,
                boolean useSecretChats, int apiId, String apiHash, String systemLanguageCode,
                String deviceModel, String systemVersion, String applicationVersion,
                boolean enableStorageOptimizer, boolean ignoreFileNames)
        {
            this.useTestDc = useTestDc;
            this.databaseDirectory = databaseDirectory;
            this.filesDirectory = filesDirectory;
            this.useFileDatabase = useFileDatabase;
            this.useChatInfoDatabase = useChatInfoDatabase;
            this.useMessageDatabase = useMessageDatabase;
            this.useSecretChats = useSecretChats;
            this.apiId = apiId;
            this.apiHash = apiHash;
            this.systemLanguageCode = systemLanguageCode;
            this.deviceModel = deviceModel;
            this.systemVersion = systemVersion;
            this.applicationVersion = applicationVersion;
            this.enableStorageOptimizer = enableStorageOptimizer;
            this.ignoreFileNames = ignoreFileNames;
        }

        public static final int CONSTRUCTOR = -761520773;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TemporaryPasswordState extends Object
    {
        public boolean hasPassword;
        public int validFor;

        public TemporaryPasswordState()
        {
        }

        public TemporaryPasswordState(boolean hasPassword, int validFor)
        {
            this.hasPassword = hasPassword;
            this.validFor = validFor;
        }

        public static final int CONSTRUCTOR = 939837410;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TermsOfService extends Object
    {
        public FormattedText text;
        public int minUserAge;
        public boolean showPopup;

        public TermsOfService()
        {
        }

        public TermsOfService(FormattedText text, int minUserAge, boolean showPopup)
        {
            this.text = text;
            this.minUserAge = minUserAge;
            this.showPopup = showPopup;
        }

        public static final int CONSTRUCTOR = 739422597;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestBytes extends Object
    {
        public byte[] value;

        public TestBytes()
        {
        }

        public TestBytes(byte[] value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = -1541225250;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestInt extends Object
    {
        public int value;

        public TestInt()
        {
        }

        public TestInt(int value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = -574804983;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestString extends Object
    {
        public String value;

        public TestString()
        {
        }

        public TestString(String value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = -27891572;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestVectorInt extends Object
    {
        public int[] value;

        public TestVectorInt()
        {
        }

        public TestVectorInt(int[] value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = 593682027;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestVectorIntObject extends Object
    {
        public TestInt[] value;

        public TestVectorIntObject()
        {
        }

        public TestVectorIntObject(TestInt[] value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = 125891546;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestVectorString extends Object
    {
        public String[] value;

        public TestVectorString()
        {
        }

        public TestVectorString(String[] value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = 79339995;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestVectorStringObject extends Object
    {
        public TestString[] value;

        public TestVectorStringObject()
        {
        }

        public TestVectorStringObject(TestString[] value)
        {
            this.value = value;
        }

        public static final int CONSTRUCTOR = 80780537;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Text extends Object
    {
        public String text;

        public Text()
        {
        }

        public Text(String text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 578181272;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntities extends Object
    {
        public TextEntity[] entities;

        public TextEntities()
        {
        }

        public TextEntities(TextEntity[] entities)
        {
            this.entities = entities;
        }

        public static final int CONSTRUCTOR = -933199172;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntity extends Object
    {
        public int offset;
        public int length;
        public TextEntityType type;

        public TextEntity()
        {
        }

        public TextEntity(int offset, int length, TextEntityType type)
        {
            this.offset = offset;
            this.length = length;
            this.type = type;
        }

        public static final int CONSTRUCTOR = -1951688280;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class TextEntityType extends Object
    {
    }

    public static class TextEntityTypeMention extends TextEntityType
    {

        public TextEntityTypeMention()
        {
        }

        public static final int CONSTRUCTOR = 934535013;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeHashtag extends TextEntityType
    {

        public TextEntityTypeHashtag()
        {
        }

        public static final int CONSTRUCTOR = -1023958307;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeCashtag extends TextEntityType
    {

        public TextEntityTypeCashtag()
        {
        }

        public static final int CONSTRUCTOR = 1222915915;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeBotCommand extends TextEntityType
    {

        public TextEntityTypeBotCommand()
        {
        }

        public static final int CONSTRUCTOR = -1150997581;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeUrl extends TextEntityType
    {

        public TextEntityTypeUrl()
        {
        }

        public static final int CONSTRUCTOR = -1312762756;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeEmailAddress extends TextEntityType
    {

        public TextEntityTypeEmailAddress()
        {
        }

        public static final int CONSTRUCTOR = 1425545249;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypePhoneNumber extends TextEntityType
    {

        public TextEntityTypePhoneNumber()
        {
        }

        public static final int CONSTRUCTOR = -1160140246;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeBankCardNumber extends TextEntityType
    {

        public TextEntityTypeBankCardNumber()
        {
        }

        public static final int CONSTRUCTOR = 105986320;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeBold extends TextEntityType
    {

        public TextEntityTypeBold()
        {
        }

        public static final int CONSTRUCTOR = -1128210000;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeItalic extends TextEntityType
    {

        public TextEntityTypeItalic()
        {
        }

        public static final int CONSTRUCTOR = -118253987;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeUnderline extends TextEntityType
    {

        public TextEntityTypeUnderline()
        {
        }

        public static final int CONSTRUCTOR = 792317842;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeStrikethrough extends TextEntityType
    {

        public TextEntityTypeStrikethrough()
        {
        }

        public static final int CONSTRUCTOR = 961529082;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeCode extends TextEntityType
    {

        public TextEntityTypeCode()
        {
        }

        public static final int CONSTRUCTOR = -974534326;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypePre extends TextEntityType
    {

        public TextEntityTypePre()
        {
        }

        public static final int CONSTRUCTOR = 1648958606;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypePreCode extends TextEntityType
    {
        public String language;

        public TextEntityTypePreCode()
        {
        }

        public TextEntityTypePreCode(String language)
        {
            this.language = language;
        }

        public static final int CONSTRUCTOR = -945325397;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeTextUrl extends TextEntityType
    {
        public String url;

        public TextEntityTypeTextUrl()
        {
        }

        public TextEntityTypeTextUrl(String url)
        {
            this.url = url;
        }

        public static final int CONSTRUCTOR = 445719651;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeMentionName extends TextEntityType
    {
        public long userId;

        public TextEntityTypeMentionName()
        {
        }

        public TextEntityTypeMentionName(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = -1570974289;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextEntityTypeMediaTimestamp extends TextEntityType
    {
        public int mediaTimestamp;

        public TextEntityTypeMediaTimestamp()
        {
        }

        public TextEntityTypeMediaTimestamp(int mediaTimestamp)
        {
            this.mediaTimestamp = mediaTimestamp;
        }

        public static final int CONSTRUCTOR = -1841898992;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class TextParseMode extends Object
    {
    }

    public static class TextParseModeMarkdown extends TextParseMode
    {
        public int version;

        public TextParseModeMarkdown()
        {
        }

        public TextParseModeMarkdown(int version)
        {
            this.version = version;
        }

        public static final int CONSTRUCTOR = 360073407;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TextParseModeHTML extends TextParseMode
    {

        public TextParseModeHTML()
        {
        }

        public static final int CONSTRUCTOR = 1660208627;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ThemeSettings extends Object
    {
        public int accentColor;
        public Background background;
        public BackgroundFill outgoingMessageFill;
        public boolean animateOutgoingMessageFill;
        public int outgoingMessageAccentColor;

        public ThemeSettings()
        {
        }

        public ThemeSettings(int accentColor, Background background,
                BackgroundFill outgoingMessageFill, boolean animateOutgoingMessageFill,
                int outgoingMessageAccentColor)
        {
            this.accentColor = accentColor;
            this.background = background;
            this.outgoingMessageFill = outgoingMessageFill;
            this.animateOutgoingMessageFill = animateOutgoingMessageFill;
            this.outgoingMessageAccentColor = outgoingMessageAccentColor;
        }

        public static final int CONSTRUCTOR = -62120942;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Thumbnail extends Object
    {
        public ThumbnailFormat format;
        public int width;
        public int height;
        public File file;

        public Thumbnail()
        {
        }

        public Thumbnail(ThumbnailFormat format, int width, int height, File file)
        {
            this.format = format;
            this.width = width;
            this.height = height;
            this.file = file;
        }

        public static final int CONSTRUCTOR = 1243275371;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class ThumbnailFormat extends Object
    {
    }

    public static class ThumbnailFormatJpeg extends ThumbnailFormat
    {

        public ThumbnailFormatJpeg()
        {
        }

        public static final int CONSTRUCTOR = -653503352;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ThumbnailFormatPng extends ThumbnailFormat
    {

        public ThumbnailFormatPng()
        {
        }

        public static final int CONSTRUCTOR = 1577490421;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ThumbnailFormatWebp extends ThumbnailFormat
    {

        public ThumbnailFormatWebp()
        {
        }

        public static final int CONSTRUCTOR = -53588974;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ThumbnailFormatGif extends ThumbnailFormat
    {

        public ThumbnailFormatGif()
        {
        }

        public static final int CONSTRUCTOR = 1252205962;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ThumbnailFormatTgs extends ThumbnailFormat
    {

        public ThumbnailFormatTgs()
        {
        }

        public static final int CONSTRUCTOR = 1315522642;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ThumbnailFormatMpeg4 extends ThumbnailFormat
    {

        public ThumbnailFormatMpeg4()
        {
        }

        public static final int CONSTRUCTOR = 278616062;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class TopChatCategory extends Object
    {
    }

    public static class TopChatCategoryUsers extends TopChatCategory
    {

        public TopChatCategoryUsers()
        {
        }

        public static final int CONSTRUCTOR = 1026706816;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TopChatCategoryBots extends TopChatCategory
    {

        public TopChatCategoryBots()
        {
        }

        public static final int CONSTRUCTOR = -1577129195;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TopChatCategoryGroups extends TopChatCategory
    {

        public TopChatCategoryGroups()
        {
        }

        public static final int CONSTRUCTOR = 1530056846;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TopChatCategoryChannels extends TopChatCategory
    {

        public TopChatCategoryChannels()
        {
        }

        public static final int CONSTRUCTOR = -500825885;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TopChatCategoryInlineBots extends TopChatCategory
    {

        public TopChatCategoryInlineBots()
        {
        }

        public static final int CONSTRUCTOR = 377023356;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TopChatCategoryCalls extends TopChatCategory
    {

        public TopChatCategoryCalls()
        {
        }

        public static final int CONSTRUCTOR = 356208861;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TopChatCategoryForwardChats extends TopChatCategory
    {

        public TopChatCategoryForwardChats()
        {
        }

        public static final int CONSTRUCTOR = 1695922133;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class Update extends Object
    {
    }

    public static class UpdateAuthorizationState extends Update
    {
        public AuthorizationState authorizationState;

        public UpdateAuthorizationState()
        {
        }

        public UpdateAuthorizationState(AuthorizationState authorizationState)
        {
            this.authorizationState = authorizationState;
        }

        public static final int CONSTRUCTOR = 1622347490;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewMessage extends Update
    {
        public Message message;

        public UpdateNewMessage()
        {
        }

        public UpdateNewMessage(Message message)
        {
            this.message = message;
        }

        public static final int CONSTRUCTOR = -563105266;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageSendAcknowledged extends Update
    {
        public long chatId;
        public long messageId;

        public UpdateMessageSendAcknowledged()
        {
        }

        public UpdateMessageSendAcknowledged(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = 1302843961;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageSendSucceeded extends Update
    {
        public Message message;
        public long oldMessageId;

        public UpdateMessageSendSucceeded()
        {
        }

        public UpdateMessageSendSucceeded(Message message, long oldMessageId)
        {
            this.message = message;
            this.oldMessageId = oldMessageId;
        }

        public static final int CONSTRUCTOR = 1815715197;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageSendFailed extends Update
    {
        public Message message;
        public long oldMessageId;
        public int errorCode;
        public String errorMessage;

        public UpdateMessageSendFailed()
        {
        }

        public UpdateMessageSendFailed(Message message, long oldMessageId, int errorCode,
                String errorMessage)
        {
            this.message = message;
            this.oldMessageId = oldMessageId;
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public static final int CONSTRUCTOR = -1032335779;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageContent extends Update
    {
        public long chatId;
        public long messageId;
        public MessageContent newContent;

        public UpdateMessageContent()
        {
        }

        public UpdateMessageContent(long chatId, long messageId, MessageContent newContent)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.newContent = newContent;
        }

        public static final int CONSTRUCTOR = 506903332;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageEdited extends Update
    {
        public long chatId;
        public long messageId;
        public int editDate;
        public ReplyMarkup replyMarkup;

        public UpdateMessageEdited()
        {
        }

        public UpdateMessageEdited(long chatId, long messageId, int editDate,
                ReplyMarkup replyMarkup)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.editDate = editDate;
            this.replyMarkup = replyMarkup;
        }

        public static final int CONSTRUCTOR = -559545626;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageIsPinned extends Update
    {
        public long chatId;
        public long messageId;
        public boolean isPinned;

        public UpdateMessageIsPinned()
        {
        }

        public UpdateMessageIsPinned(long chatId, long messageId, boolean isPinned)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = 1102848829;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageInteractionInfo extends Update
    {
        public long chatId;
        public long messageId;
        public MessageInteractionInfo interactionInfo;

        public UpdateMessageInteractionInfo()
        {
        }

        public UpdateMessageInteractionInfo(long chatId, long messageId,
                MessageInteractionInfo interactionInfo)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.interactionInfo = interactionInfo;
        }

        public static final int CONSTRUCTOR = -1417659394;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageContentOpened extends Update
    {
        public long chatId;
        public long messageId;

        public UpdateMessageContentOpened()
        {
        }

        public UpdateMessageContentOpened(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = -1520523131;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageMentionRead extends Update
    {
        public long chatId;
        public long messageId;
        public int unreadMentionCount;

        public UpdateMessageMentionRead()
        {
        }

        public UpdateMessageMentionRead(long chatId, long messageId, int unreadMentionCount)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.unreadMentionCount = unreadMentionCount;
        }

        public static final int CONSTRUCTOR = -252228282;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateMessageLiveLocationViewed extends Update
    {
        public long chatId;
        public long messageId;

        public UpdateMessageLiveLocationViewed()
        {
        }

        public UpdateMessageLiveLocationViewed(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = -1308260971;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewChat extends Update
    {
        public Chat chat;

        public UpdateNewChat()
        {
        }

        public UpdateNewChat(Chat chat)
        {
            this.chat = chat;
        }

        public static final int CONSTRUCTOR = 2075757773;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatTitle extends Update
    {
        public long chatId;
        public String title;

        public UpdateChatTitle()
        {
        }

        public UpdateChatTitle(long chatId, String title)
        {
            this.chatId = chatId;
            this.title = title;
        }

        public static final int CONSTRUCTOR = -175405660;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatPhoto extends Update
    {
        public long chatId;
        public ChatPhotoInfo photo;

        public UpdateChatPhoto()
        {
        }

        public UpdateChatPhoto(long chatId, ChatPhotoInfo photo)
        {
            this.chatId = chatId;
            this.photo = photo;
        }

        public static final int CONSTRUCTOR = -324713921;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatPermissions extends Update
    {
        public long chatId;
        public ChatPermissions permissions;

        public UpdateChatPermissions()
        {
        }

        public UpdateChatPermissions(long chatId, ChatPermissions permissions)
        {
            this.chatId = chatId;
            this.permissions = permissions;
        }

        public static final int CONSTRUCTOR = -1622010003;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatLastMessage extends Update
    {
        public long chatId;
        public Message lastMessage;
        public ChatPosition[] positions;

        public UpdateChatLastMessage()
        {
        }

        public UpdateChatLastMessage(long chatId, Message lastMessage, ChatPosition[] positions)
        {
            this.chatId = chatId;
            this.lastMessage = lastMessage;
            this.positions = positions;
        }

        public static final int CONSTRUCTOR = -923244537;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatPosition extends Update
    {
        public long chatId;
        public ChatPosition position;

        public UpdateChatPosition()
        {
        }

        public UpdateChatPosition(long chatId, ChatPosition position)
        {
            this.chatId = chatId;
            this.position = position;
        }

        public static final int CONSTRUCTOR = -8979849;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatReadInbox extends Update
    {
        public long chatId;
        public long lastReadInboxMessageId;
        public int unreadCount;

        public UpdateChatReadInbox()
        {
        }

        public UpdateChatReadInbox(long chatId, long lastReadInboxMessageId, int unreadCount)
        {
            this.chatId = chatId;
            this.lastReadInboxMessageId = lastReadInboxMessageId;
            this.unreadCount = unreadCount;
        }

        public static final int CONSTRUCTOR = -797952281;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatReadOutbox extends Update
    {
        public long chatId;
        public long lastReadOutboxMessageId;

        public UpdateChatReadOutbox()
        {
        }

        public UpdateChatReadOutbox(long chatId, long lastReadOutboxMessageId)
        {
            this.chatId = chatId;
            this.lastReadOutboxMessageId = lastReadOutboxMessageId;
        }

        public static final int CONSTRUCTOR = 708334213;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatActionBar extends Update
    {
        public long chatId;
        public ChatActionBar actionBar;

        public UpdateChatActionBar()
        {
        }

        public UpdateChatActionBar(long chatId, ChatActionBar actionBar)
        {
            this.chatId = chatId;
            this.actionBar = actionBar;
        }

        public static final int CONSTRUCTOR = -643671870;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatDraftMessage extends Update
    {
        public long chatId;
        public DraftMessage draftMessage;
        public ChatPosition[] positions;

        public UpdateChatDraftMessage()
        {
        }

        public UpdateChatDraftMessage(long chatId, DraftMessage draftMessage,
                ChatPosition[] positions)
        {
            this.chatId = chatId;
            this.draftMessage = draftMessage;
            this.positions = positions;
        }

        public static final int CONSTRUCTOR = 1455190380;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatMessageSender extends Update
    {
        public long chatId;
        public MessageSender messageSenderId;

        public UpdateChatMessageSender()
        {
        }

        public UpdateChatMessageSender(long chatId, MessageSender messageSenderId)
        {
            this.chatId = chatId;
            this.messageSenderId = messageSenderId;
        }

        public static final int CONSTRUCTOR = 2003849793;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatMessageTtl extends Update
    {
        public long chatId;
        public int messageTtl;

        public UpdateChatMessageTtl()
        {
        }

        public UpdateChatMessageTtl(long chatId, int messageTtl)
        {
            this.chatId = chatId;
            this.messageTtl = messageTtl;
        }

        public static final int CONSTRUCTOR = -572479112;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatNotificationSettings extends Update
    {
        public long chatId;
        public ChatNotificationSettings notificationSettings;

        public UpdateChatNotificationSettings()
        {
        }

        public UpdateChatNotificationSettings(long chatId,
                ChatNotificationSettings notificationSettings)
        {
            this.chatId = chatId;
            this.notificationSettings = notificationSettings;
        }

        public static final int CONSTRUCTOR = -803163050;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatPendingJoinRequests extends Update
    {
        public long chatId;
        public ChatJoinRequestsInfo pendingJoinRequests;

        public UpdateChatPendingJoinRequests()
        {
        }

        public UpdateChatPendingJoinRequests(long chatId, ChatJoinRequestsInfo pendingJoinRequests)
        {
            this.chatId = chatId;
            this.pendingJoinRequests = pendingJoinRequests;
        }

        public static final int CONSTRUCTOR = 348578785;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatReplyMarkup extends Update
    {
        public long chatId;
        public long replyMarkupMessageId;

        public UpdateChatReplyMarkup()
        {
        }

        public UpdateChatReplyMarkup(long chatId, long replyMarkupMessageId)
        {
            this.chatId = chatId;
            this.replyMarkupMessageId = replyMarkupMessageId;
        }

        public static final int CONSTRUCTOR = 1309386144;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatTheme extends Update
    {
        public long chatId;
        public String themeName;

        public UpdateChatTheme()
        {
        }

        public UpdateChatTheme(long chatId, String themeName)
        {
            this.chatId = chatId;
            this.themeName = themeName;
        }

        public static final int CONSTRUCTOR = 838063205;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatUnreadMentionCount extends Update
    {
        public long chatId;
        public int unreadMentionCount;

        public UpdateChatUnreadMentionCount()
        {
        }

        public UpdateChatUnreadMentionCount(long chatId, int unreadMentionCount)
        {
            this.chatId = chatId;
            this.unreadMentionCount = unreadMentionCount;
        }

        public static final int CONSTRUCTOR = -2131461348;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatVideoChat extends Update
    {
        public long chatId;
        public VideoChat videoChat;

        public UpdateChatVideoChat()
        {
        }

        public UpdateChatVideoChat(long chatId, VideoChat videoChat)
        {
            this.chatId = chatId;
            this.videoChat = videoChat;
        }

        public static final int CONSTRUCTOR = 637226150;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatDefaultDisableNotification extends Update
    {
        public long chatId;
        public boolean defaultDisableNotification;

        public UpdateChatDefaultDisableNotification()
        {
        }

        public UpdateChatDefaultDisableNotification(long chatId, boolean defaultDisableNotification)
        {
            this.chatId = chatId;
            this.defaultDisableNotification = defaultDisableNotification;
        }

        public static final int CONSTRUCTOR = 464087707;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatHasProtectedContent extends Update
    {
        public long chatId;
        public boolean hasProtectedContent;

        public UpdateChatHasProtectedContent()
        {
        }

        public UpdateChatHasProtectedContent(long chatId, boolean hasProtectedContent)
        {
            this.chatId = chatId;
            this.hasProtectedContent = hasProtectedContent;
        }

        public static final int CONSTRUCTOR = 1800406811;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatHasScheduledMessages extends Update
    {
        public long chatId;
        public boolean hasScheduledMessages;

        public UpdateChatHasScheduledMessages()
        {
        }

        public UpdateChatHasScheduledMessages(long chatId, boolean hasScheduledMessages)
        {
            this.chatId = chatId;
            this.hasScheduledMessages = hasScheduledMessages;
        }

        public static final int CONSTRUCTOR = 2064958167;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatIsBlocked extends Update
    {
        public long chatId;
        public boolean isBlocked;

        public UpdateChatIsBlocked()
        {
        }

        public UpdateChatIsBlocked(long chatId, boolean isBlocked)
        {
            this.chatId = chatId;
            this.isBlocked = isBlocked;
        }

        public static final int CONSTRUCTOR = -1998946752;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatIsMarkedAsUnread extends Update
    {
        public long chatId;
        public boolean isMarkedAsUnread;

        public UpdateChatIsMarkedAsUnread()
        {
        }

        public UpdateChatIsMarkedAsUnread(long chatId, boolean isMarkedAsUnread)
        {
            this.chatId = chatId;
            this.isMarkedAsUnread = isMarkedAsUnread;
        }

        public static final int CONSTRUCTOR = 1468347188;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatFilters extends Update
    {
        public ChatFilterInfo[] chatFilters;

        public UpdateChatFilters()
        {
        }

        public UpdateChatFilters(ChatFilterInfo[] chatFilters)
        {
            this.chatFilters = chatFilters;
        }

        public static final int CONSTRUCTOR = -961518713;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatOnlineMemberCount extends Update
    {
        public long chatId;
        public int onlineMemberCount;

        public UpdateChatOnlineMemberCount()
        {
        }

        public UpdateChatOnlineMemberCount(long chatId, int onlineMemberCount)
        {
            this.chatId = chatId;
            this.onlineMemberCount = onlineMemberCount;
        }

        public static final int CONSTRUCTOR = 487369373;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateScopeNotificationSettings extends Update
    {
        public NotificationSettingsScope scope;
        public ScopeNotificationSettings notificationSettings;

        public UpdateScopeNotificationSettings()
        {
        }

        public UpdateScopeNotificationSettings(NotificationSettingsScope scope,
                ScopeNotificationSettings notificationSettings)
        {
            this.scope = scope;
            this.notificationSettings = notificationSettings;
        }

        public static final int CONSTRUCTOR = -1203975309;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNotification extends Update
    {
        public int notificationGroupId;
        public Notification notification;

        public UpdateNotification()
        {
        }

        public UpdateNotification(int notificationGroupId, Notification notification)
        {
            this.notificationGroupId = notificationGroupId;
            this.notification = notification;
        }

        public static final int CONSTRUCTOR = -1897496876;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNotificationGroup extends Update
    {
        public int notificationGroupId;
        public NotificationGroupType type;
        public long chatId;
        public long notificationSettingsChatId;
        public boolean isSilent;
        public int totalCount;
        public Notification[] addedNotifications;
        public int[] removedNotificationIds;

        public UpdateNotificationGroup()
        {
        }

        public UpdateNotificationGroup(int notificationGroupId, NotificationGroupType type,
                long chatId, long notificationSettingsChatId, boolean isSilent, int totalCount,
                Notification[] addedNotifications, int[] removedNotificationIds)
        {
            this.notificationGroupId = notificationGroupId;
            this.type = type;
            this.chatId = chatId;
            this.notificationSettingsChatId = notificationSettingsChatId;
            this.isSilent = isSilent;
            this.totalCount = totalCount;
            this.addedNotifications = addedNotifications;
            this.removedNotificationIds = removedNotificationIds;
        }

        public static final int CONSTRUCTOR = -2049005665;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateActiveNotifications extends Update
    {
        public NotificationGroup[] groups;

        public UpdateActiveNotifications()
        {
        }

        public UpdateActiveNotifications(NotificationGroup[] groups)
        {
            this.groups = groups;
        }

        public static final int CONSTRUCTOR = -1306672221;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateHavePendingNotifications extends Update
    {
        public boolean haveDelayedNotifications;
        public boolean haveUnreceivedNotifications;

        public UpdateHavePendingNotifications()
        {
        }

        public UpdateHavePendingNotifications(boolean haveDelayedNotifications,
                boolean haveUnreceivedNotifications)
        {
            this.haveDelayedNotifications = haveDelayedNotifications;
            this.haveUnreceivedNotifications = haveUnreceivedNotifications;
        }

        public static final int CONSTRUCTOR = 179233243;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateDeleteMessages extends Update
    {
        public long chatId;
        public long[] messageIds;
        public boolean isPermanent;
        public boolean fromCache;

        public UpdateDeleteMessages()
        {
        }

        public UpdateDeleteMessages(long chatId, long[] messageIds, boolean isPermanent,
                boolean fromCache)
        {
            this.chatId = chatId;
            this.messageIds = messageIds;
            this.isPermanent = isPermanent;
            this.fromCache = fromCache;
        }

        public static final int CONSTRUCTOR = 1669252686;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatAction extends Update
    {
        public long chatId;
        public long messageThreadId;
        public MessageSender senderId;
        public ChatAction action;

        public UpdateChatAction()
        {
        }

        public UpdateChatAction(long chatId, long messageThreadId, MessageSender senderId,
                ChatAction action)
        {
            this.chatId = chatId;
            this.messageThreadId = messageThreadId;
            this.senderId = senderId;
            this.action = action;
        }

        public static final int CONSTRUCTOR = -1698703832;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateUserStatus extends Update
    {
        public long userId;
        public UserStatus status;

        public UpdateUserStatus()
        {
        }

        public UpdateUserStatus(long userId, UserStatus status)
        {
            this.userId = userId;
            this.status = status;
        }

        public static final int CONSTRUCTOR = 958468625;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateUser extends Update
    {
        public User user;

        public UpdateUser()
        {
        }

        public UpdateUser(User user)
        {
            this.user = user;
        }

        public static final int CONSTRUCTOR = 1183394041;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateBasicGroup extends Update
    {
        public BasicGroup basicGroup;

        public UpdateBasicGroup()
        {
        }

        public UpdateBasicGroup(BasicGroup basicGroup)
        {
            this.basicGroup = basicGroup;
        }

        public static final int CONSTRUCTOR = -1003239581;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateSupergroup extends Update
    {
        public Supergroup supergroup;

        public UpdateSupergroup()
        {
        }

        public UpdateSupergroup(Supergroup supergroup)
        {
            this.supergroup = supergroup;
        }

        public static final int CONSTRUCTOR = -76782300;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateSecretChat extends Update
    {
        public SecretChat secretChat;

        public UpdateSecretChat()
        {
        }

        public UpdateSecretChat(SecretChat secretChat)
        {
            this.secretChat = secretChat;
        }

        public static final int CONSTRUCTOR = -1666903253;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateUserFullInfo extends Update
    {
        public long userId;
        public UserFullInfo userFullInfo;

        public UpdateUserFullInfo()
        {
        }

        public UpdateUserFullInfo(long userId, UserFullInfo userFullInfo)
        {
            this.userId = userId;
            this.userFullInfo = userFullInfo;
        }

        public static final int CONSTRUCTOR = -51197161;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateBasicGroupFullInfo extends Update
    {
        public long basicGroupId;
        public BasicGroupFullInfo basicGroupFullInfo;

        public UpdateBasicGroupFullInfo()
        {
        }

        public UpdateBasicGroupFullInfo(long basicGroupId, BasicGroupFullInfo basicGroupFullInfo)
        {
            this.basicGroupId = basicGroupId;
            this.basicGroupFullInfo = basicGroupFullInfo;
        }

        public static final int CONSTRUCTOR = 1391881151;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateSupergroupFullInfo extends Update
    {
        public long supergroupId;
        public SupergroupFullInfo supergroupFullInfo;

        public UpdateSupergroupFullInfo()
        {
        }

        public UpdateSupergroupFullInfo(long supergroupId, SupergroupFullInfo supergroupFullInfo)
        {
            this.supergroupId = supergroupId;
            this.supergroupFullInfo = supergroupFullInfo;
        }

        public static final int CONSTRUCTOR = 435539214;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateServiceNotification extends Update
    {
        public String type;
        public MessageContent content;

        public UpdateServiceNotification()
        {
        }

        public UpdateServiceNotification(String type, MessageContent content)
        {
            this.type = type;
            this.content = content;
        }

        public static final int CONSTRUCTOR = 1318622637;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateFile extends Update
    {
        public File file;

        public UpdateFile()
        {
        }

        public UpdateFile(File file)
        {
            this.file = file;
        }

        public static final int CONSTRUCTOR = 114132831;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateFileGenerationStart extends Update
    {
        public long generationId;
        public String originalPath;
        public String destinationPath;
        public String conversion;

        public UpdateFileGenerationStart()
        {
        }

        public UpdateFileGenerationStart(long generationId, String originalPath,
                String destinationPath, String conversion)
        {
            this.generationId = generationId;
            this.originalPath = originalPath;
            this.destinationPath = destinationPath;
            this.conversion = conversion;
        }

        public static final int CONSTRUCTOR = 216817388;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateFileGenerationStop extends Update
    {
        public long generationId;

        public UpdateFileGenerationStop()
        {
        }

        public UpdateFileGenerationStop(long generationId)
        {
            this.generationId = generationId;
        }

        public static final int CONSTRUCTOR = -1894449685;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateCall extends Update
    {
        public Call call;

        public UpdateCall()
        {
        }

        public UpdateCall(Call call)
        {
            this.call = call;
        }

        public static final int CONSTRUCTOR = 1337184477;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateGroupCall extends Update
    {
        public GroupCall groupCall;

        public UpdateGroupCall()
        {
        }

        public UpdateGroupCall(GroupCall groupCall)
        {
            this.groupCall = groupCall;
        }

        public static final int CONSTRUCTOR = 808603136;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateGroupCallParticipant extends Update
    {
        public int groupCallId;
        public GroupCallParticipant participant;

        public UpdateGroupCallParticipant()
        {
        }

        public UpdateGroupCallParticipant(int groupCallId, GroupCallParticipant participant)
        {
            this.groupCallId = groupCallId;
            this.participant = participant;
        }

        public static final int CONSTRUCTOR = -803128071;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewCallSignalingData extends Update
    {
        public int callId;
        public byte[] data;

        public UpdateNewCallSignalingData()
        {
        }

        public UpdateNewCallSignalingData(int callId, byte[] data)
        {
            this.callId = callId;
            this.data = data;
        }

        public static final int CONSTRUCTOR = 583634317;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateUserPrivacySettingRules extends Update
    {
        public UserPrivacySetting setting;
        public UserPrivacySettingRules rules;

        public UpdateUserPrivacySettingRules()
        {
        }

        public UpdateUserPrivacySettingRules(UserPrivacySetting setting,
                UserPrivacySettingRules rules)
        {
            this.setting = setting;
            this.rules = rules;
        }

        public static final int CONSTRUCTOR = -912960778;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateUnreadMessageCount extends Update
    {
        public ChatList chatList;
        public int unreadCount;
        public int unreadUnmutedCount;

        public UpdateUnreadMessageCount()
        {
        }

        public UpdateUnreadMessageCount(ChatList chatList, int unreadCount, int unreadUnmutedCount)
        {
            this.chatList = chatList;
            this.unreadCount = unreadCount;
            this.unreadUnmutedCount = unreadUnmutedCount;
        }

        public static final int CONSTRUCTOR = 78987721;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateUnreadChatCount extends Update
    {
        public ChatList chatList;
        public int totalCount;
        public int unreadCount;
        public int unreadUnmutedCount;
        public int markedAsUnreadCount;
        public int markedAsUnreadUnmutedCount;

        public UpdateUnreadChatCount()
        {
        }

        public UpdateUnreadChatCount(ChatList chatList, int totalCount, int unreadCount,
                int unreadUnmutedCount, int markedAsUnreadCount, int markedAsUnreadUnmutedCount)
        {
            this.chatList = chatList;
            this.totalCount = totalCount;
            this.unreadCount = unreadCount;
            this.unreadUnmutedCount = unreadUnmutedCount;
            this.markedAsUnreadCount = markedAsUnreadCount;
            this.markedAsUnreadUnmutedCount = markedAsUnreadUnmutedCount;
        }

        public static final int CONSTRUCTOR = 1994494530;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateOption extends Update
    {
        public String name;
        public OptionValue value;

        public UpdateOption()
        {
        }

        public UpdateOption(String name, OptionValue value)
        {
            this.name = name;
            this.value = value;
        }

        public static final int CONSTRUCTOR = 900822020;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateStickerSet extends Update
    {
        public StickerSet stickerSet;

        public UpdateStickerSet()
        {
        }

        public UpdateStickerSet(StickerSet stickerSet)
        {
            this.stickerSet = stickerSet;
        }

        public static final int CONSTRUCTOR = 1879268812;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateInstalledStickerSets extends Update
    {
        public boolean isMasks;
        public long[] stickerSetIds;

        public UpdateInstalledStickerSets()
        {
        }

        public UpdateInstalledStickerSets(boolean isMasks, long[] stickerSetIds)
        {
            this.isMasks = isMasks;
            this.stickerSetIds = stickerSetIds;
        }

        public static final int CONSTRUCTOR = 1125575977;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateTrendingStickerSets extends Update
    {
        public StickerSets stickerSets;

        public UpdateTrendingStickerSets()
        {
        }

        public UpdateTrendingStickerSets(StickerSets stickerSets)
        {
            this.stickerSets = stickerSets;
        }

        public static final int CONSTRUCTOR = 450714593;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateRecentStickers extends Update
    {
        public boolean isAttached;
        public int[] stickerIds;

        public UpdateRecentStickers()
        {
        }

        public UpdateRecentStickers(boolean isAttached, int[] stickerIds)
        {
            this.isAttached = isAttached;
            this.stickerIds = stickerIds;
        }

        public static final int CONSTRUCTOR = 1906403540;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateFavoriteStickers extends Update
    {
        public int[] stickerIds;

        public UpdateFavoriteStickers()
        {
        }

        public UpdateFavoriteStickers(int[] stickerIds)
        {
            this.stickerIds = stickerIds;
        }

        public static final int CONSTRUCTOR = 1662240999;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateSavedAnimations extends Update
    {
        public int[] animationIds;

        public UpdateSavedAnimations()
        {
        }

        public UpdateSavedAnimations(int[] animationIds)
        {
            this.animationIds = animationIds;
        }

        public static final int CONSTRUCTOR = 65563814;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateSelectedBackground extends Update
    {
        public boolean forDarkTheme;
        public Background background;

        public UpdateSelectedBackground()
        {
        }

        public UpdateSelectedBackground(boolean forDarkTheme, Background background)
        {
            this.forDarkTheme = forDarkTheme;
            this.background = background;
        }

        public static final int CONSTRUCTOR = -1715658659;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatThemes extends Update
    {
        public ChatTheme[] chatThemes;

        public UpdateChatThemes()
        {
        }

        public UpdateChatThemes(ChatTheme[] chatThemes)
        {
            this.chatThemes = chatThemes;
        }

        public static final int CONSTRUCTOR = -1588098376;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateLanguagePackStrings extends Update
    {
        public String localizationTarget;
        public String languagePackId;
        public LanguagePackString[] strings;

        public UpdateLanguagePackStrings()
        {
        }

        public UpdateLanguagePackStrings(String localizationTarget, String languagePackId,
                LanguagePackString[] strings)
        {
            this.localizationTarget = localizationTarget;
            this.languagePackId = languagePackId;
            this.strings = strings;
        }

        public static final int CONSTRUCTOR = -1056319886;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateConnectionState extends Update
    {
        public ConnectionState state;

        public UpdateConnectionState()
        {
        }

        public UpdateConnectionState(ConnectionState state)
        {
            this.state = state;
        }

        public static final int CONSTRUCTOR = 1469292078;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateTermsOfService extends Update
    {
        public String termsOfServiceId;
        public TermsOfService termsOfService;

        public UpdateTermsOfService()
        {
        }

        public UpdateTermsOfService(String termsOfServiceId, TermsOfService termsOfService)
        {
            this.termsOfServiceId = termsOfServiceId;
            this.termsOfService = termsOfService;
        }

        public static final int CONSTRUCTOR = -1304640162;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateUsersNearby extends Update
    {
        public ChatNearby[] usersNearby;

        public UpdateUsersNearby()
        {
        }

        public UpdateUsersNearby(ChatNearby[] usersNearby)
        {
            this.usersNearby = usersNearby;
        }

        public static final int CONSTRUCTOR = -1517109163;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateDiceEmojis extends Update
    {
        public String[] emojis;

        public UpdateDiceEmojis()
        {
        }

        public UpdateDiceEmojis(String[] emojis)
        {
            this.emojis = emojis;
        }

        public static final int CONSTRUCTOR = -1069066940;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateAnimatedEmojiMessageClicked extends Update
    {
        public long chatId;
        public long messageId;
        public Sticker sticker;

        public UpdateAnimatedEmojiMessageClicked()
        {
        }

        public UpdateAnimatedEmojiMessageClicked(long chatId, long messageId, Sticker sticker)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = -1558809595;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateAnimationSearchParameters extends Update
    {
        public String provider;
        public String[] emojis;

        public UpdateAnimationSearchParameters()
        {
        }

        public UpdateAnimationSearchParameters(String provider, String[] emojis)
        {
            this.provider = provider;
            this.emojis = emojis;
        }

        public static final int CONSTRUCTOR = -1144983202;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateSuggestedActions extends Update
    {
        public SuggestedAction[] addedActions;
        public SuggestedAction[] removedActions;

        public UpdateSuggestedActions()
        {
        }

        public UpdateSuggestedActions(SuggestedAction[] addedActions,
                SuggestedAction[] removedActions)
        {
            this.addedActions = addedActions;
            this.removedActions = removedActions;
        }

        public static final int CONSTRUCTOR = 1459452346;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewInlineQuery extends Update
    {
        public long id;
        public long senderUserId;
        public Location userLocation;
        public ChatType chatType;
        public String query;
        public String offset;

        public UpdateNewInlineQuery()
        {
        }

        public UpdateNewInlineQuery(long id, long senderUserId, Location userLocation,
                ChatType chatType, String query, String offset)
        {
            this.id = id;
            this.senderUserId = senderUserId;
            this.userLocation = userLocation;
            this.chatType = chatType;
            this.query = query;
            this.offset = offset;
        }

        public static final int CONSTRUCTOR = 1903279924;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewChosenInlineResult extends Update
    {
        public long senderUserId;
        public Location userLocation;
        public String query;
        public String resultId;
        public String inlineMessageId;

        public UpdateNewChosenInlineResult()
        {
        }

        public UpdateNewChosenInlineResult(long senderUserId, Location userLocation, String query,
                String resultId, String inlineMessageId)
        {
            this.senderUserId = senderUserId;
            this.userLocation = userLocation;
            this.query = query;
            this.resultId = resultId;
            this.inlineMessageId = inlineMessageId;
        }

        public static final int CONSTRUCTOR = -884191395;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewCallbackQuery extends Update
    {
        public long id;
        public long senderUserId;
        public long chatId;
        public long messageId;
        public long chatInstance;
        public CallbackQueryPayload payload;

        public UpdateNewCallbackQuery()
        {
        }

        public UpdateNewCallbackQuery(long id, long senderUserId, long chatId, long messageId,
                long chatInstance, CallbackQueryPayload payload)
        {
            this.id = id;
            this.senderUserId = senderUserId;
            this.chatId = chatId;
            this.messageId = messageId;
            this.chatInstance = chatInstance;
            this.payload = payload;
        }

        public static final int CONSTRUCTOR = -1989881762;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewInlineCallbackQuery extends Update
    {
        public long id;
        public long senderUserId;
        public String inlineMessageId;
        public long chatInstance;
        public CallbackQueryPayload payload;

        public UpdateNewInlineCallbackQuery()
        {
        }

        public UpdateNewInlineCallbackQuery(long id, long senderUserId, String inlineMessageId,
                long chatInstance, CallbackQueryPayload payload)
        {
            this.id = id;
            this.senderUserId = senderUserId;
            this.inlineMessageId = inlineMessageId;
            this.chatInstance = chatInstance;
            this.payload = payload;
        }

        public static final int CONSTRUCTOR = -319212358;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewShippingQuery extends Update
    {
        public long id;
        public long senderUserId;
        public String invoicePayload;
        public Address shippingAddress;

        public UpdateNewShippingQuery()
        {
        }

        public UpdateNewShippingQuery(long id, long senderUserId, String invoicePayload,
                Address shippingAddress)
        {
            this.id = id;
            this.senderUserId = senderUserId;
            this.invoicePayload = invoicePayload;
            this.shippingAddress = shippingAddress;
        }

        public static final int CONSTRUCTOR = 693651058;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewPreCheckoutQuery extends Update
    {
        public long id;
        public long senderUserId;
        public String currency;
        public long totalAmount;
        public byte[] invoicePayload;
        public String shippingOptionId;
        public OrderInfo orderInfo;

        public UpdateNewPreCheckoutQuery()
        {
        }

        public UpdateNewPreCheckoutQuery(long id, long senderUserId, String currency,
                long totalAmount, byte[] invoicePayload, String shippingOptionId,
                OrderInfo orderInfo)
        {
            this.id = id;
            this.senderUserId = senderUserId;
            this.currency = currency;
            this.totalAmount = totalAmount;
            this.invoicePayload = invoicePayload;
            this.shippingOptionId = shippingOptionId;
            this.orderInfo = orderInfo;
        }

        public static final int CONSTRUCTOR = 708342217;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewCustomEvent extends Update
    {
        public String event;

        public UpdateNewCustomEvent()
        {
        }

        public UpdateNewCustomEvent(String event)
        {
            this.event = event;
        }

        public static final int CONSTRUCTOR = 1994222092;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewCustomQuery extends Update
    {
        public long id;
        public String data;
        public int timeout;

        public UpdateNewCustomQuery()
        {
        }

        public UpdateNewCustomQuery(long id, String data, int timeout)
        {
            this.id = id;
            this.data = data;
            this.timeout = timeout;
        }

        public static final int CONSTRUCTOR = -687670874;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdatePoll extends Update
    {
        public Poll poll;

        public UpdatePoll()
        {
        }

        public UpdatePoll(Poll poll)
        {
            this.poll = poll;
        }

        public static final int CONSTRUCTOR = -1771342902;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdatePollAnswer extends Update
    {
        public long pollId;
        public long userId;
        public int[] optionIds;

        public UpdatePollAnswer()
        {
        }

        public UpdatePollAnswer(long pollId, long userId, int[] optionIds)
        {
            this.pollId = pollId;
            this.userId = userId;
            this.optionIds = optionIds;
        }

        public static final int CONSTRUCTOR = -1209100651;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateChatMember extends Update
    {
        public long chatId;
        public long actorUserId;
        public int date;
        public ChatInviteLink inviteLink;
        public ChatMember oldChatMember;
        public ChatMember newChatMember;

        public UpdateChatMember()
        {
        }

        public UpdateChatMember(long chatId, long actorUserId, int date, ChatInviteLink inviteLink,
                ChatMember oldChatMember, ChatMember newChatMember)
        {
            this.chatId = chatId;
            this.actorUserId = actorUserId;
            this.date = date;
            this.inviteLink = inviteLink;
            this.oldChatMember = oldChatMember;
            this.newChatMember = newChatMember;
        }

        public static final int CONSTRUCTOR = -2027989165;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpdateNewChatJoinRequest extends Update
    {
        public long chatId;
        public ChatJoinRequest request;
        public ChatInviteLink inviteLink;

        public UpdateNewChatJoinRequest()
        {
        }

        public UpdateNewChatJoinRequest(long chatId, ChatJoinRequest request,
                ChatInviteLink inviteLink)
        {
            this.chatId = chatId;
            this.request = request;
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = 175285905;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Updates extends Object
    {
        public Update[] updates;

        public Updates()
        {
        }

        public Updates(Update[] updates)
        {
            this.updates = updates;
        }

        public static final int CONSTRUCTOR = 475842347;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class User extends Object
    {
        public long id;
        public String firstName;
        public String lastName;
        public String username;
        public String phoneNumber;
        public UserStatus status;
        public ProfilePhoto profilePhoto;
        public boolean isContact;
        public boolean isMutualContact;
        public boolean isVerified;
        public boolean isSupport;
        public String restrictionReason;
        public boolean isScam;
        public boolean isFake;
        public boolean haveAccess;
        public UserType type;
        public String languageCode;

        public User()
        {
        }

        public User(long id, String firstName, String lastName, String username, String phoneNumber,
                UserStatus status, ProfilePhoto profilePhoto, boolean isContact,
                boolean isMutualContact, boolean isVerified, boolean isSupport,
                String restrictionReason, boolean isScam, boolean isFake, boolean haveAccess,
                UserType type, String languageCode)
        {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
            this.phoneNumber = phoneNumber;
            this.status = status;
            this.profilePhoto = profilePhoto;
            this.isContact = isContact;
            this.isMutualContact = isMutualContact;
            this.isVerified = isVerified;
            this.isSupport = isSupport;
            this.restrictionReason = restrictionReason;
            this.isScam = isScam;
            this.isFake = isFake;
            this.haveAccess = haveAccess;
            this.type = type;
            this.languageCode = languageCode;
        }

        public static final int CONSTRUCTOR = -537797015;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserFullInfo extends Object
    {
        public ChatPhoto photo;
        public boolean isBlocked;
        public boolean canBeCalled;
        public boolean supportsVideoCalls;
        public boolean hasPrivateCalls;
        public boolean hasPrivateForwards;
        public boolean needPhoneNumberPrivacyException;
        public String bio;
        public String shareText;
        public String description;
        public int groupInCommonCount;
        public BotCommand[] commands;

        public UserFullInfo()
        {
        }

        public UserFullInfo(ChatPhoto photo, boolean isBlocked, boolean canBeCalled,
                boolean supportsVideoCalls, boolean hasPrivateCalls, boolean hasPrivateForwards,
                boolean needPhoneNumberPrivacyException, String bio, String shareText,
                String description, int groupInCommonCount, BotCommand[] commands)
        {
            this.photo = photo;
            this.isBlocked = isBlocked;
            this.canBeCalled = canBeCalled;
            this.supportsVideoCalls = supportsVideoCalls;
            this.hasPrivateCalls = hasPrivateCalls;
            this.hasPrivateForwards = hasPrivateForwards;
            this.needPhoneNumberPrivacyException = needPhoneNumberPrivacyException;
            this.bio = bio;
            this.shareText = shareText;
            this.description = description;
            this.groupInCommonCount = groupInCommonCount;
            this.commands = commands;
        }

        public static final int CONSTRUCTOR = 2138747126;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class UserPrivacySetting extends Object
    {
    }

    public static class UserPrivacySettingShowStatus extends UserPrivacySetting
    {

        public UserPrivacySettingShowStatus()
        {
        }

        public static final int CONSTRUCTOR = 1862829310;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingShowProfilePhoto extends UserPrivacySetting
    {

        public UserPrivacySettingShowProfilePhoto()
        {
        }

        public static final int CONSTRUCTOR = 1408485877;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingShowLinkInForwardedMessages extends UserPrivacySetting
    {

        public UserPrivacySettingShowLinkInForwardedMessages()
        {
        }

        public static final int CONSTRUCTOR = 592688870;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingShowPhoneNumber extends UserPrivacySetting
    {

        public UserPrivacySettingShowPhoneNumber()
        {
        }

        public static final int CONSTRUCTOR = -791567831;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingAllowChatInvites extends UserPrivacySetting
    {

        public UserPrivacySettingAllowChatInvites()
        {
        }

        public static final int CONSTRUCTOR = 1271668007;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingAllowCalls extends UserPrivacySetting
    {

        public UserPrivacySettingAllowCalls()
        {
        }

        public static final int CONSTRUCTOR = -906967291;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingAllowPeerToPeerCalls extends UserPrivacySetting
    {

        public UserPrivacySettingAllowPeerToPeerCalls()
        {
        }

        public static final int CONSTRUCTOR = 352500032;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingAllowFindingByPhoneNumber extends UserPrivacySetting
    {

        public UserPrivacySettingAllowFindingByPhoneNumber()
        {
        }

        public static final int CONSTRUCTOR = -1846645423;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class UserPrivacySettingRule extends Object
    {
    }

    public static class UserPrivacySettingRuleAllowAll extends UserPrivacySettingRule
    {

        public UserPrivacySettingRuleAllowAll()
        {
        }

        public static final int CONSTRUCTOR = -1967186881;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingRuleAllowContacts extends UserPrivacySettingRule
    {

        public UserPrivacySettingRuleAllowContacts()
        {
        }

        public static final int CONSTRUCTOR = -1892733680;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingRuleAllowUsers extends UserPrivacySettingRule
    {
        public long[] userIds;

        public UserPrivacySettingRuleAllowUsers()
        {
        }

        public UserPrivacySettingRuleAllowUsers(long[] userIds)
        {
            this.userIds = userIds;
        }

        public static final int CONSTRUCTOR = 1110988334;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingRuleAllowChatMembers extends UserPrivacySettingRule
    {
        public long[] chatIds;

        public UserPrivacySettingRuleAllowChatMembers()
        {
        }

        public UserPrivacySettingRuleAllowChatMembers(long[] chatIds)
        {
            this.chatIds = chatIds;
        }

        public static final int CONSTRUCTOR = -2048749863;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingRuleRestrictAll extends UserPrivacySettingRule
    {

        public UserPrivacySettingRuleRestrictAll()
        {
        }

        public static final int CONSTRUCTOR = -1406495408;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingRuleRestrictContacts extends UserPrivacySettingRule
    {

        public UserPrivacySettingRuleRestrictContacts()
        {
        }

        public static final int CONSTRUCTOR = 1008389378;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingRuleRestrictUsers extends UserPrivacySettingRule
    {
        public long[] userIds;

        public UserPrivacySettingRuleRestrictUsers()
        {
        }

        public UserPrivacySettingRuleRestrictUsers(long[] userIds)
        {
            this.userIds = userIds;
        }

        public static final int CONSTRUCTOR = 622796522;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingRuleRestrictChatMembers extends UserPrivacySettingRule
    {
        public long[] chatIds;

        public UserPrivacySettingRuleRestrictChatMembers()
        {
        }

        public UserPrivacySettingRuleRestrictChatMembers(long[] chatIds)
        {
            this.chatIds = chatIds;
        }

        public static final int CONSTRUCTOR = 392530897;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserPrivacySettingRules extends Object
    {
        public UserPrivacySettingRule[] rules;

        public UserPrivacySettingRules()
        {
        }

        public UserPrivacySettingRules(UserPrivacySettingRule[] rules)
        {
            this.rules = rules;
        }

        public static final int CONSTRUCTOR = 322477541;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class UserStatus extends Object
    {
    }

    public static class UserStatusEmpty extends UserStatus
    {

        public UserStatusEmpty()
        {
        }

        public static final int CONSTRUCTOR = 164646985;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserStatusOnline extends UserStatus
    {
        public int expires;

        public UserStatusOnline()
        {
        }

        public UserStatusOnline(int expires)
        {
            this.expires = expires;
        }

        public static final int CONSTRUCTOR = -1529460876;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserStatusOffline extends UserStatus
    {
        public int wasOnline;

        public UserStatusOffline()
        {
        }

        public UserStatusOffline(int wasOnline)
        {
            this.wasOnline = wasOnline;
        }

        public static final int CONSTRUCTOR = -759984891;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserStatusRecently extends UserStatus
    {

        public UserStatusRecently()
        {
        }

        public static final int CONSTRUCTOR = -496024847;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserStatusLastWeek extends UserStatus
    {

        public UserStatusLastWeek()
        {
        }

        public static final int CONSTRUCTOR = 129960444;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserStatusLastMonth extends UserStatus
    {

        public UserStatusLastMonth()
        {
        }

        public static final int CONSTRUCTOR = 2011940674;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class UserType extends Object
    {
    }

    public static class UserTypeRegular extends UserType
    {

        public UserTypeRegular()
        {
        }

        public static final int CONSTRUCTOR = -598644325;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserTypeDeleted extends UserType
    {

        public UserTypeDeleted()
        {
        }

        public static final int CONSTRUCTOR = -1807729372;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserTypeBot extends UserType
    {
        public boolean canJoinGroups;
        public boolean canReadAllGroupMessages;
        public boolean isInline;
        public String inlineQueryPlaceholder;
        public boolean needLocation;

        public UserTypeBot()
        {
        }

        public UserTypeBot(boolean canJoinGroups, boolean canReadAllGroupMessages, boolean isInline,
                String inlineQueryPlaceholder, boolean needLocation)
        {
            this.canJoinGroups = canJoinGroups;
            this.canReadAllGroupMessages = canReadAllGroupMessages;
            this.isInline = isInline;
            this.inlineQueryPlaceholder = inlineQueryPlaceholder;
            this.needLocation = needLocation;
        }

        public static final int CONSTRUCTOR = 1262387765;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UserTypeUnknown extends UserType
    {

        public UserTypeUnknown()
        {
        }

        public static final int CONSTRUCTOR = -724541123;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Users extends Object
    {
        public int totalCount;
        public long[] userIds;

        public Users()
        {
        }

        public Users(int totalCount, long[] userIds)
        {
            this.totalCount = totalCount;
            this.userIds = userIds;
        }

        public static final int CONSTRUCTOR = 171203420;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ValidatedOrderInfo extends Object
    {
        public String orderInfoId;
        public ShippingOption[] shippingOptions;

        public ValidatedOrderInfo()
        {
        }

        public ValidatedOrderInfo(String orderInfoId, ShippingOption[] shippingOptions)
        {
            this.orderInfoId = orderInfoId;
            this.shippingOptions = shippingOptions;
        }

        public static final int CONSTRUCTOR = 1511451484;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public abstract static class VectorPathCommand extends Object
    {
    }

    public static class VectorPathCommandLine extends VectorPathCommand
    {
        public Point endPoint;

        public VectorPathCommandLine()
        {
        }

        public VectorPathCommandLine(Point endPoint)
        {
            this.endPoint = endPoint;
        }

        public static final int CONSTRUCTOR = -614056822;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class VectorPathCommandCubicBezierCurve extends VectorPathCommand
    {
        public Point startControlPoint;
        public Point endControlPoint;
        public Point endPoint;

        public VectorPathCommandCubicBezierCurve()
        {
        }

        public VectorPathCommandCubicBezierCurve(Point startControlPoint, Point endControlPoint,
                Point endPoint)
        {
            this.startControlPoint = startControlPoint;
            this.endControlPoint = endControlPoint;
            this.endPoint = endPoint;
        }

        public static final int CONSTRUCTOR = 1229733434;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Venue extends Object
    {
        public Location location;
        public String title;
        public String address;
        public String provider;
        public String id;
        public String type;

        public Venue()
        {
        }

        public Venue(Location location, String title, String address, String provider, String id,
                String type)
        {
            this.location = location;
            this.title = title;
            this.address = address;
            this.provider = provider;
            this.id = id;
            this.type = type;
        }

        public static final int CONSTRUCTOR = 1070406393;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Video extends Object
    {
        public int duration;
        public int width;
        public int height;
        public String fileName;
        public String mimeType;
        public boolean hasStickers;
        public boolean supportsStreaming;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File video;

        public Video()
        {
        }

        public Video(int duration, int width, int height, String fileName, String mimeType,
                boolean hasStickers, boolean supportsStreaming, Minithumbnail minithumbnail,
                Thumbnail thumbnail, File video)
        {
            this.duration = duration;
            this.width = width;
            this.height = height;
            this.fileName = fileName;
            this.mimeType = mimeType;
            this.hasStickers = hasStickers;
            this.supportsStreaming = supportsStreaming;
            this.minithumbnail = minithumbnail;
            this.thumbnail = thumbnail;
            this.video = video;
        }

        public static final int CONSTRUCTOR = 832856268;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class VideoChat extends Object
    {
        public int groupCallId;
        public boolean hasParticipants;
        public MessageSender defaultParticipantId;

        public VideoChat()
        {
        }

        public VideoChat(int groupCallId, boolean hasParticipants,
                MessageSender defaultParticipantId)
        {
            this.groupCallId = groupCallId;
            this.hasParticipants = hasParticipants;
            this.defaultParticipantId = defaultParticipantId;
        }

        public static final int CONSTRUCTOR = -1374319320;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class VideoNote extends Object
    {
        public int duration;
        public int length;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File video;

        public VideoNote()
        {
        }

        public VideoNote(int duration, int length, Minithumbnail minithumbnail, Thumbnail thumbnail,
                File video)
        {
            this.duration = duration;
            this.length = length;
            this.minithumbnail = minithumbnail;
            this.thumbnail = thumbnail;
            this.video = video;
        }

        public static final int CONSTRUCTOR = -71734726;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class VoiceNote extends Object
    {
        public int duration;
        public byte[] waveform;
        public String mimeType;
        public File voice;

        public VoiceNote()
        {
        }

        public VoiceNote(int duration, byte[] waveform, String mimeType, File voice)
        {
            this.duration = duration;
            this.waveform = waveform;
            this.mimeType = mimeType;
            this.voice = voice;
        }

        public static final int CONSTRUCTOR = -2066012058;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class WebPage extends Object
    {
        public String url;
        public String displayUrl;
        public String type;
        public String siteName;
        public String title;
        public FormattedText description;
        public Photo photo;
        public String embedUrl;
        public String embedType;
        public int embedWidth;
        public int embedHeight;
        public int duration;
        public String author;
        public Animation animation;
        public Audio audio;
        public Document document;
        public Sticker sticker;
        public Video video;
        public VideoNote videoNote;
        public VoiceNote voiceNote;
        public int instantViewVersion;

        public WebPage()
        {
        }

        public WebPage(String url, String displayUrl, String type, String siteName, String title,
                FormattedText description, Photo photo, String embedUrl, String embedType,
                int embedWidth, int embedHeight, int duration, String author, Animation animation,
                Audio audio, Document document, Sticker sticker, Video video, VideoNote videoNote,
                VoiceNote voiceNote, int instantViewVersion)
        {
            this.url = url;
            this.displayUrl = displayUrl;
            this.type = type;
            this.siteName = siteName;
            this.title = title;
            this.description = description;
            this.photo = photo;
            this.embedUrl = embedUrl;
            this.embedType = embedType;
            this.embedWidth = embedWidth;
            this.embedHeight = embedHeight;
            this.duration = duration;
            this.author = author;
            this.animation = animation;
            this.audio = audio;
            this.document = document;
            this.sticker = sticker;
            this.video = video;
            this.videoNote = videoNote;
            this.voiceNote = voiceNote;
            this.instantViewVersion = instantViewVersion;
        }

        public static final int CONSTRUCTOR = -577333714;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class WebPageInstantView extends Object
    {
        public PageBlock[] pageBlocks;
        public int viewCount;
        public int version;
        public boolean isRtl;
        public boolean isFull;
        public InternalLinkType feedbackLink;

        public WebPageInstantView()
        {
        }

        public WebPageInstantView(PageBlock[] pageBlocks, int viewCount, int version, boolean isRtl,
                boolean isFull, InternalLinkType feedbackLink)
        {
            this.pageBlocks = pageBlocks;
            this.viewCount = viewCount;
            this.version = version;
            this.isRtl = isRtl;
            this.isFull = isFull;
            this.feedbackLink = feedbackLink;
        }

        public static final int CONSTRUCTOR = 778202453;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AcceptCall extends Function
    {
        public int callId;
        public CallProtocol protocol;

        public AcceptCall()
        {
        }

        public AcceptCall(int callId, CallProtocol protocol)
        {
            this.callId = callId;
            this.protocol = protocol;
        }

        public static final int CONSTRUCTOR = -646618416;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AcceptTermsOfService extends Function
    {
        public String termsOfServiceId;

        public AcceptTermsOfService()
        {
        }

        public AcceptTermsOfService(String termsOfServiceId)
        {
            this.termsOfServiceId = termsOfServiceId;
        }

        public static final int CONSTRUCTOR = 2130576356;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddChatMember extends Function
    {
        public long chatId;
        public long userId;
        public int forwardLimit;

        public AddChatMember()
        {
        }

        public AddChatMember(long chatId, long userId, int forwardLimit)
        {
            this.chatId = chatId;
            this.userId = userId;
            this.forwardLimit = forwardLimit;
        }

        public static final int CONSTRUCTOR = 499426810;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddChatMembers extends Function
    {
        public long chatId;
        public long[] userIds;

        public AddChatMembers()
        {
        }

        public AddChatMembers(long chatId, long[] userIds)
        {
            this.chatId = chatId;
            this.userIds = userIds;
        }

        public static final int CONSTRUCTOR = -519951226;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddChatToList extends Function
    {
        public long chatId;
        public ChatList chatList;

        public AddChatToList()
        {
        }

        public AddChatToList(long chatId, ChatList chatList)
        {
            this.chatId = chatId;
            this.chatList = chatList;
        }

        public static final int CONSTRUCTOR = -80523595;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddContact extends Function
    {
        public Contact contact;
        public boolean sharePhoneNumber;

        public AddContact()
        {
        }

        public AddContact(Contact contact, boolean sharePhoneNumber)
        {
            this.contact = contact;
            this.sharePhoneNumber = sharePhoneNumber;
        }

        public static final int CONSTRUCTOR = 1869640000;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddCustomServerLanguagePack extends Function
    {
        public String languagePackId;

        public AddCustomServerLanguagePack()
        {
        }

        public AddCustomServerLanguagePack(String languagePackId)
        {
            this.languagePackId = languagePackId;
        }

        public static final int CONSTRUCTOR = 4492771;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddFavoriteSticker extends Function
    {
        public InputFile sticker;

        public AddFavoriteSticker()
        {
        }

        public AddFavoriteSticker(InputFile sticker)
        {
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = 324504799;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddLocalMessage extends Function
    {
        public long chatId;
        public MessageSender senderId;
        public long replyToMessageId;
        public boolean disableNotification;
        public InputMessageContent inputMessageContent;

        public AddLocalMessage()
        {
        }

        public AddLocalMessage(long chatId, MessageSender senderId, long replyToMessageId,
                boolean disableNotification, InputMessageContent inputMessageContent)
        {
            this.chatId = chatId;
            this.senderId = senderId;
            this.replyToMessageId = replyToMessageId;
            this.disableNotification = disableNotification;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = -1998878725;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddLogMessage extends Function
    {
        public int verbosityLevel;
        public String text;

        public AddLogMessage()
        {
        }

        public AddLogMessage(int verbosityLevel, String text)
        {
            this.verbosityLevel = verbosityLevel;
            this.text = text;
        }

        public static final int CONSTRUCTOR = 1597427692;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddNetworkStatistics extends Function
    {
        public NetworkStatisticsEntry entry;

        public AddNetworkStatistics()
        {
        }

        public AddNetworkStatistics(NetworkStatisticsEntry entry)
        {
            this.entry = entry;
        }

        public static final int CONSTRUCTOR = 1264825305;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddProxy extends Function
    {
        public String server;
        public int port;
        public boolean enable;
        public ProxyType type;

        public AddProxy()
        {
        }

        public AddProxy(String server, int port, boolean enable, ProxyType type)
        {
            this.server = server;
            this.port = port;
            this.enable = enable;
            this.type = type;
        }

        public static final int CONSTRUCTOR = 331529432;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddRecentSticker extends Function
    {
        public boolean isAttached;
        public InputFile sticker;

        public AddRecentSticker()
        {
        }

        public AddRecentSticker(boolean isAttached, InputFile sticker)
        {
            this.isAttached = isAttached;
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = -1478109026;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddRecentlyFoundChat extends Function
    {
        public long chatId;

        public AddRecentlyFoundChat()
        {
        }

        public AddRecentlyFoundChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -1746396787;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddSavedAnimation extends Function
    {
        public InputFile animation;

        public AddSavedAnimation()
        {
        }

        public AddSavedAnimation(InputFile animation)
        {
            this.animation = animation;
        }

        public static final int CONSTRUCTOR = -1538525088;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AddStickerToSet extends Function
    {
        public long userId;
        public String name;
        public InputSticker sticker;

        public AddStickerToSet()
        {
        }

        public AddStickerToSet(long userId, String name, InputSticker sticker)
        {
            this.userId = userId;
            this.name = name;
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = 3869569;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AnswerCallbackQuery extends Function
    {
        public long callbackQueryId;
        public String text;
        public boolean showAlert;
        public String url;
        public int cacheTime;

        public AnswerCallbackQuery()
        {
        }

        public AnswerCallbackQuery(long callbackQueryId, String text, boolean showAlert, String url,
                int cacheTime)
        {
            this.callbackQueryId = callbackQueryId;
            this.text = text;
            this.showAlert = showAlert;
            this.url = url;
            this.cacheTime = cacheTime;
        }

        public static final int CONSTRUCTOR = -1153028490;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AnswerCustomQuery extends Function
    {
        public long customQueryId;
        public String data;

        public AnswerCustomQuery()
        {
        }

        public AnswerCustomQuery(long customQueryId, String data)
        {
            this.customQueryId = customQueryId;
            this.data = data;
        }

        public static final int CONSTRUCTOR = -1293603521;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AnswerInlineQuery extends Function
    {
        public long inlineQueryId;
        public boolean isPersonal;
        public InputInlineQueryResult[] results;
        public int cacheTime;
        public String nextOffset;
        public String switchPmText;
        public String switchPmParameter;

        public AnswerInlineQuery()
        {
        }

        public AnswerInlineQuery(long inlineQueryId, boolean isPersonal,
                InputInlineQueryResult[] results, int cacheTime, String nextOffset,
                String switchPmText, String switchPmParameter)
        {
            this.inlineQueryId = inlineQueryId;
            this.isPersonal = isPersonal;
            this.results = results;
            this.cacheTime = cacheTime;
            this.nextOffset = nextOffset;
            this.switchPmText = switchPmText;
            this.switchPmParameter = switchPmParameter;
        }

        public static final int CONSTRUCTOR = 485879477;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AnswerPreCheckoutQuery extends Function
    {
        public long preCheckoutQueryId;
        public String errorMessage;

        public AnswerPreCheckoutQuery()
        {
        }

        public AnswerPreCheckoutQuery(long preCheckoutQueryId, String errorMessage)
        {
            this.preCheckoutQueryId = preCheckoutQueryId;
            this.errorMessage = errorMessage;
        }

        public static final int CONSTRUCTOR = -1486789653;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class AnswerShippingQuery extends Function
    {
        public long shippingQueryId;
        public ShippingOption[] shippingOptions;
        public String errorMessage;

        public AnswerShippingQuery()
        {
        }

        public AnswerShippingQuery(long shippingQueryId, ShippingOption[] shippingOptions,
                String errorMessage)
        {
            this.shippingQueryId = shippingQueryId;
            this.shippingOptions = shippingOptions;
            this.errorMessage = errorMessage;
        }

        public static final int CONSTRUCTOR = -434601324;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BanChatMember extends Function
    {
        public long chatId;
        public MessageSender memberId;
        public int bannedUntilDate;
        public boolean revokeMessages;

        public BanChatMember()
        {
        }

        public BanChatMember(long chatId, MessageSender memberId, int bannedUntilDate,
                boolean revokeMessages)
        {
            this.chatId = chatId;
            this.memberId = memberId;
            this.bannedUntilDate = bannedUntilDate;
            this.revokeMessages = revokeMessages;
        }

        public static final int CONSTRUCTOR = -888111748;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class BlockMessageSenderFromReplies extends Function
    {
        public long messageId;
        public boolean deleteMessage;
        public boolean deleteAllMessages;
        public boolean reportSpam;

        public BlockMessageSenderFromReplies()
        {
        }

        public BlockMessageSenderFromReplies(long messageId, boolean deleteMessage,
                boolean deleteAllMessages, boolean reportSpam)
        {
            this.messageId = messageId;
            this.deleteMessage = deleteMessage;
            this.deleteAllMessages = deleteAllMessages;
            this.reportSpam = reportSpam;
        }

        public static final int CONSTRUCTOR = -1214384757;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CanTransferOwnership extends Function
    {

        public CanTransferOwnership()
        {
        }

        public static final int CONSTRUCTOR = 634602508;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CancelDownloadFile extends Function
    {
        public int fileId;
        public boolean onlyIfPending;

        public CancelDownloadFile()
        {
        }

        public CancelDownloadFile(int fileId, boolean onlyIfPending)
        {
            this.fileId = fileId;
            this.onlyIfPending = onlyIfPending;
        }

        public static final int CONSTRUCTOR = -1954524450;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CancelPasswordReset extends Function
    {

        public CancelPasswordReset()
        {
        }

        public static final int CONSTRUCTOR = 940733538;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CancelUploadFile extends Function
    {
        public int fileId;

        public CancelUploadFile()
        {
        }

        public CancelUploadFile(int fileId)
        {
            this.fileId = fileId;
        }

        public static final int CONSTRUCTOR = 1623539600;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChangeImportedContacts extends Function
    {
        public Contact[] contacts;

        public ChangeImportedContacts()
        {
        }

        public ChangeImportedContacts(Contact[] contacts)
        {
            this.contacts = contacts;
        }

        public static final int CONSTRUCTOR = 1968207955;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChangePhoneNumber extends Function
    {
        public String phoneNumber;
        public PhoneNumberAuthenticationSettings settings;

        public ChangePhoneNumber()
        {
        }

        public ChangePhoneNumber(String phoneNumber, PhoneNumberAuthenticationSettings settings)
        {
            this.phoneNumber = phoneNumber;
            this.settings = settings;
        }

        public static final int CONSTRUCTOR = -124666973;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ChangeStickerSet extends Function
    {
        public long setId;
        public boolean isInstalled;
        public boolean isArchived;

        public ChangeStickerSet()
        {
        }

        public ChangeStickerSet(long setId, boolean isInstalled, boolean isArchived)
        {
            this.setId = setId;
            this.isInstalled = isInstalled;
            this.isArchived = isArchived;
        }

        public static final int CONSTRUCTOR = 449357293;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckAuthenticationBotToken extends Function
    {
        public String token;

        public CheckAuthenticationBotToken()
        {
        }

        public CheckAuthenticationBotToken(String token)
        {
            this.token = token;
        }

        public static final int CONSTRUCTOR = 639321206;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckAuthenticationCode extends Function
    {
        public String code;

        public CheckAuthenticationCode()
        {
        }

        public CheckAuthenticationCode(String code)
        {
            this.code = code;
        }

        public static final int CONSTRUCTOR = -302103382;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckAuthenticationPassword extends Function
    {
        public String password;

        public CheckAuthenticationPassword()
        {
        }

        public CheckAuthenticationPassword(String password)
        {
            this.password = password;
        }

        public static final int CONSTRUCTOR = -2025698400;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckAuthenticationPasswordRecoveryCode extends Function
    {
        public String recoveryCode;

        public CheckAuthenticationPasswordRecoveryCode()
        {
        }

        public CheckAuthenticationPasswordRecoveryCode(String recoveryCode)
        {
            this.recoveryCode = recoveryCode;
        }

        public static final int CONSTRUCTOR = -603309083;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckChangePhoneNumberCode extends Function
    {
        public String code;

        public CheckChangePhoneNumberCode()
        {
        }

        public CheckChangePhoneNumberCode(String code)
        {
            this.code = code;
        }

        public static final int CONSTRUCTOR = -1720278429;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckChatInviteLink extends Function
    {
        public String inviteLink;

        public CheckChatInviteLink()
        {
        }

        public CheckChatInviteLink(String inviteLink)
        {
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = -496940997;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckChatUsername extends Function
    {
        public long chatId;
        public String username;

        public CheckChatUsername()
        {
        }

        public CheckChatUsername(long chatId, String username)
        {
            this.chatId = chatId;
            this.username = username;
        }

        public static final int CONSTRUCTOR = -119119344;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckCreatedPublicChatsLimit extends Function
    {
        public PublicChatType type;

        public CheckCreatedPublicChatsLimit()
        {
        }

        public CheckCreatedPublicChatsLimit(PublicChatType type)
        {
            this.type = type;
        }

        public static final int CONSTRUCTOR = -445546591;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckDatabaseEncryptionKey extends Function
    {
        public byte[] encryptionKey;

        public CheckDatabaseEncryptionKey()
        {
        }

        public CheckDatabaseEncryptionKey(byte[] encryptionKey)
        {
            this.encryptionKey = encryptionKey;
        }

        public static final int CONSTRUCTOR = 1018769307;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckEmailAddressVerificationCode extends Function
    {
        public String code;

        public CheckEmailAddressVerificationCode()
        {
        }

        public CheckEmailAddressVerificationCode(String code)
        {
            this.code = code;
        }

        public static final int CONSTRUCTOR = -426386685;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckPasswordRecoveryCode extends Function
    {
        public String recoveryCode;

        public CheckPasswordRecoveryCode()
        {
        }

        public CheckPasswordRecoveryCode(String recoveryCode)
        {
            this.recoveryCode = recoveryCode;
        }

        public static final int CONSTRUCTOR = -200794600;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckPhoneNumberConfirmationCode extends Function
    {
        public String code;

        public CheckPhoneNumberConfirmationCode()
        {
        }

        public CheckPhoneNumberConfirmationCode(String code)
        {
            this.code = code;
        }

        public static final int CONSTRUCTOR = -1348060966;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckPhoneNumberVerificationCode extends Function
    {
        public String code;

        public CheckPhoneNumberVerificationCode()
        {
        }

        public CheckPhoneNumberVerificationCode(String code)
        {
            this.code = code;
        }

        public static final int CONSTRUCTOR = 1497462718;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckRecoveryEmailAddressCode extends Function
    {
        public String code;

        public CheckRecoveryEmailAddressCode()
        {
        }

        public CheckRecoveryEmailAddressCode(String code)
        {
            this.code = code;
        }

        public static final int CONSTRUCTOR = -1997039589;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CheckStickerSetName extends Function
    {
        public String name;

        public CheckStickerSetName()
        {
        }

        public CheckStickerSetName(String name)
        {
            this.name = name;
        }

        public static final int CONSTRUCTOR = -1789392642;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CleanFileName extends Function
    {
        public String fileName;

        public CleanFileName()
        {
        }

        public CleanFileName(String fileName)
        {
            this.fileName = fileName;
        }

        public static final int CONSTRUCTOR = 967964667;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ClearAllDraftMessages extends Function
    {
        public boolean excludeSecretChats;

        public ClearAllDraftMessages()
        {
        }

        public ClearAllDraftMessages(boolean excludeSecretChats)
        {
            this.excludeSecretChats = excludeSecretChats;
        }

        public static final int CONSTRUCTOR = -46369573;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ClearImportedContacts extends Function
    {

        public ClearImportedContacts()
        {
        }

        public static final int CONSTRUCTOR = 869503298;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ClearRecentStickers extends Function
    {
        public boolean isAttached;

        public ClearRecentStickers()
        {
        }

        public ClearRecentStickers(boolean isAttached)
        {
            this.isAttached = isAttached;
        }

        public static final int CONSTRUCTOR = -321242684;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ClearRecentlyFoundChats extends Function
    {

        public ClearRecentlyFoundChats()
        {
        }

        public static final int CONSTRUCTOR = -285582542;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ClickAnimatedEmojiMessage extends Function
    {
        public long chatId;
        public long messageId;

        public ClickAnimatedEmojiMessage()
        {
        }

        public ClickAnimatedEmojiMessage(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = 196179554;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Close extends Function
    {

        public Close()
        {
        }

        public static final int CONSTRUCTOR = -1187782273;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CloseChat extends Function
    {
        public long chatId;

        public CloseChat()
        {
        }

        public CloseChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 39749353;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CloseSecretChat extends Function
    {
        public int secretChatId;

        public CloseSecretChat()
        {
        }

        public CloseSecretChat(int secretChatId)
        {
            this.secretChatId = secretChatId;
        }

        public static final int CONSTRUCTOR = -471006133;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ConfirmQrCodeAuthentication extends Function
    {
        public String link;

        public ConfirmQrCodeAuthentication()
        {
        }

        public ConfirmQrCodeAuthentication(String link)
        {
            this.link = link;
        }

        public static final int CONSTRUCTOR = -376199379;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateBasicGroupChat extends Function
    {
        public long basicGroupId;
        public boolean force;

        public CreateBasicGroupChat()
        {
        }

        public CreateBasicGroupChat(long basicGroupId, boolean force)
        {
            this.basicGroupId = basicGroupId;
            this.force = force;
        }

        public static final int CONSTRUCTOR = 1972024548;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateCall extends Function
    {
        public long userId;
        public CallProtocol protocol;
        public boolean isVideo;

        public CreateCall()
        {
        }

        public CreateCall(long userId, CallProtocol protocol, boolean isVideo)
        {
            this.userId = userId;
            this.protocol = protocol;
            this.isVideo = isVideo;
        }

        public static final int CONSTRUCTOR = -1104663024;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateChatFilter extends Function
    {
        public ChatFilter filter;

        public CreateChatFilter()
        {
        }

        public CreateChatFilter(ChatFilter filter)
        {
            this.filter = filter;
        }

        public static final int CONSTRUCTOR = 49065126;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateChatInviteLink extends Function
    {
        public long chatId;
        public String name;
        public int expirationDate;
        public int memberLimit;
        public boolean createsJoinRequest;

        public CreateChatInviteLink()
        {
        }

        public CreateChatInviteLink(long chatId, String name, int expirationDate, int memberLimit,
                boolean createsJoinRequest)
        {
            this.chatId = chatId;
            this.name = name;
            this.expirationDate = expirationDate;
            this.memberLimit = memberLimit;
            this.createsJoinRequest = createsJoinRequest;
        }

        public static final int CONSTRUCTOR = 287744833;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateNewBasicGroupChat extends Function
    {
        public long[] userIds;
        public String title;

        public CreateNewBasicGroupChat()
        {
        }

        public CreateNewBasicGroupChat(long[] userIds, String title)
        {
            this.userIds = userIds;
            this.title = title;
        }

        public static final int CONSTRUCTOR = -2104438789;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateNewSecretChat extends Function
    {
        public long userId;

        public CreateNewSecretChat()
        {
        }

        public CreateNewSecretChat(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = -620682651;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateNewStickerSet extends Function
    {
        public long userId;
        public String title;
        public String name;
        public boolean isMasks;
        public InputSticker[] stickers;
        public String source;

        public CreateNewStickerSet()
        {
        }

        public CreateNewStickerSet(long userId, String title, String name, boolean isMasks,
                InputSticker[] stickers, String source)
        {
            this.userId = userId;
            this.title = title;
            this.name = name;
            this.isMasks = isMasks;
            this.stickers = stickers;
            this.source = source;
        }

        public static final int CONSTRUCTOR = -396493358;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateNewSupergroupChat extends Function
    {
        public String title;
        public boolean isChannel;
        public String description;
        public ChatLocation location;
        public boolean forImport;

        public CreateNewSupergroupChat()
        {
        }

        public CreateNewSupergroupChat(String title, boolean isChannel, String description,
                ChatLocation location, boolean forImport)
        {
            this.title = title;
            this.isChannel = isChannel;
            this.description = description;
            this.location = location;
            this.forImport = forImport;
        }

        public static final int CONSTRUCTOR = -830232895;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreatePrivateChat extends Function
    {
        public long userId;
        public boolean force;

        public CreatePrivateChat()
        {
        }

        public CreatePrivateChat(long userId, boolean force)
        {
            this.userId = userId;
            this.force = force;
        }

        public static final int CONSTRUCTOR = -947758327;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateSecretChat extends Function
    {
        public int secretChatId;

        public CreateSecretChat()
        {
        }

        public CreateSecretChat(int secretChatId)
        {
            this.secretChatId = secretChatId;
        }

        public static final int CONSTRUCTOR = 1930285615;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateSupergroupChat extends Function
    {
        public long supergroupId;
        public boolean force;

        public CreateSupergroupChat()
        {
        }

        public CreateSupergroupChat(long supergroupId, boolean force)
        {
            this.supergroupId = supergroupId;
            this.force = force;
        }

        public static final int CONSTRUCTOR = 1187475691;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateTemporaryPassword extends Function
    {
        public String password;
        public int validFor;

        public CreateTemporaryPassword()
        {
        }

        public CreateTemporaryPassword(String password, int validFor)
        {
            this.password = password;
            this.validFor = validFor;
        }

        public static final int CONSTRUCTOR = -1626509434;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class CreateVideoChat extends Function
    {
        public long chatId;
        public String title;
        public int startDate;

        public CreateVideoChat()
        {
        }

        public CreateVideoChat(long chatId, String title, int startDate)
        {
            this.chatId = chatId;
            this.title = title;
            this.startDate = startDate;
        }

        public static final int CONSTRUCTOR = -917641210;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteAccount extends Function
    {
        public String reason;

        public DeleteAccount()
        {
        }

        public DeleteAccount(String reason)
        {
            this.reason = reason;
        }

        public static final int CONSTRUCTOR = -1203056508;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteAllCallMessages extends Function
    {
        public boolean revoke;

        public DeleteAllCallMessages()
        {
        }

        public DeleteAllCallMessages(boolean revoke)
        {
            this.revoke = revoke;
        }

        public static final int CONSTRUCTOR = -1466445325;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteAllRevokedChatInviteLinks extends Function
    {
        public long chatId;
        public long creatorUserId;

        public DeleteAllRevokedChatInviteLinks()
        {
        }

        public DeleteAllRevokedChatInviteLinks(long chatId, long creatorUserId)
        {
            this.chatId = chatId;
            this.creatorUserId = creatorUserId;
        }

        public static final int CONSTRUCTOR = 1112020698;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteChat extends Function
    {
        public long chatId;

        public DeleteChat()
        {
        }

        public DeleteChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -171253666;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteChatFilter extends Function
    {
        public int chatFilterId;

        public DeleteChatFilter()
        {
        }

        public DeleteChatFilter(int chatFilterId)
        {
            this.chatFilterId = chatFilterId;
        }

        public static final int CONSTRUCTOR = -523220877;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteChatHistory extends Function
    {
        public long chatId;
        public boolean removeFromChatList;
        public boolean revoke;

        public DeleteChatHistory()
        {
        }

        public DeleteChatHistory(long chatId, boolean removeFromChatList, boolean revoke)
        {
            this.chatId = chatId;
            this.removeFromChatList = removeFromChatList;
            this.revoke = revoke;
        }

        public static final int CONSTRUCTOR = -1472081761;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteChatMessagesByDate extends Function
    {
        public long chatId;
        public int minDate;
        public int maxDate;
        public boolean revoke;

        public DeleteChatMessagesByDate()
        {
        }

        public DeleteChatMessagesByDate(long chatId, int minDate, int maxDate, boolean revoke)
        {
            this.chatId = chatId;
            this.minDate = minDate;
            this.maxDate = maxDate;
            this.revoke = revoke;
        }

        public static final int CONSTRUCTOR = -1639653185;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteChatMessagesBySender extends Function
    {
        public long chatId;
        public MessageSender senderId;

        public DeleteChatMessagesBySender()
        {
        }

        public DeleteChatMessagesBySender(long chatId, MessageSender senderId)
        {
            this.chatId = chatId;
            this.senderId = senderId;
        }

        public static final int CONSTRUCTOR = -1164235161;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteChatReplyMarkup extends Function
    {
        public long chatId;
        public long messageId;

        public DeleteChatReplyMarkup()
        {
        }

        public DeleteChatReplyMarkup(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = 100637531;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteCommands extends Function
    {
        public BotCommandScope scope;
        public String languageCode;

        public DeleteCommands()
        {
        }

        public DeleteCommands(BotCommandScope scope, String languageCode)
        {
            this.scope = scope;
            this.languageCode = languageCode;
        }

        public static final int CONSTRUCTOR = 1002732586;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteFile extends Function
    {
        public int fileId;

        public DeleteFile()
        {
        }

        public DeleteFile(int fileId)
        {
            this.fileId = fileId;
        }

        public static final int CONSTRUCTOR = 1807653676;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteLanguagePack extends Function
    {
        public String languagePackId;

        public DeleteLanguagePack()
        {
        }

        public DeleteLanguagePack(String languagePackId)
        {
            this.languagePackId = languagePackId;
        }

        public static final int CONSTRUCTOR = -2108761026;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteMessages extends Function
    {
        public long chatId;
        public long[] messageIds;
        public boolean revoke;

        public DeleteMessages()
        {
        }

        public DeleteMessages(long chatId, long[] messageIds, boolean revoke)
        {
            this.chatId = chatId;
            this.messageIds = messageIds;
            this.revoke = revoke;
        }

        public static final int CONSTRUCTOR = 1130090173;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeletePassportElement extends Function
    {
        public PassportElementType type;

        public DeletePassportElement()
        {
        }

        public DeletePassportElement(PassportElementType type)
        {
            this.type = type;
        }

        public static final int CONSTRUCTOR = -1719555468;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteProfilePhoto extends Function
    {
        public long profilePhotoId;

        public DeleteProfilePhoto()
        {
        }

        public DeleteProfilePhoto(long profilePhotoId)
        {
            this.profilePhotoId = profilePhotoId;
        }

        public static final int CONSTRUCTOR = 1319794625;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteRevokedChatInviteLink extends Function
    {
        public long chatId;
        public String inviteLink;

        public DeleteRevokedChatInviteLink()
        {
        }

        public DeleteRevokedChatInviteLink(long chatId, String inviteLink)
        {
            this.chatId = chatId;
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = -1859711873;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteSavedCredentials extends Function
    {

        public DeleteSavedCredentials()
        {
        }

        public static final int CONSTRUCTOR = 826300114;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DeleteSavedOrderInfo extends Function
    {

        public DeleteSavedOrderInfo()
        {
        }

        public static final int CONSTRUCTOR = 1629058164;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class Destroy extends Function
    {

        public Destroy()
        {
        }

        public static final int CONSTRUCTOR = 685331274;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DisableProxy extends Function
    {

        public DisableProxy()
        {
        }

        public static final int CONSTRUCTOR = -2100095102;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DiscardCall extends Function
    {
        public int callId;
        public boolean isDisconnected;
        public int duration;
        public boolean isVideo;
        public long connectionId;

        public DiscardCall()
        {
        }

        public DiscardCall(int callId, boolean isDisconnected, int duration, boolean isVideo,
                long connectionId)
        {
            this.callId = callId;
            this.isDisconnected = isDisconnected;
            this.duration = duration;
            this.isVideo = isVideo;
            this.connectionId = connectionId;
        }

        public static final int CONSTRUCTOR = -1784044162;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DisconnectAllWebsites extends Function
    {

        public DisconnectAllWebsites()
        {
        }

        public static final int CONSTRUCTOR = -1082985981;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DisconnectWebsite extends Function
    {
        public long websiteId;

        public DisconnectWebsite()
        {
        }

        public DisconnectWebsite(long websiteId)
        {
            this.websiteId = websiteId;
        }

        public static final int CONSTRUCTOR = -778767395;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class DownloadFile extends Function
    {
        public int fileId;
        public int priority;
        public int offset;
        public int limit;
        public boolean synchronous;

        public DownloadFile()
        {
        }

        public DownloadFile(int fileId, int priority, int offset, int limit, boolean synchronous)
        {
            this.fileId = fileId;
            this.priority = priority;
            this.offset = offset;
            this.limit = limit;
            this.synchronous = synchronous;
        }

        public static final int CONSTRUCTOR = -1102026662;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditChatFilter extends Function
    {
        public int chatFilterId;
        public ChatFilter filter;

        public EditChatFilter()
        {
        }

        public EditChatFilter(int chatFilterId, ChatFilter filter)
        {
            this.chatFilterId = chatFilterId;
            this.filter = filter;
        }

        public static final int CONSTRUCTOR = -1674793086;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditChatInviteLink extends Function
    {
        public long chatId;
        public String inviteLink;
        public String name;
        public int expirationDate;
        public int memberLimit;
        public boolean createsJoinRequest;

        public EditChatInviteLink()
        {
        }

        public EditChatInviteLink(long chatId, String inviteLink, String name, int expirationDate,
                int memberLimit, boolean createsJoinRequest)
        {
            this.chatId = chatId;
            this.inviteLink = inviteLink;
            this.name = name;
            this.expirationDate = expirationDate;
            this.memberLimit = memberLimit;
            this.createsJoinRequest = createsJoinRequest;
        }

        public static final int CONSTRUCTOR = 1320303996;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditCustomLanguagePackInfo extends Function
    {
        public LanguagePackInfo info;

        public EditCustomLanguagePackInfo()
        {
        }

        public EditCustomLanguagePackInfo(LanguagePackInfo info)
        {
            this.info = info;
        }

        public static final int CONSTRUCTOR = 1320751257;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditInlineMessageCaption extends Function
    {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;
        public FormattedText caption;

        public EditInlineMessageCaption()
        {
        }

        public EditInlineMessageCaption(String inlineMessageId, ReplyMarkup replyMarkup,
                FormattedText caption)
        {
            this.inlineMessageId = inlineMessageId;
            this.replyMarkup = replyMarkup;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = -760985929;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditInlineMessageLiveLocation extends Function
    {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;
        public Location location;
        public int heading;
        public int proximityAlertRadius;

        public EditInlineMessageLiveLocation()
        {
        }

        public EditInlineMessageLiveLocation(String inlineMessageId, ReplyMarkup replyMarkup,
                Location location, int heading, int proximityAlertRadius)
        {
            this.inlineMessageId = inlineMessageId;
            this.replyMarkup = replyMarkup;
            this.location = location;
            this.heading = heading;
            this.proximityAlertRadius = proximityAlertRadius;
        }

        public static final int CONSTRUCTOR = -156902912;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditInlineMessageMedia extends Function
    {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public EditInlineMessageMedia()
        {
        }

        public EditInlineMessageMedia(String inlineMessageId, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.inlineMessageId = inlineMessageId;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 23553921;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditInlineMessageReplyMarkup extends Function
    {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;

        public EditInlineMessageReplyMarkup()
        {
        }

        public EditInlineMessageReplyMarkup(String inlineMessageId, ReplyMarkup replyMarkup)
        {
            this.inlineMessageId = inlineMessageId;
            this.replyMarkup = replyMarkup;
        }

        public static final int CONSTRUCTOR = -67565858;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditInlineMessageText extends Function
    {
        public String inlineMessageId;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public EditInlineMessageText()
        {
        }

        public EditInlineMessageText(String inlineMessageId, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.inlineMessageId = inlineMessageId;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = -855457307;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditMessageCaption extends Function
    {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public FormattedText caption;

        public EditMessageCaption()
        {
        }

        public EditMessageCaption(long chatId, long messageId, ReplyMarkup replyMarkup,
                FormattedText caption)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.replyMarkup = replyMarkup;
            this.caption = caption;
        }

        public static final int CONSTRUCTOR = 1154677038;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditMessageLiveLocation extends Function
    {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public Location location;
        public int heading;
        public int proximityAlertRadius;

        public EditMessageLiveLocation()
        {
        }

        public EditMessageLiveLocation(long chatId, long messageId, ReplyMarkup replyMarkup,
                Location location, int heading, int proximityAlertRadius)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.replyMarkup = replyMarkup;
            this.location = location;
            this.heading = heading;
            this.proximityAlertRadius = proximityAlertRadius;
        }

        public static final int CONSTRUCTOR = -14047982;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditMessageMedia extends Function
    {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public EditMessageMedia()
        {
        }

        public EditMessageMedia(long chatId, long messageId, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = -1152678125;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditMessageReplyMarkup extends Function
    {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;

        public EditMessageReplyMarkup()
        {
        }

        public EditMessageReplyMarkup(long chatId, long messageId, ReplyMarkup replyMarkup)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.replyMarkup = replyMarkup;
        }

        public static final int CONSTRUCTOR = 332127881;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditMessageSchedulingState extends Function
    {
        public long chatId;
        public long messageId;
        public MessageSchedulingState schedulingState;

        public EditMessageSchedulingState()
        {
        }

        public EditMessageSchedulingState(long chatId, long messageId,
                MessageSchedulingState schedulingState)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.schedulingState = schedulingState;
        }

        public static final int CONSTRUCTOR = -1372976192;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditMessageText extends Function
    {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public EditMessageText()
        {
        }

        public EditMessageText(long chatId, long messageId, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 196272567;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EditProxy extends Function
    {
        public int proxyId;
        public String server;
        public int port;
        public boolean enable;
        public ProxyType type;

        public EditProxy()
        {
        }

        public EditProxy(int proxyId, String server, int port, boolean enable, ProxyType type)
        {
            this.proxyId = proxyId;
            this.server = server;
            this.port = port;
            this.enable = enable;
            this.type = type;
        }

        public static final int CONSTRUCTOR = -1605883821;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EnableProxy extends Function
    {
        public int proxyId;

        public EnableProxy()
        {
        }

        public EnableProxy(int proxyId)
        {
            this.proxyId = proxyId;
        }

        public static final int CONSTRUCTOR = 1494450838;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EndGroupCall extends Function
    {
        public int groupCallId;

        public EndGroupCall()
        {
        }

        public EndGroupCall(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = 573131959;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EndGroupCallRecording extends Function
    {
        public int groupCallId;

        public EndGroupCallRecording()
        {
        }

        public EndGroupCallRecording(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = -75799927;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class EndGroupCallScreenSharing extends Function
    {
        public int groupCallId;

        public EndGroupCallScreenSharing()
        {
        }

        public EndGroupCallScreenSharing(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = -2047599540;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class FinishFileGeneration extends Function
    {
        public long generationId;
        public Error error;

        public FinishFileGeneration()
        {
        }

        public FinishFileGeneration(long generationId, Error error)
        {
            this.generationId = generationId;
            this.error = error;
        }

        public static final int CONSTRUCTOR = -1055060835;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ForwardMessages extends Function
    {
        public long chatId;
        public long fromChatId;
        public long[] messageIds;
        public MessageSendOptions options;
        public boolean sendCopy;
        public boolean removeCaption;
        public boolean onlyPreview;

        public ForwardMessages()
        {
        }

        public ForwardMessages(long chatId, long fromChatId, long[] messageIds,
                MessageSendOptions options, boolean sendCopy, boolean removeCaption,
                boolean onlyPreview)
        {
            this.chatId = chatId;
            this.fromChatId = fromChatId;
            this.messageIds = messageIds;
            this.options = options;
            this.sendCopy = sendCopy;
            this.removeCaption = removeCaption;
            this.onlyPreview = onlyPreview;
        }

        public static final int CONSTRUCTOR = -798726491;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetAccountTtl extends Function
    {

        public GetAccountTtl()
        {
        }

        public static final int CONSTRUCTOR = -443905161;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetActiveLiveLocationMessages extends Function
    {

        public GetActiveLiveLocationMessages()
        {
        }

        public static final int CONSTRUCTOR = -1425459567;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetActiveSessions extends Function
    {

        public GetActiveSessions()
        {
        }

        public static final int CONSTRUCTOR = 1119710526;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetAllPassportElements extends Function
    {
        public String password;

        public GetAllPassportElements()
        {
        }

        public GetAllPassportElements(String password)
        {
            this.password = password;
        }

        public static final int CONSTRUCTOR = -2038945045;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetAnimatedEmoji extends Function
    {
        public String emoji;

        public GetAnimatedEmoji()
        {
        }

        public GetAnimatedEmoji(String emoji)
        {
            this.emoji = emoji;
        }

        public static final int CONSTRUCTOR = 1065635702;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetApplicationConfig extends Function
    {

        public GetApplicationConfig()
        {
        }

        public static final int CONSTRUCTOR = -1823144318;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetApplicationDownloadLink extends Function
    {

        public GetApplicationDownloadLink()
        {
        }

        public static final int CONSTRUCTOR = 112013252;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetArchivedStickerSets extends Function
    {
        public boolean isMasks;
        public long offsetStickerSetId;
        public int limit;

        public GetArchivedStickerSets()
        {
        }

        public GetArchivedStickerSets(boolean isMasks, long offsetStickerSetId, int limit)
        {
            this.isMasks = isMasks;
            this.offsetStickerSetId = offsetStickerSetId;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 1996943238;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetAttachedStickerSets extends Function
    {
        public int fileId;

        public GetAttachedStickerSets()
        {
        }

        public GetAttachedStickerSets(int fileId)
        {
            this.fileId = fileId;
        }

        public static final int CONSTRUCTOR = 1302172429;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetAuthorizationState extends Function
    {

        public GetAuthorizationState()
        {
        }

        public static final int CONSTRUCTOR = 1949154877;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetAutoDownloadSettingsPresets extends Function
    {

        public GetAutoDownloadSettingsPresets()
        {
        }

        public static final int CONSTRUCTOR = -1721088201;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetBackgroundUrl extends Function
    {
        public String name;
        public BackgroundType type;

        public GetBackgroundUrl()
        {
        }

        public GetBackgroundUrl(String name, BackgroundType type)
        {
            this.name = name;
            this.type = type;
        }

        public static final int CONSTRUCTOR = 733769682;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetBackgrounds extends Function
    {
        public boolean forDarkTheme;

        public GetBackgrounds()
        {
        }

        public GetBackgrounds(boolean forDarkTheme)
        {
            this.forDarkTheme = forDarkTheme;
        }

        public static final int CONSTRUCTOR = 249072633;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetBankCardInfo extends Function
    {
        public String bankCardNumber;

        public GetBankCardInfo()
        {
        }

        public GetBankCardInfo(String bankCardNumber)
        {
            this.bankCardNumber = bankCardNumber;
        }

        public static final int CONSTRUCTOR = -1310515792;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetBasicGroup extends Function
    {
        public long basicGroupId;

        public GetBasicGroup()
        {
        }

        public GetBasicGroup(long basicGroupId)
        {
            this.basicGroupId = basicGroupId;
        }

        public static final int CONSTRUCTOR = -1635174828;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetBasicGroupFullInfo extends Function
    {
        public long basicGroupId;

        public GetBasicGroupFullInfo()
        {
        }

        public GetBasicGroupFullInfo(long basicGroupId)
        {
            this.basicGroupId = basicGroupId;
        }

        public static final int CONSTRUCTOR = -1822039253;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetBlockedMessageSenders extends Function
    {
        public int offset;
        public int limit;

        public GetBlockedMessageSenders()
        {
        }

        public GetBlockedMessageSenders(int offset, int limit)
        {
            this.offset = offset;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 1947079776;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetCallbackQueryAnswer extends Function
    {
        public long chatId;
        public long messageId;
        public CallbackQueryPayload payload;

        public GetCallbackQueryAnswer()
        {
        }

        public GetCallbackQueryAnswer(long chatId, long messageId, CallbackQueryPayload payload)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.payload = payload;
        }

        public static final int CONSTRUCTOR = 116357727;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetCallbackQueryMessage extends Function
    {
        public long chatId;
        public long messageId;
        public long callbackQueryId;

        public GetCallbackQueryMessage()
        {
        }

        public GetCallbackQueryMessage(long chatId, long messageId, long callbackQueryId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.callbackQueryId = callbackQueryId;
        }

        public static final int CONSTRUCTOR = -1121939086;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChat extends Function
    {
        public long chatId;

        public GetChat()
        {
        }

        public GetChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 1866601536;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatAdministrators extends Function
    {
        public long chatId;

        public GetChatAdministrators()
        {
        }

        public GetChatAdministrators(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 1544468155;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatAvailableMessageSenders extends Function
    {
        public long chatId;

        public GetChatAvailableMessageSenders()
        {
        }

        public GetChatAvailableMessageSenders(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -1541571496;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatEventLog extends Function
    {
        public long chatId;
        public String query;
        public long fromEventId;
        public int limit;
        public ChatEventLogFilters filters;
        public long[] userIds;

        public GetChatEventLog()
        {
        }

        public GetChatEventLog(long chatId, String query, long fromEventId, int limit,
                ChatEventLogFilters filters, long[] userIds)
        {
            this.chatId = chatId;
            this.query = query;
            this.fromEventId = fromEventId;
            this.limit = limit;
            this.filters = filters;
            this.userIds = userIds;
        }

        public static final int CONSTRUCTOR = -1281344669;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatFilter extends Function
    {
        public int chatFilterId;

        public GetChatFilter()
        {
        }

        public GetChatFilter(int chatFilterId)
        {
            this.chatFilterId = chatFilterId;
        }

        public static final int CONSTRUCTOR = 1826317803;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatFilterDefaultIconName extends Function
    {
        public ChatFilter filter;

        public GetChatFilterDefaultIconName()
        {
        }

        public GetChatFilterDefaultIconName(ChatFilter filter)
        {
            this.filter = filter;
        }

        public static final int CONSTRUCTOR = -1339828680;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatHistory extends Function
    {
        public long chatId;
        public long fromMessageId;
        public int offset;
        public int limit;
        public boolean onlyLocal;

        public GetChatHistory()
        {
        }

        public GetChatHistory(long chatId, long fromMessageId, int offset, int limit,
                boolean onlyLocal)
        {
            this.chatId = chatId;
            this.fromMessageId = fromMessageId;
            this.offset = offset;
            this.limit = limit;
            this.onlyLocal = onlyLocal;
        }

        public static final int CONSTRUCTOR = -799960451;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatInviteLink extends Function
    {
        public long chatId;
        public String inviteLink;

        public GetChatInviteLink()
        {
        }

        public GetChatInviteLink(long chatId, String inviteLink)
        {
            this.chatId = chatId;
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = -479575555;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatInviteLinkCounts extends Function
    {
        public long chatId;

        public GetChatInviteLinkCounts()
        {
        }

        public GetChatInviteLinkCounts(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 890299025;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatInviteLinkMembers extends Function
    {
        public long chatId;
        public String inviteLink;
        public ChatInviteLinkMember offsetMember;
        public int limit;

        public GetChatInviteLinkMembers()
        {
        }

        public GetChatInviteLinkMembers(long chatId, String inviteLink,
                ChatInviteLinkMember offsetMember, int limit)
        {
            this.chatId = chatId;
            this.inviteLink = inviteLink;
            this.offsetMember = offsetMember;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -977921638;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatInviteLinks extends Function
    {
        public long chatId;
        public long creatorUserId;
        public boolean isRevoked;
        public int offsetDate;
        public String offsetInviteLink;
        public int limit;

        public GetChatInviteLinks()
        {
        }

        public GetChatInviteLinks(long chatId, long creatorUserId, boolean isRevoked,
                int offsetDate, String offsetInviteLink, int limit)
        {
            this.chatId = chatId;
            this.creatorUserId = creatorUserId;
            this.isRevoked = isRevoked;
            this.offsetDate = offsetDate;
            this.offsetInviteLink = offsetInviteLink;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 883252396;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatJoinRequests extends Function
    {
        public long chatId;
        public String inviteLink;
        public String query;
        public ChatJoinRequest offsetRequest;
        public int limit;

        public GetChatJoinRequests()
        {
        }

        public GetChatJoinRequests(long chatId, String inviteLink, String query,
                ChatJoinRequest offsetRequest, int limit)
        {
            this.chatId = chatId;
            this.inviteLink = inviteLink;
            this.query = query;
            this.offsetRequest = offsetRequest;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -388428126;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatListsToAddChat extends Function
    {
        public long chatId;

        public GetChatListsToAddChat()
        {
        }

        public GetChatListsToAddChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 654956193;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatMember extends Function
    {
        public long chatId;
        public MessageSender memberId;

        public GetChatMember()
        {
        }

        public GetChatMember(long chatId, MessageSender memberId)
        {
            this.chatId = chatId;
            this.memberId = memberId;
        }

        public static final int CONSTRUCTOR = -792636814;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatMessageByDate extends Function
    {
        public long chatId;
        public int date;

        public GetChatMessageByDate()
        {
        }

        public GetChatMessageByDate(long chatId, int date)
        {
            this.chatId = chatId;
            this.date = date;
        }

        public static final int CONSTRUCTOR = 1062564150;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatMessageCalendar extends Function
    {
        public long chatId;
        public SearchMessagesFilter filter;
        public long fromMessageId;

        public GetChatMessageCalendar()
        {
        }

        public GetChatMessageCalendar(long chatId, SearchMessagesFilter filter, long fromMessageId)
        {
            this.chatId = chatId;
            this.filter = filter;
            this.fromMessageId = fromMessageId;
        }

        public static final int CONSTRUCTOR = -326164204;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatMessageCount extends Function
    {
        public long chatId;
        public SearchMessagesFilter filter;
        public boolean returnLocal;

        public GetChatMessageCount()
        {
        }

        public GetChatMessageCount(long chatId, SearchMessagesFilter filter, boolean returnLocal)
        {
            this.chatId = chatId;
            this.filter = filter;
            this.returnLocal = returnLocal;
        }

        public static final int CONSTRUCTOR = 205435308;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatNotificationSettingsExceptions extends Function
    {
        public NotificationSettingsScope scope;
        public boolean compareSound;

        public GetChatNotificationSettingsExceptions()
        {
        }

        public GetChatNotificationSettingsExceptions(NotificationSettingsScope scope,
                boolean compareSound)
        {
            this.scope = scope;
            this.compareSound = compareSound;
        }

        public static final int CONSTRUCTOR = 201199121;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatPinnedMessage extends Function
    {
        public long chatId;

        public GetChatPinnedMessage()
        {
        }

        public GetChatPinnedMessage(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 359865008;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatScheduledMessages extends Function
    {
        public long chatId;

        public GetChatScheduledMessages()
        {
        }

        public GetChatScheduledMessages(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -549638149;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatSparseMessagePositions extends Function
    {
        public long chatId;
        public SearchMessagesFilter filter;
        public long fromMessageId;
        public int limit;

        public GetChatSparseMessagePositions()
        {
        }

        public GetChatSparseMessagePositions(long chatId, SearchMessagesFilter filter,
                long fromMessageId, int limit)
        {
            this.chatId = chatId;
            this.filter = filter;
            this.fromMessageId = fromMessageId;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -462227580;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatSponsoredMessage extends Function
    {
        public long chatId;

        public GetChatSponsoredMessage()
        {
        }

        public GetChatSponsoredMessage(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 7520523;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChatStatistics extends Function
    {
        public long chatId;
        public boolean isDark;

        public GetChatStatistics()
        {
        }

        public GetChatStatistics(long chatId, boolean isDark)
        {
            this.chatId = chatId;
            this.isDark = isDark;
        }

        public static final int CONSTRUCTOR = 327057816;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetChats extends Function
    {
        public ChatList chatList;
        public int limit;

        public GetChats()
        {
        }

        public GetChats(ChatList chatList, int limit)
        {
            this.chatList = chatList;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -972768574;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetCommands extends Function
    {
        public BotCommandScope scope;
        public String languageCode;

        public GetCommands()
        {
        }

        public GetCommands(BotCommandScope scope, String languageCode)
        {
            this.scope = scope;
            this.languageCode = languageCode;
        }

        public static final int CONSTRUCTOR = 1488621559;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetConnectedWebsites extends Function
    {

        public GetConnectedWebsites()
        {
        }

        public static final int CONSTRUCTOR = -170536110;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetContacts extends Function
    {

        public GetContacts()
        {
        }

        public static final int CONSTRUCTOR = -1417722768;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetCountries extends Function
    {

        public GetCountries()
        {
        }

        public static final int CONSTRUCTOR = -51902050;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetCountryCode extends Function
    {

        public GetCountryCode()
        {
        }

        public static final int CONSTRUCTOR = 1540593906;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetCreatedPublicChats extends Function
    {
        public PublicChatType type;

        public GetCreatedPublicChats()
        {
        }

        public GetCreatedPublicChats(PublicChatType type)
        {
            this.type = type;
        }

        public static final int CONSTRUCTOR = 710354415;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetCurrentState extends Function
    {

        public GetCurrentState()
        {
        }

        public static final int CONSTRUCTOR = -1191417719;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetDatabaseStatistics extends Function
    {

        public GetDatabaseStatistics()
        {
        }

        public static final int CONSTRUCTOR = -1942760263;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetDeepLinkInfo extends Function
    {
        public String link;

        public GetDeepLinkInfo()
        {
        }

        public GetDeepLinkInfo(String link)
        {
            this.link = link;
        }

        public static final int CONSTRUCTOR = 680673150;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetEmojiSuggestionsUrl extends Function
    {
        public String languageCode;

        public GetEmojiSuggestionsUrl()
        {
        }

        public GetEmojiSuggestionsUrl(String languageCode)
        {
            this.languageCode = languageCode;
        }

        public static final int CONSTRUCTOR = -1404101841;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetExternalLink extends Function
    {
        public String link;
        public boolean allowWriteAccess;

        public GetExternalLink()
        {
        }

        public GetExternalLink(String link, boolean allowWriteAccess)
        {
            this.link = link;
            this.allowWriteAccess = allowWriteAccess;
        }

        public static final int CONSTRUCTOR = 1586688235;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetExternalLinkInfo extends Function
    {
        public String link;

        public GetExternalLinkInfo()
        {
        }

        public GetExternalLinkInfo(String link)
        {
            this.link = link;
        }

        public static final int CONSTRUCTOR = 1175288383;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetFavoriteStickers extends Function
    {

        public GetFavoriteStickers()
        {
        }

        public static final int CONSTRUCTOR = -338964672;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetFile extends Function
    {
        public int fileId;

        public GetFile()
        {
        }

        public GetFile(int fileId)
        {
            this.fileId = fileId;
        }

        public static final int CONSTRUCTOR = 1553923406;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetFileDownloadedPrefixSize extends Function
    {
        public int fileId;
        public int offset;

        public GetFileDownloadedPrefixSize()
        {
        }

        public GetFileDownloadedPrefixSize(int fileId, int offset)
        {
            this.fileId = fileId;
            this.offset = offset;
        }

        public static final int CONSTRUCTOR = -1668864864;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetFileExtension extends Function
    {
        public String mimeType;

        public GetFileExtension()
        {
        }

        public GetFileExtension(String mimeType)
        {
            this.mimeType = mimeType;
        }

        public static final int CONSTRUCTOR = -106055372;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetFileMimeType extends Function
    {
        public String fileName;

        public GetFileMimeType()
        {
        }

        public GetFileMimeType(String fileName)
        {
            this.fileName = fileName;
        }

        public static final int CONSTRUCTOR = -2073879671;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetGameHighScores extends Function
    {
        public long chatId;
        public long messageId;
        public long userId;

        public GetGameHighScores()
        {
        }

        public GetGameHighScores(long chatId, long messageId, long userId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = 15746459;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetGroupCall extends Function
    {
        public int groupCallId;

        public GetGroupCall()
        {
        }

        public GetGroupCall(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = 1468491406;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetGroupCallInviteLink extends Function
    {
        public int groupCallId;
        public boolean canSelfUnmute;

        public GetGroupCallInviteLink()
        {
        }

        public GetGroupCallInviteLink(int groupCallId, boolean canSelfUnmute)
        {
            this.groupCallId = groupCallId;
            this.canSelfUnmute = canSelfUnmute;
        }

        public static final int CONSTRUCTOR = 719407396;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetGroupCallStreamSegment extends Function
    {
        public int groupCallId;
        public long timeOffset;
        public int scale;
        public int channelId;
        public GroupCallVideoQuality videoQuality;

        public GetGroupCallStreamSegment()
        {
        }

        public GetGroupCallStreamSegment(int groupCallId, long timeOffset, int scale, int channelId,
                GroupCallVideoQuality videoQuality)
        {
            this.groupCallId = groupCallId;
            this.timeOffset = timeOffset;
            this.scale = scale;
            this.channelId = channelId;
            this.videoQuality = videoQuality;
        }

        public static final int CONSTRUCTOR = -2077959515;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetGroupsInCommon extends Function
    {
        public long userId;
        public long offsetChatId;
        public int limit;

        public GetGroupsInCommon()
        {
        }

        public GetGroupsInCommon(long userId, long offsetChatId, int limit)
        {
            this.userId = userId;
            this.offsetChatId = offsetChatId;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 381539178;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetImportedContactCount extends Function
    {

        public GetImportedContactCount()
        {
        }

        public static final int CONSTRUCTOR = -656336346;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetInactiveSupergroupChats extends Function
    {

        public GetInactiveSupergroupChats()
        {
        }

        public static final int CONSTRUCTOR = -657720907;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetInlineGameHighScores extends Function
    {
        public String inlineMessageId;
        public long userId;

        public GetInlineGameHighScores()
        {
        }

        public GetInlineGameHighScores(String inlineMessageId, long userId)
        {
            this.inlineMessageId = inlineMessageId;
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = -533107798;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetInlineQueryResults extends Function
    {
        public long botUserId;
        public long chatId;
        public Location userLocation;
        public String query;
        public String offset;

        public GetInlineQueryResults()
        {
        }

        public GetInlineQueryResults(long botUserId, long chatId, Location userLocation,
                String query, String offset)
        {
            this.botUserId = botUserId;
            this.chatId = chatId;
            this.userLocation = userLocation;
            this.query = query;
            this.offset = offset;
        }

        public static final int CONSTRUCTOR = 2044524652;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetInstalledStickerSets extends Function
    {
        public boolean isMasks;

        public GetInstalledStickerSets()
        {
        }

        public GetInstalledStickerSets(boolean isMasks)
        {
            this.isMasks = isMasks;
        }

        public static final int CONSTRUCTOR = 1214523749;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetInternalLinkType extends Function
    {
        public String link;

        public GetInternalLinkType()
        {
        }

        public GetInternalLinkType(String link)
        {
            this.link = link;
        }

        public static final int CONSTRUCTOR = -1948428535;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetJsonString extends Function
    {
        public JsonValue jsonValue;

        public GetJsonString()
        {
        }

        public GetJsonString(JsonValue jsonValue)
        {
            this.jsonValue = jsonValue;
        }

        public static final int CONSTRUCTOR = 663458849;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetJsonValue extends Function
    {
        public String json;

        public GetJsonValue()
        {
        }

        public GetJsonValue(String json)
        {
            this.json = json;
        }

        public static final int CONSTRUCTOR = -1829086715;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLanguagePackInfo extends Function
    {
        public String languagePackId;

        public GetLanguagePackInfo()
        {
        }

        public GetLanguagePackInfo(String languagePackId)
        {
            this.languagePackId = languagePackId;
        }

        public static final int CONSTRUCTOR = 2077809320;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLanguagePackString extends Function
    {
        public String languagePackDatabasePath;
        public String localizationTarget;
        public String languagePackId;
        public String key;

        public GetLanguagePackString()
        {
        }

        public GetLanguagePackString(String languagePackDatabasePath, String localizationTarget,
                String languagePackId, String key)
        {
            this.languagePackDatabasePath = languagePackDatabasePath;
            this.localizationTarget = localizationTarget;
            this.languagePackId = languagePackId;
            this.key = key;
        }

        public static final int CONSTRUCTOR = 150789747;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLanguagePackStrings extends Function
    {
        public String languagePackId;
        public String[] keys;

        public GetLanguagePackStrings()
        {
        }

        public GetLanguagePackStrings(String languagePackId, String[] keys)
        {
            this.languagePackId = languagePackId;
            this.keys = keys;
        }

        public static final int CONSTRUCTOR = 1246259088;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLocalizationTargetInfo extends Function
    {
        public boolean onlyLocal;

        public GetLocalizationTargetInfo()
        {
        }

        public GetLocalizationTargetInfo(boolean onlyLocal)
        {
            this.onlyLocal = onlyLocal;
        }

        public static final int CONSTRUCTOR = 1849499526;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLogStream extends Function
    {

        public GetLogStream()
        {
        }

        public static final int CONSTRUCTOR = 1167608667;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLogTagVerbosityLevel extends Function
    {
        public String tag;

        public GetLogTagVerbosityLevel()
        {
        }

        public GetLogTagVerbosityLevel(String tag)
        {
            this.tag = tag;
        }

        public static final int CONSTRUCTOR = 951004547;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLogTags extends Function
    {

        public GetLogTags()
        {
        }

        public static final int CONSTRUCTOR = -254449190;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLogVerbosityLevel extends Function
    {

        public GetLogVerbosityLevel()
        {
        }

        public static final int CONSTRUCTOR = 594057956;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLoginUrl extends Function
    {
        public long chatId;
        public long messageId;
        public long buttonId;
        public boolean allowWriteAccess;

        public GetLoginUrl()
        {
        }

        public GetLoginUrl(long chatId, long messageId, long buttonId, boolean allowWriteAccess)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.buttonId = buttonId;
            this.allowWriteAccess = allowWriteAccess;
        }

        public static final int CONSTRUCTOR = 791844305;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetLoginUrlInfo extends Function
    {
        public long chatId;
        public long messageId;
        public long buttonId;

        public GetLoginUrlInfo()
        {
        }

        public GetLoginUrlInfo(long chatId, long messageId, long buttonId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.buttonId = buttonId;
        }

        public static final int CONSTRUCTOR = -859202125;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMapThumbnailFile extends Function
    {
        public Location location;
        public int zoom;
        public int width;
        public int height;
        public int scale;
        public long chatId;

        public GetMapThumbnailFile()
        {
        }

        public GetMapThumbnailFile(Location location, int zoom, int width, int height, int scale,
                long chatId)
        {
            this.location = location;
            this.zoom = zoom;
            this.width = width;
            this.height = height;
            this.scale = scale;
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -152660070;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMarkdownText extends Function
    {
        public FormattedText text;

        public GetMarkdownText()
        {
        }

        public GetMarkdownText(FormattedText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 164524584;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMe extends Function
    {

        public GetMe()
        {
        }

        public static final int CONSTRUCTOR = -191516033;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessage extends Function
    {
        public long chatId;
        public long messageId;

        public GetMessage()
        {
        }

        public GetMessage(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = -1821196160;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageEmbeddingCode extends Function
    {
        public long chatId;
        public long messageId;
        public boolean forAlbum;

        public GetMessageEmbeddingCode()
        {
        }

        public GetMessageEmbeddingCode(long chatId, long messageId, boolean forAlbum)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.forAlbum = forAlbum;
        }

        public static final int CONSTRUCTOR = 1654967561;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageFileType extends Function
    {
        public String messageFileHead;

        public GetMessageFileType()
        {
        }

        public GetMessageFileType(String messageFileHead)
        {
            this.messageFileHead = messageFileHead;
        }

        public static final int CONSTRUCTOR = -490270764;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageImportConfirmationText extends Function
    {
        public long chatId;

        public GetMessageImportConfirmationText()
        {
        }

        public GetMessageImportConfirmationText(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 390627752;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageLink extends Function
    {
        public long chatId;
        public long messageId;
        public int mediaTimestamp;
        public boolean forAlbum;
        public boolean forComment;

        public GetMessageLink()
        {
        }

        public GetMessageLink(long chatId, long messageId, int mediaTimestamp, boolean forAlbum,
                boolean forComment)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.mediaTimestamp = mediaTimestamp;
            this.forAlbum = forAlbum;
            this.forComment = forComment;
        }

        public static final int CONSTRUCTOR = -1607389329;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageLinkInfo extends Function
    {
        public String url;

        public GetMessageLinkInfo()
        {
        }

        public GetMessageLinkInfo(String url)
        {
            this.url = url;
        }

        public static final int CONSTRUCTOR = -700533672;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageLocally extends Function
    {
        public long chatId;
        public long messageId;

        public GetMessageLocally()
        {
        }

        public GetMessageLocally(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = -603575444;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessagePublicForwards extends Function
    {
        public long chatId;
        public long messageId;
        public String offset;
        public int limit;

        public GetMessagePublicForwards()
        {
        }

        public GetMessagePublicForwards(long chatId, long messageId, String offset, int limit)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.offset = offset;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 1611049289;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageStatistics extends Function
    {
        public long chatId;
        public long messageId;
        public boolean isDark;

        public GetMessageStatistics()
        {
        }

        public GetMessageStatistics(long chatId, long messageId, boolean isDark)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.isDark = isDark;
        }

        public static final int CONSTRUCTOR = 1270194648;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageThread extends Function
    {
        public long chatId;
        public long messageId;

        public GetMessageThread()
        {
        }

        public GetMessageThread(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = 2062695998;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageThreadHistory extends Function
    {
        public long chatId;
        public long messageId;
        public long fromMessageId;
        public int offset;
        public int limit;

        public GetMessageThreadHistory()
        {
        }

        public GetMessageThreadHistory(long chatId, long messageId, long fromMessageId, int offset,
                int limit)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.fromMessageId = fromMessageId;
            this.offset = offset;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -1808411608;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessageViewers extends Function
    {
        public long chatId;
        public long messageId;

        public GetMessageViewers()
        {
        }

        public GetMessageViewers(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = -1879496099;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetMessages extends Function
    {
        public long chatId;
        public long[] messageIds;

        public GetMessages()
        {
        }

        public GetMessages(long chatId, long[] messageIds)
        {
            this.chatId = chatId;
            this.messageIds = messageIds;
        }

        public static final int CONSTRUCTOR = 425299338;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetNetworkStatistics extends Function
    {
        public boolean onlyCurrent;

        public GetNetworkStatistics()
        {
        }

        public GetNetworkStatistics(boolean onlyCurrent)
        {
            this.onlyCurrent = onlyCurrent;
        }

        public static final int CONSTRUCTOR = -986228706;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetOption extends Function
    {
        public String name;

        public GetOption()
        {
        }

        public GetOption(String name)
        {
            this.name = name;
        }

        public static final int CONSTRUCTOR = -1572495746;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPassportAuthorizationForm extends Function
    {
        public long botUserId;
        public String scope;
        public String publicKey;
        public String nonce;

        public GetPassportAuthorizationForm()
        {
        }

        public GetPassportAuthorizationForm(long botUserId, String scope, String publicKey,
                String nonce)
        {
            this.botUserId = botUserId;
            this.scope = scope;
            this.publicKey = publicKey;
            this.nonce = nonce;
        }

        public static final int CONSTRUCTOR = 1636107398;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPassportAuthorizationFormAvailableElements extends Function
    {
        public int autorizationFormId;
        public String password;

        public GetPassportAuthorizationFormAvailableElements()
        {
        }

        public GetPassportAuthorizationFormAvailableElements(int autorizationFormId,
                String password)
        {
            this.autorizationFormId = autorizationFormId;
            this.password = password;
        }

        public static final int CONSTRUCTOR = 1738134754;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPassportElement extends Function
    {
        public PassportElementType type;
        public String password;

        public GetPassportElement()
        {
        }

        public GetPassportElement(PassportElementType type, String password)
        {
            this.type = type;
            this.password = password;
        }

        public static final int CONSTRUCTOR = -1882398342;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPasswordState extends Function
    {

        public GetPasswordState()
        {
        }

        public static final int CONSTRUCTOR = -174752904;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPaymentForm extends Function
    {
        public long chatId;
        public long messageId;
        public PaymentFormTheme theme;

        public GetPaymentForm()
        {
        }

        public GetPaymentForm(long chatId, long messageId, PaymentFormTheme theme)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.theme = theme;
        }

        public static final int CONSTRUCTOR = 158229273;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPaymentReceipt extends Function
    {
        public long chatId;
        public long messageId;

        public GetPaymentReceipt()
        {
        }

        public GetPaymentReceipt(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = 1013758294;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPhoneNumberInfo extends Function
    {
        public String phoneNumberPrefix;

        public GetPhoneNumberInfo()
        {
        }

        public GetPhoneNumberInfo(String phoneNumberPrefix)
        {
            this.phoneNumberPrefix = phoneNumberPrefix;
        }

        public static final int CONSTRUCTOR = -1608344583;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPhoneNumberInfoSync extends Function
    {
        public String languageCode;
        public String phoneNumberPrefix;

        public GetPhoneNumberInfoSync()
        {
        }

        public GetPhoneNumberInfoSync(String languageCode, String phoneNumberPrefix)
        {
            this.languageCode = languageCode;
            this.phoneNumberPrefix = phoneNumberPrefix;
        }

        public static final int CONSTRUCTOR = 547061048;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPollVoters extends Function
    {
        public long chatId;
        public long messageId;
        public int optionId;
        public int offset;
        public int limit;

        public GetPollVoters()
        {
        }

        public GetPollVoters(long chatId, long messageId, int optionId, int offset, int limit)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.optionId = optionId;
            this.offset = offset;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 2075288734;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPreferredCountryLanguage extends Function
    {
        public String countryCode;

        public GetPreferredCountryLanguage()
        {
        }

        public GetPreferredCountryLanguage(String countryCode)
        {
            this.countryCode = countryCode;
        }

        public static final int CONSTRUCTOR = -933049386;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetProxies extends Function
    {

        public GetProxies()
        {
        }

        public static final int CONSTRUCTOR = -95026381;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetProxyLink extends Function
    {
        public int proxyId;

        public GetProxyLink()
        {
        }

        public GetProxyLink(int proxyId)
        {
            this.proxyId = proxyId;
        }

        public static final int CONSTRUCTOR = -1054495112;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetPushReceiverId extends Function
    {
        public String payload;

        public GetPushReceiverId()
        {
        }

        public GetPushReceiverId(String payload)
        {
            this.payload = payload;
        }

        public static final int CONSTRUCTOR = -286505294;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetRecentInlineBots extends Function
    {

        public GetRecentInlineBots()
        {
        }

        public static final int CONSTRUCTOR = 1437823548;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetRecentStickers extends Function
    {
        public boolean isAttached;

        public GetRecentStickers()
        {
        }

        public GetRecentStickers(boolean isAttached)
        {
            this.isAttached = isAttached;
        }

        public static final int CONSTRUCTOR = -579622241;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetRecentlyOpenedChats extends Function
    {
        public int limit;

        public GetRecentlyOpenedChats()
        {
        }

        public GetRecentlyOpenedChats(int limit)
        {
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -1924156893;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetRecentlyVisitedTMeUrls extends Function
    {
        public String referrer;

        public GetRecentlyVisitedTMeUrls()
        {
        }

        public GetRecentlyVisitedTMeUrls(String referrer)
        {
            this.referrer = referrer;
        }

        public static final int CONSTRUCTOR = 806754961;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetRecommendedChatFilters extends Function
    {

        public GetRecommendedChatFilters()
        {
        }

        public static final int CONSTRUCTOR = -779390746;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetRecoveryEmailAddress extends Function
    {
        public String password;

        public GetRecoveryEmailAddress()
        {
        }

        public GetRecoveryEmailAddress(String password)
        {
            this.password = password;
        }

        public static final int CONSTRUCTOR = -1594770947;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetRemoteFile extends Function
    {
        public String remoteFileId;
        public FileType fileType;

        public GetRemoteFile()
        {
        }

        public GetRemoteFile(String remoteFileId, FileType fileType)
        {
            this.remoteFileId = remoteFileId;
            this.fileType = fileType;
        }

        public static final int CONSTRUCTOR = 2137204530;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetRepliedMessage extends Function
    {
        public long chatId;
        public long messageId;

        public GetRepliedMessage()
        {
        }

        public GetRepliedMessage(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = -641918531;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSavedAnimations extends Function
    {

        public GetSavedAnimations()
        {
        }

        public static final int CONSTRUCTOR = 7051032;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSavedOrderInfo extends Function
    {

        public GetSavedOrderInfo()
        {
        }

        public static final int CONSTRUCTOR = -1152016675;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetScopeNotificationSettings extends Function
    {
        public NotificationSettingsScope scope;

        public GetScopeNotificationSettings()
        {
        }

        public GetScopeNotificationSettings(NotificationSettingsScope scope)
        {
            this.scope = scope;
        }

        public static final int CONSTRUCTOR = -995613361;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSecretChat extends Function
    {
        public int secretChatId;

        public GetSecretChat()
        {
        }

        public GetSecretChat(int secretChatId)
        {
            this.secretChatId = secretChatId;
        }

        public static final int CONSTRUCTOR = 40599169;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetStatisticalGraph extends Function
    {
        public long chatId;
        public String token;
        public long x;

        public GetStatisticalGraph()
        {
        }

        public GetStatisticalGraph(long chatId, String token, long x)
        {
            this.chatId = chatId;
            this.token = token;
            this.x = x;
        }

        public static final int CONSTRUCTOR = 1100975515;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetStickerEmojis extends Function
    {
        public InputFile sticker;

        public GetStickerEmojis()
        {
        }

        public GetStickerEmojis(InputFile sticker)
        {
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = -1895508665;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetStickerSet extends Function
    {
        public long setId;

        public GetStickerSet()
        {
        }

        public GetStickerSet(long setId)
        {
            this.setId = setId;
        }

        public static final int CONSTRUCTOR = 1052318659;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetStickers extends Function
    {
        public String emoji;
        public int limit;

        public GetStickers()
        {
        }

        public GetStickers(String emoji, int limit)
        {
            this.emoji = emoji;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -1594919556;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetStorageStatistics extends Function
    {
        public int chatLimit;

        public GetStorageStatistics()
        {
        }

        public GetStorageStatistics(int chatLimit)
        {
            this.chatLimit = chatLimit;
        }

        public static final int CONSTRUCTOR = -853193929;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetStorageStatisticsFast extends Function
    {

        public GetStorageStatisticsFast()
        {
        }

        public static final int CONSTRUCTOR = 61368066;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSuggestedFileName extends Function
    {
        public int fileId;
        public String directory;

        public GetSuggestedFileName()
        {
        }

        public GetSuggestedFileName(int fileId, String directory)
        {
            this.fileId = fileId;
            this.directory = directory;
        }

        public static final int CONSTRUCTOR = -2049399674;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSuggestedStickerSetName extends Function
    {
        public String title;

        public GetSuggestedStickerSetName()
        {
        }

        public GetSuggestedStickerSetName(String title)
        {
            this.title = title;
        }

        public static final int CONSTRUCTOR = -1340995520;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSuitableDiscussionChats extends Function
    {

        public GetSuitableDiscussionChats()
        {
        }

        public static final int CONSTRUCTOR = 49044982;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSupergroup extends Function
    {
        public long supergroupId;

        public GetSupergroup()
        {
        }

        public GetSupergroup(long supergroupId)
        {
            this.supergroupId = supergroupId;
        }

        public static final int CONSTRUCTOR = 989663458;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSupergroupFullInfo extends Function
    {
        public long supergroupId;

        public GetSupergroupFullInfo()
        {
        }

        public GetSupergroupFullInfo(long supergroupId)
        {
            this.supergroupId = supergroupId;
        }

        public static final int CONSTRUCTOR = 1099776056;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSupergroupMembers extends Function
    {
        public long supergroupId;
        public SupergroupMembersFilter filter;
        public int offset;
        public int limit;

        public GetSupergroupMembers()
        {
        }

        public GetSupergroupMembers(long supergroupId, SupergroupMembersFilter filter, int offset,
                int limit)
        {
            this.supergroupId = supergroupId;
            this.filter = filter;
            this.offset = offset;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -570940984;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetSupportUser extends Function
    {

        public GetSupportUser()
        {
        }

        public static final int CONSTRUCTOR = -1733497700;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetTemporaryPasswordState extends Function
    {

        public GetTemporaryPasswordState()
        {
        }

        public static final int CONSTRUCTOR = -12670830;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetTextEntities extends Function
    {
        public String text;

        public GetTextEntities()
        {
        }

        public GetTextEntities(String text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = -341490693;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetTopChats extends Function
    {
        public TopChatCategory category;
        public int limit;

        public GetTopChats()
        {
        }

        public GetTopChats(TopChatCategory category, int limit)
        {
            this.category = category;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -388410847;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetTrendingStickerSets extends Function
    {
        public int offset;
        public int limit;

        public GetTrendingStickerSets()
        {
        }

        public GetTrendingStickerSets(int offset, int limit)
        {
            this.offset = offset;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -1494581948;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetUser extends Function
    {
        public long userId;

        public GetUser()
        {
        }

        public GetUser(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = 1117363211;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetUserFullInfo extends Function
    {
        public long userId;

        public GetUserFullInfo()
        {
        }

        public GetUserFullInfo(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = -776823720;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetUserPrivacySettingRules extends Function
    {
        public UserPrivacySetting setting;

        public GetUserPrivacySettingRules()
        {
        }

        public GetUserPrivacySettingRules(UserPrivacySetting setting)
        {
            this.setting = setting;
        }

        public static final int CONSTRUCTOR = -2077223311;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetUserProfilePhotos extends Function
    {
        public long userId;
        public int offset;
        public int limit;

        public GetUserProfilePhotos()
        {
        }

        public GetUserProfilePhotos(long userId, int offset, int limit)
        {
            this.userId = userId;
            this.offset = offset;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -908132798;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetVideoChatAvailableParticipants extends Function
    {
        public long chatId;

        public GetVideoChatAvailableParticipants()
        {
        }

        public GetVideoChatAvailableParticipants(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -1000496379;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetWebPageInstantView extends Function
    {
        public String url;
        public boolean forceFull;

        public GetWebPageInstantView()
        {
        }

        public GetWebPageInstantView(String url, boolean forceFull)
        {
            this.url = url;
            this.forceFull = forceFull;
        }

        public static final int CONSTRUCTOR = -1962649975;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class GetWebPagePreview extends Function
    {
        public FormattedText text;

        public GetWebPagePreview()
        {
        }

        public GetWebPagePreview(FormattedText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 573441580;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class HideSuggestedAction extends Function
    {
        public SuggestedAction action;

        public HideSuggestedAction()
        {
        }

        public HideSuggestedAction(SuggestedAction action)
        {
            this.action = action;
        }

        public static final int CONSTRUCTOR = -1561384065;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ImportContacts extends Function
    {
        public Contact[] contacts;

        public ImportContacts()
        {
        }

        public ImportContacts(Contact[] contacts)
        {
            this.contacts = contacts;
        }

        public static final int CONSTRUCTOR = -215132767;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ImportMessages extends Function
    {
        public long chatId;
        public InputFile messageFile;
        public InputFile[] attachedFiles;

        public ImportMessages()
        {
        }

        public ImportMessages(long chatId, InputFile messageFile, InputFile[] attachedFiles)
        {
            this.chatId = chatId;
            this.messageFile = messageFile;
            this.attachedFiles = attachedFiles;
        }

        public static final int CONSTRUCTOR = -1864116784;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class InviteGroupCallParticipants extends Function
    {
        public int groupCallId;
        public long[] userIds;

        public InviteGroupCallParticipants()
        {
        }

        public InviteGroupCallParticipants(int groupCallId, long[] userIds)
        {
            this.groupCallId = groupCallId;
            this.userIds = userIds;
        }

        public static final int CONSTRUCTOR = 1867097679;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class JoinChat extends Function
    {
        public long chatId;

        public JoinChat()
        {
        }

        public JoinChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 326769313;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class JoinChatByInviteLink extends Function
    {
        public String inviteLink;

        public JoinChatByInviteLink()
        {
        }

        public JoinChatByInviteLink(String inviteLink)
        {
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = -1049973882;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class JoinGroupCall extends Function
    {
        public int groupCallId;
        public MessageSender participantId;
        public int audioSourceId;
        public String payload;
        public boolean isMuted;
        public boolean isMyVideoEnabled;
        public String inviteHash;

        public JoinGroupCall()
        {
        }

        public JoinGroupCall(int groupCallId, MessageSender participantId, int audioSourceId,
                String payload, boolean isMuted, boolean isMyVideoEnabled, String inviteHash)
        {
            this.groupCallId = groupCallId;
            this.participantId = participantId;
            this.audioSourceId = audioSourceId;
            this.payload = payload;
            this.isMuted = isMuted;
            this.isMyVideoEnabled = isMyVideoEnabled;
            this.inviteHash = inviteHash;
        }

        public static final int CONSTRUCTOR = -1043773467;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LeaveChat extends Function
    {
        public long chatId;

        public LeaveChat()
        {
        }

        public LeaveChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -1825080735;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LeaveGroupCall extends Function
    {
        public int groupCallId;

        public LeaveGroupCall()
        {
        }

        public LeaveGroupCall(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = 980152233;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LoadChats extends Function
    {
        public ChatList chatList;
        public int limit;

        public LoadChats()
        {
        }

        public LoadChats(ChatList chatList, int limit)
        {
            this.chatList = chatList;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -1885635205;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LoadGroupCallParticipants extends Function
    {
        public int groupCallId;
        public int limit;

        public LoadGroupCallParticipants()
        {
        }

        public LoadGroupCallParticipants(int groupCallId, int limit)
        {
            this.groupCallId = groupCallId;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 938720974;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class LogOut extends Function
    {

        public LogOut()
        {
        }

        public static final int CONSTRUCTOR = -1581923301;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class OpenChat extends Function
    {
        public long chatId;

        public OpenChat()
        {
        }

        public OpenChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -323371509;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class OpenMessageContent extends Function
    {
        public long chatId;
        public long messageId;

        public OpenMessageContent()
        {
        }

        public OpenMessageContent(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = -739088005;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class OptimizeStorage extends Function
    {
        public long size;
        public int ttl;
        public int count;
        public int immunityDelay;
        public FileType[] fileTypes;
        public long[] chatIds;
        public long[] excludeChatIds;
        public boolean returnDeletedFileStatistics;
        public int chatLimit;

        public OptimizeStorage()
        {
        }

        public OptimizeStorage(long size, int ttl, int count, int immunityDelay,
                FileType[] fileTypes, long[] chatIds, long[] excludeChatIds,
                boolean returnDeletedFileStatistics, int chatLimit)
        {
            this.size = size;
            this.ttl = ttl;
            this.count = count;
            this.immunityDelay = immunityDelay;
            this.fileTypes = fileTypes;
            this.chatIds = chatIds;
            this.excludeChatIds = excludeChatIds;
            this.returnDeletedFileStatistics = returnDeletedFileStatistics;
            this.chatLimit = chatLimit;
        }

        public static final int CONSTRUCTOR = 853186759;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ParseMarkdown extends Function
    {
        public FormattedText text;

        public ParseMarkdown()
        {
        }

        public ParseMarkdown(FormattedText text)
        {
            this.text = text;
        }

        public static final int CONSTRUCTOR = 756366063;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ParseTextEntities extends Function
    {
        public String text;
        public TextParseMode parseMode;

        public ParseTextEntities()
        {
        }

        public ParseTextEntities(String text, TextParseMode parseMode)
        {
            this.text = text;
            this.parseMode = parseMode;
        }

        public static final int CONSTRUCTOR = -1709194593;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PinChatMessage extends Function
    {
        public long chatId;
        public long messageId;
        public boolean disableNotification;
        public boolean onlyForSelf;

        public PinChatMessage()
        {
        }

        public PinChatMessage(long chatId, long messageId, boolean disableNotification,
                boolean onlyForSelf)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.disableNotification = disableNotification;
            this.onlyForSelf = onlyForSelf;
        }

        public static final int CONSTRUCTOR = 2034719663;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class PingProxy extends Function
    {
        public int proxyId;

        public PingProxy()
        {
        }

        public PingProxy(int proxyId)
        {
            this.proxyId = proxyId;
        }

        public static final int CONSTRUCTOR = -979681103;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ProcessChatJoinRequest extends Function
    {
        public long chatId;
        public long userId;
        public boolean approve;

        public ProcessChatJoinRequest()
        {
        }

        public ProcessChatJoinRequest(long chatId, long userId, boolean approve)
        {
            this.chatId = chatId;
            this.userId = userId;
            this.approve = approve;
        }

        public static final int CONSTRUCTOR = 1004876963;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ProcessChatJoinRequests extends Function
    {
        public long chatId;
        public String inviteLink;
        public boolean approve;

        public ProcessChatJoinRequests()
        {
        }

        public ProcessChatJoinRequests(long chatId, String inviteLink, boolean approve)
        {
            this.chatId = chatId;
            this.inviteLink = inviteLink;
            this.approve = approve;
        }

        public static final int CONSTRUCTOR = 1048722894;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ProcessPushNotification extends Function
    {
        public String payload;

        public ProcessPushNotification()
        {
        }

        public ProcessPushNotification(String payload)
        {
            this.payload = payload;
        }

        public static final int CONSTRUCTOR = 786679952;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReadAllChatMentions extends Function
    {
        public long chatId;

        public ReadAllChatMentions()
        {
        }

        public ReadAllChatMentions(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 1357558453;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReadFilePart extends Function
    {
        public int fileId;
        public int offset;
        public int count;

        public ReadFilePart()
        {
        }

        public ReadFilePart(int fileId, int offset, int count)
        {
            this.fileId = fileId;
            this.offset = offset;
            this.count = count;
        }

        public static final int CONSTRUCTOR = -407749314;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RecoverAuthenticationPassword extends Function
    {
        public String recoveryCode;
        public String newPassword;
        public String newHint;

        public RecoverAuthenticationPassword()
        {
        }

        public RecoverAuthenticationPassword(String recoveryCode, String newPassword,
                String newHint)
        {
            this.recoveryCode = recoveryCode;
            this.newPassword = newPassword;
            this.newHint = newHint;
        }

        public static final int CONSTRUCTOR = -131001053;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RecoverPassword extends Function
    {
        public String recoveryCode;
        public String newPassword;
        public String newHint;

        public RecoverPassword()
        {
        }

        public RecoverPassword(String recoveryCode, String newPassword, String newHint)
        {
            this.recoveryCode = recoveryCode;
            this.newPassword = newPassword;
            this.newHint = newHint;
        }

        public static final int CONSTRUCTOR = -1524262541;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RegisterDevice extends Function
    {
        public DeviceToken deviceToken;
        public long[] otherUserIds;

        public RegisterDevice()
        {
        }

        public RegisterDevice(DeviceToken deviceToken, long[] otherUserIds)
        {
            this.deviceToken = deviceToken;
            this.otherUserIds = otherUserIds;
        }

        public static final int CONSTRUCTOR = 366088823;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RegisterUser extends Function
    {
        public String firstName;
        public String lastName;

        public RegisterUser()
        {
        }

        public RegisterUser(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public static final int CONSTRUCTOR = -109994467;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveBackground extends Function
    {
        public long backgroundId;

        public RemoveBackground()
        {
        }

        public RemoveBackground(long backgroundId)
        {
            this.backgroundId = backgroundId;
        }

        public static final int CONSTRUCTOR = -1484545642;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveChatActionBar extends Function
    {
        public long chatId;

        public RemoveChatActionBar()
        {
        }

        public RemoveChatActionBar(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -1650968070;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveContacts extends Function
    {
        public long[] userIds;

        public RemoveContacts()
        {
        }

        public RemoveContacts(long[] userIds)
        {
            this.userIds = userIds;
        }

        public static final int CONSTRUCTOR = 1943858054;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveFavoriteSticker extends Function
    {
        public InputFile sticker;

        public RemoveFavoriteSticker()
        {
        }

        public RemoveFavoriteSticker(InputFile sticker)
        {
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = 1152945264;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveNotification extends Function
    {
        public int notificationGroupId;
        public int notificationId;

        public RemoveNotification()
        {
        }

        public RemoveNotification(int notificationGroupId, int notificationId)
        {
            this.notificationGroupId = notificationGroupId;
            this.notificationId = notificationId;
        }

        public static final int CONSTRUCTOR = 862630734;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveNotificationGroup extends Function
    {
        public int notificationGroupId;
        public int maxNotificationId;

        public RemoveNotificationGroup()
        {
        }

        public RemoveNotificationGroup(int notificationGroupId, int maxNotificationId)
        {
            this.notificationGroupId = notificationGroupId;
            this.maxNotificationId = maxNotificationId;
        }

        public static final int CONSTRUCTOR = 1713005454;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveProxy extends Function
    {
        public int proxyId;

        public RemoveProxy()
        {
        }

        public RemoveProxy(int proxyId)
        {
            this.proxyId = proxyId;
        }

        public static final int CONSTRUCTOR = 1369219847;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveRecentHashtag extends Function
    {
        public String hashtag;

        public RemoveRecentHashtag()
        {
        }

        public RemoveRecentHashtag(String hashtag)
        {
            this.hashtag = hashtag;
        }

        public static final int CONSTRUCTOR = -1013735260;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveRecentSticker extends Function
    {
        public boolean isAttached;
        public InputFile sticker;

        public RemoveRecentSticker()
        {
        }

        public RemoveRecentSticker(boolean isAttached, InputFile sticker)
        {
            this.isAttached = isAttached;
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = 1246577677;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveRecentlyFoundChat extends Function
    {
        public long chatId;

        public RemoveRecentlyFoundChat()
        {
        }

        public RemoveRecentlyFoundChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 717340444;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveSavedAnimation extends Function
    {
        public InputFile animation;

        public RemoveSavedAnimation()
        {
        }

        public RemoveSavedAnimation(InputFile animation)
        {
            this.animation = animation;
        }

        public static final int CONSTRUCTOR = -495605479;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveStickerFromSet extends Function
    {
        public InputFile sticker;

        public RemoveStickerFromSet()
        {
        }

        public RemoveStickerFromSet(InputFile sticker)
        {
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = 1642196644;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RemoveTopChat extends Function
    {
        public TopChatCategory category;
        public long chatId;

        public RemoveTopChat()
        {
        }

        public RemoveTopChat(TopChatCategory category, long chatId)
        {
            this.category = category;
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -1907876267;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReorderChatFilters extends Function
    {
        public int[] chatFilterIds;

        public ReorderChatFilters()
        {
        }

        public ReorderChatFilters(int[] chatFilterIds)
        {
            this.chatFilterIds = chatFilterIds;
        }

        public static final int CONSTRUCTOR = -1258111097;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReorderInstalledStickerSets extends Function
    {
        public boolean isMasks;
        public long[] stickerSetIds;

        public ReorderInstalledStickerSets()
        {
        }

        public ReorderInstalledStickerSets(boolean isMasks, long[] stickerSetIds)
        {
            this.isMasks = isMasks;
            this.stickerSetIds = stickerSetIds;
        }

        public static final int CONSTRUCTOR = 1114537563;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReplacePrimaryChatInviteLink extends Function
    {
        public long chatId;

        public ReplacePrimaryChatInviteLink()
        {
        }

        public ReplacePrimaryChatInviteLink(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 1067350941;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReportChat extends Function
    {
        public long chatId;
        public long[] messageIds;
        public ChatReportReason reason;
        public String text;

        public ReportChat()
        {
        }

        public ReportChat(long chatId, long[] messageIds, ChatReportReason reason, String text)
        {
            this.chatId = chatId;
            this.messageIds = messageIds;
            this.reason = reason;
            this.text = text;
        }

        public static final int CONSTRUCTOR = -964543587;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReportChatPhoto extends Function
    {
        public long chatId;
        public int fileId;
        public ChatReportReason reason;
        public String text;

        public ReportChatPhoto()
        {
        }

        public ReportChatPhoto(long chatId, int fileId, ChatReportReason reason, String text)
        {
            this.chatId = chatId;
            this.fileId = fileId;
            this.reason = reason;
            this.text = text;
        }

        public static final int CONSTRUCTOR = 734652708;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ReportSupergroupSpam extends Function
    {
        public long supergroupId;
        public long[] messageIds;

        public ReportSupergroupSpam()
        {
        }

        public ReportSupergroupSpam(long supergroupId, long[] messageIds)
        {
            this.supergroupId = supergroupId;
            this.messageIds = messageIds;
        }

        public static final int CONSTRUCTOR = -94825000;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RequestAuthenticationPasswordRecovery extends Function
    {

        public RequestAuthenticationPasswordRecovery()
        {
        }

        public static final int CONSTRUCTOR = 1393896118;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RequestPasswordRecovery extends Function
    {

        public RequestPasswordRecovery()
        {
        }

        public static final int CONSTRUCTOR = -13777582;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RequestQrCodeAuthentication extends Function
    {
        public long[] otherUserIds;

        public RequestQrCodeAuthentication()
        {
        }

        public RequestQrCodeAuthentication(long[] otherUserIds)
        {
            this.otherUserIds = otherUserIds;
        }

        public static final int CONSTRUCTOR = 1363496527;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResendAuthenticationCode extends Function
    {

        public ResendAuthenticationCode()
        {
        }

        public static final int CONSTRUCTOR = -814377191;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResendChangePhoneNumberCode extends Function
    {

        public ResendChangePhoneNumberCode()
        {
        }

        public static final int CONSTRUCTOR = -786772060;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResendEmailAddressVerificationCode extends Function
    {

        public ResendEmailAddressVerificationCode()
        {
        }

        public static final int CONSTRUCTOR = -1872416732;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResendMessages extends Function
    {
        public long chatId;
        public long[] messageIds;

        public ResendMessages()
        {
        }

        public ResendMessages(long chatId, long[] messageIds)
        {
            this.chatId = chatId;
            this.messageIds = messageIds;
        }

        public static final int CONSTRUCTOR = -940655817;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResendPhoneNumberConfirmationCode extends Function
    {

        public ResendPhoneNumberConfirmationCode()
        {
        }

        public static final int CONSTRUCTOR = 2069068522;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResendPhoneNumberVerificationCode extends Function
    {

        public ResendPhoneNumberVerificationCode()
        {
        }

        public static final int CONSTRUCTOR = 1367629820;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResendRecoveryEmailAddressCode extends Function
    {

        public ResendRecoveryEmailAddressCode()
        {
        }

        public static final int CONSTRUCTOR = 433483548;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResetAllNotificationSettings extends Function
    {

        public ResetAllNotificationSettings()
        {
        }

        public static final int CONSTRUCTOR = -174020359;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResetBackgrounds extends Function
    {

        public ResetBackgrounds()
        {
        }

        public static final int CONSTRUCTOR = 204852088;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResetNetworkStatistics extends Function
    {

        public ResetNetworkStatistics()
        {
        }

        public static final int CONSTRUCTOR = 1646452102;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ResetPassword extends Function
    {

        public ResetPassword()
        {
        }

        public static final int CONSTRUCTOR = -593589091;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RevokeChatInviteLink extends Function
    {
        public long chatId;
        public String inviteLink;

        public RevokeChatInviteLink()
        {
        }

        public RevokeChatInviteLink(long chatId, String inviteLink)
        {
            this.chatId = chatId;
            this.inviteLink = inviteLink;
        }

        public static final int CONSTRUCTOR = -776514135;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class RevokeGroupCallInviteLink extends Function
    {
        public int groupCallId;

        public RevokeGroupCallInviteLink()
        {
        }

        public RevokeGroupCallInviteLink(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = 501589140;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SaveApplicationLogEvent extends Function
    {
        public String type;
        public long chatId;
        public JsonValue data;

        public SaveApplicationLogEvent()
        {
        }

        public SaveApplicationLogEvent(String type, long chatId, JsonValue data)
        {
            this.type = type;
            this.chatId = chatId;
            this.data = data;
        }

        public static final int CONSTRUCTOR = -811154930;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchBackground extends Function
    {
        public String name;

        public SearchBackground()
        {
        }

        public SearchBackground(String name)
        {
            this.name = name;
        }

        public static final int CONSTRUCTOR = -2130996959;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchCallMessages extends Function
    {
        public long fromMessageId;
        public int limit;
        public boolean onlyMissed;

        public SearchCallMessages()
        {
        }

        public SearchCallMessages(long fromMessageId, int limit, boolean onlyMissed)
        {
            this.fromMessageId = fromMessageId;
            this.limit = limit;
            this.onlyMissed = onlyMissed;
        }

        public static final int CONSTRUCTOR = -1077230820;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchChatMembers extends Function
    {
        public long chatId;
        public String query;
        public int limit;
        public ChatMembersFilter filter;

        public SearchChatMembers()
        {
        }

        public SearchChatMembers(long chatId, String query, int limit, ChatMembersFilter filter)
        {
            this.chatId = chatId;
            this.query = query;
            this.limit = limit;
            this.filter = filter;
        }

        public static final int CONSTRUCTOR = -445823291;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchChatMessages extends Function
    {
        public long chatId;
        public String query;
        public MessageSender senderId;
        public long fromMessageId;
        public int offset;
        public int limit;
        public SearchMessagesFilter filter;
        public long messageThreadId;

        public SearchChatMessages()
        {
        }

        public SearchChatMessages(long chatId, String query, MessageSender senderId,
                long fromMessageId, int offset, int limit, SearchMessagesFilter filter,
                long messageThreadId)
        {
            this.chatId = chatId;
            this.query = query;
            this.senderId = senderId;
            this.fromMessageId = fromMessageId;
            this.offset = offset;
            this.limit = limit;
            this.filter = filter;
            this.messageThreadId = messageThreadId;
        }

        public static final int CONSTRUCTOR = -162154976;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchChatRecentLocationMessages extends Function
    {
        public long chatId;
        public int limit;

        public SearchChatRecentLocationMessages()
        {
        }

        public SearchChatRecentLocationMessages(long chatId, int limit)
        {
            this.chatId = chatId;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 950238950;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchChats extends Function
    {
        public String query;
        public int limit;

        public SearchChats()
        {
        }

        public SearchChats(String query, int limit)
        {
            this.query = query;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -1879787060;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchChatsNearby extends Function
    {
        public Location location;

        public SearchChatsNearby()
        {
        }

        public SearchChatsNearby(Location location)
        {
            this.location = location;
        }

        public static final int CONSTRUCTOR = -196753377;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchChatsOnServer extends Function
    {
        public String query;
        public int limit;

        public SearchChatsOnServer()
        {
        }

        public SearchChatsOnServer(String query, int limit)
        {
            this.query = query;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -1158402188;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchContacts extends Function
    {
        public String query;
        public int limit;

        public SearchContacts()
        {
        }

        public SearchContacts(String query, int limit)
        {
            this.query = query;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = -1794690715;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchEmojis extends Function
    {
        public String text;
        public boolean exactMatch;
        public String[] inputLanguageCodes;

        public SearchEmojis()
        {
        }

        public SearchEmojis(String text, boolean exactMatch, String[] inputLanguageCodes)
        {
            this.text = text;
            this.exactMatch = exactMatch;
            this.inputLanguageCodes = inputLanguageCodes;
        }

        public static final int CONSTRUCTOR = 398837927;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchHashtags extends Function
    {
        public String prefix;
        public int limit;

        public SearchHashtags()
        {
        }

        public SearchHashtags(String prefix, int limit)
        {
            this.prefix = prefix;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 1043637617;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchInstalledStickerSets extends Function
    {
        public boolean isMasks;
        public String query;
        public int limit;

        public SearchInstalledStickerSets()
        {
        }

        public SearchInstalledStickerSets(boolean isMasks, String query, int limit)
        {
            this.isMasks = isMasks;
            this.query = query;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 681171344;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchMessages extends Function
    {
        public ChatList chatList;
        public String query;
        public int offsetDate;
        public long offsetChatId;
        public long offsetMessageId;
        public int limit;
        public SearchMessagesFilter filter;
        public int minDate;
        public int maxDate;

        public SearchMessages()
        {
        }

        public SearchMessages(ChatList chatList, String query, int offsetDate, long offsetChatId,
                long offsetMessageId, int limit, SearchMessagesFilter filter, int minDate,
                int maxDate)
        {
            this.chatList = chatList;
            this.query = query;
            this.offsetDate = offsetDate;
            this.offsetChatId = offsetChatId;
            this.offsetMessageId = offsetMessageId;
            this.limit = limit;
            this.filter = filter;
            this.minDate = minDate;
            this.maxDate = maxDate;
        }

        public static final int CONSTRUCTOR = -225214062;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchPublicChat extends Function
    {
        public String username;

        public SearchPublicChat()
        {
        }

        public SearchPublicChat(String username)
        {
            this.username = username;
        }

        public static final int CONSTRUCTOR = 857135533;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchPublicChats extends Function
    {
        public String query;

        public SearchPublicChats()
        {
        }

        public SearchPublicChats(String query)
        {
            this.query = query;
        }

        public static final int CONSTRUCTOR = 970385337;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchSecretMessages extends Function
    {
        public long chatId;
        public String query;
        public String offset;
        public int limit;
        public SearchMessagesFilter filter;

        public SearchSecretMessages()
        {
        }

        public SearchSecretMessages(long chatId, String query, String offset, int limit,
                SearchMessagesFilter filter)
        {
            this.chatId = chatId;
            this.query = query;
            this.offset = offset;
            this.limit = limit;
            this.filter = filter;
        }

        public static final int CONSTRUCTOR = -852865892;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchStickerSet extends Function
    {
        public String name;

        public SearchStickerSet()
        {
        }

        public SearchStickerSet(String name)
        {
            this.name = name;
        }

        public static final int CONSTRUCTOR = 1157930222;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchStickerSets extends Function
    {
        public String query;

        public SearchStickerSets()
        {
        }

        public SearchStickerSets(String query)
        {
            this.query = query;
        }

        public static final int CONSTRUCTOR = -1082314629;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SearchStickers extends Function
    {
        public String emoji;
        public int limit;

        public SearchStickers()
        {
        }

        public SearchStickers(String emoji, int limit)
        {
            this.emoji = emoji;
            this.limit = limit;
        }

        public static final int CONSTRUCTOR = 1555771203;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendBotStartMessage extends Function
    {
        public long botUserId;
        public long chatId;
        public String parameter;

        public SendBotStartMessage()
        {
        }

        public SendBotStartMessage(long botUserId, long chatId, String parameter)
        {
            this.botUserId = botUserId;
            this.chatId = chatId;
            this.parameter = parameter;
        }

        public static final int CONSTRUCTOR = -1435877650;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendCallDebugInformation extends Function
    {
        public int callId;
        public String debugInformation;

        public SendCallDebugInformation()
        {
        }

        public SendCallDebugInformation(int callId, String debugInformation)
        {
            this.callId = callId;
            this.debugInformation = debugInformation;
        }

        public static final int CONSTRUCTOR = 2019243839;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendCallRating extends Function
    {
        public int callId;
        public int rating;
        public String comment;
        public CallProblem[] problems;

        public SendCallRating()
        {
        }

        public SendCallRating(int callId, int rating, String comment, CallProblem[] problems)
        {
            this.callId = callId;
            this.rating = rating;
            this.comment = comment;
            this.problems = problems;
        }

        public static final int CONSTRUCTOR = -1402719502;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendCallSignalingData extends Function
    {
        public int callId;
        public byte[] data;

        public SendCallSignalingData()
        {
        }

        public SendCallSignalingData(int callId, byte[] data)
        {
            this.callId = callId;
            this.data = data;
        }

        public static final int CONSTRUCTOR = 1412280732;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendChatAction extends Function
    {
        public long chatId;
        public long messageThreadId;
        public ChatAction action;

        public SendChatAction()
        {
        }

        public SendChatAction(long chatId, long messageThreadId, ChatAction action)
        {
            this.chatId = chatId;
            this.messageThreadId = messageThreadId;
            this.action = action;
        }

        public static final int CONSTRUCTOR = 2096947540;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendChatScreenshotTakenNotification extends Function
    {
        public long chatId;

        public SendChatScreenshotTakenNotification()
        {
        }

        public SendChatScreenshotTakenNotification(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 448399457;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendCustomRequest extends Function
    {
        public String method;
        public String parameters;

        public SendCustomRequest()
        {
        }

        public SendCustomRequest(String method, String parameters)
        {
            this.method = method;
            this.parameters = parameters;
        }

        public static final int CONSTRUCTOR = 285045153;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendEmailAddressVerificationCode extends Function
    {
        public String emailAddress;

        public SendEmailAddressVerificationCode()
        {
        }

        public SendEmailAddressVerificationCode(String emailAddress)
        {
            this.emailAddress = emailAddress;
        }

        public static final int CONSTRUCTOR = -221621379;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendInlineQueryResultMessage extends Function
    {
        public long chatId;
        public long messageThreadId;
        public long replyToMessageId;
        public MessageSendOptions options;
        public long queryId;
        public String resultId;
        public boolean hideViaBot;

        public SendInlineQueryResultMessage()
        {
        }

        public SendInlineQueryResultMessage(long chatId, long messageThreadId,
                long replyToMessageId, MessageSendOptions options, long queryId, String resultId,
                boolean hideViaBot)
        {
            this.chatId = chatId;
            this.messageThreadId = messageThreadId;
            this.replyToMessageId = replyToMessageId;
            this.options = options;
            this.queryId = queryId;
            this.resultId = resultId;
            this.hideViaBot = hideViaBot;
        }

        public static final int CONSTRUCTOR = -948639588;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendMessage extends Function
    {
        public long chatId;
        public long messageThreadId;
        public long replyToMessageId;
        public MessageSendOptions options;
        public ReplyMarkup replyMarkup;
        public InputMessageContent inputMessageContent;

        public SendMessage()
        {
        }

        public SendMessage(long chatId, long messageThreadId, long replyToMessageId,
                MessageSendOptions options, ReplyMarkup replyMarkup,
                InputMessageContent inputMessageContent)
        {
            this.chatId = chatId;
            this.messageThreadId = messageThreadId;
            this.replyToMessageId = replyToMessageId;
            this.options = options;
            this.replyMarkup = replyMarkup;
            this.inputMessageContent = inputMessageContent;
        }

        public static final int CONSTRUCTOR = 960453021;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendMessageAlbum extends Function
    {
        public long chatId;
        public long messageThreadId;
        public long replyToMessageId;
        public MessageSendOptions options;
        public InputMessageContent[] inputMessageContents;

        public SendMessageAlbum()
        {
        }

        public SendMessageAlbum(long chatId, long messageThreadId, long replyToMessageId,
                MessageSendOptions options, InputMessageContent[] inputMessageContents)
        {
            this.chatId = chatId;
            this.messageThreadId = messageThreadId;
            this.replyToMessageId = replyToMessageId;
            this.options = options;
            this.inputMessageContents = inputMessageContents;
        }

        public static final int CONSTRUCTOR = 983360432;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendPassportAuthorizationForm extends Function
    {
        public int autorizationFormId;
        public PassportElementType[] types;

        public SendPassportAuthorizationForm()
        {
        }

        public SendPassportAuthorizationForm(int autorizationFormId, PassportElementType[] types)
        {
            this.autorizationFormId = autorizationFormId;
            this.types = types;
        }

        public static final int CONSTRUCTOR = -602402218;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendPaymentForm extends Function
    {
        public long chatId;
        public long messageId;
        public long paymentFormId;
        public String orderInfoId;
        public String shippingOptionId;
        public InputCredentials credentials;
        public long tipAmount;

        public SendPaymentForm()
        {
        }

        public SendPaymentForm(long chatId, long messageId, long paymentFormId, String orderInfoId,
                String shippingOptionId, InputCredentials credentials, long tipAmount)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.paymentFormId = paymentFormId;
            this.orderInfoId = orderInfoId;
            this.shippingOptionId = shippingOptionId;
            this.credentials = credentials;
            this.tipAmount = tipAmount;
        }

        public static final int CONSTRUCTOR = 1536242687;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendPhoneNumberConfirmationCode extends Function
    {
        public String hash;
        public String phoneNumber;
        public PhoneNumberAuthenticationSettings settings;

        public SendPhoneNumberConfirmationCode()
        {
        }

        public SendPhoneNumberConfirmationCode(String hash, String phoneNumber,
                PhoneNumberAuthenticationSettings settings)
        {
            this.hash = hash;
            this.phoneNumber = phoneNumber;
            this.settings = settings;
        }

        public static final int CONSTRUCTOR = -1901171495;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SendPhoneNumberVerificationCode extends Function
    {
        public String phoneNumber;
        public PhoneNumberAuthenticationSettings settings;

        public SendPhoneNumberVerificationCode()
        {
        }

        public SendPhoneNumberVerificationCode(String phoneNumber,
                PhoneNumberAuthenticationSettings settings)
        {
            this.phoneNumber = phoneNumber;
            this.settings = settings;
        }

        public static final int CONSTRUCTOR = 2081689035;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetAccountTtl extends Function
    {
        public AccountTtl ttl;

        public SetAccountTtl()
        {
        }

        public SetAccountTtl(AccountTtl ttl)
        {
            this.ttl = ttl;
        }

        public static final int CONSTRUCTOR = 701389032;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetAlarm extends Function
    {
        public double seconds;

        public SetAlarm()
        {
        }

        public SetAlarm(double seconds)
        {
            this.seconds = seconds;
        }

        public static final int CONSTRUCTOR = -873497067;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetAuthenticationPhoneNumber extends Function
    {
        public String phoneNumber;
        public PhoneNumberAuthenticationSettings settings;

        public SetAuthenticationPhoneNumber()
        {
        }

        public SetAuthenticationPhoneNumber(String phoneNumber,
                PhoneNumberAuthenticationSettings settings)
        {
            this.phoneNumber = phoneNumber;
            this.settings = settings;
        }

        public static final int CONSTRUCTOR = 868276259;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetAutoDownloadSettings extends Function
    {
        public AutoDownloadSettings settings;
        public NetworkType type;

        public SetAutoDownloadSettings()
        {
        }

        public SetAutoDownloadSettings(AutoDownloadSettings settings, NetworkType type)
        {
            this.settings = settings;
            this.type = type;
        }

        public static final int CONSTRUCTOR = -353671948;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetBackground extends Function
    {
        public InputBackground background;
        public BackgroundType type;
        public boolean forDarkTheme;

        public SetBackground()
        {
        }

        public SetBackground(InputBackground background, BackgroundType type, boolean forDarkTheme)
        {
            this.background = background;
            this.type = type;
            this.forDarkTheme = forDarkTheme;
        }

        public static final int CONSTRUCTOR = -1035439225;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetBio extends Function
    {
        public String bio;

        public SetBio()
        {
        }

        public SetBio(String bio)
        {
            this.bio = bio;
        }

        public static final int CONSTRUCTOR = -1619582124;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetBotUpdatesStatus extends Function
    {
        public int pendingUpdateCount;
        public String errorMessage;

        public SetBotUpdatesStatus()
        {
        }

        public SetBotUpdatesStatus(int pendingUpdateCount, String errorMessage)
        {
            this.pendingUpdateCount = pendingUpdateCount;
            this.errorMessage = errorMessage;
        }

        public static final int CONSTRUCTOR = -1154926191;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatClientData extends Function
    {
        public long chatId;
        public String clientData;

        public SetChatClientData()
        {
        }

        public SetChatClientData(long chatId, String clientData)
        {
            this.chatId = chatId;
            this.clientData = clientData;
        }

        public static final int CONSTRUCTOR = -827119811;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatDescription extends Function
    {
        public long chatId;
        public String description;

        public SetChatDescription()
        {
        }

        public SetChatDescription(long chatId, String description)
        {
            this.chatId = chatId;
            this.description = description;
        }

        public static final int CONSTRUCTOR = 1957213277;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatDiscussionGroup extends Function
    {
        public long chatId;
        public long discussionChatId;

        public SetChatDiscussionGroup()
        {
        }

        public SetChatDiscussionGroup(long chatId, long discussionChatId)
        {
            this.chatId = chatId;
            this.discussionChatId = discussionChatId;
        }

        public static final int CONSTRUCTOR = -918801736;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatDraftMessage extends Function
    {
        public long chatId;
        public long messageThreadId;
        public DraftMessage draftMessage;

        public SetChatDraftMessage()
        {
        }

        public SetChatDraftMessage(long chatId, long messageThreadId, DraftMessage draftMessage)
        {
            this.chatId = chatId;
            this.messageThreadId = messageThreadId;
            this.draftMessage = draftMessage;
        }

        public static final int CONSTRUCTOR = 1683889946;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatLocation extends Function
    {
        public long chatId;
        public ChatLocation location;

        public SetChatLocation()
        {
        }

        public SetChatLocation(long chatId, ChatLocation location)
        {
            this.chatId = chatId;
            this.location = location;
        }

        public static final int CONSTRUCTOR = -767091286;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatMemberStatus extends Function
    {
        public long chatId;
        public MessageSender memberId;
        public ChatMemberStatus status;

        public SetChatMemberStatus()
        {
        }

        public SetChatMemberStatus(long chatId, MessageSender memberId, ChatMemberStatus status)
        {
            this.chatId = chatId;
            this.memberId = memberId;
            this.status = status;
        }

        public static final int CONSTRUCTOR = 81794847;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatMessageSender extends Function
    {
        public long chatId;
        public MessageSender messageSenderId;

        public SetChatMessageSender()
        {
        }

        public SetChatMessageSender(long chatId, MessageSender messageSenderId)
        {
            this.chatId = chatId;
            this.messageSenderId = messageSenderId;
        }

        public static final int CONSTRUCTOR = -1421513858;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatMessageTtl extends Function
    {
        public long chatId;
        public int ttl;

        public SetChatMessageTtl()
        {
        }

        public SetChatMessageTtl(long chatId, int ttl)
        {
            this.chatId = chatId;
            this.ttl = ttl;
        }

        public static final int CONSTRUCTOR = -1578406279;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatNotificationSettings extends Function
    {
        public long chatId;
        public ChatNotificationSettings notificationSettings;

        public SetChatNotificationSettings()
        {
        }

        public SetChatNotificationSettings(long chatId,
                ChatNotificationSettings notificationSettings)
        {
            this.chatId = chatId;
            this.notificationSettings = notificationSettings;
        }

        public static final int CONSTRUCTOR = 777199614;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatPermissions extends Function
    {
        public long chatId;
        public ChatPermissions permissions;

        public SetChatPermissions()
        {
        }

        public SetChatPermissions(long chatId, ChatPermissions permissions)
        {
            this.chatId = chatId;
            this.permissions = permissions;
        }

        public static final int CONSTRUCTOR = 2138507006;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatPhoto extends Function
    {
        public long chatId;
        public InputChatPhoto photo;

        public SetChatPhoto()
        {
        }

        public SetChatPhoto(long chatId, InputChatPhoto photo)
        {
            this.chatId = chatId;
            this.photo = photo;
        }

        public static final int CONSTRUCTOR = -377778941;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatSlowModeDelay extends Function
    {
        public long chatId;
        public int slowModeDelay;

        public SetChatSlowModeDelay()
        {
        }

        public SetChatSlowModeDelay(long chatId, int slowModeDelay)
        {
            this.chatId = chatId;
            this.slowModeDelay = slowModeDelay;
        }

        public static final int CONSTRUCTOR = -540350914;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatTheme extends Function
    {
        public long chatId;
        public String themeName;

        public SetChatTheme()
        {
        }

        public SetChatTheme(long chatId, String themeName)
        {
            this.chatId = chatId;
            this.themeName = themeName;
        }

        public static final int CONSTRUCTOR = -1895234925;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetChatTitle extends Function
    {
        public long chatId;
        public String title;

        public SetChatTitle()
        {
        }

        public SetChatTitle(long chatId, String title)
        {
            this.chatId = chatId;
            this.title = title;
        }

        public static final int CONSTRUCTOR = 164282047;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetCommands extends Function
    {
        public BotCommandScope scope;
        public String languageCode;
        public BotCommand[] commands;

        public SetCommands()
        {
        }

        public SetCommands(BotCommandScope scope, String languageCode, BotCommand[] commands)
        {
            this.scope = scope;
            this.languageCode = languageCode;
            this.commands = commands;
        }

        public static final int CONSTRUCTOR = -907165606;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetCustomLanguagePack extends Function
    {
        public LanguagePackInfo info;
        public LanguagePackString[] strings;

        public SetCustomLanguagePack()
        {
        }

        public SetCustomLanguagePack(LanguagePackInfo info, LanguagePackString[] strings)
        {
            this.info = info;
            this.strings = strings;
        }

        public static final int CONSTRUCTOR = -296742819;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetCustomLanguagePackString extends Function
    {
        public String languagePackId;
        public LanguagePackString newString;

        public SetCustomLanguagePackString()
        {
        }

        public SetCustomLanguagePackString(String languagePackId, LanguagePackString newString)
        {
            this.languagePackId = languagePackId;
            this.newString = newString;
        }

        public static final int CONSTRUCTOR = 1316365592;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetDatabaseEncryptionKey extends Function
    {
        public byte[] newEncryptionKey;

        public SetDatabaseEncryptionKey()
        {
        }

        public SetDatabaseEncryptionKey(byte[] newEncryptionKey)
        {
            this.newEncryptionKey = newEncryptionKey;
        }

        public static final int CONSTRUCTOR = -1204599371;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetFileGenerationProgress extends Function
    {
        public long generationId;
        public int expectedSize;
        public int localPrefixSize;

        public SetFileGenerationProgress()
        {
        }

        public SetFileGenerationProgress(long generationId, int expectedSize, int localPrefixSize)
        {
            this.generationId = generationId;
            this.expectedSize = expectedSize;
            this.localPrefixSize = localPrefixSize;
        }

        public static final int CONSTRUCTOR = -540459953;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetGameScore extends Function
    {
        public long chatId;
        public long messageId;
        public boolean editMessage;
        public long userId;
        public int score;
        public boolean force;

        public SetGameScore()
        {
        }

        public SetGameScore(long chatId, long messageId, boolean editMessage, long userId,
                int score, boolean force)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.editMessage = editMessage;
            this.userId = userId;
            this.score = score;
            this.force = force;
        }

        public static final int CONSTRUCTOR = 2127359430;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetGroupCallParticipantIsSpeaking extends Function
    {
        public int groupCallId;
        public int audioSource;
        public boolean isSpeaking;

        public SetGroupCallParticipantIsSpeaking()
        {
        }

        public SetGroupCallParticipantIsSpeaking(int groupCallId, int audioSource,
                boolean isSpeaking)
        {
            this.groupCallId = groupCallId;
            this.audioSource = audioSource;
            this.isSpeaking = isSpeaking;
        }

        public static final int CONSTRUCTOR = 927506917;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetGroupCallParticipantVolumeLevel extends Function
    {
        public int groupCallId;
        public MessageSender participantId;
        public int volumeLevel;

        public SetGroupCallParticipantVolumeLevel()
        {
        }

        public SetGroupCallParticipantVolumeLevel(int groupCallId, MessageSender participantId,
                int volumeLevel)
        {
            this.groupCallId = groupCallId;
            this.participantId = participantId;
            this.volumeLevel = volumeLevel;
        }

        public static final int CONSTRUCTOR = -1753769944;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetGroupCallTitle extends Function
    {
        public int groupCallId;
        public String title;

        public SetGroupCallTitle()
        {
        }

        public SetGroupCallTitle(int groupCallId, String title)
        {
            this.groupCallId = groupCallId;
            this.title = title;
        }

        public static final int CONSTRUCTOR = -1228825139;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetInactiveSessionTtl extends Function
    {
        public int inactiveSessionTtlDays;

        public SetInactiveSessionTtl()
        {
        }

        public SetInactiveSessionTtl(int inactiveSessionTtlDays)
        {
            this.inactiveSessionTtlDays = inactiveSessionTtlDays;
        }

        public static final int CONSTRUCTOR = 1570548048;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetInlineGameScore extends Function
    {
        public String inlineMessageId;
        public boolean editMessage;
        public long userId;
        public int score;
        public boolean force;

        public SetInlineGameScore()
        {
        }

        public SetInlineGameScore(String inlineMessageId, boolean editMessage, long userId,
                int score, boolean force)
        {
            this.inlineMessageId = inlineMessageId;
            this.editMessage = editMessage;
            this.userId = userId;
            this.score = score;
            this.force = force;
        }

        public static final int CONSTRUCTOR = -948871797;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetLocation extends Function
    {
        public Location location;

        public SetLocation()
        {
        }

        public SetLocation(Location location)
        {
            this.location = location;
        }

        public static final int CONSTRUCTOR = 93926257;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetLogStream extends Function
    {
        public LogStream logStream;

        public SetLogStream()
        {
        }

        public SetLogStream(LogStream logStream)
        {
            this.logStream = logStream;
        }

        public static final int CONSTRUCTOR = -1364199535;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetLogTagVerbosityLevel extends Function
    {
        public String tag;
        public int newVerbosityLevel;

        public SetLogTagVerbosityLevel()
        {
        }

        public SetLogTagVerbosityLevel(String tag, int newVerbosityLevel)
        {
            this.tag = tag;
            this.newVerbosityLevel = newVerbosityLevel;
        }

        public static final int CONSTRUCTOR = -2095589738;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetLogVerbosityLevel extends Function
    {
        public int newVerbosityLevel;

        public SetLogVerbosityLevel()
        {
        }

        public SetLogVerbosityLevel(int newVerbosityLevel)
        {
            this.newVerbosityLevel = newVerbosityLevel;
        }

        public static final int CONSTRUCTOR = -303429678;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetName extends Function
    {
        public String firstName;
        public String lastName;

        public SetName()
        {
        }

        public SetName(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public static final int CONSTRUCTOR = 1711693584;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetNetworkType extends Function
    {
        public NetworkType type;

        public SetNetworkType()
        {
        }

        public SetNetworkType(NetworkType type)
        {
            this.type = type;
        }

        public static final int CONSTRUCTOR = -701635234;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetOption extends Function
    {
        public String name;
        public OptionValue value;

        public SetOption()
        {
        }

        public SetOption(String name, OptionValue value)
        {
            this.name = name;
            this.value = value;
        }

        public static final int CONSTRUCTOR = 2114670322;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetPassportElement extends Function
    {
        public InputPassportElement element;
        public String password;

        public SetPassportElement()
        {
        }

        public SetPassportElement(InputPassportElement element, String password)
        {
            this.element = element;
            this.password = password;
        }

        public static final int CONSTRUCTOR = 2068173212;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetPassportElementErrors extends Function
    {
        public long userId;
        public InputPassportElementError[] errors;

        public SetPassportElementErrors()
        {
        }

        public SetPassportElementErrors(long userId, InputPassportElementError[] errors)
        {
            this.userId = userId;
            this.errors = errors;
        }

        public static final int CONSTRUCTOR = -2056754881;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetPassword extends Function
    {
        public String oldPassword;
        public String newPassword;
        public String newHint;
        public boolean setRecoveryEmailAddress;
        public String newRecoveryEmailAddress;

        public SetPassword()
        {
        }

        public SetPassword(String oldPassword, String newPassword, String newHint,
                boolean setRecoveryEmailAddress, String newRecoveryEmailAddress)
        {
            this.oldPassword = oldPassword;
            this.newPassword = newPassword;
            this.newHint = newHint;
            this.setRecoveryEmailAddress = setRecoveryEmailAddress;
            this.newRecoveryEmailAddress = newRecoveryEmailAddress;
        }

        public static final int CONSTRUCTOR = -1193589027;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetPinnedChats extends Function
    {
        public ChatList chatList;
        public long[] chatIds;

        public SetPinnedChats()
        {
        }

        public SetPinnedChats(ChatList chatList, long[] chatIds)
        {
            this.chatList = chatList;
            this.chatIds = chatIds;
        }

        public static final int CONSTRUCTOR = -695640000;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetPollAnswer extends Function
    {
        public long chatId;
        public long messageId;
        public int[] optionIds;

        public SetPollAnswer()
        {
        }

        public SetPollAnswer(long chatId, long messageId, int[] optionIds)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.optionIds = optionIds;
        }

        public static final int CONSTRUCTOR = -1399388792;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetProfilePhoto extends Function
    {
        public InputChatPhoto photo;

        public SetProfilePhoto()
        {
        }

        public SetProfilePhoto(InputChatPhoto photo)
        {
            this.photo = photo;
        }

        public static final int CONSTRUCTOR = -2069678882;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetRecoveryEmailAddress extends Function
    {
        public String password;
        public String newRecoveryEmailAddress;

        public SetRecoveryEmailAddress()
        {
        }

        public SetRecoveryEmailAddress(String password, String newRecoveryEmailAddress)
        {
            this.password = password;
            this.newRecoveryEmailAddress = newRecoveryEmailAddress;
        }

        public static final int CONSTRUCTOR = -1981836385;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetScopeNotificationSettings extends Function
    {
        public NotificationSettingsScope scope;
        public ScopeNotificationSettings notificationSettings;

        public SetScopeNotificationSettings()
        {
        }

        public SetScopeNotificationSettings(NotificationSettingsScope scope,
                ScopeNotificationSettings notificationSettings)
        {
            this.scope = scope;
            this.notificationSettings = notificationSettings;
        }

        public static final int CONSTRUCTOR = -2049984966;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetStickerPositionInSet extends Function
    {
        public InputFile sticker;
        public int position;

        public SetStickerPositionInSet()
        {
        }

        public SetStickerPositionInSet(InputFile sticker, int position)
        {
            this.sticker = sticker;
            this.position = position;
        }

        public static final int CONSTRUCTOR = 2075281185;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetStickerSetThumbnail extends Function
    {
        public long userId;
        public String name;
        public InputFile thumbnail;

        public SetStickerSetThumbnail()
        {
        }

        public SetStickerSetThumbnail(long userId, String name, InputFile thumbnail)
        {
            this.userId = userId;
            this.name = name;
            this.thumbnail = thumbnail;
        }

        public static final int CONSTRUCTOR = 1230174856;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetSupergroupStickerSet extends Function
    {
        public long supergroupId;
        public long stickerSetId;

        public SetSupergroupStickerSet()
        {
        }

        public SetSupergroupStickerSet(long supergroupId, long stickerSetId)
        {
            this.supergroupId = supergroupId;
            this.stickerSetId = stickerSetId;
        }

        public static final int CONSTRUCTOR = -2056344215;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetSupergroupUsername extends Function
    {
        public long supergroupId;
        public String username;

        public SetSupergroupUsername()
        {
        }

        public SetSupergroupUsername(long supergroupId, String username)
        {
            this.supergroupId = supergroupId;
            this.username = username;
        }

        public static final int CONSTRUCTOR = 1346325252;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetTdlibParameters extends Function
    {
        public TdlibParameters parameters;

        public SetTdlibParameters()
        {
        }

        public SetTdlibParameters(TdlibParameters parameters)
        {
            this.parameters = parameters;
        }

        public static final int CONSTRUCTOR = -1912557997;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetUserPrivacySettingRules extends Function
    {
        public UserPrivacySetting setting;
        public UserPrivacySettingRules rules;

        public SetUserPrivacySettingRules()
        {
        }

        public SetUserPrivacySettingRules(UserPrivacySetting setting, UserPrivacySettingRules rules)
        {
            this.setting = setting;
            this.rules = rules;
        }

        public static final int CONSTRUCTOR = -473812741;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetUsername extends Function
    {
        public String username;

        public SetUsername()
        {
        }

        public SetUsername(String username)
        {
            this.username = username;
        }

        public static final int CONSTRUCTOR = 439901214;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SetVideoChatDefaultParticipant extends Function
    {
        public long chatId;
        public MessageSender defaultParticipantId;

        public SetVideoChatDefaultParticipant()
        {
        }

        public SetVideoChatDefaultParticipant(long chatId, MessageSender defaultParticipantId)
        {
            this.chatId = chatId;
            this.defaultParticipantId = defaultParticipantId;
        }

        public static final int CONSTRUCTOR = -240749901;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SharePhoneNumber extends Function
    {
        public long userId;

        public SharePhoneNumber()
        {
        }

        public SharePhoneNumber(long userId)
        {
            this.userId = userId;
        }

        public static final int CONSTRUCTOR = 1097130069;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StartGroupCallRecording extends Function
    {
        public int groupCallId;
        public String title;
        public boolean recordVideo;
        public boolean usePortraitOrientation;

        public StartGroupCallRecording()
        {
        }

        public StartGroupCallRecording(int groupCallId, String title, boolean recordVideo,
                boolean usePortraitOrientation)
        {
            this.groupCallId = groupCallId;
            this.title = title;
            this.recordVideo = recordVideo;
            this.usePortraitOrientation = usePortraitOrientation;
        }

        public static final int CONSTRUCTOR = 1757774971;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StartGroupCallScreenSharing extends Function
    {
        public int groupCallId;
        public int audioSourceId;
        public String payload;

        public StartGroupCallScreenSharing()
        {
        }

        public StartGroupCallScreenSharing(int groupCallId, int audioSourceId, String payload)
        {
            this.groupCallId = groupCallId;
            this.audioSourceId = audioSourceId;
            this.payload = payload;
        }

        public static final int CONSTRUCTOR = -884068051;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StartScheduledGroupCall extends Function
    {
        public int groupCallId;

        public StartScheduledGroupCall()
        {
        }

        public StartScheduledGroupCall(int groupCallId)
        {
            this.groupCallId = groupCallId;
        }

        public static final int CONSTRUCTOR = 1519938838;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class StopPoll extends Function
    {
        public long chatId;
        public long messageId;
        public ReplyMarkup replyMarkup;

        public StopPoll()
        {
        }

        public StopPoll(long chatId, long messageId, ReplyMarkup replyMarkup)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.replyMarkup = replyMarkup;
        }

        public static final int CONSTRUCTOR = 1659374253;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class SynchronizeLanguagePack extends Function
    {
        public String languagePackId;

        public SynchronizeLanguagePack()
        {
        }

        public SynchronizeLanguagePack(String languagePackId)
        {
            this.languagePackId = languagePackId;
        }

        public static final int CONSTRUCTOR = -2065307858;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TerminateAllOtherSessions extends Function
    {

        public TerminateAllOtherSessions()
        {
        }

        public static final int CONSTRUCTOR = 1874485523;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TerminateSession extends Function
    {
        public long sessionId;

        public TerminateSession()
        {
        }

        public TerminateSession(long sessionId)
        {
            this.sessionId = sessionId;
        }

        public static final int CONSTRUCTOR = -407385812;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestCallBytes extends Function
    {
        public byte[] x;

        public TestCallBytes()
        {
        }

        public TestCallBytes(byte[] x)
        {
            this.x = x;
        }

        public static final int CONSTRUCTOR = -736011607;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestCallEmpty extends Function
    {

        public TestCallEmpty()
        {
        }

        public static final int CONSTRUCTOR = -627291626;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestCallString extends Function
    {
        public String x;

        public TestCallString()
        {
        }

        public TestCallString(String x)
        {
            this.x = x;
        }

        public static final int CONSTRUCTOR = -1732818385;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestCallVectorInt extends Function
    {
        public int[] x;

        public TestCallVectorInt()
        {
        }

        public TestCallVectorInt(int[] x)
        {
            this.x = x;
        }

        public static final int CONSTRUCTOR = -2137277793;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestCallVectorIntObject extends Function
    {
        public TestInt[] x;

        public TestCallVectorIntObject()
        {
        }

        public TestCallVectorIntObject(TestInt[] x)
        {
            this.x = x;
        }

        public static final int CONSTRUCTOR = 1825428218;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestCallVectorString extends Function
    {
        public String[] x;

        public TestCallVectorString()
        {
        }

        public TestCallVectorString(String[] x)
        {
            this.x = x;
        }

        public static final int CONSTRUCTOR = -408600900;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestCallVectorStringObject extends Function
    {
        public TestString[] x;

        public TestCallVectorStringObject()
        {
        }

        public TestCallVectorStringObject(TestString[] x)
        {
            this.x = x;
        }

        public static final int CONSTRUCTOR = 1527666429;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestGetDifference extends Function
    {

        public TestGetDifference()
        {
        }

        public static final int CONSTRUCTOR = 1747084069;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestNetwork extends Function
    {

        public TestNetwork()
        {
        }

        public static final int CONSTRUCTOR = -1343998901;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestProxy extends Function
    {
        public String server;
        public int port;
        public ProxyType type;
        public int dcId;
        public double timeout;

        public TestProxy()
        {
        }

        public TestProxy(String server, int port, ProxyType type, int dcId, double timeout)
        {
            this.server = server;
            this.port = port;
            this.type = type;
            this.dcId = dcId;
            this.timeout = timeout;
        }

        public static final int CONSTRUCTOR = -1197366626;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestReturnError extends Function
    {
        public Error error;

        public TestReturnError()
        {
        }

        public TestReturnError(Error error)
        {
            this.error = error;
        }

        public static final int CONSTRUCTOR = 455179506;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestSquareInt extends Function
    {
        public int x;

        public TestSquareInt()
        {
        }

        public TestSquareInt(int x)
        {
            this.x = x;
        }

        public static final int CONSTRUCTOR = -60135024;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TestUseUpdate extends Function
    {

        public TestUseUpdate()
        {
        }

        public static final int CONSTRUCTOR = 717094686;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleChatDefaultDisableNotification extends Function
    {
        public long chatId;
        public boolean defaultDisableNotification;

        public ToggleChatDefaultDisableNotification()
        {
        }

        public ToggleChatDefaultDisableNotification(long chatId, boolean defaultDisableNotification)
        {
            this.chatId = chatId;
            this.defaultDisableNotification = defaultDisableNotification;
        }

        public static final int CONSTRUCTOR = 314794002;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleChatHasProtectedContent extends Function
    {
        public long chatId;
        public boolean hasProtectedContent;

        public ToggleChatHasProtectedContent()
        {
        }

        public ToggleChatHasProtectedContent(long chatId, boolean hasProtectedContent)
        {
            this.chatId = chatId;
            this.hasProtectedContent = hasProtectedContent;
        }

        public static final int CONSTRUCTOR = 975231309;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleChatIsMarkedAsUnread extends Function
    {
        public long chatId;
        public boolean isMarkedAsUnread;

        public ToggleChatIsMarkedAsUnread()
        {
        }

        public ToggleChatIsMarkedAsUnread(long chatId, boolean isMarkedAsUnread)
        {
            this.chatId = chatId;
            this.isMarkedAsUnread = isMarkedAsUnread;
        }

        public static final int CONSTRUCTOR = -986129697;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleChatIsPinned extends Function
    {
        public ChatList chatList;
        public long chatId;
        public boolean isPinned;

        public ToggleChatIsPinned()
        {
        }

        public ToggleChatIsPinned(ChatList chatList, long chatId, boolean isPinned)
        {
            this.chatList = chatList;
            this.chatId = chatId;
            this.isPinned = isPinned;
        }

        public static final int CONSTRUCTOR = -1485429186;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleGroupCallEnabledStartNotification extends Function
    {
        public int groupCallId;
        public boolean enabledStartNotification;

        public ToggleGroupCallEnabledStartNotification()
        {
        }

        public ToggleGroupCallEnabledStartNotification(int groupCallId,
                boolean enabledStartNotification)
        {
            this.groupCallId = groupCallId;
            this.enabledStartNotification = enabledStartNotification;
        }

        public static final int CONSTRUCTOR = 707839826;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleGroupCallIsMyVideoEnabled extends Function
    {
        public int groupCallId;
        public boolean isMyVideoEnabled;

        public ToggleGroupCallIsMyVideoEnabled()
        {
        }

        public ToggleGroupCallIsMyVideoEnabled(int groupCallId, boolean isMyVideoEnabled)
        {
            this.groupCallId = groupCallId;
            this.isMyVideoEnabled = isMyVideoEnabled;
        }

        public static final int CONSTRUCTOR = -1624289030;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleGroupCallIsMyVideoPaused extends Function
    {
        public int groupCallId;
        public boolean isMyVideoPaused;

        public ToggleGroupCallIsMyVideoPaused()
        {
        }

        public ToggleGroupCallIsMyVideoPaused(int groupCallId, boolean isMyVideoPaused)
        {
            this.groupCallId = groupCallId;
            this.isMyVideoPaused = isMyVideoPaused;
        }

        public static final int CONSTRUCTOR = -478875239;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleGroupCallMuteNewParticipants extends Function
    {
        public int groupCallId;
        public boolean muteNewParticipants;

        public ToggleGroupCallMuteNewParticipants()
        {
        }

        public ToggleGroupCallMuteNewParticipants(int groupCallId, boolean muteNewParticipants)
        {
            this.groupCallId = groupCallId;
            this.muteNewParticipants = muteNewParticipants;
        }

        public static final int CONSTRUCTOR = 284082626;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleGroupCallParticipantIsHandRaised extends Function
    {
        public int groupCallId;
        public MessageSender participantId;
        public boolean isHandRaised;

        public ToggleGroupCallParticipantIsHandRaised()
        {
        }

        public ToggleGroupCallParticipantIsHandRaised(int groupCallId, MessageSender participantId,
                boolean isHandRaised)
        {
            this.groupCallId = groupCallId;
            this.participantId = participantId;
            this.isHandRaised = isHandRaised;
        }

        public static final int CONSTRUCTOR = -1896127519;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleGroupCallParticipantIsMuted extends Function
    {
        public int groupCallId;
        public MessageSender participantId;
        public boolean isMuted;

        public ToggleGroupCallParticipantIsMuted()
        {
        }

        public ToggleGroupCallParticipantIsMuted(int groupCallId, MessageSender participantId,
                boolean isMuted)
        {
            this.groupCallId = groupCallId;
            this.participantId = participantId;
            this.isMuted = isMuted;
        }

        public static final int CONSTRUCTOR = -1308093433;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleGroupCallScreenSharingIsPaused extends Function
    {
        public int groupCallId;
        public boolean isPaused;

        public ToggleGroupCallScreenSharingIsPaused()
        {
        }

        public ToggleGroupCallScreenSharingIsPaused(int groupCallId, boolean isPaused)
        {
            this.groupCallId = groupCallId;
            this.isPaused = isPaused;
        }

        public static final int CONSTRUCTOR = -1602530464;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleMessageSenderIsBlocked extends Function
    {
        public MessageSender senderId;
        public boolean isBlocked;

        public ToggleMessageSenderIsBlocked()
        {
        }

        public ToggleMessageSenderIsBlocked(MessageSender senderId, boolean isBlocked)
        {
            this.senderId = senderId;
            this.isBlocked = isBlocked;
        }

        public static final int CONSTRUCTOR = -2008084779;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleSessionCanAcceptCalls extends Function
    {
        public long sessionId;
        public boolean canAcceptCalls;

        public ToggleSessionCanAcceptCalls()
        {
        }

        public ToggleSessionCanAcceptCalls(long sessionId, boolean canAcceptCalls)
        {
            this.sessionId = sessionId;
            this.canAcceptCalls = canAcceptCalls;
        }

        public static final int CONSTRUCTOR = 1819027208;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleSessionCanAcceptSecretChats extends Function
    {
        public long sessionId;
        public boolean canAcceptSecretChats;

        public ToggleSessionCanAcceptSecretChats()
        {
        }

        public ToggleSessionCanAcceptSecretChats(long sessionId, boolean canAcceptSecretChats)
        {
            this.sessionId = sessionId;
            this.canAcceptSecretChats = canAcceptSecretChats;
        }

        public static final int CONSTRUCTOR = 1000843390;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleSupergroupIsAllHistoryAvailable extends Function
    {
        public long supergroupId;
        public boolean isAllHistoryAvailable;

        public ToggleSupergroupIsAllHistoryAvailable()
        {
        }

        public ToggleSupergroupIsAllHistoryAvailable(long supergroupId,
                boolean isAllHistoryAvailable)
        {
            this.supergroupId = supergroupId;
            this.isAllHistoryAvailable = isAllHistoryAvailable;
        }

        public static final int CONSTRUCTOR = 1155110478;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleSupergroupIsBroadcastGroup extends Function
    {
        public long supergroupId;

        public ToggleSupergroupIsBroadcastGroup()
        {
        }

        public ToggleSupergroupIsBroadcastGroup(long supergroupId)
        {
            this.supergroupId = supergroupId;
        }

        public static final int CONSTRUCTOR = 884089365;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ToggleSupergroupSignMessages extends Function
    {
        public long supergroupId;
        public boolean signMessages;

        public ToggleSupergroupSignMessages()
        {
        }

        public ToggleSupergroupSignMessages(long supergroupId, boolean signMessages)
        {
            this.supergroupId = supergroupId;
            this.signMessages = signMessages;
        }

        public static final int CONSTRUCTOR = 1156568356;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class TransferChatOwnership extends Function
    {
        public long chatId;
        public long userId;
        public String password;

        public TransferChatOwnership()
        {
        }

        public TransferChatOwnership(long chatId, long userId, String password)
        {
            this.chatId = chatId;
            this.userId = userId;
            this.password = password;
        }

        public static final int CONSTRUCTOR = 2006977043;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UnpinAllChatMessages extends Function
    {
        public long chatId;

        public UnpinAllChatMessages()
        {
        }

        public UnpinAllChatMessages(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = -1437805385;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UnpinChatMessage extends Function
    {
        public long chatId;
        public long messageId;

        public UnpinChatMessage()
        {
        }

        public UnpinChatMessage(long chatId, long messageId)
        {
            this.chatId = chatId;
            this.messageId = messageId;
        }

        public static final int CONSTRUCTOR = 2065448670;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UpgradeBasicGroupChatToSupergroupChat extends Function
    {
        public long chatId;

        public UpgradeBasicGroupChatToSupergroupChat()
        {
        }

        public UpgradeBasicGroupChatToSupergroupChat(long chatId)
        {
            this.chatId = chatId;
        }

        public static final int CONSTRUCTOR = 300488122;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UploadFile extends Function
    {
        public InputFile file;
        public FileType fileType;
        public int priority;

        public UploadFile()
        {
        }

        public UploadFile(InputFile file, FileType fileType, int priority)
        {
            this.file = file;
            this.fileType = fileType;
            this.priority = priority;
        }

        public static final int CONSTRUCTOR = -745597786;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class UploadStickerFile extends Function
    {
        public long userId;
        public InputSticker sticker;

        public UploadStickerFile()
        {
        }

        public UploadStickerFile(long userId, InputSticker sticker)
        {
            this.userId = userId;
            this.sticker = sticker;
        }

        public static final int CONSTRUCTOR = 597751182;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ValidateOrderInfo extends Function
    {
        public long chatId;
        public long messageId;
        public OrderInfo orderInfo;
        public boolean allowSave;

        public ValidateOrderInfo()
        {
        }

        public ValidateOrderInfo(long chatId, long messageId, OrderInfo orderInfo,
                boolean allowSave)
        {
            this.chatId = chatId;
            this.messageId = messageId;
            this.orderInfo = orderInfo;
            this.allowSave = allowSave;
        }

        public static final int CONSTRUCTOR = 9480644;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ViewMessages extends Function
    {
        public long chatId;
        public long messageThreadId;
        public long[] messageIds;
        public boolean forceRead;

        public ViewMessages()
        {
        }

        public ViewMessages(long chatId, long messageThreadId, long[] messageIds, boolean forceRead)
        {
            this.chatId = chatId;
            this.messageThreadId = messageThreadId;
            this.messageIds = messageIds;
            this.forceRead = forceRead;
        }

        public static final int CONSTRUCTOR = -1155961496;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class ViewTrendingStickerSets extends Function
    {
        public long[] stickerSetIds;

        public ViewTrendingStickerSets()
        {
        }

        public ViewTrendingStickerSets(long[] stickerSetIds)
        {
            this.stickerSetIds = stickerSetIds;
        }

        public static final int CONSTRUCTOR = -952416520;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

    public static class WriteGeneratedFilePart extends Function
    {
        public long generationId;
        public int offset;
        public byte[] data;

        public WriteGeneratedFilePart()
        {
        }

        public WriteGeneratedFilePart(long generationId, int offset, byte[] data)
        {
            this.generationId = generationId;
            this.offset = offset;
            this.data = data;
        }

        public static final int CONSTRUCTOR = -2062358189;

        @Override
        public int getConstructor()
        {
            return CONSTRUCTOR;
        }
    }

}
