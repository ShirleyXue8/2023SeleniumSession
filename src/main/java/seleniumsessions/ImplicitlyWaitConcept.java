package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// Implicity Wait:
		// dynamic wait
		// globle wait: its applied

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit,s)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// selenium 4.x

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.id("input-email11")).sendKeys("test@gmail.com");

		// e1 --->10 secs ---> 2 secs: 8 secs
		// e1 --->10 secs --->10 secs:nosuchelement exception

		// e2
		// e3
		// e4
		// e50

		// home page: 20 secs:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// e51, e52:20secs

		// login page:
		// e1: 20 secs

		// login page:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// register page:5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// page: 0 secs: nullification of imp wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		// login page: 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// emailId: 10 secs: 2 secs: 8 secs will be ignored
		// password: 10 secs: 0 secs: 10 secs will be ignored
		// login button:10 secs: 0 secs: 10 secs will be ignored

		// to optimize the wait: explicit wait: for the specific element
		// emailId: 10 secs: 2 secs: 8 secs will be ignored
		// password: no wait applied
		// login button:no wait applied
		
		//imp wait can not be used with non web elements(elerts,title,url)\
		//exp wait can be used for non web elements
		
		
		//alert: 5 secs
		//driver.switchto.elert();

	}
}