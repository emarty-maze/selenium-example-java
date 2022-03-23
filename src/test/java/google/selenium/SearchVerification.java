package google.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchVerification {

    // Create Webdriver object
    static WebDriver driver;

    // Create object for business functions
    static SearchFunctions query;

    // Make sure this runs before the first test method
    @BeforeClass
    public static void before()
    {
        driver = new ChromeDriver();
        driver.get("https://google.com");
        query = new SearchFunctions(driver);
    }

    // Make sure this runs after all test methods have run
    @AfterClass
    public static void after()
    {
        driver.quit();
        driver = null;
    }

    // Begin test method
    @Test(description = "Login to Yahoo email and assert predefined values")
    public void SearchVerifyContents()
    {
        // Search Google
        query.terms("justice league");

        // Print results
        query.resultsList();

    }
}