package com.eugene_andrienko.telepodcast.helpers;

import com.vdurmont.emoji.EmojiParser;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;


/**
 * Removes garbage text from YouTube video description.
 */
@Slf4j
public class GarbageTextRemover
{
    /**
     * Removes garbage text from given string with description from YouTube.
     *
     * @param text Original text.
     *
     * @return Cleaned text.
     */
    public static String removeGarbageText(String text)
    {
        return String.join("\n", filterParagraphs(parseParagraphs(splitToParagraphs(text))));
    }

    /**
     * Split given text to paragraphs.
     *
     * @param text Original text.
     *
     * @return List of paragraphs.
     */
    static List<String> splitToParagraphs(String text)
    {
        if(text == null)
        {
            log.error("Got null text for splitting to paragraphs");
            return Collections.emptyList();
        }
        String[] result = text.split("\n");
        return Arrays.stream(result).filter(i -> !i.isBlank()).collect(Collectors.toList());
    }

    /**
     * Types of parsed paragraphs.
     */
    enum ParType
    {
        NORMAL_TEXT,
        TIMECODES,
        EMOJIS,
        ROSKOM_SHIT,
        HASHTAGS,
        MARKETING
    }

    /**
     * Parse paragraphs to get its type.
     *
     * @param paragraphs List of paragraphs.
     *
     * @return Map with paragraph's text as key and type of paragraph as value.
     */
    static LinkedHashMap<String, ParType> parseParagraphs(List<String> paragraphs)
    {
        LinkedHashMap<String, ParType> result = new LinkedHashMap<>();
        for(String par : paragraphs)
        {
            if(SimpleTextHelper.containsTimeCode(par))
            {
                result.put(par, ParType.TIMECODES);
            }
            else if(containsEmojis(par))
            {
                result.put(par, ParType.EMOJIS);
            }
            else if(containsShit(par))
            {
                result.put(par, ParType.ROSKOM_SHIT);
            }
            else if(containsHashtag(par))
            {
                result.put(par, ParType.HASHTAGS);
            }
            else if(containsMarketing(par))
            {
                result.put(par, ParType.MARKETING);
            }
            else
            {
                result.put(par, ParType.NORMAL_TEXT);
            }
        }
        return result;
    }

    /**
     * Is given string contains emojis.
     *
     * @param string String to check.
     *
     * @return {@code True} if contains, otherwise {@code false}.
     */
    static boolean containsEmojis(String string)
    {
        return !EmojiParser.extractEmojis(string).isEmpty();
    }

    /**
     * Is given string contains some shit.
     *
     * @param string String to check.
     *
     * @return {@code True} if contains, otherwise {@code false}.
     */
    static boolean containsShit(String string)
    {
        return string.contains("ДАННОЕ СООБЩЕНИЕ (МАТЕРИАЛ) СОЗДАНО");
    }

    /**
     * Is given string contains hashtag(s).
     *
     * @param string String to check.
     *
     * @return {@code True} if contains, otherwise {@code false}.
     */
    static boolean containsHashtag(String string)
    {
        return string.contains("#");
    }

    /**
     * Is given string contains some marketing bullshit.
     *
     * @param string String to check.
     *
     * @return {@code True} if contains, otherwise {@code false}.
     */
    static boolean containsMarketing(String string)
    {
        boolean containsLink = string.contains("https://") || string.contains("http://");

        String[] marketingRegexes = new String[]{"[Сс]кидо?к",
                                                 "[Пп]ромокод"};
        for(String regex : marketingRegexes)
        {
            Pattern pattern = Pattern.compile(".*" + regex + ".*");
            Matcher matcher = pattern.matcher(string);
            if(matcher.matches())
            {
                return true;
            }
        }

        return containsLink;
    }

    /**
     * Filter given map with parsed paragraphs.
     *
     * Removes any paragraphs, expect of {@code ParType.NORMAL_TEXT} and {@code ParType
     * .TIMECODES} types.
     *
     * @param parsedParagraphs Map with parsed paragraphs.
     *
     * @return List of filtered paragraphs.
     */
    static List<String> filterParagraphs(LinkedHashMap<String, ParType> parsedParagraphs)
    {
        List<String> result = new LinkedList<>();
        for(Map.Entry<String, ParType> parsed : parsedParagraphs.entrySet())
        {
            if(parsed.getValue() == ParType.NORMAL_TEXT || parsed.getValue() == ParType.TIMECODES)
            {
                result.add(parsed.getKey());
            }
        }
        return result;
    }
}
