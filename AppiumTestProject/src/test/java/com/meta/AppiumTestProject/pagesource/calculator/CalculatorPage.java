package com.meta.AppiumTestProject.pagesource.calculator;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculatorPage {
	
	private AppiumDriver<MobileElement> driver;
	
	public CalculatorPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "digit_1")
	MobileElement digit_one;
	
	@AndroidFindBy(id = "digit_2")
	MobileElement digit_two;
	
	@AndroidFindBy(id = "digit_3")
	MobileElement digit_three;
	
	@AndroidFindBy(id = "digit_5")
	MobileElement digit_five;
	
	@AndroidFindBy(className = "android.widget.TextView")
	MobileElement result_screen;
	
	@AndroidFindBy(accessibility = "plus")
	MobileElement plus;
	
	@AndroidFindBy(accessibility = "divide")
	MobileElement divide;
	
	@AndroidFindBy(accessibility = "equals")
	MobileElement equals;
	
	public void waitForElement(MobileElement element) {
		WebDriverWait wait = new WebDriverWait(this.driver, 30);  
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickElement(MobileElement element) {
		waitForElement(element);
		element.click();
	}
	
	public void scenario_one() {
		clickElement(digit_two);
		clickElement(digit_one);
		clickElement(plus);
		clickElement(digit_three);
		clickElement(digit_five);
		clickElement(equals);
		clickElement(divide);
		clickElement(digit_two);
		clickElement(equals);
		waitForElement(result_screen);
		assertEquals(result_screen.getText(),"28");
	}
}
