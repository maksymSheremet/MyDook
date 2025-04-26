package my.code.chapter_4.Item_20;

/**
 * ✏️ Завдання
 * Створи інтерфейс Resizable з методом resize(double factor).
 * Створи клас Rectangle, який реалізує Resizable і має width і height.
 * Зроби тест, що resize правильно масштабує розміри.
 */

public class Rectangle implements Resizable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void resize(double factor) {
        width *= factor;
        height *= factor;
    }
}
