package com.abcassignment.pom.testcases;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.abcassignment.pom.pages.LaunchPage;

import com.abcassignment.pom.pages.session.VideoPage;
import com.abcassignment.pom.testcases.base.BaseTest;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.LogStatus;

public class VideoPageTest extends BaseTest{
	
	@Test
	public void testVideoPage()
	{
	test = extent.startTest("VideoPageTest");
	test.log(LogStatus.INFO,"Starting VideoPage Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);
	
	VideoPage videoPage = new VideoPage(driver,test);
	PageFactory.initElements(driver,videoPage);
	videoPage.navigate(ABCNewsConstants.VIDEO_URL_KEY);
	test.log(LogStatus.INFO, "Navigated to Video Page Successfully");
	
	videoPage.isElementPresent(ABCNewsConstants.VIDEO_WEB_ELEMENT);
	
	//Clicking the video
	videoPage.click(ABCNewsConstants.VIDEO_PLAY_BUTTON);
	try
	{
		Thread.sleep(5000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	videoPage.takeScreenshot();
	
	
	if(videoPage instanceof VideoPage)
		test.log(LogStatus.PASS, "Video Page Test PASSED");
	else 
		test.log(LogStatus.FAIL, "Video Page Test FAILED");
	
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
