package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class VoucherPage extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/voucher";

	public VoucherPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static  By nameInput = By.id("input-to-name");
	private static  By emailInput = By.id("input-to-email");
	private static  By yourNameInput = By.id("input-from-name");
	private static  By yourEmailInput = By.id("input-from-email");
	private static  By giftCertTheme = By.cssSelector("input[name='voucher_theme_id']");
	private static  By inputMsg = By.id("input-message");
	private static  By amount = By.id("input-amount");
	private static  By checkbox = By.cssSelector("input[type='checkbox']");
	private static  By submitBtn = By.cssSelector("input[type='submit']");
	private static  By invalidrecipientsNameWarning = By.cssSelector("div.text-danger");
	private static  By invalidrecipientsEmailWarning = By.cssSelector("div.text-danger");
	private static  By giftCertificateWarning = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	public String invalidrecipientsNameWarningText() {
		return ((ProxyDriver) wd).getText(invalidrecipientsNameWarning);
	}

	public String invalidrecipientsEmailWarningText() {
		return ((ProxyDriver) wd).getText(invalidrecipientsEmailWarning);
	}

	public String giftCertificateWarningText() {
		return ((ProxyDriver) wd).getText(giftCertificateWarning);
	}

	public void enterRecipientsName(String recipientName) {
		((ProxyDriver) wd).sendKeys(nameInput, recipientName);
	}

	public void enterRecipientsEmail(String recipientEmail) {
		((ProxyDriver) wd).sendKeys(emailInput, recipientEmail);
	}

	public void enterYourName(String name) {
		((ProxyDriver) wd).sendKeys(yourNameInput, name);
	}

	public void enterYourEmail(String email) {
		((ProxyDriver) wd).sendKeys(yourEmailInput, email);
	}

	public void clickGiftTheme() {
		((ProxyDriver) wd).click(giftCertTheme);
	}

	public void enterGiftMessage(String msg) {
		((ProxyDriver) wd).sendKeys(inputMsg, msg);
	}

	public void enterGiftAmount(String enterAmount) {
		((ProxyDriver) wd).clear(amount);
		((ProxyDriver) wd).sendKeys(amount, enterAmount);
	}

	public void clickCheckBox() {
		((ProxyDriver) wd).click(checkbox);
	}

	public GeneralPage clickSubmitBtn() {
		((ProxyDriver) wd).click(submitBtn);
		return this.waitForPageToLoad(SuccessPage.class,VoucherPage.class);
	}

	public void enterDetails(String recipientName, String recipientEmail, String name, String email, String msg, String amount) {
		enterRecipientsName(recipientName);
		enterRecipientsEmail(recipientEmail);
		enterYourName(name);
		enterYourEmail(email);
		clickGiftTheme();
		enterGiftMessage(msg);
		enterGiftAmount(amount);

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
