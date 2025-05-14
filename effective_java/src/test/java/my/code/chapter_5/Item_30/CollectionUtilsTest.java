package my.code.chapter_5.Item_30;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {

    @Test
    void testGetLastWithStrings() {
        List<String> words = List.of("Java", "Python", "Kotlin");
        String last = CollectionUtils.getLast(words);
        assertEquals("Kotlin", last);
    }

    @Test
    void testGetLastWithIntegers() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        Integer last = CollectionUtils.getLast(numbers);
        assertEquals(4, last);
    }

    @Test
    void testGetLastThrowsOnEmptyList() {
        List<String> empty = List.of();
        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.getLast(empty));
    }
}