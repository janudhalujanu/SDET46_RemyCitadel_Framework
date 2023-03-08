package com.RealCitadel.genericFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.swing.text.DateFormatter;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;
/**
 * this 
 * @author jyothi
 *
 */
public class ExcelUtility {
	DataFormatter df;
	Workbook wb;


	public ExcelUtility() {}
	/**
	 * 
	 * @param fileName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public ExcelUtility(String fileName) throws EncryptedDocumentException, IOException {
		initialize(fileName);


	}
	/**
	 * 
	 * @param fileName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */



	private void initialize(String fileName) throws EncryptedDocumentException, IOException {
		df=new DataFormatter();
		FileInputStream fisData=new FileInputStream(fileName);
		wb=WorkbookFactory.create(fisData);
	}
	/**
	 * this 
	 * @param sheetName
	 * @param expModuleName
	 * @param expTestCaseName
	 * @return
	 */
	public Map<String,String> getData(String sheetName,String expModuleName,String expTestCaseName)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Map<String,String>map=new HashedMap<>();
		if(expModuleName.equalsIgnoreCase("AdminTest"))
		{
			for(int i=1;i<=rowCount;i++)
			{
				String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
				if(testScriptName.equalsIgnoreCase(expModuleName))
				{
					String cell = df.formatCellValue(sheet.getRow(i).getCell(1));
					String cell2 = df.formatCellValue(sheet.getRow(i+4).getCell(1));
					if(cell.equalsIgnoreCase(expTestCaseName))
					{
						for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
						{
							String	key=df.formatCellValue(sheet.getRow(i+1).getCell(j));
							String value=df.formatCellValue(sheet.getRow(i+2).getCell(j));
							if(key.equals(""))break;
							map.put(key, value);

						}

					}
					else if(cell2.equalsIgnoreCase(expTestCaseName))
					{
						for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
						{
							String key = df.formatCellValue(sheet.getRow(i+5).getCell(j));
							String value = df.formatCellValue(sheet.getRow(i+6).getCell(j));
							if(key.equals(""))break;
							map.put(key, value);

						}
					}
					else {
						System.out.println("no matching data");
					}
					break;
				}
			}
		}
		else if(expModuleName.equalsIgnoreCase("OwnerTest"))
		{
			for(int i=9;i<rowCount;i++)
			{
				String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
				if(testScriptName.equalsIgnoreCase(expModuleName))
				{


					String cell3 = df.formatCellValue(sheet.getRow(i).getCell(1));
					String cell4 = df.formatCellValue(sheet.getRow(i+8).getCell(1));
					String cell5 = df.formatCellValue(sheet.getRow(i+4).getCell(1));
					String cell6 = df.formatCellValue(sheet.getRow(i+12).getCell(1));
					if(cell3.equalsIgnoreCase(expTestCaseName))
					{
						for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
						{
							String key = df.formatCellValue(sheet.getRow(i+1).getCell(j));
							String value = df.formatCellValue(sheet.getRow(i+2).getCell(j));
							if(key.equals(""))break;
							map.put(key, value);
						}
					}
					else if(cell4.equalsIgnoreCase(expTestCaseName))
					{
						for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
						{
							String key = df.formatCellValue(sheet.getRow(i+9).getCell(j));
							String value = df.formatCellValue(sheet.getRow(i+10).getCell(j));
							if(key.equals(""))break;
							map.put(key, key);
						}
					}
					else if(cell5.equalsIgnoreCase(expTestCaseName))
					{
						for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
						{
							String key = df.formatCellValue(sheet.getRow(i+5).getCell(j));
							String value = df.formatCellValue(sheet.getRow(i+6).getCell(j));
							if(key.equals(""))break;
							map.put(key, key);
						}
					}
					else if(cell6.equalsIgnoreCase(expTestCaseName))
					{
						for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
						{
							String key = df.formatCellValue(sheet.getRow(i+13).getCell(j));
							String value = df.formatCellValue(sheet.getRow(i+14).getCell(j));
							if(key.equals(""))break;
							map.put(key, key);
						}
					}
					else {
						System.out.println("no data matching");
					}
					break;
				}		
			}
		}
		return map;
	}

	public void close() throws IOException {
		wb.close();
	}
}



//	public Map<String, String> getData(String sheetName,String expTestCaseName)
//	{
//		Sheet sheet = wb.getSheet(sheetName);
//		int rowCount=sheet.getLastRowNum();
//		Map<String,String> map=new HashedMap<String,String>();
//		for(int i=1;i<=rowCount;i++) {
//			String	 testScriptName= df.formatCellValue(sheet.getRow(i).getCell(0));
//
//			if(testScriptName.equalsIgnoreCase(expTestCaseName)) {
//
//				for(int j=0;j<sheet.getRow(i).getLastCellNum();j++) {
//					String key = df.formatCellValue(sheet.getRow(i+1).getCell(j));
//					String value = df.formatCellValue(sheet.getRow(i+2).getCell(j));
//					map.put(key,value);
//
//				}
//				break;
//			}
//		}
//		return map;
//
//	}



/*public String getData(String sheetName,String expTestCaseName,String expectedkey){
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		String value="";
		int testScriptCounter=0;
		int keyCounter=0;
		Map<String ,String> map=new HashedMap<>();
		for( int i=0;i<=rowCount;i++) {
			String testScriptName=df.formatCellValue(sheet.getRow(i).getCell(i));
			if(testScriptName.equals(expTestCaseName))
			{
				testScriptCounter++;

				for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
				{
					String key=df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equals(expectedkey))
					{
						keyCounter++;
						value=df.formatCellValue(sheet.getRow(i).getCell(j));
						break;
					}
				}
				break;

			}
		}
		if(keyCounter==0)
		{
			if(testScriptCounter==0)
			{
				value="please give proper testScript key "+expTestCaseName+"'";


			}
			else {
				value="please give proper testScript key '"+expectedkey+"'";
			}
		}
		System.out.println("valuen fetched from excel===>"+value);
		return value;
	}


	public String getData(String sheetName,int rowIndex,int cellIndex)
	{
		String value=df.formatCellValue(wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex));
		return value;
	}
	public void close() throws IOException
	{
		wb.close();
	}
	public void setData(String sheetName,int rowIndex,int cellIndex)
	{
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex);

	}
	public void setData(String fileoutputpath) throws FileNotFoundException, IOException {

		wb.write(new FileOutputStream(fileoutputpath));
	}

}*/
