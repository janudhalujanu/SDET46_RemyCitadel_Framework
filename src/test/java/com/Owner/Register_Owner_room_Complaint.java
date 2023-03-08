package com.Owner;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.RealCitadel.EnumFiles.ExcelSheet;
import com.RealCitadel.genericFile.BaseClassUtility;

public class Register_Owner_room_Complaint extends BaseClassUtility {
	public void testScript4() {

		String sheetName = ExcelSheet.SHEET1.getSheetName();
		String expModuleName = "OwnerTest";
		String expTestCaseName = "RegisterNewOwner";
		
        Map<String,String> map=excelUtils.getData(sheetName,expModuleName,expTestCaseName);
		System.out.println(map);
		String expTestCaseName1="IndividualHomeRegistration";
		Map<String,String>map1=excelUtils.getData(sheetName,expModuleName,expTestCaseName);
		System.out.println(map1);
		String expSale=map.get("cmp");//+javaUtility.getRandomNumber(100);
		String homePage=driver.getCurrentUrl();
		if(homePage.equalsIgnoreCase("http://rmgtestingserver/domain/House_Rental_Application/"));
		{
			System.out.println("home page is displayed");
		}
		//owner Registration
		driver.findElement(By.xpath("//a[.=Register']")).click();
		ownerReg.RegisterAction(map);
		WebElement message = driver.findElement(By.xpath(""));
		System.out.println("message: "+message.getText());
		//admin Login
		
		
	}

}
