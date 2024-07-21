package com.datadrivenproject.testcases;

import java.util.Arrays;
import java.util.List;

import base.BaseClass;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTestCase extends BaseClass {

	public static void main(String[] args) throws Exception {

		multipleAccountLoginTest();
//	   singleAccountLoginTest();

	}

	public static void singleAccountLoginTest() throws Exception {
		// Initialize WebDriver and launch the application
		launchApp();

		ExcelUtility eu = new ExcelUtility();

		// Read user login credentials from Excel
		String[] userInfo = eu.readExcelData();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginDetails(userInfo);
		
		closeBrowser();

	}

	public static void multipleAccountLoginTest() throws Exception {
		// Initialize WebDriver and launch the application

		ExcelUtility eu = new ExcelUtility();

		// Read user login credentials from Excel
		List<String[]> userInfoList = eu.readExcelDataList();
		for (String[] row : userInfoList) {
			System.out.println(String.join(", ", row));
		}

		

		// Iterate over the list of credentials and perform login for each
		for (String[] userInfo : userInfoList) {
			launchApp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterLoginDetails(userInfo);
			closeBrowser(); // Ensure browser is properly closed
		
		}

	}

}
