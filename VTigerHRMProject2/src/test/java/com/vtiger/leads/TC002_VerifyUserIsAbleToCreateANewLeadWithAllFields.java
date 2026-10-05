package com.vtiger.leads;

import java.io.IOException;	
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vtiger.businessUtility.BaseClass;
import com.vtiger.objectRepository.CreateLeadPage;
import com.vtiger.objectRepository.HomePage;
@Listeners(com.vtiger.GenericUtility.ListenerUtility.class)
public class TC002_VerifyUserIsAbleToCreateANewLeadWithAllFields extends BaseClass{

	@Test
	public void tC002_VerifyUserIsAbleToCreateANewLeadWithAllFields() throws InterruptedException, IOException {
//
//		FileUtility fileUtil = new FileUtility();
//		WebDriverUtility webUtil = new WebDriverUtility();
//		JavaUtility javaUtil = new JavaUtility();
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
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		//navigate to Leads
		
		HomePage homePage = new HomePage(driver);
		homePage.getLeadsButton().click();
		
		newLead = new CreateLeadPage(driver);
		newLead.createANewLeadWithAllFields();
//		driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
//		driver.findElement(By.cssSelector("img[title='Create Lead...']")).click();
//		WebElement salutationtypeElement = driver.findElement(By.name("salutationtype"));
//		salutationtypeElement.click();
//		Select dropdown1 = new Select(salutationtypeElement);
//		dropdown1.selectByValue("Mr.");
//		driver.findElement(By.name("firstname")).sendKeys("Bimalendu");
//		driver.findElement(By.name("lastname")).sendKeys("Behera");
//		driver.findElement(By.name("company")).sendKeys("Global");
//		driver.findElement(By.id("designation")).sendKeys("Director");
//		driver.findElement(By.xpath("//input[@value='T']")).click();
//		WebElement assigned_group_id = driver.findElement(By.name("assigned_group_id"));
//		assigned_group_id.click();
//		Select dropdown = new Select(assigned_group_id);
//		dropdown.selectByValue("3");
//		driver.findElement(By.id("code")).sendKeys("560037");
//		driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
//		Thread.sleep(7000);
//		driver.quit();
	}
}
