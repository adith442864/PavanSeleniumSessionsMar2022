package MyTests;
import org.testng.annotations.Test;

public class FirstTestNGTestCase {
	
	@Test(priority=1)
	public void launchApp() {
		System.out.println("Launching application");
	}
	
	@Test(priority=2)
	public void doLogin() {
		
		// Login code
		System.out.println("Login to application");
	}
	
	
	@Test(priority=3)
	public void logout() {
		//logout code
		System.out.println("Logout from application");
	}
	
	
	@Test(priority=4)
	public void closeApp() {
		System.out.println("Close the application");
	}

}
