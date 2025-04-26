package my.code.chapter_4.Item_20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @Test
    void testResize() {
        Rectangle rect = new Rectangle(4, 5);
        rect.resize(2.0);

        assertEquals(8.0, rect.getWidth(), 0.0001);
        assertEquals(10.0, rect.getHeight(), 0.0001);
    }
}