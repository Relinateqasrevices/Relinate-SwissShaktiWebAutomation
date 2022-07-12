package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class PassRecMobileOptionsPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By addSecondaryMobileButton = By.xpath("//span[normalize-space()='Add a secondary mobile']");
	By addtrustedMobileButton = By.xpath("//button[@class='btn btn-lg btn-block set-password-recovery-btn']");
	By addAnotherTrustedMobileButton = By.xpath("//span[contains(text(),'Add another trusted friend’s mobile')]");	

	public PassRecMobileOptionsPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public String getHeading() {
		return null;
	}

	public String getHeading2() {
		return null;
	}

	public void clickAddSecondaryMobileButton() {
		elementutil.waitForElementPresent(addSecondaryMobileButton, 10);
		elementutil.doClick(addSecondaryMobileButton);
	}

	public void clickAddtrustedMobileButton() {
		elementutil.waitForElementPresent(addtrustedMobileButton, 10);
		elementutil.doClick(addtrustedMobileButton);
	}

	public void clickAddAnotherTrustedMobileButton() {
		elementutil.waitForElementPresent(addAnotherTrustedMobileButton, 10);
		elementutil.doClick(addAnotherTrustedMobileButton);
	}

}
