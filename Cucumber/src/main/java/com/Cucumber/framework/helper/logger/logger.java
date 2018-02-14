package com.Cucumber.framework.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.Cucumber.framework.utility.ResourceHelper;

public class logger {

	private static boolean root=false;
	
	public static Logger getLogger(Class clas) {
		
		if(root) {
			
			return Logger.getLogger(clas);
		}
		
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("configFile/"+"log4j.properties"));
		root=true;
		return Logger.getLogger(clas);
		
	}
}
