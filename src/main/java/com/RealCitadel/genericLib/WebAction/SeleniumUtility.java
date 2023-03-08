package com.RealCitadel.genericLib.WebAction;

import java.io.IOException;

import java.util.Set;

import org.bouncycastle.asn1.microsoft.MicrosoftObjectIdentifiers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class contains
 * @author HP
 *
 */
public class SeleniumUtility {
	private WebDriver driver;
	/**
	 * 
	 * @param browser
	 * @return 
	 * 
	 */

	public WebDriver launchBrowser(String browser) {
		//wt ever we create proprty data we need to impliment here

		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		}
		return driver;
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();

	}
	public void launchApplication(String url) {
		driver.get(url);
	}
	
	/*
	 * public void lunchApplication(String url) { //waitForElementLoad(timeout);
	 * driver.get(url);}
	 */



public void reSizeBrowser(int width,int hight) {
	driver.manage().window().setSize(null);
}
public void closeTab() throws IOException {
	driver.close();
}

public void closeBrowser() throws IOException {
	driver.quit();
}

/*public void acceptAlert() {
	driver.switchTo().alert().accept();
}

public void dismissAlert() {
	driver.switchTo().alert().dismiss();
}

public String getAlertMessage() {
	return driver.switchTo().alert().getText();
}

public void switchFrame(int index) {
	driver.switchTo().frame(index);
}

public void switchFrame(String nameOrId) {
	driver.switchTo().frame(nameOrId);
}

public void switchFrame(WebElement frameElement) {
	driver.switchTo().frame(frameElement);
}

public void switchbackFrame() {
	driver.switchTo().defaultContent();
}

public void scrollBar(int x, int y) {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(" + x + "," + y + ")");
}

public void performClickOpertion(WebElement element) {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", element);
}*/

public boolean switchTabs(String expPageTitle) {

	Set<String> windows = driver.getWindowHandles();
	boolean found = false;
	for (String window : windows) {
		driver.switchTo().window(window);
		if (driver.getTitle().contains(expPageTitle)) {
			found = true;
			break;
		}
	}
	return found;
}

public void switchBackToParent(String parentWindow) {

	driver.switchTo().window(parentWindow);

	driver.manage();
	driver.navigate();
}

public String getCurrentUrl() {
	return driver.getCurrentUrl();
}

public String getPageSource() {
	return driver.getPageSource();
}

public String getPageTitle() {
	return driver.getTitle();
}

public void fullscreen() {
	driver.manage().window().fullscreen();
}


/*public void getURL(String url) {
	driver.get(url);
}*/




}


