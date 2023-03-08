package com.RealCitadel.genericFile;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * @return 
	 * 
	 */
public int getRandomNumber(int boundaryValue) {
	return new Random().nextInt(boundaryValue);
}

/**
 * 
 * @param s
 * @param strategy
 * @return
 */



public String encode(String propertyData)
{
	return new String(Base64.getEncoder().encode(propertyData.getBytes()));
}
 
public String decode(String propertyData)
{
	return new String(Base64.getDecoder().decode(propertyData.getBytes()));
}
public String getCurrentDate() {
	SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss");
	return sdf.format(new Date());
}
public String getCurrentDate(String pattern) {
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	return sdf.format(new Date());
}
public String getCurrentDate(int days) {
	SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, days);
	return sdf.format(cal.getTime());
	
}
public String getCurrentDate(String date,int days) throws ParseException {
	SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");
	Calendar cal=Calendar.getInstance();
	cal.setTime(sdf.parse(date));
	cal.add(Calendar.DAY_OF_MONTH, days);
	return sdf.format(cal.getTime());
	
}

}
