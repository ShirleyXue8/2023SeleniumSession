package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDownConcept {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		
		
		driver.findElement(By.cssSelector("input#justAnInputBox")).click();
		Thread.sleep(2000);
		
		//45 spans  --->15 spans
		List<WebElement>choiceList=driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
		
		for(WebElement e: choiceList) {
			
//			String text=e.getText();
//			System.out.println(text);
//			if(text.contains("choice 2")) {
//				e.click();
//				break;
			try {
			e.click();// after 15th choice:ElementNotInteractableException: element not interactable
			}catch(ElementNotInteractableException ex) {
				System.out.println("drop down choices are over....");
				break;
				
			}
			
		}
		driver.quit();
		}
		
		
		
	}

