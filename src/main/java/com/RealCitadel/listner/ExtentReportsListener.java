package com.RealCitadel.listner;


import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.RealCitadel.EnumFiles.PropertyKeyData;
import com.RealCitadel.Reporter.ReporterUtility;
import com.RealCitadel.genericFile.BaseClassUtility;
import com.RealCitadel.genericFile.FrameWorkConstants;
import com.RealCitadel.genericFile.JavaUtility;
import com.RealCitadel.genericFile.PropertyUtility;
import com.RealCitadel.genericFile.UtilityInstanceTransfor;
import com.generic.Base.Annotation.Report;

public class ExtentReportsListener implements ITestListener,ISuiteListener{
	private ReporterUtility report;
	public static ReporterUtility sreporter;

	@Override
	public void onStart(ITestContext context) {

		System.out.println("OnStart ---> Test");
		PropertyUtility propUtil = null;
		try {
			propUtil = new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		report = new ReporterUtility();
		String overrideOrNot=propUtil.getPropertyData(PropertyKeyData.OVERRIDERREPORT);
		String randomName="";
		if(overrideOrNot.equalsIgnoreCase("no"))
			randomName="-"+new JavaUtility().getCurrentDate();
		report.init(randomName,propUtil.getPropertyData(PropertyKeyData.EXTENTREPORTTITLE),propUtil.getPropertyData(PropertyKeyData.EXTENTREPORTNAME),propUtil.getPropertyData(PropertyKeyData.BROWSER));
	 		}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		report.addAuthor(UtilityInstanceTransfor.getExtentTest(), reportAnnotation.author());
		report.addCategory(UtilityInstanceTransfor.getExtentTest(), reportAnnotation.category());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		report.pass(UtilityInstanceTransfor.getExtentTest(),result.getMethod().getMethodName() + "PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		report.fail(UtilityInstanceTransfor.getExtentTest(),result.getMethod().getMethodName() + "FAIL");
		report.fail(UtilityInstanceTransfor.getExtentTest(),result.getThrowable());
		String screenshotPath = BaseClassUtility.class.cast(result.getMethod().getInstance()).screenshotUtility.getScreenshot();
		report.attachScreenshot(UtilityInstanceTransfor.getExtentTest(),screenshotPath, result.getMethod().getMethodName(), "base64");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		report.skip(UtilityInstanceTransfor.getExtentTest(),result.getMethod().getMethodName() + "SKIPPED",result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.saveReport();
	}

}



