package my.code.chapter_5.Item_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Створи утилітний клас Combiner, який має метод:
 * public static <T> List<T> combine(T[] array1, T[] array2)
 * Метод повертає список, який містить усі елементи з двох масивів.
 *
 * Також створи метод:
 * public static <T> List<T> combineLists(List<T> list1, List<T> list2)
 * У тестах покажи:
 * як зручніше працювати зі списками,
 * які обмеження мають масиви.
 */

public class Combiner {

    public static <T> List<T> combine(T[] array1, T[] array2) {
        List<T> result = new ArrayList<>();
        result.addAll(Arrays.asList(array1));
        result.addAll(Arrays.asList(array2));
        return result;
    }

    public static <T> List<T> combineLists(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.addAll(list2);
        return result;
    }
}
