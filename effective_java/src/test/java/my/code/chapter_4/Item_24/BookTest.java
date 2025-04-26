package my.code.chapter_4.Item_24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void testBookAndChapter() {
        Book book = new Book("Effective Java");
        Book.Chapter chapter = new Book.Chapter("Creating and Destroying Objects", 1);

        assertEquals("Effective Java", book.getTitle());
        assertEquals("Creating and Destroying Objects", chapter.getName());
        assertEquals(1, chapter.getNumber());
    }
}