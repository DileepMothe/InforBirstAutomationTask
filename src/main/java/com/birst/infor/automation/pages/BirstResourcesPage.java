package com.birst.infor.automation.pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.birst.infor.automation.util.Elements;

public class BirstResourcesPage {

	SoftAssert Assert = new SoftAssert();

	public By AllProductsDropDown = By
			.xpath("//div[@class='row align-items-lg-center justify-content-lg-between']/div[3]/select");
	public By AllAssertsDropDown = By
			.xpath("//div[@class='row align-items-lg-center justify-content-lg-between']/div[4]/select");
	public By VerifyWebinar = By.xpath("//a[contains(text(),'Six steps to becoming a data-driven organization')]");

	
	
	
	/*
	 * Author: DileepMothe
	 * Description: This method is used to select the Value from AllProduct drop down list
	 */
	public void selectValueFromAllProductDropdown(String Data) throws InterruptedException {
		Thread.sleep(5000);
		Elements.SelectValueByVisibleText(AllProductsDropDown, Data);
	}

	
	/*
	 * Author: DileepMothe
	 * Description: This method is used to select the Value from AllAssert drop down list
	 */
	public void selectValueFromAllAssertsDropdown(String Data) throws InterruptedException {
		Thread.sleep(3000);
		Elements.SelectValueByVisibleText(AllAssertsDropDown, Data);
	}

	
	/*
	 * Author: DileepMothe
	 * Description: This method is used to verify the specific Webinar details present on the page
	 */
	public void VerifyWebinarExists() throws InterruptedException {
		Thread.sleep(8000);
		Assert.assertTrue(Elements.isDisplayed(VerifyWebinar));
		System.out.println("Six steps to becoming a data-driven organization Webniar is present");
	}
}
