package com.RealCitadel.EnumFiles;

public enum ExcelSheet {
	
	
	SHEET1("Sheet1");
	String Key;
	private ExcelSheet(String key) {
		this.Key=key;
		
	}
	/**
	 * 
	 * @return
	 */
	public String getSheetName()
	{
		return Key;


	}
}

	
	
	
