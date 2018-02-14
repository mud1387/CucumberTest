package com.Cucumber.framework.helper.testBase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Cucumber.framework.configReader.PropertyFileReader;
import com.Cucumber.framework.helper.logger.logger;
import com.Cucumber.framework.utility.BrowserType;

public class TestBase {

	private final Logger log=logger.getLogger(TestBase.class);
	public WebDriver driver;
	
	PropertyFileReader pro= new PropertyFileReader();
	
	public WebDriver startBrowser(BrowserType bro) {
		
		switch (bro) {
		case chrome:
			log.info(bro);
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver","./src/main/resources/Driver/chromedriver.exe");
			driver= new ChromeDriver(options);
			break;
		case firefox:
			
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/Driver/geckodriver.exe");
			driver= new FirefoxDriver();
			break;
			
		case ie:
			System.setProperty("webdriver.ie.driver", "./src/main/resources/Driver/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			break;
			
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(pro.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pro.getPageLoadTimeOut(), TimeUnit.SECONDS);
		
		return driver;
		
		
	}
}


