package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class AddressPage extends Page {

	public AddressPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/opencart/index.php?route=account/address";

	private static By newAddressBtn = By.xpath("//a[text()='New Address']");
	private static By addressAddedSuccessMsg = By.cssSelector("div[class = 'alert alert-success alert-dismissible']");
	private static By editButton = By.xpath("//a[text()='Edit']");
	public static By adressUpdateSuccessMsg = By.cssSelector("#account-address>div");

	public GeneralPage addAddress() {
		((ProxyDriver) wd).click(newAddressBtn);
		return this.waitForPageToLoad(AddAddressPage.class, AddressPage.class);
	}
	
	public GeneralPage clickEditBtn() {
		((ProxyDriver) wd).click(editButton);	
		return this.waitForPageToLoad(AddAddressPage.class, AddressPage.class);
	}

	public GeneralPage getAddAddressSuccessMessage() {
		((ProxyDriver) wd).getText(addressAddedSuccessMsg);
		return this.waitForPageToLoad(AddAddressPage.class, AddressPage.class);
	}
	
	public GeneralPage getAddressUpdateSuccessMessage() {
		((ProxyDriver) wd).getText(adressUpdateSuccessMsg);
		return this.waitForPageToLoad(AddAddressPage.class, AddressPage.class);
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
	public AddressPage get() {
		return (AddressPage) super.get();
	}

}
