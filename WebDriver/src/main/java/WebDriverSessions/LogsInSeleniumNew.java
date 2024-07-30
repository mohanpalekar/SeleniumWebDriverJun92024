package WebDriverSessions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsInSeleniumNew {
	
	public static void main(String[] args) {
		
		Logger logger = LogManager.getLogger(LogsInSeleniumNew.class);
		
		logger.info("info");
		logger.error("error");
		logger.warn("warn");
		logger.fatal("fatal");
		logger.debug("debug");
		logger.trace("trace");
		logger.info("info");
	}

}
