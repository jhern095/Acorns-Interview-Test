package WebDriver.selenium;

import com.util.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.Config;

public class BrowserMethods {
    static WebDriver driver;
    static WebDriverWait wait;
    Data data = new Data();
    static WebDriverController webDriverController;
    Config config = new Config("/resource/config/test.properties");

    private static BrowserMethods instance = null;

    private BrowserMethods() {

    }

    public By ParamsReplace(By oldElement) throws Throwable {
        By newElement = null;
        String locator = oldElement.toString();

        while (locator.contains("{")) {
            if (locator.contains("{")) {
                int keyBegin = locator.indexOf("{");
                int keyEnd = locator.indexOf("}");

                if (!data.getDictionary(locator.substring(keyBegin + 1, keyEnd)).isEmpty())
                    locator = locator.replace("{" + locator.substring(keyBegin + 1, keyEnd) + "}", data.getDictionary(locator.substring(keyBegin + 1, keyEnd)));
                else
                    throw new Exception("The {" + locator.substring(keyBegin + 1, keyEnd) + "} does not exist as a stored value!");
            }
        }

        if (locator.contains("By.xpath: "))
            locator = locator.substring(10);

        newElement = By.xpath(locator);
        return newElement;
    }

    //Launches Browser
    public void BrowserLaunch() {
        try {
            webDriverController = WebDriverController.getInstance();
            driver = WebDriverController.driver;
            wait = new WebDriverWait(driver, 30);
            driver.manage().window().maximize();
            driver.get(config.BaseURL());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}







