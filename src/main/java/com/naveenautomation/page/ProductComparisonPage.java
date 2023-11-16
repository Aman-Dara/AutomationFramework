package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class ProductComparisonPage extends Page {
	
	private static final String PAGE_URL = "/opencart/index.php?route=product/compare";

	public ProductComparisonPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private static By productComparisonText = By.cssSelector("#content>h1");
	
	public String getComparisonBannerText() {
		return ((ProxyDriver) wd).getText(productComparisonText);
	}
	
	public void getDataFromWebTables() {
		
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
	public ProductComparisonPage get() {
		return (ProductComparisonPage) super.get();
	}

}
