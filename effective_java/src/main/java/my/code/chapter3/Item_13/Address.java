package my.code.chapter3.Item_13;

public class Address implements Cloneable {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    protected Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getCity() {
        return city;
    }
}
