package my.code.chapter_5.Item_26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SafeListTest {
    @Test
    void testAddAndGetString() {
        SafeList<String> list = new SafeList<>();
        list.add("Hello");
        list.add("World");

        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
    }

    @Test
    void testAddAndGetInteger() {
        SafeList<Integer> list = new SafeList<>();
        list.add(10);
        list.add(20);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void testSize() {
        SafeList<String> list = new SafeList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals(3, list.size());
    }
}