package SeleniumSessions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownloadHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		String location = System.getProperty("user.dir")+"/Downloads";
		
		HashMap preferences = new HashMap();
		preferences.put("download.default.directory", location);
		
		//chrome
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs",preferences);
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(options);
		
		//firefox:
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");//Mime Type
		profile.setPreference("browser.download.folderList", 2); //0- desktop 1-downloads 2-desired location
		profile.setPreference("browser.download.dir", location);
		
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		driver = new FirefoxDriver(option);
		
		
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		

	}

}
