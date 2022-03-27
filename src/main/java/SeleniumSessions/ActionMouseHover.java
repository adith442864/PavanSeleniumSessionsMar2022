package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionMouseHover {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		WebElement desktopMenu = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement menuItem = driver.findElement(By.xpath(" //a[normalize-space()='Mac (1)']"));
		
		//Mouse Hover action
		
		Actions action = new Actions(driver);
		//Overloaded methods are available
		action
			.moveToElement(desktopMenu)
				.moveToElement(menuItem)
					.click()
						.build()
							.perform();
		
		
		Thread.sleep(5000);
		driver.quit();

	}

}
