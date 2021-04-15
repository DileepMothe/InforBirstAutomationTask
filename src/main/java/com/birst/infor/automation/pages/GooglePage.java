package com.birst.infor.automation.pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.birst.infor.automation.base.Base;
import com.birst.infor.automation.util.Elements;

public class GooglePage {

	SoftAssert Assert = new SoftAssert();

	public By googleSearchBox = By.name("q");
	public By googleSearchButton = By.name("btnK");
	public By birstInforLink = By.xpath("//h3[contains(text(),'Birst | Business intelligence and analytics | Infor')]");

	
	
	
	/*
	 * Author: DileepMothe
	 * Description: This method is used to Browser navigate to Google.com andd verify page title
	 */
	public void navigateToGoogleSiteAndverifyTittle() {
		Base.driver.get("https://www.google.com/");
		Assert.assertEquals("Google", Base.driver.getTitle());
		System.out.println("Page Title is :" + Base.driver.getTitle());

	}

	
	/*
	 * Author: DileepMothe
	 * Description: This method is used to search a specific string
	 */
	public void searchText(String Data) throws InterruptedException {
		Thread.sleep(3000);
		Elements.SendInput(googleSearchBox, Data, "Google Search text box");
		Thread.sleep(3000);
		Elements.clickObject(googleSearchButton, "Google Search Button");
	}

	/*
	 * Author: DileepMothe
	 * Description: This method is used to click on the BristInfor Link
	 */
	public void clickBirstInforLinkIfExists() throws InterruptedException {
		Thread.sleep(3000);
		if (Elements.isDisplayed(birstInforLink)) {
			Elements.clickObject(birstInforLink, "Birst Infor Link");
		}
	}

}
