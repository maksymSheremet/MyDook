package my.code.chapter2.private_designer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class EmojiUtilsTest {

    @Test
    @DisplayName("😄 Має повертати емодзі за настроєм")
    void testMoodEmoji() {
        assertEquals("😄", EmojiUtils.getMoodEmoji("happy"));
        assertEquals("🤷‍♂️", EmojiUtils.getMoodEmoji("unknown"));
    }

    @Test
    @DisplayName("🐶 Має повертати емодзі за твариною")
    void testAnimalEmoji() {
        assertEquals("🐶", EmojiUtils.getAnimalEmoji("dog"));
        assertEquals("❓", EmojiUtils.getAnimalEmoji("dragon"));
    }

    @Test
    @DisplayName("🚫 Неможливо створити EmojiUtils через приватний конструктор")
    void testPrivateConstructor() throws Exception {
        Constructor<EmojiUtils> constructor = EmojiUtils.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InvocationTargetException ex = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(AssertionError.class, ex.getCause());
    }
}
