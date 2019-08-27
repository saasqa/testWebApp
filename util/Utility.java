package util;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import pageObjectRepository.ClientSectionPage;
import pageObjectRepository.ESSTestPage_Company;
import pageObjectRepository.EmployeeUploadPage;
import pageObjectRepository.Employee_PersonalInformation;
import pageObjectRepository.Frames;
import pageObjectRepository.HomePage;
import pageObjectRepository.LoginPage;

public class Utility extends Base {

	static LoginPage lp = new LoginPage(driver);
	static Frames frm = new Frames(driver);
	static HomePage home = new HomePage(driver);
	static ClientSectionPage clientSection = new ClientSectionPage(driver);
	static ESSTestPage_Company essPage = new ESSTestPage_Company(driver);
	static Employee_PersonalInformation empPI = new Employee_PersonalInformation(driver);
	static EmployeeUploadPage empUpload = new EmployeeUploadPage(driver);
	
	// Method for login to benefit junction web site with valid credential
	public static void loginToBenefitJunctionWithValidCredential() {
		lp.enterUsername().sendKeys(readPropertiesFile("validUsername"));
		lp.enterPassword().sendKeys(readPropertiesFile("validPassword"));
		lp.clickLoginButton().click();
		
	}

	// Method for add employee details on ESS Test Company
	public static void addingNewEmployeeDeatailsToESSAndLoginAsEmployee() {
		// switch back to default frame
		frm.switchToDefaultWindowOrFrame();
		// switch to client info middle frame
		frm.switchToClientInfoSectionFrame();
		// Enter first name
		essPage.EnterFirstname().sendKeys(readPropertiesFile("EnterFirstname"));
		// Enter middle name
		essPage.EnterMiddletname().sendKeys(readPropertiesFile("EnterMiddletname"));
		// Enter last name
		essPage.EnterLastname().sendKeys(readPropertiesFile("EnterLastname"));
		// Enter Date of Birth
		essPage.SelectDateofBirth().sendKeys(readPropertiesFile("SelectDateofBirth"));
		// Enter SSN Number
		essPage.EnterSNNnumber().sendKeys(readPropertiesFile("EnterSNNnumber"));
		// Enter hire date
		essPage.SelectHireDate().sendKeys(readPropertiesFile("SelectHireDate"));
		// Enter emp id
		essPage.EnterEmployeeId().sendKeys(readPropertiesFile("EnterEmployeeId"));
		// Enter work email
		essPage.EnterWorkEmail().sendKeys(readPropertiesFile("EnterWorkEmail"));
		// Enter Job title
		essPage.JobTitle().sendKeys(readPropertiesFile("JobTitle"));
		// Enter employee class
		essPage.ClassDropDownlist().selectByVisibleText(readPropertiesFile("selectclass"));
		// Select location
		essPage.LocationDropDownlist().selectByVisibleText(readPropertiesFile("selectlocationlist"));
		// Select division
		essPage.DivisionDropDownlist().selectByVisibleText(readPropertiesFile("selectdiviiondropdownlist"));
		// Select department
		essPage.DepartmentDropDownlist().selectByVisibleText(readPropertiesFile("selectdepartdropdownlist"));
		// Select Country
		essPage.CountrytDropDownlist().selectByVisibleText(readPropertiesFile("selectcountrydropdownlist"));
		// Select status
		essPage.StatusDropDownlist().selectByVisibleText(readPropertiesFile("selectstatusdropdownlllist"));
		// Select employee type
		essPage.EmployeeTypeDropDownlist().selectByVisibleText(readPropertiesFile("selectemployeedropdownlist"));
		// Select Pay Cycle
		essPage.PayCycleDropDownlist().selectByVisibleText(readPropertiesFile("selectpaycycledropdownlist"));
		// Enter Salary
		essPage.EnterSalary().sendKeys(readPropertiesFile("salaryvalue"));
		// Enter Salary Period
		essPage.SalaryPerioddropdownlist().selectByVisibleText(readPropertiesFile("selectperioddropdownlist"));
		// Enter UserName
		essPage.EnterUserName().sendKeys(readPropertiesFile("enterusernamedisplay"));
		// Clicking on addEmployee and login as employee
		essPage.loginAsEmployee().click();
	}

	// Method for click on client link on tab navigation menu
	public static void clickOnClientLink() {
		driver.switchTo().frame(frm.topTabFrame());
		home.clientTabLink().click();
	}

