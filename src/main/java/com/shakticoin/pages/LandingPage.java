package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shakticoin.utils.Constants;
import com.shakticoin.utils.ElementUtil;

public class LandingPage {

	private WebDriver driver;
	ElementUtil elementutil;
	
	By whitePaperLink = By.xpath("//a[normalize-space()='White Paper']");
	By mineShaktiCoin = By.xpath("//a[normalize-space()='Mine ShaktiCoin']");
	By about = By.xpath("//a[normalize-space()='About']");
	By community = By.xpath("//a[normalize-space()='Community']");
	By sign = By.xpath("//a[normalize-space()='Sign Up / Log In']");
	By joinSxeNetwork = By.xpath("//div[@class='join-txt']");
	By gettingStarted = By.xpath("//span[normalize-space()='Getting Started']");
	By intro = By.xpath("//a[normalize-space()='Intro']");
	By miningLicenses = By.xpath("//a[normalize-space()='Mining Licenses']");
	By soma = By.xpath("//span[normalize-space()='SOMA']");
	By userInterface = By.xpath("//a[normalize-space()='User Interface']");
	By overview = By.xpath("//a[normalize-space()='Overview']");
	By quickStaretd = By.xpath("//a[normalize-space()='Quick Start']");
	By architectualOverview = By.xpath("//a[normalize-space()='Architectural Overview']");
	By shakttiLedger = By.xpath("//span[normalize-space()='Shakti Ledgers']");
	By sxeLedger = By.xpath("//a[normalize-space()='SXE Ledger']");
	By poeLedger = By.xpath("//a[normalize-space()='PoE Ledger']");
	By forum = By.xpath("//span[normalize-space()='Forum']");
	By shaktiCoin = By.xpath("//img[@src='../../../assets/icon/logo.png']");
	// h2[@class='pt-5 mb-4']

	By gmailConfirmed = By.xpath("//div[@id='existing-user-information']//h2[@class='pt-5 mb-4']");
	By text = By.xpath("//div[@id='existing-user-information']//p[@class='pt-3 mb-0']']");
	By signupButton =By.xpath("//a[@class='nav-link btn-signup']");		
	
	public LandingPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	
	public String  getPageTitle()
	{
		return elementutil.doGetPageTitleWithIsTitle(10, Constants.LOGIN_PAGE_TITLE);
	}
	
	public boolean isSignUpExists()
	{					
		elementutil.waitForElementPresent(signupButton, 100);
		return elementutil.doIsDisplayed(signupButton);
	}
	
	public String checkHeading() {
		return elementutil.doGetText(signupButton);
	}
	public String getWhitePaperLink() {		
		elementutil.waitForElementPresent(whitePaperLink, 200);
		return elementutil.doGetText(whitePaperLink).trim();
	}

	public String getMineShaktiCoin() {
		return elementutil.doGetText(mineShaktiCoin).trim();

	}

	public String getAbout() {
		return elementutil.doGetText(about).trim();

	}

	public String getCommunity() {
		return elementutil.doGetText(community).trim();

	}

	public boolean getsignin() {
		return elementutil.doIsDisplayed(sign);

	}

	public boolean getJOINSEXNETWORK() {
		return elementutil.doIsDisplayed(joinSxeNetwork);
	}

	public String getGETTINGSTARTED() {
		return elementutil.doGetText(gettingStarted).trim();
	}

	public String getIntro() {
		return elementutil.doGetText(intro).trim();
	}

	public String getMiningLicenses() {
		return elementutil.doGetText(miningLicenses).trim();
	}

	public String getSOMA() {
		return elementutil.doGetText(soma).trim();
	}

	public String getUserInterface() {
		return elementutil.doGetText(userInterface).trim();
	}

	public String getQuikStart() {
		return elementutil.doGetText(quickStaretd).trim();
	}

	public String getArchitectualOverview() {
		return elementutil.doGetText(architectualOverview).trim();
	}

	public String getSHAKTILEDGER() {
		return elementutil.doGetText(shakttiLedger).trim();
	}

	public String getSXELedger() {
		return elementutil.doGetText(sxeLedger).trim();
	}

	public String getPoELedger() {
		return elementutil.doGetText(poeLedger).trim();
	}

	public String getFORUM() {
		return elementutil.doGetText(forum).trim();
	}

	public boolean getShaktiCoin() {
		return elementutil.doIsDisplayed(shaktiCoin);

	}

	public String MailConfirmedText() {		
		return elementutil.doGetText(gmailConfirmed).trim();

	}

	public String getText() {
		return elementutil.doGetText(text).trim();

	}

	
	public RegSendEmailOTPPage clickSignup() {
		elementutil.waitForElementToBeVisible(signupButton,30);		
		elementutil.doClick(signupButton);
		return null;//new RegSendEmailOTPPage(driver);
	}
}
