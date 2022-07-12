package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;
import com.shakticoin.utils.GetEmailOTP;

public class PassRecTrustedEmailOTPVerifyPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By inputOTP = By.xpath("//input[@id='otp']");
	By continueButton = By.xpath("//app-recover-password-email-otp//button[@type='submit']");	

	public PassRecTrustedEmailOTPVerifyPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public String getHeading() {
		return null;
	}

	public String getHeading2() {
		return null;
	}

	public void inputOTP(String email,String requestedFlow) {
		elementutil.explicitWait(3000);			
		//Get OTP
		String otp = GetEmailOTP.getEmailOTP(email, requestedFlow);
		elementutil.waitForElementPresent(inputOTP, 10);
		elementutil.doSendKeys(inputOTP,otp);
		elementutil.waitForElementPresent(continueButton, 10);
		elementutil.doClick(continueButton);
	}
}
