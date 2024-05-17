package se.reky.hakan;

import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {

    // Testmetod för att verifiera att nextLine-metoden i Scanner returnerar rätt sträng
    @Test
    public void testNextLine() {
        String input = "Test input"; // Skapar en teststräng
        Scanner sc = new Scanner(input); // Skapar en Scanner med teststrängen som indata
        assertEquals("Test input", sc.nextLine()); // Verifierar att nextLine-metoden i Scanner returnerar rätt sträng
    }
}
