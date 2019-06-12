package com.meta.AppiumTestProject.classes.appClasses;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.meta.AppiumTestProject.pagesource.amazonPage.AmazonPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonTest {

	private static AppiumDriver<MobileElement> hybridAppDriver;
	AmazonPage amazonPage;

	@BeforeSuite
	public void beforeMethod() throws Exception {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot, "src\\test\\resources\\in.amazon.mShop.android.shopping.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("deviceName", "Nexus 5X");
		capabilities.setCapability("platformVersion", "8.1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.UDID, "00c1a84e8dce46b4");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		hybridAppDriver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		amazonPage = new AmazonPage(hybridAppDriver);
	}

	@Test
	public void amazonScenarioTest() throws Exception {
		amazonPage.amazonAppScenarioFirst();
		System.out.println("First scenario passed");
		amazonPage.amazonAppScenarioSecond();
		System.out.println("Second scenario passed");
	}
}
