package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(xpath="//div[@id='divLogo']//img")
	WebElement logo;
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginBtn;
	
	//Page Actions:
	
	public boolean verify_ImagePresence() {
		boolean img_logo = logo.isDisplayed();
		return img_logo;
	}
	
	public void doLogin(String un, String pwd) {
		username.clear();
		username.sendKeys(un);
		
		password.clear();
		password.sendKeys(pwd);
		
		loginBtn.click();
		
	}
	

}
