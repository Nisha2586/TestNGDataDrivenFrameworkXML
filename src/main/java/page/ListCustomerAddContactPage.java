package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerAddContactPage extends BasePage {
	WebDriver driver;

	public ListCustomerAddContactPage(WebDriver driver) {
		this.driver = driver;
	}

//DashBoardPage
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_HEADER_PAGE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")
	WebElement CUSTOMER_SIDEMENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMER_ELEMENT;
	// ListCustomerPage
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement LIST_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]")
	WebElement LIST_CUSTOMER_ADD_CUSTOMER_ELEMENT;
	// ListCustomerAddCustomerPage
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULLNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_NUMBER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SUBMIT_BUTTON_ELEMENT;
	@FindBy(how=How.XPATH,using="//*[@id=\"summary\"]")WebElement ADDED_CUSTOMER_SUMMARY_ELEMENT;
	
	//ListCustomerProfilePage

	//DashBoardPage
	public void explicitWaitForDashBoardHeader(int timeInSec) {
		explicitWait(driver, timeInSec, DASHBOARD_HEADER_PAGE_ELEMENT);

	}

	public void verifydashboardpage() {
		Assert.assertEquals(DASHBOARD_HEADER_PAGE_ELEMENT.getText(), "Dashboard", "Dashboard page not found.");
	}

	public void clickcustomermenu() {
		CUSTOMER_SIDEMENU_ELEMENT.click();
	}

	public void clickListCustomer() {
		LIST_CUSTOMER_ELEMENT.click();
	}

	// ListCustomerPage
	public void explicitWaitForListCustomerHeader(int timeInSec) {
		explicitWait(driver, timeInSec, LIST_CUSTOMER_HEADER_ELEMENT);

	}

	public void verifyListCustomerHeader() {
		Assert.assertEquals(LIST_CUSTOMER_HEADER_ELEMENT.getText(), "Contacts", "Wrong Page!!");
	}

	public void clickListCustomerAddCustomer() {
		LIST_CUSTOMER_ADD_CUSTOMER_ELEMENT.click();
	}
	// ListCustomerAddCustomerPage

	public String insertFullName(String FullName) {
		String generatedName = FullName + randomGenNum(999);
		FULLNAME_ELEMENT.sendKeys(generatedName);
		return generatedName;
	}

	public void selectCompantDropDown(String visibleText) {
		selectDropDownMenu(COMPANY_DROPDOWN_ELEMENT, visibleText);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys( randomGenNum(999) + email );
	}

	public void insertPhone(String phone) {
		PHONE_NUMBER_ELEMENT.sendKeys(phone+ randomGenNum(999));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}
	public void selectCountryDropDown(String visibleText) {
		selectDropDownMenu(COUNTRY_DROPDOWN_ELEMENT,visibleText);
	}
	public void clickSubmitButton() {
		SUBMIT_BUTTON_ELEMENT.click();
	}
	//AddedCustomerPage
	public void explicitWaitForAddedCustomerSummaryElement(int timeInSec) {
		explicitWait(driver, timeInSec, ADDED_CUSTOMER_SUMMARY_ELEMENT);
	}
	public void verifyAddedCustomer() {
		Assert.assertEquals(ADDED_CUSTOMER_SUMMARY_ELEMENT.getText(), "Summary", "Wrong Page!!");
	}
	
	//ListCustomerProfileCheckPage
	public void clickListCustomer2() {
		LIST_CUSTOMER_ELEMENT.click();
	}

	public void explicitWaitForListCustomerHeader2(int timeInSec) {
		explicitWait(driver, timeInSec, LIST_CUSTOMER_HEADER_ELEMENT);

	}

	public void verifyListCustomerHeader2() {
		Assert.assertEquals(LIST_CUSTOMER_HEADER_ELEMENT.getText(), "Contacts", "Wrong Page!!");
	}

	
	String before_Xpath = "//tbody/tr[";
	String after_Xpath = "]/td[3]/a[1]";
	String before_XpathForProfile = "//tbody/tr[";////tbody/tr[1]/td[3]/following-sibling::td[4]/a[1
	String after_XpathForProfile = "]/td[3]/following-sibling::td[4]/a[1]";

	public void findingAddedCustomerFullNameAndCheckingProfile(String generatedName) {
		for (int i = 1; i <= 5; i++) {
			String addedCustomerName = driver.findElement(By.xpath(before_Xpath + i + after_Xpath)).getText();
			//System.out.println(addedCustomerName);
			if (addedCustomerName.contains(generatedName)) {
				driver.findElement(By.xpath(before_XpathForProfile + i + after_XpathForProfile)).click();
			}
		}
	}
//	public void confirmingDeletion() {
//		ALERT_POPUP_ACCEPT_BUTTON.click();
//		
//	}

}
