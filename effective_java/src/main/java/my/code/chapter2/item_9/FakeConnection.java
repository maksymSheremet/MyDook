package my.code.chapter2.item_9;

public class FakeConnection implements AutoCloseable {
    private final String name;
    private boolean closed = false;

    public FakeConnection(String name) {
        this.name = name;
        System.out.println("🔌 [" + name + "] Відкрито з'єднання");
    }

    public void send(String data) {
        if (closed) {
            throw new IllegalStateException("З'єднання вже закрите: " + name);
        }
        System.out.println("📤 [" + name + "] Надсилання: " + data);
    }

    @Override
    public void close() {
        closed = true;
        System.out.println("🔒 [" + name + "] Закрито з'єднання");
    }

    public boolean isClosed() {
        return closed;
    }
}
