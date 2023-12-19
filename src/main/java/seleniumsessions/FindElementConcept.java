package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//create the webelement +perform an action(click,sendkeys,getText,isDisplayed)
//        driver.findElement(By.id("input-email11111")).sendKeys("test@gmail.com");
        
        //NoSuchElementException: no such element: Unable to locate element
	
      //  driver.findElement(By.id("input-email")).sendKeys(null);
        //IllegalArgumentException:Keys to send should be a not null CharSequence
        
		//sendKeys: String,stringbuilder,stringbuffer
		StringBuilder sb=new StringBuilder("test");
//		driver.findElement(By.id("input-email")).sendKeys(sb);
		
		driver.findElement(By.id("input-email")).sendKeys(sb+"automation");
		
		//CharSequence(I)<----string,stringbuilder,stringbuffer
		

        
        
	}

}
