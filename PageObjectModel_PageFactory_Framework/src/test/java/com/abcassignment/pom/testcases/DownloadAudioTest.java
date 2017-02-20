package com.abcassignment.pom.testcases;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.abcassignment.pom.pages.LaunchPage;
import com.abcassignment.pom.pages.session.RadioNationalPage;
import com.abcassignment.pom.testcases.base.BaseTest;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.LogStatus;

public class DownloadAudioTest extends BaseTest{
	
	

	@Test
	public void testDownloadAudioRadio() throws InterruptedException
	{
	test = extent.startTest("DownloadAudio Test");
	test.log(LogStatus.INFO,"Starting DownloadAudio Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);
	
	RadioNationalPage radNationalPage = new RadioNationalPage(driver,test);
	PageFactory.initElements(driver,radNationalPage);
	
	radNationalPage.navigate(ABCNewsConstants.SHARE_ICON_HOME_URL_KEY);
	test.log(LogStatus.INFO, "Navigated to RATIONAL web Page Successfully");
	
	radNationalPage.downloadAudioFunctionality();
	Thread.sleep(10000);
	radNationalPage.takeScreenshot();
	test.log(LogStatus.INFO, "Automatic file download started.....");
	

	
	if(radNationalPage instanceof RadioNationalPage)
		test.log(LogStatus.PASS, "DownloadAudio Test PASSED");
	else 
		test.log(LogStatus.FAIL, "DownloadAudio Test FAILED");
	
	
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

