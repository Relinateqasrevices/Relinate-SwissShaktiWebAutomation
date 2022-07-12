package com.shakticoin.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.PassRecUpdatePinPage;
import com.shakticoin.pages.PassRecoveryStatusPage;
import com.shakticoin.pages.RegConfirmPasswordPage;
import com.shakticoin.pages.UserDropdownMenu;

public class PassRecUpdatePinTest extends Base{
	
	String password = prop.getProperty("password");
	
	public UserDropdownMenu menuOptions;
	public PassRecoveryStatusPage passRecoveryStatusPage;
	public PassRecUpdatePinPage passRecUpdatePinPage;
	public RegConfirmPasswordPage regConfirmPasswordPage;
	
	@BeforeTest 
	public void setUp()
	{		
		
		System.out.println("driver at sendMobile"+driver);
		menuOptions = new UserDropdownMenu(driver);			
	}
		
	@Test(priority=1)
	public void selectSetPassRecoveryOption() {		
		menuOptions.selectSetPassRecovery();
	}
	@Test(priority=2)
	public void clickUpdatePin() {	
		passRecoveryStatusPage = new PassRecoveryStatusPage(driver);
		passRecoveryStatusPage.clickUpdatePin();
	}
	@Test(priority=3)
	public void updatePin() {		
		passRecUpdatePinPage = new PassRecUpdatePinPage(driver);
		passRecUpdatePinPage.updatePin("3446", "3446");
	}
	
	@Test(priority=4)
	public void confirmPassowrd() {		
		regConfirmPasswordPage = new RegConfirmPasswordPage(driver);
		regConfirmPasswordPage.confirmPassowrd(password);
	}
	@Test(priority=5)
	public void logout() {		
		menuOptions.logout();
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
