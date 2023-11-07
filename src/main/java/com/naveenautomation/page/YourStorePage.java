package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class YourStorePage extends Page {

	public YourStorePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final String PAGE_URL = "/opencart/index.php?route=common/home";

	private static By featuredBanner = By.cssSelector("#content>h3");

	public String featuredText() {
		return ((ProxyDriver) wd).getText(featuredBanner);
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
	public YourStorePage get() {
		return (YourStorePage) super.get();
	}

}
