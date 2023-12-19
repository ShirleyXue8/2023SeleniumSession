package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


/**
 * 
 * @author shirley
 * BrowserUtil is having multiple generic methods to handle the various browser actions
 *
 */
public class BrowserUtil {
	
	private WebDriver driver;
	/**
	 * This methods is used to launch  the browser on the basis of given browserName
	 * @param browserName
	 * @return this returns the driver instance
	 */
	
	
	public WebDriver launchBrowser(String browserName) {
		System.out.println("browser name: "+browserName);
		
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver=new ChromeDriver();
			break;

		case "firefox":
			driver=new FirefoxDriver();
			break;

		case "edge":
			driver=new EdgeDriver();
			break;
			
		case "safari":
			driver=new SafariDriver();
			break;

		default:
			System.out.println("please pass the right browser......"+ browserName);
			throw new AutomationException("INVALID BROWSER");
			
		}
		
		return driver;
		
		
		
	}
	
	/**
	 * 
	 * @param url
	 */
	public void launchURL(String url) {
		
		if(url==null) {
			System.out.println("URL IS NULL");
			throw new AutomationException("NULL URL");
		}
		//http://www.google.com
		if(url.indexOf("http")==0) {
			driver.get(url);
		}else {
			throw new AutomationException("HTTP is missing");
		}
	}
	
	public String getPageTitle() {
		
		String title=driver.getTitle();
		System.out.println("page title is :"+title);
		return title;
	}
	
	
	public String getPageURL() {
		
		String url=driver.getCurrentUrl();
		System.out.println("page url is: "+url);
		return url;
	}
	

	public boolean getPageSource(String value) {
		String pageSource=driver.getPageSource();
		if(pageSource.contains(value)) {
			return true;
		}
		return false;
	}
	
	
	public void closeBrowser() {
		
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}
