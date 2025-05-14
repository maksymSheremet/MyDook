package my.code.chapter_5.Item_33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FavoritesTest {

    @Test
    void testFavoriteStorage() {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "Hello");
        favorites.putFavorite(Integer.class, 42);

        String str = favorites.getFavorite(String.class);
        Integer num = favorites.getFavorite(Integer.class);

        assertEquals("Hello", str);
        assertEquals(42, num);
    }

    @Test
    void testTypeSafety() {
        Favorites favorites = new Favorites();
        favorites.putFavorite(Number.class, 3.14); // Double is a Number

        Number number = favorites.getFavorite(Number.class);
        assertEquals(3.14, number);
    }

    @Test
    void testNullValues() {
        Favorites favorites = new Favorites();
        assertThrows(NullPointerException.class, () -> favorites.putFavorite(null, "test"));
        assertThrows(NullPointerException.class, () -> favorites.putFavorite(String.class, null));
    }
}