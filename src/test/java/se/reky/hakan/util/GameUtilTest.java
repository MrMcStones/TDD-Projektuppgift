package se.reky.hakan.util;

import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameUtilTest {
    @Test
    public void testToLowerCaseButFirstLetterCapitalized() {
        GameUtil gameUtil = new GameUtil();
        assertThrows(GameException.class, () -> gameUtil.toLowerCaseButFirstLetterCapitalized(null));
    }
}
