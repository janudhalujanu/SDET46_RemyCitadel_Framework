package com.Admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RealCitadel.EnumFiles.ExcelSheet;
import com.RealCitadel.EnumFiles.PropertyKeyData;
import com.RealCitadel.genericFile.BaseClassUtility;
import com.RealCitadel.genericFile.ExcelUtility;
import com.RealCitadel.genericFile.FrameWorkConstants;
import com.RealCitadel.genericFile.JavaUtility;
import com.RealCitadel.genericFile.PropertyUtility;
import com.RealCitadel.genericFile.Verificationutility;
import com.RealCitadel.genericLib.WebAction.InteractionUtility;
import com.RealCitadel.genericLib.WebAction.SeleniumUtility;
import com.RealCitadel.genericLib.WebAction.WaitUtility;
import com.RealCitadel.objectRepository.ApartmentRegistration;
import com.RealCitadel.objectRepository.LoginPage;
import com.RealCitadel.objectRepository.RegistrationLinkPage;
import com.generic.Base.Annotation.Report;


public class LoginAdmin_RegisterApartmentAndSearch_details extends BaseClassUtility{
	@Report(author = "jyothi")
	@Test

	public void test1() {
	
		//test data

		String sheetName = ExcelSheet.SHEET1.getSheetName();
		String expModuleName = "AdminTest";
		String expTestCaseName = "Apartment Registration";
        Map<String,String> map=excelUtils.getData(sheetName,expModuleName,expTestCaseName);
		System.out.println(map);
		String expApartmentName=map.get("apartment_name");//+""+javaUtility.getRandomNumber(100);
		
		Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");
		//admin Login
		homePageLinks.loginLinkClick();
		login.LoginAction(username, password);
		Assert.assertEquals(adminDsbLinks.adminPageVerification(), "MAHANTESH KUMBAR (ADMIN)");
		
	
		//admin register apartment
		
		homePageLinks.registerLinkClick();
		registrationLinkPage.apartmentRegistrationClick();
		apartmentRegistration.setDataIntoTextFeild(map);
		Assert.assertEquals(adminDsbLinks.successMessage(), "Registration successfull. Thank you");
		
		adminDsbLinks.logoutClick();
		Assert.assertEquals(homePageLinks.homePageVerification(),"Welcome To Room Rental Registration!");
	
		 //search and verify
		 homePageLinks.searchClick();
		 searchPage.SearchPageAction(map.get("rooms"),map.get("city"));
		 searchPage.searchClick();
		 Assert.assertEquals(searchPage.apartmentNameVerification(),expApartmentName);
       
		
		 homePageLinks.searchClick();
		 searchPage.SearchPageAction(map.get("rooms"),map.get("city"));
		 searchPage.searchClick();
		 Assert.assertEquals(searchPage.apartmentNameVerification(),expApartmentName);
		
		 
	
	}
}





//driver.findElement(By.xpath("//h2[.='Apartment Room']/../form/div[6]/following-sibling::button")).click();
		//WebElement message = driver.findElement(By.xpath("(//div[.='Registration successfull. Thank you'])[1]"));
		//System.out.println("print Message :"+message.getText());	
		
		//driver.findElement(By.xpath("//a[.='Logout']")).click();
  	//String homePage1 = driver.getCurrentUrl();
		//if(homePage1.equals("http://rmgtestingserver/domain/House_Rental_Application/index.php"))
		//{
		//	System.out.println("homePage is Displayed after logout");
		//}
	
		//driver.findElement(By.xpath("//a[.='Logout']")).click();
		//verify and search
		
		//driver.findElement(By.xpath("//a[.='Search']")).click();
//LoginPage login=new LoginPage(driver);
//ApartmentRegistration apartmentRegistration=new ApartmentRegistration (driver);
/*driver.findElement(By.xpath("//input[@id='keywords']")).sendKeys(map.get("rooms"));
driver.findElement(By.xpath("//input[@id='location']")).sendKeys(map.get("city"));*/
 
//driver.findElement(By.xpath("//button[@name='search']")).click();
 
// Assert.assertEquals(searchPage.apartmentNameVerification(),"List of Apartment Details");
/*List<WebElement> info = driver.findElements(By.xpath("//h4[.='Room Details']/following-sibling::div[1]/p"));
String actualApartmetName = "";
for(WebElement ele2:info) {
	actualApartmetName = ele2.getText().replaceAll("Apartment Name: ","");
	
	}
Assert.assertEquals(actualApartmetName, actualApartmetName,"testcase is pass");*/

//verificationUtility.partialVerification(actualApartmetName, actualApartmetName);

// seleniumUtility.closeBrowser();

//String sheetName="Project";




	//SCRIPT


/*JavaUtility javaUtility=new JavaUtility();
SeleniumUtility seleniumUtility=new SeleniumUtility();
Verificationutility verificationUtility=new Verificationutility();
WaitUtility waitUtility=new WaitUtility();
InteractionUtility interactionUtility=new InteractionUtility();


PropertyUtility propertyUtils=new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILE_PATH);
ExcelUtility excelUtils=new ExcelUtility(FrameWorkConstants.TEST_EXCEL_FILE_PATH);

//common data

String browser = propertyUtils.getPropertyData(PropertyKeyData.BROWSER);

String url = propertyUtils.getPropertyData(PropertyKeyData.URL);
System.out.println(url);
String username = propertyUtils.getPropertyData(PropertyKeyData.USERNAME);
String password = propertyUtils.getPropertyData(PropertyKeyData.PASSWORD);
 String timeout=
//test data

String sheetName = ExcelSheet.SHEET1.getSheetName();
String expModuleName = "AdminTest";
String expTestCaseName = "Apartment Registration";
Map<String,String> map=excelUtils.getData(sheetName,expModuleName,expTestCaseName);
System.out.println(map);
String expApartmentName=map.get("apartment_name")+""+javaUtility.getRandomNumber(100);


WebDriver driver=seleniumUtility.launchBrowser(browser);
seleniumUtility.maximizeBrowser();

waitUtility.waitForElementLoad(driver, timeout);
seleniumUtility.launchApplication(url);
LoginPage login=new LoginPage(driver);
ApartmentRegistration apartmentRegistration=new ApartmentRegistration (driver);


//String sheetName="Project";
//admin Login

driver.findElement(By.xpath("//a[text()='Login']")).click();
login.LoginAction(username, password);
/*driver.findElement(By.id("exampleInputEmail1")).sendKeys(username);
driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
driver.findElement(By.xpath("//button[text()='Submit']")).click();*/

