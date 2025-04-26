package my.code.chapter_4.Item_21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    @Test
    public void testSongTitle() {
        Song song = new Song("Imagine");
        assertEquals("Imagine", song.getTitle());
    }

    @Test
    public void testSongPlay() {
        Song song = new Song("Imagine");
        song.play();
        // Перевірка через логування або мок об'єкт в реальному проекті
        // Тут просто викликаємо для демонстрації
    }
}