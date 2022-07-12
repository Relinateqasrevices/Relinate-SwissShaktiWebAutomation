package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;
import com.shakticoin.utils.GetEmailOTP;
import com.shakticoin.utils.GetMobileOTP;

public class ForgotPasswordPage {
	private WebDriver driver;
	ElementUtil elementutil;

	By inputEmail = By.xpath("//input[@id='email']");
	By submitButton = By.xpath("//button[@id='submit-button']");
	By inputOTP = By.xpath("//input[@id='otp']");
	By verifyButton = By.xpath("//button[@id='verify-button']");
	By continueButton = By.xpath("//button[@id='continue-button']");
	By inputPin = By.xpath("//input[@id='pin']");
	// continueButton to submit PIN
	By inputPassword = By.xpath("//input[@id='password']");
	By repeatPassword = By.xpath("//input[@id='repeat-password']");
	By submit = By.xpath("//button[@type='submit']");
	By toLogin = By.xpath("//button[@id='go-to-login-button']");
	
	By trustedMobileLink = By.xpath("//a[@class='resendCnt']");
	By selectMobile = By.xpath("//label[@id='contentCntCheck']");
	By nextButton = By.xpath("//button[@id='send-button']");
	By skipQA = By.xpath("//div[@id='go-to-pin-button']");			
	

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public void sendEmailOTP(String email) {
		driver.navigate().to("https://qa.shakticoin.com/reset-password");
		elementutil.waitForElementPresent(inputEmail, 50);
		elementutil.doSendKeys(inputEmail, email);
		elementutil.waitForElementToBeClickable(submitButton, 50);
		elementutil.doClick(submitButton);
	}

	public void verifyEmailOTP(String email, String requestedFlow) {
		elementutil.explicitWait(3000);
		// Get OTP
		String otp = GetEmailOTP.getEmailOTP(email, requestedFlow);
		elementutil.waitForElementPresent(inputOTP, 50);
		elementutil.doSendKeys(inputOTP, otp);
		elementutil.waitForElementToBeClickable(verifyButton, 50);
		elementutil.doClick(verifyButton);
	}

	public void sendMobileOTP() {
		elementutil.waitForElementToBeClickable(continueButton, 50);
		elementutil.doClick(continueButton);
	}
	public void userTrustedMobile() {
		elementutil.waitForElementPresent(trustedMobileLink, 50);
		elementutil.doClick(trustedMobileLink);
	
		elementutil.waitForElementPresent(selectMobile, 50);
		elementutil.doClick(selectMobile);
		
		elementutil.waitForElementToBeClickable(nextButton, 50);
		elementutil.doClick(nextButton);
		/*
		 * elementutil.waitForElementPresent(skipQA, 50); elementutil.doClick(skipQA);
		 */
	}

	public void verifymobileOTP(String countryCode, String mobile, String requestedFlow) {
		elementutil.explicitWait(3000);
		// Get OTP
		String otp = GetMobileOTP.getMobileOTP(countryCode, mobile, requestedFlow);
		elementutil.waitForElementPresent(inputOTP, 50);
		elementutil.doSendKeys(inputOTP, otp);
		elementutil.waitForElementToBeClickable(verifyButton, 50);
		elementutil.doClick(verifyButton);
	}
	public void skipQA() {			
		elementutil.waitForElementToBeClickable(skipQA, 50);		
		elementutil.doClick(skipQA);		
	}

	public void confirmPin(String pin) {
		elementutil.waitForElementPresent(inputPin, 50);
		elementutil.doSendKeys(inputPin, pin);
		elementutil.waitForElementToBeClickable(submit, 50);
		elementutil.doClick(submit);
	}

	public void setPassword(String password) {
		// password
		elementutil.waitForElementPresent(inputPassword, 50);		
		elementutil.doSendKeys(inputPassword, password);		

		// confirm password
		elementutil.waitForElementPresent(repeatPassword, 50);		
		elementutil.doSendKeys(repeatPassword, password);
		
		// submit
		elementutil.waitForElementToBeClickable(submit, 50);
		elementutil.doClick(submit);
	}
}