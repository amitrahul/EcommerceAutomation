package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.driver.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	public DriverFactory df;
	
	public WebDriver driver;
	
	public Properties prop;
	
	protected LoginPage lp;
	
	protected AccountsPage acp;
	
	@BeforeTest
	public void setUp() {
	
		df= new DriverFactory();
		
		prop= df.init_prop();
		
		driver=df.init_driver(prop);
		
		lp= new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}

}
