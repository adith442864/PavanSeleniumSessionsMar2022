package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		/*
		//1. scroll down page by pixel
		js.executeScript("window.scrollBy(0,3000)", "");
		Long value = (Long) js.executeScript("return window.pageYOffset;");
		System.out.println("Number of pixels moved: " +value); //3000
		*/
		
		//2. Scroll down page till the element is visible
		/*
		WebElement flag = driver.findElement(By.xpath(" //img[@alt='Flag of India']"));
		js.executeScript("arguments[0].scrollIntoView();",flag);
		Long value = (Long) js.executeScript("return window.pageYOffset;");
		System.out.println("Number of pixels moved: " +value);
		*/
		
		//3. Scroll down till the end of the page:
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Long value = (Long) js.executeScript("return window.pageYOffset;");
		System.out.println("Number of pixels moved: " +value);//5916
		
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
