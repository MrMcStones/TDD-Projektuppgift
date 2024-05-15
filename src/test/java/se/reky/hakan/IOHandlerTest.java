package se.reky.hakan;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IOHandlerTest {

    private IOHandler createIOHandler(String dataForScanner) {
        Scanner sc = new Scanner(dataForScanner);
        return new IOHandler(sc);
    }

    @Test
    public void testHasNextInt() {
        IOHandler ioHandler = createIOHandler("123");
        assertTrue(ioHandler.hasNextInt());
    }
}
