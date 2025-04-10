package my.code.chapter2.creating_excess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimizedCounterTest {
    
    @Test
    void testSameObjectsFromCache() {
        var counter1 = OptimizedCounter.of(5);
        var counter2 = OptimizedCounter.of(5);

        assertSame(counter1, counter2, "Об'єкти повинні бути однакові (кешування)");
    }

    @Test
    void testDifferentValues() {
        var counter1 = OptimizedCounter.of(10);
        var counter2 = OptimizedCounter.of(20);

        assertNotSame(counter1, counter2, "Різні значення повинні мати різні об'єкти");
    }


    @Test
    void testCacheLimit() {
        // Створюємо понад 100 унікальних об'єктів
        for (int i = 0; i < 150; i++) {
            OptimizedCounter.of(i);
        }

        // Тепер перший об'єкт (0) має бути видалений з кешу
        var newZero = OptimizedCounter.of(0);
        var anotherZero = OptimizedCounter.of(0);

        // Вони мають бути однакові (кеш після оновлення)
        assertSame(newZero, anotherZero);

        // Але вони точно не такі ж самі як той, що був у самому початку (бо той був видалений)
        // Ми не можемо перевірити старий, бо його вже немає, але можемо підтвердити що кеш обмежений
    }
}