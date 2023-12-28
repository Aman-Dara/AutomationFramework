package com.naveenautomation.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountLoginPage;
import com.naveenautomation.page.SuccessPage;
import com.naveenautomation.page.VoucherPage;

public class VoucherPageTest extends TestBase {

	private AccountLoginPage accountLoginPage;
	private VoucherPage voucherPage;
	private SuccessPage successPage;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd, false).get();
	}

	@Test(enabled=false)
	public void validateIfUserCanPurchaseGiftCertificate() {
		voucherPage = accountLoginPage.clickOnGiftCertificate();
		successPage = (SuccessPage) voucherPage.enterDetailsAndSubmit("Andreas", "andreas@email.com", "Andreas",
				"andreas@email.com", "Happy Holidays", "1");
		Assert.assertEquals(successPage.giftVoucherSuccessMsgText(),
				"Thank you for purchasing a gift certificate! Once you have completed your order your gift certificate recipient will be sent an e-mail with details how to redeem their gift certificate.",
				"User not able to purchase Gift Certificate");
	}

	@Test(enabled=false)
	public void validateWarningWithInvalidRecipientName() {
		voucherPage = accountLoginPage.clickOnGiftCertificate();
		voucherPage.enterDetailsAndSubmit("", "andreas@email.com", "Andreas", "andreas@email.com", "Happy Holidays",
				"1");
		Assert.assertEquals(voucherPage.invalidrecipientsNameWarningText(),
				"Recipient's Name must be between 1 and 64 characters!", "User not able to purchase Gift Certificate");
	}

	@Test(enabled=false)
	public void validateWarningWithInvalidRecipientEmail() {
		voucherPage = accountLoginPage.clickOnGiftCertificate();
		voucherPage.enterDetailsAndSubmit("Andreas", "andreas@email.com", "Andreas", "andreasemail.com",
				"Happy Holidays", "1");
		Assert.assertEquals(voucherPage.invalidrecipientsEmailWarningText(),
				"E-Mail Address does not appear to be valid!", "User not able to purchase Gift Certificate");
	}

	@Test(enabled = false)
	public void validateWarningIfCheckBoxIsSkipped() {
		voucherPage = accountLoginPage.clickOnGiftCertificate();
		voucherPage.enterDetailsAndSubmit("", "andreas@email.com", "Andreas", "andreas@email.com", "Happy Holidays",
				"1");
		Assert.assertEquals(voucherPage.giftCertificateWarningText(),
				"Warning: You must agree that the gift certificates are non-refundable!",
				"Unsuccessfull Gift Certificate Purchase");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
