package my.code.chapter2.static_factory_methods;

import java.util.HashMap;
import java.util.Map;

public class SmartNumbersComplete {
    private final int value;
    private static final Map<Integer, SmartNumbersComplete> CACHE = new HashMap<>();

    private SmartNumbersComplete(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 1️⃣ Фабричний метод для додатних чисел
    public static SmartNumbersComplete fromPositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Число має бути додатним!");
        }
        return CACHE.computeIfAbsent(value, SmartNumbersComplete::new);
    }

    // 2️⃣ Фабричний метод для парних чисел
    public static SmartNumbersComplete fromEven(int value) {
        if (value % 2 != 0) {
            throw new IllegalArgumentException("Число має бути парним!");
        }
        return CACHE.computeIfAbsent(value, SmartNumbersComplete::new);
    }

    // 3️⃣ Фабричний метод для простих чисел
    public static SmartNumbersComplete fromPrime(int value) {
        if (!isPrime(value)) {
            throw new IllegalArgumentException("Число має бути простим!");
        }
        return CACHE.computeIfAbsent(value, SmartNumbersComplete::new);
    }

    // 4️⃣ Фабричний метод для степенів двійки
    public static SmartNumbersComplete fromPowerOfTwo(int value) {
        if (value <= 0 || (value & (value - 1)) != 0) {
            throw new IllegalArgumentException("Value must be a power of two");
        }
        return CACHE.computeIfAbsent(value, SmartNumbersComplete::new);
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}