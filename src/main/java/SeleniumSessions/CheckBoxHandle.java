package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		//1. select specific checkbox
		
//		driver.findElement(By.id("monday")).click(); //Monday
		
		//2 select all checkboxes using each loop:
		List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@class='form-check-input' and contains(@id,'day')]"));
		
		System.out.println(checkBoxList.size()); //7
		
//		for(WebElement ele: checkBoxList) {
//			ele.click();	
//			//System.out.println(e.getText());
//		}
		
		//3. select multiple checkboxes based on choice:
//		for(WebElement ele: checkBoxList) {
//			String day = ele.getAttribute("id");
//			if(day.equalsIgnoreCase("monday") || day.equalsIgnoreCase("sunday")) {
//				ele.click();
//			}
			
//		}
		
		
		//4. select last 2 checkboxes:
		
		// 0 1 2 3 4 5 6 -- Index 
		// 1 2 3 4 5 6 7 -- Total checkboxes
		// formula: total checkboxes  - index (7-2) ->> 5th Index 
		
		for(int i=checkBoxList.size()-2; i<checkBoxList.size(); i++) {
			checkBoxList.get(i).click();
		}
		
		// first 2 check boxes:
		for(int i=0; i<checkBoxList.size(); i++) {
			if(i<2) { //0 1 
				checkBoxList.get(i).click();
			}
		}
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		
	}

}
