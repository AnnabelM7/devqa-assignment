import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlaytechTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Initialize Chrome browser
        driver = new ChromeDriver();
    }

    @Test
    public void testBrowserOpens() {
        // Simple test - open Google
        driver.get("https://www.google.com");
        System.out.println("Browser opened successfully!");
        System.out.println("Page title: " + driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}