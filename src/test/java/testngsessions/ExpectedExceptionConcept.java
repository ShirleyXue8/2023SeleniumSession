package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	String name;
	
	@Test(expectedExceptions= {ArithmeticException.class,NullPointerException.class})
	public  void loginTest() {
		
		System.out.println("login step");
	//	int i=9/0;
		System.out.println("bye");
		
		ExpectedExceptionConcept obj=null;
		System.out.println(obj.name);
		
		System.out.println("bye");
		
	}
	
	
	

}
