package com.RealCitadel.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardLinks {
	@FindBy(xpath="//a[.='Home']")
	private WebElement HomeLink;
	@FindBy(xpath="//a[.='Register']")
	private WebElement registerLink;
	@FindBy(xpath="//a[.='Details/Update']")
	private WebElement  DetailUpdateLink;
	@FindBy(xpath="//a[.='//a[.='Send SMS']")
	private WebElement SendSMSLink ;
	@FindBy(xpath="//a[.='Complaint List']")
	private WebElement ComplaintList;
	@FindBy(xpath="//b[text()='Registered Users: ']")
	private WebElement RegisterUserLink;
	@FindBy(xpath="//b[text()='Rooms for Rent: ']")
	private WebElement RoomForRentLink;
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//h2[.='Register Room']/preceding-sibling::div[1]")
	private WebElement registrationSuccessMessage;
	
	@FindBy(xpath="//a[.='Mahantesh Kumbar (Admin)']")
	private WebElement adminPageVerification;
	
	

public AdminDashboardLinks(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void homeClick() {
	HomeLink.click();
}
public void registerlick() {
	registerLink.click();
}
public void detailsClick() {
	DetailUpdateLink.click();
}
public void sendSMSclick() {
	SendSMSLink.click();
}
public void complaintClick() {
	ComplaintList.click();
}
public String  adminPageVerification() {
	return adminPageVerification.getText();
}
public void registerUserClick() {
	RegisterUserLink.click();
}
public void roomforRentClick() {
	 RoomForRentLink.click();
}
public String successMessage() {
	return  registrationSuccessMessage.getText();
}
public void logoutClick() {
	logoutBtn.click();
}
}