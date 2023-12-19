package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	
	static WebDriver driver;
	public static void main(String[] args) {

		// ExplicitWait:
		// concept of dynamic wait for the specific element/non webelement
		// on the basis of some expected conditions
		
		 driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId=By.id("input-email11");
		By password=By.id("input-password");
		By loginButton=By.xpath("//input[@value='Login']");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement email_ele=wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		email_ele.sendKeys("test@gmail.com");
		
		
		//10 secs:
		//2 secs:
		//ingored: 8 secs
		
		//after secs also element is not present: TimeOutException +NoSuchelement exception
		
		driver.findElement(password).sendKeys("test@123");
		driver.findElement(loginButton).click();
		
		
		
		
		
	}
	
	public static WebElement waitForPresentOfElement(By locator,int timeOut) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	

}
	
public static WebElement waitForVisiblityOfElement(By locator,int timeOut) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	

}
	
	
}
