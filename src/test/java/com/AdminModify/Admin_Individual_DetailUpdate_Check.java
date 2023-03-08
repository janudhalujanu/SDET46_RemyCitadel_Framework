package com.AdminModify;

import java.util.Map;

import org.openqa.selenium.By;

import com.RealCitadel.EnumFiles.ExcelSheet;
import com.RealCitadel.genericFile.BaseClassUtility;

public class Admin_Individual_DetailUpdate_Check extends BaseClassUtility {
	public void testScript1() {
		String sheetName = ExcelSheet.SHEET1.getSheetName();
		String expModuleName = "AdminTest";
		String expTestCaseName = "IndividualHomeRegistration";
		Map<String,String> map=excelUtils.getData(sheetName,expModuleName,expTestCaseName);
		System.out.println(map);
		String expFullName=map.get("fullname");
		//verify login page
		String homePage=driver.getCurrentUrl();
		if(homePage.equals("http://rmgtestingserver/domain/House_Rental_Application/"))
		{
			System.out.println("home page is displayed");
		}
		//admin login

		driver.findElement(By.xpath("//a[text()='Login']")).click();
		login.LoginAction(username, password);

	driver.findElement(By.xpath("//a[text()='Register']")).click();
	homeRegister.setDataIntoTextFeild(map);
	}

}
