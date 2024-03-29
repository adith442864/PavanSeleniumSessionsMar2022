package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrames {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame("packageListFrame"); 	//switch to 1st frame
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		driver.switchTo().defaultContent(); // focus on page
		
		driver.switchTo().frame("packageFrame"); //switch to 2nd frame
		driver.findElement(By.linkText("WebDriver")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("classFrame"); //switch to 3rd frame
		driver.findElement(By.xpath("//a[text()='Index']")).click();

	}

}
