package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utility.TestUtil;

public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage conatactpage;
	DealsPage dealspage;
	TaskPage taskpage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		init();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		conatactpage=new ContactPage();
		dealspage=new DealsPage();
		taskpage=new TaskPage();
		homepage=loginpage.login_verification(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verify_title()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title,"CRMPRO","Title is not valid");
	}
	
	@Test(priority=2)
	public void verify_usernamelabel()
	{
		testutil.switch_to_frame();
		homepage.label_verification();
	}
	
	@Test(priority=3)
	public void verify_contacts_link()
	{
		testutil.switch_to_frame();
		conatactpage=homepage.clickoncontactslink();
	}
	
	@Test(priority=4)
	public void verify_deals_link()
	{
		testutil.switch_to_frame();
		dealspage=homepage.clickondealslink();
	}
	
	@Test(priority=5)
	public void verify_tasks_page()
	{
		testutil.switch_to_frame();
		taskpage=homepage.clickontaskpage();
	}
	
	@AfterMethod
	public void end()
	{
		driver.close();
	}
}
