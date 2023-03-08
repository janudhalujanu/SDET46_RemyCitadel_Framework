package com.RealCitadel.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLinks {
	@FindBy(xpath="//a[text()='Search']")
	private WebElement SearchLinkBtn;
	@FindBy(xpath="//a[.='Register']")
	private WebElement RegisterLinkBtn;
	@FindBy (xpath="//a[text()='Login']")
	private WebElement LoginLinkBtn;
	
	@FindBy(xpath="//div[.='Welcome To Room Rental Registration!']")
	private WebElement homePageVerification;
	
	public  HomePageLinks(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void searchClick() {
		SearchLinkBtn.click();
	}
	public void registerLinkClick() {
		 RegisterLinkBtn.click();
	}
	public void loginLinkClick() {
		LoginLinkBtn.click();
	}
	public  String homePageVerification() {
		return homePageVerification.getText();
	}
}

