package com.RealCitadel.genericFile;

public class Verificationutility {
	public void exactVerification(String actual,String expected) {

		if(actual.equals(expected))
		{
			System.out.println("Pass");
		}
		else 
		{
			System.out.println("Fail");
		}


	}
	public void partialVerification(String actual, String expected) {
		if(actual.contains(expected))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");

		}
	}

	
}


