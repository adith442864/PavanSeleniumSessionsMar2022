package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDummyTicketApp {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		driver.findElement(By.xpath("//input[@id='dob']")).click(); //opens the date-picker
		
		//select the month
		Select month = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		month.selectByVisibleText("Aug");
		
		Select year = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		year.selectByVisibleText("2022");
		
		String date="10";
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement e: allDates) {
			String dt = e.getText();
			if(dt.equals(date)) {
				e.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
