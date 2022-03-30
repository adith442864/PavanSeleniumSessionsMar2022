package MyTests;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class GroupingTestConcept {
	/*
	 * sanity:
	 * loginByfacebook
	 * loginBytwitter
	 * paymentindollar
	 * 
	 * regression:
	 * signupbyfacebook
	 * signupbytwitter
	 * paymentinrupees
	 * 
	 * sanity + regression
	 * loginByEmail
	 * signupByEmail
	 * paymentReturnbyBank
	 */
	
	@Test(priority=1,groups= {"sanity", "regression"})
	public void loginByEmail() {
		System.out.println("login by email..");
	}
	@Test(priority=2,groups= {"sanity"} )
	public void loginByFacebook() {
		System.out.println("login by facebook..");
	}
	
	@Test(priority=3,groups= {"sanity"})
	public void loginByTwitter() {
		System.out.println("login by twitter..");
	}


	@Test(priority=4,groups= {"sanity", "regression"})
	public void signUpByEmail() {
		System.out.println("sign up by email..");
	}
	
	@Test(priority=5,groups= {"regression"})
	public void signUpByFacebook() {
		System.out.println("sign up by facebook..");
	}
	
	@Test(priority=6,groups= {"regression"})
	public void signUpByTwitter() {
		System.out.println("sign up by twitter..");
	}
	
	@Test(priority=7,groups= {"regression"})
	public void payment_In_Rupees() {
		System.out.println("login by facebook..");
	}
	
	@Test(priority=8,groups= {"sanity"})
	public void payment_In_Dollar() {
		System.out.println("payment in dollar");
	}
	
	@Test(priority=9,groups= {"sanity", "regression"})
	public void paymentReturnByBank() {
		System.out.println("payment return by bank..");
	}
	
	

}
