package com.RealCitadel.Reporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.RealCitadel.genericFile.FrameWorkConstants;
import com.RealCitadel.genericFile.UtilityInstanceTransfor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReporterUtility {
	private ExtentReports report;
	private ExtentTest test;
	private String extentReportPath;
	

	public void init(String filePath, String title, String reportname, String browserName) {
		extentReportPath=" FrameWorkConstants.EXTENT_REPORT_PATH+\"extentReport\"+filePath+\".html\"";
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportPath);
		spark.config().setDocumentTitle(title);
		spark.config().setReportName(reportname);
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", browserName);
		report.setSystemInfo("OS", System.getProperty("os.name"));

	}

	public void createTest( String testName) {
		 ExtentTest test=report.createTest(testName);
		 UtilityInstanceTransfor.setExtentTest(test);
		
	}

	public void pass(ExtentTest test,String message) {
		test.pass(message);
		System.out.println(message);
	}

	public void fail(ExtentTest test,String message) {
		test.fail(message);
		System.out.println(message);
	}

	public void fail(ExtentTest test,Throwable errorMessage) {
		test.fail(errorMessage);
		System.out.println(errorMessage);
	}

	public void warn(String message) {
		test.warning(message);
		System.out.println(message);
	}

	

	public void skip( ExtentTest test,String message,Throwable errormessage) {
		test.skip(message);
		test.skip(errormessage);
		System.out.println(message);
	}

	public void info(ExtentTest test,String message) {
		test.info(message);
		System.out.println(message);
	}

	public void addAuthor( ExtentTest test ,String... names) {
		test.assignAuthor(names);
	}

	public void addCategory( ExtentTest test ,String... names) {
		test.assignCategory(names);
	}

	public void attachScreenshot(ExtentTest test,String screenshotPath, String title, String strategy) {

		if (strategy.equalsIgnoreCase("base64"))
			test.addScreenCaptureFromBase64String(screenshotPath, title);
		else
			test.addScreenCaptureFromPath(screenshotPath, title);
	}

	public void saveReport() {
		report.flush();
		try {
		Desktop.getDesktop().browse(new File(extentReportPath).toURI());
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
}


