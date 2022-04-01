package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPagePFTest {
	
	WebDriver driver;
	LoginPage lp;
	
	@BeforeClass
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		lp = new LoginPage(driver);
		
		
	}
	
	@Test(priority=1)
	public void verify_ImageTest() {
		boolean logo = lp.verify_ImagePresence();
		Assert.assertEquals(logo, true);
		
	}
	
	@Test(priority=2)
	public void loginTest() {
		lp.doLogin("Admin", "admin123");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
