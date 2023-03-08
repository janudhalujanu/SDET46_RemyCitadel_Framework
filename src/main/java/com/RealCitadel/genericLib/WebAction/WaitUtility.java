package com.RealCitadel.genericLib.WebAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	private WebDriverWait wait;
	private WebDriver driver ;
	public void WaitUtility(WebDriver driver) {
		wait=new WebDriverWait(driver,10);
	}

	public void pause(long milisecond) {
		try {
			Thread.sleep(0);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public void waitForElementLoad(WebDriver  driver,long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	public void waitUntilVisible(String xpath) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
	}

	public void waitTillClick(long pollingTime,int duration,WebElement element) throws InterruptedException {
		int count=0;
		while(count<duration) {
			try {
				element.click();
				break;

			}
			catch(Exception e) {
				Thread.sleep(pollingTime);
				count++;
			}
		}
	}





}
