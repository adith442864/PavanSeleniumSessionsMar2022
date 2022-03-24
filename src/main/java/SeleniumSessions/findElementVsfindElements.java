package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElementVsfindElements {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//1. findElement() --> returns a single webElement
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']")); // locator matching with single webelemnt
		searchBox.sendKeys("Apple Macbook Pro 13-inch");
		
		//2. findElement() -> returns the first element of all matching elements
		WebElement footerLinks = driver.findElement(By.xpath("//div[@class='footer']//a")); //locator matching with multiple webelements
		System.out.println(footerLinks.getText());
		
		//3.  NoSuchElementException --> Element is not available in a page
//		WebElement searchBtn = driver.findElement(By.xpath("//button[normalize-space()='Search123']"));
		
		// 1. findElements() --> returns multiple webElements
		List<WebElement> logoLink = driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']")); // Locator matching single web element
		System.out.println(logoLink.size());
		
		//2.
		List<WebElement> footer = driver.findElements(By.xpath("//div[@class='footer']//a")); //locator matching with multiple webelements
		System.out.println(footer.size());
		
		//iterate:
		for(WebElement e: footer) {
			System.out.println(e.getText());
		}
		
		//3. if Locator is not matching with any of the webelements throws --> No Exception -- Returns zero
		List<WebElement> footerLinkImg = driver.findElements(By.xpath("//div[@class='footer']//img")); //locator matching with multiple webelements
		System.out.println(footerLinkImg);
		
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
	
		
	}

}
