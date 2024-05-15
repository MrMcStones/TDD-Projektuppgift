package se.reky.hakan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerInteractionTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    private PlayerInteraction createPlayerInteraction(String dataForScanner) {
        Scanner sc = new Scanner(dataForScanner);
        IOHandler ioHandler = new IOHandler(sc);
        return new SimplePlayerInteraction(ioHandler);
    }

    @Test
    public void testSetupPlayer() {
        PlayerInteraction playerInteraction = createPlayerInteraction("PlayerName");
        playerInteraction.setupPlayer(player);
        assertEquals("PlayerName", player.getName());
    }

    @Test
    public void testUpdatePlayerHealth() {
        PlayerInteraction interaction = createPlayerInteraction("20");
        player.setHp(100);
        interaction.updatePlayerHealth(player, 50);
        assertEquals(150, player.getHp());
    }
}
