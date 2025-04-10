package my.code.chapter2.private_designer;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureUtilsTest {

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureUtils.celsiusToFahrenheit(0), 0.001);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(100.0, TemperatureUtils.fahrenheitToCelsius(212), 0.01);
    }

    @Test
    void testPrivateConstructor() throws Exception {
        Constructor<TemperatureUtils> constructor =
                TemperatureUtils.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Exception exception = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(AssertionError.class, exception.getCause());
    }
}