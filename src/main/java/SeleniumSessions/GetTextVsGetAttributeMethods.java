package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextVsGetAttributeMethods {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement email = driver.findElement(By.id("Email"));
		
		email.clear(); //clears the text value in the text box
		email.sendKeys("admin@yourstore.com");
		
		System.out.println(email.getText()); //no output is return
		String text = email.getAttribute("type");
		System.out.println(text); 
		
		
		System.out.println(driver.findElement(By.xpath("//button[normalize-space()='Log in']")).getText());
		System.out.println(driver.findElement(By.xpath("//button[normalize-space()='Log in']")).getAttribute("value"));
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
