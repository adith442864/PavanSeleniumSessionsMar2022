package SeleniumSessions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
//		driver.get("http://automationpractice.com/index.php");
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//id
//		driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
		//name
//		driver.findElement(By.name("submit_search")).click();
//		Thread.sleep(3000);
		
		//linktext
//		String text = driver.findElement(By.linkText("Printed Chiffon Dress")).getText();
//		System.out.println(text);
		
		//partialLinkText
//		driver.findElement(By.partialLinkText("Chiffon Dress")).click();
		
		//classname
//		List<WebElement> sliderList = driver.findElements(By.className("homeslider-container"));
//		System.out.println("Total number of images in a slider :"+sliderList.size());
//		
//		for(WebElement e: sliderList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		System.out.println("Total no of links in a page :"+linksList.size());
		
		//facebook app:
		driver.get("https://facebook.com");
		
		//Tag & ID
		driver.findElement(By.cssSelector("input#email")).sendKeys("test@gmail.com");
		driver.findElement(By.cssSelector("#email")).sendKeys("test@gmail.com");
		
		//tag and class:
		driver.findElement(By.cssSelector("input.inputtext")).sendKeys("test@gmail.com");
		driver.findElement(By.cssSelector(".inputtext")).sendKeys("test@gmail.com");
		
		//Tag & Class & Attribute
		driver.findElement(By.cssSelector("input.inputtext[id='email']")).sendKeys("test@gmail.com");
		driver.findElement(By.cssSelector(".inputtext[id='email']")).sendKeys("test@gmail.com");
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		

	}

}
