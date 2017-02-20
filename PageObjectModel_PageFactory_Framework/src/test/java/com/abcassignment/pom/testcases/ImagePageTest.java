package com.abcassignment.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.abcassignment.pom.pages.LaunchPage;
import com.abcassignment.pom.pages.session.ImagePage;

import com.abcassignment.pom.testcases.base.BaseTest;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.LogStatus;

public class ImagePageTest extends BaseTest{
	
	@Test
	public void testImagePage()
	{
	test = extent.startTest("ImagePageTest");
	test.log(LogStatus.INFO,"Starting ImagePage Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);
	
	ImagePage imgPage = new ImagePage(driver,test);
	PageFactory.initElements(driver,imgPage);
	imgPage.navigate(ABCNewsConstants.IMAGE_URL_KEY);
	test.log(LogStatus.INFO, "Navigated to Image Page Successfully");
	
	imgPage.isElementPresent(ABCNewsConstants.IMAGE_WEB_ELEMENT);
	test.log(LogStatus.INFO, "Image loaded Successfully");
	
	
	
	try
	{
		Thread.sleep(2000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	imgPage.takeScreenshot();
	
	
	if(imgPage instanceof ImagePage)
		test.log(LogStatus.PASS, "Image Page Test PASSED");
	else 
		test.log(LogStatus.FAIL, "Image Page Test FAILED");
	
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
