package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.ListCustomerAddContactPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerAddContactTest {
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

		ListCustomerAddContactPage listCustomerAddContact = PageFactory.initElements(driver,
				ListCustomerAddContactPage.class);
		listCustomerAddContact.explicitWaitForDashBoardHeader(10);
		listCustomerAddContact.verifydashboardpage();
		listCustomerAddContact.clickcustomermenu();
		listCustomerAddContact.clickListCustomer();

		listCustomerAddContact.explicitWaitForListCustomerHeader(10);
		listCustomerAddContact.verifyListCustomerHeader();
		listCustomerAddContact.clickListCustomerAddCustomer();

		String insertedName = listCustomerAddContact.insertFullName(FullName);
		listCustomerAddContact.selectCompantDropDown(Company);
		listCustomerAddContact.insertEmail(Email);
		listCustomerAddContact.insertPhone(Phone);
		listCustomerAddContact.insertAddress(Address);
		listCustomerAddContact.insertCity(City);
		listCustomerAddContact.insertState(State);
		listCustomerAddContact.insertZip(Zip);
		listCustomerAddContact.selectCountryDropDown(Country);
		listCustomerAddContact.clickSubmitButton();

		listCustomerAddContact.explicitWaitForAddedCustomerSummaryElement(10);
		listCustomerAddContact.verifyAddedCustomer();
		
		listCustomerAddContact.clickListCustomer2();
		listCustomerAddContact.explicitWaitForListCustomerHeader2(10);
		listCustomerAddContact.verifyListCustomerHeader2();
		listCustomerAddContact.findingAddedCustomerFullNameAndCheckingProfile(insertedName);
//		listCustomerPage.confirmingDeletion();

	}

}
