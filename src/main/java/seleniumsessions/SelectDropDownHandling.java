package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {
	
	static WebDriver driver ;

	public static void main(String[] args) throws InterruptedException {

		// drop down --htmltag:<select>---<option>
		// Use Select class
		// single selection
		// multi selection

	   driver = new ChromeDriver();
		driver.get("https://orangehrm.com/30-day-free-trial");
		

		By country = By.id("Form_getForm_Country");
//		WebElement country_ele=driver.findElement(country);
//
//		Select select = new Select(country_ele);
//	    select.selectByIndex(5);//month 1 to 12
//		Thread.sleep(1000);
//		select.selectByVisibleText("Brazil");
//		Thread.sleep(1000);
//		select.selectByValue("India");
		
		
		doSelectDropDownByIndext(country, 5);
		doSelectDropDownByVisibleText(country, "Brazil");
		doSelectDropDownByValue(country, "India");
		
		
		driver.quit();
	}

	public static WebElement getElement(By locator) {
		
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownByIndext(By locator,int index) {
		
		Select select=new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropDownByVisibleText(By locator,String visibleText) {
		
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
public static void doSelectDropDownByValue(By locator,String value) {
		
		Select select=new Select(getElement(locator));
		select.selectByValue(value);
	}
	
}
