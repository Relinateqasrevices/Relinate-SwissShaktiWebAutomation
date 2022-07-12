package com.shakticoin.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.LoginConfirmMobilePage;

public class LoginConfirmMobilePageTest extends Base {
	
	public LoginConfirmMobilePage confirmMobilePage;

	
	@BeforeTest
	public void setUp() {
		System.out.println("driver at setUp"+driver);
		confirmMobilePage = new LoginConfirmMobilePage(driver);		
	}

	@Test(priority=1)
	public void confirmMobile() {
		System.out.println("driver:--"+driver);
		confirmMobilePage.confirmMobile();
		
	}
	/*
	 * @Test(priority = 1) public void getWhitePaperLink() {
	 * System.out.println(confirmMobilePage.getWhitePaperLink()); }
	 * 
	 * @Test(priority = 2) public void MailConfirmedText() {
	 * System.out.println(confirmMobilePage.MailConfirmedText());
	 * 
	 * }
	 * 
	 * @Test(priority = 3) public void getText() {
	 * System.out.println(confirmMobilePage.getText());
	 * 
	 * }
	 * 
	 * @Test(priority = 6) public void getMobile() {
	 * System.out.println(confirmMobilePage.getMobile());
	 * 
	 * }
	 * 
	 * @Test(priority = 7) public void getMineShaktiCoin() {
	 * System.out.println(confirmMobilePage.getMineShaktiCoin());
	 * 
	 * }
	 * 
	 * @Test(priority = 8) public void getAbout() {
	 * System.out.println(confirmMobilePage.getAbout());
	 * 
	 * }
	 * 
	 * @Test(priority = 9) public void getCommunity() {
	 * System.out.println(confirmMobilePage.getCommunity());
	 * 
	 * }
	 * 
	 * @Test(priority = 10) public void getsignin() {
	 * System.out.println(confirmMobilePage.getsignin());
	 * 
	 * }
	 * 
	 * @Test(priority = 11) public void getJOINSEXNETWORK() {
	 * System.out.println(confirmMobilePage.getJOINSEXNETWORK()); }
	 * 
	 * @Test(priority = 12) public void getGETTINGSTARTED() {
	 * System.out.println(confirmMobilePage.getGETTINGSTARTED()); }
	 * 
	 * @Test(priority = 13) public void getIntro() {
	 * System.out.println(confirmMobilePage.getIntro()); }
	 * 
	 * @Test(priority = 14) public void getMiningLicenses() {
	 * System.out.println(confirmMobilePage.getMiningLicenses()); }
	 * 
	 * @Test(priority = 15) public void getSOMA() {
	 * System.out.println(confirmMobilePage.getSOMA()); }
	 * 
	 * @Test(priority = 16) public void getUserInterface() {
	 * System.out.println(confirmMobilePage.getUserInterface()); }
	 * 
	 * @Test(priority = 17) public void getQuikStart() {
	 * System.out.println(confirmMobilePage.getQuikStart()); }
	 * 
	 * @Test(priority = 18) public void getArchitectualOverview() {
	 * System.out.println(confirmMobilePage.getArchitectualOverview()); }
	 * 
	 * @Test(priority = 19) public void getSHAKTILEDGER() {
	 * System.out.println(confirmMobilePage.getSHAKTILEDGER()); }
	 * 
	 * @Test(priority = 20) public void getSXELedger() {
	 * System.out.println(confirmMobilePage.getSXELedger()); }
	 * 
	 * @Test(priority = 21) public void getPoELedger() {
	 * System.out.println(confirmMobilePage.getPoELedger()); }
	 * 
	 * @Test(priority = 22) public void getFORUM() {
	 * System.out.println(confirmMobilePage.getFORUM()); }
	 * 
	 * 
	 * @Test(priority = 23) public void getShaktiCoin() {
	 * System.out.println(confirmMobilePage.getShaktiCoin());
	 * 
	 * }
	 */

	
}
