package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.shakticoin.utils.ElementUtil;

public class RegEnterMobileNumberPage{
	private WebDriver driver;
	ElementUtil elementutil;
		
	By countryCode	=By.xpath("//span[@class='ng-arrow-wrapper']");
	//div[@role='combobox'] 
	By mobile	=By.xpath("//input[@id='number']");	
	By sendSMS	=By.xpath("//button[@type='submit']");
	By searchCountry	=By.xpath("//input[@type='text']");
	//By selectCountry	=By.xpath("//li[@class='ng-star-inserted']");
	By selectCountry	=By.xpath("//span[normalize-space()='(+91)']");
	//li[contains(text(),'IN (+91)')]
	
	//N
	By signupButton =By.xpath("//a[@class='nav-link btn-signup']");	
	By enterregisterMobilenumber=By.xpath("//input[@id='number']");
	By registerInvaldmobilenumberMessage=By.xpath("//div[text()='Valid Mobile Number is required']");
	
	public RegEnterMobileNumberPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	public String invalidmobileNumber()
	{
		/*
		 * elementutil.waitForElementPresent(email, 10); elementutil.doSendKeys(email,
		 * "tnarayanat@gmail.com"); elementutil.waitForElementPresent(registerButton,
		 * 10); elementutil.doActionsClick(registerButton); String
		 * otp=getemailotp.getEmailOTP("tnarayanat@gmail.com",
		 * "User_Email_Register_Flow");
		 * elementutil.doSendKeys(enterInvalidEmailVerificationCode, otp);
		 * //elementutil.waitForElementPresent(emailVerificationContinueButton, 10);
		 * elementutil.doActionsClick(emailVerificationContinueButton);
		 */
		elementutil.waitForElementPresent(enterregisterMobilenumber, 10);
		elementutil.doSendKeys(enterregisterMobilenumber, "9652065799");
		Actions act = new Actions(driver);		   
	    act.sendKeys(Keys.TAB).build().perform();		   
	    elementutil.waitForElementPresent(enterregisterMobilenumber, 10);
	   return elementutil.doGetText(registerInvaldmobilenumberMessage);		   				 		
	}
	public RegValidateMobileOTPPage sendMobileOTP(String countryCodeValue,String mobileValue) {
		elementutil.explicitWait(4000);
		
		elementutil.clickWhenReady(countryCode,20);				 	
		elementutil.waitForElementToBeClickable(selectCountry,10);
		elementutil.doClick(selectCountry);
		//elementutil.selectValuesFromDropDown(countryCode, "IN (+91)");
		return 	enterMobileNumber(mobileValue);
	}
	
	public RegValidateMobileOTPPage enterMobileNumber(String mobileValue) {
		elementutil.waitForElementPresent(mobile,10);
		elementutil.doSendKeys(mobile, mobileValue);		
		return confirmMobile();
	}
	public RegValidateMobileOTPPage confirmMobile() {
		elementutil.waitForElementToBeClickable(sendSMS, 10);
		elementutil.doClick(sendSMS);
		return new RegValidateMobileOTPPage(driver);
	}
}