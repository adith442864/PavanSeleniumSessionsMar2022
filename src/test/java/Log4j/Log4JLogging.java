package Log4j;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Log4JLogging {
	
	WebDriver driver;
	Logger logger;
	
	@BeforeClass
	public void setup() {
		logger = LogManager.getLogger("Log4JLogging"); //initialization of logs

		driver = new ChromeDriver();
		logger.info("browser launched..");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		logger.info("App URL opened..");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testRegistration() {
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		driver.findElement(By.linkText("Register")).click();
		logger.info("Register Link got clicked...");

		driver.findElement(By.id("input-firstname")).sendKeys("tom2345");
		logger.info("provided First Name...");
	
		driver.findElement(By.id("input-lastname")).sendKeys("peter");
		logger.info("provided Last Name...");
		
		driver.findElement(By.id("input-email")).sendKeys("tom123456.peter@gmail.com");
		logger.info("provided Email...");
		
		driver.findElement(By.id("input-telephone")).sendKeys("1234568789");
		logger.info("provided Telephone...");
		
		driver.findElement(By.id("input-password")).sendKeys("test123");
		logger.info("provided Password...");
		
		driver.findElement(By.id("input-confirm")).sendKeys("test123");
		logger.info("provided confirm Password...");
		
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		logger.info("Agreed privacy policy...");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		logger.info("continue button clicked...");
		
		logger.debug("Capturing API calls...");
		
		String confmsg = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			logger.info("Success: User Registered...");
			Assert.assertTrue(true);
		}else {
			logger.error("Error: User Not Registered");
			Assert.assertTrue(false);
		}
		
	}
	
	
	@AfterClass
	public void tearDown() {
		logger.info("closing browser...");
		driver.quit();
	}

}
