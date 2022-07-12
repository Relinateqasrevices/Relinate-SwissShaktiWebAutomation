package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class LoginConfirmMobilePage {
	private WebDriver driver;
	ElementUtil elementutil;

	By smsConfirm = By.xpath("//button[@type='submit']");
	
	By mobile = By.xpath("//p[@class='mb-0']");

	public LoginConfirmMobilePage(WebDriver driver) {
		System.out.println("driver at constructor"+driver);
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	

	public RegValidateMobileOTPPage confirmMobile() {
	
		elementutil.waitForElementPresent(smsConfirm, 10);
		
		elementutil.doClick(smsConfirm);
		
		return null;//new  RegValidateMobileOTPPage(driver);
	}
}
