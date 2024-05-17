package se.reky.hakan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerInteractionTest {
    private Player player; // Klassattribut för att hålla en instans av Player

    // Metod som körs före varje test för att initialisera player-attributet
    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    // Privat metod som skapar och returnerar en instans av PlayerInteraction
    private PlayerInteraction createPlayerInteraction(String dataForScanner) {
//        Scanner sc = new Scanner(dataForScanner); // Skapar en ny Scanner med dataForScanner som indata
//        IOHandler ioHandler = new IOHandler(sc); // Skapar en ny IOHandler med Scanner som argument
        return new SimplePlayerInteraction(new IOHandler(new Scanner(dataForScanner))); // Returnerar en ny SimplePlayerInteraction-instans med IOHandler som argument
    }

    // Testmetod för att verifiera playerSetup-metoden i PlayerInteraction
    @Test
    public void testSetupPlayer() {
        PlayerInteraction playerInteraction = createPlayerInteraction("PlayerName"); // Skapar en PlayerInteraction med strängen "PlayerName"
        playerInteraction.setupPlayer(player); // Anropar playerSetup-metoden med player som argument
        assertEquals("PlayerName", player.getName()); // Verifierar att spelarens namn har satts korrekt
    }

    // Testmetod för att verifiera updatePlayerHealth-metoden i PlayerInteraction
    @Test
    public void testUpdatePlayerHealth() {
        PlayerInteraction interaction = createPlayerInteraction(""); // Skapar en PlayerInteraction med strängen "20"
        player.setHp(100); // Sätter spelarens initiala hälsa till 100
        interaction.updatePlayerHealth(player, 50); // Anropar updatePlayerHealth-metoden med player och en extra parameter för hälsouppdatering
        assertEquals(150, player.getHp()); // Verifierar att spelarens hälsa har uppdaterats korrekt
    }
}
