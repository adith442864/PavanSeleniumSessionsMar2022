package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionHandle2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("adithautomation");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Tester@123");
		
		driver.navigate().refresh();
		try {	
			username.sendKeys("adithautomation");
		}catch(StaleElementReferenceException e) {
			username = driver.findElement(By.name("username"));
			username.sendKeys("adithautomation");
		}
		
		Thread.sleep(5000);
		driver.close();
		

	}

}
