package my.code.chapter_4.Item_22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    void testCarDrive() {
        Car car = new Car("Toyota");
        car.drive();
        assertEquals("Toyota", car.getModel());
    }

    @Test
    void testMaxSpeed() {
        assertEquals(200, CarConstants.MAX_SPEED);
    }
}