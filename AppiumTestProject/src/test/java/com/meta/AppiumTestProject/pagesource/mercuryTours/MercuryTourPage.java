package com.meta.AppiumTestProject.pagesource.mercuryTours;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MercuryTourPage{

	private AppiumDriver<WebElement> driver;
	WebDriverWait wait = null;
	
	@FindBy(name = "userName")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "login")
	WebElement loginBtn;
	
	@FindBy(css = "[href=\"mercurysignoff.php\"]")
	WebElement signOff;
	
	public void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean waitUntilInvisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickElement(WebElement element) {
		waitForElement(element);
		element.click();
	}

	public void enterText(WebElement element, String textToEnter) {
		waitForElement(element);
		element.click();
		element.clear();
		element.sendKeys(textToEnter);
	}
	
	public MercuryTourPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(this.driver, 20);
	}
	
	public void mercuryTourTest(AppiumDriver<WebElement> driver) {
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		assertFalse(isElementVisible(signOff));
		enterText(userName, "mercury");
		enterText(password, "mercury");
		password.submit();
		assertTrue(isElementVisible(signOff));
	}
}
