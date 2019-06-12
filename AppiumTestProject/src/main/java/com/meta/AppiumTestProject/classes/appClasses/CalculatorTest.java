package com.meta.AppiumTestProject.classes.appClasses;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.meta.AppiumTestProject.pagesource.calculator.CalculatorPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {

	private static AppiumDriver<MobileElement> driver;
	private CalculatorPage calculatorPage;  

	@BeforeSuite
	public void beforeMethod() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("deviceName", "Nexus 5X");
		capabilities.setCapability("platformVersion", "8.1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.UDID, "00c1a84e8dce46b4");
		capabilities.setCapability("noReset", false);

		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		calculatorPage = new CalculatorPage(driver);
	}
	
	@Test
	public void test() {
		calculatorPage.scenario_one();
		System.out.println("Passed");
	}
	
}
