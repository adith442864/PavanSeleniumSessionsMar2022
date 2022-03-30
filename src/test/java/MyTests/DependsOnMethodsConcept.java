package MyTests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.*;

public class DependsOnMethodsConcept {
	
	@Test(priority=1)
	public void openURL() {
		Assert.assertTrue(true);	
	}
	
	
	@Test(priority=2, dependsOnMethods = {"openURL"})
	public void login() {
		//Assert.assertTrue(false);
		Assert.assertTrue(true);
	}
	
	@Test(priority=3,dependsOnMethods = {"login"})
	public void search() {
		//Assert.assertTrue(true);
		Assert.assertTrue(false);
	}
	
	@Test(priority=4,dependsOnMethods = {"login", "search"})
	public void advSearch() {
		Assert.assertTrue(true);
	}
	
	@Test(priority=5,dependsOnMethods = {"login"})
	public void logout() {
		Assert.assertTrue(true);
	}
	
	
	

}
