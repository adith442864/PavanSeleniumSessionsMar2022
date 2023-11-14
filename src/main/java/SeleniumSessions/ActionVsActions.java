package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVsActions {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php/");
		
		WebElement womenMenuLink = driver.findElement(By.linkText("Women"));
		
		//Actions act = new Actions(driver);
		//act.moveToElement(womenMenuLink).build().perform(); //includes .build().perform()
		
		Actions act = new Actions(driver);
		Action ac =  act.moveToElement(womenMenuLink).build(); //here we create only action but not perform
		ac.perform();
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
		

	}

}
