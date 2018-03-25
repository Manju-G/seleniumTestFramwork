package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import objectRepository.HomePageElements;

public class HomePage {
	WebDriver driver = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = HomePageElements.login)
	public WebElement loginLink;

	@FindBy(how = How.LINK_TEXT, using = HomePageElements.demo)
	public WebElement demoLink;

	@FindBy(how = How.CLASS_NAME, using = HomePageElements.feature)
	public WebElement featureLink;

	@FindBy(how = How.CLASS_NAME, using = HomePageElements.order)
	public WebElement orderLink;

}
