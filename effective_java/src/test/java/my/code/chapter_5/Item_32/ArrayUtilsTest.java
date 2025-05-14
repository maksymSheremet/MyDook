package my.code.chapter_5.Item_32;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void testAsListWithStrings() {
        List<String> result = ArrayUtils.asList("a", "b", "c");
        assertEquals(List.of("a", "b", "c"), result);
    }

    @Test
    void testAsListWithIntegers() {
        List<Integer> result = ArrayUtils.asList(1, 2, 3, 4);
        assertEquals(List.of(1, 2, 3, 4), result);
    }

    @Test
    void testAsListEmpty() {
        List<Object> result = ArrayUtils.asList();
        assertTrue(result.isEmpty());
    }
}