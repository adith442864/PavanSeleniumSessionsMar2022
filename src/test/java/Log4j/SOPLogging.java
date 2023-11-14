package Log4j;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SOPLogging {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Chrome Browser got launched..");
		
		driver.get("https://demo.opencart.com/");
		System.out.println("opencart Application got opened..");
		
		driver.manage().window().maximize();
		System.out.println("Browser got maximized");
		
	}
	
	@Test
	public void testRegistration() {
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		driver.findElement(By.linkText("Register")).click();
		System.out.println("Register link got clicked");
		
		driver.findElement(By.id("input-firstname")).sendKeys("tom");
		System.out.println("Provided First Name");
		
		driver.findElement(By.id("input-lastname")).sendKeys("peter");
		System.out.println("Provided Last Name");
		
		driver.findElement(By.id("input-email")).sendKeys("tom123.peter@gmail.com");
		System.out.println("Provided Email");
		
		driver.findElement(By.id("input-telephone")).sendKeys("1234568789");
		System.out.println("Provided Telephone");
		
		driver.findElement(By.id("input-password")).sendKeys("test123");
		System.out.println("Provided Password");
		
		driver.findElement(By.id("input-confirm")).sendKeys("test123");
		System.out.println("Provided Confirm Password");
		
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		System.out.println("Agreed privay policy");
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		System.out.println("Continue link got clicked");
		
		String confmsg = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			//System.out.println("Test Passed");
			System.out.println("Success: User Registered");
			Assert.assertTrue(true);
		}else {
			//System.out.println("Test Failed");
			System.out.println("Error: User Not Registered");
			Assert.assertTrue(false);
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Browser got closed");
	}

}
