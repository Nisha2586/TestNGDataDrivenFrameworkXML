package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddContactPage extends BasePage {
	WebDriver driver;

	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElements
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")
	WebElement ADDCONTACT_HEADER_ELEMENT;
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
	@FindBy(how=How.XPATH,using="//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")WebElement LIST_CUSTOMER_ELEMENT;


	public void Explicitwaitforaddcontactpage(int time) {
		explicitWait(driver, time, ADDCONTACT_HEADER_ELEMENT);
	}

	public void verifyaddcontactpage() {
		Assert.assertEquals(ADDCONTACT_HEADER_ELEMENT.getText(), "Add Contact", "Wrong Page!!");
	}

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
	public void explicitWaitForAddedCustomerSummaryElement(int timeInSec) {
		explicitWait(driver, timeInSec, ADDED_CUSTOMER_SUMMARY_ELEMENT);
	}
	public void verifyAddedCustomer() {
		Assert.assertEquals(ADDED_CUSTOMER_SUMMARY_ELEMENT.getText(), "Summary", "Wrong Page!!");
	}
	public void clickListCustomer() {
		LIST_CUSTOMER_ELEMENT.click();
	}
	
}

