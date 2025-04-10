package my.code.chapter2.singleton_or_enum;

import java.util.ArrayList;
import java.util.List;

/**
 * Завжди повертає один об’єкт, через який можна логувати повідомлення.
 */
public enum SystemLogger {
    INSTANCE;

    private final List<String> logs = new ArrayList<>();

    public void log(String message) {
        logs.add(message);
    }

    public List<String> getLogs() {
        return List.copyOf(logs); // незмінний список
    }

    public void clear() {
        logs.clear();
    }
}
