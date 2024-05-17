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

@Disabled
public class PlayerControllerTest {

    private WebDriver driver;
    private final String url = "http://localhost:8080/";

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(url + "players");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPlayerCount() {
        List<WebElement> players = driver.findElements(By.tagName("li"));
        assertEquals(2, players.size());
    }

    @Test
    public void testFirstPlayerNameDisplayed() {
        WebElement firstPlayerName = driver.findElement(By.tagName("li"));
        assertTrue(firstPlayerName.isDisplayed());
    }

    @Test
    public void testPageTitle() {
        assertEquals("Players List", driver.getTitle());
    }

    @Test
    public void testLoginButtonText() {
        assertEquals("Logga in", driver.findElement(By.tagName("button")).getText());
    }
}
