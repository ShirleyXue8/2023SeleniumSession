package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementList {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		List<WebElement> linksList=driver.findElements(By.xpath("//aside[@id='column-right']//a"));
		System.out.println(linksList.size());
		Thread.sleep(3000);
		
		for(WebElement e:linksList) {
			String text=e.getText();
			if(text.contains("Order History")){
				e.click();
				}
			}

	}

}
