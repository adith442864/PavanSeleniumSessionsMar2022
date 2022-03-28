package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionMultipleKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://text-compare.com/");
		
		WebElement input1 = driver.findElement(By.id("inputText1"));
		WebElement input2 = driver.findElement(By.id("inputText2"));
		
		input1.sendKeys("WELCOME TO SELENIUM");
		
		Actions action = new Actions(driver);
		
		// input1 -> CTRL +A 
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL); //To Release the control
			action.perform();
			
		// input1 --> CTRL +C
			action.keyDown(Keys.CONTROL);
			action.sendKeys("c");
			action.keyUp(Keys.CONTROL);
				action.perform();
		
		
		//press TAB KEY to navigate to second input box input2
		action.sendKeys(Keys.TAB);
		action.perform();
		
		//input2 --> CTRL +V -> paste
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
			action.perform();

	}

}
