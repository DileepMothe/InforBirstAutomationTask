package com.birst.infor.automation.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PathHelper {

	/*
	 * Author: DileepMothe
	 * Description: This method is used to get user.dir path
	 */
	public static String getBasePath() {
		return System.getProperty("user.dir");
	}

	/*
	 * Author: DileepMothe
	 * Description: This method is used to get specified path
	 */
	public static String getResourcePath(String path) {
		return getBasePath() + path;
	}

	
	/*
	 * Author: DileepMothe
	 * Description: This method is used to get specified path with return type as FileInputStream
	 */
	public static FileInputStream getInputStreamresourcePath(String path) throws FileNotFoundException {
		return new FileInputStream(getResourcePath(path));
	}
}
