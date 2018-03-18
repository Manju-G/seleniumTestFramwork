package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import UIMaps.LoginPageElements;

public class LoginPage {

	public WebDriver driver = null;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = LoginPageElements.email)
	public WebElement email;
	@FindBy(how = How.CSS, using = LoginPageElements.password)
	public WebElement password;
	@FindBy(how = How.CSS, using = LoginPageElements.remember)
	public WebElement remember;
	@FindBy(how = How.CSS, using = LoginPageElements.login)
	public WebElement login;
	@FindBy(how = How.CSS, using = LoginPageElements.forgetpassword)
	public WebElement forgetpassword;
	@FindBy(how = How.CSS, using = LoginPageElements.register)
	public WebElement register;
	@FindBy(how = How.CSS, using = LoginPageElements.storeMenuOption)
	public WebElement storeMenuOption;
	@FindBy(how = How.CSS, using = LoginPageElements.storeMenusubOption)
	public WebElement storeMenusubOption;
	@FindBy(how = How.CSS, using = LoginPageElements.result)
	public WebElement result;

	public void login(String username, String password, String remember) {
		email.clear();
		this.password.clear();
		email.sendKeys(username);
		this.password.sendKeys(password);
		if (remember != null) {
			if (remember.equalsIgnoreCase("yes")) {
				this.remember.click();
			}
		}
		login.click();
	}
}
