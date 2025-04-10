package my.code.chapter2.singleton_or_enum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemLoggerTest {

    @BeforeEach
    void setUp() {
        SystemLogger.INSTANCE.clear(); // чистимо перед кожним тестом
    }

    @Test
    @DisplayName("1️ Один екземпляр логера")
    void singletonTest() {
        var logger1 = SystemLogger.INSTANCE;
        var logger2 = SystemLogger.INSTANCE;

        assertSame(logger1, logger2);
    }

    @Test
    @DisplayName("2️ Логування повідомлень")
    void logMessageTest() {
        SystemLogger.INSTANCE.log("Перший запис");
        SystemLogger.INSTANCE.log("Другий запис");

        var logs = SystemLogger.INSTANCE.getLogs();
        assertEquals(2, logs.size());
        assertEquals("Перший запис", logs.get(0));
    }

    @Test
    @DisplayName("3️ Очистка логів")
    void clearLogsTest() {
        SystemLogger.INSTANCE.log("Я щось написав");
        SystemLogger.INSTANCE.clear();

        assertTrue(SystemLogger.INSTANCE.getLogs().isEmpty());
    }

}