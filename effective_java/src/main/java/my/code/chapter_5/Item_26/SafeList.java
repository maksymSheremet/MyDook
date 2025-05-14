package my.code.chapter_5.Item_26;

import java.util.ArrayList;
import java.util.List;

public class SafeList<T> {
    private final List<T> list;

    public SafeList() {
        list = new ArrayList<>();
    }

    public void add(T item) {
        list.add(item);
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
}
