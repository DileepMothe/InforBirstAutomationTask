package com.birst.infor.Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.birst.infor.automation.base.Base;
import com.birst.infor.automation.pages.BirstHomePage;
import com.birst.infor.automation.pages.BirstResourcesPage;
import com.birst.infor.automation.pages.GooglePage;

public class AutomationTask {
	public BirstHomePage homePage = new BirstHomePage();
	public BirstResourcesPage resourcePage = new BirstResourcesPage();
	public GooglePage googlePage = new GooglePage();

	@BeforeSuite
	public void BeforeSuite() {
		Base.startBrowser();
		Base.maxiMizeWindow();
		Base.driver.manage().deleteAllCookies();
	}

	@AfterSuite
	public void AfterSuite() {
		Base.CloseBrowser();
	}

	@Test(priority=1)
	public void vefiryGooglePageTitleAndClickingOnBirstInforLink() throws InterruptedException {
		googlePage.navigateToGoogleSiteAndverifyTittle();
		googlePage.searchText("Birst.com");
		googlePage.clickBirstInforLinkIfExists();
	}
	
	@Test(priority=2)
	public void verifyInforLogoOnPage() throws InterruptedException {
		homePage.AcceptAllCookies();
		homePage.verifyInforLogo();
		
	}
	@Test(priority=3)
	public void verifyNavigateToResourcePageAndValidateWebinarText() throws InterruptedException {
		homePage.clickOnResourcesLink();
		resourcePage.selectValueFromAllProductDropdown("Birst");
		resourcePage.selectValueFromAllAssertsDropdown("Past Webinars");
		resourcePage.VerifyWebinarExists();
	}
}
