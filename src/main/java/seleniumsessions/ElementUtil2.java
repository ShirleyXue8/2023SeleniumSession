package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil2 {
	
	
	private WebDriver driver;
	
	
	public ElementUtil2(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void doSendKeys(By locator,String value) {
		
		getElement(locator).sendKeys(value);
	}
	
	
	public WebElement getElement(By locator) {
		
		return driver.findElement(locator);
	}
	
	
	

}
