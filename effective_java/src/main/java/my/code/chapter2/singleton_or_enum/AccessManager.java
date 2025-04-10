package my.code.chapter2.singleton_or_enum;

import java.util.HashSet;
import java.util.Set;

/**
 * ✅ 1. AccessManager – Контроль доступу
 * 📘 Ідея:
 * У тебе є клас, який керує списком авторизованих користувачів. І він має бути лише один на всю систему.
 * 🔹 Методи:
 * void authorize(String username)
 * boolean isAuthorized(String username)
 * void clear()
 *
 * ✅ 2. SystemConfig – Конфігурація системи
 * 📘 Ідея:
 * Цей клас зберігає налаштування (мову, країну, режим тощо) — як глобальний config.json, але в пам'яті.
 * 🔹 Методи:
 * void setConfig(String key, String value)
 * String getConfig(String key)
 * void reset()
 *
 * ✅ 3. ReceiptPrinter – Друк чеків
 * 📘 Ідея:
 * Симуляція принтера чеків. У тебе може бути лише один принтер у магазині.
 * 🔹 Методи:
 * void print(String text)
 * List<String> getPrintedReceipts()
 * void clearReceipts()
 */

public enum AccessManager {
    INSTANCE;

    private final Set<String> authorizedUsers = new HashSet<>();

    public void  authorize(String username) {
        authorizedUsers.add(username);
    }

    public boolean isAuthorized(String username) {
        return authorizedUsers.contains(username);
    }

    public void clear() {
        authorizedUsers.clear();
    }
}
