package com.Cucumber.framework.configReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;

import com.Cucumber.framework.utility.BrowserType;
import com.Cucumber.framework.utility.ResourceHelper;

public class PropertyFileReader {

	private Properties pro= null;
	
	public PropertyFileReader() {
		
		pro=new Properties();
		try {
			pro.load(ResourceHelper.getResourcePathInputStream("configFile/"+"config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public String getURL() {
		
		return pro.getProperty("URL");
	}
	
	public BrowserType getBrowser() {
		
		return BrowserType.valueOf(pro.getProperty("Browser"));
	
	}
	
	public String getUsername() {
		
		return pro.getProperty("Username");
	}
	
	public String getPassword() {
		
		return pro.getProperty("Password");
	}
	
	public int getPageLoadTimeOut() {
		
		return Integer.parseInt(pro.getProperty("PageLoadTimeOut"));
	}
	
	public int getImplicitWait() {
		
		return Integer.parseInt(pro.getProperty("ImplicitWait"));
	}
	public int getExplicitWait() {
		
		return Integer.parseInt(pro.getProperty("ExplicitWait"));
	}
	
	public Level getLoggerLevel() {
		
		switch(pro.getProperty("Logger.Level")) {
		
		case "DEBUG":
			return Level.DEBUG;
			
		case "INFO":
			return Level.INFO;
			
		case "Error":
			return Level.ERROR;
			
		case "Warn":
			return Level.WARN;
			
		case "Fatal":
			return Level.FATAL;
			
		}
		
		return Level.ALL;
		
		
	}
	
	
}



