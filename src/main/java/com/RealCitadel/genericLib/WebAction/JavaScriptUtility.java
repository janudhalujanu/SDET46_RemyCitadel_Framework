package com.RealCitadel.genericLib.WebAction;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * @author jyothi
 *
 */
public class JavaScriptUtility {
	JavascriptExecutor js;
	public  JavaScriptUtility(WebDriver driver) {
		js=(JavascriptExecutor) driver;
	}
	public void scrollUp() {
		js.executeScript("window.scrollBy(0,.document.body.scrollHeight");
	}
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView",element);
		
	}
	public void scrollDown() {
		js.executeScript("window.scollBy(0,document.body.scrollHeight)");
	}
	public void click(WebElement element) {
		js.executeScript("argument[0].click()",element);
	}
	public void sendKeys(WebElement element,String data) {
		js.executeScript("argument[0].value=argument[1]",element,data);
		
	}
	public void launchApplication(String url) {
		js.executeScript("window.location=arguments[0]",url);
	}
	public void highlight(WebElement element) {
		js.executeScript("arguments[0].setAttribute('style','border 6px dotted red;')",element);
	}
	

}
