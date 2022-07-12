package com.shakticoin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.io.Zip;

public class UnZip {
	public static void runScirpt() throws Exception, IOException {
		String path = System.getProperty("user.home");				
		Zip.unzip(new FileInputStream(path+"\\Downloads\\Shakti.zip"), new File(path+"\\Downloads\\Shakti"));
		System.out.println("unzip Done");		
		Runtime.getRuntime().exec("cmd /c start "+path+"\\Downloads\\Shakti\\setup.cmd");
		System.out.println("Running the script");
	}
	public static void main(String[] args) throws IOException, Exception {
		//runScirpt();
		//deleteFolder("C:\\Users\\aparn\\Documents\\ShaktiCoin");
	}
	
	

}