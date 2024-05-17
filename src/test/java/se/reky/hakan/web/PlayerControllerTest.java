package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Disabled // Klasser körs ej när applikation byggs
public class PlayerControllerTest {

    private WebDriver driver; // WebDriver-instans, kontrollera webbläsare
    private final String url = "http://localhost:8080/"; // Bas-URL för applikation
    private WebDriverWait wait;


    @BeforeAll
    public static void setupClass() {
        // Ställer in WebDriverManager för att hantera ChromeDriver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        // Skapar instans av ChromeDriver till /players endpoint
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
        driver.get(url + "players");
        // Hittar spelare i lista genom <li>-element
        List<WebElement> players = driver.findElements(By.tagName("li"));
        // Verifierar att antal spelare är 2 i lista
        assertEquals(2, players.size());
    }

    @Test
    public void testFirstPlayerNameIsDisplayed() {
        driver.get(url + "players");
        // Hittar det första <li>-elementet
        WebElement firstPlayerName = driver.findElement(By.tagName("li"));
        // Verifierar att första namn i lista visas
        assertTrue(firstPlayerName.isDisplayed());
    }

    @Test
    public void testPageTitle() {
        driver.get(url + "players");
        // Verifierar att titelsida är "Players List"
        assertEquals("Players List", driver.getTitle());
    }

    @Test
    public void testLoginButtonText() {
        driver.get(url + "players");
        // Hittar button och verifierar att text är "Logga in"
        assertEquals("Logga in", driver.findElement(By.tagName("button")).getText());
    }

    @Test
    public void testPlayerDetailsDisplayed() {
        driver.get(url + "players");
        driver.findElement(By.tagName("a")).click();

        wait.until(ExpectedConditions.titleIs("Player Details"));
        assertTrue(driver.findElement(By.className("player-name")).isDisplayed());
    }
}
