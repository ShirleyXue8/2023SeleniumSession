package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.get("https://www.amazon.com");

		// webelement +perform action(getAttribute)

		By emailId = By.id("input-email");
		By passwordId = By.id("input-password");
		By registerLink = By.linkText("Register");
		By img=By.xpath("//*[@id=\"CardInstanceju8WGiM8ZkLO9cmlKvccsw\"]/a/div[1]/div/img");

//		String placeholderVal= driver.findElement(emailId).getAttribute("placeholder");
//		System.out.println(placeholderVal);
//		
//		String hrefVal=driver.findElement(registerLink).getAttribute("href");
//		System.out.println(hrefVal);
//		
//		String className=driver.findElement(registerLink).getAttribute("class");
//		System.out.println(className);

//		driver.findElement(emailId).sendKeys("tom@gmail.com");
//		String text = driver.findElement(emailId).getAttribute("value");
//		System.out.println(text);
//
//		driver.findElement(passwordId).sendKeys("test@123");
//		String pwdValue = driver.findElement(passwordId).getAttribute("value");
//		System.out.println(pwdValue);
	
//		String placeholderVal=doGetElementAttribut(emailId, "placeholder");
//		System.out.println(placeholderVal);
//		
//		String hrefVal=doGetElementAttribut(registerLink, "href");
//		System.out.println(hrefVal);
//		
//		String value=doGetElementAttribut(emailId, "value");
//		System.out.println(value);
		
		String alt=doGetElementAttribut(img, "alt");
		System.out.println(alt);
		
		
		String src=doGetElementAttribut(img, "src");
		System.out.println(src);
		
		

	}
	
	public static String doGetElementAttribut(By locator,String attrName) {
		
		return getElement(locator).getAttribute(attrName);
	}
	

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

}
