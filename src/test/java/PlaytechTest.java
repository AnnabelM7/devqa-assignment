import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class PlaytechTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        // Initialize Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    void playtechTasks() {
        openWebsite();
    }

    private void openWebsite() {
        // Open Playtech website
        driver.get("https://www.playtechpeople.com/");

        // Accept all cookies
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();

        // Verify that the website is opened successfully by checking the title
        WebElement h1 = driver.findElement(By.tagName("h1"));
        String actualText = h1.getText();

        assertTrue(actualText.contains("We Are Playtech People"),
                "H1 does not contain expected text. Actual: " + actualText);

    }

    @AfterEach
    void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}