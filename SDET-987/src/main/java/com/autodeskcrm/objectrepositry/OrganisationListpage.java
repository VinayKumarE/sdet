package com.autodeskcrm.objectrepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

import Genericlibrary.WebdriverUtils;

public class OrganisationListpage extends WebdriverUtils  {
	
	WebdriverUtils WU= new WebdriverUtils();
	@FindBy(id="viewname")
	private WebElement filter;
	
	@FindBy(linkText="Create Filter")
	private WebElement createfilter;
	
	@FindBy(name="viewName")
	private WebElement createfilterviewname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	

	public WebElement getCreatefilterviewname() {
		return createfilterviewname;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}

	public OrganisationListpage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFilter() {
		return filter;
	}
	
		public WebElement getCreatefilter() {
		return createfilter;
	}	
	/*
		 * select the filter option
		 */
	public void filters(String all) {
		select(getFilter(),all);
		
	}	
	for(WebElement option:filter. getoptions()) {
		if(option.equals()) {
			option.click();
			break;
		}
	}
	
	
	
	
	
	
	
	/*
	 * public void filters(String all, String NewThisWeek) {
	 * select(getFilter(),all); select(getFilter(),NewThisWeek); }
	 * 
	 * public void filters(String all, String NewThisWeek,String prospectAccounts) {
	 * select(getFilter(),all); select(getFilter(),NewThisWeek);
	 * select(getFilter(),prospectAccounts); }
	 */
		
}

