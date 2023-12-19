package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPause {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement userName = driver.findElement(By.id("input-email"));

		String value = "naveen@gmail.com";

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionsSendKeysWithPause(By locator, String value) {

		Actions act = new Actions(driver);

		char val[] = value.toCharArray();

		for (char c : val) {

			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();

		}
	}
     
}
