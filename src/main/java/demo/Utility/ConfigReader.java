package demo.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;

	static {
		try (FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties")) {
			properties = new Properties();
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file.");
		}
	}

	// Method to get a property value by key
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	// Method to get an integer property value by key
	public static int getIntProperty(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}

	// Method to get a boolean property value by key
	public static boolean getBooleanProperty(String key) {
		return Boolean.parseBoolean(properties.getProperty(key));
	}
}
