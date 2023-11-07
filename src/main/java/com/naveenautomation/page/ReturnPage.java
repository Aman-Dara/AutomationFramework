package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class ReturnPage extends Page {

	public ReturnPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/opencart/index.php?route=account/return";

	private static By continueBtn = By.xpath("//a[text()='Continue']");
	private static By returnBannerText = By.cssSelector("#content>h1");

	public String getReturnBannerText() {
		return ((ProxyDriver) wd).getText(returnBannerText);
	}

	public GeneralPage clickContinue() {
		((ProxyDriver) wd).click(continueBtn);
		return this.waitForPageToLoad(ReturnPage.class, AccountPage.class);
	}

	@Override
	protected void isLoaded() {
		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public ChangePasswordPage get() {
		return (ChangePasswordPage) super.get();
	}

}
