package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Utility {
	
	
	
	private WebDriver driver;
	
	public WebDriver lunchBrowser(String browserName) {
		
		System.out.println("browser name: "+browserName);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			driver=new  FirefoxDriver();
			break;
			
			
		case "safair":
			driver=new SafariDriver();
			break;
			
		case "edge":
			driver=new EdgeDriver();
			break;

		default:
		
			System.out.println("pls pass the right browser: "+browserName);
			throw new AutomationException("mesg");
			
		}
		
		return driver;
	}
	
	
	public void luanchUrl(String url) {
		
		if(url==null) {
			System.out.println("invalid url");
			
		}
		
		
		
		if(url.indexOf("https://")==0|| url.indexOf("http://")==0) {
			
		driver.get(url);
		
			
			
			
		}
		
//		if(url.indexOf("https://")==0) {
//			try {
//				driver.get(url);
//			} 
//			catch (Exception e) {
//				System.out.println("http is missing..................");
//				throw new AutomationException("Invalid url");
//			}
//		}
		
		
		
		else {
				throw new AutomationException("Invalid url");
				
				}
		}
		
		
	
	
	
	public String getPageTitle() {
		
		String title=driver.getTitle();
		System.out.println("page title is :"+title);
		
		return title;
	}
	
	public String getPageURl() {
		
		String url=driver.getCurrentUrl();
		
		System.out.println("page url is :"+url);
		return url;
	}
	
	public void getPageSource(String value) {
		
		String pageSource=driver.getPageSource();
		if(pageSource.contains(value)) {
			
			System.out.println("PASSSS");
			
		}
	}
	
	
	public void quitBrowser() {
		
		driver.quit();
		
	}
}
