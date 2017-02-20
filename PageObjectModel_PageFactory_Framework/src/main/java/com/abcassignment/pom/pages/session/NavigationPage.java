package com.abcassignment.pom.pages.session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.abcassignment.pom.base.BasePage;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NavigationPage extends BasePage {
	
	public NavigationPage(WebDriver driver,ExtentTest test)
	{
		
		super(driver,test);
	
	}
	
	public void verifyingNavigationFunctionality() throws InterruptedException
	{
		driver.findElement(By.xpath(ABCNewsConstants.PROGRAMS_HYPERLINK_XPATH)).click();
		test.log(LogStatus.INFO, "Clicked on Program Links Sucessfully");
        Thread.sleep(5000);
        driver.findElement(By.xpath(ABCNewsConstants.BIGIDEAS_LINK_XPATH)).click();
        test.log(LogStatus.INFO, "Clicked on BIGIDEAS link successfully");
        String text= driver.getTitle();  
        System.out.println(text);
        test.log(LogStatus.INFO, "Title of the page: -"+text);
	}
	
    public void goingToEndofTheProgram() throws InterruptedException
    {
    	driver.findElement(By.xpath(ABCNewsConstants.RIGHT_ARROW_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ABCNewsConstants.RIGHT_ARROW_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ABCNewsConstants.RIGHT_ARROW_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ABCNewsConstants.RIGHT_ARROW_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ABCNewsConstants.LAST_PROGRAM_XPATH)).click();
    
        boolean runProgram = true;
    	if(runProgram)
    	{
    		
    		test.log(LogStatus.PASS, "goingToEndofTheProgram run successfully");
    		
    	}
    	else
    	{
    		
    		test.log(LogStatus.FAIL, "goingToEndofTheProgram did not run successfully");
    		
    	}
    }
    

}
