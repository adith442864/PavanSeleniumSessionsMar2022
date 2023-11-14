package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDrop {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		Actions action = new Actions(driver);
		
		WebElement sourceElement = driver.findElement(By.id("box6"));
		WebElement targetElement = driver.findElement(By.id("box106"));
		
		action.dragAndDrop(sourceElement, targetElement).perform(); //perform drag and drop action
		
		Thread.sleep(3000);
		
		sourceElement = driver.findElement(By.id("box3"));
		targetElement = driver.findElement(By.id("box103"));
		
		action.dragAndDrop(sourceElement, targetElement).perform(); //perform drag and drop action
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
		
		

	}

}
