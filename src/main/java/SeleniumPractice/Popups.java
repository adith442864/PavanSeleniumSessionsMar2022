package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popups {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hdfcbank.com/");
	
		driver.manage().window().maximize();
		
		//driver.switchTo().alert().accept();
		
	
				
	}

}
