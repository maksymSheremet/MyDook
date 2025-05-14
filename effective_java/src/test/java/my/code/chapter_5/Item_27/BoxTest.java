package my.code.chapter_5.Item_27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    @Test
    void testBoxWithString() {
        String[] data = {"apple", "banana"};
        Box<String> box = Box.fromArray(data);
        assertEquals("apple", box.get());
    }

    @Test
    void testBoxWithInteger() {
        Integer[] data = {10, 20, 30};
        Box<Integer> box = Box.fromArray(data);
        assertEquals(10, box.get());
    }

    @Test
    void testEmptyArrayThrows() {
        Object[] data = {};
        assertThrows(IllegalArgumentException.class, () -> Box.fromArray(data));
    }
}