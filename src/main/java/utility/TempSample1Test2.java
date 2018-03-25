package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import levelOne.Sample1Test;
import pages.HomePage;
import pages.LoginPage;
import resources.BaseDriverClass;
@Listeners(TestListener.class)
public class TempSample1Test2 extends BaseDriverClass {
	private static Logger log = LogManager.getLogger(Sample1Test.class.getName());
	String url = "https://phptravels.com/demo/";
	WebDriverWait wait = null;

	@BeforeTest
	public void loadBrowser() {
		driver = initilize();
		wait = new WebDriverWait(driver, 10);
		log.info("Loading the page : " + url);
		driver.get(url);
	}

	@Test
	public void homepageTest() {
		log.info("Current title of opened browser tab : " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "PHPTRAVELS | Demo");
	}

	@Test(dependsOnMethods = "homepageTest")
	public void loginLinkTest() {
		log.info("Clicking on link login");
		HomePage homepage = new HomePage(driver);
		homepage.loginLink.click();
		// driver.findElement(By.linkText("Register")).click();
		driver = SeleniumUtility.switchWindows(driver);
		wait.until(ExpectedConditions.titleContains("Client Area - PHPTRAVELS"));
		log.info("Current title of opened browser tab : " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Client Area1 - PHPTRAVELS");
	}

	@Test(dependsOnMethods = "loginLinkTest")
	public void checkLoginpageAndTryLogin() {
		log.info("Logging in.");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("sample", "sample", "n");
		System.out.println(loginPage.result.getText());

	}
}
