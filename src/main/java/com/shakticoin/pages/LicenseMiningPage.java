package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.shakticoin.utils.ElementUtil;

public class LicenseMiningPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	public LicenseMiningPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public LicenseOrderSummaryPage selectSubscription(String licenseType,String licenseValidity) {		
		
	   	driver.navigate().to("https://qa.shakticoin.com/mining-licenses");
		 By baiscMinerLicense =By.xpath(licenseType);
		 By weeklySection =By.xpath(licenseValidity); 
		 By purchaseButton =By.xpath("//button[@class='btn btn-soma-next']");
		//Enter the password click login
		elementutil.waitForElementPresent(baiscMinerLicense,20);
		elementutil.doClick(baiscMinerLicense);
		elementutil.waitForElementToBeClickable(weeklySection, 20);
		elementutil.doClick(weeklySection);
		elementutil.waitForElementToBeClickable(purchaseButton, 20);
		elementutil.doClick(purchaseButton);
		return new LicenseOrderSummaryPage(driver);
	}

	
}
