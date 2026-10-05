package com.vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.vtiger.businessUtility.BaseClass;

public class ListenerUtility /* extends ExtentReports */ implements ITestListener, ISuiteListener {
	ExtentTest test;
	ExtentReports reports;
	ExtentSparkReporter spark;
	String time = LocalDateTime.now().toString().replaceAll(":", "_");

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("onStart Executed - STARTED", true);

		// create object for ExtentSparkReporter class
		spark = new ExtentSparkReporter("./reports/report_" + suite.getName() + "_" + time + ".html");

		// create object for ExtentReports class
		reports = new ExtentReports();

		// call attachReporter() and pass spark reference
		reports.attachReporter(spark);

		//call createTest() and store it
		test = reports.createTest(suite.getName() + "_" + time);
	}
//	@Override
//	public void onStart(ISuite suite) {
//	    Reporter.log("onStart Executed - STARTED", true);
//
//	    spark = new ExtentSparkReporter(
//	        "./reports/report_" + suite.getName() + "_" + time + ".html");
//
//	    reports = new ExtentReports();
//	    reports.attachReporter(spark);
//	}
	
//	@Override
//	public void onTestStart(ITestResult result) {
//	    test = reports.createTest(result.getMethod().getMethodName());
//	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("onFinish Executed - COMPLETED", true);

		// save the report
		reports.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("onTestSuccess Executed - PASSED", true);
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("onTestFailure Executed - FAILED", true);

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorshots/img_" + result.getMethod().getMethodName() + "_" + time + ".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getMethod().getMethodName());
	//	test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64),result.getMethod().getMethodName());

	}
	
//	@Override
//	public void onTestFailure(ITestResult result) {
//
//	    Reporter.log("onTestFailure Executed - FAILED", true);
//
//	    if (test == null) {
//	        test = reports.createTest(result.getMethod().getMethodName());
//	    }
//
//	    test.log(Status.FAIL, result.getMethod().getMethodName());
//
//	    TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
//
//	    try {
//	        test.addScreenCaptureFromBase64String(
//	            ts.getScreenshotAs(OutputType.BASE64),
//	            result.getMethod().getMethodName()
//	        );
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}


	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("onTestSkipped Executed - SKIPPED", true);
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}

}