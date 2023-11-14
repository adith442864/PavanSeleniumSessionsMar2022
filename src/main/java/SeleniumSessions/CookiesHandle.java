package SeleniumSessions;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		//driver.manage().window().maximize();
		
		// How to capture cookies from Browser?
		
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size()); //3
		
		// How to print cookies from browser?
		
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+ " : +"+cookie.getValue());
		}
		
		//how to add cookies to the browser?
		Cookie cookieObj = new Cookie("MyCookie", "123456");
		driver.manage().addCookie(cookieObj);
		
		cookies = driver.manage().getCookies();
		System.out.println("size of the cookie after adding new one :" +cookies.size()); 
		
//		for(Cookie cookie:cookies) {
//			System.out.println(cookie.getName()+ " : +"+cookie.getValue());
//		}
		
		//how to delete specific Cookie from the browser?
		driver.manage().deleteCookie(cookieObj);
		cookies = driver.manage().getCookies();
		System.out.println("size of the cookie after deletion :" +cookies.size()); 
		
		//How to delete all the cookies from the browser?
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("size of the cookie after deleting all :" +cookies.size()); //0
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		

	}

}
