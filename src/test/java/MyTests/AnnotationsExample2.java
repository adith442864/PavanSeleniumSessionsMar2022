package MyTests;

import org.testng.annotations.*;

public class AnnotationsExample2 {
	
	/*
	 *  1) Login - @BeforeClass
		2) search - @Test
		3) Advanced search - @Test
		4) Prepaid recharge - @Test
		5) postpaid recharge  - @Test
		6) Logout - @AfterClass

	 */
	
	@BeforeClass
	public void Login() {
		System.out.println("Login test...");
	}
	
	@Test(priority=1)
	public void search() {
		System.out.println("search test....");
	}
	
	@Test(priority=2)
	public void Advsearch() {
		System.out.println("Adv search....");
	}
	
	@Test(priority=3)
	public void prepaidSearch() {
		System.out.println("Prepaid recharge search test....");
	}
	
	@Test(priority=4)
	public void postpaidSearch() {
		System.out.println("Postpaid search recharge test....");
	}
	
	
	@AfterClass
	public void Logout() {
		System.out.println("Logout test...");
	}

}
