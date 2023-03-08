package com.RealCitadel.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	@FindBy(xpath="//input[@id='keywords']")private WebElement KeyTxtFeild;
	@FindBy(xpath="//input[@id='location']")private WebElement LocationTxtFeild;
	@FindBy(xpath="//button[@name='search']") private WebElement SearchBtn;
	@FindBy(xpath="//h4[.='Room Details']/..//div[1]/p")
	private List<WebElement> apartmentNameVerification;
	
public SearchPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public void SearchPageAction(String Keywords,String location ) {
	KeyTxtFeild.sendKeys(Keywords);
	LocationTxtFeild.sendKeys(location);
	
}
public String apartmentNameVerification() {
	String actualApartmetName = "";
	for(WebElement ele:apartmentNameVerification) {
		actualApartmetName = ele.getText().replaceAll("Apartment Name: ","");
		
		}
	return actualApartmetName;
}
public void searchClick() {
	SearchBtn.click();
}
}

