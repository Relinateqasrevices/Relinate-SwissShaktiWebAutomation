package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class RegConfirmPasswordPage {

	private WebDriver driver;
	ElementUtil elementutil;
			
	
	By password			=By.xpath("//input[@id='password']");	
	By submitButton		=By.xpath("//button[@type='submit']");	
	
	public RegConfirmPasswordPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public RegConfirmPasswordPage confirmPassowrd(String passwordValue) {
		
		elementutil.explicitWait(2000);
		elementutil.waitForElementPresent(password,10);
		elementutil.doSendKeys(password, passwordValue);
		
		//submit
		elementutil.waitForElementToBeClickable(submitButton, 10);
		elementutil.doClick(submitButton);
		return new RegConfirmPasswordPage(driver);
	}
}
