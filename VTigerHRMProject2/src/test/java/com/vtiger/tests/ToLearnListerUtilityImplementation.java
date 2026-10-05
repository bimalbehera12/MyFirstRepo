package com.vtiger.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.businessUtility.BaseClass;

@Listeners(com.vtiger.GenericUtility.ListenerUtility.class)
public class ToLearnListerUtilityImplementation extends BaseClass{
	@Test
	public void toLearnListerUtilityImplementation() {
		Reporter.log("Test Case Line 1 executed", true);
		Reporter.log("Test Case Line 2 executed", true);
		Reporter.log("Test Case Line 3 executed", true);
		Assert.assertEquals("abc", "avc");
		Reporter.log("Test Case Line 4 executed", true);
		Reporter.log("Test Case Line 5 executed", true);
		
	}
}
