package com.abcassignment.pom.pages.session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.abcassignment.pom.base.BasePage;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JustInPage extends BasePage {
	

	
	public JustInPage(WebDriver driver,ExtentTest test)
	{
		
		super(driver,test);
	
	}
	
	public void verificationFunctionality()
	{
		String text = driver.findElement(By.xpath(ABCNewsConstants.VERIFYING_TEXT)).getText();
        test.log(LogStatus.INFO, text);
	}

}
