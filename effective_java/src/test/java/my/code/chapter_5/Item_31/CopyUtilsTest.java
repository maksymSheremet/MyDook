package my.code.chapter_5.Item_31;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CopyUtilsTest {

    @Test
    void testCopyStringsToObjects() {
        List<String> src = List.of("A", "B", "C");
        List<Object> dest = new ArrayList<>();
        CopyUtils.copy(src, dest);

        assertEquals(List.of("A", "B", "C"), dest);
    }

    @Test
    void testCopyIntegersToNumbers() {
        List<Integer> src = List.of(1, 2, 3);
        List<Number> dest = new ArrayList<>();
        CopyUtils.copy(src, dest);

        assertEquals(List.of(1, 2, 3), dest);
    }

    @Test
    void testCopyToSameType() {
        List<Double> src = List.of(1.1, 2.2);
        List<Double> dest = new ArrayList<>();
        CopyUtils.copy(src, dest);

        assertEquals(List.of(1.1, 2.2), dest);
    }
}