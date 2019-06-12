package com.meta.AppiumTestProject.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ConfigBase {

	private static Properties props;
	public static final String CONFIGFILE = "ConfigFile.properties";
	private static final Logger logger = Logger.getLogger(ConfigBase.class.getName());

	static {
		try {
			init();
			 DOMConfigurator.configure("log4j.xml");
		} catch (IOException e) {
			logger.error("Unable to load configuration", e);
			System.exit(1);
		}
	}

	private static void init() throws IOException {
		props = new Properties();
		InputStream input = ConfigBase.class.getClassLoader().getResourceAsStream(CONFIGFILE);
		props.load(input);
	}

	/**
	 * Returns configuration value corresponding to specified key
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		return props.getProperty(key);
	}
	
	public static String getSoftPhoneQAUrl() {
		return getValue("qa_test_site_name");
	}

	public static String getAdminUserName() {
		return getValue("qa_admin_user_username");
	}
	
	public static String getAdminUserPass() {
		return getValue("qa_admin_user_password");
	}
	
	public static String getAdminPhoneNumber() {
		return getValue("qa_admin_user_number");
	}
	
	public static String getSupportUserName() {
		return getValue("qa_support_user_username");
	}
	
	public static String getSupportUserPass() {
		return getValue("qa_support_user_password");
	}
	
	public static String getSupportPhoneNumber() {
		return getValue("qa_support_user_number");
	}
	
	/**
	 * Returns Appium Driver after initializing
	 * 
	 * @return
	 */
	public AppiumDriver<WebElement> getMobileDriver() throws Exception{
		
		logger.info("******Loading desired capabilities*********");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Admin's iPad");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability("chromedriverExecutable", System.getProperty("user.dir").concat("\\src\\test\\resources\\chromedriver.exe"));
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(new String[] { "--test-type" });
		chromeOptions.addArguments(new String[] { "--use-fake-device-for-media-stream" });
		chromeOptions.addArguments(new String[] { "--use-fake-ui-for-media-stream" });
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3000");
//		capabilities.setCapability(MobileCapabilityType.UDID, "00c1a84e8dce46b4");
		capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AppiumDriver<WebElement> mobileDriver = new AppiumDriver<WebElement>(url, capabilities);
		
		logger.info("******Appium driver initialized*********");
		return mobileDriver;
	}
	
	/**
	 * Returns WebDriver after initializing
	 * 
	 * @param key
	 * @return
	 */
	public WebDriver getWebDriver()
	{
		WebDriver driver = null;
		ChromeOptions options = new ChromeOptions();

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").concat("\\src\\test\\resources\\chromedriver.exe"));
		options.addArguments(new String[] { "--test-type" });
		options.addArguments(new String[] { "--start-maximized" });
		options.addArguments(new String[] { "--use-fake-device-for-media-stream" });
		options.addArguments(new String[] { "--use-fake-ui-for-media-stream" });
		driver = new ChromeDriver(options);
		
		logger.info("******Web driver initialized*********");
		
		return driver;
	}
}
