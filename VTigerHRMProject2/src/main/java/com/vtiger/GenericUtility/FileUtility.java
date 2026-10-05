package com.vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This Class is used to fetch Test Data from External resource file.
 * @author Bimalendu
 */
public class FileUtility {
/**
 * This method is used to fetch test data from properties.file
 * @param key
 * @return
 * @throws IOException
 */
	public String readDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties"); //fetching the file
		Properties prop = new Properties(); //create object for file type class(Properties)
		prop.load(fis); //load the data to test-script
		String value = prop.getProperty(key);
		return value; 
	}
}


