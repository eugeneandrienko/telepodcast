package com.eugene_andrienko.telepodcast.helpers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class SimpleTextHelper
{
    /**
     * Split given string to {@code subStringSize} sized chunks taking words to account.
     *
     * @param string        String to split
     * @param subStringSize Size of chunk
     *
     * @return List of substrings, split by words. Substring can be less than {@code
     * subStringSize}. If string cannot be splitted by words — it will be simply splitted by
     * given {@code subStringSize}.
     */
    public static List<String> splitByWords(String string, int subStringSize)
    {
        if(string == null)
        {
            log.error("Got null as string to split — returning null");
            return null;
        }

        List<String> result = new LinkedList<>();

        if(subStringSize <= 0)
        {
            log.error("Got {} as substring size - returning empty list", subStringSize);
            return result;
        }

        if(string.length() <= subStringSize)
        {
            log.warn("Nothing to split. String length: {}, substring size: {}",
                    string.length(), subStringSize);
            if(string.length() > 0)
            {
                result.add(string);
            }
            return result;
        }

        int[] codePoints = string.codePoints().toArray();
        StringBuilder sb = new StringBuilder();
        int previousSpaceIndex = 0;
        List<Integer> spaceCodePoints = Arrays.asList(
                " ".codePointAt(0), "\t".codePointAt(0), "\n".codePointAt(0));

        for(int i = 0; i < codePoints.length; i++)
        {
            int codePoint = codePoints[i];
            boolean spaceAtIndex = spaceCodePoints.contains(codePoint);
            if(spaceAtIndex)
            {
                previousSpaceIndex = i;
            }

            sb.appendCodePoint(codePoint);

            if(sb.length() >= subStringSize)
            {
                int lastFoundSpaceIndex;
                if(spaceAtIndex)
                {
                    lastFoundSpaceIndex = sb.length() - 1;
                }
                else
                {
                    // Space index inside sb:
                    lastFoundSpaceIndex = sb.length() - i + previousSpaceIndex - 1;
                }
                if(lastFoundSpaceIndex > 0)
                {
                    sb.delete(lastFoundSpaceIndex, sb.length());
                    i = previousSpaceIndex;
                }
                else
                {
                    log.warn("Fail to split string by words — no previous space character in " +
                             "buffer — splitting by size");
                    log.debug("Substring size: {}, last character: {}, previous space index " +
                              "in string: {}", sb.length(), Character.toChars(codePoint),
                            previousSpaceIndex);
                }
                if(sb.length() > 0)
                {
                    result.add(sb.toString());
                }
                sb.setLength(0);
            }
        }

        // Something left in buffer after splitting:
        if(sb.length() > 0)
        {
            result.add(sb.toString());
        }

        return result;
    }

    /**
     * Removes invalid URLs from given set
     *
     * @param urls Input URLs
     *
     * @return Processed set of valid URLs
     */
    public static Set<String> removeInvalidUrls(Set<String> urls)
    {
        Set<String> result = new HashSet<>();

        if(urls == null)
        {
            return result;
        }

        Pattern pattern = Pattern.compile("https://www.youtube.com/watch\\?v=[-\\w_]+");
        for(String url : urls)
        {
            Matcher matcher = pattern.matcher(url);
            boolean isNotYouTubeLink = !matcher.matches();
            if(isNotYouTubeLink)
            {
                log.warn("{} is not an YouTube link! Skipping...", url);
                continue;
            }
            result.add(url);
        }

        return result;
    }

    /**
     * Is given string contains time code.
     *
     * @param string String to check for time code.
     *
     * @return {@code True} if time code in string, otherwise {@code false}.
     */
    public static boolean containsTimeCode(String string)
    {
        Pattern wrongPattern = Pattern.compile(".*\\d{3}+:\\d{2} ?[-—]?.*", Pattern.DOTALL);
        Matcher matcher = wrongPattern.matcher(string);
        if(matcher.matches())
        {
            return false;
        }

        wrongPattern = Pattern.compile(".*\\d{3}+:\\d{2}:\\d{2} ?[-—]?.*", Pattern.DOTALL);
        matcher = wrongPattern.matcher(string);
        if(matcher.matches())
        {
            return false;
        }

        Pattern pattern = Pattern.compile(".*\\d{2}:\\d{2} ?[-—]?.*", Pattern.DOTALL);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
