package my.code.chapter_4.Item_18;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentedListTest {

    @Test
    public void testSingleAdd() {
        InstrumentedList<String> list = new InstrumentedList<>(new ArrayList<>());
        list.add("Java");
        list.add("GPT");

        assertEquals(2, list.getAddCount());
        assertEquals(2, list.size());
    }

    @Test
    public void testAddAll() {
        InstrumentedList<String> list = new InstrumentedList<>(new ArrayList<>());
        list.addAll(List.of("A", "B", "C"));

        assertEquals(3, list.getAddCount());
        assertEquals("B", list.get(1));
    }

}