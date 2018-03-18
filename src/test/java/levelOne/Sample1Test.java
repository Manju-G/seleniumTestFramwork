package levelOne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;

import resources.BaseDriverClass;

public class Sample1Test extends BaseDriverClass {
	private static Logger log = LogManager.getLogger(Sample1Test.class.getName());
	String url = "https://phptravels.com/demo/";

	@BeforeTest
	public void loadBrowser() {
		driver = initilize();
		log.info("Loading the page : " + url);
		driver.get(url);
	}
}
