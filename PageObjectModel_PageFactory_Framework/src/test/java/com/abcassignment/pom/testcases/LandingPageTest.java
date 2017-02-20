package com.abcassignment.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.abcassignment.pom.pages.LaunchPage;
import com.abcassignment.pom.pages.session.LandingPage;

import com.abcassignment.pom.testcases.base.BaseTest;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.LogStatus;

public class LandingPageTest extends BaseTest {
	@Test
	public void testLandingPage()
	{
	test = extent.startTest("LandingPageTest");
	test.log(LogStatus.INFO,"Starting LandingPage Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);

	
	LandingPage landingPage = launchPage.goToNewsHomePage();
	test.log(LogStatus.INFO,"Navigating to ABC News Home Page");
	
	
	landingPage.isElementPresent(ABCNewsConstants.SET_LOCATION_WEBELEMENT);
	test.log(LogStatus.INFO, "News Banner loaded successfully");
	test.log(LogStatus.INFO, test.addScreenCapture(System.getProperty("user.dir")+"\\Images\\NewsBanner.png"));
	landingPage.takeScreenshot();
	
	if(landingPage instanceof LandingPage)
		test.log(LogStatus.PASS, "Landing Page Test PASSED");
	else 
		test.log(LogStatus.FAIL, "Landing Page Test FAILED");
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
