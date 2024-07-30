package WebDriverSessions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesExampleInSelenium {

	public static void main(String[] args) throws IOException {
		
		Logger logger = LogManager.getLogger(PropertiesExampleInSelenium.class);
		
		File file = new File("src/main/resources/test.properties");
		
		FileReader reader = new FileReader(file);
		
		Properties properties = new Properties();
		
		properties.load(reader);
		
		logger.info(properties.getProperty("username"));
		logger.info(properties.getProperty("url"));
		

	}

}
