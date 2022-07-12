package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class UserDropdownMenu {
	private WebDriver driver;
	ElementUtil elementutil;
	
	 
	By dropdownMenu    =By.xpath("//a[@id='dropdownMenuButton'] ");			
	By passwordMenu    =By.xpath("//a[@id='dropdownMenuPassword']");
	By userSettingsMenu=By.xpath("//a[@id='dropdownMenuUserSettings']");			
	By accountsMenu    =By.xpath("//a[normalize-space()='Account Settings']");
	By setPassRecOption=By.xpath("//a[normalize-space()='Set Password Recovery']");
	By logout 		   =By.xpath("//a[normalize-space()='Logout']");
	
	public UserDropdownMenu(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public void selectSetPassRecovery() {
		elementutil.explicitWait(5000);
		elementutil.waitForElementPresent(dropdownMenu,10);	
		elementutil.doClick(dropdownMenu);	

		elementutil.waitForElementPresent(passwordMenu, 10);
		elementutil.doClick(passwordMenu);
		
		elementutil.waitForElementPresent(setPassRecOption, 10);
		elementutil.doClick(setPassRecOption);			
	}
	public void selectAccountSettings() {
		elementutil.explicitWait(5000);
		elementutil.waitForElementPresent(dropdownMenu,10);	
		elementutil.doClick(dropdownMenu);	

		elementutil.waitForElementPresent(userSettingsMenu, 10);
		elementutil.doClick(userSettingsMenu);
		
		elementutil.waitForElementPresent(accountsMenu, 10);
		elementutil.doClick(accountsMenu);			
	}
	
	public void logout() {
		elementutil.explicitWait(3000);
		elementutil.waitForElementPresent(dropdownMenu,10);
		elementutil.doClick(dropdownMenu);
		elementutil.waitForElementPresent(logout,10);	
		elementutil.doClick(logout);			
	}
}
