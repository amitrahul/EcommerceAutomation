package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.driver.factory.DriverFactory;
import com.qa.opencart.pages.ActitimeLoginPage;
import com.qa.opencart.pages.TimeTrack;

public class ActiTimeBaseTest {

public DriverFactory df;
	
	public WebDriver driver;
	
	public Properties prop;
	
	protected ActitimeLoginPage alp;
	
	protected TimeTrack ttr;
	
	
	@BeforeTest
	public void setUp() {
	
		df= new DriverFactory();
		
		prop= df.init_prop();
		
		driver=df.init_driver(prop);
		
		alp = new ActitimeLoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}
	
}
