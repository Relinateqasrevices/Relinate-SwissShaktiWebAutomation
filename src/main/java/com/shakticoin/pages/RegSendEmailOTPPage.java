package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shakticoin.utils.ElementUtil;

public class RegSendEmailOTPPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By email 			 =By.xpath("//input[@id='email']");			
	By registerButton    =By.xpath("//button[@type='submit']");
	
	//N
	By invalidEmailErrorMessage    =By.xpath("//div[@class='error-message ng-star-inserted']");
	By invalidEmailVerificationCodeMessage=By.xpath("//span[text()='Invalid Email Verification Code']");
	By enterInvalidEmailVerificationCode=By.xpath("//input[@id='emailToken']");
	By emailVerificationContinueButton=By.xpath("//button[@id='verification-button']");
	
	int val=10;
	
	public RegSendEmailOTPPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	//N
	public String invalidEmailFormat()
	{
		elementutil.waitForElementPresent(email, 10);
		elementutil.doSendKeys(email, "tnara@@@a.cm");
		
		elementutil.waitForElementPresent(invalidEmailErrorMessage, 10);
		return elementutil.doGetText(invalidEmailErrorMessage);
	}
	
	public String invalidEmailVerificationCode()
	{   
		elementutil.waitForElementPresent(email, 10);
		elementutil.doSendKeys(email, "tnarayanat@gmail.com");
		
		elementutil.waitForElementPresent(registerButton, 10);
		elementutil.doActionsClick(registerButton);
		elementutil.waitForElementPresent(enterInvalidEmailVerificationCode, 10);
		elementutil.doSendKeys(enterInvalidEmailVerificationCode, "123456");
		elementutil.waitForElementPresent(emailVerificationContinueButton, 10);
		elementutil.doActionsClick(emailVerificationContinueButton);
		elementutil.waitForElementPresent(enterInvalidEmailVerificationCode, 10);
		elementutil.waitForElementPresent(invalidEmailVerificationCodeMessage, 10);
		return elementutil.doGetText(invalidEmailVerificationCodeMessage);
	}
	
	public RegValidateEmailOTPPage sendEmailOTP(String emailID) {
		elementutil.explicitWait(5000);		 
		elementutil.waitForElementPresent(email,200);
		//enterEmail
		elementutil.doSendKeys(email, emailID);	
		//Click send otp
		elementutil.waitForElementToBeClickable(registerButton, 200);
		elementutil.doClick(registerButton);
		return new RegValidateEmailOTPPage(driver);
	}	
	
public static void main(String[] args) {
	RegSendEmailOTPPage obj = new RegSendEmailOTPPage(null);
	System.out.println(obj.val);
}	
}