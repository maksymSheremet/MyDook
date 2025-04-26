package my.code.chapter_4.Item_25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void testCreatePersonWithAddress() {
        Address address = new Address("Kyiv", "Khreshchatyk Street");
        Person person = new Person("Ivan", address);

        assertEquals("Ivan", person.getName());
        assertEquals("Kyiv", person.getAddress().getCity());
        assertEquals("Khreshchatyk Street", person.getAddress().getStreet());
    }
}