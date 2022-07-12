package com.eugene_andrienko.telepodcast.helpers;

import com.eugene_andrienko.telepodcast.helpers.GarbageTextRemover.ParType;
import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GarbageTextRemoverTest
{
    @Test
    @DisplayName("Spit to paragraphs test")
    void splitToParagraphsTest()
    {
        String testString = "Line 1\n" +
                            "Line 2\n" +
                            "\n" +
                            "Line 3\n" +
                            "      \n" +
                            "Line 4";
        List<String> expectedResult = Arrays.asList("Line 1", "Line 2", "Line 3", "Line 4");
        List<String> result = GarbageTextRemover.splitToParagraphs(testString);
        assertIterableEquals(expectedResult, result, "Not expected paragraphs list");

        testString = "Test string\n";
        expectedResult = List.of("Test string");
        result = GarbageTextRemover.splitToParagraphs(testString);
        assertIterableEquals(expectedResult, result, "Not expected paragraphs list");

        testString = "Test string";
        result = GarbageTextRemover.splitToParagraphs(testString);
        assertIterableEquals(expectedResult, result, "Not expected paragraphs list");

        testString = "";
        result = GarbageTextRemover.splitToParagraphs(testString);
        expectedResult = Collections.emptyList();
        assertIterableEquals(expectedResult, result, "Not expected paragraphs list");

        testString = null;
        result = GarbageTextRemover.splitToParagraphs(testString);
        assertIterableEquals(expectedResult, result, "Not expected paragraphs list");
    }

    @Test
    @DisplayName("Test for parse paragraphs")
    void parseParagraphsTest()
    {
        List<String> testParagraphs = Arrays.asList("Text", "01:00 - timecode", "😀😚😴",
                "ДАННОЕ СООБЩЕНИЕ (МАТЕРИАЛ) СОЗДАНО", "#hashtag", "http://marketing.bullshit");
        LinkedHashMap<String, ParType> result = GarbageTextRemover.parseParagraphs(testParagraphs);
        assertEquals(6, testParagraphs.size());
        for(Map.Entry<String, ParType> i : result.entrySet())
        {
            ParType expectedParType;
            switch(i.getKey())
            {
                case "Text":
                    expectedParType = ParType.NORMAL_TEXT;
                    break;
                case "01:00 - timecode":
                    expectedParType = ParType.TIMECODES;
                    break;
                case "😀😚😴":
                    expectedParType = ParType.EMOJIS;
                    break;
                case "ДАННОЕ СООБЩЕНИЕ (МАТЕРИАЛ) СОЗДАНО":
                    expectedParType = ParType.ROSKOM_SHIT;
                    break;
                case "#hashtag":
                    expectedParType = ParType.HASHTAGS;
                    break;
                case "http://marketing.bullshit":
                    expectedParType = ParType.MARKETING;
                    break;
                default:
                    fail("Not expected paragraph type!");
                    // For compiler, never reach this:
                    return;
            }
            assertEquals(expectedParType, i.getValue());
        }
    }

    @Test
    @DisplayName("Test for emojis in text")
    void containsEmojisTest()
    {
        String[] emojis = new String[]{"🍔test string",
                                       "test string💻",
                                       "🚈test string8⃣",
                                       "test🔗string"};
        String plainText = "Plain text";
        boolean result;

        for(String s : emojis)
        {
            result = GarbageTextRemover.containsEmojis(s);
            assertTrue(result, "String should contain emoji(s)");
        }
        result = GarbageTextRemover.containsEmojis(plainText);
        assertFalse(result, "String should not contain emojis");
    }

    @Test
    @DisplayName("Test for shit in text")
    void containsShitTest()
    {
        String s1 = "Normal text\n\n" +
                    "ДАННОЕ СООБЩЕНИЕ (МАТЕРИАЛ) СОЗДАНО И (ИЛИ) РАСПРОСТРАНЕНО ИНОСТРАННЫМ " +
                    "СРЕДСТВОМ МАССОВОЙ ИНФОРМАЦИИ, ВЫПОЛНЯЮЩИМ ФУНКЦИИ ИНОСТРАННОГО АГЕНТА, И " +
                    "(ИЛИ) РОССИЙСКИМ ЮРИДИЧЕСКИМ ЛИЦОМ, ВЫПОЛНЯЮЩИМ ФУНКЦИИ ИНОСТРАННОГО АГЕНТА." +
                    "\nNormal text #2.";
        String s2 = "Usual text";
        boolean result = GarbageTextRemover.containsShit(s1);
        assertTrue(result, "This text should contains shit");
        result = GarbageTextRemover.containsShit(s2);
        assertFalse(result, "This text should not contains shit");
    }

    @Test
    @DisplayName("Test for hashtag in text")
    void containsHashtagTest()
    {
        String oneHashTag = "Test\nTest #hashtag\nTest";
        String twoHashTags = "Test\n#hashtag\nTest #test\nTest";
        String moreHashTags = "\n######\n####\n";
        String noHashTags = "\nTest\nTest\n";

        boolean result = GarbageTextRemover.containsHashtag(oneHashTag);
        assertTrue(result, "Hashtag should be found");
        result = GarbageTextRemover.containsHashtag(twoHashTags);
        assertTrue(result, "Hashtags should be found");
        result = GarbageTextRemover.containsHashtag(moreHashTags);
        assertTrue(result, "Hashtags should be found");
        result = GarbageTextRemover.containsHashtag(noHashTags);
        assertFalse(result, "Hashtags should not be found");
    }

    @Test
    @DisplayName("Test for marketing bullshit in text")
    void containsMarketingTest()
    {
        String[] marketingShit = new String[]{"Marketing text http://marketing.bullshit text",
                                              "Marketing text https://marketing.bullshit text",
                                              "Скидки по коду 123",
                                              "Код 123 для скидок",
                                              "Промокод 123",
                                              "Бесплатные промокоды"};
        String usualText = "Usual text";
        boolean result;

        for(String s : marketingShit)
        {
            result = GarbageTextRemover.containsMarketing(s);
            assertTrue(result, String.format("Text \"%s\" should filtered as marketing text", s));
        }
        result = GarbageTextRemover.containsMarketing(usualText);
        assertFalse(result, "Text should not filtered as marketing text");
    }

    @Test
    @DisplayName("Test filtering paragraphs")
    void filterParagraphsTest()
    {
        LinkedHashMap<String, ParType> paragraphsForTest = new LinkedHashMap<>();
        paragraphsForTest.put("Text", ParType.NORMAL_TEXT);
        paragraphsForTest.put("01:00 - timecode", ParType.TIMECODES);
        paragraphsForTest.put("😀😚😴", ParType.EMOJIS);
        paragraphsForTest.put("ДАННОЕ СООБЩЕНИЕ (МАТЕРИАЛ) СОЗДАНО", ParType.ROSKOM_SHIT);
        paragraphsForTest.put("#hashtag", ParType.HASHTAGS);
        paragraphsForTest.put("http://marketing.bullshit", ParType.MARKETING);

        List<String> result = GarbageTextRemover.filterParagraphs(paragraphsForTest);
        assertEquals(2, result.size(), "Should have 2 resulting paragraphs");
        assertEquals("Text", result.get(0), "First paragraph should contains normal text");
        assertEquals("01:00 - timecode", result.get(1), "Second paragraph should contains " +
                                                        "timecodes");
    }
}
