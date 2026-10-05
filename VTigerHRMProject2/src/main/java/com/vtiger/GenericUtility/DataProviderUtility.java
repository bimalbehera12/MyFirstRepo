package com.vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {


	@DataProvider
	public Object[][] dataprovider() throws EncryptedDocumentException, IOException {
		//FIRST APPROACH (Using String)
//		String data[][] = {{"admin1","admin@1"},
//				{"admin2","admin@2"},
//				{"admin3","admin@3"}};
//		return data;
		
		//SECOND APPROACH (Using Object array)
//		Object[][] objarr = new Object[3][2];
//		
//		objarr[0][0] = "admin1";
//		objarr[0][1] = "admin@1";
//		objarr[1][0] = "admin2";
//		objarr[1][1] = "admin@2";
//		objarr[2][0] = "admin3";
//		objarr[2][1] = "admin@3";
//		
//		return objarr;
		
//		THIRD APPROACH
		FileInputStream fis = new FileInputStream("./src/test/resources/dataprovidertestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		
		Object[][] objarr = new Object[lastRowNum][lastCellNum];
		
		for (int i = 1; i <= lastRowNum; i++) {

			for (int j = 0; j < lastCellNum; j++) {

				objarr[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			 
		}
		return objarr;
		
		
	}
}
