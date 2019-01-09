package WebDriver.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.concurrent.TimeUnit;

public class WaitMethods {

    WebDriver driver = new ChromeDriver();
    private FluentWait<WebDriver> webDriverWait;


    public void WaitMethods (long maxWaitTimeInSeconds, WebDriver webDriver) {
        webDriverWait = new FluentWait<WebDriver>(webDriver);
        webDriverWait.withTimeout(maxWaitTimeInSeconds, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(250, TimeUnit.MILLISECONDS);
    }

    public FluentWait<WebDriver> getWebDriverWait() {
        return webDriverWait;
    }

    public WebElement untilElementClickable(By locator) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement untilElementClickable(WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}

