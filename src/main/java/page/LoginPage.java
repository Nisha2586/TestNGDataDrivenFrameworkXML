package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;

	public  LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

//WebElement
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")
	WebElement SIGN_IN_BUTTON;
	@FindBy(how=How.XPATH,using="//*[@id=\"page-wrapper\"]/div[2]/div/h2")WebElement DASHBOARD_HEADER_ELEMENT;

//Intractable Methods
	public void insertValidUserName(String UserName) {
		USER_NAME_ELEMENT.sendKeys(UserName);
	}

	public void insertValidPassword(String Password) {
		PASSWORD_ELEMENT.sendKeys(Password);
	}

	public void clickSingninButton() {
		SIGN_IN_BUTTON.click();

	}
	public void verifyDashboardHeader() {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), " Dashboard ", "wrong page");
	}
}
