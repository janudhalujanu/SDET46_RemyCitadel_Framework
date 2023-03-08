package com.RealCitadel.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	@FindBy(xpath="//input[@id='fullname']") private WebElement FuNTxtFeild;
	@FindBy(xpath="//input[@id='username']") private WebElement UnTxtFeild;
	@FindBy(xpath="//input[@id='mobile']") private WebElement MobileTxtFeild;
	@FindBy(xpath="//input[@id='email']") private WebElement EmailTxtFeild;
	@FindBy(xpath="//input[@id='password']") private WebElement PwdTxtFeild;
	@FindBy(xpath="//input[@id='c_password']") private WebElement ConfirmPwdTxtFeild;
	@FindBy(xpath="//button[text()='Submit']") private WebElement SubmitBtn;
	public RegisterPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void RegisterPageAction(String fullname,String username,String mobile,String email,String password,String Cpassword,String subbmit) {
		FuNTxtFeild.sendKeys(fullname);
		UnTxtFeild.sendKeys(username);
		MobileTxtFeild.sendKeys(mobile);
		EmailTxtFeild.sendKeys(email);
		PwdTxtFeild.sendKeys(password);
		
	}
	
	
	
	

}
