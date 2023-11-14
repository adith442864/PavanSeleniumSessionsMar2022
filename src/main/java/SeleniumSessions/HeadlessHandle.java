package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessHandle {

	public static void main(String[] args) {
		
		//chrome
		/*
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.setHeadless(true);
		WebDriver driver = new ChromeDriver(co); */
		
		//firefox
		FirefoxOptions fo = new FirefoxOptions();
		//fo.addArguments("--headless");
		fo.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(fo);
		
		driver.get("https://demo.nopcommerce.com/");
		//driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
	}

}
