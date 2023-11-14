package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		// dynamic wait -- applicable for webelements
		// default is set to 0
		// Implicit wait is applicable for the entire session of the browser...
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
		
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
