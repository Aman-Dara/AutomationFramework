package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class NikonD300Page extends Page {
	
	private static final String PAGE_URL = "/opencart/index.php?route=product/product&path=33&product_id=31";
	
	public NikonD300Page(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static  By quantity = By.id("input-quantity");
	private static  By addToCartBtn = By.id("button-cart");
	private static  By cartTotal = By.id("cart-total");

	public void changingProductQuantity(String inputQuantity) {
		((ProxyDriver)wd).click(quantity);
		((ProxyDriver) wd).clear(quantity);
		((ProxyDriver) wd).sendKeys(quantity, inputQuantity);
	}

	public void clickAddToCart() {
		((ProxyDriver) wd).click(addToCartBtn);
	}

	public String cartTotalBannerText() {
		return ((ProxyDriver) wd).getText(cartTotal);
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

}


