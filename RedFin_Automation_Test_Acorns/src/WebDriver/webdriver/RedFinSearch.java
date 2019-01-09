package WebDriver.webdriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RedFinSearch {

    private WebDriver driver;
    private LocatorsWebDriver locator = new LocatorsWebDriver();

    public void setUp() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("version", "latest");
        capabilities.setCapability("name", "Testing Selenium");
        this.driver = new RemoteWebDriver(
                new URL(locator.WebDriver),
                capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void AcornsTest() throws Throwable {
        System.setProperty(locator.ChromeDriver, locator.FileDirectory);
        WebDriver driver = new ChromeDriver();
        driver.get(locator.RedFinURL);
        //Entering Search Criteria
        driver.findElement(By.xpath(locator.SearchCriteria)).sendKeys("Irvine, CA", Keys.ENTER);
        //Can not proceed without implicit wait here.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Clicks minimum price range.
        driver.findElement(By.xpath(locator.MinimumPriceButton)).click();
        //Clicks price value
        driver.findElement(By.xpath(locator.SelectMinimumPrice)).click();
        //Clicks maximum price range.
        driver.findElement(By.xpath(locator.MaximumPriceButton)).click();
        //Clicks price value
        driver.findElement(By.xpath(locator.SelectMaximumPrice)).click();
        //Clicks 'Filters' button
        driver.findElement(By.xpath(locator.FilterButton)).click();
        //Selects number of baths.
        driver.findElement(By.xpath(locator.NumberOfBathsButton)).click();
        driver.findElement(By.xpath(locator.SelectNumberOfBaths)).click();
        //Selects number of beds.
        driver.findElement(By.xpath(locator.NumberOfBedsButton)).click();
        driver.findElement(By.xpath(locator.SelectNumberOfBeds)).click();
        //Clicks 'Apply Filters' button.
        driver.findElement(By.xpath(locator.SelectApplyFiltersButton)).click();
        //Clicks filtered selection.
        driver.findElement(By.xpath(locator.SelectListingOption)).click();
        //Verifying the number of beds.
        String beds = driver.findElement(By.xpath(locator.NumberOfBedsElement)).getText();
        Assert.assertTrue("Beds listing does not match search criteria!", beds.contains("1"));
        System.out.println(beds);
        //Verifying the number of baths.
        String bath = driver.findElement(By.xpath(locator.NumberOfBathsElement)).getText();
        Assert.assertTrue("Baths listing does not match search criteria!", bath.contains("1"));
        System.out.println(bath);
        //Verifying price listing.
        String price = driver.findElement(By.xpath(locator.ListingPriceElement)).getText();
        Assert.assertTrue("Price listing does not match search criteria!", price.contains("319,000"));
        System.out.println(price);
    }
}
