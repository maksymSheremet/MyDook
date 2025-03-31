package my.code.chapter2.static_factory_methods;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SmartNumbersTest {

    @Test
    @Order(1)
    @DisplayName("Перевірка створення SmartNumbers з додатного числа")
    void testFromPositive() {
        SmartNumbers num = SmartNumbers.fromPositive(10);
        assertEquals(10, num.getValue());
    }

    @Test
    @Order(2)
    @DisplayName("Перевірка, що від'ємне число викликає виняток у fromPositive")
    void testFromPositiveShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> SmartNumbers.fromPositive(-5));
    }

    @Test
    @Order(3)
    @DisplayName("Перевірка створення SmartNumbers з парного числа")
    void testFromEven() {
        SmartNumbers num = SmartNumbers.fromEven(8);
        assertEquals(8, num.getValue());
    }

    @Test
    @Order(4)
    @DisplayName("Перевірка, що непарне число викликає виняток у fromEven")
    void testFromEvenShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> SmartNumbers.fromEven(7));
    }

    @Test
    @Order(5)
    @DisplayName("Перевірка створення SmartNumbers з простого числа")
    void testFromPrime() {
        SmartNumbers num = SmartNumbers.fromPrime(7);
        assertEquals(7, num.getValue());
    }

    @Test
    @Order(6)
    @DisplayName("Перевірка, що складене число викликає виняток у fromPrime")
    void testFromPrimeShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> SmartNumbers.fromPrime(10));
    }

    @Test
    @Order(7)
    @DisplayName("Перевірка створення SmartNumbers зі степенем двійки")
    void testFromPowerOfTwo() {
        SmartNumbers num = SmartNumbers.fromPowerOfTwo(16);
        assertEquals(16, num.getValue());
    }

    @Test
    @Order(8)
    @DisplayName("Перевірка, що не-степінь двійки викликає виняток у fromPowerOfTwo")
    void testFromPowerOfTwoShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> SmartNumbers.fromPowerOfTwo(10));
    }

    @Test
    @Order(9)
    @DisplayName("Перевірка кешування об'єктів SmartNumbers")
    void testCacheWorks() {
        var num1 = SmartNumbers.fromPositive(10);
        var num2 = SmartNumbers.fromPositive(10);
        assertSame(num1, num2);
    }
}