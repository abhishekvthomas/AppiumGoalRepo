package com.meta.AppiumTestProject.classes.appClasses;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.meta.AppiumTestProject.pagesource.dialer.DialerPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DialerTest {
	
	private static AppiumDriver<MobileElement> driver;
	private DialerPage dialerPage;
	
	@BeforeSuite
	public void beforeMethod() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("deviceName", "Nexus 5X");
		capabilities.setCapability("platformVersion", "8.1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.UDID, "00c1a84e8dce46b4");
		capabilities.setCapability("noReset", false);

		capabilities.setCapability("appPackage", "com.google.android.dialer");
		capabilities.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		dialerPage = new DialerPage(driver);
	}
	
	@Test
	public void dialerTestCase() {
		dialerPage.dialTest();
		System.out.println("Passed");
	}
}
