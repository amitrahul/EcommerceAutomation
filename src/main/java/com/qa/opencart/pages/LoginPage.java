package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.util.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;  // Every class should have it's own driver to perform actions.
	
	private ElementUtil eleutil;
	
	private By email=By.id("input-email");
	
	private By pwd= By.id("input-password");
	
	private By login= By.xpath("//input[@type='submit']");
	
	private By register=By.xpath("//a[text()='Register' and @class='list-group-item']");
	
	private By orderhis= By.xpath("//a[text()='Order History' and @class='list-group-item']");
	
	private By rp = By.xpath("//a[text()='Reward Points']");
		
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		
		eleutil= new ElementUtil(this.driver);
		
	}
	
	
	//Page Actions
	
	public String LoginPageTitle() {
		
		return eleutil.waitforTitle(Constants.LOGIN_PAGE_TITLE,Constants.DEFAULT_TIMEOUT);
		
		
	}
	
	public String loginPageUrl() {
		
	return eleutil.waitforurlcontains(Constants.LOGIN_PAGE_URL, Constants.DEFAULT_TIMEOUT);
	
		
	}
	
	public AccountsPage doLogin(String un, String pw) {
		
		System.out.println("login credential are : " + un + "  and " +  pw);
		
		eleutil.waitForElementVisible(email, Constants.DEFAULT_ELEMENT_TIMEOUT).sendKeys(un);
		
		eleutil.dosendKeys(pwd, pw);
		
		eleutil.doClick(login);
		
		return new AccountsPage(driver);     // returning new class object.
	}
	
	public boolean isregisterLinkexist() {
	return	eleutil.doIsDisplayed(register);
	}
	
	public boolean isorderhisexist() {
		
		return eleutil.doIsDisplayed(orderhis);
		
		
	}

}
