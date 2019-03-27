package com.Vtiger.ObjectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Vtiger.GenericLib.BaseClass;
import com.Vtiger.GenericLib.WebDriverCommonUtils;

public class HomePage extends BaseClass {
	
	WebDriverCommonUtils util=new WebDriverCommonUtils();
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationsLnk;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement userImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	public void navigateToOrganizations() throws Throwable {
		organizationsLnk.click();
	}

	public void logout() throws Throwable {
		util.WaitAndClick(userImg);
		signOutLnk.click();
	}
	
}
