package my.code.chapter_4.Item_19;

/**
 * ✏️ Завдання:
 * Створи базовий клас Shape, який має метод area().
 * Заборони перевизначення методу getName() — він повинен бути однаковий для всіх фігур.
 * І додай клас Circle, який успадковується від Shape.
 */

public abstract class Shape {
    public abstract double area();

    public final String getName() {
        return "Shape";
    }
}
