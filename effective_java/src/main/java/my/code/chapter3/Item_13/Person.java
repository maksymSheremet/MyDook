package my.code.chapter3.Item_13;

public class Person implements Cloneable {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Person clone() {
        try {
            Person cloned = (Person) super.clone();
            cloned.address = address.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
