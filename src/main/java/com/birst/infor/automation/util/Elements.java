package com.birst.infor.automation.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.birst.infor.automation.base.Base;

public class Elements {
	public static Logger log = Logger.getLogger(Elements.class);

	/*
	 * Author: DileepMothe
	 * Description: This method is used to Click Object 
	 */
	public static void clickObject(By element, String elementName) {
		try {
			if (isDisplayed(element))
				Base.driver.findElement(element).click();
			else
				log.error("Element is not Displayed on the Page");
		} catch (Exception e) {
			log.error("Getting Exception while clicking on the element and error message is :" + e.getMessage());
		}

	}

	
	/*
	 * Author: DileepMothe
	 * Description: This method is used to send data to text boxes
	 */
	public static void SendInput(By element, String data, String elementName) {
		try {

			if (isDisplayed(element))
				Base.driver.findElement(element).sendKeys(data);
			else
				log.error("Element is not Displayed on the Page");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.error("Getting Exception while sending data to the element and error message is :" + e.getMessage());

		}

	}

	/*
	 * Author: DileepMothe
	 * Description: This method is used to select a dropdown based on visible text
	 */
	public static void SelectValueByVisibleText(By element, String Data) {

		try {
			if (isDisplayed(element)) {
				Select select = new Select(Base.driver.findElement(element));
				select.selectByVisibleText(Data);
			} else
				log.error("Element is not Displayed on the Page");
		} catch (Exception e) {
			log.error(
					"Getting Exception while selecting data from the element and error message is :" + e.getMessage());

		}

	}

	/*
	 * Author: DileepMothe
	 * Description: This method is used to specified element displayed or not
	 */
	public static boolean isDisplayed(By element) {
		if (Base.driver.findElement(element).isDisplayed())
			return true;
		else
			return false;
	}

}
