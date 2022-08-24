package com.qa.opencart.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	
	private WebDriver driver; // current value is null, right now it is not pointing to anyone.
	
	public ElementUtil(WebDriver driver)
	{
		this.driver =driver;
		
	}
	
	public By getBy(String locatorType, String locatorValue) {
		
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			
			locator = By.id(locatorValue);
			break;
			
		case "name":
			
			locator = By.name(locatorValue);
			break;


		default:
			break;
			
		case "className":
			
			locator = By.className(locatorValue);
			break;
			
			
		case "xpath":
			
			locator = By.xpath(locatorValue);
			break;
			
		case "cssSelector":
			
			locator = By.cssSelector(locatorValue);
			break;
			
			
			
		case "linkText":
	
			locator = By.linkText(locatorValue);
			break;
			
			
			
		case "partiallinkText":
			
			locator = By.partialLinkText(locatorValue);
			break;
			
			
		case "tagname":
			
			locator = By.tagName(locatorValue);
			break;


		}
		 return locator;
	}
	
	

	public void dosendKeys(String locatorType, String locatorValue, String value) {
		
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
		
		
	}
	
	
	public void dosendKeys(By locator, String value) {
		
		WebElement element= driver.findElement(locator);
		
		element.clear();
	
		element.sendKeys(value);
	}
	
	public WebElement getElement(By locator) {
	
	return driver.findElement(locator);
	
	}
	
	public void doClick(By locator) {
	
	getElement(locator).click();
	}
	

	public String doGetText(By locator) {
	
	return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	
	public boolean doIsENABLED(By locator) {
		
	return	getElement(locator).isEnabled();
		
	}
	
	public String getAttributeValue(By locator, String attrName) {
		
		return getElement(locator).getAttribute(attrName);
		
	}
	
	public  List<WebElement> getElements(By locator) {
		
		return driver.findElements(locator);
		
	}

	
	public  List<String> getElementAttribute(By locator, String attributeName) {
		
		List<WebElement> eleList=getElements(locator);
		
		List<String> eleAttrList= new ArrayList<String>();
		
		for (WebElement e : eleList) {
			
			String attributeValue=e.getAttribute(attributeName);
	
			System.out.println(attributeValue);
			
			eleAttrList.add(attributeValue);
			
		}
		
		return eleAttrList;
		
	}
	
	
	public  List<String> getElementTextList(By locator) {
	
		List<WebElement> eleList=getElements(locator);
		
		List<String> eleTextList= new ArrayList<String>();
		
		for (WebElement e : eleList) {
			
			String eleText=e.getText();
			
			eleTextList.add(eleText);
			
		}
		
		return eleTextList;
		
	}

	public  int getElementCount(By locator) {
	
	return getElements(locator).size();
	
}


	public void selectSuggestion(By locator, String suggVal) {
	List<WebElement> suggList = driver.findElements(locator);
	for (WebElement e : suggList) {
		String text = e.getText();
		System.out.println(text);
		if (text.contains(suggVal)) {
			e.click();
			break;
		}
	}
}

	public List<String> getSuggList(By locator, String searchKey) {
	List<WebElement> suggList = driver.findElements(locator);
	List<String> suggValList = new ArrayList<String>();
	for (WebElement e : suggList) {
		String text = e.getText();
		System.out.println(text);
		suggValList.add(text);
	}
	return suggValList;
}
	
	public boolean isElementDisplayed(By locator) {
		WebElement ele = getElement(locator);
		List<WebElement> eleList = getElements(locator);
		if (eleList.size() > 0) {
			if (ele.isDisplayed())
				return true;
		}
		return false;
	}

	public boolean isElementDisplayedWithSize(By locator) {
		List<WebElement> eleList = getElements(locator);
		if (eleList.size() > 0) {
			return true;
		}
		return false;
	}


/**************************Drop down handling methods
*/
	


	public  void dropdownbyindex(By locator, int i) {
	
	Select sel=new Select(getElement(locator));
	
	sel.selectByIndex(i);
	
}

	public  void dropdownbyvalue(By locator, String val) {
	
	Select sel=new Select(getElement(locator));
	
	sel.selectByValue(val);
	
}


	public  void dropdownbyVisibletext(By locator, String txt) {
	
	Select sel=new Select(getElement(locator));
	
	sel.selectByVisibleText(txt);
	
}

	public  void dropdownGetoptionstext(By locator) {
	Select sel=new Select(getElement(locator));
	
	List<WebElement> list= sel.getOptions();
	
	for (WebElement w : list) {
		
		System.out.println(w.getText());
		
	}
}


	public  void dropdownGetoptionselection(By locator, String txt) {
		
	
	Select sel=new Select(getElement(locator));
	
	List<WebElement> list= sel.getOptions();
	
	System.out.println("total options are : " + list.size());
	
	for (WebElement w : list) {
		
		String li=w.getText();
		
	if(	li.contains(txt))
	{
		w.click();
		break;
	}
		
	}
	
	

}
	
	/*	drop down selection without select class 
	 * 
	 */
	
		
	
	public  void multiSelection(By locator, String... value) {
		
		List<WebElement> pathlist=	driver.findElements(locator);
		
		boolean flag=false;
		
		if (!value[0].trim().equalsIgnoreCase("all"))
		{
		
		for (WebElement w : pathlist) {
			
		//	System.out.println(w.getText());
			
			for (int i = 0; i < value.length; i++) {
				
				if (w.getText().trim().equals(value[i])) {
					
					flag=true;
					w.click();
					break;
					
				}
				
				
			
			}
			
			
		}
		
		}
		
		else
		{
			for (WebElement w : pathlist) {
				flag=true;
				w.click();
			}
		}
		
		if(flag==false)
		{
			System.out.println("Please provide correct choice : " + value[0]);
		}
		
	}
	
	
	/*
	 *  *********************Menu Handling**********************
	 */

		
	public  void twoLevelMenuHandling(By locator, By locaotr1)
	{	
		Actions act= new Actions(driver);
		
		act.moveToElement(getElement(locator)).perform();
		
		getElement(locaotr1).click();
		
	}
	
	
	/***************************Actions class input**************
	 * 
	 */
	
	

		public  void doActionsSendkeys(By locator, String value) {
		
		Actions act= new Actions(driver);
		
		act.moveToElement(getElement(locator)).sendKeys(getElement(locator), value).perform();
		
		
	}
	
		public  void doActionsClick(By locator) {
		
		Actions act= new Actions(driver);
		
		act.moveToElement(getElement(locator)).click().perform();

		
	}
		
		
		public  boolean isElementDisplayedhavingsize(By locator) {
			
			WebElement ele = getElement(locator);
			
			List<WebElement> ele_list = getElements(locator);
			
			if(ele_list.size()>0)
			{
					if (ele.isDisplayed()) 
						System.out.println("Pass");
						return true;
			}
			
			System.out.println("fail");
			return false;	
		}
		
		
		
	/***************************************Wait utils**********************************************/
		/*    An expectation for checking that an element is present on the DOM of a page. 
		 * This does not necessarily mean that the element is visible.

			Parameters:
			locator used to find the element
			Returns:
			the WebElement once it is located
		 * 
		 */
		
		
		public  WebElement waitforpersenceofElement(By locator, int timeout) {
			
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
			
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			
		}
		
		
		/*	An expectation for checking that an element is present on the DOM of a page and visible. 
		 * Visibility means that the element is not only displayed but 
		 * also has a height and width that is greater than 0.

			Parameters:
			locator used to find the element
			Returns:
			the WebElement once it is located and visible
		 * 
		 */
		
		public  WebElement waitforVisibleofElement(By locator, int timeout) {
			
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
			
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
			
		}
		
		/*	An expectation for checking that the title contains a case-sensitive substring

				Parameters:
				title the fragment of title expected
				Returns:
				true when the title matches, false otherwise
		 * 
		 */
		
		
		public  String waitforTitlecontains(String  partialtitle, int timeout) {
			
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
			
			if(	wait.until(ExpectedConditions.titleContains(partialtitle)))
			{
				
				return driver.getTitle();
				
			}
			return null;
		}
		
		
		/*		An expectation for checking the title of a page.

					Parameters:
					title the expected title, which must be an exact match
					Returns:
					true when the title matches, false otherwise
		 * 
		 */
		
		public  String waitforTitle(String title, int timeout) {
			
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
			
			if(	wait.until(ExpectedConditions.titleIs(title)))
			{
				
				return driver.getTitle();
				
			}
			return null;
		}
		
		
		public  String waitforurlcontains(String partialurl, int timeout) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
			
			if(wait.until(ExpectedConditions.urlContains(partialurl)))
			{
				return driver.getCurrentUrl();
		}
			
			return null;
			
		}
		
		
		public  String waitForurlIs(String url, int timeout) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
			
			if(wait.until(ExpectedConditions.urlToBe(url)))
			{
				return driver.getCurrentUrl();
		}
			
			return null;
			
		}
		
		
		public void acceptAlert(int timeOut) {
			waitForAlert(timeOut).accept();
		}

		public void dismissAlert(int timeOut) {
			waitForAlert(timeOut).dismiss();
		}

		public void alertSendKeys(int timeOut, String value) {
			waitForAlert(timeOut).sendKeys(value);
		}

		public String doGetAlertText(int timeOut) {
			return waitForAlert(timeOut).getText();
		}

		public Alert waitForAlert(int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.alertIsPresent()); // wait for alert and then switch to alert

		}
		
		
		
		/***********************************frame wait*******************************/
		
		
		public void waitForFrameByLocator(By frameLocator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		}

		public void waitForFrameByIndex(int frameIndex, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
		}

		public void waitForFrameByElement(WebElement frameElement, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		}
		
		
		/***************************************************************************/
		
		/**
		 * An expectation for checking an element is visible and enabled such that you
		 * can click it.
		 * 
		 * @param locator
		 * @param timeOut
		 */
		public void clickElementWhenReady(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}
		
		
		
		/**
		 * An expectation for checking that all elements present on the web page that
		 * match the locator are visible. Visibility means that the elements are not
		 * only displayed but also have a height and width that is greater than 0.
		 * 
		 * @param locator
		 * @param timeOut
		 * @return
		 */
		public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		
		
		public WebElement waitForElementVisible(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}

		/**
		 * An expectation for checking that there is at least one element present on a
		 * web page. Default Polling Time = 500ms
		 * 
		 * @param locator
		 * @param timeOut
		 * @return
		 */
		public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
		
		public void waitForElementToBeClickableWithPolling(By locator, int timeOut, int pollingTime) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(pollingTime));
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

		}
		
		/**
		 * An expectation for checking that there is at least one element present on a
		 * web page. Default Polling Time = customized
		 * 
		 * @param locator
		 * @param timeOut
		 * @return
		 */
		public List<WebElement> waitForElementsPresencewithpolling(By locator, int timeOut, int pollingTime) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(pollingTime));
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}

		public void waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime, String message) {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofMillis(pollingTime))
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).withMessage(message);

			wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
		}


		
		
		
		
		/*******************************************************************************************************/
		
		
		
		public WebElement retryingElement(By locator, int timeOut, int pollingTime) {

			WebElement element = null;

			int attempts = 0;
			while (attempts < timeOut) {
				try {
					element = driver.findElement(locator);
					break;
				} catch (NoSuchElementException e) {
					System.out.println("element is not found in attempt : " + attempts + " for : " + locator);
					try {
						Thread.sleep(pollingTime);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				attempts++;
			}

			if (element == null) {
				try {
					throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
				} catch (Exception e) {
					System.out.println("element is not found exception....tried for : " + timeOut + " secs"
							+ " with the interval of : " + pollingTime + " ms ");
				}
			}

			return element;

		}

		public void waitForPageLoad(int timeOut) {

			long endTime = System.currentTimeMillis() + timeOut;

			while (System.currentTimeMillis() < endTime) {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				String state = js.executeScript("return document.readyState").toString();
				System.out.println("page is : " + state);
				if (state.equals("complete")) {
					System.out.println("page is fully loaded now....");
					break;
				}

			}

		}
		

	}
	



