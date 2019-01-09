package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import config.Config;

public class WebDriverController
{
	private static WebDriverController instance = null;
	public static WebDriver driver;
	Config config = new Config("/resource/config/test.properties");

	private WebDriverController() {

	}

	public static WebDriverController getInstance() {
		if(instance == null) {
			instance = new WebDriverController();
			driver = instance.setup();
		}
		return instance;
	}

	public WebDriver setup()
	{
		String browser = null;
		try {
			browser = config.BrowserType();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if(browser.toLowerCase().equals("firefox"))
		{
			System.setProperty("TestExecution.firefox.marionette", "./drivers/");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if(browser.toLowerCase().equals("chrome"))
		{
			System.setProperty("TestExecution.chrome.driver", "/home/arodarte/Desktop/GaidoHealth/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}
}
