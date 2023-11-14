package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		//isDisplayed and isEnabled()
		
		WebElement searchStore = driver.findElement(By.id("small-searchterms"));
		System.out.println(searchStore.isDisplayed()); //true
		System.out.println(searchStore.isEnabled());  //true
		
		//isSelected - for radio buttons and check boxes
		WebElement male_btn = driver.findElement(By.xpath("//input[@id='gender-male']")); 
		WebElement female_btn = driver.findElement(By.xpath("//input[@id='gender-female']")); 
		
		System.out.println(male_btn.isSelected()); //false
		System.out.println(female_btn.isSelected()); //false
		
		male_btn.click();
		System.out.println(male_btn.isSelected()); //true
		System.out.println(female_btn.isSelected()); //false
		
		female_btn.click();
		System.out.println(male_btn.isSelected()); //false
		System.out.println(female_btn.isSelected()); //true
		
		Thread.sleep(5000);
		driver.quit();
	}

}
