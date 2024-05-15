package se.reky.hakan.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {
    @Test
    public void testAttack() {
        Player player = new Player("Player", 100, 10);
        Goblin goblin = new Goblin("Goblin", 50, 5);
        player.attack(goblin);
        assertEquals(40, goblin.getHp());
    }
}
