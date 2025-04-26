package my.code.chapter_4.Item_16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void testValidBook() {
        Book book = new Book("Clean Code", "Robert C. Martin", 45.99);
        assertEquals("Clean Code", book.getTitle());
        assertEquals("Robert C. Martin", book.getAuthor());
        assertEquals(45.99, book.getPrice());
    }

    @Test
    public void testNegativePriceThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Book("Refactoring", "Martin Fowler", -10.0);
        });

        assertEquals("Price cannot be negative", exception.getMessage());
    }

    @Test
    public void testSetNegativePriceThrowsException() {
        Book book = new Book("Refactoring", "Martin Fowler", 30.0);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(-5.0);
        });
    }
}