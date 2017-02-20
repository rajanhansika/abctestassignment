package com.abcassignment.pom.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.abcassignment.pom.pages.LaunchPage;
import com.abcassignment.pom.pages.session.RadioNationalPage;
import com.abcassignment.pom.testcases.base.BaseTest;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.LogStatus;

public class ShareIconTest extends BaseTest{
	
	@Test
	public void testShareIcon() throws InterruptedException
	{
	test = extent.startTest("ShareIcon Test");
	test.log(LogStatus.INFO,"Starting ShareIcon Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);
	
	RadioNationalPage radNationalPage = new RadioNationalPage(driver,test);
	PageFactory.initElements(driver,radNationalPage);
	
	radNationalPage.navigate(ABCNewsConstants.SHARE_ICON_HOME_URL_KEY);
	test.log(LogStatus.INFO, "Navigated to RATIONAL web Page Successfully");
	
	radNationalPage.clickOnShareIcon();
	try
	{
		Thread.sleep(5000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	test.log(LogStatus.INFO, "Clicked on Social Media Share Icon at the bottom successfully");
	try
	{
		Thread.sleep(5000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	Set<String> windowIds = driver.getWindowHandles();
	Iterator<String> it = windowIds.iterator();
	
	String mainWindow = it.next();
	String popupWindow = it.next();
	driver.switchTo().window(popupWindow);
	radNationalPage.takeScreenshot();
	try
	{
		Thread.sleep(3000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	driver.close();
	driver.switchTo().window(mainWindow);
	radNationalPage.takeScreenshot();
	
	if(radNationalPage instanceof RadioNationalPage)
		test.log(LogStatus.PASS, "ShareIcon Test PASSED");
	else 
		test.log(LogStatus.FAIL, "ShareIcon Test FAILED");
	
	
	}
	
	@AfterMethod
	public void quit()
	{
		if(extent!=null)
	{		extent.endTest(test);
		extent.flush();
	}
	if(driver!=null)
		driver.quit();
	}
	
	}


