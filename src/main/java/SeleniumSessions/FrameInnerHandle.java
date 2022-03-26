package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameInnerHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
		
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		//switch to outerframe
		WebElement outerFrame = driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		driver.switchTo().frame(outerFrame);
		
		//switch to innerframe
		WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(innerFrame);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		

	}

}
