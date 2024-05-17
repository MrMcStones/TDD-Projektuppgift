package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Disabled // Klasser körs ej när applikation byggs
public class PlayerControllerTest {

    private WebDriver driver; // WebDriver-instans, kontrollera webbläsare
    private final String url = "http://localhost:8080/"; // Bas-URL för applikation


    @BeforeAll
    public static void setupClass() {
        // Ställer in WebDriverManager för att hantera ChromeDriver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        // Skapar instans av ChromeDriver till /players endpoint
        driver = new ChromeDriver();
        driver.get(url + "players");
    }

    @AfterEach
    public void tearDown() {
        // Avslutar WebDriver efter varje test
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPlayerCount() {
        // Hittar spelare i lista genom <li>-element
        List<WebElement> players = driver.findElements(By.tagName("li"));
        // Verifierar att antal spelare är 2 i lista
        assertEquals(2, players.size());
    }

    @Test
    public void testFirstPlayerNameIsDisplayed() {
        // Hittar det första <li>-elementet
        WebElement firstPlayerName = driver.findElement(By.tagName("li"));
        // Verifierar att första namn i lista visas
        assertTrue(firstPlayerName.isDisplayed());
    }

    @Test
    public void testPageTitle() {
        // Verifierar att titelsida är "Players List"
        assertEquals("Players List", driver.getTitle());
    }

    @Test
    public void testLoginButtonText() {
        // Hittar button och verifierar att text är "Logga in"
        assertEquals("Logga in", driver.findElement(By.tagName("button")).getText());
    }
}
