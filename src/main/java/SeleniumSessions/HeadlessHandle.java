package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessHandle {

	public static void main(String[] args) {
		
		//chrome
		/*
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.setHeadless(true);
		WebDriver driver = new ChromeDriver(co); */
		
		//firefox
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo = new FirefoxOptions();
		//fo.addArguments("--headless");
		fo.setHeadless(true);
		WebDriver driver = new FirefoxDriver(fo);
		
		driver.get("https://demo.nopcommerce.com/");
		//driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
	}

}
