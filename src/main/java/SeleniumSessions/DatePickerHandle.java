package SeleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame(0); //switch to frame
		//1. Direct - using sendkeys()
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("03/27/2022"); // MM/DD/YYYY 
		
		//using Date Picker:
		String year="2020";
		String month="September";
		String date="15";
		
		driver.findElement(By.xpath(" //input[@id='datepicker']")).click(); // opens the date picker
		
		while(true) 
		{
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			//if it matches, break the loop else click forward arrow:
			if(mon.equals(month) && yr.equals(year)) {
				break;
			}
			else 
			{
				//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //Forward button
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // Back button
			}
				
		}
		
		//select the dates:
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele: allDates) {
			String dt = ele.getText();
			//compare the date
			if(dt.equals(date)) {
				ele.click(); 
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
