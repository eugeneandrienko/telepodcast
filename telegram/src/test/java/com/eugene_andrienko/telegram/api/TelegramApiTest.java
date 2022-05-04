package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramAuthException;
import com.eugene_andrienko.telegram.impl.Telegram;
import java.lang.reflect.Field;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.MockedStatic;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.mockStatic;


public class TelegramApiTest
{
    @Test
    @DisplayName("Test TelegramApi constructor")
    void constructorTest()
    {
        try
        {
            new TelegramApi(1, "2", 3, true);
            new TelegramApi(1, "2", 3, false);
        }
        catch(TelegramAuthException ex)
        {
            fail("Constructor should not throw exception", ex);
        }

        assertThrows(TelegramAuthException.class, () -> new TelegramApi(0, "2", 3, true));
        assertThrows(TelegramAuthException.class, () -> new TelegramApi(1, null, 3, true));
        assertThrows(TelegramAuthException.class, () -> new TelegramApi(1, "", 3, true));
        assertThrows(TelegramAuthException.class, () -> new TelegramApi(1, " ", 3, true));
        assertThrows(TelegramAuthException.class, () -> new TelegramApi(1, "2", 0, true));
    }

    @Test
    @DisplayName("Test Telegram init during login")
    @SneakyThrows({TelegramAuthException.class, IllegalAccessException.class})
    void loginInitTest()
    {
        try(MockedStatic<Telegram> mockedTelegram = mockStatic(Telegram.class))
        {
            TelegramApi telegramApi = new TelegramApi(1, "2", 3, true);
            List<Field> fields = ReflectionUtils.findFields(TelegramApi.class,
                    (field -> "telegram".equals(field.getName())),
                    ReflectionUtils.HierarchyTraversalMode.TOP_DOWN);
            assumeTrue(fields.size() == 1, "Should be only one \"telegram\" field");
            Field telegram = fields.get(0);
            telegram.setAccessible(true);
            telegram.set(telegramApi, mockedTelegram);
        }
    }
}
