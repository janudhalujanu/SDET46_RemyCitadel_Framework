package com.RealCitadel.genericFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.RealCitadel.EnumFiles.PropertyKeyData;
import com.mysql.cj.conf.PropertyKey;
//dont start with class interview we need to create one method and wrapp

public class PropertyUtility {
	private Properties prop;
	/**
	 * this constructor will initialize property file
	 * @throws IOException 
	 * @
	 */
	public PropertyUtility(String filepath) throws IOException {
		
		FileInputStream fisProperty=new FileInputStream(filepath);
		prop=new Properties();
		prop.load(fisProperty);
		fisProperty.close();
		
		
		
	}
	public PropertyUtility() {}
	/**
	 * this method is used initialize Property file
	 * @deprecated new PropertyUtility(String filepath)
	 * @param filePath
	 * @throws IOException
	 */
		
		@Deprecated
		public void initializePropertyFile(String filePath) throws IOException {
			FileInputStream fisProperty=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fisProperty);
			fisProperty.close();
		
		}
		/***
		 * this method is used to fetch the data from Proprty file based on key
		 * @param url
		 * @return
		 */
		
	

	public  String getPropertyData(PropertyKeyData key) {
		String KeyString = key.name().toLowerCase();
		String value=prop.getProperty(KeyString, KeyString);
		return value;
		
	}
}


