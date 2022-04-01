package SeleniumSessions;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QRCodeHandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException, NotFoundException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		String qrCodeURL = driver.findElement(By.xpath("//div[@id='HTML4']//img")).getAttribute("src");
		
		URL url = new URL(qrCodeURL);
		BufferedImage bufferedImage = ImageIO.read(url);
		
		LuminanceSource ls = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitMap = new BinaryBitmap(new HybridBinarizer(ls));
		
		Result result = new MultiFormatReader().decode(binaryBitMap);
		System.out.println(result.getText());
		
		
		Thread.sleep(5000);
		driver.quit();
	}	

}
