package com.abcassignment.pom.base;

import java.io.File;
import java.util.Date;

//import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.abcassignment.pom.pages.common.TopMenu;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {
	
	public WebDriver driver;
	public TopMenu menu;
	public ExtentTest test;
	
	//Default constructor
	public BasePage()
	{
		
	}
	
	
	
	//Creating a constructor
	public BasePage(WebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		menu = PageFactory.initElements(driver, TopMenu.class);
	}
	
	//Verification of Title
	public void verifyTitle(String expTitle)
	{
		test.log(LogStatus.INFO,"Verifying the title - "+expTitle);
		expTitle = driver.findElement(By.xpath(ABCNewsConstants.TITLE_xpath)).getText();
	}
	
	public boolean verifyText(String locatorkey,String expectedTextKey)
	{
		test.log(LogStatus.INFO, "Trying to find the TEXT WebElement -> "+ABCNewsConstants.TITLE_xpath);
		String actualText=getElement(locatorkey).getText().trim();
	    String expectedText=expectedTextKey;
	     
		if(actualText.equals(expectedText))
			return true;
		else 
			return false;
	}
	
	public WebElement getElement(String locatorKey){
		WebElement e=null;
		test.log(LogStatus.INFO,locatorKey);
		try{
		if(locatorKey.endsWith("_id"))
			e = driver.findElement(By.id(locatorKey));
		else if(locatorKey.endsWith("_name"))
			e = driver.findElement(By.name(locatorKey));
		else if(locatorKey.endsWith("_xpath"))
			e = driver.findElement(By.xpath(locatorKey));
		else{
			
			//Assert.fail("Locator not correct - " + locatorKey);
			test.log(LogStatus.FAIL, "Locator not correct - " + locatorKey);
			
		}
		
		}catch(Exception ex){
			// fail the test and report the error
		    test.log(LogStatus.INFO, ex.getMessage());
			ex.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
		}
		test.log(LogStatus.INFO,locatorKey);
		return e;
		
	}
	
	public boolean isElementPresent(String locatorkey)
	{
		
		int s = driver.findElements(By.xpath(locatorkey)).size();
		if (s==0)
		{
			test.log(LogStatus.INFO, "Required WebElement not found");
			return false;
		}
		
		else
		{
			test.log(LogStatus.INFO, "Required WebElement found");
			
			return true;
			
		}
		     
	}
	
	public TopMenu getMenu()
	{
		return menu;
	}
	
	public void takeScreenshot()
	{
		
		//fileName of the screenshot
	    //code for taking screenshot
				Date d = new Date();
				String screenshotFile = d.toString().replace(":", "_").replace(" ", "_")+".png";
				String filePath = System.getProperty("user.dir")+ABCNewsConstants.REPORTS_PATH+ "//Screenshots//"+screenshotFile;
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try
				{
					FileUtils.copyFile(scrFile,new File(filePath));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				test.log(LogStatus.INFO, test.addScreenCapture(filePath));
				
	}
	
	public void navigate(String urlkey)
	{
		driver.get(urlkey);
	}

	public void click(String xPathElement)
	{
		driver.findElement(By.xpath(xPathElement)).click();
	}
}
