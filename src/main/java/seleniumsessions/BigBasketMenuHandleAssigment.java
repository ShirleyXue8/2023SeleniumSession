package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMenuHandleAssigment {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.bigbasket.com/cl/beverages/?nc=nb");

		Actions act = new Actions(driver);

		By parentMenu = By.xpath("(//span[text()='Category'])[2]");

		By firstLevelFruitMenu = By.linkText("Fruits & Vegetables");

		By secondLevelSproutsMenu = By.linkText("Cuts & Sprouts");

		By thirdLevelMenuList = By.xpath
				("//a[text()='Cuts & Sprouts']/parent::li/parent::ul/following-sibling::ul//li");
		
		By secondLevelVeggiesMenu=By.linkText("Exotic Fruits & Veggies");
		
		By thirdLevelMenuveggiesList=By.xpath("//a[text()='Exotic Fruits & Veggies']/parent::li/parent::ul/following-sibling::ul//li");
		

//		threeLevelMenuHandle(parentMenu, firstLevelFruitMenu, secondLevelSproutsMenu, thirdLevelMenuList);
		threeLevelMenuHandle(parentMenu, firstLevelFruitMenu, secondLevelVeggiesMenu, thirdLevelMenuveggiesList);
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}

	public static void threeLevelMenuHandle(By parentMenuLocator, By firstLevelFruitMenuLocator,
			By secondLevelSproutsMenuLocator, By thirdLevelMenuListLocator) {

		Actions act = new Actions(driver);

		WebElement parentMenu = getElement(parentMenuLocator);

		act.click(parentMenu).perform();

		WebElement firstLevelFruitMenu = getElement(firstLevelFruitMenuLocator);

		act.moveToElement(firstLevelFruitMenu).build().perform();

		WebElement secondLevelSproutsMenu = getElement(secondLevelSproutsMenuLocator);
		act.moveToElement(secondLevelSproutsMenu).perform();

		String text = secondLevelSproutsMenu.getText();
		System.out.println(text);

		List<WebElement> thirdLevelMenuList = getElements(thirdLevelMenuListLocator);
		for (WebElement e : thirdLevelMenuList) {

			String textList = e.getText();
			System.out.println(textList);
		}

	}

}
