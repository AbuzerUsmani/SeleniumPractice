package com.qa.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.practice.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page factory--OR
	@FindBy (id="login1")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@name=\"proceed\"]")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//div[@class=\"logtext\"]")
	WebElement logo;

	//Initialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		SubmitBtn.click();
		return new HomePage();
	}
	
}
