package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		Actions act = new Actions(driver);
		
//		WebElement firstName = driver.findElement(By.id("input-firstname"));
//		WebElement lastName = driver.findElement(By.id("input-lastname"));
		
//		act.sendKeys(firstName, "adith").build().perform();
//		act.sendKeys(lastName, "automation10").perform();
		
//		act.click(firstName).sendKeys("adith").build().perform();
//		act.click(lastName).sendKeys("automation10").build().perform();
		
		By firstName = By.id("input-firstname");
		doActionsSendKeys(firstName, "adith");
		
		By lastName = By.id("input-lastname");
		doActionsSendKeysonActiveElement(lastName, "automation10");
		
		By checkBox = By.name("agree");
		doActionsClick(checkBox);
		
		Thread.sleep(5000);
		driver.quit();
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).build().perform();
		
	}
	
	public static void doActionsSendKeysonActiveElement(By locator, String value) {
		
		Actions act = new Actions(driver);
		act.click(getElement(locator)).sendKeys(value).build().perform();
		
	}
	
	/*
	 * Clicks on the middle of the element. 
	 * Equivalent to : Actions.moveToElemnt(onElement).click()
	 */
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
	
	public static void doActionsmoveToElementClick(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).click().build().perform();
	}

}
