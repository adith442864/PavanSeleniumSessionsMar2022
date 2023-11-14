package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("http://www.pavantestingtools.com");
		Thread.sleep(5000);
		
		WebElement trainingLink = driver.findElement(By.xpath("//a[normalize-space()='Online Training']"));
		trainingLink.click();
		
		driver.navigate().back();
		
		Thread.sleep(5000);
		try {
			trainingLink.click();
		}catch(StaleElementReferenceException e) {
			trainingLink = driver.findElement(By.xpath("//a[normalize-space()='Online Training']"));
			trainingLink.click();
		}
		
		
		
		Thread.sleep(5000);
		driver.close();
		
		
		

	}

}
