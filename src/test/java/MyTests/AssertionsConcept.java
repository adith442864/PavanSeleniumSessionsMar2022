package MyTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AssertionsConcept {
	
	@Test
	public void test() {
		int a=10;
		int b=20;
		
		String s1="abc";
		String s2="xyz";
		
		//Assert.assertTrue(a==b); //false
		//Assert.assertFalse(a==b);
		//assert.fail();
		//Assert.assertEquals(a, b,"Values are not equal");
		//Assert.assertEquals(s1, s2,"Values are not equal...");
		
		
		//Hard assertions
		//Soft assertions
	
	} 
	/*
	@Test
	public void hard_assertions() {
		Assert.assertEquals("abc", "xyz");
		System.out.println("hard assertion is completed...");
	}*/
	
	@Test
	public void soft_assertions() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("abc", "xyz");
		System.out.println("soft assertion is completed...");
		softAssert.assertAll(); //must be specified at the end of the statement..
		
	}
	

}
