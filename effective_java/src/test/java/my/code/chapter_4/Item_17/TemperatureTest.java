package my.code.chapter_4.Item_17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void testCelsiusGetter() {
        Temperature t = new Temperature(25.0);
        assertEquals(25.0, t.getCelsius());
    }

    @Test
    void testToFahrenheit() {
        Temperature t = new Temperature(0.0);
        assertEquals(32.0, t.toFahrenheit(), 0.01);

        Temperature t2 = new Temperature(100.0);
        assertEquals(212.0, t2.toFahrenheit(), 0.01);
    }

    @Test
    void testToString() {
        Temperature t = new Temperature(15.5);
        assertEquals("15.5°C", t.toString());
    }
}