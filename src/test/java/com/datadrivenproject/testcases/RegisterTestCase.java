package com.datadrivenproject.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.RegisterPage;
import utility.ExcelUtility;
import utility.GenerateUniqueData;

public class RegisterTestCase extends BaseClass {

	public static void main(String[] args) throws Exception {
	    launchApp();
		
	    RegisterPage registerPage = new RegisterPage(driver);
	    // Fill registration form
	    
	    
	    ExcelUtility eu = new ExcelUtility();
	    String[]  userInfo = GenerateUniqueData.generateData();
	    
	    registerPage.enterRegisterInfo(userInfo);
		
        // Write user details to an Excel sheet
        eu.writeExcelData(userInfo);
        
        System.out.println(userInfo[0]+" : "+userInfo[1]);
        
        
        closeBrowser();
        
	}

}
