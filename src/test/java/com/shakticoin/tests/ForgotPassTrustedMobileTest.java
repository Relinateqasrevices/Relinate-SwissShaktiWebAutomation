package com.shakticoin.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.ForgotPasswordPage;

public class ForgotPassTrustedMobileTest extends Base {


	public ForgotPasswordPage forgotPasswordPage;	
	
	String email = prop.getProperty("email");
	String requestedFlowMobile = prop.getProperty("requestedFlowForgotPassTrusted");
	String requestedFlowEmail = prop.getProperty("requestedFlowForgotPass");
	String countryCode = prop.getProperty("countryCode");
	String trustedMobile = prop.getProperty("trustedMobile");
	String pin = prop.getProperty("pin");
	String password = prop.getProperty("password");
	
	@BeforeTest 
	public void setUp()
	{	init_driver();			
		System.out.println("driver at forgotpass"+driver);
		forgotPasswordPage = new ForgotPasswordPage(driver);			
	}
		
	@Test(priority=1)
	public void sendEmailOTP() {	
		
		forgotPasswordPage.sendEmailOTP(email);
	}
	@Test(priority=2)
	public void verifyEmailOTP() {	
		forgotPasswordPage.verifyEmailOTP(email, requestedFlowEmail);		
	}
	@Test(priority=3)
	public void useTrustedMobile() {	
		forgotPasswordPage.userTrustedMobile();		
	}
	@Test(priority=4)
	public void verifyMobileOTP() {	
		forgotPasswordPage.verifymobileOTP(countryCode, trustedMobile, requestedFlowMobile);		
	}
	@Test(priority=5)
	public void skipQA() throws InterruptedException {	
		Thread.sleep(3000);
		forgotPasswordPage.skipQA();		
	}
	@Test(priority=6)
	public void verifyPin() {	
		forgotPasswordPage.confirmPin(pin);		
	}
	@Test(priority=7)
	public void changePassword() {	
		forgotPasswordPage.setPassword(password);;		
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}