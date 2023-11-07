package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class AccountCreatedSuccessPage extends Page{
	
	private  String PAGE_URL = "/opencart/index.php?route=account/success";
	
	public AccountCreatedSuccessPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		// TODO Auto-generated constructor stub
	}

	private static By accountCreatedBanner = By.cssSelector("#content>h1");
	private static By continueBtn = By.xpath("//a[text()='Continue']");;
	
	public String getAccountCreatedBanner() {
		return ((ProxyDriver) wd).getText(accountCreatedBanner);
	}
	
	public AccountPage clickContinue() {
		((ProxyDriver) wd).click(continueBtn);
		return new AccountPage(wd,true);
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
	public AccountCreatedSuccessPage get() {
		return (AccountCreatedSuccessPage) super.get();
	}
}
