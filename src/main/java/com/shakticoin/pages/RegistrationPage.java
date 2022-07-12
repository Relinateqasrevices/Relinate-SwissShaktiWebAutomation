package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.basic.Base;
import com.shakticoin.utils.Constants;
import com.shakticoin.utils.ElementUtil;
import com.shakticoin.utils.GetEmailOTP;
import com.shakticoin.utils.GetMobileOTP;

public class RegistrationPage extends Base {

	private WebDriver driver;
	ElementUtil elementutil;
	
	By singupButton      =By.xpath("//a[@class='nav-link btn-signup']");
	By email 			 =By.xpath("//input[@id='email']");		
	//div[@class='form-label-group']//input[@id='email']
	By registerButton    =By.xpath("//button[@type='submit']");
	By emailOtpTextBox   =By.xpath("//input[@id='emailToken']");
	By emailVerifyButton =By.xpath("//button[@id='verification-button']");
	By smsConfirm		 =By.xpath("//button[@type='submit']");
	By smsOtpTextBox     =By.xpath("//input[@id='otp']");
	By smsVerifyButton	 =By.xpath("//button[@id='verification-button']");
	By passwordTextBox   =By.xpath("//input[@id='password']");
	By loginButton	 	 =By.xpath("//button[@id='login-button']");
							
	
	public RegistrationPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}	
	
	
	//Login page actions
	
	public String  getPageTitle()
	{
		return elementutil.doGetPageTitleWithIsTitle(10, Constants.LOGIN_PAGE_TITLE);
	}
	
	public boolean isSignUpExists()
	{
		
		return elementutil.doIsDisplayed(singupButton);
	}
	
	public void doLogin(String uname) throws InterruptedException
	{			
		elementutil.waitForElementToBeVisible(singupButton,30);		
		elementutil.doClick(singupButton);
		elementutil.waitForElementPresent(email,50);
		//enterEmail
		elementutil.doSendKeys(email, uname);	
		//Click send otp
		elementutil.waitForElementToBeClickable(registerButton, 200);
		elementutil.doClick(registerButton);		
		Thread.sleep(5000);	
		//Get OTP
		String otp = GetEmailOTP.getEmailOTP(uname, "login");
		//Enter OTP and click verify
		elementutil.waitForElementPresent(emailOtpTextBox,50);
		elementutil.doSendKeys(emailOtpTextBox, otp);
		elementutil.waitForElementToBeClickable(emailVerifyButton, 200);
		elementutil.doClick(emailVerifyButton);	
		//Click sms confirm
		elementutil.waitForElementToBeClickable(smsConfirm, 50);
		elementutil.doClick(smsConfirm);		
		Thread.sleep(5000);		
		//Get OTP
		otp = GetMobileOTP.getMobileOTP("+91","8074791500","login");
		//Enter sms OTP and click verify
		elementutil.waitForElementPresent(smsOtpTextBox,50);
		elementutil.doSendKeys(smsOtpTextBox, otp);
		elementutil.waitForElementToBeClickable(smsVerifyButton, 200);
		elementutil.doClick(smsVerifyButton);
		//Enter the password click login
		elementutil.waitForElementPresent(passwordTextBox,50);
		elementutil.doSendKeys(passwordTextBox, "Saurabh@1988");
		elementutil.waitForElementToBeClickable(loginButton, 200);
		elementutil.doClick(loginButton);						
		
	}	
	
}
