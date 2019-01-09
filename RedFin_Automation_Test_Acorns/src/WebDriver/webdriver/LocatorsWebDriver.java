package WebDriver.webdriver;

public class LocatorsWebDriver {
    public static String WebDriver = "http://key:secret@hub.testingbot.com/wd/hub";
    public static String RedFinURL = "http://www.redfin.com";
    public static String ChromeDriver = "webdriver.chrome.driver";
    public static String FileDirectory = "/home/jhernandez/Automation/ChromeDriver/chromedriver2.43";
    public static String SearchCriteria = "//input[@placeholder='City, Address, School, Agent, ZIP']";
    public static String MinimumPriceButton = "//span[@class='quickMinPrice withFlyout withOptions mounted field select Select clickable']";
    public static String SelectMinimumPrice = "//span[contains(text(), '$300k')]";
    public static String MaximumPriceButton = "//span[@class='quickMaxPrice withFlyout withOptions mounted field select Select clickable']";
    public static String SelectMaximumPrice = "//span[contains(text(), '$325k')]";
    public static String FilterButton = "//div[@class='wideSidepaneFilterButtonContainer']";
    public static String NumberOfBathsButton = "//span[@role='spinbutton']/span[@data-rf-test-name='Stepper']";
    public static String SelectNumberOfBaths = "//div[@class='option']/span[contains(text(), '1')]";
    public static String NumberOfBedsButton = "//span[@class='minBeds withFlyout withOptions mounted field select Select clickable']";
    public static String SelectNumberOfBeds = "//div[@class='option']/span[contains(text(), '1')]";
    public static String SelectApplyFiltersButton = "//button[@data-rf-test-id='apply-search-options']";
    public static String SelectListingOption = "//div[@title='Photo of 100 Orange Blossom #98, Irvine, CA 92618']";
    public static String NumberOfBedsElement = "//div[@data-rf-test-id='abp-beds']/div";
    public static String NumberOfBathsElement = "//div[@data-rf-test-id='abp-baths']/div";
    public static String ListingPriceElement = "//input[@value='$319,000']";
}
