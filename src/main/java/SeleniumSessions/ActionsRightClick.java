package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsRightClick {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions action = new Actions(driver);
		
		action.contextClick(button).build().perform();
		
		List<WebElement> rightClickOptions = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li"));
		
		for(WebElement e: rightClickOptions) {
			System.out.println(e.getText());
			
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
