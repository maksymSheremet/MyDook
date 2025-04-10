package my.code.chapter2.singleton_or_enum;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccessManagerTest {

    @BeforeEach
    void reset() {
        AccessManager.INSTANCE.clear();
    }

    @Test
    @Order(1)
    @DisplayName("1️ Авторизація користувача")
    void testAuthorization() {
        AccessManager.INSTANCE.authorize("admin");
        assertTrue(AccessManager.INSTANCE.isAuthorized("admin"));
    }

    @Test
    @Order(2)
    @DisplayName("2️ Неавторизований користувач")
    void testUnauthorized() {
        assertFalse(AccessManager.INSTANCE.isAuthorized("guest"));
    }

    @Test
    @Order(3)
    @DisplayName("3️ Очищення списку")
    void testClear() {
        AccessManager.INSTANCE.authorize("admin");
        AccessManager.INSTANCE.clear();
        assertFalse(AccessManager.INSTANCE.isAuthorized("admin"));
    }

    @Test
    @Order(4)
    @DisplayName("4️ Сінглтон – один екземпляр")
    void testSingletonInstance() {
        var one = AccessManager.INSTANCE;
        var two = AccessManager.INSTANCE;
        assertSame(one, two);
    }
}