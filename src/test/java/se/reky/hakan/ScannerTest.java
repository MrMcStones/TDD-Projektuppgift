package se.reky.hakan;

import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {

    @Test
    public void testNextLine() {
        String input = "Test input";
        Scanner sc = new Scanner(input);
        assertEquals("Test input", sc.nextLine());
    }
}
