package com.shakticoin.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.LicensePurchasedPage;
import com.shakticoin.pages.UserDropdownMenu;

public class LicenseCancellationTest extends Base {

	public UserDropdownMenu menuOptions;
	public LicensePurchasedPage cancellationPage;
	
	
	@BeforeTest 
	public void setUp()
	{				
		System.out.println("driver at sendMobile"+driver);
		menuOptions = new UserDropdownMenu(driver);			
	}
		
	@Test(priority=1)
	public void selectAccountSettings() {		
		menuOptions.selectAccountSettings();;
	}
	@Test(priority=2)
	public void cancelLicence() throws InterruptedException {	
		cancellationPage = new LicensePurchasedPage(driver);
		cancellationPage.cancelLicense();		
	}
	/*
	 * @AfterTest public void close() { driver.close(); }
	 */
}
