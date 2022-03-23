package google.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchFunctions {

    // Create Webdriver instance
    static WebDriver driver;

    // Constructor class
    public SearchFunctions(WebDriver driver) {

        SearchFunctions.driver = driver;

    }

    // Email login function
    public void terms(String term) {

        driver.findElement(By.name("q")).sendKeys(term);
        driver.findElement(By.name("btnK")).submit();

        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.textToBePresentInElementLocated(
                        By.id("result-stats"), "results")
                );

    }

    // Get list of results and print
    public void resultsList() {

        List<WebElement> latestResults = driver.findElements(By
                                        .id("search"));

        for (WebElement subName : latestResults) {
            List<WebElement> res = subName.findElements(By.className("g"));

            for (int j = 1; j < res.size(); j++) {
                String restext = res.get(j).getText();
                System.out.println(restext);
            }
        }
    }

    // Pause helper function
    public void waitForElement()
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
