package my.code.chapter2.item_8;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Симуляція з'єднання з базою даних, яка відкривається й закривається, і якщо не закрити — будуть проблеми.
 * ✅ Кеш з'єднань
 * ✅ Лічильник активних підключень
 * ✅ Час життя з'єднання
 * ✅ Логування запитів
 * ✅ Захист від повторного відкриття
 */

public class FakeDatabaseConnection implements AutoCloseable {

    private static final List<FakeDatabaseConnection> CACHE = new ArrayList<>();
    private static final AtomicInteger ACTIVE_CONNECTIONS = new AtomicInteger(0);

    private final String dbName;
    private final Instant openedAt;
    private boolean open = false;
    private final List<String> logs = new ArrayList<>();

    private FakeDatabaseConnection(String dbName) {
        this.dbName = dbName;
        this.openedAt = Instant.now();
        this.open = true;
        ACTIVE_CONNECTIONS.incrementAndGet();
        System.out.println("🔌 Підключено до БД: " + dbName);
    }

    public static FakeDatabaseConnection open(String dbName) {
        for (FakeDatabaseConnection conn : CACHE) {
            if (conn.dbName.equals(dbName) && conn.open) {
                System.out.println("♻️ Повернуто з кешу: " + dbName);
                return conn;
            }
        }
        FakeDatabaseConnection conn = new FakeDatabaseConnection(dbName);
        CACHE.add(conn);
        return conn;
    }

    public void executeQuery(String query) {
        if (!open) {
            throw new IllegalStateException("🚫 З'єднання вже закрито!");
        }
        logs.add(query);
        System.out.println("📥 Запит: " + query);
    }

    public List<String> getQueryLogs() {
        return logs;
    }

    public Duration getLifetime() {
        return Duration.between(openedAt, Instant.now());
    }


    @Override
    public void close() throws Exception {
        if (open) {
            System.out.println("🔒 Закриваємо з'єднання з БД: " + dbName + " після " + getLifetime().toMillis() + "мс");
            open = false;
            ACTIVE_CONNECTIONS.decrementAndGet();
        }
    }

    public boolean isOpen() {
        return open;
    }

    public static int getActiveConnections() {
        return ACTIVE_CONNECTIONS.get();
    }

    public static void clearCache() {
        CACHE.clear();
        ACTIVE_CONNECTIONS.set(0);
    }
}
