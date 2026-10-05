package com.vtiger.contacts;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.businessUtility.BaseClass;
import com.vtiger.objectRepository.CreateNewContact;
import com.vtiger.objectRepository.HomePage;
@Listeners(com.vtiger.GenericUtility.ListenerUtility.class)
public class TC001_VerifyUserIsAbleToCreateANewContactWithMandatoryFields extends BaseClass{

	@Test
	public void tC001_VerifyUserIsAbleToCreateANewContactWithMandatoryFields() throws InterruptedException, IOException {
		
//		FileUtility fileUtil = new FileUtility();
//		WebDriverUtility webUtil = new WebDriverUtility();
//		String URL = fileUtil.readDataFromPropertiesFile("url");//
//		String USERNAME = fileUtil.readDataFromPropertiesFile("username");
//		String PASSWORD = fileUtil.readDataFromPropertiesFile("password");
//		
//		WebDriver driver = new ChromeDriver();
//		webUtil.toMaximize(driver);
//		webUtil.toImplicitlyWait(driver);
//		String TIMESTAMP  = javaUtil.timeStamp();
//		driver.get(URL);
//		//Login
//		LoginPage login = new LoginPage(driver);
//		login.login(USERNAME, PASSWORD);
		//navigate to contacts
		homePage = new HomePage(driver);
		homePage.createANewContact();
//		homePage.getMoreButton().click();
//		homePage.getContactsButton().click();
		newContact = new CreateNewContact(driver);
		newContact.createANewContactWithMandatoryFields();
//		driver.findElement(By.name("lastname")).sendKeys("Behera");
//		driver.findElement(By.xpath("//input[@value='U']")).click();
		//driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
//		Thread.sleep(7000);
//		driver.quit();
	}
}
