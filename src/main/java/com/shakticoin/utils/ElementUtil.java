package com.shakticoin.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * this is used to create the webelement on the basis of by locator
	 * @param locator
	 * @return webelement
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {			
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("element could not be created..." + locator);
		}

		return element;
	}
	
	public void doClick(By locator){
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value){
		getElement(locator).sendKeys(value);
	}
	
	public String doGetText(By locator){
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator){
		return getElement(locator).isDisplayed();
	}
	
	
	//**********************Actions Methods ********************
	public void doActionsClick(By locator){
		Actions ac = new Actions(driver);
		ac.click(getElement(locator)).perform();
	}
	
	public void doActionsSendKeys(By locator, String value){
		Actions ac = new Actions(driver);
		ac.sendKeys(getElement(locator), value).perform();
	}
	
	//********************drop down utils **************************
	
	public void doSelectValuesByVisibleText(By locator, String value){
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public void doSelectValuesByIndex(By locator, int index){
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void doSelectValuesByValue(By locator, String value){
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public List<String> getDropDownOptionsValues(By locator) {
		List<String> optionsList = new ArrayList<String>();

		Select select = new Select(getElement(locator));

		List<WebElement> dropList = select.getOptions();
		System.out.println(dropList.size());

		for (int i = 0; i < dropList.size(); i++) {
			String text = dropList.get(i).getText();
			optionsList.add(text);
		}

		return optionsList;
	}
	
	/**
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectValuesFromDropDown(By locator, String value){
		List<WebElement> daysList = driver.findElements(locator);
		
		for(int i=0; i<daysList.size(); i++){
			String text  = daysList.get(i).getText();
			if(text.equals(value)){
				daysList.get(i).click();
				break;
			}
		}
	}
	
	
	//***************************wait utils ******************************
	

	public String doGetPageTitleWithIsTitle(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}
	
	public String doGetPageCurrentUrl(int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlContains(urlValue));
		return  driver.getCurrentUrl();
	}
	
	public WebElement waitForElementPresent(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeClickable(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement waitForElementToBeVisible(By locator, int timeOut){
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public List<WebElement> visibilityOfAllElements(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void clickWhenReady(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public Alert waitForAlertPresent(int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public boolean isElementDisplayed(By locator, int timeout) {
		WebElement element = null;
		boolean flag = false;
		for (int i = 0; i < timeout; i++) {

			try {
				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			} catch (Exception e) {
				System.out.println("waiting for element to be present on the page -->" + i + "secs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {

				}
			}

		}
		return flag;

	}
	
	//******************* FluentWait Utils ***********************
	public WebElement waitForElementWithFluentWaitConcept(By locator, int timeOut){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementWithFluentWait(final By locator, int timeOut) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		
		return element;
	}

	public void explicitWait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void fileupload(String Filepath) throws AWTException {
	StringSelection ss = new StringSelection(Filepath);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

    Robot robot = new Robot();
    robot.delay(250);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.delay(90);
    robot.keyRelease(KeyEvent.VK_ENTER);
   // elementutil.waitForElementToBeVisible(Imageuploadmessage, 1000);
	}
	
	public void deleteFolder(String path) {
		try {
			FileUtils.deleteDirectory(new File(path));
			FileUtils.forceDelete(new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void deleteFile(String path) {
		try {			
			FileUtils.forceDelete(new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void waitUntilFileReady(String path) {
		File dir = new File(path);
		String fileName = "publicKey";
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		        wait.pollingEvery(10, TimeUnit.SECONDS);
		        wait.withTimeout(1500, TimeUnit.SECONDS);
		        wait.until(x -> {
		            File[] filesInDir = dir.listFiles();
		            for (File fileInDir : filesInDir) {
		                if (fileInDir.getName().startsWith(fileName)) {
		                    return true;
		                }
		            }
		            return false;
		        });
	}
}
	

