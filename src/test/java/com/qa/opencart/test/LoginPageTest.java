package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constants;

public class LoginPageTest extends BaseTest{
	
	
	@Test (priority = 0)
	public void loginPageTitleTest() {
		
		String title=lp.LoginPageTitle();
		
		System.out.println("login page title is " + title);
		
		// Validation
		
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);	
	}
	
	
	@Test (priority = 1)
	public void loginPageUrlTest() {
		
	String acturl=lp.loginPageUrl();
	
	System.out.println(acturl);
	
	Assert.assertTrue(acturl.contains(Constants.LOGIN_PAGE_URL));	
	}
	
	@Test (priority = 2)
	public void registerLinkexist() {
		
		Assert.assertTrue(lp.isregisterLinkexist());
		
	}
	
	@Test (priority = 3)
	public void orderhistoryexist() {
		
		Assert.assertTrue(lp.isorderhisexist());
	}
	
	@Test (priority = 4)
	public void loginTest()
	{
		lp.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
	}
	

}
