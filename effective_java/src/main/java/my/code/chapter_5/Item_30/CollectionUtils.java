package my.code.chapter_5.Item_30;

import java.util.List;

/**
 * Створи клас CollectionUtils з узагальненим методом:
 * public static <T> T getLast(List<T> list)
 * Метод повинен повертати останній елемент зі списку. Якщо список порожній — викидати IllegalArgumentException.
 */

public class CollectionUtils {
    public static <T> T getLast(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        return list.get(list.size() - 1);
    }
}
