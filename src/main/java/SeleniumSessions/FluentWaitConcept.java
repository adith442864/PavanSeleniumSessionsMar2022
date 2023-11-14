package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		By ele = By.xpath("//h3[text()='Selenium']");
		
		//Fluent wait:
		
		waitForElementWithFluentWait(ele, 10).click();
		
		
		Thread.sleep(5000);
		driver.quit();
	
		
	}
	
	public static WebElement waitForElementWithFluentWait(final By locator, int timeOut) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("Element is not found");
		
//		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		myWait.until(ExpectedConditions.presenceOfElementLocated(ele)).click();
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		
		return element;
		
	}

}
