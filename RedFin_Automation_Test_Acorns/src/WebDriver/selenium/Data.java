package WebDriver.selenium;

import java.util.HashMap;

public class Data {
	private static HashMap<String, String> data = new HashMap<String, String>();
	private static int count;
	
	public void addDictionary(String key, String value) {
		data.put(key, value);
	}
	
	public String getDictionary(String key) {
		if (!data.containsKey(key))
			data.put(key, "");
		
		return data.get(key).toString();
	}
	
	public static void clearDictionary() {
		data.clear();
	}
	
	public static void incrementCount() {
		count += 1;
	}
	
	public static int getCount() {
		return count;
	}
}
