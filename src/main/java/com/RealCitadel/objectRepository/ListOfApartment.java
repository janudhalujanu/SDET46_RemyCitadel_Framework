package com.RealCitadel.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfApartment {
	@FindBy(xpath="//h2[.='List of Apartment Details']")
	private WebElement apartmentpageVerification;
	@FindBy(xpath="//h4[.='Owner Details']/../p[1]")
	
	private List<WebElement> ownerNameVerification;
	
	public ListOfApartment(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
public String apartmentpageVerification() {
	return apartmentpageVerification.getText();
	
}
public String ownerNameVerification(){
	String actualFullName = "";
	for (WebElement ele1 : ownerNameVerification)
	{
		actualFullName = ele1.getText().replaceAll("Owner Name: ", "");
	}
	return actualFullName;
}
}