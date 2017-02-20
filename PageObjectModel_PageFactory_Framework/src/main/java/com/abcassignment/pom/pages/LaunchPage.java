package com.abcassignment.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.abcassignment.pom.base.BasePage;
import com.abcassignment.pom.pages.session.LandingPage;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class LaunchPage extends BasePage {
	

	public LaunchPage(WebDriver driver,ExtentTest test)
	{
		
		super(driver,test);
	
	}
	
	public LandingPage goToNewsHomePage()
	{
		test.log(LogStatus.INFO, "Opening the URL :-" +ABCNewsConstants.HOMEPAGE_URL);
		driver.get(ABCNewsConstants.HOMEPAGE_URL);
		test.log(LogStatus.PASS,ABCNewsConstants.HOMEPAGE_URL+" - successfully loaded");
	
		LandingPage landingPage = new LandingPage(driver,test);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
		
		
	}

}
