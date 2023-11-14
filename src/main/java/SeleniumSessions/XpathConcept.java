package SeleniumSessions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().deleteAllCookies();
		
		//Absolute Path:
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/input[4]"))
		//	.sendKeys("T-Shirts");
		
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]"))
		//	.click();
		
		//Relative XPath:
		//driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
		//driver.findElement(By.name("submit_search")).click();
		
		//xpath options:
			//and, or, contains(), text(), start-with()
		
		//OR: returns true if any of the attribute true:
//		driver.findElement(By.xpath("//input[@id='search_query_top' or name='search_query']")).sendKeys("T-shirts");
//		driver.findElement(By.xpath("//button[@name='submit_search' or @class='btn btn-default button-search']")).click();
		
		//And: returns true only both attributes are true
//		driver.findElement(By.xpath("//input[@id='search_query_top' and @name='search_query']")).sendKeys("T-shirts");
//		driver.findElement(By.xpath(" //button[@name='submit_search' and @type='submit']")).click();
		
		//contains() and starts-with()
//		driver.findElement(By.xpath("//input[contains(@id,'search_query_top')]")).sendKeys("T-shirts");
//		driver.findElement(By.xpath("//button[starts-with(@name,'submit')]")).click();
		
		//text()
//		driver.findElement(By.xpath("//a[text()='Women']")).click();
		
		//chained xpaths:
		driver.findElement(By.xpath("//form[@id='searchbox']//input[@id='search_query_top']")).sendKeys("T-shirts");
		driver.findElement(By.xpath("//form[@id='searchbox']//button[@name='submit_search']")).click();
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
