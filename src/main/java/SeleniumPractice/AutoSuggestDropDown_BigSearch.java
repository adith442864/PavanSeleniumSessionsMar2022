package SeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown_BigSearch {

public static void main(String[] args) {
	
	
	WebDriver driver = new ChromeDriver();
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
   driver.get("https://www.bing.com/");
    
   driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
   
    List<WebElement> list= driver.findElements(By.xpath("//li[@class='sa_sg']//span")); //working - using partial xpath
   
   System.out.println("size of elements"+ list.size());
   	
   for(WebElement item:list)
	{
		if(item.getText().equals("selenium"))
		{
			item.click();
			break;
		}
	}
}
}