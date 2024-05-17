package se.reky.hakan.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {

    // Testmetod för att verifiera attack-metoden i Actor-klassen
    @Test
    public void testAttack() {
        Player player = new Player("Player", 100, 10); // Skapar en spelar-instans med namnet "Player", 100 HP och attack 10
        Goblin goblin = new Goblin("Goblin", 50, 5); // Skapar en Goblin-instans med namnet "Goblin", 50 HP och attack 5
        player.attack(goblin); // Spelaren attackerar goblin
        assertEquals(40, goblin.getHp()); // Verifierar att goblins HP har minskat korrekt efter attack
    }
}
