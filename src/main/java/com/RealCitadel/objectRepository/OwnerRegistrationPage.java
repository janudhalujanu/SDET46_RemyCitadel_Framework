package com.RealCitadel.objectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnerRegistrationPage {
	@FindBy(xpath="//input[@id='fullname']")
	private WebElement FNTxtField;
	@FindBy(xpath="//input[@id='username']")
	private WebElement UNTxtField;
	@FindBy(xpath="//input[@id='mobible']")
	private WebElement MbTextFeild;
	@FindBy(xpath="//input[@id='email']")
	private WebElement EmailTxtFeild;
	@FindBy(xpath="//input[@id='password']")
	private WebElement PwdTxtFeild;
	@FindBy(xpath="//input[@id='c_password']")
	private WebElement CpwdTxtFeild;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement RegisterBtn;
	
	public  OwnerRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void RegisterAction(Map<String,String>map) {
		FNTxtField.sendKeys("fullname");
		UNTxtField.sendKeys("username");
		 MbTextFeild.sendKeys("mobible");
		 EmailTxtFeild.sendKeys("email");
		 CpwdTxtFeild.sendKeys("c_password");
		 RegisterBtn.click();
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private WebDriver driver;
	String RegisterRoomPagePartialXpath="//h2[.='Register Room']/..//div/input[@id='%s']";
	
	private WebElement convertToElement(String partialXpath,String replaceData) {
		String xPath=String.format(partialXpath,replaceData);
		return driver.findElement(By.xpath(xPath));
	}
	public OwnerRegistrationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void setDataIntoTextFeild(Map<String,String>registerInformation) {
		for(Entry<String, String> KeyValue:registerInformation.entrySet()){
			convertToElement(RegisterRoomPagePartialXpath,KeyValue.getKey()).sendKeys(KeyValue.getValue());
			
		}

}*/

