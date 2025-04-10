package my.code.chapter2.creating_excess;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OptimizedCounter {
    private static final int MAX_CACHE_SIZE = 100;

    private static final Map<Integer, OptimizedCounter> CACHE = new LinkedHashMap<>(16, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, OptimizedCounter> eldest) {
            return size() > MAX_CACHE_SIZE;
        }
    };
    private final int value;

    private OptimizedCounter(int value) {
        this.value = value;
    }

    public static synchronized OptimizedCounter of(int value) {
        return CACHE.computeIfAbsent(value, OptimizedCounter::new);
    }

    public int getValue() {
        return value;
    }
}
