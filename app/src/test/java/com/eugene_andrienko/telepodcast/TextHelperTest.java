package com.eugene_andrienko.telepodcast;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TextHelperTest
{
    @Test
    @DisplayName("Test splitting by words")
    void splitByWordsTest()
    {
        String testString = "aaa bbb ccc ddd eee fff";
        List<String> result = TextHelper.splitByWords(testString, 5);
        List<String> expectedResult = new LinkedList<>();
        expectedResult.add("aaa");
        expectedResult.add("bbb");
        expectedResult.add("ccc");
        expectedResult.add("ddd");
        expectedResult.add("eee");
        expectedResult.add("fff");
        assertNotNull(result, "Result should not be null");
        assertLinesMatch(expectedResult, result, "Split result unexpected");

        result = TextHelper.splitByWords(testString, 1);
        assertNotNull(result, "Result should not be null");
        assertEquals(testString.length(), result.size());

        result = TextHelper.splitByWords(testString, 200);
        assertNotNull(result, "Result should not be null");
        assertEquals(testString, result.get(0));

        List<String> expectedResultEmpty = new LinkedList<>();
        result = TextHelper.splitByWords(testString, 0);
        assertLinesMatch(expectedResultEmpty, result, "Result should be empty");

        result = TextHelper.splitByWords(testString, -1);
        assertLinesMatch(expectedResultEmpty, result, "Result should be empty");

        result = TextHelper.splitByWords("", 5);
        assertLinesMatch(expectedResultEmpty, result, "Result should be empty");

        result = TextHelper.splitByWords(null, 0);
        assertNull(result, "Result should be null");

        List<String> expectedResultWholeString = new LinkedList<>();
        expectedResultWholeString.add(testString);
        result = TextHelper.splitByWords(testString, testString.length());
        assertNotNull(result, "Result should not be null");
        assertLinesMatch(expectedResultWholeString, result, "Split result unexpected");
    }

    @Test
    @DisplayName("Test removing invalid YouTube URLs")
    void removeInvalidUrlsTest()
    {
        Set<String> validUrls = new HashSet<>();
        validUrls.add("https://www.youtube.com/watch?v=9licBcpBSU0");
        validUrls.add("https://www.youtube.com/watch?v=aaaa_bb2bb");
        validUrls.add("https://www.youtube.com/watch?v=aaaa-b1bbb");
        validUrls.add("https://www.youtube.com/watch?v=aa3aa-b2bbb_c3ccc");

        Set<String> result = TextHelper.removeInvalidUrls(validUrls);
        assertEquals(4, result.size(), "Should be 4 valid URLs in set");

        validUrls.add("https://www.youtube.com/watch?v=aa3aa-b2][dd");
        result = TextHelper.removeInvalidUrls(validUrls);
        assertEquals(4, result.size(), "Should be 4 valid URLs in set");

        Set<String> emptySet = new HashSet<>();
        result = TextHelper.removeInvalidUrls(emptySet);
        assertTrue(result.isEmpty(), "Set should be empty");

        result = TextHelper.removeInvalidUrls(null);
        assertTrue(result.isEmpty(), "Set should be empty");
    }
}
