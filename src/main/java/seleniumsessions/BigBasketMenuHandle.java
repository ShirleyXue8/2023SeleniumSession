package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMenuHandle {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		

	
	By parentShopByMenu=By.xpath("(//span[text()='Shop by'])[2]");
	
	By BeveragesSecondMenu=By.linkText("Beverages");
	
	By teaThridMenu=By.linkText("Tea");
	
	By greenTeaFourthMenu=By.linkText("Green Tea");
	
	
	multiMenuHandle(parentShopByMenu, BeveragesSecondMenu, teaThridMenu, greenTeaFourthMenu);
	
	
	
//	driver.quit();
	}
	
	public static void multiMenuHandle
	(By parentMenuLocator,By firstChildMenuLocator,By secondChildMenuLocator,By thirdChildMenuLocator) throws InterruptedException {
		
		
		
		Actions act=new Actions(driver);
		
		driver.findElement(parentMenuLocator).click();
		
		Thread.sleep(1000);
		
		act.moveToElement(driver.findElement(firstChildMenuLocator)).build().perform();
		
		Thread.sleep(1000);
		
		act.moveToElement(driver.findElement(secondChildMenuLocator)).build().perform();
		
		Thread.sleep(1000);
		driver.findElement(thirdChildMenuLocator).click();
		Thread.sleep(1000);
	}
	
	
	

}
