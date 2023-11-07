package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;


public class MacDesktopPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=product/category&path=20_27";

	public MacDesktopPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static By addToWishlist = By.cssSelector("div.button-group>button:nth-of-type(2)");
	private static By wishListUpdateSuccessMsg = By.cssSelector("div[class = 'alert alert-success alert-dismissible']");
	private static By monitorsOption = By.xpath("//a[text()='Monitors (2)']");

	public void addProductToWishList() {
		((ProxyDriver) wd).click(addToWishlist);
	}

	public String getWishListUpdateSuccessMsg() {
		return ((ProxyDriver) wd).getText(wishListUpdateSuccessMsg);
	}

	public MonitorsPage navigateToMonitorsPage() {
		//selectFromTopNavigationBar(TopNavigationBar.COMPONENTS);
		((ProxyDriver) wd).click(monitorsOption);
		return new MonitorsPage(wd, true);
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
	public MacDesktopPage get() {
		return (MacDesktopPage) super.get();
	}

}
