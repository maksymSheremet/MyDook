package my.code.chapter_4.Item_17;

/**
 * 🧪 Завдання
 * ✏️ Створи іммутабельний клас Temperature, який зберігає температуру в градусах Цельсія.
 * Додай метод:
 * toFahrenheit() — повертає температуру у Фаренгейтах.
 */

public class Temperature {
    private final double celsius;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    public double toFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }

    @Override
    public String toString() {
        return celsius + "°C";
    }
}
