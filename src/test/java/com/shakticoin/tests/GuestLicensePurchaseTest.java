package com.shakticoin.tests;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.LicenseMiningPage;
import com.shakticoin.pages.LicenseOrderSummaryPage;
import com.shakticoin.pages.LicensePaymentMethodsPage;
import com.shakticoin.pages.LicensePaymentPage;
import com.shakticoin.utils.GetUserStatus;

public class GuestLicensePurchaseTest extends Base{

	public LicenseMiningPage miningLicensePage;
	public LicenseOrderSummaryPage orderSummaryPage;
	public LicensePaymentMethodsPage paymentMethodsPage;
	public LicensePaymentPage paymentPage;

	
	String country = prop.getProperty("country");
	String state = prop.getProperty("state");
	String city = prop.getProperty("city");
	String zip = prop.getProperty("zipCode");
	String street = prop.getProperty("street");
	String street1 = prop.getProperty("street1");
	String guestEmail = prop.getProperty("guestEmail");	
	String requestedFlowGuest = prop.getProperty("requestedFlowGuest");	
	boolean userStatus=false;

	@BeforeTest
	public void setUp() {
		init_driver();
		miningLicensePage=new LicenseMiningPage(driver);
		userStatus = GetUserStatus.getUserStatus(guestEmail);
	}

	@Test(priority = 1,dataProvider ="getData")
	public void purchaseLicense(String licenseType,String licenseValidity,int index) {
		if(userStatus)
			throw new SkipException("User is already registered skipping this");
		orderSummaryPage = miningLicensePage.selectSubscription(licenseType,licenseValidity);
		paymentMethodsPage = orderSummaryPage.addressDetailsGuest(zip,country,state,city,street,street1,guestEmail,requestedFlowGuest,index);
		paymentPage = paymentMethodsPage.selectPaymentMethod();
		paymentPage.purchaseLicense(zip, country, state, city, street);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[1][3];
		
		for(int i=0;i<1;i++) {
			data[i][0] = "//p[normalize-space()='Basic Miner License']";
			data[i][1] = "//div[normalize-space()='weekly']";
			data[i][2] = i+1;			
		}
		
		/*
		 * data[1][0] = "//p[normalize-space()='Basic Miner License']"; data[1][1] =
		 * "//div[normalize-space()='monthly']";
		 * 
		 * data[2][0] = "//p[normalize-space()='Basic Miner License']"; data[2][1] =
		 * "//div[normalize-space()='annual']";
		 */		
		
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