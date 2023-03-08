package com.RealCitadel.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="exampleInputEmail1") private WebElement UNTxtFeild;
	@FindBy(id="exampleInputPassword1") private WebElement PWdTxtFeild;
	@FindBy(xpath="//button[text()='Submit']") private WebElement SubBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void LoginAction(String UN,String Pwd) {
		UNTxtFeild.sendKeys(UN);
		PWdTxtFeild.sendKeys(Pwd);
		SubBtn.click();
	}
	

}
