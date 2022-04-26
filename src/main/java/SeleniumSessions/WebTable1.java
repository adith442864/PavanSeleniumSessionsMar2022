package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {
	
	/*
	 * How many rows in table
	 * How many columns in the table
	 * Retrieve the specific row/column data
	 * Retrieve all the data from the table
	 * Print Specific data
	 */

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/ecosystem/");
		
		//1. How Many rows in the table
		int rows = driver.findElements(By.xpath("(//table[@class='table'])[1]/tbody/tr")).size();
		System.out.println(rows); //7
		
		//driver.findElements(By.tagName("tr")).size();
		
		//2. How Many rows in the table
		int cols = driver.findElements(By.xpath("(//table[@class='table'])[1]/thead/tr/th")).size();
		System.out.println(cols); //3
		
		//3. Retrieve the specific row/column data
		String value = driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr[2]/td[1]")).getText();
		System.out.println(value);
		
		//4. Retrieve all the data from the table:
		/*
		for(int r=1; r<rows; r++) 
		{
			for(int c=1; c<cols; c++)
			{
				value = driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print(value+ "      ");
			}
			
			System.out.println();
			
		}*/
		
		// Print specific data
		for(int r=1; r<rows; r++) {
			String lang = driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr["+r+"]/td[1]")).getText();
			//System.out.println(lang);
			if(lang.equals("Go")) {
				String Author = driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr["+r+"]/td[2]")).getText();	
				System.out.println(lang+ "        " +Author);
			}
			
		}
		
		
		driver.quit();
		
		
		
		
		

	}

}
