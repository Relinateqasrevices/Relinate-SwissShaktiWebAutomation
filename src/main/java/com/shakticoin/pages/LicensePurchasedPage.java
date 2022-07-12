package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class LicensePurchasedPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By purchasedLicenses =By.xpath("//div[@id='purchased-licenses-tab']");
	By cancelLink =By.xpath("//a[@id='cancel-license-button']"); 
	By yesButton =By.xpath("//button[normalize-space()='Yes']");
	
	By upgradeLink =By.xpath("//a[@id='upgrade-license-button']");
	By selectLicense =By.xpath("//label[@class='form-check-radio-label']"); 
	By upgradeButton =By.xpath("//button[@id='upgrade-license-button']");
	By clickPurchase =By.xpath("//button[@class='btn btn-soma-next']");
	By closePopup =By.xpath("//div[@class='text-right close-button']//a//*[name()='svg']");	
					
	public LicensePurchasedPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public void cancelLicense() throws InterruptedException {					   					 
				
		elementutil.waitForElementPresent(purchasedLicenses,10);
		elementutil.doClick(purchasedLicenses);
		elementutil.waitForElementToBeClickable(cancelLink, 10);
		elementutil.doClick(cancelLink);
		elementutil.waitForElementToBeClickable(yesButton, 10);
		elementutil.doClick(yesButton);	
		Thread.sleep(2000);
		elementutil.waitForElementToBeClickable(yesButton, 10);
		elementutil.doClick(yesButton);	
		elementutil.waitForElementPresent(closePopup,10);
		elementutil.doClick(closePopup);
	}
	public void upgradeLicense(){					   					 
		
		elementutil.waitForElementPresent(purchasedLicenses,20);
		elementutil.doClick(purchasedLicenses);
		elementutil.waitForElementToBeClickable(upgradeLink, 20);
		elementutil.doClick(upgradeLink);
		elementutil.waitForElementPresent(selectLicense, 20);
		elementutil.doClick(selectLicense);			
		elementutil.waitForElementToBeClickable(upgradeButton, 20);
		elementutil.doClick(upgradeButton);	
		elementutil.waitForElementToBeClickable(clickPurchase, 20);
		elementutil.doClick(clickPurchase);			
	}
}
