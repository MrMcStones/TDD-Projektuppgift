package se.reky.hakan;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IOHandlerTest {

    // Privat metod som skapar en instans av IOHandler med en Scanner
    private IOHandler createIOHandler(String dataForScanner) {
        Scanner sc = new Scanner(dataForScanner); // Skapar en ny Scanner med dataForScanner som indata
        return new IOHandler(sc); // Returnerar en ny IOHandler-instans med Scanner som argument
    }

    // Testmetod för att verifiera hasNextInt-metoden i IOHandler
    @Test
    public void testHasNextInt() {
        IOHandler ioHandler = createIOHandler("123"); // Skapar IOHandler med strängen "123"
        assertTrue(ioHandler.hasNextInt()); // Verifierar att hasNextInt-metoden returnerar true
    }
}
