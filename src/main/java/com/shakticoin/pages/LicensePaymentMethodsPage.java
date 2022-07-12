package com.shakticoin.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;

public class LicensePaymentMethodsPage {
	private WebDriver driver;
	ElementUtil elementutil;

	By paymentMethodCard = By.xpath("//button[normalize-space()='Debit or Credit Card']");

	// By.xpath("//div[@id='AmazonPayButton']");
	By paymentMethodAmazon = By.xpath("//button[normalize-space()='Pay with Amazon']");
	By amazonPayButton = By.id("AmazonPayButton");
	By emailTextBox = By.xpath("//input[@id='ap_email']");
	By passwordTextBox = By.xpath("//input[@id='ap_password']");
	By signinButton = By.id("signInSubmit");
	By submitButton = By.xpath("//input[@type='submit']");

	public LicensePaymentMethodsPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public String getHeading() {
		return null;
	}

	public String getHeading2() {
		return null;
	}

	public LicensePaymentPage selectPaymentMethod() {
		elementutil.explicitWait(3000);
		elementutil.waitForElementPresent(paymentMethodCard, 50);
		elementutil.doClick(paymentMethodCard);
		return new LicensePaymentPage(driver);
	}

	public void selectPaymentMethodAmazonPay(String username, String password) {
		elementutil.explicitWait(3000);
		String parent = driver.getWindowHandle();
		System.out.println(parent + " parent1");
		elementutil.clickWhenReady(paymentMethodAmazon, 50);
		elementutil.clickWhenReady(amazonPayButton, 50);
		elementutil.explicitWait(4000);
		changeWindow(username, password);
	}

	private void changeWindow(String username, String password) {
		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();
		System.out.println(parent + " parent");
		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();
			System.out.println(child_window + " child");

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println("inside IF");
				if (elementutil.isElementDisplayed(signinButton, 5)) {
					elementutil.waitForElementPresent(emailTextBox, 50);
					elementutil.doSendKeys(emailTextBox, username);

					elementutil.waitForElementPresent(passwordTextBox, 50);
					elementutil.doSendKeys(passwordTextBox, password);

					elementutil.clickWhenReady(signinButton, 50);
				}
				elementutil.explicitWait(5000);
				System.out.println("Before click");
				elementutil.clickWhenReady(submitButton, 50);
				System.out.println("After click");
				elementutil.explicitWait(10000);				
			}

		}
		// switch to the parent window
		driver.switchTo().window(parent);
	}
}