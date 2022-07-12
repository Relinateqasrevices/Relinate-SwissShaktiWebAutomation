package com.shakticoin.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptUtil {
	
	private WebDriver driver;

	public JavascriptUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public void pageScrollDown() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,350)", "");}

}
