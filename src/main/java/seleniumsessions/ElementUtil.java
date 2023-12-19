package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue) {
		By by = null;

		switch (locatorType.toLowerCase().trim()) {
		case "id":
			by = By.id(locatorValue);
			break;

		case "name":
			by = By.name(locatorValue);
			break;

		case "class":
			by = By.className(locatorValue);
			break;

		case "xpath":
			by = By.xpath(locatorValue);
			break;

		case "css":
			by = By.cssSelector(locatorValue);
			break;

		case "linktext":
			by = By.linkText(locatorValue);
			break;

		case "Paritallinxtext":
			by = By.partialLinkText(locatorValue);
			break;

		case "tag":
			by = By.tagName(locatorValue);
			break;

		default:
			System.out.println("wrong locator type is passed...." + locatorType);
			throw new AutomationException("WRONG LOCATOR TYPE");
		}

		return by;
	}

	// locatorType="id",locatorvalue="input-email",value="tom@gmail.com"
	public void doSendKeys(String locatorType, String locatorValue, String value) {

		getElement(locatorType, locatorValue).sendKeys(value);
	}

	public void doSendKeys(By locator, String value) {

		getElement(locator).sendKeys(value);
	}

	public void doClick(String locatorType, String locatorValue) {
		getElement(locatorValue, locatorValue).click();

	}

	public void doClick(By locator) {
		getElement(locator).click();

	}

	public String doGetElementAttribut(By locator, String attrName) {

		return getElement(locator).getAttribute(attrName);
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();

	}

	public String doElementGetText(String locatorType, String locatorValue) {
		return getElement(locatorType, locatorValue).getText();

	}

	public void Search(By searchField, By suggestions, String searchKey, String suggName) throws InterruptedException {

		doSendKeys(searchField, searchKey);
		Thread.sleep(3000);
		List<WebElement> suggList = getElements(suggestions);

		System.out.println(suggList.size());
		for (WebElement e : suggList) {
			String text = e.getText();

			System.out.println(text);
			if (text.contains(suggName)) {
				e.click();
				break;
			}
		}

	}

	public WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public WebElement getElement(String locatorType, String locatorValue) {

		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();// pc=0{}
		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);

			}

		}

		return eleTextList;
	}
//WAF: capture specific attribute from the list:

	public List<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();// pc=0{}
		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttrList.add(attrName);

		}

		return eleAttrList;
	}

	public int getElementsCount(By locator) {

		return getElements(locator).size();
	}

	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}
	// **************************Select drop down Utils********************//

	public Select createSelect(By locator) {

		Select select = new Select(getElement(locator));
		return select;
	}

	public void doSelectDropDownByIndext(By locator, int index) {

		createSelect(locator).selectByIndex(index);
	}

	public void doSelectDropDownByVisibleText(By locator, String visibleText) {

		createSelect(locator).selectByVisibleText(visibleText);
	}

	public void doSelectDropDownByValue(By locator, String value) {

		createSelect(locator).selectByValue(value);
	}

	public int getDropDownOptionCount(By locator) {

		List<WebElement> optionList = createSelect(locator).getOptions();
		return optionList.size();

	}

	public List<String> getDropDownOptions(By locator) {

		List<WebElement> optionList = createSelect(locator).getOptions();

		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionList) {
			String text = e.getText();
			optionsTextList.add(text);

		}
		return optionsTextList;
	}

	public void selectDropDownOption(By locator, String dropDownValue) {

		List<WebElement> optionList = createSelect(locator).getOptions();
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}

	}

	public void selectDropDownValue(By locator, String value) {

		List<WebElement> optionList = getElements(locator);
		for (WebElement e : optionList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	// *********************Actions utils*****************************//

	public void doActionsSendKeys(By locator, String value) {

		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();

	}

	public void doActionsClick(By locator) {

		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();

	}

	public void twoLevelMenu(By parentMenuLocator, By childMenuLocator) throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).build().perform();
		Thread.sleep(1000);
		doClick(childMenuLocator);
	}

	public void fourLevelMenuHandle(By parentMenuLocator, By firstChildMenuLocator, By secondChildMenuLocator,
			By thirdChildMenuLocator) throws InterruptedException {

		Actions act = new Actions(driver);

		doClick(parentMenuLocator);
		Thread.sleep(1000);

		act.moveToElement(getElement(firstChildMenuLocator)).build().perform();

		Thread.sleep(1000);

		act.moveToElement(getElement(secondChildMenuLocator)).build().perform();

		Thread.sleep(1000);
		doClick(thirdChildMenuLocator);
		Thread.sleep(1000);
	}

	public void doActionsSendKeysWithPause(By locator, String value) {

		Actions act = new Actions(driver);

		char val[] = value.toCharArray();

		for (char c : val) {

			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();

		}
	}

	// *********************Wait Utils*****************************//

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible on the page.
	 * 
	 * @param locator
	 * @param timeOUt
	 * @return
	 */
	public WebElement waitForPresenceOfElement(By locator, int timeOUt) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOUt));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible on the page.
	 * 
	 * @param locator
	 * @param timeOUt
	 * @param intervalTime
	 * @return
	 */
	public WebElement waitForPresenceOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForVisibilityOfElement(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForVisibilityOfElement(By locator, int timeOut, int intervalTime) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void doClickWithWait(By locator, int timeOut) {

		waitForVisibilityOfElement(locator, timeOut).click();

	}

	public void doSendKeysWithWait(By locator, String value, int timeOut) {

		waitForVisibilityOfElement(locator, timeOut).sendKeys(value);

	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visiblity means that the elements are not only
	 * displayed but also have a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public List<WebElement> waitForVisiblityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	/**
	 * An expectation for checking that there is at least one element present on a
	 * web page.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForPresenceOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public String waitFortitleContains(String titleFraction, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleContains(titleFraction))) {

				return driver.getTitle();

			}
		} catch (TimeoutException e) {
			System.out.println(titleFraction + "title value is not present....");
			e.printStackTrace();

		}

		return null;
	}

	public String waitFortitleIs(String title, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleIs(title))) {

				return driver.getTitle();

			}
		} catch (TimeoutException e) {
			System.out.println(title + "title value is not present....");
			e.printStackTrace();

		}

		return null;
	}
	
	public String waitForUrlContains(String urlFraction, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlContains(urlFraction))) {

				return driver.getCurrentUrl();

			}
		} catch (TimeoutException e) {
			System.out.println(urlFraction + "url value is not present....");
			e.printStackTrace();

		}

		return null;
	}

	
	public String waitURLToBe(String url, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlToBe(url))) {

				return driver.getCurrentUrl();

			}
		} catch (TimeoutException e) {
			System.out.println(url + "url value is not present....");
			e.printStackTrace();

		}

		return null;
	}
	
	
	
}
