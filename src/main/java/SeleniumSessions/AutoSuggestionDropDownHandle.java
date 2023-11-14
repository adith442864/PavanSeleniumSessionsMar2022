package SeleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		Thread.sleep(5000);
		
		List<WebElement> suggList = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']"));
		
		System.out.println(suggList.size());
		
		for(WebElement e: suggList) {
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase("selenium")) {
				e.click();
				break;
			}
		}
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
