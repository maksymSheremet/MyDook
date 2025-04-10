package my.code.chapter2.singleton_or_enum.center;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationCenterTest {

    @BeforeEach
    void reset() {
        NotificationCenter.INSTANCE.clear();
    }

    @Test
    @Order(1)
    @DisplayName("1️ Надсилання повідомлення з категорією")
    void testSendNotification() {
        NotificationCenter.INSTANCE.send("INFO", "Завантаження завершено ✅");
        var all = NotificationCenter.INSTANCE.getAll();
        assertEquals(1, all.size());
        assertEquals("INFO", all.get(0).getCategory());
    }

    @Test
    @Order(2)
    @DisplayName("2️ Отримання останнього повідомлення")
    void testGetLatest() {
        NotificationCenter.INSTANCE.send("WARNING", "Памʼять майже закінчилась!");
        Notification latest = NotificationCenter.INSTANCE.getLatest();
        assertNotNull(latest);
        assertEquals("WARNING", latest.getCategory());
    }

    @Test
    @Order(3)
    @DisplayName("3️ Фільтрація по категорії")
    void testGetByCategory() {
        NotificationCenter.INSTANCE.send("ERROR", "Фатальна помилка 😱");
        NotificationCenter.INSTANCE.send("INFO", "Система в порядку");
        List<Notification> errors = NotificationCenter.INSTANCE.getByCategory("ERROR");
        assertEquals(1, errors.size());
        assertTrue(errors.get(0).getMessage().contains("Фатальна"));
    }

    @Test
    @Order(4)
    @DisplayName("4️ Очищення всіх повідомлень")
    void testClear() {
        NotificationCenter.INSTANCE.send("DEBUG", "Щось сталося...");
        NotificationCenter.INSTANCE.clear();
        assertTrue(NotificationCenter.INSTANCE.getAll().isEmpty());
    }

    @Test
    @Order(5)
    @DisplayName("5️ Сінглтон перевірка")
    void testSingletonInstance() {
        var one = NotificationCenter.INSTANCE;
        var two = NotificationCenter.INSTANCE;
        assertSame(one, two);
    }
}
