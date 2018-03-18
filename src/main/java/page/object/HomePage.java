package page.object;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.LoadPropertiesFile;

public class HomePage {
	WebDriver driver = null;
	Properties properties = null;
	private final static String t_loginLink = "$$";

	{
		properties = LoadPropertiesFile.loadProperties("src/main/java/UI Maps/HomePage.properties");
		// t_loginLink = properties.getProperty("a.login").toString();
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		custom
		customPageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = t_loginLink)
	WebElement loginLink;
	@FindBy(how = How.LINK_TEXT, using = "classname")
	WebElement element;
	@FindBy(how = How.CLASS_NAME, using = "classname")
	WebElement element;

	private String getproperty(String key) {
		return properties.getProperty(key).toString();
	}
}
