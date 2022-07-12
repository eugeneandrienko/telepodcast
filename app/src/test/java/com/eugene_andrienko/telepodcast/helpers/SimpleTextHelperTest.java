package com.eugene_andrienko.telepodcast.helpers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SimpleTextHelperTest
{
    @Test
    @DisplayName("Test splitting by words")
    void splitByWordsTest()
    {
        String testString = "aaa bbb ccc ddd eee fff";
        List<String> result = SimpleTextHelper.splitByWords(testString, 5);
        List<String> expectedResult = new LinkedList<>();
        expectedResult.add("aaa");
        expectedResult.add("bbb");
        expectedResult.add("ccc");
        expectedResult.add("ddd");
        expectedResult.add("eee");
        expectedResult.add("fff");
        assertNotNull(result, "Result should not be null");
        assertLinesMatch(expectedResult, result, "Split result unexpected");

        result = SimpleTextHelper.splitByWords(testString, 1);
        assertNotNull(result, "Result should not be null");
        assertEquals(testString.length(), result.size());

        result = SimpleTextHelper.splitByWords(testString, 200);
        assertNotNull(result, "Result should not be null");
        assertEquals(testString, result.get(0));

        List<String> expectedResultEmpty = new LinkedList<>();
        result = SimpleTextHelper.splitByWords(testString, 0);
        assertLinesMatch(expectedResultEmpty, result, "Result should be empty");

        result = SimpleTextHelper.splitByWords(testString, -1);
        assertLinesMatch(expectedResultEmpty, result, "Result should be empty");

        result = SimpleTextHelper.splitByWords("", 5);
        assertLinesMatch(expectedResultEmpty, result, "Result should be empty");

        result = SimpleTextHelper.splitByWords(null, 0);
        assertNull(result, "Result should be null");

        List<String> expectedResultWholeString = new LinkedList<>();
        expectedResultWholeString.add(testString);
        result = SimpleTextHelper.splitByWords(testString, testString.length());
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

        Set<String> result = SimpleTextHelper.removeInvalidUrls(validUrls);
        assertEquals(4, result.size(), "Should be 4 valid URLs in set");

        validUrls.add("https://www.youtube.com/watch?v=aa3aa-b2][dd");
        result = SimpleTextHelper.removeInvalidUrls(validUrls);
        assertEquals(4, result.size(), "Should be 4 valid URLs in set");

        Set<String> emptySet = new HashSet<>();
        result = SimpleTextHelper.removeInvalidUrls(emptySet);
        assertTrue(result.isEmpty(), "Set should be empty");

        result = SimpleTextHelper.removeInvalidUrls(null);
        assertTrue(result.isEmpty(), "Set should be empty");
    }

    @Test
    @DisplayName("Is contains timecodes test")
    void containsTimeCodeTest()
    {
        String[] timecodes = new String[] {"Test\n01:23 test\nTest",
                                            "Test\n01:23-test\nTest",
                                            "Test\n01:23 -test\nTest",
                                            "Test\n01:23- test\nTest",
                                            "Test\n01:23 - test\nTest",
                                            "Test\n01:23—test\nTest",
                                            "Test\n01:23 —test\nTest",
                                            "Test\n01:23— test\nTest",
                                            "Test\n01:23 — test\nTest"};
        String[] noTimecodes = new String[] {"Test\nTest 2\n Test 3\n",
                                             "Test\n001:23 test\nTest",
                                             "Test\n001:23:45 test\nTest"};
        boolean result;
        for(String s : timecodes)
        {
            result = SimpleTextHelper.containsTimeCode(s);
            assertTrue(result, String.format("Time code should be found in %s", s));
        }
        for(String s : noTimecodes)
        {
            result = SimpleTextHelper.containsTimeCode(s);
            assertFalse(result, String.format("Time code should not be found in %s", s));
        }
    }
}
