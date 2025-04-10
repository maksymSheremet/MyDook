package my.code.chapter2.outdated_links.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnemyPool {
    private final List<Enemy> pool = new ArrayList<>();

    public void spawn(String type) {
        pool.add(new Enemy(type));
    }

    public void defeat(int index) {
        if (index >= 0 && index < pool.size()) {
            pool.set(index, null);
        }
    }

    public void compact() {
        pool.removeIf(Objects::isNull);
    }

    public List<Enemy> getEnemies() {
        return new ArrayList<>(pool);
    }

    @Override
    public String toString() {
        return pool.toString();
    }
}
