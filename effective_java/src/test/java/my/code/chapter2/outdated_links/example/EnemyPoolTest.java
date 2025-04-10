package my.code.chapter2.outdated_links.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyPoolTest {

    @Test
    void testSpawnAndDefeatAndCompact() {
        EnemyPool pool = new EnemyPool();

        pool.spawn("Orc");
        pool.spawn("Goblin");
        pool.spawn("Dragon");

        assertEquals(3, pool.getEnemies().size());
        System.out.println("Before defeat: " + pool);

        pool.defeat(1);
        System.out.println("After defeat: " + pool);

        assertNull(pool.getEnemies().get(1));

        pool.compact();
        System.out.println("After compact: " + pool);

        assertEquals(2, pool.getEnemies().size());
        assertTrue(pool.toString().contains("Orc"));
        assertTrue(pool.toString().contains("Dragon3"));
    }
}