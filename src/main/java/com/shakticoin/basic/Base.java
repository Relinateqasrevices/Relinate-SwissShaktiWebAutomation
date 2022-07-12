package com.shakticoin.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shakticoin.utils.Optionsmanager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {	
	
	//public WebDriver driver;
	public Properties prop;
	public Optionsmanager optionsmanager;
	public static ThreadLocal<WebDriver> tlDriver =new ThreadLocal<WebDriver>();
	public static WebDriver driver;
	
	public Base(){	
		
		String resourceName = "myconf.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop = new Properties();
		try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
		    prop.load(resourceStream);
		    System.out.println("email--"+prop.getProperty("email"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	public WebDriver init_driver(){
		String browsername=prop.getProperty("browser");
		
		optionsmanager = new Optionsmanager(prop);
		System.out.println("AUT is performing in "+ browsername+ " Browser ");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.out.println("Inside chrome");
			WebDriverManager.chromedriver().setup();
			
			tlDriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.out.println("Inside firefox");
			WebDriverManager.firefoxdriver().setup();			
			System.out.println("Inside firefox2");
			tlDriver.set(new FirefoxDriver(optionsmanager.getFirefoxOptions()));
			System.out.println("Inside firefox3");
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			System.out.println("Inside edge");
			WebDriverManager.edgedriver().setup();			
			System.out.println("Inside edge2");
			tlDriver.set(new EdgeDriver());
			System.out.println("Inside firefox3");
		}
		
		else
		{
			System.out.println("Sorry, browser name you passed' "+browsername +" 'is not found, please pass the correct browser");
		}					
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		//getDriver().manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		
		System.out.println("Inside chrome4");
		driver = getDriver(); 
		return driver;
	}
   
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	//take screenshot
		public String getScreenshot()
		{
			File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
			File destination=new File(path);
			try {
				FileUtils.copyFile(src, destination);
			} catch (IOException e) 
			{
				
			}
			return path;
		}
		
}
