package SeleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureLinks {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.linkText("Today's Deals")).click();
		
		Thread.sleep(3000);
		
		//2. Find Number of Links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		//3. Print all the link names:
		for(WebElement e: links) {
			String text = e.getText();
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
		
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
