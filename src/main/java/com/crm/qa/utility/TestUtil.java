package com.crm.qa.utility;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long IMPLICIT_WAIT=10;
	public static long PAGE_LOAD_TIMEOUT=20;
	
	public void switch_to_frame()
	{
		driver.switchTo().frame("mainpanel");
	}
}
