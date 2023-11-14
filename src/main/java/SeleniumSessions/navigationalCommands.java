package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigationalCommands {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		driver.navigate().to("https://www.amazon.com");
		System.out.println(driver.getTitle());
		
		driver.navigate().back(); //google
		System.out.println(driver.getTitle());
		
		driver.navigate().forward(); //amazon
		System.out.println(driver.getTitle());
		
		driver.navigate().back(); //google
		System.out.println(driver.getTitle());
		
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		driver.quit();
		
	}
}
