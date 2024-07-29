package WebDriverSessions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsInSelenium {

	public static void main(String[] args) {

		Logger logger = LogManager.getLogger(LogsInSelenium.class);

		logger.error("Message Info");

		logger.info("This is for information");
		logger.error("This is for error information");
		logger.warn("This is for warning information");
		logger.fatal("This is for fatal information");
	}

}
