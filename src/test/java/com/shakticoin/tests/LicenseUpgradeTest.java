package com.shakticoin.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.LicenseOrderSummaryPage;
import com.shakticoin.pages.LicensePaymentMethodsPage;
import com.shakticoin.pages.LicensePaymentPage;
import com.shakticoin.pages.LicensePurchasedPage;
import com.shakticoin.pages.UserDropdownMenu;

public class LicenseUpgradeTest extends Base{

	public UserDropdownMenu menuOptions;
	public LicensePurchasedPage purchasedLicensesPage;	
	public LicenseOrderSummaryPage orderSummaryPage;
	public LicensePaymentMethodsPage paymentMethodsPage;
	public LicensePaymentPage paymentPage;

	
	String country = prop.getProperty("country");
	String state = prop.getProperty("state");
	String city = prop.getProperty("city");
	String zip = prop.getProperty("zipCode");
	String street = prop.getProperty("street");
	String street1 = prop.getProperty("street1");
	
	@BeforeTest 
	public void setUp()
	{						
		menuOptions = new UserDropdownMenu(driver);			
	}
		
	@Test(priority=1)
	public void selectAccountSettings() {		
		menuOptions.selectAccountSettings();;
	}
	@Test(priority=2)
	public void upgradeLicense() {	
		purchasedLicensesPage = new LicensePurchasedPage(driver);
		purchasedLicensesPage.upgradeLicense();		
	}

	/*
	 * @Test(priority=3) public void fillAddressDetails() { orderSummaryPage = new
	 * LicenseOrderSummaryPage(driver);
	 * orderSummaryPage.addressDetails(zip,country,state,city,street,street1); }
	 */
	@Test(priority=4)
	public void selectPaymentMethod() {	
		paymentMethodsPage = new LicensePaymentMethodsPage(driver);
		paymentMethodsPage.selectPaymentMethod();		
	}
	@Test(priority=5)
	public void doPayment() {	
		paymentPage = new LicensePaymentPage(driver);
		paymentPage.purchaseLicense(zip, country, state, city, street);		
	}
}