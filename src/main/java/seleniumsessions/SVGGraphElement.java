package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGGraphElement {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(5000);

	}

}
