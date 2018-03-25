package levelOne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import resources.BaseTestClass;
import utility.SeleniumUtility;
import utility.Enumerations.selectionType;

public class Sample1Test extends BaseTestClass {
	private static Logger log = LogManager.getLogger(Sample1Test.class.getName());
	private static String oldTab = null;

	@Test(priority = 0)
	public void homepageTest() {
		String title = SeleniumUtility.getTitle();
		log.info("Current title of opened browser tab : " + title);
		Assert.assertEquals(title, "PHPTRAVELS | Demo");
	}

	@Test(priority = 1)
	public void loginLinkTest() {
		log.info("Clicking on link login");
		HomePage.clicklogin();
		oldTab = SeleniumUtility.switchWindows();
		wait.until(ExpectedConditions.titleContains("Client Area - PHPTRAVELS"));
		String title = SeleniumUtility.getTitle();
		log.info("Current title of opened browser tab : " + title);
		Assert.assertEquals(title, "Client Area - PHPTRAVELS");
	}

	@Test(priority = 2)
	public void checkLoginpageAndTryLogin() {
		log.info("Logging in.");
		LoginPage.login("user@phptravels.com", "demouser", true);
		// System.out.println(loginPage.result.getText());

	}

	@Test(priority = 3)
	public void switchBackToHomePage() {
		SeleniumUtility.switchTowindow(oldTab);
		SeleniumUtility.selectFromDropDown("", "", selectionType.INDEX);
	}
}
