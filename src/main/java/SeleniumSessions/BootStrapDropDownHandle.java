package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
//		
//		driver.findElement(By.id("dropdownMenuButton")).click();
//		
//		Thread.sleep(2000);
//		List<WebElement> bootStrapList = driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));
//		
//		System.out.println(bootStrapList.size());
		
		driver.get("https://www.hdfcbank.com/");
		
		Thread.sleep(5000);
		
		
		//select product type:
		driver.findElement(By.xpath("//div[@class='drp1']//a[@class='btn-primary dropdown-toggle btn-block']")).click();
		
		List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		
		System.out.println("Total Number of Options: "+productTypes.size());
		
		//select option:
		for(WebElement e: productTypes) {
			//System.out.println(e.getText());
			if(e.getText().equals("Loans")) {
				e.click();
				break;
			}
			
		}
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
