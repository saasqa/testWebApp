package util;

import static org.testng.Assert.assertTrue;

import pageObjectRepository.IndexPage;

public class Utility extends Base {

	static IndexPage i = new IndexPage(driver);

	// Method for verifying footer text
	public static void VerifyFooterText() {
		boolean footer_text = i.footerText().getText().equalsIgnoreCase(readPropertiesFile("footerText"));
		assertTrue(footer_text, "Footer text is not showing as per specification");
	}

	// Method for verifying logo text
	public static void VerifyLogoText() {
		boolean logo_Text = i.logoText().getText().equalsIgnoreCase(readPropertiesFile("logoText"));
		assertTrue(logo_Text,
				"logo text is showing " + i.logoText().getText() + " instead of " + readPropertiesFile("logoText"));
	}

}