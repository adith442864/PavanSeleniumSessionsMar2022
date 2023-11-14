package SeleniumSessions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerSakraWorld {

	public static void main(String[] args) throws InterruptedException, ParseException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.sakraworldhospital.com/request-appointment");
		driver.findElement(By.linkText("Dr. Rani Premkumar")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='Consultation' and @type='button'])[position()=4]")).click();
		
		Thread.sleep(3000);
		//Page Locators:
		driver.findElement(By.id("req_name")).sendKeys("test");
		driver.findElement(By.id("req_email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("req_mobile")).sendKeys("9999900000");
		
		WebElement gender = driver.findElement(By.id("req_gender"));
		Select select = new Select(gender);
		select.selectByVisibleText("Male");
		
		//dd-MM-YYYY 
		driver.findElement(By.id("req_datebirth")).click();
		String dob = "12-04-2020";
		
		String monthYearDisplayed = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//		System.out.println(monthYearSelected);
		
		
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		Date dateToBeSelected = sd.parse(dob);
		Date currentDate = new Date();
		
		String day = new SimpleDateFormat("d").format(dateToBeSelected);
		System.out.println(day);
		
		String month = new SimpleDateFormat("MMMM").format(dateToBeSelected);
		System.out.println(month);
		
		String year = new SimpleDateFormat("yyyy").format(dateToBeSelected);
		System.out.println(year);
		
		String monthYearToBeSelected = month+" "+year;
		System.out.println("monthYearToBeSelected: " +monthYearToBeSelected);
		
		while(!monthYearToBeSelected.equals(monthYearDisplayed)) {
			//click on forward or backward button
			if(dateToBeSelected.compareTo(currentDate)==1) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			else if(dateToBeSelected.compareTo(currentDate)==-1) {
				//back icon
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}
			
			monthYearDisplayed = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			System.out.println(monthYearDisplayed);
			
		}
		
		
		
		driver.quit();
		

	/*
	 * public void selectDate(String dateVal) {
		// dynamic - date selection
				String monthYearDisplayed = driver.findElement(getObjectLocator("monthyear_css")).getText();
				System.out.println("monthYearDisplayed -"+monthYearDisplayed);
				SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
				try {
					Date dateToBeSelected = sd.parse(dateVal);
					Date currentDate = new Date();
					String day = new SimpleDateFormat("d").format(dateToBeSelected);
					System.out.println(day);
					String month= new SimpleDateFormat("MMMM").format(dateToBeSelected);
					System.out.println(month);
					String year= new SimpleDateFormat("yyyy").format(dateToBeSelected);
					System.out.println(year);
					String monthYearToBeSelected = month+" "+year;
					System.out.println("monthYearToBeSelected -"+monthYearToBeSelected);
					
					while(!monthYearToBeSelected.equals(monthYearDisplayed)) {
						// click on forward or back icon
						if(dateToBeSelected.compareTo(currentDate) == 1) {//
							//forward icon
							driver.findElement(getObjectLocator("calendar_forward_xpath")).click();
						}else if(dateToBeSelected.compareTo(currentDate) == -1){
							// back icon
							driver.findElement(getObjectLocator("calendar_back_xpath")).click();
						}
						 monthYearDisplayed = driver.findElement(getObjectLocator("monthyear_css")).getText();
					     System.out.println("monthYearDisplayed -"+monthYearDisplayed);
					     
					}
					
					 //day
				     driver.findElement(By.xpath("//a[text()='"+day+"']")).click();

				}catch (Exception e) {
					
					e.printStackTrace();
				}
				
	}
	 */
		
		

	}

}
