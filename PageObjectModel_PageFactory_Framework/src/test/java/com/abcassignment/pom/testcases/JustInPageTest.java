package com.abcassignment.pom.testcases;

import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.abcassignment.pom.pages.LaunchPage;
import com.abcassignment.pom.pages.session.JustInPage;
import com.abcassignment.pom.pages.session.LandingPage;

import com.abcassignment.pom.testcases.base.BaseTest;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.LogStatus;


public class JustInPageTest extends BaseTest {
	
	@Test
	public void testJustInPage()
	{
	test = extent.startTest("JustInPageTest");
	test.log(LogStatus.INFO,"Starting JustInPage Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);

	
	LandingPage landingPage = launchPage.goToNewsHomePage();

	Object page = landingPage.goToJustInPage();
	/*
	
	if(page instanceof LandingPage)
		Assert.fail("Navigation to JustIn Page Failed");
	else if(page instanceof JustInPage)
		System.out.println("Clicked JustIn hyperlink successfully");
	*/
		
	test.log(LogStatus.INFO,"Navigating to JustIn Page");
	JustInPage justInPage = (JustInPage)page;
	
   justInPage.verifyTitle(ABCNewsConstants.expectedTextKey);
   test.log(LogStatus.INFO, "Title Verified");
   test.log(LogStatus.INFO, test.addScreenCapture(System.getProperty("user.dir")+"\\Images\\JustInPage.png"));
   
   justInPage.verificationFunctionality();
   justInPage.takeScreenshot();
   
   if(justInPage instanceof JustInPage)
		test.log(LogStatus.PASS, "JustIn Page Test PASSED");
	else 
		test.log(LogStatus.FAIL, "JustIn Page Test FAILED");
		
	
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
