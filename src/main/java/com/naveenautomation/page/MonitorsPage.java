package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class MonitorsPage extends Page{
	
	private static final String PAGE_URL = "/opencart/index.php?route=product/category&path=25_28";
	
	public MonitorsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private static By addToWishlistAppleCinema = By.cssSelector("#content>div:nth-of-type(3)>div:first-of-type>div>div:last-of-type>div>button:nth-of-type(2)");
	private static By addToWishlistSamsung = By.cssSelector("#content>div:nth-of-type(3)>div:nth-of-type(2)>div>div:last-of-type>div>button:nth-of-type(2)");
	private static By myWishList = By.cssSelector("#wishlist-total");
	
	
	public WishListPage addMonitorsToWishList() {
		((ProxyDriver) wd).click(addToWishlistAppleCinema);
		((ProxyDriver) wd).click(addToWishlistSamsung);
		((ProxyDriver) wd).click(myWishList);
		return new WishListPage(wd,true);
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
	public MonitorsPage get() {
		return (MonitorsPage) super.get();
	}

	
	
	
	

}
