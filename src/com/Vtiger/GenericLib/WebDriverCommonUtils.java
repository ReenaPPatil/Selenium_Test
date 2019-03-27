package com.Vtiger.GenericLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonUtils extends BaseClass{
	public void moveToCursor(WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element);
	}
	public void waitForElementToPresentInGUI(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void WaitAndClick(WebElement element) throws Throwable{
		int count=0;
		while(count<20){
			try {
				element.click();
				break;
			} catch (Throwable e){
				Thread.sleep(2000);
				e.printStackTrace();
				count++;
				}
		}
	}

}
