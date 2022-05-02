package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public void explicitWait(WebDriver driver,int timeInSec,WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void selectDropDownMenu(WebElement webElement,String visibleText) {
		Select sel = new Select(webElement);
		sel.selectByVisibleText(visibleText);
	}
	public int randomGenNum(int boundaryNum) {
		Random ranNum = new Random();
		int generatedNum=ranNum.nextInt(boundaryNum);
		return generatedNum;
	}

}
