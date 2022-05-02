package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
	WebDriver driver;

	@Test
	@Parameters({ "UserName", "Password", "FullName", "Company", "Email", "Phone", "Address", "City", "State", "Zip",
			"Country" })
	public void validUserShallbeAbleToAddContact(String UserName, String Password, String FullName, String Company,
			String Email, String Phone, String Address, String City, String State, String Zip, String Country) {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertValidUserName(UserName);
		loginPage.insertValidPassword(Password);
		loginPage.clickSingninButton();
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.explicitWaitForDashBoardHeader(10);
		dashboard.verifydashboardpage();
		dashboard.clickcustomermenu();
		dashboard.clickaddcustomer();

		AddContactPage addcontactpage = PageFactory.initElements(driver, AddContactPage.class);
		addcontactpage.Explicitwaitforaddcontactpage(10);
		addcontactpage.verifyaddcontactpage();
		String insertedName=addcontactpage.insertFullName(FullName);
		addcontactpage.selectCompantDropDown(Company);
		addcontactpage.insertEmail(Email);
		addcontactpage.insertPhone(Phone);
		addcontactpage.insertAddress(Address);
		addcontactpage.insertCity(City);
		addcontactpage.insertState(State);
		addcontactpage.insertZip(Zip);
		addcontactpage.selectCountryDropDown(Country);
		addcontactpage.clickSubmitButton();
		
		addcontactpage.explicitWaitForAddedCustomerSummaryElement(10);
		addcontactpage.verifyAddedCustomer();
		addcontactpage.clickListCustomer();
		
		ListCustomerPage listCustomerPage =PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.explicitWaitForListCustomerHeader(10);
		listCustomerPage.verifyListCustomerHeader();
		listCustomerPage.findingAddedCustomerFullNameAndDeleting(insertedName);
		listCustomerPage.confirmingDeletion();

	}

}
