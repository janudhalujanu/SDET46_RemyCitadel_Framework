package com.RealCitadel.genericLib.WebAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InteractionUtility {
	/**
	 * 
	 */
	private Actions act;
	public  void InteractionUtility(WebDriver driver) {
	 act = new Actions(driver);
		
	}
	/**
	 * this method is used to Move
	 * @param element
	 */
public void mouseHover(WebElement element) {
	act.moveToElement(null).perform();
	
}
/**
 * this method is used to double click action 
 */
public void doubleClick() {
	act.doubleClick().perform();
}
/**
 * this method is used to perform contextclick action
 */
public void contextClick() {
	act.contextClick().perform();
}

}