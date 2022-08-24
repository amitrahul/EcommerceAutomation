package com.qa.opencart.driver.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	WebDriver driver;
	
	Properties prop;
	
	OptionsManager optinonsManager;
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser").trim();
		
		optinonsManager = new OptionsManager(prop);
	
		System.out.println("Browser name is " + browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			
			driver= new EdgeDriver();
			
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			driver= new FirefoxDriver();
			
		}
		
		else {
			System.out.println("please pass the right browser : " + browserName);
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url").trim());
		
		
		return driver;
		
	}
	
	/*
	 * This method is used to initialize the properties.
	 */
	
	public Properties init_prop() {
		
		try {
			FileInputStream ip= new FileInputStream("./src/test/resources/configuration/config.properties");
			
			 prop= new Properties();
			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	


}
