package my.code.chapter_5.Item_28;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinerTest {

    @Test
    void testCombineArrays() {
        String[] a1 = {"A", "B"};
        String[] a2 = {"C", "D"};
        List<String> result = Combiner.combine(a1, a2);
        assertEquals(List.of("A", "B", "C", "D"), result);
    }

    @Test
    void testCombineLists() {
        List<String> l1 = List.of("One", "Two");
        List<String> l2 = List.of("Three");
        List<String> result = Combiner.combineLists(l1, l2);
        assertEquals(List.of("One", "Two", "Three"), result);
    }

    @Test
    void testCombineDifferentTypes() {
        Integer[] i1 = {1, 2};
        Integer[] i2 = {3};
        List<Integer> result = Combiner.combine(i1, i2);
        assertEquals(List.of(1, 2, 3), result);
    }
}