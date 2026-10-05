package com.vtiger.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.vtiger.businessUtility.BaseClass;

public class ToLearnExtentReports extends BaseClass{

	@Test (retryAnalyzer = com.vtiger.GenericUtility.RetryAnalyzer.class)
	public void test() {
		//create object for ExtentSparkReporter class
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/report.html");
		
		//create object for ExtentReports class
		ExtentReports reports = new ExtentReports();
		
		//call attachReporter() and pass spark reference
		reports.attachReporter(spark);
		
		//call createTest() and store it
		ExtentTest test = reports.createTest("Sample Test Report");
		
		//printing statement
		Reporter.log("Testcase Executed", true);
		Assert.assertEquals("abc", "abc");
		
		//call log() and pass arguments
		test.log(Status.PASS, "Test case Passed");
		test.log(Status.FAIL, "Test case Failed");
		test.log(Status.SKIP, "Test case Skipped");
		
		//save the report
		reports.flush();
	}

}
