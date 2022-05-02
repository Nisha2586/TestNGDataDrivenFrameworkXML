package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	WebDriver driver;
	
	@Test
	@Parameters({"UserName","Password"})
	public void validUserShouldAbleToLogin(String UserName,String Password) {
		driver=BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertValidUserName(UserName);
		loginPage.insertValidPassword(Password);
		loginPage.clickSingninButton();
		
	}

}
