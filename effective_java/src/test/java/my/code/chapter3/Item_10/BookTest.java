package my.code.chapter3.Item_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {

    @Test
    void testEqualsReflexive() {
        Book book = new Book("Java", "Bloch", "123");
        assertEquals(book, book);
    }

    @Test
    void testEqualsSymmetric() {
        Book book = new Book("Java", "Bloch", "123");
        Book book2 = new Book("Java", "Bloch", "123");
        assertEquals(book, book2);
        assertEquals(book.hashCode(), book2.hashCode());
        assertEquals(book2, book);
    }

    @Test
    void testEqualsTransitive() {
        Book book1 = new Book("Java", "Bloch", "123");
        Book book2 = new Book("Java", "Bloch", "123");
        Book book3 = new Book("Java", "Bloch", "123");
        assertEquals(book1, book2);
        assertEquals(book2, book3);
        assertEquals(book1, book3);
    }

    @Test
    void testEqualsConsistent() {
        Book book1 = new Book("Java", "Bloch", "123");
        Book book2 = new Book("Java", "Bloch", "123");
        for (int i = 0; i < 10; i++) {
            assertEquals(book1, book2);
        }
    }

    @Test
    void testEqualsNull() {
        Book book = new Book("Java", "Bloch", "123");
        assertNotEquals(book, null);
    }

    @Test
    void testNotEqualsDifferentISBN() {
        Book book1 = new Book("Java", "Bloch", "123");
        Book book2 = new Book("Java", "Bloch", "456");
        assertNotEquals(book1, book2);
    }
}