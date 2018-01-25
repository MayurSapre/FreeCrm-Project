package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//*****Verify Title,Select Checkbox**
public class ContactPage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement conatactslabel;
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_contact_label()
	{
		return conatactslabel.isDisplayed();
	}
	
	public void selectcontactsbyname(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	
}
