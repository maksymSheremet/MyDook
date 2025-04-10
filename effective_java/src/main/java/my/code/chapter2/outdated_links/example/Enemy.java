package my.code.chapter2.outdated_links.example;

public class Enemy {
    private final String type;

    public Enemy(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Enemy{" +
               "type='" + type + '\'' +
               '}';
    }
}
