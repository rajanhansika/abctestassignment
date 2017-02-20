package com.abcassignment.pom.pages.session;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.abcassignment.pom.base.BasePage;
import com.abcassignment.pom.util.ABCNewsConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RadioNationalPage extends BasePage{

	public RadioNationalPage(WebDriver driver,ExtentTest test)
	{
		
		super(driver,test);
	
	}
	
	
	public void clickOnShareIcon()
	{
          WebElement downloadAudio = driver.findElement(By.xpath(ABCNewsConstants.DOWNLOAD_AUDIO_TAB_XPATH));
		
		try
		{
			
			Actions oAction = new Actions(driver);
			oAction.moveToElement(downloadAudio);
			Thread.sleep(3000);
			oAction.contextClick(downloadAudio).sendKeys(Keys.TAB).
	        sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
	        .sendKeys(Keys.ALT).
			sendKeys(Keys.ENTER).build().perform();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void clickOnListenNow()
	{
		driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div/div[1]/ul/li[1]/a")).click();
		test.log(LogStatus.INFO,"Clicked on Listen Now Radio Tab");
		String URL = driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div/div[1]/ul/li[1]/a")).getAttribute("href");
		test.log(LogStatus.INFO, "Navigated to the URL:- " +URL);
		
	}
	
	public void downloadAudioFunctionality()
	{
		WebElement downloadAudioButton = driver
                .findElement(By.xpath(ABCNewsConstants.DOWNLOAD_AUDIO_TAB_XPATH));

        // Right click, then select "Save As.."
        Actions action = new Actions(driver);
        
        action.contextClick(downloadAudioButton).
        sendKeys(Keys.ALT).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
        build().perform();
        
     }
}
