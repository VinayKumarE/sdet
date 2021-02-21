package com.autodeskTestscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.autodeskcrm.objectrepositry.OrganisationListpage;
import com.autodeskcrm.objectrepositry.OrganisationModule;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.Login;
import com.crm.autodesk.objectrrepositorylib.OrganisationListPage2;
import com.crm.autodesk.objectrrepositorylib.OrganisationModule2;

import Genericlibrary.WebdriverUtils;

public class CreateOrgnaisation {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	@Test
	public void createQuote() throws Throwable  {
		/* Common Data */
		int randomNum = jLib.generateRandomNum();
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");
		/* test Data */
		String orgName = eLib.getExcelData("Contact", "tc_02", "filters")+ randomNum;
		/*
		 * String orgType = eLib.getExcelData("Contact", "tc_02", "orgType"); String
		 * orgIndustry = eLib.getExcelData("Contact", "tc_02", "orgIndustry"); String
		 * orgRating = eLib.getExcelData("Contact", "tc_02", "orgRating");
		 */
		String contLastNAme = eLib.getExcelData("Contact", "tc_02", "contactName") + randomNum;
		String SUBJECT=eLib.getExcelData("Contact", "tc_02", "subject")+ randomNum;
		String contLastNAme1=eLib.getExcelData("Contact", "tc_02", "contactLastName")+ randomNum;
		String billingAddress=eLib.getExcelData("Contact", "tc_02", "billingAddress")+ randomNum;
		String productname=eLib.getExcelData("Contact", "tc_02", "product")+ randomNum;



		/* step 1 : login to APP */
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();  
		}else if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}

		wLib.waitForHTMLDOM(driver);
		
		driver.get(URL);

		/* step 1 : login to APP */
		Login lp = new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		/* step 2 : navigate to create Organization Page */
		OrganisationModule orgPage = new OrganisationModule(driver);
		orgPage.getOrganisationModule().click();
		OrganisationListpage OL= new OrganisationListpage(driver);
		wLib.waitforElementToBeClickable(driver,OL.getFilter());
				
		/* step 3 : Search for Filters as ALL */
		
		OL.getFilter().click();
		
		OL.getCreatefilter().click();
		wLib.waitforElementToBeClickable(driver,OL.getCreatefilterviewname());
		OL.	getCreatefilterviewname().sendKeys(orgName);
		OL.getSavebtn().click();
}
}