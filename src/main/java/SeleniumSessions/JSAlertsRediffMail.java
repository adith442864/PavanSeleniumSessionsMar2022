package SeleniumSessions;

import java.net.MalformedURLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertsRediffMail {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath(" //input[@title='Sign in']")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.accept();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
