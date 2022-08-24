package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.ActitimeConstants;
import com.qa.opencart.util.ElementUtil;

public class TimeTrack {
	
	private WebDriver driver;
	
	private ElementUtil eleutil;
	
	private By tt= By.xpath("//table[@id='topnav']//td[@class='navItem preventPanelsHiding navCell relative selected']/a");
	
	private By hd=By.xpath("//td[text()='Enter Time-Track']");
	
	private By txtfield= By.cssSelector("#taskSearchControl_field");
	
	private By save= By.cssSelector("input[value='Save Changes' ]");
	
	private By logout=By.cssSelector("#logoutLink");
	
	public TimeTrack(WebDriver driver)
	{
		this.driver = driver;
		
		eleutil= new ElementUtil(this.driver);
		
	}
	
	public String isTimetrackDisplayed() {
		
	return	eleutil.doGetText(tt);
	
	}
	
	public String isheaderDisplayed() {
		
		return eleutil.doGetText(hd);
		
	}
	
	public boolean isSaveDisplayed() {
		return eleutil.doIsDisplayed(save);
		
	}
	
	public boolean textFieldValue() {
		
	return	eleutil.waitforVisibleofElement(txtfield, ActitimeConstants.DEFAULT_ELEMENT_TIMEOUT).isDisplayed();
	
	}
	
	public String timetrackpageTitle() {
		
	return	eleutil.waitforTitle(ActitimeConstants.TIMETRACK_PAGE_TITLE, ActitimeConstants.DEFAULT_TIMEOUT);
	
	}
	
	public String timeTrackpageUrl() {
		
		return eleutil.waitforurlcontains(ActitimeConstants.TIMETRACK_PAGE_URL, ActitimeConstants.DEFAULT_TIMEOUT);
		
		
	}
	
	public boolean isLogoutExist() {
		
	return	eleutil.waitforVisibleofElement(logout, ActitimeConstants.DEFAULT_ELEMENT_TIMEOUT).isDisplayed();
	
		
	}
	
	public ActitimeLoginPage clickLogout() {
		
		if (isLogoutExist()) {
			eleutil.doClick(logout);
		}
		
		return new ActitimeLoginPage(driver);
		
	}

}
