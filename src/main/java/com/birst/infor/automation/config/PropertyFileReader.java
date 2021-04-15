package com.birst.infor.automation.config;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.birst.infor.automation.util.PathHelper;

public class PropertyFileReader {

	public static Logger log = Logger.getLogger(PropertyFileReader.class);
	Properties prop = new Properties();

	/*
	 * Author: DileepMothe
	 * Description: This method is used to load the config.properties file
	 */
	public PropertyFileReader() {
		try {
			prop.load(PathHelper.getInputStreamresourcePath("/src/main/resources/ConfigFile/config.properties"));
		} catch (Exception e) {
			log.info("The Config File is not found and error message is: " + e.getMessage());
		}
	}

	/*
	 * Author: DileepMothe
	 * Description: This method is used to get the Browser name from config.properties file
	 */
	public String getBrowser() {
		return prop.getProperty("Browser");
	}

}
