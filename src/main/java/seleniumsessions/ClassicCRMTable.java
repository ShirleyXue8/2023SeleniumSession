package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassicCRMTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");

		Thread.sleep(3000);

		driver.findElement(By.name("username")).sendKeys("apiautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(3000);

		driver.switchTo().frame("mainpanel");

		Thread.sleep(2000);

		driver.findElement(By.linkText("CONTACTS")).click();
		
		
		
		selectUser("Abrar Zahin");
		String companyName=getUserCompany("Abrar Zahin");
		System.out.println(companyName);
		String phone=getPhoneNumber("Abrar Zahi");
		System.out.println(phone);
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}
	
	public static void selectUser(String userName) {
	
	driver.findElement
	(By.xpath("//a[text()='"+userName+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();

	
	}
	
	public static String getUserCompany(String userName) {
	
		return
				driver.findElement(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td/a[@context='company']")).getText();
		
	}
	
	public static String getPhoneNumber(String userName) {
		return
		driver.findElement
		(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td/span[1]")).getText();
	}

}
