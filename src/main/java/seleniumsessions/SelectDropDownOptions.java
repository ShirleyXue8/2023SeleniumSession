package seleniumsessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jdk.javadoc.internal.doclets.formats.html.markup.Text;

public class SelectDropDownOptions {

	static WebDriver driver;

	public static void main(String[] args)  {

		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/30-day-free-trial");

		By country = By.id("Form_getForm_Country");
//		WebElement country_ele=driver.findElement(country);
		
		selectDropDownOption(country, "Brazil");
		selectDropDownOption(country, "India");
	    getDropDownOptions(country);	
	   List<String> expectCountries= Arrays.asList("Brazil","India","China","Chile");
	   if(getDropDownOptions(country).containsAll(expectCountries)) {
		   System.out.println("ExpectCountries PASS!!!!");
	   }
//		if(getDropDownOptions(country).contains("India")) {
//			System.out.println("India ---PASS");
//		}

	   int countryCount=getDropDownOptionCount(country)-1;
	   if(countryCount==232){
		   System.out.println("PASS");
	   }
	   
	   
	   
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static int getDropDownOptionCount(By locator) {
		
		Select select=new Select(getElement(locator));
		List<WebElement> optionList=select.getOptions();
		return optionList.size();

		
	}
	
	public static List<String> getDropDownOptions(By locator) {
		
		Select select=new Select(getElement(locator));
		List<WebElement> optionList=select.getOptions();
	
		List<String>optionsTextList=new ArrayList<String>();
		
		
		for(WebElement e:optionList) {
			String text=e.getText();
		optionsTextList.add(text);
			
		
		}
	   return optionsTextList;
	}
	
	public static void selectDropDownOption(By locator,String dropDownValue) {
		
		Select select=new Select(getElement(locator));
		List<WebElement> optionList=select.getOptions();
		System.out.println(optionList.size());
		
		
		for(WebElement e:optionList) {
			String text=e.getText();
			System.out.println(text);
			
			if(text.equals(dropDownValue))
			 {
				e.click();
				break;
			}
		}
		
	}
	
	

}
