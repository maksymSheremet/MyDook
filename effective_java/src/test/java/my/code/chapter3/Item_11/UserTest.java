package my.code.chapter3.Item_11;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserEquality() {
        User u1 = new User("Oleh");
        User u2 = new User("Oleh");

        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void testUserInHashSet() {
        Set<User> set = new HashSet<>();
        set.add(new User("Oleh"));

        assert set.contains(new User("Oleh"));
    }

    @Test
    void testDifferentUser() {
        User u1 = new User("Oleh");
        User u2 = new User("Dima");

        assertNotEquals(u1, u2);
    }

}