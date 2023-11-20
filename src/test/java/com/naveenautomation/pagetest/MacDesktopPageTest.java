package com.naveenautomation.pagetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountLoginPage;
import com.naveenautomation.page.AccountPage;
import com.naveenautomation.page.MacDesktopPage;
import com.naveenautomation.page.MonitorsPage;

public class MacDesktopPageTest extends TestBase {

	AccountLoginPage accountLoginPage;
	AccountPage accountPage;
	MacDesktopPage macDesktopPage;
	MonitorsPage monitorsPage;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd,false).get();
	}

	
	/*public void validateIfUserCanAddTheProductInWishList() {
		accountPage = (AccountPage) accountLoginPage.submitLogin("andreas@email.com", "qwerty");
		macDesktopPage = accountPage.chooseFromDesktop(TopNavigationBar.DESKTOPS);
		macDesktopPage.addProductToWishList();
		Assert.assertEquals(macDesktopPage.getWishListUpdateSuccessMsg(),
				" Success: You have added iMac to your wish list!", "Item has not been added to the wishlist");
	}*/

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
