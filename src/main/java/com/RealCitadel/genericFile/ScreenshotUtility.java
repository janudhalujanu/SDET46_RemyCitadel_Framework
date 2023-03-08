package com.RealCitadel.genericFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenshotUtility {
	
	WebDriver driver;

public	ScreenshotUtility(WebDriver driver)
{
	this.driver=  driver;
}
		public String getPhoto(String testCaseName,JavaUtility javaUtility) throws IOException {
			
		
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(FrameWorkConstants.TEST_SCREENSHOT_PATH+testCaseName+"_"+javaUtility.getCurrentDate()+".png");
			FileUtils.copyFile(src, dest);
			return dest.getAbsolutePath();
				
			
		}
		public String getPhoto(WebElement ele,String elementName,JavaUtility javaUtility) throws IOException {
		File src=ele.getScreenshotAs(OutputType.FILE);
		File dest=new File(FrameWorkConstants.TEST_SCREENSHOT_PATH+elementName+""+".png");
			FileUtils.copyFile(src, dest);
			return dest.getAbsolutePath();
		}
		public String getScreenshot()
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			String path = ts.getScreenshotAs(OutputType.BASE64);
			return path;
			
		}

	}


