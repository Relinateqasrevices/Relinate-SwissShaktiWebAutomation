package com.shakticoin.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.LicenseMiningPage;
import com.shakticoin.pages.LicenseOrderSummaryPage;
import com.shakticoin.pages.LicensePaymentMethodsPage;

public class PurchaseLicenseAmazonTest extends Base{
	
	public LicenseMiningPage miningLicensePage;
	public LicenseOrderSummaryPage orderSummaryPage;
	public LicensePaymentMethodsPage paymentMethodsPage;	

	
	String country = prop.getProperty("countryAmazon");
	String state = prop.getProperty("stateAmazon");
	String city = prop.getProperty("cityAmazon");
	String zip = prop.getProperty("zipCode");
	String street = prop.getProperty("street");
	String street1 = prop.getProperty("street1");
	String username = prop.getProperty("usernameAmazon");
	String password = prop.getProperty("passwordAmazon");

	

	@BeforeTest
	public void setUp() {		
		miningLicensePage=new LicenseMiningPage(driver);			
	}

	@Test(priority = 1,dataProvider ="getData")
	public void purchaseLicense(String licenseType,String licenseValidity) {
		orderSummaryPage = miningLicensePage.selectSubscription(licenseType,licenseValidity);
		paymentMethodsPage = orderSummaryPage.addressDetails(zip,country,state,city,street,street1,1);
		paymentMethodsPage.selectPaymentMethodAmazonPay(username,password);		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2];
		data[0][0] = "//p[normalize-space()='Basic Miner License']";
		data[0][1] = "//div[normalize-space()='weekly']";			
		
		data[1][0] = "//p[normalize-space()='Basic Miner License']";
		data[1][1] = "//div[normalize-space()='monthly']";		
		
		data[2][0] = "//p[normalize-space()='Basic Miner License']";
		data[2][1] = "//div[normalize-space()='annual']";		
		
		/*data[3][0] = "//p[normalize-space()='Power Miner Tier 1']";
		data[3][1] = "//div[normalize-space()='weekly']";
		
		
		data[4][0] = "//p[normalize-space()='Power Miner Tier 1']";
		data[4][1] = "//div[normalize-space()='monthly']";
		
		
		data[5][0] = "//p[normalize-space()='Power Miner Tier 1']";
		data[5][1] = "//div[normalize-space()='annual']";
		
		
		data[6][0] = "//p[normalize-space()='Power Miner Tier 2']";
		data[6][1] = "//div[normalize-space()='weekly']";
		
	
		data[7][0] = "//p[normalize-space()='Power Miner Tier 2']";
		data[7][1] = "//div[normalize-space()='monthly']";
		
		
		data[8][0] = "//p[normalize-space()='Power Miner Tier 2']";
		data[8][1] = "//div[normalize-space()='annual']";
		
		
		data[9][0] = "//p[normalize-space()='Power Miner Tier 3']";
		data[9][1] = "//div[normalize-space()='weekly']";
		
		
		data[10][0] = "//p[normalize-space()='Power Miner Tier 3']";
		data[10][1] = "//div[normalize-space()='monthly']";
		
		
		data[11][0] = "//p[normalize-space()='Power Miner Tier 3']";
		data[11][1] = "//div[normalize-space()='annual']";
		
		
		data[12][0] = "//p[normalize-space()='Power Miner Tier 4']";
		data[12][1] = "//div[normalize-space()='weekly']";
		
		
		data[13][0] = "//p[normalize-space()='Power Miner Tier 4']";
		data[13][1] = "//div[normalize-space()='monthly']";
		
		
		data[14][0] = "//p[normalize-space()='Power Miner Tier 4']";
		data[14][1] = "//div[normalize-space()='annual']";*/
		
		
		return data;		
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}