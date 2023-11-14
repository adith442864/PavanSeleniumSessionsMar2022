package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();	
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		//locator concept:
		By ele = By.xpath("//h3[text()='Selenium']");
		
		waitForElementPresent(ele, 10).click(); //calling the method..
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}
	
	// re-usable method for explicit wait..
	public static WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}

}
