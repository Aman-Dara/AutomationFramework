package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class LogoutPage extends Page {

	public LogoutPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/opencart/index.php?route=account/logout";

	private static By acctLogoutText = By.xpath("//h1[text()='Account Logout']");
	private static By loggedOffText = By.cssSelector("#content>p:first-of-type");
	private static By cartText = By.cssSelector("#content>p:nth-of-type(2)");
	private static By continueBtn = By.xpath("//a[text()='Continue']");

	public String logoutText() {
		return ((ProxyDriver) wd).getText(acctLogoutText);

	}

	public String loggedOfText() {
		return ((ProxyDriver) wd).getText(loggedOffText);
	}

	public String cartText() {
		return ((ProxyDriver) wd).getText(cartText);

	}

	public YourStorePage continueTologoutFromAccount() {
		((ProxyDriver) wd).click(continueBtn);
		return new YourStorePage(wd, true);
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
	public LogoutPage get() {
		return (LogoutPage) super.get();
	}

}
