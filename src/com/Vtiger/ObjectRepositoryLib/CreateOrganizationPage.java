package com.Vtiger.ObjectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.GenericLib.BaseClass;

public class CreateOrganizationPage extends BaseClass {

	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveOrgBtn;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveOrgBtn.click();
	}
	
}
