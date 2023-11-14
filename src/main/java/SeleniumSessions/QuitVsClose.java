package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Thread.sleep(5000);
		driver.close();	
		
		Thread.sleep(5000);
		driver.quit();

	}


}
