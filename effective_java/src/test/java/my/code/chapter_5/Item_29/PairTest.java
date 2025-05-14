package my.code.chapter_5.Item_29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTest {

    @Test
    void testGetKeyValue() {
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        assertEquals("Age", pair.getKey());
        assertEquals(30, pair.getValue());
    }

    @Test
    void testSwap() {
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        Pair<Integer, String> swapped = pair.swap();

        assertEquals(30, swapped.getKey());
        assertEquals("Age", swapped.getValue());
    }

    @Test
    void testWithDifferentTypes() {
        Pair<Double, Boolean> pair = new Pair<>(3.14, true);
        assertEquals(3.14, pair.getKey());
        assertTrue(pair.getValue());
    }
}