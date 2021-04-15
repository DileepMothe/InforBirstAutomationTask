package com.birst.infor.automation.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.birst.infor.automation.config.PropertyFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static Logger log = Logger.getLogger(Base.class);

	public static PropertyFileReader reader = new PropertyFileReader();

	public static WebDriver driver;

	
	/*
	 * Author: DileepMothe
	 * Description: This Method is used to Start the Browser based the browser which we pass from the config.properties file
	 */
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public static void startBrowser() {
		try {
			switch (reader.getBrowser().toUpperCase()) {

			case "CHROME":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				Map prefs = new HashMap();
				prefs.put("profile.default_content_setting.cookies", 2);
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);

				break;

			case "EDGE":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			case "IE":
			case "INTERNET EXPLORER":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;

			case "FIREFOX":
				WebDriverManager.firefoxdriver().setup();
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("marionette", false);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new FirefoxDriver(capabilities);
				break;

			}
		} catch (Exception e) {
			log.error(e.getMessage());
			System.out.println(e.getMessage());

		}

	}
	/*
	 * Author: DileepMothe
	 * Description: This method is used to Maximize the browser window
	 */
	public static void maxiMizeWindow() {
		driver.manage().window().maximize();
	}
	
	/*
	 * Author: DileepMothe
	 * Description: This Method is used to Close all the browser related windows
	 * */
	public static void CloseBrowser() {
		driver.quit();
	}

}
