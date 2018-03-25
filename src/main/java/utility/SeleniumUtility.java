package utility;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.BaseDriverClass;
import utility.Enumerations.selectionType;

public class SeleniumUtility {
	private static Logger log = LogManager.getLogger(SeleniumUtility.class.getName());
	private static WebDriver driver = BaseDriverClass.getDriverInstance();

	public static String switchWindows() {
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
		return currentTab;
	}

	public static WebElement findElement(String locator) {
		WebDriver driver = BaseDriverClass.getDriverInstance();
		WebElement element = null;
		int begin = locator.indexOf('=') + 1;
		String elementType = locator.split("=")[0].toLowerCase();
		String elementValue = locator.substring(begin);
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

	public static void enterTextWithClear(String locator, String text) {
		if (locator == null || locator.length() == 0 || locator.equals("")) {
			log.fatal("Locator is not valid.");
			return;
		}
		if (text == null) {
			log.fatal("text is null.");
			return;
		}
		WebElement element = findElement(locator);
		log.info("Clearing the text.. ");
		element.clear();
		log.info("Entering text.. ");
		element.sendKeys(text);
	}

	public static void enterTextWithoutClear(String locator, String text) {
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

	public static void clickOnElement(String locator) {
		log.info("Clicking on element");
		findElement(locator).click();
	}

	public static String getTitle() {
		log.info("Getting the current page title.");
		return driver.getTitle();
	}

	public static void switchTowindow(String oldTab) {
		log.info("Switching windows as per request.");
		driver.switchTo().window(oldTab);

	}

	public static void selectFromDropDown(String element, String data, selectionType type) {
		log.info("Selecting the " + data + " in drop down with " + type + ".");
		Select select = new Select(findElement(element));
		switch (type) {
		case INDEX:
			select.selectByIndex(Integer.parseInt(data));
			log.info("Selected based on index.");
			break;
		case VALUE:
			select.selectByValue(data);
			log.info("Selected based on value.");
			break;
		case VISABLETEXT:
			select.selectByVisibleText(data);
			log.info("Selected based on VisableText.");
		default:
			break;
		}

	}

	public static void deselectFromDropDown(String element, String data, selectionType type) {
		log.info("DeSelecting the " + data + " in drop down with " + type + ".");
		Select select = new Select(findElement(element));
		switch (type) {
		case INDEX:
			select.deselectByIndex(Integer.parseInt(data));
			log.info("DeSelected based on index.");
			break;
		case VALUE:
			select.deselectByValue(data);
			log.info("DeSelected based on value.");
			break;
		case VISABLETEXT:
			select.deselectByVisibleText(data);
			log.info("DeSelected based on VisableText.");
		default:
			break;
		}
	}

}