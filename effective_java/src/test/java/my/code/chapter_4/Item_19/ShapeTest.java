package my.code.chapter_4.Item_19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    public void testCircleArea() {
        Circle c = new Circle(2.0);
        assertEquals(Math.PI * 4, c.area(), 0.0001);
    }

    @Test
    public void testShapeNameIsFinal() {
        Circle c = new Circle(1.0);
        assertEquals("Shape", c.getName());
    }
}