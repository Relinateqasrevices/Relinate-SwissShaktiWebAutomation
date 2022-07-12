package com.shakticoin.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.PassRecMobileOptionsPage;
import com.shakticoin.pages.PassRecSecurityQuestionsPage;
import com.shakticoin.pages.PassRecTruestedMobileInputPage;
import com.shakticoin.pages.PassRecTrustedMobileOTPVerifyPage;
import com.shakticoin.pages.PassRecoveryStatusPage;
import com.shakticoin.pages.RegConfirmPasswordPage;
import com.shakticoin.pages.UserDropdownMenu;

public class PassRecAddSecurityQuestionsTest extends Base {

	String countryCode = prop.getProperty("countryCode");
	String trustedMobile = prop.getProperty("trustedMobile");
	String requestedFlowTrustedMobile = prop.getProperty("requestedFlowTrustedMobile");
	String password = prop.getProperty("password");
	
	public UserDropdownMenu menuOptions;
	public PassRecoveryStatusPage passRecoveryStatusPage;
	public PassRecSecurityQuestionsPage passRecSecurityQuestionsPage;
	public RegConfirmPasswordPage regConfirmPasswordPage;
	
	@BeforeTest 
	public void setUp()
	{		
		/*
		 * basepage=new Base(); driver=basepage.init_driver(driver);
		 */	
		System.out.println("driver at sendMobile"+driver);
		menuOptions = new UserDropdownMenu(driver);			
	}
		
	@Test(priority=1)
	public void selectSetPassRecoveryOption() {		
		menuOptions.selectSetPassRecovery();
	}
	@Test(priority=2)
	public void clickSecirtyQA() throws InterruptedException {	
		passRecoveryStatusPage = new PassRecoveryStatusPage(driver);
		passRecoveryStatusPage.clickSecurityQA();
		Thread.sleep(2000);
	}
	@Test(priority=3,dataProvider ="getData")
	public void addSecurityQuestions(String answer,String index) {	
		int indexValue=Integer.parseInt(index);
		passRecSecurityQuestionsPage = new PassRecSecurityQuestionsPage(driver);
		passRecSecurityQuestionsPage.addSecurityQuestions(answer, indexValue);
	}
	
	@Test(priority=4)
	public void submitQuestions() {			
		passRecSecurityQuestionsPage.submit();
		}
	
	@Test(priority=5)
	public void confirmPassowrd() {		
		regConfirmPasswordPage = new RegConfirmPasswordPage(driver);
		regConfirmPasswordPage.confirmPassowrd(password);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[5][2];
		data[0][0] = "Test1";
		data[0][1] = "0";			
		
		data[1][0] = "Test2";
		data[1][1] = "1";	
		
		data[2][0] = "Test3";
		data[2][1] = "2";	
		
		data[3][0] = "Test4";
		data[3][1] = "3";	
		
		
		data[4][0] = "Test5";
		data[4][1] = "4";	
		
		return data;
	}
}
