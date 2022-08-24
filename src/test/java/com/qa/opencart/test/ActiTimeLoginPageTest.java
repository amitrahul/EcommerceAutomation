package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.ActiTimeBaseTest;
import com.qa.opencart.constants.ActitimeConstants;


public class ActiTimeLoginPageTest extends ActiTimeBaseTest{

	@Test(priority = 1)
	public void LoginTitleActiTimeTest() {
		
	String title=	alp.LoginTitleActiTime();
		
	System.out.println("title of the page is "+ title);
	
	Assert.assertEquals(title, ActitimeConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority = 2)
	public void LoginurlActiTimeTest() {
		
	String url=	alp.LoginurlActiTime();
	
	System.out.println("url of the page is : " + url);
	
	Assert.assertEquals(url, ActitimeConstants.LOGIN_PAGE_URL);
		
	}
	
	@Test(priority = 3)
	public void IsLoginpageheaderPage() {
		Assert.assertTrue(alp.IsLoginpageheader());
	}
	
	@Test (priority = 4)
	
	public void ActitimeSigninTest() {
		
	Assert.assertTrue(alp.ActitimeSignin(prop.getProperty("username").trim(), prop.getProperty("password").trim()).isLogoutExist());
		
	}
	
	
}
