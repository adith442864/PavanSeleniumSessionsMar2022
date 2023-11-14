package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownWithSelectClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement countryDropDown = driver.findElement(By.id("input-country"));
//		countryDropDown.click();
		
		Thread.sleep(2000);
		Select select = new Select(countryDropDown);
		
		//1. Selecting option from DropDown
		select.selectByVisibleText("India");
		Thread.sleep(3000);
		
		select.selectByValue("55");
		Thread.sleep(3000);
		
		select.selectByIndex(10);
		Thread.sleep(3000);
		
		
		//2. Finding Number of options
		List<WebElement> options = select.getOptions();
		System.out.println(options.size()-1); //241
		
		//print all options : for each loop:
//		for(WebElement option: options) {
//			System.out.println(option.getText());
//		}
		
		//for loop:
		for(int i=0; i<options.size(); i++) {
			String text = options.get(i).getText();
			System.out.println(text);
		}
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
