package resources;

import java.io.File;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.LoadPropertiesFile;

public class BaseDriverClass {
	public static WebDriver driver = null;
	private static Logger log = LogManager.getLogger(BaseDriverClass.class.getName());
	String currentPath = System.getProperty("user.dir");
	File driverrPath = new File("src/main/java/Config Files/drivers");

	public WebDriver initilize() {
		String path = "src/main/java/Config Files/PathFile.properties";
		log.info("Started loading the driver");
		Properties properties = LoadPropertiesFile.loadProperties(path);
		String browser = properties.getProperty("browser");
		if (!driverrPath.isDirectory()) {
			log.fatal("Directory " + driverrPath.getAbsolutePath() + " not exist.");
		}
		if (browser.equals("chrome")) {
			if (!new File(driverrPath.getAbsolutePath() + "/chromedriver_win.exe").exists()) {
				log.fatal("chromedriver_win.exe not exist in path " + driverrPath.getAbsolutePath());
			}
			System.setProperty("webdriver.chrome.driver", driverrPath.getAbsolutePath() + "/chromedriver_win.exe");
			log.info("Loading the Chrome browser.");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			if (!new File(driverrPath.getAbsolutePath() + "/geckodriver_win64.exe").exists()) {
				log.fatal("geckodriver_win64.exe not exist in path " + driverrPath.getAbsolutePath());
			}
			System.setProperty("webdriver.gecko.driver", driverrPath.getAbsolutePath() + "/geckodriver_win64.exe");
			log.info("Loading the Firefox browser.");
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			if (!new File(driverrPath.getAbsolutePath() + "/MicrosoftWebDriver.exe").exists()) {
				log.fatal("MicrosoftWebDriver.exe not exist in path " + driverrPath.getAbsolutePath());
			}
			System.setProperty("webdriver.edge.driver", driverrPath.getAbsolutePath() + "/MicrosoftWebDriver.exe");
			log.info("Loading the Edge browser.");
			driver = new EdgeDriver();
		} else {
			log.fatal("Requested browser not exist " + browser);
		}
		return driver;
	}
	public static void main(String[] args) {
		new BaseDriverClass().initilize();
	}
}