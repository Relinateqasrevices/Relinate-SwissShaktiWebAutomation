package com.shakticoin.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.PassRecEmailOptionsPage;
import com.shakticoin.pages.PassRecTrustedEmailInputPage;
import com.shakticoin.pages.PassRecTrustedEmailOTPVerifyPage;
import com.shakticoin.pages.PassRecoveryStatusPage;
import com.shakticoin.pages.RegConfirmPasswordPage;
import com.shakticoin.pages.UserDropdownMenu;

public class PassRecAddTrustedEmailTest extends Base {

	String trustedEmail = prop.getProperty("trustedEmail");
	String requestedFlowTrustedMobile = prop.getProperty("requestedFlowTrustedEmail");
	String password = prop.getProperty("password");
	
	public UserDropdownMenu menuOptions;
	public PassRecoveryStatusPage passRecoveryStatusPage;
	public PassRecEmailOptionsPage passRecEmailOptionsPage;
	public PassRecTrustedEmailInputPage passRecTruestedEmailInputPage;
	public PassRecTrustedEmailOTPVerifyPage passRecTrustedEmailOTPVerifyPage;
	public RegConfirmPasswordPage regConfirmPasswordPage;
	
	@BeforeTest 
	public void setUp()
	{		
		/*
		 * basepage=new Base(); driver=basepage.init_driver(driver);
		 */	
		System.out.println("driver at sendMobile"+driver);
		menuOptions = new UserDropdownMenu(driver);			
	}
		
	@Test(priority=1)
	public void selectSetPassRecoveryOption() {		
		menuOptions.selectSetPassRecovery();
	}
	@Test(priority=2)
	public void clickEmailVerification() {	
		passRecoveryStatusPage = new PassRecoveryStatusPage(driver);
		passRecoveryStatusPage.clickEmailVerification();
	}
	@Test(priority=3)
	public void clickAddtrustedEmailButton() {		
		passRecEmailOptionsPage = new PassRecEmailOptionsPage(driver);
		passRecEmailOptionsPage.clickAddtrustedEmailButton();
	}
	@Test(priority=4)
	public void sendEmailOTP() {		
		passRecTruestedEmailInputPage = new PassRecTrustedEmailInputPage(driver);
		passRecTruestedEmailInputPage.sendEmailOTP(trustedEmail);
	}
	@Test(priority=5)
	public void validateOTP() {		
		passRecTrustedEmailOTPVerifyPage = new PassRecTrustedEmailOTPVerifyPage(driver);
		passRecTrustedEmailOTPVerifyPage.inputOTP(trustedEmail, requestedFlowTrustedMobile);
	}
	@Test(priority=6)
	public void confirmPassowrd() {		
		regConfirmPasswordPage = new RegConfirmPasswordPage(driver);
		regConfirmPasswordPage.confirmPassowrd(password);
	}
}
