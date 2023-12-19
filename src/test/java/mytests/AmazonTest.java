package mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {
	

	
	
	
	@Test(priority=1)
	public void amazonTitleTest() {
		
		String actutalTitle=driver.getTitle();
		System.out.println(actutalTitle);
		Assert.assertEquals(actutalTitle, "Amazon");
	}
	
	
	@Test(priority=2)
	public void amazontURLTest() {
		String actualURL=driver.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertTrue(actualURL.contains("amazon"));
	}
	

	

	
	
	


	
	

}
