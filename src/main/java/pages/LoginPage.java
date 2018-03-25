package pages;

import objectRepository.LoginPageElements;
import utility.SeleniumUtility;

public class LoginPage {

	public static void login(String username, String password, boolean clear) {

		if (clear) {
			SeleniumUtility.enterTextWithClear(LoginPageElements.email, username);
			SeleniumUtility.enterTextWithClear(LoginPageElements.password, password);
		} else {
			SeleniumUtility.enterTextWithoutClear(LoginPageElements.email, username);
			SeleniumUtility.enterTextWithoutClear(LoginPageElements.password, password);
		}

	}
}
