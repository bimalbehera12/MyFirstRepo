package com.vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer{
	int num=1, upperLimit = 3;
	@Override
	public boolean retry(ITestResult result) {
		
		System.out.println("Executing retry analyzer for "+num+ "time");
		
		if(num<=upperLimit) {
			num++;
			return true;
		}
		return false;
	}

	
}
