package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
	List<WebElement> getToKnowUs=driver.findElements(By.xpath("//div[text()='Amazon Payment Products']/following-sibling::ul//a"));
		for(WebElement e:getToKnowUs) {
			String text=e.getText();
			System.out.println(text);
		}
		
		
		
		
		
		
		
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		// xpath: address of the element in the HTML DOM
		// 1. absolute xpath:/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/a/img
		// 2. relative xpath:using element attributes with xpath functions

		// htmltag[@attrName='value']
		// input[@name='search']
		// input[@placeholder='Search']
		// input[@id='input-email'] ----xpath vs id

		// htmltag[@attr1='value' and @attr2='value']
		// input[@type='text' and @name='search' ] ---1 of 1\
		// input[@type='text' and @name='search' and @ placeholder='Search']
		// input[@type='text' or @type='email' or @type='password']

		// input[@id] --6-->FEs
		// a ---81--->FEs

//		int linksCount = driver.findElements(By.xpath("//a")).size();
//		System.out.println(linksCount);

		// input[@id and @type']
		// a[@class='list-group-item'] ---13---FEs
//		driver.findElements(By.className("list-group-item"));
//		List<WebElement> linksList = driver.findElements(By.xpath("//a[@class='list-group-item']"));
//		System.out.println(linksList.size());
//
//		for (WebElement e : linksList) {
//
//			String text = e.getText();
//			System.out.println(text);
//	}
		// *[@attrName='value']
		// htmltag[@attrName='value']
		// *----total elments on the page----316

		// 316 elements
		// *[@class='form-control'] ---6 out of 322
		// input[@class='form-control'] --6 out of 14
		// input[@value]
//
//		String hearder = driver.findElement(By.tagName("//h2")).getText();
//		System.out.println(hearder);

		// text() in xpath: headers
		// htmltag[text()='value']
		// h2[text()='Returning Customer']
		// h2[text()='New Customer']
		// a[text()='Recurring payments']
		// a[text()='Forgotten Password']----2---FEs---size()---2===2---true---PASS

		// text() with attribute
		// htmltag[text()='value' and @attr='value' ]
		// a[text()='My Account' and @class='list-group-item']
		// htmltag[text()='value' and @attr1='value' and @attr2='value']

		// contatins() in xpath:
		// contains() with attribute
		// htmltag[contains(@attr,'value')]
		// input[contains(@placeholder,'E-Mail')]
		// input[contains(@placeholder,'Address')]
		// input[contains(@id,'email')]
		// input[contains(@id, 'email') and @type='text']
		// input[contains(@id,'email') and @type='text' and
		// contains(@placeholder,'E-Mail')]

		// when to use contains()?
		// 1.long text:
		// contains() with text():
		// htmltag[contains(text(),'value')]
		// p[contains(text(),'By creating an account')]

		// contains() with text() and attribute:
		// htmltag[contains(text(),'value') and contains(@attr,'value')]
		// a[contains(text(),'Password' )and contains(@class,'list-group-item')]

		// 2. dynamic attributes:
		// <input id=firstname_123>
		// <input id=firstname_125>
		// <input id=firstname_126>
		// <input id=firstname_120>
		// driver.findElement(By.id("firstname_123")).sendKeys("test");//---invalid

		// input[contains(@id,'firstname_')]

		// starts-with() in xpath:
		// htmltag[starts-with(text(),'value')]
		// input[starts-with(@id,'firstname')]
		// p[starts-with(text(),'By creating an account')]

		// ends-with() in xpath : deprecated --not valid now

		// id -unique --By.id(naveen);
		// xpath with id --->//input[@id='naveen']

		// index:
		// (//input[@class='form-control'])[1]
		//(//input[@class='form-control'])[position()=1]
		// (//input[@class='form-control'])[last()]
		// (//input[@class='form-control'])[last()-1]
		// (//label[@class='radio-inline'])[1]/input[@type='radio']

//		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("naveen");
//
//		String text = driver.findElement
//				(By.xpath("((//div[@class='navFooterVerticalColumn navAccessibility'])[last()]//a)[last()]"))
//				.getText();
//		System.out.println(text);
//		if (text.equals("Help")) {
//			System.out.println("PASS");
//
//		} else {
//			System.out.println("FAIL");
//		}

		// label[normalize-space()='Yes']
		// parent to child:
		// direct child:/
		// indirect + child://
		// form[@id='form-currency']//ul[@class='dropdown-menu']//button ---3

		// child to parent
		// input[@name='email']/../../../../../../../..
	

		// input[@name='email']/../../label[@for='input-email']
		// input[@name='firstname']/../../label[@for='input-firstname']

		// child-->parent --->child
		// input[@name='email']/parent::div/parent::div/label[@for=''input-email]
		// input[@name='firstname']/parent::div/parent::div/child::label
		
		// input[@name='email']/ancestor::div[@class='form-group required']
		// input[@name='firstname']/ancestor::div[@class='form-group required']/label

		// child -->parent-->
		// input[@name='firstname']/parent::div/preceding-sibling::label
		// input[@name='email']/parent::div/preceding-sibling::label
		
		//amazon
		//a[text()='Careers']/ancestor::ul/preceding-sibling::div
		
		//label[text()='Password']/following-sibling::input[@id='input-password']
		
		
		//parent,child,sibling,preceding,following,descendant---->xpath axces
		

	}

}
