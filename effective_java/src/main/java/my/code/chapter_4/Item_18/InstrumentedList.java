package my.code.chapter_4.Item_18;

import java.util.Collection;
import java.util.List;

/**
 * ✅ Завдання: Створи клас InstrumentedList, який підраховує, скільки разів додавали елементи
 * 🔧 Реалізуй це через композицію, а не наслідування!
 */

public class InstrumentedList<E> {

    private final List<E> list;
    private int addCount = 0;

    public InstrumentedList(List<E> list) {
        this.list = list;
    }

    public void add(E element) {
        addCount++;
        list.add(element);
    }

    public void addAll(Collection<? extends E> elements) {
        addCount += elements.size();
        list.addAll(elements);
    }

    public int getAddCount() {
        return addCount;
    }

    public E get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
}
