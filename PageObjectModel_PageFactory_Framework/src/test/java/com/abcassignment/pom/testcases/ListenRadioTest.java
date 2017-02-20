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

public class ListenRadioTest extends BaseTest{
	
	@Test
	public void testListenRadio() throws InterruptedException
	{
	test = extent.startTest("ListenRadio Test");
	test.log(LogStatus.INFO,"Starting ListenRadio Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);
	
	RadioNationalPage radNationalPage = new RadioNationalPage(driver,test);
	PageFactory.initElements(driver,radNationalPage);
	
	radNationalPage.navigate(ABCNewsConstants.SHARE_ICON_HOME_URL_KEY);
	test.log(LogStatus.INFO, "Navigated to RATIONAL web Page Successfully");
	
	radNationalPage.clickOnListenNow();
	
	try
	{
		Thread.sleep(8000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	Set<String> windowIds = driver.getWindowHandles();
	Iterator<String> it = windowIds.iterator();
	
	String Window1 = it.next();
	String Window2 = it.next();
	System.out.println(windowIds.size());
	driver.switchTo().window(Window2);
	Thread.sleep(10000);
	radNationalPage.takeScreenshot();
	driver.switchTo().window(Window1);
	radNationalPage.takeScreenshot();
	
	
	
	if(radNationalPage instanceof RadioNationalPage)
		test.log(LogStatus.PASS, "ListenRadio Test PASSED");
	else 
		test.log(LogStatus.FAIL, "ListenRadio Test FAILED");
	
	
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
