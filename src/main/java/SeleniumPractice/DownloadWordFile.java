package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadWordFile {

	public static void main(String[] args) throws InterruptedException {
	
		String location=System.getProperty("user.dir")+"\\Downloads\\";

		//Chrome
				
//		  HashMap preferences = new HashMap();
//		  preferences.put("download.default_directory", location);
//		  
//		  ChromeOptions options = new ChromeOptions();
//		  options.setExperimentalOption("prefs", preferences);
//		  
//		  WebDriverManager.chromedriver().setup(); 
//		  WebDriver driver = new ChromeDriver(options);
//		 
//		 //Edge Browser
//		
//		  HashMap preferences = new HashMap();
//		  preferences.put("download.default_directory", location);
//		  
//		  EdgeOptions options = new EdgeOptions();
//		  options.setExperimentalOption("prefs", preferences);
//		  
//		  WebDriverManager.edgedriver().setup(); 
//		  WebDriver driver = new EdgeDriver(options);
		 
		 

		//Firefox
			
			  FirefoxProfile profile = new FirefoxProfile();
			  profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/msword"); 
			  profile.setPreference("browser.download.folderList",2); //0-desktop 1- downloads 2-desired location
			  profile.setPreference("browser.download.dir",location);
			  
			  FirefoxOptions options = new FirefoxOptions(); options.setProfile(profile);
			  
			 
			  WebDriver driver = new FirefoxDriver(options);
			 

		driver.manage().window().maximize();
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/"); //Doc
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}
	
}
