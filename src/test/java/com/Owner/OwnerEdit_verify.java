package com.Owner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class OwnerEdit_verify extends BaseClassUtility {
	@Test

	public void testScript3() throws IOException {
		
		
		
		//test data

		String sheetName = ExcelSheet.SHEET1.getSheetName();
		String expModuleName = "OwnerTest";
		String expTestCaseName = "RegisterNewOwner";
        Map<String,String> map=excelUtils.getData(sheetName,expModuleName,expTestCaseName);
		System.out.println(map);

	
		String expSale=map.get("sale");//+javaUtility.getRandomNumber(100);
		
		String homePage=driver.getCurrentUrl();
		if(homePage.equals("http://rmgtestingserver/domain/House_Rental_Application/"))
		{
			System.out.println("home page is displayed");
		}
		
	//Owner Login
				driver.findElement(By.xpath("//a[text()='Login']")).click();
				String loginPage = driver.getCurrentUrl();
				if(loginPage.equals("http://rmgtestingserver/domain/House_Rental_Application/auth/login.php"));
				
				{
					System.out.println("login page is displayed");
				}
				driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(map.get("User Name"));
				driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(map.get("Password"));
				driver.findElement(By.xpath("//button[text()='Submit']")).click();
				String ownerPage = driver.getCurrentUrl();
				if(ownerPage.equals("http://rmgtestingserver/domain/House_Rental_Application/auth/dashboard.php"))
				{
					System.out.println("ownerPage is displayed");
				}
				//owner Updated
				driver.findElement(By.xpath("//a[.='Details/Update']")).click();
				driver.findElement(By.xpath("//a[.='Edit']")).click();
				driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='sale']")).clear();
				driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='sale']")).sendKeys(expSale);
				driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='accommodation']")).clear();
				driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='description']")).clear();
				driver.findElement(By.xpath("//h2[.='Register Room']/..//div/input[@id='accommodation']")).sendKeys(map.get("accommodation"));
				driver.findElement(By.xpath("h2[.='Register Room']/..//div/input[@id='description']")).sendKeys(map.get("description"));
				//driver.findElement(By.xpath("//input[@type='other']")).sendKeys(map.get("Other"));
				/*WebElement ele = driver.findElement(By.xpath("//select[@id='vacant']"));
				Select s=new Select(ele);
				s.selectByValue("0");*/
				driver.findElement(By.xpath("//button[text()='Submit']")).click();
				driver.findElement(By.xpath("//a[.='Logout']")).click();
				String homePage2 = driver.getCurrentUrl();
				if(homePage2.equals("http://rmgtestingserver/domain/House_Rental_Application/index.php"))
				{
					System.out.println("home page is displayed after owner logout");
				}
				//Admin Login
				driver.findElement(By.xpath("//a[text()='Login']")).click();
				//admin Login
				login.LoginAction(username, password);
				String adminPage = driver.getCurrentUrl();
				if(adminPage.equals("http://rmgtestingserver/domain/House_Rental_Application/auth/dashboard.php"))
				{
					System.out.println("admin page is displayed");
				}
				/*driver.findElement(By.id("exampleInputEmail1")).sendKeys(username);
				driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);*/
				//driver.findElement(By.xpath("//button[text()='Submit']")).click();
				
				driver.findElement(By.xpath("//a[text()='Details/Update']")).click();
				String detailsPage = driver.getCurrentUrl();
				//Verify
				List<WebElement> list = driver.findElements(By.xpath("//h4[.='Room Details']/..//p[2]//b[.='Sale: ']/../..//p[2]"));
				String actualSale = "";
				for(WebElement ele1:list) 
				{
					actualSale=ele1.getText().replaceAll("Sale: ","");
				}
				//verificationUtility.partialVerification(actualSale, actualSale);
				Assert.assertEquals(actualSale, expSale,"testcase pass");
				driver.findElement(By.xpath("//a[.='Logout']")).click();
				//seleniumUtility.closeBrowser();
				
					}
					

				
				

	}

	
//excel data
/*/*WebDriverManager.chromedriver().setup();
		 
		WebDriver driver=new ChromeDriver();
		String expctestScriptName = "AdminTest";
		//String sheetName="Project";


		FileInputStream fis=new FileInputStream("./src/test/resources/Data/EastCapeDataPush.xlsx");
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
				//driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//Property verify

				FileInputStream fis1=new FileInputStream("./src/test/resources/Data/commondata1.propety");
				Properties p=new Properties();
				
				p.load(fis1);
	
			 String url = p.getProperty("url");
				String username = p.getProperty("username");//getproperty is method//trim() is remove the spaces
				String password= p.getProperty("password");

				

			

				fis1.close();*/
