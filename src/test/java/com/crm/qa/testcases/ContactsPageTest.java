package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		init();
		testutil=new TestUtil();
		contactpage=new ContactPage();
		loginpage=new LoginPage();
		homepage=loginpage.login_verification(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switch_to_frame();
		contactpage=homepage.clickoncontactslink();
		
		
	}
	
	@Test(priority=1)
	public void verify_contacts_label()
	{
		Assert.assertTrue(contactpage.verify_contact_label(),"Contact label missing on page");
	}
	
//	@Test(priority=2)
//	public void selectcontacts()
//	{
//		contactpage.selectcontactsbyname("AAAXXX fsfsf");
//	}
	
	@AfterMethod
	public void end()
	{
		driver.close();
	}
	
}
