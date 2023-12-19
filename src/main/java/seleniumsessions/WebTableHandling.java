package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
//		List<WebElement> checkBox=driver.findElements(By.xpath("//input[contains(@id,'ohrmList_chkSelectRecord')]"));
//		System.out.println(checkBox.size());
//       for(WebElement e:checkBox) {
//    	   e.click();
//    
//       }
//      
//		selectUser("Joe.Root");
//		selectUser("John.Smith");
		
		List<String>joeDetails=selectUserInfor("Joe.Root");
		System.out.println(joeDetails);
		
		
		//classic CRM"
		//a[text()='Robby Sing']/parent::td/preceding-sibling::td/input[@type='checkbox']
		//a[text()='tom king']/parent::td//following-sibling::td//a[@context='company']

		// a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']
		// a[text()='John.Smith']/parent::td/preceding-sibling::td/input[@type='checkbox']
	}

	public static void selectUser(String userName) {
		driver.findElement(
					By.xpath("//a[text()='"+userName+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).
		click();
	}
	
	public static List<String> selectUserInfor(String userName) {
	List<WebElement> colEles=driver.
			findElements(By.xpath("//a[text()='"+userName+"']/parent::td//following-sibling::td"));
	List<String> colValueList=new ArrayList<String>();
	for(WebElement e:colEles) {
		String text=e.getText();
		colValueList.add(text);
	}
	return colValueList;
	}
}
