package my.code.chapter2.item_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakeWebSocketTest {

    @Test
    void testBasicSendAndReceive() {
        try (FakeWebSocket socket = new FakeWebSocket("wss://chat")) {
            socket.send("Hello!");
            socket.send("How are you?");

            assertEquals(2, socket.getMessagesSent().size());
            assertEquals(2, socket.getMessagesReceived().size());
            assertTrue(socket.isOpen());
        }
    }

    @Test
    void testSendAfterCloseThrowsException() {
        FakeWebSocket socket = new FakeWebSocket("wss://news");
        socket.close();
        assertThrows(IllegalStateException.class, () -> socket.send("This will fail"));
    }

    @Test
    void testActiveSocketsCount() {
        int before = FakeWebSocket.getActiveSockets();
        try (FakeWebSocket socket1 = new FakeWebSocket("wss://games");
             FakeWebSocket socket2 = new FakeWebSocket("wss://music")) {
            assertEquals(before + 2, FakeWebSocket.getActiveSockets());
        }
        assertEquals(before, FakeWebSocket.getActiveSockets());
    }
}