package my.code.chapter2.singleton_or_enum.center;

import java.time.LocalDateTime;

public class Notification {
    private final LocalDateTime timestamp;
    private final String category;
    private final String message;

    public Notification(String category, String message) {
        this.timestamp = LocalDateTime.now();
        this.category = category.toUpperCase();
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getCategory() {
        return category;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[%s] [%s] %s".formatted(timestamp, category, message);
    }
}
