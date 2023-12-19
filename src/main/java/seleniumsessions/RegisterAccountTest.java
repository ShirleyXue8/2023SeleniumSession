package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccountTest {

	public static void main(String[] args) {

		
		
		BrowserUtil2 br2=new BrowserUtil2();
		WebDriver driver=br2.launchBrowser("chrome");
        br2.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		String title=br2.getPageTitle();
		System.out.println(title);
		
		By firstName=By.id("input-firstname");
		By lastName=By.id("input-lastname");
		By email=By.id("input-email");
		By pNumber=By.id("input-telephone");
		By pwd=By.id("input-password");
		By conpwd=By.id("input-confirm");
		
		ElementUtil2 eU2=new ElementUtil2(driver);
		eU2.doSendKeys(firstName, "Shirley");
		eU2.doSendKeys(lastName, "Xue");
		eU2.doSendKeys(email, "shirley@gmail.com");
		eU2.doSendKeys(pNumber, "703333444");
		eU2.doSendKeys(pwd, "123test");
		eU2.doSendKeys(conpwd, "123test");
		
		
		
		
		
	}

}
