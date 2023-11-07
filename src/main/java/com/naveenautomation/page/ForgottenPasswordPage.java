package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class ForgottenPasswordPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/forgotten";

	public ForgottenPasswordPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By forgotPswdText = By.xpath("//h1[text()='Forgot Your Password?']");
	private static By emailInput = By.id("input-email");
	private static By continueBtn = By.cssSelector("input[type='submit']");
	private static By emailErrorMsg = By.cssSelector("#account-forgotten>div:first-of-type");

	public String forgotPasswordBanner() {
		return ((ProxyDriver) wd).getText(forgotPswdText);
	}

	public String enterEmailErrorMessage() {
		return ((ProxyDriver) wd).getText(emailErrorMsg);
	}

	public GeneralPage enterEmail(String email) {
		((ProxyDriver) wd).sendKeys(emailInput, email);
		((ProxyDriver) wd).click(continueBtn);
		return this.waitForPageToLoad(ForgottenPasswordPage.class, AccountLoginPage.class);
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
	public ForgottenPasswordPage get() {
		return (ForgottenPasswordPage) super.get();
	}

}
