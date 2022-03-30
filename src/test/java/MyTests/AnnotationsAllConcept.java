package MyTests;

import org.testng.annotations.*;

public class AnnotationsAllConcept {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test...");
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("After Test...");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class...");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class...");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method...");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method...");
	}
	
	@Test(priority=1)
	public void test1() {
		System.out.println("test1 test....");
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println("test2 test....");
	}
	
	@Test(priority=3)
	public void test3() {
		System.out.println("test3 test....");
	}

}
