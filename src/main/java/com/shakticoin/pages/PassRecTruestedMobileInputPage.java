package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class PassRecTruestedMobileInputPage {

	private WebDriver driver;
	ElementUtil elementutil;
		
	//By countryCode	=By.xpath("//span[@class='display-text']");
	By countryCode	=By.xpath("//span[@class='ng-arrow-wrapper']");
	By mobile	=By.xpath("//input[@id='number']");	
	By sendSMS	=By.xpath("//button[@type='submit']");
	//By searchCountry	=By.xpath("//input[@type='text']");
	//By selectCountry	=By.xpath("//span[@class='ng-option-label ng-star-inserted'][normalize-space()='(+91)']");
 	By selectCountry	=By.xpath("//span[normalize-space()='(+91)']");
	
	public PassRecTruestedMobileInputPage(WebDriver driver){		
		this.driver=driver;  
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public RegValidateMobileOTPPage sendMobileOTP(String countryCodeValue,String mobileValue) {
		/*
		 * elementutil.explicitWait(2000); elementutil.clickWhenReady(countryCode,10);
		 * elementutil.waitForElementToBeClickable(selectCountry,10);
		 * elementutil.doClick(selectCountry);
		 */
		
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