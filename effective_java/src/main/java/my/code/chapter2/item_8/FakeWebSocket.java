package my.code.chapter2.item_8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeWebSocket implements AutoCloseable {

    private static final AtomicInteger ACTIVE_SOCKETS = new AtomicInteger(0);

    private final String endpoint;
    private boolean open = false;
    private final List<String> messagesSent = new ArrayList<>();
    private final List<String> messagesReceived = new ArrayList<>();

    public FakeWebSocket(String endpoint) {
        this.endpoint = endpoint;
        this.open = true;
        ACTIVE_SOCKETS.incrementAndGet();
        System.out.println("📡 Підключено до WebSocket: " + endpoint);
    }

    public void send(String message) {
        ensureOpen();
        System.out.println("📤 Надіслано: " + message);
        messagesSent.add(message);
        // Імітуємо відповідь
        String reply = "📩 Відповідь на: " + message;
        messagesReceived.add(reply);
    }

    public List<String> getMessagesSent() {
        return messagesSent;
    }

    public List<String> getMessagesReceived() {
        return messagesReceived;
    }

    public boolean isOpen() {
        return open;
    }

    public static int getActiveSockets() {
        return ACTIVE_SOCKETS.get();
    }

    private void ensureOpen() {
        if (!open) throw new IllegalStateException("🚫 WebSocket-з'єднання вже закрито!");
    }

    @Override
    public void close() {
        if (open) {
            System.out.println("🔌 Закрито з'єднання: " + endpoint);
            open = false;
            ACTIVE_SOCKETS.decrementAndGet();
        }
    }
}
