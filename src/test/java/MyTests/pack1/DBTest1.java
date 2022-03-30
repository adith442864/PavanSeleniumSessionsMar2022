package MyTests.pack1;

import org.testng.annotations.*;

public class DBTest1 {
	
	@BeforeTest
	public void connectDB() {
		System.out.println("Connecting to DB");
	}
	
	
	@Test(priority=1)
	public void test_insert() {
		System.out.println("insertion test completed..");
	}
	
	@Test(priority=2)
	public void test_update() {
		System.out.println("update test completed..");
	}
	
	@AfterTest
	public void DisconnectFromDB() {
		System.out.println("Disconnected from DB");
	}

}
