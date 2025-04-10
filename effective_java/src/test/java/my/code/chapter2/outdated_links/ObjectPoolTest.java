package my.code.chapter2.outdated_links;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectPoolTest {

    @Test
    void testAddAndRelease() {
        ObjectPool pool = new ObjectPool();
        pool.add("one");
        pool.add("two");

        assertEquals("two", pool.get(1));

        Object released = pool.release(1);

        assertEquals("two", released);
        assertNull(pool.get(1));
    }

    @Test
    void testReleaseInvalidIndex() {
        ObjectPool pool = new ObjectPool();
        pool.add("test");

        assertThrows(IndexOutOfBoundsException.class, () -> pool.release(5));
    }

}