package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertsPopUpHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		
		String text  = alert.getText();
		System.out.println(text);
		
		alert.sendKeys("Welcome");
		alert.accept(); // OK
//		alert.dismiss(); //cancel
		
	
		Thread.sleep(5000);
		driver.quit();
		
		
		
		

	}

}
