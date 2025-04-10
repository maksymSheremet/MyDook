package my.code.chapter2.item_8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakeDatabaseConnectionTest {

    @BeforeEach
    void setUp() {
        FakeDatabaseConnection.clearCache();
    }

    @Test
    void testAutoCloseConnection() throws Exception {
        FakeDatabaseConnection conn;
        try (FakeDatabaseConnection c = FakeDatabaseConnection.open("UsersDB"))  {
            conn = c;
            c.executeQuery("SELECT * FROM User");
        }

        assertFalse(conn.isOpen());
        assertEquals(0, FakeDatabaseConnection.getActiveConnections());
    }

    @Test
    void testReuseFromCache() {
        FakeDatabaseConnection conn1 = FakeDatabaseConnection.open("ProductsDB");
        FakeDatabaseConnection conn2 = FakeDatabaseConnection.open("ProductsDB");

        assertSame(conn1, conn2);
    }

    @Test
    void testLogAndLifetime() throws Exception {
        try (FakeDatabaseConnection conn = FakeDatabaseConnection.open("OrdersDB")) {
            conn.executeQuery("SELECT * FROM orders");
            conn.executeQuery("DELETE FROM orders WHERE id = 5");

            assertEquals(2, conn.getQueryLogs().size());
            assertTrue(conn.getLifetime().toMillis() >= 0);
        }
    }

    @Test
    void testExecuteAfterClose() throws Exception {
        FakeDatabaseConnection conn = FakeDatabaseConnection.open("TempDB");
        conn.close();

        assertThrows(IllegalStateException.class, () -> conn.executeQuery("SELECT * FROM orders"));
    }

    @Test
    void testActiveConnections() {
        FakeDatabaseConnection.open("A");
        FakeDatabaseConnection.open("B");
        assertEquals(2, FakeDatabaseConnection.getActiveConnections());
    }
}