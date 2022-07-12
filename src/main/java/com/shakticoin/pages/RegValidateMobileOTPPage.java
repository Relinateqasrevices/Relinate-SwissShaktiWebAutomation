package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;
import com.shakticoin.utils.GetMobileOTP;

public class RegValidateMobileOTPPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By smsOtpTextBox     =By.xpath("//input[@id='otp']");
	By smsVerifyButton	 =By.xpath("//button[@id='verification-button']");
	
	public RegValidateMobileOTPPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public LoginEnterPasswordPage validateMobileOTP(String countryCode,String mobile,String requestedFlow) {
		validateMobile(countryCode,mobile,requestedFlow);
		return null;//new LoginEnterPasswordPage(driver);
	}
	public RegSetPasswordPage validateMobileOTPReg(String countryCode,String mobile,String requestedFlow) {
		validateMobile(countryCode,mobile,requestedFlow);
		return new RegSetPasswordPage(driver);
	}
	public void validateMobile(String countryCode,String mobile,String requestedFlow) {
		elementutil.explicitWait(5000);			
		//Get OTP
		String otp = GetMobileOTP.getMobileOTP(countryCode, mobile, requestedFlow);
		//Enter sms OTP and click verify
		elementutil.waitForElementPresent(smsOtpTextBox,50);
		elementutil.doSendKeys(smsOtpTextBox, otp);
		elementutil.waitForElementToBeClickable(smsVerifyButton, 200);
		elementutil.doClick(smsVerifyButton);	
	}
}
