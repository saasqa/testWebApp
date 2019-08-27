package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Base;
import util.Utility;

public class TestWebApp extends Base {
	
	private static Logger log = LogManager.getLogger(TestWebApp.class.getName());
	
	@BeforeTest
	public void openBrowser() {
		launchBrowser();
		navigateToURL();
	}
	
	@Test
	public void testCase1_VerifyfooterText() {
		log.info("verifying footer text");
		Utility.VerifyFooterText();
	}
	
	@Test
	public void testCase2_VerifyLogo() {
		log.info("verifying logo text");
		Utility.VerifyLogoText();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	

}
