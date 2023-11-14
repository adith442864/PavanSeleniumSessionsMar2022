package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


public class WorkingwithTabsAndWindows {

	public static void main(String[] args) throws InterruptedException {
		//Chrome browser
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();	
		
				
		//********** Opening link in next tab *********
	
		driver.get("https://demo.nopcommerce.com/");
		String clicklnk = Keys.chord(Keys.CONTROL,Keys.RETURN);
	    driver.findElement(By.linkText("Register")).sendKeys(clicklnk);
		
		
		//*********** Opening new Tab  : Selenium4 feature **************
		//driver.get("https://demo.nopcommerce.com/");
	   // driver.switchTo().newWindow(WindowType.TAB);
	   // driver.navigate().to("https://www.facebook.com/");
	    
	  //*********** Opening new Window  : Selenium4 feature **************
	   //driver.get("https://demo.nopcommerce.com/");
	   // driver.switchTo().newWindow(WindowType.WINDOW);
	   // driver.navigate().to("https://www.facebook.com/");
	    

	}
}
