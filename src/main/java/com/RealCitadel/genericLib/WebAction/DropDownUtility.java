package com.RealCitadel.genericLib.WebAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {
	/**
	 * this is used for the select Dropdown for 
	 * @param element
	 * @param value
	 */
public void handleDropDown(WebElement element,String value) {
		Select indDD=new Select(element);
	indDD.selectByValue(value);
	}
/**
 * 
 * @param VisibleText
 * @param element
 */

	public void handleDropDown(String VisibleText,WebElement element) {
	
		Select indDD=new Select(element);
		indDD.selectByVisibleText(VisibleText);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select indDD=new Select(element);
		indDD.selectByIndex(index);
	}
	


}
