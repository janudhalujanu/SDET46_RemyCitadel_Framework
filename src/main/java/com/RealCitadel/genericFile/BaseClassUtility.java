package com.RealCitadel.genericFile;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.RealCitadel.EnumFiles.PropertyKeyData;
import com.RealCitadel.genericLib.WebAction.InteractionUtility;
import com.RealCitadel.genericLib.WebAction.SeleniumUtility;
import com.RealCitadel.genericLib.WebAction.WaitUtility;
import com.RealCitadel.objectRepository.AdminDashboardLinks;
import com.RealCitadel.objectRepository.ApartmentRegistration;
import com.RealCitadel.objectRepository.HomePageLinks;
import com.RealCitadel.objectRepository.HomeRegistrationPage;
import com.RealCitadel.objectRepository.ListOfApartment;
import com.RealCitadel.objectRepository.LoginPage;
import com.RealCitadel.objectRepository.OwnerRegistrationPage;
import com.RealCitadel.objectRepository.RegistrationLinkPage;
import com.RealCitadel.objectRepository.SearchPage;
import org.testng.annotations.Parameters;
import com.generic.Base.BaseClassDeclaration;

public class BaseClassUtility extends BaseClassDeclaration {
	
	
	
	@BeforeClass(alwaysRun=true)
	public void initializeSetUp()  {
		javaUtility=new JavaUtility();
		seleniumUtility=new SeleniumUtility();
	 waitUtility=new WaitUtility();
	 verificationUtility = new Verificationutility();
		
		try {
			excelUtils=new ExcelUtility(FrameWorkConstants.TEST_EXCEL_FILE_PATH);
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			propertyUtils=new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILE_PATH);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//common data
		
		browser=propertyUtils.getPropertyData(PropertyKeyData.BROWSER);
		
		url =propertyUtils.getPropertyData(PropertyKeyData.URL);
	                               
		username =javaUtility.decode(propertyUtils.getPropertyData(PropertyKeyData.USERNAME));
		password = javaUtility.decode(propertyUtils.getPropertyData(PropertyKeyData.PASSWORD));
		 timeout = Long.parseLong(propertyUtils.getPropertyData(PropertyKeyData.TIMEOUT));
	}
	@Parameters(value="browser")
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetUp(@Optional String browser) throws IOException {
		//navigating the app
		if(browser==null)
		{
			this.browser=propertyUtils.getPropertyData(PropertyKeyData.BROWSER);
			//browser=System.getProperty("url");
			
		}
		else {
			this.browser=browser;
		}
		  driver=seleniumUtility.launchBrowser(this.browser);
			seleniumUtility.maximizeBrowser();
			waitUtility.waitForElementLoad(driver, timeout);
			screenshotUtility=new ScreenshotUtility(driver);
		
		seleniumUtility.launchApplication(url);
		
		//pom class
		login=new LoginPage(driver);
		homeRegister=new HomeRegistrationPage(driver);
		searchPage=new SearchPage(driver);
		apartmentRegistration=new ApartmentRegistration(driver);
		 ownerReg = new  OwnerRegistrationPage(driver);
		 apartmentList=new ListOfApartment(driver);
		 adminDsbLinks=new AdminDashboardLinks(driver);
		 homePageLinks=new HomePageLinks(driver);
		 registrationLinkPage=new RegistrationLinkPage(driver);
	}
	@AfterMethod
	public void tearDown() throws IOException {
		seleniumUtility.closeBrowser();
	}
	@AfterClass(alwaysRun=true)
	public void initializationTearDown() throws IOException {
		excelUtils.close();
	
	}
	

}
