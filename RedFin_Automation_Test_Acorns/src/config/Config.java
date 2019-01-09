package config;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Config {
	Properties prop;
	String filePath = null;

	public Config(String file)
	{
		filePath = file;
		prop = new Properties();
	}

	public String BaseURL() throws Throwable
	{
		String baseURL = null;
		prop.load(new FileReader(new File(System.getProperty("user.dir")+filePath)));
		baseURL = prop.getProperty("baseurl");
		return baseURL;
	}

	public String BrowserType() throws Throwable
	{
		String browserType = null;
		prop.load(new FileReader(new File(System.getProperty("user.dir")+filePath)));
		browserType = prop.getProperty("browser");
		return browserType;
	}

	public String getParam(String key) throws Throwable
	{
		String value = null;
		prop.load(new FileReader(new File(System.getProperty("user.dir")+filePath)));
		value = prop.getProperty(key);
		return value;
	}
}
