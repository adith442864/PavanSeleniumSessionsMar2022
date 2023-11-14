package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDoubleClick {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		
		driver.switchTo().frame("iframeResult");
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Welcome");
		
		Actions action = new Actions(driver);
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		action.doubleClick(button).build().perform();
		
		
		Thread.sleep(5000);
		driver.quit();
				
		

	}

}
