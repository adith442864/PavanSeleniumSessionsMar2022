package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabsAndWindows {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
//		driver.get("https://demo.nopcommerce.com/");
//		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		//opening link in another tab
		//driver.get("https://demo.nopcommerce.com/");
		//Keys.chord(Keys.CONTROL, Keys.RETURN); //old approach may not work sometime
		//driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		//Selenium -- 4 new features
		//new tab
		driver.get("https://www.opencart.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://orangehrm.com");
		
		//new window
		driver.get("https://www.opencart.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://orangehrm.com");
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
