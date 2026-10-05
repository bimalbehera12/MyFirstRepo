package com.vtiger.tests;


import org.testng.Reporter;
import org.testng.annotations.Test;

public class DataProviderClass {

		@Test (dataProvider = "dataprovider")
		public void test(String username, String password) {
			Reporter.log(username,true);
			Reporter.log(password,true);
			System.out.println("--------");
		}
		
}
