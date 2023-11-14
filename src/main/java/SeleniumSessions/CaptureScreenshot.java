package SeleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//screenshot of full page:
		/*
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\homepage.png");
		FileUtils.copyFile(src, target);
		*/
		
		//screenshot of particular portion of the page
		/*
		WebElement pageSection = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src = pageSection.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\featuredProduct.png");
		FileUtils.copyFile(src, target);
		*/
		
		//Screenshot of the specific webelement
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src = logo.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
		FileUtils.copyFile(src, target);
		
		Thread.sleep(5000);
		driver.quit();

	}

}
