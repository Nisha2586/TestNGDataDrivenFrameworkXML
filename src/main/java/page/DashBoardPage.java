package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashBoardPage extends BasePage {
	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_HEADER_PAGE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")
	WebElement CUSTOMER_SIDEMENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADDCUSTOMER_ELEMENT;

	public void explicitWaitForDashBoardHeader(int timeInSec) {
		explicitWait(driver, timeInSec, DASHBOARD_HEADER_PAGE_ELEMENT);

	}

	public void verifydashboardpage() {
		Assert.assertEquals(DASHBOARD_HEADER_PAGE_ELEMENT.getText(), "Dashboard", "Dashboard page not found.");
	}

	public void clickcustomermenu() {
		CUSTOMER_SIDEMENU_ELEMENT.click();
	}

	public void clickaddcustomer() {
		ADDCUSTOMER_ELEMENT.click();
	}

}
