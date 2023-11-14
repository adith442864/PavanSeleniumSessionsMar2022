package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownHandleWithoutSelectTag {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
//		WebElement optionDropDown = driver.findElement(By.id("input-country"));
		
		// select option without using built-in method
		List<WebElement> optionsList = driver.findElements(By.xpath("//select[@id='input-country']/option"));
		
		System.out.println(optionsList.size()-1);
		
		for(WebElement e: optionsList) {
			System.out.println(e.getText());
			if(e.getText().equals("India")) {
				e.click();
				break;
			}
		}
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
