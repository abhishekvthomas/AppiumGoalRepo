package com.meta.AppiumTestProject.pagesource.dialer;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DialerPage {
	
private AppiumDriver<MobileElement> driver;
	
	public DialerPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "key pad")
	MobileElement dialPad;
	
	@AndroidFindBy(id = "zero")
	MobileElement digit_zero;
	
	@AndroidFindBy(id = "nine")
	MobileElement digit_nine;
	
	@AndroidFindBy(id = "one")
	MobileElement digit_one;
	
	@AndroidFindBy(id = "six")
	MobileElement digit_six;
	
	@AndroidFindBy(id = "four")
	MobileElement digit_four;
	
	@AndroidFindBy(id = "eight")
	MobileElement digit_eight;
	
	@AndroidFindBy(id = "seven")
	MobileElement digit_seven;
	
	@AndroidFindBy(id = "five")
	MobileElement digit_five;
	
	@AndroidFindBy(id = "two")
	MobileElement digit_two;
	
	@AndroidFindBy(id = "digits")
	MobileElement digitsScreen;
	
	@AndroidFindBy(className = "android.widget.TextView")
	MobileElement result_screen;
	
	@AndroidFindBy(accessibility = "dial")
	MobileElement dialBtn;
	
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
	
	public void longTouchElement(MobileElement element) {
		TouchAction action = new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)).withDuration(Duration.ofSeconds(5))).release().perform();
	}
	
	public void dialTest() {
		clickElement(dialPad);
		longTouchElement(digit_zero);
		clickElement(digit_nine);
		clickElement(digit_one);
		clickElement(digit_nine);
		clickElement(digit_zero);
		clickElement(digit_zero);
		clickElement(digit_one);
		clickElement(digit_two);
		clickElement(digit_six);
		clickElement(digit_four);
		clickElement(digit_eight);
		clickElement(digit_seven);
		clickElement(digit_five);
		assertEquals(digitsScreen.getText(), "+91 90012 64875");
		clickElement(dialBtn);
	}
}
