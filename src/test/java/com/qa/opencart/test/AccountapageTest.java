package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constants;

public class AccountapageTest extends BaseTest {
	
	@BeforeTest
	
	public void AccountapageSetup()
	{
	acp=lp.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
	}
	
	@Test
	public void AccountPgTitle() {
		
	String title =	acp.AccountPgTitle();
	
	System.out.println(title);
	
	Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void AccountPgUrl() {
		
	String acturl=acp.AccountPgUrl();
	
	System.out.println(acturl);
	
	Assert.assertEquals(acturl, Constants.Account_PAGE_URL);
	}
	
	
}
