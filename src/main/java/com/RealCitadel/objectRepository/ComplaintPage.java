package com.RealCitadel.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplaintPage {
	@FindBy(xpath="//input[@id='name']")
	private WebElement ownerName;
	@FindBy(xpath="//input[@id='cmp']")
	private WebElement complaintTxtFeild;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submitBtn;
	
	public ComplaintPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	public void ownerNameClick() {
		ownerName.click();
	}
	public void complaintTxtClick() {
		complaintTxtFeild.click();
	}
	public void SubbmitClick() {
		 submitBtn.click();
	}
}
