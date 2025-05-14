package my.code.chapter_5.Item_29;

/**
 * Створи узагальнений клас Pair<K, V>, який зберігає пару ключ-значення. Реалізуй:
 * конструктор
 * методи getKey(), getValue()
 * метод swap(), який повертає новий Pair<V, K>
 */

public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Pair<V, K> swap() {
        return new Pair<>(value, key);
    }
}
