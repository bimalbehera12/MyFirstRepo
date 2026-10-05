package com.vtiger.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Demo1 {

    @Test
    public void demo1() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        driver.get("http://localhost:8888/");

        // Login
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();

        // More menu
        WebElement moreButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//td[@onmouseout=\"fnHide_Event('allMenu');\"]")
                )
        );

        // Hover over More
        actions.moveToElement(moreButton).perform();

        // Campaigns
        WebElement campaignButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.name("Campaigns")
                )
        );

        // Move to Campaigns and click
        actions.moveToElement(campaignButton).click().perform();

        // Create Campaign
        WebElement createCampaignButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(text(),'Create a')]")
                )
        );

        createCampaignButton.click();

        // Campaign Name
        WebElement campaignName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("campaignname")
                )
        );

        campaignName.sendKeys("Camp_001");
    }
}
