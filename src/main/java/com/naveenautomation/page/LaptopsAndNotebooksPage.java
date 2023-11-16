package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class LaptopsAndNotebooksPage extends Page{
	
	private static final String PAGE_URL = "/opencart/index.php?route=product/category&path=18";

	public LaptopsAndNotebooksPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private static By LaptopBanner = By.cssSelector("#content>h2");
	private static By HpLaptop = By.xpath("//span[text()='Add to Cart']");
	
	public String getLaptopBannerText() {
		return ((ProxyDriver)wd).getText(LaptopBanner);
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
	public LaptopsAndNotebooksPage get() {
		return (LaptopsAndNotebooksPage) super.get();
	}

}
