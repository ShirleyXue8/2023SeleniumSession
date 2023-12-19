package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil2 {
	
	WebDriver driver;
	
	public WebDriver launchBrowser(String browserName) {
		
		System.out.println("browser name: "+browserName);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver=new ChromeDriver();
			break;

		case "firefox":
			driver=new FirefoxDriver();
			break;

		case "safari":
			driver=new SafariDriver();
			break;

		case "edge":
			driver=new EdgeDriver();
			break;

			
		default:
			System.out.println("plz the right browser:"+browserName);
			throw new AutomationException("INVALID BROWSER");
		}
		
		
		return driver;
		
		
	}
	
	 
	public void launchUrl(String url){
		
		if(url==null) {
			
			System.out.println("url is null");
			throw new AutomationException("URL IS NULL");
		}
		
		if(url.indexOf("http://")==0 ||url.indexOf("https://")==0)
		{
		driver.get(url);
		
		}
	else {
		
		throw new AutomationException("http is missing");
		
	}
	
	}
	
	
	public String getPageTitle() {
		
		String title=driver.getTitle();
		System.out.println("title is :"+title);
		return title;
	}
	

	public String getPageUrl() {
		
		String url=driver.getCurrentUrl();
		System.out.println("url is :"+url);
		return url;
	}
	
	
	public boolean getPageSource(String value) {
		
		String pageSaurce=driver.getPageSource();
		if(pageSaurce.contains(value)) {
			return true;
			
		} return false;

	}
	
	
	public void quitBrowser() {
		
		driver.quit();
	}
	
}
