package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//Declaration
	@FindBy(name = "user_name")
	private WebElement UserNameTextField;

	@FindBy(name = "user_password")
	private WebElement PasswordTextField;

	@FindBy(id = "submitButton")
	private WebElement LoginButton;

//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Getters
	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

//
	public void login(String USERNAME, String PASSWORD) {
		UserNameTextField.sendKeys(USERNAME);
		PasswordTextField.sendKeys(PASSWORD);
		LoginButton.click();
	}
	
}
