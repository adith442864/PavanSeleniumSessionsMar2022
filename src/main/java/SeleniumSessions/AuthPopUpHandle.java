package SeleniumSessions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUpHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
