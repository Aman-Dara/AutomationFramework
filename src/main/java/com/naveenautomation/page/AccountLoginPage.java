package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class AccountLoginPage extends Page {

	private static String PAGE_URL = "/opencart/index.php?route=account/login";

	public AccountLoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By emailInput = By.id("input-email");
	private static By passwordInput = By.id("input-password");
	private static By loginBtn = By.cssSelector("input[type='submit']");
	private static By forgottenPassword = By.cssSelector("form>div:nth-of-type(2)>a");
	private static By alertBanner = By.cssSelector(".alert-danger");
	private static By passChangeSuccessMessage = By.cssSelector("#account-login>div:first-of-type");
	private static By newCustRegisterAccountContinueBtn = By.xpath("//a[text()='Continue']");
	private static By giftCertificates = By.xpath("//a[text()='Gift Certificates']");

	public GeneralPage submitLogin(String email, String password) {
		((ProxyDriver) wd).sendKeys(emailInput, email);
		((ProxyDriver) wd).sendKeys(passwordInput, password);
		((ProxyDriver) wd).click(loginBtn);
		return this.waitForPageToLoad(AccountPage.class,AccountLoginPage.class);
	}
	
	public VoucherPage clickOnGiftCertificate() {
		((ProxyDriver) wd).click(giftCertificates);
		return new VoucherPage(wd,true);
	}


	public ForgottenPasswordPage clickOnForgotPassword() {
		((ProxyDriver) wd).click(forgottenPassword);
		return new ForgottenPasswordPage(wd,true);
	}

	public String getPasswordChangeSuccessMessage() {
		return ((ProxyDriver) wd).getText(passChangeSuccessMessage);
	}

	public String getAlertText() {
		return ((ProxyDriver) wd).getText(alertBanner);
	}

	public RegisterAccountPage clickContinueBtn() {
		((ProxyDriver) wd).click(newCustRegisterAccountContinueBtn);
		return new RegisterAccountPage(wd, true);
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
	public AccountLoginPage get() {
		return (AccountLoginPage) super.get();
	}

}
