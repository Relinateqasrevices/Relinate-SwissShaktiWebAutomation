package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;
import com.shakticoin.utils.GetEmailOTP;

public class LicenseOrderSummaryPage {
	private WebDriver driver;
	ElementUtil elementutil;	  	 
	
	By zip   =By.xpath("//input[@id='zip']");
	//By countryDropdown    =By.xpath("//span[normalize-space()='Select Country']");
	By countryDropdown    =By.xpath("//span[@class='ng-arrow-wrapper']");
	//div[@role='combobox']	
	By selectCountry    =By.xpath("//span[normalize-space()='India']");	
	By stateDropdown	 	 =By.xpath("//span[normalize-space()='Select province / state']");
	
	By cityDropdown    =By.xpath("//span[normalize-space()='Select city']");
	By selectOption    =By.xpath("//li[@class='ng-star-inserted']");
	By search    =By.xpath("//input[@name='search-text']");
	By street    =By.xpath("//input[@id='street']");
	By street1    =By.xpath("//input[@id='street1']");
	By continueButton    =By.xpath("//button[@type='submit']");
	//For Guest License
	By email    =By.xpath("//input[@id='Email']");
	By inputOTP    =By.xpath("//input[@id='otp']");
	By verifyOTP    =By.xpath("//button[@id='verify-button']");
		
	
	
	
	public LicenseOrderSummaryPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public LicensePaymentMethodsPage addressDetails(String zipCode,String country,String state,String city,String streetValue,String street2Value,int index) {
		fillAddress(zipCode, country, state, city, streetValue, street2Value,index);
		//Click continue	
		elementutil.waitForElementToBeClickable(continueButton, 50);
		elementutil.doClick(continueButton);
		
		return new LicensePaymentMethodsPage(driver);		
	}
	public LicensePaymentMethodsPage addressDetailsGuest(String zipCode,String country,String state,String city,String streetValue,String street2Value,String guestEmail,String requestedFlowGuest, int index) {
		fillAddress(zipCode, country, state, city, streetValue, street2Value,index);
		
		elementutil.waitForElementPresent(email,50);
		elementutil.doSendKeys(email,guestEmail);
		//Click continue	
		elementutil.waitForElementToBeClickable(continueButton, 50);
		elementutil.doClick(continueButton);
		verifyOTP(guestEmail,requestedFlowGuest);
		return new LicensePaymentMethodsPage(driver);		
	}
	private void verifyOTP(String guestEmail, String requestedFlowGuest) {
		elementutil.explicitWait(3000);			
		//Get OTP
		String otp = GetEmailOTP.getEmailOTP(guestEmail, requestedFlowGuest);
		elementutil.waitForElementPresent(inputOTP, 10);
		elementutil.doSendKeys(inputOTP,otp);
		elementutil.waitForElementPresent(verifyOTP, 10);
		elementutil.doClick(verifyOTP);
		
	}

	public void fillAddress(String zipCode,String country,String state,String city,String streetValue,String street2Value,int index) {
		elementutil.explicitWait(2000);
		By selectCountry = By.xpath("//span[normalize-space()='"+country+"']");
		//By selectCountry = By.xpath("//div[@role='option']["+index+"]");
		
		//Enter zip
		elementutil.waitForElementPresent(zip,10);
		elementutil.doSendKeys(zip,zipCode);
		//Select country
		elementutil.waitForElementPresent(countryDropdown, 10);
		elementutil.doClick(countryDropdown);
		/*
		 * elementutil.waitForElementPresent(search,50);
		 * elementutil.doSendKeys(search,country);
		 */
		elementutil.waitForElementPresent(selectCountry, 10);
		System.out.println(driver.findElement(selectCountry).getText()+" Country");
		elementutil.doClick(selectCountry);
		
		//Select state
		elementutil.waitForElementPresent(stateDropdown, 10);
		elementutil.doClick(stateDropdown);
		/*
		 * elementutil.waitForElementPresent(search,10);
		 * elementutil.doSendKeys(search,state);
		 */
		elementutil.waitForElementPresent(selectOption, 10);
		elementutil.doClick(selectOption);
		//Select city
		elementutil.waitForElementPresent(cityDropdown, 10);
		System.out.println(elementutil.doGetText(cityDropdown)+" Cityy");
		elementutil.doClick(cityDropdown);
		/*
		 * elementutil.waitForElementPresent(search,10);
		 * elementutil.doSendKeys(search,city);
		 */
		elementutil.waitForElementPresent(selectOption, 10);
		elementutil.doClick(selectOption);
		//Enter street
		elementutil.waitForElementPresent(street,10);
		elementutil.doSendKeys(street,streetValue);
		//Enter street1
		elementutil.waitForElementPresent(street1,10);
		elementutil.doSendKeys(street1,street2Value);						
	}
}