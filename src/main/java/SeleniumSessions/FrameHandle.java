package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//frame is Overloaded
		driver.switchTo().frame(driver.findElement(By.name("packageListFrame"))); //switch to 1st frame
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();
		
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.name("packageFrame"))); //switch to 2nd frame
		driver.findElement(By.linkText("WebDriver")).click();
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.name("classFrame"))); //switch to 3rd frame
		driver.findElement(By.xpath("/html/body/header/nav/div[1]/div[1]/ul/li[8]")).click();
		//driver.findElement(By.xpath("(//li[@class='navBarCell1Rev' and contains(text(),'Help')])[1]")).click();
		//driver.findElement(By.xpath("(//li[contains(text(),'Help')])[position()=1]")).click();
		System.out.println(driver.getTitle());
		
		
		
		
		
		Thread.sleep(5000);
		driver.quit();

	}

}
