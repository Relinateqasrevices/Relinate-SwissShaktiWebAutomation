package com.shakticoin.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.ElementUtil;
import com.shakticoin.utils.GetEmailOTP;
import com.shakticoin.utils.UnZip;

public class JoinSXEFlowPage {
	private WebDriver driver;
	ElementUtil elementutil;
	
	//By joinButton = By.xpath("//div[@class='row btn-txt-container']");
	By joinButton = By.xpath("//div[@class='join-txt']");
	By continueButton = By.xpath("//button[@id='continue-button']");
	By inputOTP = By.xpath("//input[@id='otp']");
	By verifyButton = By.xpath("//button[@id='verify-button']");
	//By selectlicense = By.xpath("//select[@id='subscriptions-dropdown']");
	By selectlicense = By.id("subscriptions-dropdown");
	By selectIP = By.xpath("//button[@id='fetch-node-ip-button']");
	By selectPort = By.xpath("//button[@id='fetch-port-number-button']");
	By downloadScript = By.xpath("//button[@id='download-button']");
	By joinShakti = By.xpath("//button[@id='join-shakti-network-button']");					
	By closeButton = By.xpath("//div[@class='text-right close-button modal-close-button']//a//*[name()='svg']");	
	
	By uploadKeyFile = By.xpath("//label[@for='SubscriptionId']");
	By joinSXEButton = By.xpath("//button[@id='join-shakti-network-button']");	
	
	String path = System.getProperty("user.home");
	//div[@class='text-right close-button modal-close-button']//a//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]
	public JoinSXEFlowPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public void clickJoinSXE() {
		elementutil.explicitWait(2000);
		elementutil.waitForElementPresent(joinButton, 50);
		elementutil.doClick(joinButton);		
	}
	public void sendEmailOTP() {				
		elementutil.explicitWait(2000);
		elementutil.waitForElementToBeClickable(continueButton, 50);
		elementutil.doClick(continueButton);
	}
	public void validateEmail(String emailID,String requestedFlow) {
		elementutil.explicitWait(5000);
		//Get OTP
		String otp = GetEmailOTP.getEmailOTP(emailID, requestedFlow);
		//Enter OTP and click verify
		elementutil.waitForElementPresent(inputOTP,50);
		elementutil.doSendKeys(inputOTP, otp);
		elementutil.waitForElementToBeClickable(verifyButton, 200);
		elementutil.doClick(verifyButton);				
	}
	public void downloadScript() {
		elementutil.explicitWait(2000);	
		elementutil.waitForElementPresent(selectlicense,50);
		elementutil.doSelectValuesByIndex(selectlicense, 2);
		closePopup();
		elementutil.waitForElementToBeClickable(selectIP,50);
		elementutil.doClick(selectIP);
		closePopup();
		elementutil.waitForElementToBeClickable(selectPort,50);
		elementutil.doClick(selectPort);	
		closePopup();		
		elementutil.deleteFolder(path+"\\Downloads\\Shakti");
		elementutil.deleteFolder(path+"\\Documents\\ShaktiCoin");
		elementutil.deleteFile(path+"\\Downloads\\Shakti.zip");
		elementutil.waitForElementToBeClickable(downloadScript,50);
		elementutil.doClick(downloadScript);
		closePopup();
	}
	public void closePopup() {
		elementutil.waitForElementPresent(closeButton,50);
		elementutil.doClick(closeButton);
	}
	public void uploadKey() throws IOException, Exception {		
		elementutil.explicitWait(2000);		
		UnZip.runScirpt();
		elementutil.waitUntilFileReady(path+"\\Downloads\\Shakti");
		elementutil.clickWhenReady(uploadKeyFile, 50);				
		elementutil.fileupload(path+"\\Downloads\\Shakti\\publicKey.json");
		elementutil.clickWhenReady(joinSXEButton, 50);
	}	
}