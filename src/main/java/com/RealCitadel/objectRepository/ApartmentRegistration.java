package com.RealCitadel.objectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentRegistration {
	@FindBy(xpath="//h2[.='Apartment Room']/../form/div[6]/following-sibling::button")
	private WebElement apartmentRegistrationBtn;
	@FindBy(xpath="//a[text()='Add More(Plat Number/Description)']")
	private WebElement addMoreBtn;
	
	private WebDriver driver;
	String RegistrationApartmentPartialXpath="//h2[.='Apartment Room']/..//div/input[@id='%s']";
	
	private WebElement convertToElement(String partialXpath,String replaceData) {
		String xPath=String.format(partialXpath,replaceData);
		return driver.findElement(By.xpath(xPath));
	}
	public ApartmentRegistration(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void setDataIntoTextFeild(Map<String,String>registerInformation) {
		addMoreBtn.click();
		for(Entry<String, String> KeyValue:registerInformation.entrySet()){
			convertToElement(RegistrationApartmentPartialXpath,KeyValue.getKey()).sendKeys(KeyValue.getValue());
			
		}
	
		
		
		apartmentRegistrationBtn.click();
		
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='apartment_name']")
	private WebElement AptNameTxtFeild;
	@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='mobile']")
	private WebElement mobileTxtFeild;
	@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='alternat_mobile']")
	private WebElement AltmobileTxtFeild;
	@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='email']")
	private WebElement emailTxtFeild;
	@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='plot_number']")
	private WebElement PlotNumTxtFeild;
	@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='country']")
	private WebElement CountryTxtFeild;
	@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='state']")
	private WebElement StateTxtFeild;
	@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='city']")
	private WebElement CityTxtFeild;
	@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='landmark']")
	private WebElement LandMarkTxtFeild;
	@FindBy(xpath="//h2[.='Apartment Room']/..//div/input[@id='address']")
	private WebElement AddTxtFeild;
	
	

}*/
