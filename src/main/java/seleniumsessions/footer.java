package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class footer {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		List<WebElement> footList=driver.findElements(By.className("list-unstyled"));
	     System.out.println(footList.size());	
	     for(WebElement e:footList) {
	    	String text= e.getText();
	    	System.out.println(text);
	     }
	
		
	

	}
	

		
	}


