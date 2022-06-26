package com.eugene_andrienko.telepodcast;

import java.util.LinkedList;
import java.util.List;
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

        result = TextHelper.splitByWords(null, 0);
        assertNull(result, "Result should be null");

        List<String> expectedResultWholeString = new LinkedList<>();
        expectedResultWholeString.add(testString);
        result = TextHelper.splitByWords(testString, testString.length());
        assertNotNull(result, "Result should not be null");
        assertLinesMatch(expectedResultWholeString, result, "Split result unexpected");
    }
}
