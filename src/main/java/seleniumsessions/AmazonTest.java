package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {

		
		Utility ut=new Utility();
		ut.lunchBrowser("chrome");
		ut.luanchUrl("https://www.amazon.com/");
		String pagetTitle=ut.getPageTitle();
		if(pagetTitle.equals("Amazon.com. Spend less. Smile more.")) {
			System.out.println("title is correct ,pass");
		}else {
			System.out.println("incorrect title,Fail");
		}
		
		String actURL=ut.getPageURl();
		if(actURL.contains("amazon")) {
			System.out.println("URl is correct...pass");
		}
		
		
		ut.quitBrowser();
	}

}