	// Method for opening ESS Test Company Dashboard or Home
	public static void openingESSCompanyDashboard() {
		frm.switchToDefaultWindowOrFrame();
		frm.switchToClientInfoSectionFrame();
		clientSection.enterSearchCompanyName().sendKeys(readPropertiesFile("companyname"));
		clientSection.submitForSearchCompany().click();
		clientSection.essCompanyNameLink().click();
	}

	// Method for clicking add/search employee left navigation link
	public static void clcikingOnEmployeeSearchAndAddLink() {
		frm.switchToDefaultWindowOrFrame();
		frm.switchToLeftMenuFrame();
		essPage.employeeAdd_SearchLink().click();
	}

	// Method opening add employee page
	public static void clickingOnAddLinkUnderEmployeeSearchAndAddMenu() {
		clcikingOnEmployeeSearchAndAddLink();
		essPage.addLinkUnderEmployeeAddSection().click();
	}

	// Method for verify new employee added or not
	public static void verifyNewEmployeeDetailsAddedSuccessfully() {
		Boolean alertP = driver.findElements(By.xpath("//*[@id='popup_container']")).size() != 0;
		assertTrue(alertP, "Add new employee details successfully");
		if (alertP)
			essPage.oklinkOnAddEmployeeConfirmationPopUp().click();
		System.out.println("System added employee details successfully");
	}

	// Method for add employee personal details
	public static void addEmployeePersonalDetails() {
		// select country from dropDown
		Select country = new Select(empPI.countryDropDownOption());
		country.selectByVisibleText(readPropertiesFile("employerPI_country"));

		// select gender
		if (readPropertiesFile("employerPI_gender").equalsIgnoreCase("Male"))
			empPI.maleRadioLink().click();
		else
			empPI.femaleRadioLink().click();

		// Enter Address Line 1 field
		empPI.addressLine1TextField().sendKeys(readPropertiesFile("employerPI_AddressLine1"));

		// Enter Zip Code
		empPI.zipCodeField().sendKeys(readPropertiesFile("employerPI_zipcode"));

		// Select martial status from drop down
		Select martialStatus = new Select(empPI.maritalStatusDropDownOption());
		martialStatus.selectByVisibleText(readPropertiesFile("employerPI_maritalstatus"));

		// Tobacoo user
		if (readPropertiesFile("employerPI_tobaccouser").equalsIgnoreCase("yes"))
			empPI.yesRadioLinkForTobaccoUser().click();
		else
			empPI.noRadioLinkForTobaccoUser().click();

		// click on submit button
		empPI.submitButton().click();

	}
	
	// Method opening upload page
	public static void clickingOnUploadLinkUnderEmployeeSearchAndAddMenu() {
		clcikingOnEmployeeSearchAndAddLink();
		essPage.uploadLinkUnderEmployeeAddSection().click();
	}
	
	//Method for upload employee information type file
	public static void uploadEmployeeInformationTypeFile() {
		frm.switchToDefaultWindowOrFrame();
		frm.switchToClientInfoSectionFrame();
		//Select file type from drop down
		Select fileDropDown = new Select(empUpload.fileTypeDropDown());
		fileDropDown.selectByVisibleText("Employee Information");
		//Select transaction type from drop down
		Select transactionDropDown = new Select(empUpload.transactionTypeDropDown());
		transactionDropDown.selectByVisibleText("All");
		//Upload File
		empUpload.upload_ChooseFileLink().sendKeys("UploadFile\\Employeeinfo_TestAbc.xls");
		//click on upload file button
		empUpload.uploadButton().click();
		//click on check box of Use Email Delivery Date
		empUpload.useEmailDeliveryDateCheckBox().click();
		//click on Now radio link
		empUpload.nowRadioButton().click();
		//Checked yes radio button on 
		empUpload.processChangesResultTermination_YES().click();
		empUpload.checkBenefitTerminalEmailBox().click();
		empUpload.checkOffActivationEmailBox().click();
		empUpload.finishButton().click();
		driver.switchTo().alert().accept();
	}
	
	//Method to verify file uploaded successfully or not
	public static void verifyFileUploadedSuccessfullyOrNot() {
		//Click on previous upload radio link
		empUpload.previousUploadRadioLink().click();
		String fileUploadStatus = empUpload.fileUploadStatus().getText();
		assertTrue(fileUploadStatus.equalsIgnoreCase("Running"), "file is not uploaded");
	}
	

}
