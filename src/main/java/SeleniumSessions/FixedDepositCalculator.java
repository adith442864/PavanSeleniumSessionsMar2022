package SeleniumSessions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositCalculator {

	static WebDriver driver;
//	static XLUtils util;

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String path="./src/test/resources/testdata/caldata.xlsx";
//		util = new XLUtils();
		
		int rows = XLUtils.getRowCount(path, "Sheet1");
		System.out.println(rows);

		//capture data from all the columns
		for(int i=1; i<=rows; i++) {
		
		String principle = XLUtils.getCellData(path, "Sheet1", i, 0);
		String rateofinterest = XLUtils.getCellData(path, "Sheet1", i, 1);
		String period1 = XLUtils.getCellData(path, "Sheet1", i, 2);
		String period2 = XLUtils.getCellData(path, "Sheet1", i, 3);;
		String frequency = XLUtils.getCellData(path, "Sheet1", i, 4);
		String expected_maturityValue = XLUtils.getCellData(path, "Sheet1", i, 5);
			
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
			XLUtils.setCellData(path, "Sheet1", i, 7, "Passed");
			XLUtils.fillGreenColor(path, "Sheet1", i, 7);
			//util.setCellData("Sheet1", i, 7, "Passed");
			//util.fillGreenColor("Sheet1", i, 7);
	
			
		}else {
			System.out.println("Test Failed");
			XLUtils.setCellData(path, "Sheet1", i, 7, "Failed");
			XLUtils.fillRedColor(path, "Sheet1", i, 7);
		}
		
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			Thread.sleep(3000);

		}
		
		driver.quit();
		
	}

}
