package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage extends BasePage {
	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement LIST_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[3]/a[1]")
	WebElement ADDED_CUSTOMERS_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]")WebElement ALERT_POPUP_ACCEPT_BUTTON;

	public void explicitWaitForListCustomerHeader(int timeInSec) {
		explicitWait(driver, timeInSec, LIST_CUSTOMER_HEADER_ELEMENT);

	}

	public void verifyListCustomerHeader() {
		Assert.assertEquals(LIST_CUSTOMER_HEADER_ELEMENT.getText(), "Contacts", "Wrong Page!!");
	}

	String before_Xpath = "//tbody/tr[";
	String after_Xpath = "]/td[3]/a[1]";
	String before_XpathForDelete = "//tbody/tr[";
	String after_XpathForDelete = "]/td[1]/following-sibling::td[6]/a[2]";

	public void findingAddedCustomerFullNameAndDeleting(String generatedName) {
		for (int i = 1; i <= 5; i++) {
			String addedCustomerName = driver.findElement(By.xpath(before_Xpath + i + after_Xpath)).getText();
			if (addedCustomerName.contains(generatedName)) {
				driver.findElement(By.xpath(before_XpathForDelete + i + after_XpathForDelete)).click();
			}
		}
	}
	public void confirmingDeletion() {
		ALERT_POPUP_ACCEPT_BUTTON.click();
		
	}

}
