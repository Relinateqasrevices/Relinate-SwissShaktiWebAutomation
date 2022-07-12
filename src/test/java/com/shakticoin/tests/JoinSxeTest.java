package com.shakticoin.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shakticoin.basic.Base;
import com.shakticoin.pages.JoinSXEFlowPage;

public class JoinSxeTest extends Base{
	
	public JoinSXEFlowPage joinSxeFlowPage;

	String email = prop.getProperty("email");	
	String requestedFlowJoin = prop.getProperty("requestedFlowJoinSXE");	
	boolean userStatus=false;

	@BeforeTest
	public void setUp() {		
		joinSxeFlowPage=new JoinSXEFlowPage(driver);		
	}

	@Test(priority = 1)
	public void clickJoinSXE() {
		joinSxeFlowPage.clickJoinSXE();
	}
	@Test(priority = 2)
	public void sendEmailOTP() {
		joinSxeFlowPage.sendEmailOTP();
	}
	@Test(priority = 3)
	public void verifyEmailOTP() {
		joinSxeFlowPage.validateEmail(email, requestedFlowJoin);;
	}
	@Test(priority = 4)
	public void downloadScript() {
		joinSxeFlowPage.downloadScript();
	}
	@Test(priority = 5)
	public void uploadKey() throws IOException, Exception {
		joinSxeFlowPage.uploadKey();		
	}
}