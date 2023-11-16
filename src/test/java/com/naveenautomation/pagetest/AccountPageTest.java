package com.naveenautomation.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountPage;
import com.naveenautomation.page.ChangePasswordPage;
import com.naveenautomation.page.DownloadPage;
import com.naveenautomation.page.EditPage;
import com.naveenautomation.page.MacDesktopPage;
import com.naveenautomation.page.MonitorsPage;
import com.naveenautomation.page.NewsletterPage;
import com.naveenautomation.page.OrderHistoryPage;
import com.naveenautomation.page.OrderInformationPage;
import com.naveenautomation.page.RecurringPaymentsPage;
import com.naveenautomation.page.RegisterAccountPage;
import com.naveenautomation.page.ReturnPage;
import com.naveenautomation.page.RewardPage;
import com.naveenautomation.page.RightNavigationBar;
import com.naveenautomation.page.SideNavBar;
import com.naveenautomation.page.TopNavBar;
import com.naveenautomation.page.TopNavigationBar;
import com.naveenautomation.page.TransactionPage;
import com.naveenautomation.page.WishListPage;
import com.naveenautomation.utils.ExcelUtils;
import com.naveenautomation.page.AccountCreatedSuccessPage;
import com.naveenautomation.page.AccountLoginPage;

public class AccountPageTest extends TestBase {

	private AccountLoginPage accountLoginPage;
	private AccountPage accountPage;
	private EditPage editPage;
	private NewsletterPage newsletterPage;
	private ChangePasswordPage changePassword;
	private MacDesktopPage macDesktopPage;
	private RegisterAccountPage registerAcctPage;
	private AccountCreatedSuccessPage accountCreatedSuccessPage;
	private MonitorsPage monitorsPage;
	private WishListPage wishListPage;
	private OrderHistoryPage orderHistoryPage;
	private OrderInformationPage orderInfoPage;
	private DownloadPage downloadPage;
	private RecurringPaymentsPage paymentsPage;
	private RewardPage rewardPage;
	private ReturnPage returnPage;
	private TransactionPage transactionPage;
	

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd,false).get();
		accountPage = (AccountPage) accountLoginPage.submitLogin("andreas@email.com", "qwerty");
	}
	
	//12 test cases

	@Test
	public void validateUserCanUpdatePersonalInfo() {
		editPage = (EditPage) accountPage.clickEditInfoLink();
		editPage.enterFName("Andrea");
		accountPage = editPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getSuccessMessage(), "Success: Your account has been successfully updated.",
				"Info not updated");
	}

	@Test
	public void validateIfUserCanChangeThePassword() {
		changePassword = (ChangePasswordPage) new SideNavBar(wd,false).OpenPageByClickOnSideNavBar(RightNavigationBar.PASSWORD);
		accountPage = (AccountPage) changePassword.submitPasswordChange("qwerty", "qwerty");
		Assert.assertEquals(accountPage.getPswdChangeSuccessMessage(),
				"Success: Your password has been successfully updated.", "User not able to change the password");
	}

	@Test
	public void validateSubscribeOption() {
		newsletterPage = (NewsletterPage) new SideNavBar(wd,false).OpenPageByClickOnSideNavBar(RightNavigationBar.NEWSLETTER);
		newsletterPage.newsLetterSubscription();
		Assert.assertEquals(accountPage.getNewsletterSubSuccessMessage(),
				"Success: Your newsletter subscription has been successfully updated!",
				"Newsletter subscription not updated");
	}
	
	@Test(dataProvider = "UserRegistration",enabled=false)
	public void validateRegistrationWithMultipleUsers(String fName,String lName, String email, String telephone, String password, String confirmPassword) {
		registerAcctPage = accountLoginPage.clickContinueBtn();
		accountCreatedSuccessPage = registerAcctPage.enterUserDetails(fName, lName, email, telephone, password, confirmPassword);
		Assert.assertEquals(accountCreatedSuccessPage.getAccountCreatedBanner(), "Your Account Has Been Created!", "User not able to register");
		accountPage = accountCreatedSuccessPage.clickContinue();
		Assert.assertEquals(accountPage.myAccountText(), "My Account", "Registration unsuccessful");
		
	}
	
	@DataProvider(name = "UserRegistration")
	public Object[][] getDataFromExcelSheet() throws Exception {
		String fileName = "C:\\Users\\amand\\Desktop\\UserRegistration.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(fileName,sheetName);
		int cellCount = ExcelUtils.getCellCount(fileName, sheetName, rowCount);
		
		String virtualSheet[][] = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				virtualSheet[i-1][j] = ExcelUtils.getCellData(fileName, sheetName, i, j);
			}
		}
		return virtualSheet;
	}
	
	
