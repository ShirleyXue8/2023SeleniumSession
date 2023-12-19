package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		By links = By.className("list-group-item");
		
	
	getText(links);
		
	
	}
	
	
	public static void getText(By links) {
		
		List<WebElement>linksList=driver.findElements(links);
		System.out.println(linksList.size());
		for(WebElement e:linksList) {
			String text=e.getText();
			System.out.println(text);
		}

		
	}

		
	}

