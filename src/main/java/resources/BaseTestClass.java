package resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {
	private static Logger log = LogManager.getLogger(BaseTestClass.class.getName());
	public static String url = "https://phptravels.com/demo/";
	public static WebDriverWait wait = null;

	enum selectionType {
		ID, VALUE, VISABLETEXT;
	}

	@BeforeTest
	public void loadBrowser() {
		wait = new WebDriverWait(BaseDriverClass.getDriverInstance(), 10);
		log.info("Loading the page : " + url);
		BaseDriverClass.getDriverInstance().get(url);
	}

	@AfterTest
	public void closeBrowser() {
		log.info("Closing opened browser.");
		BaseDriverClass.getDriverInstance().quit();
	}
}
