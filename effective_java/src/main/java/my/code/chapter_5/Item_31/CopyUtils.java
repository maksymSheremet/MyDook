package my.code.chapter_5.Item_31;

import java.util.List;

/**
 * ✏️ Умова:
 * Створи клас CopyUtils з методом:
 * public static <T> void copy(List<? extends T> src, List<? super T> dest)
 * Метод повинен копіювати елементи з одного списку до іншого.
 */

public class CopyUtils {
    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T item : src) {
            dest.add(item);
        }
    }
}
