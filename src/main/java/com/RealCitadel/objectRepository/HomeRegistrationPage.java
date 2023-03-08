package com.RealCitadel.objectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RealCitadel.genericLib.WebAction.DropDownUtility;

public class HomeRegistrationPage {
	private WebDriver  driver;
	@FindBy(xpath="//h2[.='Register Room']/../form/div[6]/following-sibling::button")
	private WebElement roomRegisterBtn;
	@FindBy(xpath="//select[@id='vacant']")
	private WebElement dropdown;
	DropDownUtility dd=new DropDownUtility();
	String visibleTxt="Occupied";
	
	String RegisterRoomPagePartialXpath="//h2[.='Register Room']/..//div/input[@id='%s']";
	
	private WebElement convertToElement(String partialXpath,String replaceData) {
		String xPath=String.format(partialXpath,replaceData);
		return driver.findElement(By.xpath(xPath));
	}
	public HomeRegistrationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void setDataIntoTextFeild(Map<String,String>registerInformation) {
		for(Entry<String, String> KeyValue:registerInformation.entrySet()){
			convertToElement(RegisterRoomPagePartialXpath,KeyValue.getKey()).sendKeys(KeyValue.getValue());
			
		}
		
	}
	
	/*@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='fullname']")
	private WebElement FuNTextFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='mobile']")
	private WebElement MobTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='alternat_mobile']")
	private WebElement AlterMobTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='email']")
	private WebElement EmailTextFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='plot_number']")
	private WebElement PlotNoTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='rooms']")
	private WebElement RoomTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='country']")
	private WebElement CountryTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='state']")
	private WebElement StateTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='city']")
	private WebElement CityTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='rent']")
	private WebElement RentTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='sale']")
	private WebElement SaleTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='deposit']")
	private WebElement DepositTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='accommodation']")
	private WebElement AccomodationTextFeild;
	@FindBy(xpath="h2[.='Register Room']/..//div/input[@id='description']")
	private WebElement DescriptionTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='landmark']")
	private WebElement LandMTxtFeild;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='address']")
	private WebElement AddressTxtFeild;
	@FindBy(id="vacant")
	private WebElement VacantOption;
	@FindBy(xpath="//h2[.='Register Room']/..//div/input[@id='image']")
	private WebElement imageLink;
	@FindBy(xpath="//h2[.='Register Room']/../form/div[6]/following-sibling::button")
	private WebElement RegisterBtn;
	
	public HomeRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void RegistrationAction(Map<String,String>map) {
		FuNTextFeild.sendKeys(map.get(""));
		MobTxtFeild.sendKeys(map.get("Mobile"));
		 AlterMobTxtFeild.sendKeys(map.get("Alternat Mobile"));
		 EmailTextFeild.sendKeys(map.get("Email"));
		 PlotNoTxtFeild.sendKeys(map.get("Plot Number/Home Number"));
		 RoomTxtFeild.sendKeys(map.get("Available Rooms"));
		 CountryTxtFeild.sendKeys(map.get("Country"));
		 StateTxtFeild.sendKeys(map.get("State"));
		 CityTxtFeild.sendKeys(map.get("City"));
		 RentTxtFeild.sendKeys(map.get("Rent"));
		 SaleTxtFeild.sendKeys(map.get("Sale"));
		 DepositTxtFeild.sendKeys(map.get("Deposit"));
		 AccomodationTextFeild.sendKeys(map.get("Facilities"));
		 DescriptionTxtFeild.sendKeys(map.get("Description"));
		 LandMTxtFeild.sendKeys(map.get("Landmark"));
		 AddressTxtFeild.sendKeys(map.get("Address"));
		 VacantOption.sendKeys(map.get("vacant"));
		 imageLink.sendKeys(map.get(""));
		 RegisterBtn.sendKeys(map.get(""));*/
		 
		 
		
	}
	
	
	


