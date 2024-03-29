package SeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoostrapDropDown3_GenericMethod {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.hdfcbank.com/");
		
		//Select Product Type
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click(); //click on element
		List<WebElement> prodTypes=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		System.out.println("Number of Options:"+prodTypes.size());
		selectOptionFromDropDown(prodTypes, "Accounts"); 
		
		
		//Select Product
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click(); //click on element
		List<WebElement> products=driver.findElements(By.xpath("//div[@class='drp2']//div[@class='dropdown open']//li"));
		System.out.println("Number of Options:"+products.size());
		selectOptionFromDropDown(products, "Salary Accounts"); 		
				
	}

		
	public static void selectOptionFromDropDown(List<WebElement> options, String value) 
	{
	    for (WebElement option : options) 
		{
			if (option.getText().equals(value)) 
			{
				option.click();
				break;
			}
		}
}
}
