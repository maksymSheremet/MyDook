package my.code.chapter_4.Item_25;


/**
 * ✏️ Завдання
 * Створи два класи: Person і Address.
 * Відокрем їх у різні файли.
 * У класі Person використовуй Address.
 * Напиши тести на створення людини з адресою.
 */

public class Person {
    private final String name;
    private final Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
