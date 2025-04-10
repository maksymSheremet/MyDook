package my.code.chapter2.outdated_links;

import java.util.ArrayList;
import java.util.List;

/**
 * Напиши ObjectPool, який зберігає і "випускає" об'єкти, і переконайся,
 * що після "випуску" об’єкти очищаються з пам’яті
 */

public class ObjectPool {
    private final List<Object> pool = new ArrayList<>();

    public void add(Object o) {
        pool.add(o);
    }

    public Object release(int index) {
        if (index < 0 || index >= pool.size()) {
            throw new IndexOutOfBoundsException();
        }
        Object obj = pool.get(index);
        pool.set(index, null);
        return obj;
    }

    public Object get(int index) {
        return pool.get(index);
    }

    public int size() {
        return pool.size();
    }
}
