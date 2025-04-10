package my.code.chapter2.template_builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LaptopTest {
    @Test
    void testLaptopBuilderWithAllFields() {
        Laptop laptop = new Laptop.Builder("Dell", "XPS 15")
                .processor("Intel i7")
                .ram(16)
                .storage(512)
                .graphicsCard("NVIDIA RTX 3050")
                .screenSize(15.6)
                .batteryCapacity(6000)
                .build();

        assertEquals("Dell", laptop.getBrand());
        assertEquals("XPS 15", laptop.getModel());
        assertEquals("Intel i7", laptop.getProcessor());
        assertEquals(16, laptop.getRam());
        assertEquals(512, laptop.getStorage());
        assertEquals("NVIDIA RTX 3050", laptop.getGraphicsCard());
        assertEquals(15.6, laptop.getScreenSize());
        assertEquals(6000, laptop.getBatteryCapacity());
    }

    @Test
    void testLaptopBuilderWithOnlyRequiredFields() {
        Laptop laptop = new Laptop.Builder("Apple", "MacBook Pro").build();

        assertEquals("Apple", laptop.getBrand());
        assertEquals("MacBook Pro", laptop.getModel());
        assertNull(laptop.getProcessor());
        assertEquals(0, laptop.getRam());
        assertEquals(0, laptop.getStorage());
        assertNull(laptop.getGraphicsCard());
        assertEquals(0.0, laptop.getScreenSize());
        assertEquals(0, laptop.getBatteryCapacity());
    }

    @Test
    void testLaptopBuilderWithNullBrandOrModelShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Laptop.Builder(null, "XPS 15"));
        assertThrows(IllegalArgumentException.class, () -> new Laptop.Builder("Dell", null));
    }
}