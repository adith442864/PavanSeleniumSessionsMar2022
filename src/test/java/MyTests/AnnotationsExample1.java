package MyTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsExample1 {
	
	@BeforeMethod
	public void login() {
		System.out.println("Login");
		
	}
	

	@Test(priority=1)
	public void search() {
		System.out.println("Search Test");
	}
	
	@Test(priority=2)
	public void Advsearch() {
		System.out.println("Adv Search Test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout");
		
	}
	
	

}
