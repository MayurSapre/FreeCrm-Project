package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//****Verify Homepage Label,Contact link,Taskpage link,dealspage link****//

public class HomePage extends TestBase
{
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement conatactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	@FindBy(xpath="//td[contains(text(),'Naveen')]")
	WebElement userlabel;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean label_verification()
	{
		return userlabel.isDisplayed();
	}
	
	public ContactPage clickoncontactslink()
	{
		conatactslink.click();
		return new ContactPage();
	}
	
	public DealsPage clickondealslink()
	{
		dealslink.click();
		return new DealsPage();
	}
	
	public TaskPage clickontaskpage()
	{
		tasklink.click();
		return new TaskPage();
	}
	
}
