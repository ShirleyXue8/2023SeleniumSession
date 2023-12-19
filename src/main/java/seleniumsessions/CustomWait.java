package seleniumsessions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		
		

	}
	
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static WebElement retryingElement(By locator,int timeOut) {
		
		WebElement element=null;
		int attempts=0;
		while(attempts<timeOut) {
			
			try {
				
				element=getElement(locator);
				System.out.println("element is found..."+locator);
				break;
			}catch(NoSuchElementException e) {
				System.out.println("element is not found..."+locator);
				try {
					Thread.sleep(500);//polling time
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			attempts++;
		}
		if(element ==null) {
			
		}
		return element;
	}
	
	
	

}
