package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class DownloadPage extends Page {
	
	private  static final String PAGE_URL = "/opencart/index.php?route=account/download";

	public DownloadPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private static By downloadBanner = By.cssSelector("#content>h2");
	private static By continueBtn = By.xpath("//a[text()='Continue']");
	
	public GeneralPage clickContinue() {
		((ProxyDriver)wd).click(continueBtn);
		return this.waitForPageToLoad(AccountPage.class,DownloadPage.class);
	}
	
	public String getDownloadBannerText() {
		return ((ProxyDriver)wd).getText(downloadBanner);
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
	public AddAddressPage get() {
		return (AddAddressPage) super.get();
	}
}
