package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class OrderInformationPage extends Page {

	public OrderInformationPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/opencart/index.php?route=account/order/info&order_id=3733";

	private static By continueBtn = By.xpath("//a[text()='Continue']");
	private static By orderHistoryBanner = By.cssSelector("#content>h2");

	public OrderHistoryPage clickContinue() {
		((ProxyDriver) wd).click(continueBtn);
		return new OrderHistoryPage(wd, true);
	}

	public String getOrderHistoryText() {
		return ((ProxyDriver) wd).getText(orderHistoryBanner);
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
	public OrderInformationPage get() {
		return (OrderInformationPage) super.get();
	}

}
