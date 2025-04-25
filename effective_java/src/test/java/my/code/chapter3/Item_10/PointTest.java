package my.code.chapter3.Item_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testPointEquals() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertEquals(p1, p2);
        assertEquals(p2, p1);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testColorPointEqualsSameColor() {
        ColorPoint cp1 = new ColorPoint(1, 2, "red");
        ColorPoint cp2 = new ColorPoint(1, 2, "red");
        assertEquals(cp1, cp2);
        assertEquals(cp2, cp1);
        assertEquals(cp1.hashCode(), cp2.hashCode());
    }

    @Test
    void testColorPointEqualsDifferentColor() {
        ColorPoint cp1 = new ColorPoint(1, 2, "red");
        ColorPoint cp2 = new ColorPoint(1, 2, "blue");
        assertNotEquals(cp1, cp2);
    }

    @Test
    void testColorPointAndPointInequality() {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, "red");
        assertNotEquals(p, cp);
        assertNotEquals(cp, p);
    }

    @Test
    void testReflexive() {
        ColorPoint cp = new ColorPoint(3, 4, "green");
        assertEquals(cp, cp);
    }

}