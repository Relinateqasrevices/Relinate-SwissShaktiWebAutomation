package com.shakticoin.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.LoginSendMobileOTPPage;
import com.shakticoin.pages.PassRecMobileOptionsPage;
import com.shakticoin.pages.PassRecTruestedMobileInputPage;
import com.shakticoin.pages.PassRecTrustedMobileOTPVerifyPage;
import com.shakticoin.pages.PassRecoveryStatusPage;
import com.shakticoin.pages.RegConfirmPasswordPage;
import com.shakticoin.pages.UserDropdownMenu;

public class PassRecAddTrustedMobileTest extends Base {

	String countryCode = prop.getProperty("countryCode");
	String trustedMobile = prop.getProperty("trustedMobile");
	String requestedFlowTrustedMobile = prop.getProperty("requestedFlowTrustedMobile");
	String password = prop.getProperty("password");
	
	public UserDropdownMenu menuOptions;
	public PassRecoveryStatusPage passRecoveryStatusPage;
	public PassRecMobileOptionsPage passRecSMSVerifcationPage;
	public PassRecTruestedMobileInputPage passRecTruestedMobileInputPage;
	public PassRecTrustedMobileOTPVerifyPage passRecTrustedMobileOTPVerifyPage;
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
	public void clickSMSVerification() {	
		passRecoveryStatusPage = new PassRecoveryStatusPage(driver);
		passRecoveryStatusPage.clickSMSVerification();
	}
	@Test(priority=3)
	public void clickAddtrustedMobileButton() {		
		passRecSMSVerifcationPage = new PassRecMobileOptionsPage(driver);
		passRecSMSVerifcationPage.clickAddtrustedMobileButton();
	}
	@Test(priority=4)
	public void sendMobileOTP() {		
		passRecTruestedMobileInputPage = new PassRecTruestedMobileInputPage(driver);
		passRecTruestedMobileInputPage.sendMobileOTP(countryCode,trustedMobile);
	}
	@Test(priority=5)
	public void validateOTP() {		
		passRecTrustedMobileOTPVerifyPage = new PassRecTrustedMobileOTPVerifyPage(driver);
		passRecTrustedMobileOTPVerifyPage.inputOTP(countryCode,trustedMobile,requestedFlowTrustedMobile);
	}
	@Test(priority=6)
	public void confirmPassowrd() {		
		regConfirmPasswordPage = new RegConfirmPasswordPage(driver);
		regConfirmPasswordPage.confirmPassowrd(password);
	}
}
