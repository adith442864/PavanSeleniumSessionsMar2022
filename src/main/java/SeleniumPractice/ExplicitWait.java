package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
						
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Selenium WebDriver']")));
		//WebElement ele=mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Selenium WebDriver']")));
		ele.click();
		driver.quit();
		
	}

}
