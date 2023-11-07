package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class RegisterAccountPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/register";

	public RegisterAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By fNameInput = By.id("input-firstname");
	private static By lNameInput = By.id("input-lastname");
	private static By emailInput = By.id("input-email");
	private static By telephoneInput = By.id("input-telephone");
	private static By passwdInput = By.id("input-password");
	private static By confirmPasswdInput = By.id("input-confirm");
	private static By checkBox = By.id("input[type='checkbox']");
	private static By continueBtn = By.id("input[type='submit']");

	public AccountCreatedSuccessPage enterUserDetails(String firstName, String lastName, String email, String phone,
			String password, String confirmPassword) {
		((ProxyDriver) wd).sendKeys(fNameInput, firstName);
		((ProxyDriver) wd).sendKeys(lNameInput, lastName);
		((ProxyDriver) wd).sendKeys(emailInput, email);
		((ProxyDriver) wd).sendKeys(telephoneInput, phone);
		((ProxyDriver) wd).sendKeys(passwdInput, password);
		((ProxyDriver) wd).sendKeys(confirmPasswdInput, confirmPassword);
		((ProxyDriver) wd).click(checkBox);
		((ProxyDriver) wd).click(continueBtn);
		return new AccountCreatedSuccessPage(wd, true);

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
	public RegisterAccountPage get() {
		return (RegisterAccountPage) super.get();
	}

}
