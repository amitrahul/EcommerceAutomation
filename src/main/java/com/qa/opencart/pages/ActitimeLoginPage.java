package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.ActitimeConstants;
import com.qa.opencart.util.ElementUtil;

public class ActitimeLoginPage {
	
	
	private WebDriver driver;
	
	private ElementUtil eleutil;
	
	private By un= By.cssSelector("input#username");
	
	private By pwd= By.xpath("//input[@type='password']");
	
	private By login= By.xpath("//div[text()='Login ']");
	
	private By checkbox= By.cssSelector("#keepLoggedInCheckBox");
	
	private By header= By.cssSelector("#headerContainer");
	
	public ActitimeLoginPage(WebDriver driver)
	{
		this.driver= driver;
		
		eleutil= new ElementUtil(this.driver);
	}
	
	public String  LoginTitleActiTime()
	{
		return eleutil.waitforTitle(ActitimeConstants.LOGIN_PAGE_TITLE, ActitimeConstants.DEFAULT_TIMEOUT);
	}
	
	public String LoginurlActiTime() {
		
		return eleutil.waitforurlcontains(ActitimeConstants.LOGIN_PAGE_URL,ActitimeConstants.DEFAULT_TIMEOUT);
		
	}
	
	
	public TimeTrack ActitimeSignin(String u, String p) {
		System.out.println("user is logged with username : " + u + " and password is " + p);
		
		eleutil.waitforpersenceofElement(un, ActitimeConstants.DEFAULT_ELEMENT_TIMEOUT).sendKeys(u);
		
		eleutil.dosendKeys(pwd, p);
		
		eleutil.doClick(checkbox);
		
		eleutil.doClick(login);
		
		return new TimeTrack(driver);      // here it's return TimeTrack class object.
	}
	
	public boolean IsLoginpageheader() {
		
	return	eleutil.doIsDisplayed(header);
	
	
	}
	
	

}
