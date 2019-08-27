package pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	public WebDriver driver;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// footer text
	@FindBy(xpath = "/html/body/div[3]/footer/p")
	WebElement footer;

	public WebElement footerText() {
		return footer;
	}

	//logo text
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/a")
	WebElement logo;

	public WebElement logoText() {
		return logo;
	}

}
