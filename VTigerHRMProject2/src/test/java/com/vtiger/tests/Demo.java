package com.vtiger.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
@Test
	public void demo() {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888/");
	
	//Actions actions = new Actions(driver);
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	//driver.findElement(By.cssSelector("img[src='themes/softed/images/info.PNG']")).click();
	driver.findElement(By.xpath("//td[@onmouseout=\"fnHide_Event('allMenu');\"]")).click();
	driver.findElement(By.name("Campaigns")).click();
	//driver.findElement(By.linkText("Campaigns")).click();
	driver.findElement(By.id("alpha_1")).click();
//	WebElement moreButton = driver.findElement(By.xpath("//td[@onmouseout=\"fnHide_Event('allMenu');\"]"));
//	actions.moveToElement(moreButton).click().perform();
//	
//	WebElement campaignButton = driver.findElement(By.name("Campaigns"));
//	actions.moveToElement(campaignButton).click().perform();
//	
//	WebElement createCampaignButton = driver.findElement(By.xpath("//a[contains(text(),'Create a')]"));
//	actions.moveToElement(createCampaignButton).click().perform();
//	
//	
//	WebElement campaignName =  driver.findElement(By.xpath("//input[@name='campaignname']"));
//	actions.moveToElement(campaignName).click().sendKeys("Camp_001").perform();
	
//	WebElement closingDate = driver.fin
//	actions.moveToElement(closingDate).click().perform();
	
	
	
//for (;;) {
//	
//	try {
//		
//		driver.findElement(By.xpath("//td[text()='September, 2026']/../../..//td[text()='15']")).click();
//		break;
//		
//	} catch (Exception e) {
//
//		driver.findElement(By.xpath("(//td[text()='›'])[2]")).click();
//		
//	}

	
	
//}	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
