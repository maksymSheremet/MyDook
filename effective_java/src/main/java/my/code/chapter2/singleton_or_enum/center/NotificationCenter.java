package my.code.chapter2.singleton_or_enum.center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum NotificationCenter {
    INSTANCE;

    private final List<Notification> notifications = new ArrayList<>();

    public void send(String category, String message) {
        notifications.add(new Notification(category, message));
    }

    public List<Notification> getAll() {
        return Collections.unmodifiableList(notifications);
    }

    public List<Notification> getByCategory(String category) {
        return notifications.stream()
                .filter(n -> n.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    public Notification getLatest() {
        if (notifications.isEmpty()) {
            return null;
        }
        return notifications.get(notifications.size() - 1);
    }

    public void clear() {
        notifications.clear();
    }
}