/*	public void validateIfProductsAreAddedToTheWishList() {
		macDesktopPage =  (MacDesktopPage) new TopNavBar(wd,false).OpenPageByClickOnSideNavBar(TopNavigationBar.DESKTOPS);
		macDesktopPage.addProductToWishList();
		monitorsPage = macDesktopPage.navigateToMonitorsPage();
		wishListPage = monitorsPage.addMonitorsToWishList();
		accountPage = wishListPage.getDataFromWishListTable();
		Assert.assertEquals(accountPage.myAccountText(), "My Account", "Items not added to the wishlist");
	}*/
	
	@Test
	public void validateIfUserCanCheckOrderHistory() {
		orderHistoryPage = (OrderHistoryPage) new SideNavBar(wd,false).OpenPageByClickOnSideNavBar(RightNavigationBar.ORDERHISTORY);
		Assert.assertEquals(orderHistoryPage.getOrderHistoryBanner(), "Order History","User not able to check the history");
		accountPage = orderHistoryPage.clickContinue();
		Assert.assertEquals(accountPage.myAccountText(), "My Account", "Account Page not loaded successfully");
	}
	
	@Test
	public void validateIfUserCanViewTheOrderPlaced() {
		orderHistoryPage = (OrderHistoryPage) new SideNavBar(wd,false).OpenPageByClickOnSideNavBar(RightNavigationBar.ORDERHISTORY);
		orderInfoPage = orderHistoryPage.getOrderHistoryTableData();
		orderInfoPage.getOrderHistoryText();
		Assert.assertEquals(orderInfoPage.getOrderHistoryText(), "Order History","User not able to see previous orders");
		orderHistoryPage = orderInfoPage.clickContinue();
		accountPage = orderHistoryPage.clickContinue();
		Assert.assertEquals(accountPage.myAccountText(), "My Account", "Account Page not loaded successfully");	
	}
	
	@Test
	public void validateIfUserCanSeeDownloads() {
		downloadPage =(DownloadPage) new SideNavBar(wd,false).OpenPageByClickOnSideNavBar(RightNavigationBar.DOWNLOADS);
		Assert.assertEquals(downloadPage.getDownloadBannerText(), "Account Downloads","User not able to see downloads");
		accountPage = (AccountPage) downloadPage.clickContinue();
		Assert.assertEquals(accountPage.myAccountText(), "My Account","User not able to return to previous page");
		
	}
	@Test
	public void validateIfUserCanSeeTransactions() {
		transactionPage =(TransactionPage) new SideNavBar(wd,false).OpenPageByClickOnSideNavBar(RightNavigationBar.TRANSACTIONS);
		Assert.assertEquals(transactionPage.getPaymentBannerText(),"Your Transactions","User not able to see transactions");
		accountPage = (AccountPage) transactionPage.clickContinue();
		Assert.assertEquals(accountPage.myAccountText(), "My Account","User not able to return to previous page");
		
	}
	@Test
	public void validateIfUserCanSeeReturns() {
		returnPage =(ReturnPage) new SideNavBar(wd,false).OpenPageByClickOnSideNavBar(RightNavigationBar.RETURNS);
		Assert.assertEquals(returnPage.getReturnBannerText(),"Product Returns","User not able to see returns");
		accountPage = (AccountPage) returnPage.clickContinue();
		Assert.assertEquals(accountPage.myAccountText(), "My Account","User not able to return to previous page");
		
	}
	@Test
	public void validateIfUserCanSeeRewardPoints() {
		rewardPage =(RewardPage) new SideNavBar(wd,false).OpenPageByClickOnSideNavBar(RightNavigationBar.REWARDPOINTS);
		Assert.assertEquals(rewardPage.getRewardsBannerText(),"Your Reward Points","User not able to see reward points");
		accountPage = (AccountPage) rewardPage.clickContinue();
		Assert.assertEquals(accountPage.myAccountText(), "My Account","User not able to return to previous page");
		
	}
	@Test
	public void validateIfUserCanSeeRecurringPayments() {
		paymentsPage =(RecurringPaymentsPage) new SideNavBar(wd,false).OpenPageByClickOnSideNavBar(RightNavigationBar.RECURRINGPAYMENTS);
		Assert.assertEquals(transactionPage.getPaymentBannerText(),"Recurring Payments","User not able to see transactions");
		accountPage = (AccountPage) paymentsPage.clickContinue();
		Assert.assertEquals(accountPage.myAccountText(), "My Account","User not able to return to previous page");
		
	}
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
