package com.autodeskcrm.objectrepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationModule {
	@FindBy(xpath="//td[@class='tabSelected']/a[text()='Organizations']")
	private WebElement organisationModule;

	public OrganisationModule(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrganisationModule() {
		return organisationModule;
	}

}
