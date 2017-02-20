package com.abcassignment.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.abcassignment.pom.pages.LaunchPage;

import com.abcassignment.pom.pages.session.NavigationPage;
import com.abcassignment.pom.testcases.base.BaseTest;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.LogStatus;

public class NavigationPageTest extends BaseTest {
	

	@Test
	public void testNavigationPage() throws InterruptedException
	{
	test = extent.startTest("NavigationPageTest");
	test.log(LogStatus.INFO,"Starting NavigationPage Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);
	
	NavigationPage navPage = new NavigationPage(driver,test);
	PageFactory.initElements(driver,navPage);
	navPage.navigate(ABCNewsConstants.NAV_URL_KEY);
	test.log(LogStatus.INFO, "Navigated to RATIONAL web Page Successfully");
	
	navPage.verifyingNavigationFunctionality();
	navPage.takeScreenshot();
	navPage.click(ABCNewsConstants.HOME_PAGE_XPATH);
	navPage.goingToEndofTheProgram();
	navPage.takeScreenshot();
	
	
	
	
	try
	{
		Thread.sleep(2000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	navPage.takeScreenshot();
	
	
	if(navPage instanceof NavigationPage)
		test.log(LogStatus.PASS, "Navigation Page Test PASSED");
	else 
		test.log(LogStatus.FAIL, "Navigation Page Test FAILED");
	
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



