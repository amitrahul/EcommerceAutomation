package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.ActiTimeBaseTest;
import com.qa.opencart.constants.ActitimeConstants;

public class TimetrackPageTest extends ActiTimeBaseTest {
	
	
	@BeforeClass
	public void timeTrackSetup() {
		
		 ttr=alp.ActitimeSignin(prop.getProperty("username").trim(),prop.getProperty("password").trim() );
	}
	
	@Test (priority = 1)
	public void timetrackpageTitleTest() {
		
	String actTitle=ttr.timetrackpageTitle();
	
	System.out.println("actual tiltle is : " + actTitle);
		
		Assert.assertEquals(ttr.timetrackpageTitle(), ActitimeConstants.TIMETRACK_PAGE_TITLE);
	}
	
	@Test (priority = 0)
	public void timeTrackpageUrlTest() {
		
		String act_url=ttr.timeTrackpageUrl();
		
		System.out.println(act_url);
		
		Assert.assertEquals(act_url, ActitimeConstants.TIMETRACK_PAGE_URL);
	}
	
	
	@Test (priority = 2)
	public void isTimetrackDisplayedTest() {
		
	String txt=	ttr.isTimetrackDisplayed();
	
	System.out.println("Opened page is: "+ txt);
	
	Assert.assertEquals(txt, ActitimeConstants.TIMETRACK_PAGE_CLICK);
	
	}
	
	@Test (priority = 3)
	public void isheaderDisplayedTest() {
		
		String hdr= ttr.isheaderDisplayed();
		
		System.out.println("Header is : " + hdr);
		
		Assert.assertEquals(hdr, ActitimeConstants.TIMETRACK_PAGE_HEADER);
	}
	
	@Test (priority = 4)
	public void isSaveDisplayedTest() {
		Assert.assertTrue(ttr.isSaveDisplayed());
	}
	
	@Test (priority = 5)
	public void textFieldValueTest() {
		Assert.assertTrue(ttr.textFieldValue());
	}
	
	@Test (priority = 6)
	public void isLogoutExistPageTest() {
		Assert.assertTrue(ttr.isLogoutExist());
	}
	
	@Test (priority = 7)
	public void LogoutPageTest() {
		
		Assert.assertEquals(ttr.clickLogout().LoginTitleActiTime(), ActitimeConstants.LOGIN_PAGE_TITLE);
		
	}

}
