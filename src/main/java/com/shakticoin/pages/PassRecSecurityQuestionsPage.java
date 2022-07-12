package com.shakticoin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.shakticoin.utils.ElementUtil;

public class PassRecSecurityQuestionsPage {

	private WebDriver driver;
	ElementUtil elementutil;

	By addQuestionButton    =By.xpath("//button[@id='add-question-button']");					
	By submitButton =By.xpath("//button[@id='security-question-form-submit']");	
	
	public PassRecSecurityQuestionsPage(WebDriver driver){		
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}		
	
	public String getHeading() {
		return null;
	}
	
	public String getHeading2() {
		return null;
	}
	
	public void addSecurityQuestions(String answerValue,int index) {
		
		By answer		 =By.xpath("//div[@id='systemQuestionForm"+index+"']//input[@formcontrolname='answer']");
		By confrimAnswer =By.xpath("//div[@id='systemQuestionForm"+index+"']//input[@formcontrolname='confirmAnswer']");
		By selectQuestion=By.xpath("//div[@id='systemQuestionForm"+index+"']//*[@formcontrolname='id']");
		System.out.println("xpath:--"+selectQuestion);
		
		elementutil.waitForElementPresent(addQuestionButton,10);	
		elementutil.doClick(addQuestionButton);	
		elementutil.waitForElementPresent(selectQuestion,10);	
		elementutil.doSelectValuesByIndex(selectQuestion, index+1);
		System.out.println("index--"+index);
		elementutil.waitForElementPresent(answer,10);	
		elementutil.doSendKeys(answer, answerValue);
		elementutil.waitForElementPresent(confrimAnswer,10);	
		elementutil.doSendKeys(confrimAnswer, answerValue);
	}
	public void submit() {
		elementutil.waitForElementToBeClickable(submitButton, 10);
		elementutil.doClick(submitButton);			
	}
		
}
