package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("http://londonfreelance.org/courses/frames/index.html");
		
		Thread.sleep(1000);
		
		
		//driver.switchTo().frame(2);
	//	driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']")));
		
		
		String text=driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		
		//Browser
		  //Page ---elements
		  //Frame ---elements
		//Frame ---elements
		
		//2.type of frames:
		//1.frame tag  --deprecated --OLd --not recommended by w3c
		//2.iFrame tag --new --w3c
		
		
		
		
	}

}
