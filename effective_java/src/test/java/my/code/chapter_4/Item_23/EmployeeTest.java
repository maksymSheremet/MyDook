package my.code.chapter_4.Item_23;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    @Test
    void testDeveloperSalary() {
        Developer dev = new Developer(50, 160);
        assertEquals(8000, dev.calculateSalary(), 0.0001);
    }

    @Test
    void testManagerSalary() {
        Manager mgr = new Manager(5000, 1500);
        assertEquals(6500, mgr.calculateSalary(), 0.0001);
    }
}