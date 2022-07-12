package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class LoginSendMobileOTPPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By smsConfirm = By.xpath("//button[@type='submit']");	
	
	public LoginSendMobileOTPPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	
	public void sendMobileOTP() {
		//Click on Continue
		elementutil.waitForElementPresent(smsConfirm,10);		
		elementutil.doClick(smsConfirm);
	}
}
