package my.code.chapter_5.Item_32;

import java.util.ArrayList;
import java.util.List;

/**
 * ✏️ Умова:
 * Створи утиліту ArrayUtils з методом:
 * @SafeVarargs
 * public static <T> List<T> asList(T... elements)
 * Цей метод має повертати список з усіх переданих елементів.
 */

public class ArrayUtils {

    @SafeVarargs
    public static <T> List<T> asList(T... elements) {
        List<T> list = new ArrayList<>();
        for (T el : elements) {
            list.add(el);
        }
        return list;
    }
}
