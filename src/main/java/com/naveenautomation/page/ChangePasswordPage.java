package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class ChangePasswordPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/password";

	public ChangePasswordPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By passwordInput = By.id("input-password");
	private static By confirmPasswordInput = By.id("input-confirm");
	private static By continueBtn = By.cssSelector("div>div:nth-of-type(2)>input");

	public void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(passwordInput, password);
	}

	public void confirmPassword(String confirmPswd) {
		((ProxyDriver) wd).sendKeys(confirmPasswordInput, confirmPswd);
	}

	public GeneralPage submitPasswordChange(String newPassword, String confirmPassword) {
		enterPassword(newPassword);
		confirmPassword(confirmPassword);
		((ProxyDriver) wd).click(continueBtn);
		return this.waitForPageToLoad(ChangePasswordPage.class, AccountPage.class);

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
	public ChangePasswordPage get() {
		return (ChangePasswordPage) super.get();
	}

}
