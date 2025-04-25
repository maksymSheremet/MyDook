package my.code.chapter3.Item_13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testCloning() {
        Address addr = new Address("Lviv");
        Person p1 = new Person("Andrii", addr);
        Person p2 = p1.clone();

        assertEquals(p1.getName(), p2.getName());
        assertEquals(p1.getAddress().getCity(), p2.getAddress().getCity());
        assertNotSame(p1, p2); // різні об'єкти
        assertNotSame(p1.getAddress(), p2.getAddress()); // глибока копія
    }
}