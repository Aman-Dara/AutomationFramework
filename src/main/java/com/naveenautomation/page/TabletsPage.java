package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class TabletsPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=product/category&path=57";

	public TabletsPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By tabletBannerText = By.cssSelector("#content>h2");
	private static By addToCart = By.cssSelector("div.button-group>button>span");
	private static By addToCartSuccessMsg = By.cssSelector("div.alert");
	private static By productComparisonButton = By.cssSelector("div.button-group>button:nth-of-type(3)");
	private static By productComparison = By.xpath("//a[text()='product comparison']");

	public String getTabletBannerText() {
		return ((ProxyDriver) wd).getText(tabletBannerText);
	}

	public void clickAddToCart() {
		((ProxyDriver) wd).click(addToCart);
	}

	public void clickComparison() {
		((ProxyDriver) wd).click(productComparisonButton);
	}

	public GeneralPage clickProductComparison() {
		((ProxyDriver) wd).click(productComparison);
		return this.waitForPageToLoad(ProductComparisonPage.class,TabletsPage.class);
	}

	public String getSuccessText() {
		return ((ProxyDriver) wd).getText(addToCartSuccessMsg);
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
	public TabletsPage get() {
		return (TabletsPage) super.get();
	}

}
