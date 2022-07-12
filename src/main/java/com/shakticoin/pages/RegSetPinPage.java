package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class RegSetPinPage {

	private WebDriver driver;
	ElementUtil elementutil;
			
	
	By pin			=By.xpath("//input[@id='pin']");
	By confirmpin	=By.xpath("//input[@id='confirmpin']");	
	By hint			=By.xpath("//textarea[@id='hint']");
	By continueButton	=By.xpath("//button[@id='continue-button']");
	
	
	public RegSetPinPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public RegConfirmPasswordPage setPin(String pinValue,String hintValue) {
		elementutil.explicitWait(2000);
		//pin
		elementutil.waitForElementPresent(pin,10);
		elementutil.doSendKeys(pin, pinValue);
		//confirm pin
		elementutil.waitForElementPresent(confirmpin,10);
		elementutil.doSendKeys(confirmpin, pinValue);
		
		//hint
		elementutil.waitForElementPresent(hint,10);
		elementutil.doSendKeys(hint, pinValue);
		
		//submit
		elementutil.waitForElementToBeClickable(continueButton, 10);
		elementutil.doClick(continueButton);
		return new RegConfirmPasswordPage(driver);
	}
}
