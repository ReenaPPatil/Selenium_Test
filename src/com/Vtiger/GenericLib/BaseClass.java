package com.Vtiger.GenericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Vtiger.ObjectRepositoryLib.HomePage;
import com.Vtiger.ObjectRepositoryLib.Login;

public class BaseClass {
	public static WebDriver driver;
	public static FileLib fLib=new FileLib();
	
	@BeforeClass
	public void configBC() throws Throwable{
		//Get browser data from properties file
		String browserName = fLib.getPropertyKeyValue("browser");
		if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();	
		}else if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void configBM() throws Throwable{
		String URL=fLib.getPropertyKeyValue("url");
		String USER=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		
		driver.get(URL);
		Login lp=PageFactory.initElements(driver, Login.class);
		lp.LoginToApp(USER,PASSWORD);
	}
	
	@AfterMethod
	public void configAM() throws Throwable{
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.logout();
	}
	
	@AfterClass
	public void configAC() throws Throwable{
		driver.close();
	}

}
