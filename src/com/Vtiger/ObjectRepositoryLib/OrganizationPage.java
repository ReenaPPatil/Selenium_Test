package com.Vtiger.ObjectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPage {

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgBtn;
	
	public void navigateToCreateOrgPage()
	{
		createOrgBtn.click();
	}
}
