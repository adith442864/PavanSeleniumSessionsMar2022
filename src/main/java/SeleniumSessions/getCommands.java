package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getCommands {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
//		System.out.println(driver.getPageSource());
		
		
		Thread.sleep(5000);
		driver.quit();

	}

}
