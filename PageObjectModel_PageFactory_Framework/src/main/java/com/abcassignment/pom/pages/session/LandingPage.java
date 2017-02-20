package com.abcassignment.pom.pages.session;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abcassignment.pom.base.BasePage;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LandingPage extends BasePage{
	


    @FindBy(xpath = ABCNewsConstants.JUSTINPAGE_LINK)
    public WebElement justIn;
    

    
	
	public LandingPage(WebDriver driver,ExtentTest test)
	{
		
		super(driver,test);
		
	}
	

	
	public Object goToJustInPage()
	{
	
		
		
		test.log(LogStatus.INFO, "Clicking JustIn hyperlink");
		justIn.click();
		
		//justIn- hyperlink click validation
		boolean clickSuccess = true;
		if(clickSuccess)
		{
			JustInPage justInPage = new JustInPage(driver,test);
			PageFactory.initElements(driver, justInPage);
			test.log(LogStatus.PASS, "JustIn-Page loaded successfully");
			return justInPage;
		}
		else
		{
			LandingPage landingPage = new LandingPage(driver,test);
			PageFactory.initElements(driver, landingPage);
			test.log(LogStatus.FAIL, "JustIn-Page not loaded successfully");
			return landingPage;
		}
		
	}

	
	
}
