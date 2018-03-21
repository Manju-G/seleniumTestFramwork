package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.BaseDriverClass;

public class ScreenShotUtility implements ITestListener {
	WebDriver driver;
	String seperator = System.getProperty("file.separator");

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		String className = arg0.getInstanceName();
		String methodName = arg0.getName();
		String destPath = createFolderIfNotExist(className, "Failure");
		takeScreenshot(methodName, destPath);
	}

	private void takeScreenshot(String methodName, String destPath) {
		driver = BaseDriverClass.getDriver();
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			//System.out.println("destPath-->" + destPath + " methodName--> " + methodName);
			FileUtils.copyFile(srcfile, new File(destPath + seperator + methodName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	private String createFolderIfNotExist(String className, String result) {

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
