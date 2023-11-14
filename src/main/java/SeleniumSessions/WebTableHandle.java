package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * How many rows in a table
 * How many cols in a table
 * Retrive the specific row/column data
 * Retrieve all data from the table
 * Print Release date, 
 */

public class WebTableHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//How many rows in the table:
		int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		System.out.println(rows); //7
		
		//How many columns in the table:
		
		int cols = driver.findElements(By.xpath("//table[@id='customers']/tbody//tr/th")).size();
		System.out.println(cols); //3
		
		// Retrieve specific row/col data:

		//		//*[@id="customers"]/tbody/tr[2]/td[1]
		//		//*[@id="customers"]/tbody/tr[2]/td[2]
		//		//*[@id="customers"]/tbody/tr[2]/td[3]
		
		//		//*[@id="customers"]/tbody/tr[3]/td[1]
		
//		System.out.println(driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[2]/td[1]")).getText());
		
		//Retrieve all rows/cols from the table:
//		for(int r=2; r<=rows; r++) {
//			
//			for(int c=1; c<=cols; c++) {
//				String value = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+r+"]/td["+c+"]")).getText();
//				System.out.print(value +" --------- "); //
//				
//			}
//			
//			System.out.println( );
//		}
		
		//Print specific rows data 
		for(int r=2; r<=rows; r++) {
			String names = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+r+"]/td[1]")).getText();
			System.out.println(names);
			if(names.equals("Island Trading")) {
				String contact = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+r+"]/td[2]")).getText();
				String country = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+r+"]/td[3]")).getText();
				
				System.out.println(names+"   "+contact +"   "+country);
				break;
			}
			
			
		}
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
		

	}

}
