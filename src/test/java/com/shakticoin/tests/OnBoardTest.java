package com.shakticoin.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.LandingPage;
import com.shakticoin.pages.LoginConfirmMobilePage;
import com.shakticoin.pages.LoginEnterPasswordPage;
import com.shakticoin.pages.RegConfirmPasswordPage;
import com.shakticoin.pages.RegEnterMobileNumberPage;
import com.shakticoin.pages.RegSendEmailOTPPage;
import com.shakticoin.pages.RegSetPasswordPage;
import com.shakticoin.pages.RegSetPinPage;
import com.shakticoin.pages.RegValidateEmailOTPPage;
import com.shakticoin.pages.RegValidateMobileOTPPage;
import com.shakticoin.utils.Constants;
import com.shakticoin.utils.GetUserStatus;

public class OnBoardTest extends Base {

	public Base basepage;	
	public LandingPage landingPage;
	public RegSendEmailOTPPage sendEMailOTPPage;
	public RegValidateEmailOTPPage validateEmailOTPPage;
	public LoginConfirmMobilePage confirmMobilePage;
	public RegEnterMobileNumberPage enterMobileNumberPage;
	public RegValidateMobileOTPPage validateMobileOTPPage;
	public LoginEnterPasswordPage enterPasswordPage;
	public RegSetPasswordPage setPasswordPage;
	public RegSetPinPage setPinPage;
	public RegConfirmPasswordPage confirmPasswordPage;

	
	String requestedFlowEmail;
	String requestedFlowMobile;	
	boolean userStatus;
	String email = prop.getProperty("email");
	String countryCode = prop.getProperty("countryCode");
	String mobile = prop.getProperty("mobile");
	String password = prop.getProperty("password");
	

	@BeforeTest
	public void setUp() {
		
		basepage = new Base();
		basepage.init_driver();
		userStatus = GetUserStatus.getUserStatus(email);
		if(userStatus)
		{			
			 requestedFlowEmail = prop.getProperty("requestedFlowLogin");
			 requestedFlowMobile = prop.getProperty("requestedFlowLogin");
		}else {
			 requestedFlowEmail = prop.getProperty("requestedFlowRegisterEmail");
			 requestedFlowMobile = prop.getProperty("requestedFlowRegisterMobile");
		}
	}

	@Test(priority=1)
	public void verifySignupLinkTest()
	{
	landingPage = new LandingPage(driver);	
	Assert.assertEquals(landingPage.isSignUpExists(), true);
		
	}
	@Test(priority=2)
	public void verifyLoginPageTitleTest()
	{
		System.out.println("Returned Loginpage title is--"+landingPage.getPageTitle());
		Assert.assertEquals(landingPage.getPageTitle(), Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=3)
	public void clickSignup()
	{	
		landingPage.clickSignup();
	}		
	@Test(priority=4)
	public void sendEmailOTP() {
		sendEMailOTPPage = new RegSendEmailOTPPage(driver);			
		sendEMailOTPPage.sendEmailOTP(email);
	}
	
	@Test(priority=5)
	public void validateEmailOTP() {	
		validateEmailOTPPage = new RegValidateEmailOTPPage(driver);;
		validateEmailOTPPage.validateEmailOTP(email, requestedFlowEmail);
	}
	
	@Test(priority = 6)
	public void inputMobileNumber() {
		if(userStatus)
			throw new SkipException("User is already registered so skipping this");
		enterMobileNumberPage =  new RegEnterMobileNumberPage(driver);	
		enterMobileNumberPage.sendMobileOTP(countryCode, mobile);
	}
	
	@Test(priority=7)
	public void confirmMobile() {
		if(!userStatus)
			throw new SkipException("User is not registered so skipping this");
		confirmMobilePage = new LoginConfirmMobilePage(driver);
		confirmMobilePage.confirmMobile();
		
	}
			
	@Test(priority=8)
	public void validateMobile() {		
		validateMobileOTPPage = new RegValidateMobileOTPPage(driver);
		validateMobileOTPPage.validateMobileOTP(countryCode, mobile, requestedFlowMobile);
	}	
		
	@Test(priority=9)
	public void login() {
		if(!userStatus)
			throw new SkipException("User is not registered so skipping this");
		enterPasswordPage = new LoginEnterPasswordPage(driver);		
		enterPasswordPage.login(password);
	}
		
	@Test(priority=10)
	public void setPassword() {	
		if(userStatus)
			throw new SkipException("User is already registered so skipping this");
		setPasswordPage = new RegSetPasswordPage(driver);		
		System.out.println(password);
		setPasswordPage.setPassword(password);
	}

	@Test(priority=11)
	public void setPin() {	
		if(userStatus)
			throw new SkipException("User is already registered so skipping this");
		setPinPage = new RegSetPinPage(driver);
		setPinPage.setPin("3446","Hint");
	}
		
	@Test(priority=12)
	public void confirmPassword() {	
		if(userStatus)
			throw new SkipException("User is already registered so skipping this");
		confirmPasswordPage = new RegConfirmPasswordPage(driver);
		confirmPasswordPage.confirmPassowrd(password);		
	}		
}
