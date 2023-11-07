package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class EditPage extends Page {
	
	private static final String PAGE_URL = "/opencart/index.php?route=account/edit";

	public EditPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private static By firstNameInput = By.id("input-firstname");
	private static By lastNameInput = By.id("input-lastname");
	private static By emailInput = By.id("input-email");
	private static By telePhoneInput = By.id("input-telephone");
	private static By submitBtn = By.cssSelector("input[value='Continue']");


	public void enterFName(String name) {
		((ProxyDriver)wd).clear(firstNameInput);
		((ProxyDriver) wd).sendKeys(firstNameInput, name);
	}

	public void enterLName(String lname) {
		((ProxyDriver)wd).clear(lastNameInput);
		((ProxyDriver) wd).sendKeys(lastNameInput, lname);
	}

	public void enterEmail(String email) {
		((ProxyDriver)wd).clear(emailInput);
		((ProxyDriver) wd).sendKeys(emailInput, email);
	}

	public void enterTelephone(String number) {
		((ProxyDriver)wd).clear(telePhoneInput);
		((ProxyDriver) wd).sendKeys(telePhoneInput, number);
	}

	public AccountPage clickSubmitBtn() {
		((ProxyDriver) wd).click(submitBtn);
		return new AccountPage(wd,true);

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
	public EditPage get() {
		return (EditPage) super.get();
	}


}
