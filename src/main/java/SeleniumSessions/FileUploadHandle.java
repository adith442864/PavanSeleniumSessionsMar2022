package SeleniumSessions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath(" //span[@class='uprcse semi-bold']")).click();
		
		// Approach1: using sendkeys() Method:
		driver.findElement(By.id("file-upload")).sendKeys("c:\\downloads\\sample.txt");
		
		//Approach2:
		//driver.findElement(By.xpath("//input[@id='file-upload']")).click(); //opens the window -- not working
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@id='file-upload']")));
		
		//PUT PATH to the file in a clibboard:
		StringSelection ss = new StringSelection("c:\\downloads\\sample.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); 
		
		//Use Robot Class:
		Robot rb = new Robot();
		rb.delay(3000);
		
		// CTRL +V 
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		
		//Keys Release:
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(3000);
		
		// Press Enter Key
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		

	}

}
