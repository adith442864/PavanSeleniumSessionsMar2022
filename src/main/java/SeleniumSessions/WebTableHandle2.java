package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
		// how many users are enabled and disabled. 
		
		int rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
		System.out.println("Total No of Rows are:" +rows);
		
		int count =0;
		for(int r=1; r<=rows; r++) {
			String status = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+r+"]/td[5]")).getText();
			if(status.equals("Enabled")) {
				count++;
			}
		}
		
		System.out.println("No of enabled users: " +count);
		System.out.println("No of disabled users: " +(rows - count));
		
		Thread.sleep(5000);
		driver.quit();	

	}

}
