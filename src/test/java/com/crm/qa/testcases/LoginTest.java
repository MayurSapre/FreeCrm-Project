package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		init();
		loginpage=new LoginPage();
		System.out.println("Iniatialization done");
	}
	
	@Test(priority=2)
	public void verifytitle()
	{
		String title=loginpage.title_verification();
		Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software");
		System.out.println("Tiltle verify");
	}
	
	@Test(priority=1)
	public HomePage login()
	{
		loginpage.login_verification(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println("Login done");
		
		return new HomePage();
	}
	
	@AfterMethod
	public void end()
	{
		driver.quit();
		System.out.println("Clsoe browser");
	}
}
