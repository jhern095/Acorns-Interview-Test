package WebDriver.selenium;


import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.WebElement;

import java.net.URL;
import java.util.List;

public class JQueryMethods {
    private static final String JQUERY_MIN_JS = "jquery.min.js";
    private static final String SELECTOR_PREFIX = "By.cssSelector: ";


    JavascriptExecutor executor = new JavascriptExecutor() {
        public Object executeScript(String s, Object... objects) {
            return null;
        }

        public Object executeAsyncScript(String s, Object... objects) {
            return null;
        }
    };

    WaitMethods defaultWait = new WaitMethods();

    public List<WebElement> execute(String expression, Object... args) {
        maybeSetupScriptingEngine();
        return (List<WebElement>) executor.executeScript(expression, args);
    }

    public Object executeJavascript(String javascript) {
        return executor.executeScript(javascript);
    }

    public Object executeJavascript(String javascript, Object arg) {
        return executor.executeScript(javascript, arg);
    }

    private Boolean sizzleLoaded() {
        JavascriptExecutor executor = this.executor;
        Boolean loaded;
        try {
            loaded = (Boolean) executor.executeScript("return jQuery()!=null");
        } catch (WebDriverException e) {
            loaded = false;
        }
        return loaded;
    }

    private void maybeSetupScriptingEngine() {
        JavascriptExecutor executor = this.executor;
        String jqueryText;
        try {
            if (!sizzleLoaded()) {
                URL jqueryUrl = Resources.getResource(JQUERY_MIN_JS);
                jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
                executor.executeScript(jqueryText);
            }
        } catch (Exception e) {
            System.out.println("System has failed");
        }
    }


    private WebElement getClickableElement(WebElement webElement) {
        if (webElement.isDisplayed() && webElement.isEnabled()) {
            return webElement;
        } else {
            return defaultWait.untilElementClickable(webElement);
        }
    }

    private String selectorAsString(By locator) {
        String rawToString = locator.toString();
        if (!rawToString.startsWith(SELECTOR_PREFIX)) {
            throw new RuntimeException(".toString() result in By locator does not match expected prefix");
        } else {
            return StringUtils.replaceOnce(rawToString, SELECTOR_PREFIX, "");
        }
    }

    void click(WebElement webElement) {
        execute("arguments[0].click();", getClickableElement(webElement));
    }
}



