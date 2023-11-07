package com.naveenautomation.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountLoginPage;
import com.naveenautomation.page.AccountPage;
import com.naveenautomation.page.ForgottenPasswordPage;
import com.naveenautomation.page.LogoutPage;
import com.naveenautomation.page.RightNavigationBar;
import com.naveenautomation.page.SideNavBar;
import com.naveenautomation.page.YourStorePage;
import com.naveenautomation.utils.ExcelUtils;

public class AccountLoginPageTest extends TestBase {

	private AccountLoginPage accountLoginPage;
	private AccountPage accountPage;
	private LogoutPage logoutPage;
	private ForgottenPasswordPage forgotPasswordPage;
	private YourStorePage yourStorePage;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd, false).get();
	}
	
	// This class contains 7 test cases

	@Test
	public void validateUserCanLoginWithValidCredentials() {
		accountPage = (AccountPage) accountLoginPage.submitLogin("andreas@email.com", "qwery");
		Assert.assertEquals(accountPage.myAccountText(), "My Account", "User not logged in");

	}

	@Test
	public void validateUserCanNotLoginWithInValidCredentials() {
		accountLoginPage = (AccountLoginPage) accountLoginPage.submitLogin("andreas@email.com", "qwerty12");
		Assert.assertEquals(accountLoginPage.getAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"User logged in");

	}

	@Test
	public void validateUserCanNotLoginWithoutEmail() {
		accountLoginPage = (AccountLoginPage) accountLoginPage.submitLogin("", "qwerty");
		Assert.assertEquals(accountLoginPage.getAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"User logged in");

	}

	@Test
	public void validateUserCanNotLoginWithoutEmailAndPassword() {
		accountLoginPage = (AccountLoginPage) accountLoginPage.submitLogin("", "");
		Assert.assertEquals(accountLoginPage.getAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"User logged in");

	}

	@Test
	public void validatingForgotPasswordFunctionality() {
		forgotPasswordPage = accountLoginPage.clickOnForgotPassword();
		forgotPasswordPage.enterEmail("andreas@email.com");
		accountLoginPage.getPasswordChangeSuccessMessage();
		Assert.assertEquals(accountLoginPage.getPasswordChangeSuccessMessage(),
				"An email with a confirmation link has been sent your email address.",
				"User not able to change the password");
	}
	
	@Test
	public void validateIfUserCanRequestPasswordWithoutEnteringEmail() {
		forgotPasswordPage = accountLoginPage.clickOnForgotPassword();
		forgotPasswordPage.enterEmail("");
		Assert.assertEquals(forgotPasswordPage.enterEmailErrorMessage(),
				"Warning: The E-Mail Address was not found in our records, please try again!",
				"User did not enter the email to continue");
	}

	@Test
	public void validateIfUserCanLogout() {
		accountPage = (AccountPage) accountLoginPage.submitLogin("andreas@email.com", "qwerty");
		logoutPage = (LogoutPage) new SideNavBar(wd, false).OpenPageByClickOnSideNavBar(RightNavigationBar.LOGOUT);
		// logoutPage = accountPage.logoutFromAccount(RightNavigationBar.LOGOUT);
		Assert.assertEquals(logoutPage.logoutText(), "Account Logout", "Logout banner not displayed");
		Assert.assertEquals(logoutPage.loggedOfText(),
				"You have been logged off your account. It is now safe to leave the computer.", "User not logged off");
		Assert.assertEquals(logoutPage.cartText(),
				"Your shopping cart has been saved, the items inside it will be restored whenever you log back into your account.",
				"User not logged out");
		yourStorePage = logoutPage.continueTologoutFromAccount();
		Assert.assertEquals(yourStorePage.featuredText(), "Featured", "User not logged out.");
	}

	@Test(dataProvider = "UserLogin")
	public void validateLoginWithMultipleUsers(String email, String password) {
		accountPage = (AccountPage) accountLoginPage.submitLogin(email, password);
		Assert.assertEquals(accountPage.myAccountText(), "My Account", "User not logged in");
	}

	@DataProvider(name = "UserLogin")
	public Object[][] getDataFromExcelSheet() throws Exception {
		String fileName = "C:\\Users\\amand\\Desktop\\UserLogin.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(fileName, sheetName);
		int cellCount = ExcelUtils.getCellCount(fileName, sheetName, rowCount);
		String virtualSheet[][] = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(fileName, sheetName, i, j);
			}
		}
		return virtualSheet;
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
