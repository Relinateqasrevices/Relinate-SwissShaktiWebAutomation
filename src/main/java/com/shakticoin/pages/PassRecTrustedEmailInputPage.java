package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class PassRecTrustedEmailInputPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By email 			 =By.xpath("//input[@id='emailId']");			
	By continueButton    =By.xpath("//button[@type='submit']");
	
	public PassRecTrustedEmailInputPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public RegValidateEmailOTPPage sendEmailOTP(String emailID) {
		elementutil.waitForElementPresent(email,10);
		//enterEmail
		elementutil.doSendKeys(email, emailID);	
		//Click send otp
		elementutil.waitForElementToBeClickable(continueButton, 10);
		elementutil.doClick(continueButton);
		return new RegValidateEmailOTPPage(driver);
	}

}
