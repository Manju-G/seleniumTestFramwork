package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private static Logger log = LogManager.getLogger(TestListener.class.getName());

	public void onFinish(ITestContext arg0) {
	}

	public void onStart(ITestContext arg0) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {
		String className = arg0.getInstanceName();
		String methodName = arg0.getName();
		log.error("Testscase \"" + methodName + "\" of testcase \"" + className + "\" failed.");
		String destPath = ScreenShotUtility.createFolderIfNotExist(className, "Failure");
		ScreenShotUtility.takeScreenshot(methodName, destPath);
	}

	public void onTestSkipped(ITestResult arg0) {
		log.error("Testscase \"" + arg0.getName() + "\" of testcase \"" + arg0.getInstanceName()
				+ "\" finished and skipped.");
	}

	public void onTestStart(ITestResult arg0) {
		log.error("Executing of testscase \"" + arg0.getName() + "\" of testcase \"" + arg0.getInstanceName()
				+ "\" started.");
	}

	public void onTestSuccess(ITestResult arg0) {
		log.error("Executing of testscase \"" + arg0.getName() + "\" of testcase \"" + arg0.getInstanceName()
				+ "\" finished and success.");
	}

}
