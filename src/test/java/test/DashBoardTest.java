package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class DashBoardTest {
	WebDriver driver;

	// @Test
	@Parameters({ "UserName", "Password" })

	public void ValidUserShouldBeAbleToAccessAddCustomerMenu(String UserName, String Password) {
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
		addcontactpage.verifyaddcontactpage();

	}

}
