package com.vtiger.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.GenericUtility.RetryAnalyzer;
import com.vtiger.businessUtility.BaseClass;
import com.vtiger.objectRepository.CreateACampaign;
import com.vtiger.objectRepository.HomePage;

@Listeners(com.vtiger.GenericUtility.ListenerUtility.class)
public class ToLearn_RetryAnalyzer extends BaseClass {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void toLearn_RetryAnalyzer() throws InterruptedException, IOException {

		String ExpectedResult = "Camp_001"; 
		String CAMPAIGNNAME = fileUtil.readDataFromPropertiesFile("campaignname");
		
		homePage = new HomePage(driver);
		homePage.getMoreButton().click();
		homePage.getCampaignsButton().click();
		
		campaign = new CreateACampaign(driver);
		campaign.getCreateNewCampaignIcon().click();
		campaign.getCampaignName().sendKeys(CAMPAIGNNAME);
		Thread.sleep(5000);
		campaign.toLearnRetryAnalyzer();
		WebElement element = driver.findElement(By.id("dtlview_Campaign Name"));
		String ActualResult = element.getText();
		System.out.println(ActualResult);
		Assert.assertEquals(ActualResult,ExpectedResult);
		
	}
	
}
