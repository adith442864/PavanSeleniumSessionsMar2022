package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[normalize-space()='From']")).click();
		Thread.sleep(2000);
		
		WebElement from=driver.findElement(By.xpath("//input[@placeholder='From']"));
		Thread.sleep(2000);
				
		from.sendKeys("Sydney");
		Thread.sleep(2000);
		from.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		from.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}

}
