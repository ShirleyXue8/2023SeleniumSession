package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	static WebDriver driver;

	public static void main(String[] args) {

		// right click ---context click
		// context menu

		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		

		By rightClickField = By.cssSelector("span.context-menu-one");
		By List = By.cssSelector("li.context-menu-icon");
//		rightClick(rightClickField, List, "Copy");
		rightClick(rightClickField, List, "Cut");
	
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}
	
	
	public static void rightClick(By rightClickField,By list,String value) {

		WebElement rightClick = getElement(rightClickField);

		Actions act = new Actions(driver);
		act.contextClick(rightClick).perform();

		List<WebElement> optionList = getElements(list);
		for (WebElement e : optionList) {

			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