//admin register apartment
/*sssssss driver.findElement(By.xpath("//a[text()='Register']")).click();

driver.findElement(By.xpath("//a[text()='Apartment Registration']")).click();
apartmentRegistration.setDataIntoTextFeild(map); sssssssssssss


/*driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='apartment_name']")).sendKeys(expApartmentName);
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='mobile']")).sendKeys(map.get("Mobile"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='alternat_mobile']")).sendKeys(map.get("Alternat Mobile"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='email']")).sendKeys(map.get("Email"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='plot_number']")).sendKeys(map.get("Plot Number/Home Number"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='country']")).sendKeys(map.get("Country"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='state']")).sendKeys(map.get("State"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='city']")).sendKeys(map.get("City"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='landmark']")).sendKeys(map.get("Landmark"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='address']")).sendKeys(map.get("Address"));
WebElement image = driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='image']"));
image.sendKeys("C:\\\\Users\\\\HP\\\\Desktop\\\\Web technology\\\\image\\\\shiva-1594171271.jpg");*/

/*	driver.findElement(By.xpath("//a[text()='Add More(Plat Number/Description)']")).click();
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='fullname']")).sendKeys(map.get("Fullname"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='ap_number_of_plats']")).sendKeys(map.get("Flat number"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='rooms']")).sendKeys(map.get("Room"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='area']")).sendKeys(map.get("Area"));*/
//Select class
/*WebElement ele = driver.findElement(By.id("floor"));
Select s=new Select(ele);
s.selectByValue("1st");
WebElement mj = driver.findElement(By.id("ownership"));
Select s1=new Select(mj);
s1.selectByValue("owner");*/

//scrip impliment

/*driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='rent']")).sendKeys(map.get("Rent"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='deposit']")).sendKeys(map.get("Deposit"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='accommodation']")).sendKeys(map.get("Accomodation"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='description']")).sendKeys(map.get("Description"));*/

//select class

/*WebElement sw = driver.findElement(By.xpath(""));
Select s3=new Select(sw);
s3.selectByValue("1");*/

/*driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div/input[@id='description']"));
driver.findElement(By.xpath("//h2[.='Apartment Room']/../form/div[6]/following-sibling::button")).click();*/
/*sssss  WebElement message = driver.findElement(By.xpath("(//div[.='Registration successfull. Thank you'])[1]"));
System.out.println("print Message :"+message.getText());	
driver.findElement(By.xpath("//a[.='Logout']")).click();
String homePage1 = driver.getCurrentUrl();
if(homePage1.equals("http://rmgtestingserver/domain/House_Rental_Application/index.php"))
{
	System.out.println("homePage is Displayed after logout");
}

//driver.findElement(By.xpath("//a[.='Logout']")).click();
//verify and search

driver.findElement(By.xpath("//a[.='Search']")).click();
driver.findElement(By.xpath("//input[@id='keywords']")).sendKeys(map.get("rooms"));
driver.findElement(By.xpath("//input[@id='location']")).sendKeys(map.get("city"));
driver.findElement(By.xpath("//button[@name='search']")).click();
List<WebElement> info = driver.findElements(By.xpath("//h4[.='Room Details']/following-sibling::div[1]"));
String actualApartmetName = "";
for(WebElement ele2:info) {
	actualApartmetName = ele2.getText();
	
	}


verificationUtility.partialVerification(actualApartmetName, actualApartmetName);
seleniumUtility.closeBrowser();
}
}*/
//excel property file
/*	FileInputStream fis=new FileInputStream("./src/test/resources/Data/EastCapeDataPush.xlsx");
DataFormatter df=new DataFormatter();
Workbook wb=WorkbookFactory.create(fis);
Sheet sheet = wb.getSheet("SamplePro");
int rowCount = sheet.getLastRowNum();
Map<String,String> map=new HashMap<String,String>();
for(int i=1;i<=rowCount;i++) {

	String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
	if(testScriptName.equalsIgnoreCase(expctestScriptName)) {

		for(int j=1;j<sheet.getRow(i).getLastCellNum();j++) {
			String key = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			String value = df.formatCellValue(sheet.getRow(i+2).getCell(j));
			map.put(key,value);

		}
		break;
	}

}
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
//driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//verify property data

FileInputStream fis1=new FileInputStream("./src/test/resources/Data/commondata1.propety");
Properties p=new Properties();//properties is class
//step3==>here loading all the keys
p.load(fis1);
//step4==>fetch data
String Url = p.getProperty("url");
String un = p.getProperty("username");//getproperty is method//trim() is remove the spaces
String pwd = p.getProperty("password");

//System.out.println(username);

//step 5 close the stream

fis1.close();
//p.clear();
driver.get(Url);*/




