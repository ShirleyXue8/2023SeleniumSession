package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();//browser -chrome
		
		//page
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(null));
		
		
	}

}
