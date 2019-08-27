package tests;

import org.apache.logging.log4j.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import util.Base;

public class Listners extends Base implements ITestListener {
	
	private static Logger log = LogManager.getLogger(Listners.class.getName());

	public void onTestStart(ITestResult result) {
		log.info("Test case -> "+result.getName()+ " : verifcation start");
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test case -> "+ result.getName()+ " : PASSED");
	}

	public void onTestFailure(ITestResult result) {
		takeScreenshot(result.getName());
		log.info("Test case -> " +result.getName()+ " : FAILED, please check taken failed screenshot");
	}

	public void onTestSkipped(ITestResult result) {
		log.info("Test case -> "+ result.getName()+ " : SKIPPED");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info(result.getName()+ " : TestFailedButWithinSuccessPercentage");
	}

	public void onStart(ITestContext context) {
		log.info("Test Suite -> "+context.getName()+ " : Start ");
	}

	public void onFinish(ITestContext context) {
		log.info("Test Suite -> "+context.getName()+ " : Finish ");
	}

	
}
