package com.shakticoin.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.ForgotPasswordPage;

public class ForgotPasswordTest extends Base {


	public ForgotPasswordPage forgotPasswordPage;	
	
	String email = prop.getProperty("email");
	String requestedFlow = prop.getProperty("requestedFlowForgotPass");
	String countryCode = prop.getProperty("countryCode");
	String mobile = prop.getProperty("mobile");
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
		forgotPasswordPage.verifyEmailOTP(email, requestedFlow);		
	}
	@Test(priority=3)
	public void sendMobileOTP() {	
		forgotPasswordPage.sendMobileOTP();		
	}
	@Test(priority=4)
	public void verifyMobileOTP() {	
		forgotPasswordPage.verifymobileOTP(countryCode, mobile, requestedFlow);		
	}
	@Test(priority=5)
	public void verifyPin() {	
		forgotPasswordPage.confirmPin(pin);		
	}
	@Test(priority=6)
	public void changePassword() {	
		forgotPasswordPage.setPassword(password);;		
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
