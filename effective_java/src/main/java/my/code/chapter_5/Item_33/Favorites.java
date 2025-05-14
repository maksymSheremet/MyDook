package my.code.chapter_5.Item_33;

import java.util.HashMap;
import java.util.Map;

public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null || instance == null) {
            throw new NullPointerException("Type or instance must not be null");
        }
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
