package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	
	private ElementUtil eleutil;
	
	
	private By myacc= By.xpath("//aside[@id='column-right']//a[text()='My Account']");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		
		eleutil = new ElementUtil(this.driver);
	}
	
	
	public String AccountPgTitle() {
		
	return	eleutil.waitforTitle(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	
	}
	
	public String AccountPgUrl() {
		
		return eleutil.waitforurlcontains(Constants.Account_PAGE_URL, Constants.DEFAULT_TIMEOUT);
		
		
	}

}
