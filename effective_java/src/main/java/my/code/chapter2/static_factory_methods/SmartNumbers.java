package my.code.chapter2.static_factory_methods;

import java.util.HashMap;
import java.util.Map;

public class SmartNumbers {
    private final int value;

    // ❗ Кеш для збереження створених об'єктів (завдання 1)
    private static final Map<Integer, SmartNumbers> CACHE = new HashMap<>();

    /**
     * Приватний конструктор – забороняє створювати об'єкти напряму через new
     */
    private SmartNumbers(int value) {
        this.value = value;
    }

    /**
     * ✅ 1. Реалізуй фабричний метод для додатних чисел
     * 📌 Завдання 1: Реалізувати метод, який створює об'єкт лише для ДОДАТНИХ чисел.
     *  🔹 Якщо число <= 0 → кидати IllegalArgumentException.
     *  🔹 Використовувати кешування, щоб не створювати один і той самий об'єкт двічі.
     * @param value Додатне число
     * @return SmartNumbers, якщо число > 0, інакше – виняток
     */
    public static SmartNumbers fromPositive(int value) {
//         TODO: ❗ Тут потрібно реалізувати перевірку на додатність
        throw new UnsupportedOperationException("Not implemented yet");

    }

    /**
     * ✅ 2. Реалізуй фабричний метод для парних чисел
     * 📌 Завдання 2: Реалізувати метод, який створює об'єкт лише для ПАРНИХ чисел.
     *  🔹 Якщо число НЕ парне → кидати IllegalArgumentException.
     *  🔹 Використовувати кешування.
     * @param value Парне число
     * @return SmartNumbers, якщо число парне, інакше – виняток
     */
    public static SmartNumbers fromEven(int value) {
        // TODO: ❗ Тут потрібно перевірити, що число парне
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * ✅ 3. Реалізуй фабричний метод для простих чисел
     * 📌 Завдання 3: Реалізувати метод, який створює об'єкт лише для ПРОСТИХ чисел.
     *  🔹 Якщо число НЕ просте → кидати IllegalArgumentException.
     *  🔹 Використовувати кешування.
     * @param value Просте число
     * @return SmartNumbers, якщо число просте, інакше – виняток
     */
    public static SmartNumbers fromPrime(int value) {
        // TODO: ❗ Тут потрібно реалізувати перевірку на просте число
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * ✅ 4. Реалізуй фабричний метод для степенів двійки
     * 📌 Завдання 4: Реалізувати метод, який створює об'єкт лише для чисел, які є степенями двійки.
     * 🔹 Якщо число не є 1, 2, 4, 8, 16, 32... → кидати IllegalArgumentException.
     * 🔹 Використовувати кешування.
     * 🔹 Використати умову: (n > 0) && ((n & (n - 1)) == 0)
     * @param value Степінь двійки (1, 2, 4, 8, 16...)
     * @return SmartNumbers, якщо число – степінь двійки, інакше – виняток
     */
    public static SmartNumbers fromPowerOfTwo(int value) {
        // TODO: ❗ Тут потрібно перевірити, чи є число степенем двійки
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * ✅ 5. Реалізуй кешування, щоб унікальні числа створювалися лише 1 раз
     * Потрібно використати `CACHE`
     */

    /**
     * Метод для отримання значення
     * @return Число
     */
    public int getValue() {
        return value;
    }
}

