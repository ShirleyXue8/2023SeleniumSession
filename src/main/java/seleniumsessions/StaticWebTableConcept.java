package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

			driver = new ChromeDriver();
			driver.get("https://www.w3schools.com/html/html_tables.asp");
			int rowCount=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
			List<WebElement> allTD=driver.findElements(By.xpath("//th[text()='Company']/parent::tr/following-sibling::tr/td"));
			
			
			//WebTable Traversing:
			//table[@id='customers']/tbody/tr[2]/td[1]
			//table[@id='customers']/tbody/tr[3]/td[1]
			//table[@id='customers']/tbody/tr42]/td[1]
			//table[@id='customers']/tbody/tr[5]/td[1]
			//table[@id='customers']/tbody/tr[6]/td[1]
			//table[@id='customers']/tbody/tr[7]/td[1]
			
			String beforeXpath="//table[@id='customers']/tbody/tr[";
			String afterXpath="]/td[1]";
			String afterXpath2="]/td[2]";
			String afterXpath3="]/td[3]";
			
			
			for(int row=2;row<=rowCount;row++) {
				String actXpath=beforeXpath+row+afterXpath;
//				System.out.println(actXpath);
				String companyName=driver.findElement(By.xpath(actXpath)).getText();
				System.out.println(companyName);
			}
					
			System.out.println("-----------------------");
			for(int row=2;row<=rowCount;row++) {
				String actXpath2=beforeXpath+row+afterXpath2;
				String contactName=driver.findElement(By.xpath(actXpath2)).getText();
				System.out.println(contactName);
			
				
			}
			
			
			System.out.println("-----------------------");
			for(int row=2;row<=rowCount;row++) {
				String actXpath3=beforeXpath+row+afterXpath3;
				String countryName=driver.findElement(By.xpath(actXpath3)).getText();
				System.out.println(countryName);

	}
			
		//every td
			System.out.println("----------allTD-------------");	
		for(WebElement e:allTD) {
			String text=e.getText();
			System.out.println(text);
		}
			
			
			
	}
}
