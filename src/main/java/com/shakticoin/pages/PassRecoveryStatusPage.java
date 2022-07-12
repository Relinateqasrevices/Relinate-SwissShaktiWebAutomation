package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class PassRecoveryStatusPage {

	private WebDriver driver;
	ElementUtil elementutil;

	By smsVerification    =By.xpath("//button[@id='sms-verification-button']");			
	By emailVerification    =By.xpath("//button[@id='email-verification-button']");
	By securityQA		 =By.xpath("//button[@id='answer-security-button']");
	By updatePin		 =By.xpath("//button[@id='password-recovery-button']");
	
	public PassRecoveryStatusPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public void clickSMSVerification() {
		elementutil.waitForElementPresent(smsVerification,10);	
		elementutil.doClick(smsVerification);	
	}
	public void clickEmailVerification() {
		elementutil.waitForElementPresent(emailVerification,10);	
		elementutil.doClick(emailVerification);	
	}
	public void clickSecurityQA() {
		elementutil.waitForElementPresent(securityQA,10);	
		elementutil.doClick(securityQA);	
	}
	public void clickUpdatePin() {
		elementutil.waitForElementPresent(updatePin,10);	
		elementutil.doClick(updatePin);	
	}
}
