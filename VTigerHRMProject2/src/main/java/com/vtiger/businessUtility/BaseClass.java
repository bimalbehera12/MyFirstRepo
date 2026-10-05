package com.vtiger.businessUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.GenericUtility.FileUtility;
import com.vtiger.GenericUtility.JavaUtility;
import com.vtiger.GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateACampaign;
import com.vtiger.objectRepository.CreateLeadPage;
import com.vtiger.objectRepository.CreateNewContact;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

public class BaseClass {
	// driver declaration
	public WebDriver driver;
	public static WebDriver sdriver;

	// create object for POM class
	public HomePage homePage;
	public LoginPage loginpage;
	public CampaignPage campaignPage;
	public CreateACampaign campaign;
	public CreateNewContact newContact;
	public CreateLeadPage newLead;

	// create object for utility class
	public FileUtility fileUtil = new FileUtility();
	public WebDriverUtility webUtil = new WebDriverUtility();
	public JavaUtility javaUtil = new JavaUtility();

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("@BeforeSuite - database connectivity established", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("@AfterSuite - database connectivity terminated", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("@BeforeTest - report starts", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("@AfterTest - report backed-up", true);
	}
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String BROWSER) {
		Reporter.log("@BeforeClass - launch browser", true);
//		driver = new ChromeDriver();
//		String BROWSER = null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("CHROME_DRIVER LAUNCHED");	
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println("EDGE_DRIVER LAUNCHED");
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("FIREFOX_DRIVER LAUNCHED");
		}
		else if(BROWSER.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			System.out.println("SAFARI_DRIVER LAUNCHED");
		}
		else {
			Reporter.log("INVALID INPUT");
		}
		sdriver = driver;
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("@AfterClass - close browser", true);
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		Reporter.log("@BeforeMethod - login to the application", true);

		String URL = fileUtil.readDataFromPropertiesFile("url");
		String USERNAME = fileUtil.readDataFromPropertiesFile("username");
		String PASSWORD = fileUtil.readDataFromPropertiesFile("password");

		webUtil.toMaximize(driver);
		webUtil.toImplicitlyWait(driver);
		driver.get(URL);
		// Login
		loginpage = new LoginPage(driver);
		loginpage.login(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("@AfterMethod - logout from the application", true);
		homePage = new HomePage(driver);
		homePage.logout();
	}
}
