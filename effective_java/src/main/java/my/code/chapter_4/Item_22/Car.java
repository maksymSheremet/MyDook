package my.code.chapter_4.Item_22;

/**
 * ✏️ Завдання
 * Створи інтерфейс Drivable з методом drive().
 * Створи клас Car, який реалізує Drivable.
 * Також створи клас CarConstants, який містить константу MAX_SPEED.
 */

public class Car implements Drivable {

    private final String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void drive() {
        System.out.println(model + " is driving.");
    }

    public String getModel() {
        return model;
    }
}
