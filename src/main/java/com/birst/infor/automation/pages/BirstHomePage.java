package com.birst.infor.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.birst.infor.automation.base.Base;
import com.birst.infor.automation.util.Elements;

public class BirstHomePage {

	public By InforLogo = By.xpath("//img[@src='/img/logo-infor.png']");
	public By ResourcesLink = By.linkText("Resources");
	public By AcceptAllCookies = By.xpath("//button[contains(text(),'Accept All Cookies')]");

	
	
	
	
	/*
	 * Author: DileepMothe
	 * Description: This method is used to verify and Print the Infor Logo displayed on the page
	 */
	public void verifyInforLogo() throws InterruptedException {
		Thread.sleep(3000);
		if (Elements.isDisplayed(InforLogo)) {
			System.out.println("Infor Logo is Displayed");
		} else
			System.out.println("Infor Logo is not Displayed");
	}

	/*
	 * Author: DileepMothe
	 * Description: This method is used to click on Resource link from HomePage
	 */
	public void clickOnResourcesLink() {
		Elements.clickObject(ResourcesLink, "Resources Link");
	}

	/*
	 * Author: DileepMothe
	 * Description: This method is used to AcceptAllCookies button
	 */
	public void AcceptAllCookies() {
		WebDriverWait wait = new WebDriverWait(Base.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(AcceptAllCookies));
		Elements.clickObject(AcceptAllCookies, "AcceptAllCookies");
	}
}
