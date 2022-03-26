package SeleniumSessions;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		int brokenLinks=0;
		
		for(WebElement e: allLinks) {
			String url = e.getAttribute("href");
			
			if(url==null || url.isEmpty() || url.isBlank()) {
				System.out.println("URL is empty");
			}
			
			URL link = new URL(url);
			
			try {
				HttpURLConnection httpcon = (HttpURLConnection)link.openConnection();
				httpcon.connect();
				
				if(httpcon.getResponseCode()>=400) {
					System.out.println(httpcon.getResponseCode()+" " +url+ "  "+ "is a broken link");
					brokenLinks++;
				}
				else {
					System.out.println(httpcon.getResponseCode()+" " +url+ "  " + "is a valid link");
				}
				
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			//System.out.println("Number of broken links: " +brokenLinks);
		}
		
		
		System.out.println("Number of broken links: " +brokenLinks);
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
