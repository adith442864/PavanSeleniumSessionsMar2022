package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Permission_Popups {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Chrome Browser
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");	//To disable the notifications based permission popup
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.redbus.in/"); 
		
		
		
		
	}

}
