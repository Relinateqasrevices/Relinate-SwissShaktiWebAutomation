package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class RegSetPasswordPage {
	private WebDriver driver;
	ElementUtil elementutil;
			
	
	By password			=By.xpath("//input[@id='password']");
	By confirmPassword	=By.xpath("//input[@id='repeat-password']");	
	By checkBox			=By.xpath("//label[@class='container-check my-25']//span[@class='checkmark']");
	By confirmButton	=By.xpath("//button[@type='submit']");
	
	
	public RegSetPasswordPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public RegSetPinPage setPassword(String passwordValue) {
		elementutil.explicitWait(2000);
		System.out.println(passwordValue+"1");
		//password
		elementutil.waitForElementPresent(password,10);
		System.out.println(passwordValue+"2");
		elementutil.doSendKeys(password, passwordValue);
		System.out.println(passwordValue+"3");
		
		//confirm password
		elementutil.waitForElementPresent(confirmPassword,10);
		System.out.println(passwordValue+"4");
		elementutil.doSendKeys(confirmPassword, passwordValue);
		System.out.println(passwordValue+"5");
		
		//checkbox
		elementutil.waitForElementPresent(checkBox,10);
		elementutil.doClick(checkBox);
		
		//submit
		elementutil.waitForElementToBeClickable(confirmButton, 50);
		elementutil.doClick(confirmButton);
		return new RegSetPinPage(driver);
	}
}
