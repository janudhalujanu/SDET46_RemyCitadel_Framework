package com.Admin;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.RealCitadel.EnumFiles.ExcelSheet;
import com.RealCitadel.genericFile.BaseClassUtility;
import com.RealCitadel.objectRepository.AdminDashboardLinks;
import com.generic.Base.Annotation.Report;

public class AdminLogin_Register_Room extends BaseClassUtility {
	@Report(author = "jyothi")
	@Test

	public void test1() {

		// test data
		//Assert.fail();
		String sheetName = ExcelSheet.SHEET1.getSheetName();
		String expModuleName = "AdminTest";
		String expTestCaseName = "IndividualHomeRegistration";
		Map<String, String> map = excelUtils.getData(sheetName, expModuleName, expTestCaseName);
		System.out.println(map);
		String expFullName = map.get("fullname");// +""+javaUtility.getRandomNumber(100);

	
	
		Assert.assertEquals(homePageLinks.homePageVerification(), "Welcome To Room Rental Registration!");
		// Admin Login
		homePageLinks.loginLinkClick();
		login.LoginAction(username, password);
		Assert.assertEquals(adminDsbLinks.adminPageVerification(), "MAHANTESH KUMBAR (ADMIN)");
		
		homePageLinks.registerLinkClick();
		homeRegister.setDataIntoTextFeild(map);
		//Assert.assertEquals(adminDsbLinks.successMessage(), "Registration successfull. Thank you");

	
		
		adminDsbLinks.homeClick();
		adminDsbLinks.roomforRentClick();
		Assert.assertEquals(apartmentList.apartmentpageVerification(), "List of Apartment Details");
		Assert.assertEquals(apartmentList.ownerNameVerification(), expFullName);
		adminDsbLinks.logoutClick();
	
		/*String roomsPage = driver.getCurrentUrl();
		if (roomsPage.equals("http://rmgtestingserver/domain/House_Rental_Application/app/list.php")) {
			System.out.println("registred room is Displyed");
		}
		/*List<WebElement> list = driver.findElements(By.xpath("//h4[.='Owner Details']/../p[1]"));
		String actualFullName = "";
		for (WebElement ele1 : list) {
			actualFullName = ele1.getText().replaceAll("Owner Name: ", "");
		}
		Assert.assertEquals(actualFullName, expFullName, "test case pass");

		// verificationUtility.partialVerification(actualFullName, expFullName);
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		// seleniumUtility.closeBrowser();*/
	}
}
//driver.findElement(By.xpath("//a[text()='Login']")).click();
//driver.findElement(By.xpath("//a[text()='Login']")).click();
//driver.findElement(By.xpath("//a[text()='Register']")).click();
		// driver.findElement(By.xpath("//a[.='Register']")).click();
///WebElement success = driver.findElement(By.xpath("//h2[.='Register Room']/preceding-sibling::div[1]"));
//System.out.println(success.getText());/


//	// WebDriver driver=seleniumUtility.launchBrowser(browser);
// expFullName.maximizeBrowser();
// waitUtility.waitForElement(10);
// seleniumUtility.launchApplication(url);
// LoginPage login=new LoginPage(driver);
// HomeRegistrationPage homeRegister=new HomeRegistrationPage(driver);


//ACTUAL TEST SCRIPT
/*
 * JavaUtility javaUtility=new JavaUtility(); SeleniumUtility
 * seleniumUtility=new SeleniumUtility(); Verificationutility
 * verificationUtility=new Verificationutility(); WaitUtility waitUtility=new
 * WaitUtility(); InteractionUtility interactionUtility=new
 * InteractionUtility();
 * 
 * 
 * PropertyUtility propertyUtils=new
 * PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILE_PATH); ExcelUtility
 * excelUtils=new ExcelUtility(FrameWorkConstants.TEST_EXCEL_FILE_PATH);
 * 
 * //common data
 * 
 * String browser = propertyUtils.getPropertyData(PropertyKeyData.BROWSER);
 * 
 * String url = propertyUtils.getPropertyData(PropertyKeyData.URL);
 * System.out.println(url); String username =
 * propertyUtils.getPropertyData(PropertyKeyData.USERNAME); String password =
 * propertyUtils.getPropertyData(PropertyKeyData.PASSWORD);
 * 
 * //test data
 * 
 * String sheetName = ExcelSheet.SHEET1.getSheetName(); String expModuleName =
 * "AdminTest"; String expTestCaseName = "IndividualHomeRegistration";
 * Map<String,String>
 * map=excelUtils.getData(sheetName,expModuleName,expTestCaseName);
 * System.out.println(map); String
 * expFullName=map.get("Full Name")+""+javaUtility.getRandomNumber(100);
 * 
 * 
 * WebDriver driver=seleniumUtility.launchBrowser(browser);
 * seleniumUtility.maximizeBrowser(); waitUtility.waitForElement(10);
 * seleniumUtility.getURL(url); LoginPage login=new LoginPage(driver);
 * HomeRegistrationPage homeRegister=new HomeRegistrationPage(driver);
 * 
 * 
 * 
 * 
 * 
 * //Admin Login
 * 
 * driver.findElement(By.xpath("//a[text()='Login']")).click();
 * login.LoginAction(username, password);
 * 
 * driver.findElement(By.xpath("//a[text()='Register']")).click();
 * homeRegister.setDataIntoTextFeild(map);
 * 
 * 
 * 
 * //
 * driver.findElement(By.xpath("//a[text()='Individual Home Registration']")).
 * click();
 * 
 * driver.findElement(By.
 * xpath("//h2[.='Register Room']/../form/div[6]/following-sibling::button")).
 * click(); WebElement success = driver.findElement(By.
 * xpath("//h2[.='Register Room']/preceding-sibling::div[1]"));
 * System.out.println(success.getText());
 * driver.findElement(By.xpath("//a[.='Home']")).click();
 * driver.findElement(By.xpath("//b[text()='Rooms for Rent: ']")).click();
 * String roomsPage = driver.getCurrentUrl(); if(roomsPage.equals(
 * "http://rmgtestingserver/domain/House_Rental_Application/app/list.php")) {
 * System.out.println("registred room is Displyed"); } List<WebElement> list =
 * driver.findElements(By.xpath("//h4[.='Owner Details']/../p[1]")); String
 * actualFullName = ""; for(WebElement ele1:list) { actualFullName
 * =ele1.getText(); } verificationUtility.partialVerification(actualFullName,
 * actualFullName); driver.findElement(By.xpath("//a[.='Logout']")).click();
 * seleniumUtility.closeBrowser(); } }
 */ // LAST LINE SCRIPT

