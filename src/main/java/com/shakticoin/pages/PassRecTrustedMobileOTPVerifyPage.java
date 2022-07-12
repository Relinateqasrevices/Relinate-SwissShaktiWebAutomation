package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;
import com.shakticoin.utils.GetMobileOTP;

public class PassRecTrustedMobileOTPVerifyPage {
	private WebDriver driver;
	ElementUtil elementutil;

	
	
	By inputOTP = By.xpath("//input[@id='otp']");
	By continueButton = By.xpath("//app-recover-password-sms-otp//button[@type='submit']");	

	public PassRecTrustedMobileOTPVerifyPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public String getHeading() {
		return null;
	}

	public String getHeading2() {
		return null;
	}

	public void inputOTP(String countryCode,String mobile,String requestedFlow) {
		elementutil.explicitWait(3000);			
		//Get OTP
		String otp = GetMobileOTP.getMobileOTP(countryCode, mobile, requestedFlow);
		elementutil.waitForElementPresent(inputOTP, 10);
		elementutil.doSendKeys(inputOTP,otp);
		elementutil.waitForElementToBeClickable(continueButton, 10);
		elementutil.doClick(continueButton);
	}
}
