package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		// returns single window ID:
//		String windowID = driver.getWindowHandle();
//		System.out.println(windowID);
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		//1st Approach: Set to ArrayList Concept
//		List<String> windowIDsList = new ArrayList<String>(windowIDs);
//		String parentWindowID = windowIDsList.get(0);
//		String childWindowID = windowIDsList.get(1);
//		
//		System.out.println(parentWindowID);
//		System.out.println(childWindowID);
//		
//		driver.switchTo().window(childWindowID); //switch to childwindow
//		System.out.println(driver.getTitle());
//		driver.close();
//		
//		driver.switchTo().window(parentWindowID); //switch to parentWindow
//		System.out.println(driver.getTitle());
		
		//2nd Approach: using Loop Statement:
//		for(String s: windowIDs) {
//			System.out.println(s);
//			String title = driver.switchTo().window(s).getTitle();
//			System.out.println(title);
//		}
		
		//3rd Approach: using iterator
		Iterator it = windowIDs.iterator();
		String parentWindowID = (String) it.next();
		System.out.println(parentWindowID);
		
		String childWindowID = (String) it.next();
		System.out.println(childWindowID);
		
		//switch to child window
		driver.switchTo().window(childWindowID);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
