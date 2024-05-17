package se.reky.hakan.util;

import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameUtilTest {

    // Testmetod för att verifiera att GameException kastas när null skickas till toLowerCaseButFirstLetterCapitalized-metoden
    @Test
    public void testToLowerCaseButFirstLetterCapitalized() {
        GameUtil gameUtil = new GameUtil(); // Skapar en instans av GameUtil
        // Använder assertThrows för att verifiera att ett GameException kastas när null skickas till metoden
        assertThrows(GameException.class, () -> gameUtil.toLowerCaseButFirstLetterCapitalized(null));
    }
}
