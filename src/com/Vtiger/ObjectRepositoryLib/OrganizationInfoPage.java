package com.Vtiger.ObjectRepositoryLib;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.GenericLib.BaseClass;

public class OrganizationInfoPage extends BaseClass {
	
	@FindBy(className="dvHeaderText")
	private WebElement OrgInfo;
	
	public WebElement getOrgInfo() {
		return OrgInfo;
	}

	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@name='Edit']")
	private WebElement EditBtn;
	
	@FindBy(xpath="//input[@name='Delete']")
	private WebElement DeleteBtn;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveOrgBtn;
	
	public void modifyOrg(String orgName, String ModifyOrgName)
	{
		EditBtn.click();
		orgNameEdt.clear();
		orgNameEdt.sendKeys(ModifyOrgName);
		saveOrgBtn.click();
	}
	
	public void deleteOrg(String orgName) throws InterruptedException
	{
		DeleteBtn.click();
		Thread.sleep(1000);
		Alert alt=driver.switchTo().alert();
		//String ExpMsg = alt.getText();
		alt.accept();
	}
	
}
