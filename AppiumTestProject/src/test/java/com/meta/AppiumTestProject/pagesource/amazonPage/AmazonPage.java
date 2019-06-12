package com.meta.AppiumTestProject.pagesource.amazonPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AmazonPage {
	
private AppiumDriver<MobileElement> driver;
WebDriverWait wait = null;
	
	public AmazonPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(this.driver, 60);
	}
	
	@AndroidFindBy(id = "skip_sign_in_button")
	MobileElement skipSignInBtn;
	
	@AndroidFindBy(id = "action_bar_burger_icon")
	MobileElement homeIcon;
	
	@AndroidFindBy(xpath = "//*[@text='Your Account']")
	MobileElement yourAccount;
	
	@AndroidFindBy(id = "login_accordion_header")
	MobileElement loginRadioBtn;
	
	@AndroidFindBy(className = "android.widget.TextView")
	MobileElement result_screen;
	
	@AndroidFindBy(id = "ap_email_login")
	MobileElement email_mobileNo_tab;
	
	@AndroidFindBy(id = "continue")
	MobileElement continueBtn;
	
	@AndroidFindBy(id = "auth-signin-show-password-checkbox")
	MobileElement showPasswordCheckBox;
	
	@AndroidFindBy(id = "ap_password")
	MobileElement password_tab;
	
	@AndroidFindBy(id = "signInSubmit")
	MobileElement loginBtn;
	
	@AndroidFindBy(xpath = "//*[@text='Your Orders']")
	MobileElement yourOrders;
	
	@AndroidFindBy(id = "gno_greeting_text_view")
	MobileElement greetingText;
	
	@AndroidFindBy(xpath = "//*[@text='Home']")
	MobileElement goToHome;
	
	@AndroidFindBy(xpath = "//*[@id='search_edit_text']")
	MobileElement searchBar;
	
	@AndroidFindBy(id = "search_auto_text")
	MobileElement searchAutoText;
	
	@AndroidFindBy(id = "rs_search_dropdown_item_text")
	List<MobileElement> searchDropDown;
	
	@AndroidFindBy(xpath = "//*[@id='resultItems']//*[contains(@text,'SHAFTESBURY LONDON')]")
	MobileElement selectCloth;
	
	@AndroidFindBy(xpath = "//*[@text='Size:']/parent::*[@class='android.view.View']/..//*[contains(@id,'size_name')]//*[@text='36']")
	MobileElement sizeCloth;
	
	@AndroidFindBy(id = "add-to-cart-button")
	MobileElement addToCartBtn;
	
	@AndroidFindBy(id = "action_bar_cart_image")
	MobileElement selectCart;
	
	@AndroidFindBy(xpath = "//*[@id='activeCartViewForm']//*[@class='android.widget.Image'][contains(@text, \"SHAFTESBURY LONDON \")]")
	MobileElement cartResultItem;
	
	@AndroidFindBy(xpath = "//*[@id='activeCartViewForm']//*[@class='android.widget.Image'][contains(@text, \"SHAFTESBURY LONDON\")]/ancestor::*[contains(@id,'sc-item-')]//*[@text='Delete']")
	MobileElement deleteBtnForItem;

	public boolean isListElementsVisible(List<MobileElement> searchDropDown2) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) searchDropDown2));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void waitForElement(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickElement(MobileElement element) {
		waitForElement(element);
		element.click();
	}

	public boolean isElementVisible(MobileElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void enterText(MobileElement element, String textToEnter) {
		waitForElement(element);
		element.click();
		element.clear();
		element.sendKeys(textToEnter);
	}
	
	public void amazonAppScenarioFirst() {
		if(isElementVisible(skipSignInBtn)) {
			clickElement(skipSignInBtn);
		}
		clickElement(homeIcon);
		assertFalse(greetingText.getText().equals("Hello, Abhishek Thomas"));
		clickElement(yourAccount);
		clickElement(loginRadioBtn);
		enterText(email_mobileNo_tab, "9001264875");
		clickElement(continueBtn);
		clickElement(showPasswordCheckBox);
		enterText(password_tab, "******");
		clickElement(loginBtn);
		clickElement(homeIcon);
		assertTrue(greetingText.getText().equals("Hello, Abhishek Thomas"));
		clickElement(goToHome);
		System.out.println("Login successful");
	}

	public void amazonAppScenarioSecond() throws Exception {
		clickElement(searchBar);
		enterText(searchAutoText, "SHAFTESBURY LONDON mens shirt");
		Thread.sleep(10000);
		isListElementsVisible(searchDropDown);
		clickElement(searchDropDown.get(0));
		clickElement(selectCloth);
		clickElement(addToCartBtn);
		clickElement(selectCart);
		Thread.sleep(3000);
		assertTrue(isElementVisible(cartResultItem));
		clickElement(deleteBtnForItem);
		Thread.sleep(3000);
		assertFalse(isElementVisible(cartResultItem));
	}
	
}
