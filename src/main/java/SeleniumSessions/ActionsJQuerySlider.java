package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsJQuerySlider {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		
		System.out.println(min_slider.getLocation()); // (59, 250)
		System.out.println(max_slider.getLocation()); // (369, 250)
		
		Actions action  = new Actions(driver);
		action.dragAndDropBy(min_slider, 100, 0).perform();
		action.dragAndDropBy(max_slider, -40, 0).perform();
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
