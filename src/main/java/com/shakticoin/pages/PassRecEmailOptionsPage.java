package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class PassRecEmailOptionsPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	By addSecondaryEmailButton = By.xpath("//span[normalize-space()='Add a Secondary Email']");
	By addtrustedEmailButton = By.xpath("//button[@class='btn btn-lg btn-block set-password-recovery-btn']");
	By addAnotherTrustedEmailButton = By.xpath("//span[contains(text(),'Add another Trusted Friend’s Email')]");	

	public PassRecEmailOptionsPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public String getHeading() {
		return null;
	}

	public String getHeading2() {
		return null;
	}

	public void clickAddSecondaryEmailButton() {
		elementutil.waitForElementPresent(addSecondaryEmailButton, 10);
		elementutil.doClick(addSecondaryEmailButton);
	}

	public void clickAddtrustedEmailButton() {
		elementutil.waitForElementPresent(addtrustedEmailButton, 10);
		elementutil.doClick(addtrustedEmailButton);
	}

	public void clickAddAnotherTrustedEmailButton() {
		elementutil.waitForElementPresent(addAnotherTrustedEmailButton, 10);
		elementutil.doClick(addAnotherTrustedEmailButton);
	}
}
