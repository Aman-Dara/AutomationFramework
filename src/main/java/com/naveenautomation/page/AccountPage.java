package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class AccountPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/account";

	public AccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By myAccBanner = By.cssSelector("#content>h2:first-of-type");
	private static By acccountInfoUpdateSuccessMessage = By.cssSelector("div.alert-success");
	private static By editYourInfoLink = By.xpath("//a[text()='Edit your account information']");
	private static By pswdChangeSuccessMessage = By.cssSelector("#account-account>div:first-of-type");
	private static By newsletterSubSuccessMessage = By.cssSelector("#account-account>div");
	private static By desktopMac = By.xpath("//a[text()='Mac (1)']");

	public String myAccountText() {
		return ((ProxyDriver) wd).getText(myAccBanner);
	}

	public GeneralPage clickEditInfoLink() {
		((ProxyDriver) wd).click(editYourInfoLink);
		return this.waitForPageToLoad(EditPage.class,AccountPage.class);
	}
	public String getSuccessMessage() {
		return ((ProxyDriver) wd).getText(acccountInfoUpdateSuccessMessage);
	}

	public String getPswdChangeSuccessMessage() {
		return ((ProxyDriver) wd).getText(pswdChangeSuccessMessage);
	}

	public String getNewsletterSubSuccessMessage() {
		return ((ProxyDriver) wd).getText(newsletterSubSuccessMessage);
	}

	public MacDesktopPage chooseFromDesktop(TopNavigationBar item) {
		((ProxyDriver) wd).click(desktopMac);
		return new MacDesktopPage(wd, true);
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
	public AccountPage get() {
		return (AccountPage) super.get();
	}

}
