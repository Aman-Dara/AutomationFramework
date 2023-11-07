package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class TransactionPage extends Page {

	public TransactionPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/opencart/index.php?route=account/return";

	private static By continueBtn = By.xpath("//a[text()='Continue']");
	private static By transactionBannerText = By.cssSelector("#content>h1");

	public String getPaymentBannerText() {
		return ((ProxyDriver) wd).getText(transactionBannerText);
	}

	public GeneralPage clickContinue() {
		((ProxyDriver) wd).click(continueBtn);
		return this.waitForPageToLoad(TransactionPage.class, AccountPage.class);
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
