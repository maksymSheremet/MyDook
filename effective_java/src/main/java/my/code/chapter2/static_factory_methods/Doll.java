package my.code.chapter2.static_factory_methods;

public class Doll {
    private String name;

    private Doll(String name) {
        this.name = name;
    }

    public static Doll createBarbie() {
        return new Doll("Barbie");
    }

    public static Doll createKen() {
        return new Doll("Ken");
    }

    @Override
    public String toString() {
        return "Лялька: " + name;
    }
}
