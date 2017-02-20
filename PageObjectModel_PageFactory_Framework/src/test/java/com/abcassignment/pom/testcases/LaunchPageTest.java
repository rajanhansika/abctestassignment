package com.abcassignment.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.abcassignment.pom.pages.LaunchPage;

import com.abcassignment.pom.testcases.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPageTest extends BaseTest{
	
	@Test
	public void testLaunchPage()
	{
	test = extent.startTest("LaunchPageTest");
	test.log(LogStatus.INFO,"Starting LaunchPage Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	//Create LaunchPage Object
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);
	
	if(launchPage instanceof LaunchPage)
		test.log(LogStatus.PASS, "Launch Page Test PASSED");
	else 
		test.log(LogStatus.FAIL, "Launch Page Test FAILED");

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
  

