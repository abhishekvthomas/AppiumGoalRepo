package com.meta.AppiumTestProject.classes.appClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.meta.AppiumTestProject.base.ConfigBase;
import com.meta.AppiumTestProject.pagesource.mercuryTours.MercuryTourPage;

import io.appium.java_client.AppiumDriver;

public class MercuryTourTest extends ConfigBase{

	private AppiumDriver<WebElement> webAppdriver;
	MercuryTourPage mercuryPage;
	
	@Test
	public void mercuryTestCase() throws Exception {
		webAppdriver = getMobileDriver();
		mercuryPage = new MercuryTourPage(webAppdriver);
		mercuryPage.mercuryTourTest(webAppdriver);
		System.out.println("Passed");
	}
}
