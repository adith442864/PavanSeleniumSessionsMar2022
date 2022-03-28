package SeleniumSessions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionsHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/key_presses");
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.SPACE).perform();
		Thread.sleep(3000);
		
		
		driver.quit();
		
		

	}

}
