package utility;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.BaseDriverClass;

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

	public static WebElement findElement(String locator) {
		WebDriver driver = BaseDriverClass.getDriver();
		WebElement element = null;
		String elementType = locator.split("=")[0].toLowerCase();
		String elementValue = locator.split("=")[1];
		switch (elementType) {
		case "id":
			element = driver.findElement(By.id(elementValue));
			break;
		case "css":
			element = driver.findElement(By.cssSelector(elementValue));
			break;
		case "classname":
			element = driver.findElement(By.className(elementValue));
			break;
		case "linktext":
			element = driver.findElement(By.linkText(elementValue));
			break;
		case "name":
			element = driver.findElement(By.name(elementValue));
			break;
		case "partiallinktext":
			element = driver.findElement(By.partialLinkText(elementValue));
			break;
		case "tagname":
			element = driver.findElement(By.tagName(elementValue));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(elementValue));
			break;
		default:
			log.fatal("Wrong elementType mapped. ElementType : " + elementType + " and ElementValue : " + elementValue);
		}

		return element;
	}

	public static void enterText(String locator, String text) {
		if (locator == null || locator.length() == 0 || locator.equals("")) {
			log.fatal("Locator is not valid.");
			return;
		}
		if (text == null) {
			log.fatal("text is null.");
			return;
		}
		log.info("Entering text.. ");
		findElement(locator).sendKeys(text);
	}

}
