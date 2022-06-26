package com.eugene_andrienko.telepodcast;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TextHelper
{
    private static final Logger logger = LoggerFactory.getLogger(TextHelper.class);

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
            logger.error("Got null as string to split — returning null");
            return null;
        }

        List<String> result = new LinkedList<>();

        if(subStringSize <= 0)
        {
            logger.error("Got {} as substring size - returning empty list", subStringSize);
            return result;
        }

        if(string.length() <= subStringSize)
        {
            logger.warn("Nothing to split. String length: {}, substring size: {}",
                    string.length(), subStringSize);
            result.add(string);
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
                    logger.warn("Fail to split string by words — no previous space character in " +
                                "buffer — splitting by size");
                    logger.debug("Substring size: {}, last character: {}, previous space index " +
                                 "in string: {}", sb.length(), Character.toChars(codePoint),
                            previousSpaceIndex);
                }
                result.add(sb.toString());
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
}
