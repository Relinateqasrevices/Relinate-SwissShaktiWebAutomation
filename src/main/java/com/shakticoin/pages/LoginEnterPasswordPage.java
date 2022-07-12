package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class LoginEnterPasswordPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By passwordTextBox   =By.xpath("//input[@id='password']");
	By loginButton	 	 =By.xpath("//button[@id='login-button']");
	
	public LoginEnterPasswordPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public void login(String password) {
		//Enter the password click login
		elementutil.waitForElementPresent(passwordTextBox,50);
		elementutil.doSendKeys(passwordTextBox, password);
		elementutil.waitForElementToBeClickable(loginButton, 200);
		elementutil.doClick(loginButton);
	}
}