//excel and property implimentation

/*
 * FileInputStream fis=new
 * FileInputStream("./src/test/resources/Data/EastCapeDataPush.xlsx");
 * DataFormatter df=new DataFormatter(); Workbook
 * wb=WorkbookFactory.create(fis); Sheet sheet = wb.getSheet("SamplePro"); int
 * rowCount = sheet.getLastRowNum(); Map<String,String> map=new
 * HashMap<String,String>(); for(int i=1;i<=rowCount;i++) {
 * 
 * String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
 * if(testScriptName.equalsIgnoreCase(expctestScriptName)) {
 * 
 * for(int j=1;j<sheet.getRow(i).getLastCellNum();j++) { String key =
 * df.formatCellValue(sheet.getRow(i+1).getCell(j)); String value =
 * df.formatCellValue(sheet.getRow(i+2).getCell(j)); map.put(key,value);
 * 
 * } break; }
 * 
 * } WebDriverManager.chromedriver().setup();
 * 
 * WebDriver driver=new ChromeDriver();
 * //driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * 
 * //verify propery file
 * 
 * FileInputStream fis1=new
 * FileInputStream("./src/test/resources/Data/commondata1.propety"); Properties
 * p=new Properties();//properties is class //step3==>here loading all the keys
 * p.load(fis1); //step4==>fetch data String Url = p.getProperty("url"); String
 * un = p.getProperty("username");//getproperty is method//trim() is remove the
 * spaces String pwd = p.getProperty("password");
 * 
 * //System.out.println(username);
 * 
 * //step 5 close the stream
 * 
 * fis1.close(); //p.clear(); } }
 */

//script of Admin Application
//Admin Login

/*
 * driver.findElement(By.xpath("//a[text()='Login']")).click();
 * login.LoginAction(username, password); //
 * driver.findElement(By.id("exampleInputEmail1")).sendKeys(username); //
 * driver.findElement(By.id("exampleInputPassword1")).sendKeys(password); //
 * driver.findElement(By.xpath("//button[text()='Submit']")).click();
 * driver.findElement(By.xpath("//a[text()='Register']")).click();
 * homeRegister.setDataIntoTextFeild(map);
 * 
 * 
 * 
 * //driver.findElement(By.xpath("//a[text()='Individual Home Registration']")).
 * click(); // //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='fullname']")).sendKeys(
 * expFullName); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='mobile']")).sendKeys(map.
 * get("Mobile")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='alternat_mobile']")).
 * sendKeys(map.get("Alternat Mobile")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='email']")).sendKeys(map.get
 * ("Email")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='plot_number']")).sendKeys(
 * map.get("Plot Number/Home Number")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='rooms']")).sendKeys(map.
 * get("Available Rooms")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='country']")).sendKeys(map.
 * get("Country")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='state']")).sendKeys(map.get
 * ("State")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='city']")).sendKeys(map.get(
 * "City")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='rent']")).sendKeys(map.get(
 * "Rent")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='sale']")).sendKeys(map.get(
 * "Sale")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='deposit']")).sendKeys(map.
 * get("Deposit")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='accommodation']")).sendKeys
 * (map.get("Facilities")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='description']")).sendKeys(
 * map.get("Description")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='landmark']")).sendKeys(map.
 * get("Landmark")); //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='address']")).sendKeys(map.
 * get("Address")); //WebElement Text = driver.findElement(By.id("vacant"));
 * //Select S=new Select(Text);email //S.selectByVisibleText("Vacant");
 * //driver.findElement(By.
 * xpath("//h2[.='Register Room']/..//div/input[@id='image']")).
 * sendKeys("C:\\Users\\HP\\Desktop\\Web technology\\image\\shiva-1594171271.jpg"
 * ); //driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
 * driver.findElement(By.
 * xpath("//h2[.='Register Room']/../form/div[6]/following-sibling::button")).
 * click(); WebElement success = driver.findElement(By.
 * xpath("//h2[.='Register Room']/preceding-sibling::div[1]"));
 * System.out.println(success.getText());
 * driver.findElement(By.xpath("//a[.='Home']")).click();
 * driver.findElement(By.xpath("//b[text()='Rooms for Rent: ']")).click();
 * String roomsPage = driver.getCurrentUrl(); if(roomsPage.equals(
 * "http://rmgtestingserver/domain/House_Rental_Application/app/list.php")) {
 * System.out.println("registred room is Displyed"); } List<WebElement> list =
 * driver.findElements(By.xpath("//h4[.='Owner Details']/../p[1]")); String
 * actualFullName = ""; for(WebElement ele1:list) { actualFullName
 * =ele1.getText(); } verificationUtility.partialVerification(actualFullName,
 * actualFullName); driver.findElement(By.xpath("//a[.='Logout']")).click();
 * seleniumUtility.closeBrowser(); } }
 */
