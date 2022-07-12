package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.basic.Base;
import com.shakticoin.utils.ElementUtil;

//input[@id='pin']  //input[@id='newpin'] //input[@id='confirmpin'] //button[@id='continue-button']
public class PassRecUpdatePinPage extends Base{
	private WebDriver driver;
	ElementUtil elementutil;
	
	By pin = By.xpath("//input[@id='pin']");
	By newPin = By.xpath("//input[@id='newpin']");	
	By confirmpin = By.xpath("//input[@id='confirmpin']");
	By submitButton = By.xpath("//button[@id='continue-button']");	

	public PassRecUpdatePinPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public String getHeading() {
		return null;
	}

	public String getHeading2() {
		return null;
	}

	public void updatePin(String oldPin,String newPinValue) {
		elementutil.explicitWait(1000);			
		
		elementutil.waitForElementPresent(pin, 10);
		elementutil.doSendKeys(pin,oldPin);
		elementutil.waitForElementPresent(newPin, 10);
		elementutil.doSendKeys(newPin,oldPin);
		elementutil.waitForElementPresent(confirmpin, 10);
		elementutil.doSendKeys(confirmpin,oldPin);
		elementutil.waitForElementToBeClickable(submitButton, 10);
		elementutil.doClick(submitButton);
	}
}
