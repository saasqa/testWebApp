package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;

	public void launchBrowser() {
		if (readPropertiesFile("borwserName").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readPropertiesFile("PathofChromeDriver"));
			driver = new ChromeDriver();
		} else if (readPropertiesFile("borwserName").equalsIgnoreCase("firefox")) {
			// need to write
		} else if (readPropertiesFile("borwserName").equalsIgnoreCase("ie")) {
			// need to write
		} else {
			System.out.println("Please give proper name of browser");
		}

		driver.manage().window().maximize();
	}

	public void navigateToURL() {
		driver.get(readPropertiesFile("USStageURL"));
	}

	public static String readPropertiesFile(String value) {
		Properties prop = new Properties();

		FileInputStream file = null;
		try {
			file = new FileInputStream("src//main//java//config//config.properties");
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error is " + e);

		}
		return prop.getProperty(value);

	}

	public static void waitFor10Seconds() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void takeScreenshot(String testCaseName) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("FailedTestCasesScreenShots//" + testCaseName + "_Screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void switchToAlert() {
		driver.switchTo().alert();
	}

}
