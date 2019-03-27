package com.Vtiger.OrganizationTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Vtiger.GenericLib.BaseClass;
import com.Vtiger.ObjectRepositoryLib.CreateOrganizationPage;
import com.Vtiger.ObjectRepositoryLib.HomePage;
import com.Vtiger.ObjectRepositoryLib.OrganizationInfoPage;
import com.Vtiger.ObjectRepositoryLib.OrganizationPage;


public class OrganizationTest extends BaseClass{
	
	@Test
	public void createOrganizationTest() throws Throwable{
		
		//Read data from excel file
		String temp;
		String organizationName = fLib.getExcelData("Sheet1", 1, 2);
		//Click on Organization link
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOrganizations();
		//Navigate to create new organization page
		OrganizationPage org = PageFactory.initElements(driver, OrganizationPage.class);
		org.navigateToCreateOrgPage();
		//Create new customer
		CreateOrganizationPage op = PageFactory.initElements(driver, CreateOrganizationPage.class);
		op.createOrg(organizationName);
		//verify
		OrganizationInfoPage oi = PageFactory.initElements(driver, OrganizationInfoPage.class);
		String actOrgName = oi.getOrgInfo().getText();
		boolean status = actOrgName.contains(organizationName);
		Assert.assertTrue(status);
		Reporter.log("Organization "+organizationName+" created");
	}
	
	@Test
	public void modifyOrganizationTest() throws Throwable{
		//Read data from excel
		String organizationName = fLib.getExcelData("Sheet1", 2, 2);
		String ModifyOrgName = fLib.getExcelData("sheet1", 2, 3);
		//Click on Organization link
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOrganizations();
		//Navigate to create new organization page
		OrganizationPage org = PageFactory.initElements(driver, OrganizationPage.class);
		org.navigateToCreateOrgPage();
		//Create new customer
		CreateOrganizationPage op = PageFactory.initElements(driver, CreateOrganizationPage.class);
		op.createOrg(organizationName);
		//Edit organization details
		OrganizationInfoPage oi = PageFactory.initElements(driver, OrganizationInfoPage.class);
		oi.modifyOrg(organizationName, ModifyOrgName);
		
		Reporter.log("Organization "+organizationName+ " modified to "+ModifyOrgName);
	}
	
	@Test
	public void deleteOrganizationTest() throws Throwable{
		//Read data from excel
		String organizationName = fLib.getExcelData("Sheet1", 3, 2);
		//Click on Organization link
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOrganizations();
		//Navigate to create new organization page
		OrganizationPage org = PageFactory.initElements(driver, OrganizationPage.class);
		org.navigateToCreateOrgPage();
		//Create new customer
		CreateOrganizationPage op = PageFactory.initElements(driver, CreateOrganizationPage.class);
		op.createOrg(organizationName);
		//Delete organization
		OrganizationInfoPage oi = PageFactory.initElements(driver, OrganizationInfoPage.class);
		oi.deleteOrg(organizationName);
		
		Reporter.log("Organization "+organizationName+" deleted");
	}
	
}
