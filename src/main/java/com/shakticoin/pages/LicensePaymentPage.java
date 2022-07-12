package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class LicensePaymentPage {
	private WebDriver driver;
	ElementUtil elementutil;

	By successCardDetails = By.xpath("//a[@class='ml-5']");
	By countryDropdown = By.xpath("//select[@name='country']");
	By state = By.xpath("//input[@name='state']");
	By city = By.xpath("//input[@name='city']");
	By street = By.xpath("//input[@name='street']");
	By zip = By.xpath("//input[@name='zip']");
	By subscribe = By.xpath("//button[@id='submit-button']");

	public LicensePaymentPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public String getHeading() {
		return null;
	}

	public String getHeading2() {
		return null;
	}

	public void purchaseLicense(String zipCode, String country, String stateValue, String cityValue,
			String streetValue) {
		elementutil.explicitWait(2000);
		if (elementutil.isElementDisplayed(successCardDetails, 5)) {
			// Enter the password click login
			elementutil.waitForElementPresent(successCardDetails, 50);
			elementutil.doClick(successCardDetails);
			elementutil.waitForElementPresent(countryDropdown, 50);
			// elementutil.selectValuesFromDropDown(countryDropdown,country );
			elementutil.doSendKeys(state, stateValue);
			elementutil.doSendKeys(city, cityValue);
			elementutil.doSendKeys(street, streetValue);
			elementutil.doSendKeys(zip, zipCode);
		}
		elementutil.waitForElementToBeClickable(subscribe, 10);
		elementutil.doClick(subscribe);
		//elementutil.explicitWait(3000);
	}
}