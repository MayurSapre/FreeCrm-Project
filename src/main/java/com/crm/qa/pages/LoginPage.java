package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

///****Verify Logo and Login Functionality***//
public class LoginPage extends TestBase
{
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement submit;
	
	@FindBy(xpath="//img[@src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg']")
	WebElement logo;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Title Verification
	public String title_verification()
	{
		return driver.getTitle();
	}
	
	//Logo Verification
	public boolean logo_verification()
	{
		return logo.isDisplayed();
	}
	
	//Login Verification
	public HomePage login_verification(String un,String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		JavascriptExecutor jsx=(JavascriptExecutor) driver;
		jsx.executeScript("arguments[0].click()",submit);
		
		return new HomePage();
	}
	
	
}
