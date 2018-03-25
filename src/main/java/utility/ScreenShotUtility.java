package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import resources.BaseDriverClass;

public class ScreenShotUtility {
	static WebDriver driver = BaseDriverClass.getDriver();
	static String seperator = System.getProperty("file.separator");

	public static void takeScreenshot(String methodName, String destPath) {
		driver = BaseDriverClass.getDriver();
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File(destPath + seperator + methodName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String createFolderIfNotExist(String className, String result) {

		if (className == null || className.length() == 0 || className.equals("")) {
			return null;
		}
		String path = "Screenshots" + seperator + result + seperator + className;
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		return path;
	}
}
