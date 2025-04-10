package my.code.chapter2.item_9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakeConnectionTest {

    @Test
    void testConnectionAutoCloseable() {
        FakeConnection conn = null;
        try (FakeConnection connection = new FakeConnection("TestConn")) {
            conn = connection;
            connection.send("Hello, world!");
        }

        assertNotNull(conn);
        assertTrue(conn.isClosed(), "З'єднання має бути закрите після try-with-resources");
    }

    @Test
    void testConnectionThrowsAfterClose() {
        FakeConnection conn = new FakeConnection("Conn2");
        conn.close();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            conn.send("Oops");
        });

        assertTrue(exception.getMessage().contains("З'єднання вже закрите"));
    }
}