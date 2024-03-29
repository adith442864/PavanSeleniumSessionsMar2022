package SeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoostrapDropDown3 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.hdfcbank.com/");
		
		
		//Select Product Type
		
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click(); //click on element
		
		List<WebElement> prodTypes=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		
		System.out.println("Number of Options:"+prodTypes.size());
		
		for(WebElement ptype:prodTypes)
		{
			if(ptype.getText().equals("Accounts"))
			{
				ptype.click();
				break;
			}
			
		}
		
		
		//Select Product
		
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click(); //click on element
		List<WebElement> products=driver.findElements(By.xpath("//div[@class='drp2']//div[@class='dropdown open']//li"));
				
		System.out.println("Number of Options:"+products.size());
				
		for(WebElement product:products)
		{
			if(product.getText().equals("Salary Accounts"))
				{
				product.click();
				break;
				}
				
		}
			
		
	}

}
