package com.generic.Base;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.RealCitadel.Reporter.ReporterUtility;
import com.RealCitadel.genericFile.ExcelUtility;
import com.RealCitadel.genericFile.JavaUtility;
import com.RealCitadel.genericFile.PropertyUtility;
import com.RealCitadel.genericFile.ScreenshotUtility;
import com.RealCitadel.genericFile.Verificationutility;
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
import com.aventstack.extentreports.ExtentTest;

public class BaseClassDeclaration {
	protected WebDriver driver;
	protected JavaUtility javaUtility;
	protected SeleniumUtility seleniumUtility;
	protected Verificationutility verificationUtility;
	protected WaitUtility waitUtility;
	protected InteractionUtility interactionUtility;
	protected PropertyUtility propertyUtils;
	protected ExcelUtility excelUtils;
	protected String browser;
	protected String url;
	protected String username;
	protected String password ;
	protected String sheetName ;
	protected String expModuleName ;
	protected String expTestCaseName;
	protected Map<String,String> map;
	protected LoginPage login;
	protected HomeRegistrationPage homeRegister;
	protected ApartmentRegistration apartmentRegistration;
	protected SearchPage searchPage;
	protected long timeout;
	protected OwnerRegistrationPage ownerReg;
	public ScreenshotUtility screenshotUtility;
	protected HomePageLinks homePageLinks;
	protected AdminDashboardLinks adminDsbLinks;
	protected  ListOfApartment apartmentList;
	protected ReporterUtility reporterUtility;
	public ExtentTest test;
	protected RegistrationLinkPage registrationLinkPage;
	
	
}
