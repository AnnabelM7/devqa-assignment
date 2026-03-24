import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        howManyTeams();
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

    private void howManyTeams() {
        // One way to find the numberof teams: Locate the element containing the text about teams
        WebElement teamsText = driver.findElement(
                By.xpath("//h4[text()='Our teams']/parent::div//p"));

        String text = teamsText.getText(); // Example: "100+ jobs across 12 teams"
        Pattern pattern = Pattern.compile("(\\d+)\\s+teams"); // Regular expression to extract the number of teams
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            int teamsCount = Integer.parseInt(matcher.group(1));
            System.out.println("Teams count in text: " + teamsCount);
        } else {
            System.out.println("Could not extract teams count from text: " + text);
        }

        // Another way to find the number of teams: Locate all team cards and count them
        List<WebElement> teamCards = driver.findElements(
                By.cssSelector(".teams-cards a"));

        System.out.println("Total team cards: " + teamCards.size());

        for (WebElement card : teamCards) {
            String teamName = card.findElement(By.tagName("h6")).getText();
            System.out.println(teamName);
        }

    }

    @AfterEach
    void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}