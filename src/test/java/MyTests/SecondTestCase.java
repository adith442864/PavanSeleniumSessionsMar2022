package MyTests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SecondTestCase {
	
	WebDriver driver;
	
  @Test(priority=1)
  public void openApp() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://admin-demo.nopcommerce.com/login");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().deleteAllCookies();
	  
  }
  
  @Test(priority=2)
  public void doLogin() throws InterruptedException {
	 
	  driver.findElement(By.id("Email")).clear();
	  driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
	  
	  driver.findElement(By.id("Password")).clear();
	  driver.findElement(By.id("Password")).sendKeys("admin");
	  
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  Thread.sleep(5000);
	  
	  String actualTitle = driver.getTitle();
	  System.out.println(actualTitle);
	  
	  if(actualTitle.equals("Dashboard / nopCommerce administration")) {
		  System.out.println("Test Passed");
	  }else {
		  System.out.println("Test Failed");
	  }
	  
  }
  
  @Test(priority=3)
  public void closeApp() {
	  
	  driver.quit();
	  
	  
  }
  
  
  
  
  
  
  
  
  
}
