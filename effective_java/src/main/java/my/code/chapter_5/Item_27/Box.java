package my.code.chapter_5.Item_27;

/**
 * 📝 Пояснення:
 * Object[] не можна безпечно привести до T[], бо Java не знає, що таке T під час виконання.
 * Тому ми свідомо кастимо array[0] до T, і позначаємо це анотацією @SuppressWarnings.
 * @param <T>
 */

public class Box<T> {
    private final T value;

    public Box(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @SuppressWarnings("unchecked") // придушує попередження
    public static <T> Box<T> fromArray(Object[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        // Попередження: unchecked cast
        return new Box<>((T) array[0]);
    }
}
