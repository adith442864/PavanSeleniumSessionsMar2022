package MyTests.pack1;

import org.testng.annotations.Test;


public class DBTest2 {
	

	@Test(priority=3)
	public void test_select() {
		System.out.println("select test completed..");
	}
	
	@Test(priority=4)
	public void test_delete() {
		System.out.println("delete test completed..");
	}

}
