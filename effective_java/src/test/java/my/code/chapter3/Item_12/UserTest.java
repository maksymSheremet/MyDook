package my.code.chapter3.Item_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testToStringContainsNameAndEmail() {
        User user = new User("John", "john@example.com");
        String srt = user.toString();

        assertTrue(srt.contains("John"));
        assertTrue(srt.contains("john@example.com"));
        assertEquals("User{name='John', email='john@example.com'}", srt);
    }

    @Test
    void testToStringNotEmpty() {
        User user = new User("Dmytro", "dmytro@ukr.net");
        assertNotNull(user.toString());
        assertFalse(user.toString().isEmpty());
    }
}