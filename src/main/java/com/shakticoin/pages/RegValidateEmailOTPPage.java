package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;
import com.shakticoin.utils.GetEmailOTP;
import com.shakticoin.utils.GetUserStatus;

public class RegValidateEmailOTPPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By emailOtpTextBox   =By.xpath("//input[@id='emailToken']");
	By emailVerifyButton =By.xpath("//button[@id='verification-button']");
	
	public RegValidateEmailOTPPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public LoginConfirmMobilePage validateEmailOTP(String emailID,String requestedFlow) {
		validateEmail(emailID,requestedFlow);
		return null; //new LoginConfirmMobilePage(driver);
	}
	
	public RegEnterMobileNumberPage validateEmailOTPReg(String emailID,String requestedFlow) {
		validateEmail(emailID,requestedFlow);
		return new RegEnterMobileNumberPage(driver);
	}
	public void validateEmail(String emailID,String requestedFlow) {
		elementutil.explicitWait(8000);	
		//Get OTP
		String otp = GetEmailOTP.getEmailOTP(emailID, requestedFlow);
		//Enter OTP and click verify
		elementutil.waitForElementPresent(emailOtpTextBox,50);
		elementutil.doSendKeys(emailOtpTextBox, otp);
		elementutil.waitForElementToBeClickable(emailVerifyButton, 200);
		elementutil.doClick(emailVerifyButton);	
		
		
	}
	
	 
}
