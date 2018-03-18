package utility;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SeleniumUtility {
	private static Logger log = LogManager.getLogger(SeleniumUtility.class.getName());

	public static WebDriver switchWindows(WebDriver driver) {
		String currentTab = driver.getWindowHandle();
		log.info("Current opened tab : " + currentTab + " and tile is " + driver.getTitle());
		log.info("Switching the tabs.");
		Set<String> openedTabs = driver.getWindowHandles();
		log.info("Current opened tabs count " + openedTabs.size());
		for (String string : openedTabs) {
			if (!driver.getWindowHandle().equals(string)) {
				log.info("Switched tab : " + string + " and tile is " + driver.getTitle());
				driver.switchTo().window(string);
			}
		}
		return driver;
	}

}
