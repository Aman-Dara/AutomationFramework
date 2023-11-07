package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class NewsletterPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/newsletter";

	public NewsletterPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static By radioNoBtn = By.cssSelector("div>label:nth-of-type(2)>input");
	private static By continueBtn = By.cssSelector("input[type='submit']");

	public void isRadioButtonSelected() {
		((ProxyDriver) wd).click(radioNoBtn);
	}

	public AccountPage newsLetterSubscription() {
		((ProxyDriver) wd).click(continueBtn);
		return new AccountPage(wd, true);
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
	public NewsletterPage get() {
		return (NewsletterPage) super.get();
	}

}
