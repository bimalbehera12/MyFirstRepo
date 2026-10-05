package com.vtiger.GenericUtility;

import java.time.LocalDateTime;	
import java.util.Random;
import java.util.UUID;
/**
 * This Class is used to Java store all required java methods
 * @author Bimalendu
 */
public class JavaUtility {
//TimeStamp
	/**
	 * This method is used to capture Local date and time of the system.
	 * @return String
	 */
	public String timeStamp() {
	return	LocalDateTime.now().toString().replaceAll(":", "_");
	}
	
//GenerateRandomNumber
	/**
	 * This method is used to generate random number.
	 * @return int
	 */
	public int generateRandomNumber() {
		Random random = new Random();
		int randomValue = random.nextInt(1000);
		return randomValue;
	}

//Generate random Data (Can be used to generate booking ID	)
	/**
	 * This method is used to random String data
	 * @return String
	 */
	public String generateRandomData() {
		String data = UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "");
		return data;
	}
	
//
	
}
