package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class SuccessPage extends Page {
	
	private static final String PAGE_URL = "/opencart/index.php?route=account/voucher/success";

	public SuccessPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}
	private static By giftVoucherSuccessMsg = By.cssSelector("#content>p");

	public String giftVoucherSuccessMsgText() {
		return ((ProxyDriver) wd).getText(giftVoucherSuccessMsg);
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
