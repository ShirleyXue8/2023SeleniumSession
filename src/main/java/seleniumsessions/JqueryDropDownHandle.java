package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDownHandle {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectmenu/");
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("span#speed-button")).click();
		Thread.sleep(2000);
		
		List<WebElement> optionList=driver.findElements(By.cssSelector("ul#speed-menu div"));
	
		
		System.out.println(optionList.size());
		
		for(WebElement e:optionList) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals("Fast")) {
				e.click();
				break;
			}
			}
		
		driver.findElement(By.cssSelector("span#files-button")).click();
		List<WebElement>optionList1=driver.findElements(By.cssSelector("ul#files-menu div"));
		
		for(WebElement e:optionList1) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals("Some unknown file")) {
				e.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span#number-button")).click();
		List<WebElement>optionList2=driver.findElements(By.cssSelector("ul#number-menu div"));
		for(WebElement e:optionList2) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals("2")) {
				e.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector("span#salutation-button")).click();
		List<WebElement>optionList3=driver.findElements(By.cssSelector("ul#salutation-menu div"));
		for(WebElement e:optionList3) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals("Prof.")) {
				e.click();
				break;
			}
		}
		
		driver.quit();
	}
	
	

}
