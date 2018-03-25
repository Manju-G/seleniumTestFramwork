package pages;

import objectRepository.HomePageElements;
import utility.SeleniumUtility;

public class HomePage {

	public static void clicklogin() {
		SeleniumUtility.clickOnElement(HomePageElements.login);
	}
}
