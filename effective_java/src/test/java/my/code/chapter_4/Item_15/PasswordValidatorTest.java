package my.code.chapter_4.Item_15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void testStrongPassword() {
        assertTrue(PasswordValidator.isStrongPassword("Password1"));
    }

    @Test
    public void testTooShort() {
        assertFalse(PasswordValidator.isStrongPassword("Pas1"));
    }

    @Test
    public void testNoDigit() {
        assertFalse(PasswordValidator.isStrongPassword("Password"));
    }

    @Test
    public void testNoUpperCase() {
        assertFalse(PasswordValidator.isStrongPassword("password1"));
    }
}