package SeleniumSessions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositCalculator {

	static WebDriver driver;
	static XLSUtil util;

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String path="./src/test/resources/testdata/caldata.xlsx";
		util = new XLSUtil(path);
		
		int rows = util.getRowCount("Sheet1");
		
		System.out.println(rows);

		
		Thread.sleep(5000);
		//capture data from all the columns
		for(int i=1; i<=rows; i++) {
			
			String principle = util.getCellData("Sheet1", i, 0);
			String rateofinterest = util.getCellData("Sheet1", i, 1);
			String period1 = util.getCellData("Sheet1", i, 2);
			String period2 = util.getCellData("Sheet1", i, 3);
			String frequency = util.getCellData("Sheet1", i, 4);
			String expected_maturityValue = util.getCellData("Sheet1", i, 5);
			
			//application code
			driver.findElement(By.id("principal")).sendKeys(principle);
			driver.findElement(By.id("interest")).sendKeys(rateofinterest);
			driver.findElement(By.id("tenure")).sendKeys(period1);
			//handle drop-down
			Select period2DropDown = new Select(driver.findElement(By.id("tenurePeriod")));
			period2DropDown.selectByVisibleText(period2);
			
			Select freqDropDown = new Select(driver.findElement(By.id("frequency")));
			freqDropDown.selectByVisibleText(frequency);
			
			driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]/img")).click();
			
			String actual_maturityValue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(expected_maturityValue) == Double.parseDouble(actual_maturityValue)) {
				System.out.println("Test Passed");
				util.setCellData("Sheet1", i, 7, "Passed");
				util.fillGreenColor("Sheet1", i, 7);
		
			
		}else {
			System.out.println("Test Failed");
			util.setCellData("Sheet1", i, 7, "Failed");
			util.fillRedColor("Sheet1", i, 7);
		}
		
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			Thread.sleep(5000);

		}
		
		driver.quit();
		
	}

}
