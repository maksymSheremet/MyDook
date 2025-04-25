package my.code.chapter3.Item_14;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testCompareToByAge() {
        Person p1 = new Person("Ivan", 30);
        Person p2 = new Person("Oksana", 25);
        Person p3 = new Person("Petro", 35);

        List<Person> people = Arrays.asList(p1, p2, p3);
        people.sort(null);

        assertEquals("Oksana", people.get(0).getName());
        assertEquals("Ivan", people.get(1).getName());
        assertEquals("Petro", people.get(2).getName());
    }

}