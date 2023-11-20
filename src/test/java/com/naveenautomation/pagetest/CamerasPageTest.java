package com.naveenautomation.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountLoginPage;
import com.naveenautomation.page.AccountPage;
import com.naveenautomation.page.CamerasPage;
import com.naveenautomation.page.NikonD300Page;
import com.naveenautomation.page.ProductComparisonPage;
import com.naveenautomation.page.TopNavBar;
import com.naveenautomation.page.TopNavigationBar;

public class CamerasPageTest extends TestBase {

	private AccountLoginPage accountLoginPage;
	private CamerasPage camerasPage;
	private ProductComparisonPage productComparisonPage;
	private NikonD300Page nikonCameraPage;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd, false).get();
		accountLoginPage.submitLogin("andreas@email.com", "qwerty");
	}

	@Test
	@Ignore
	public void validateIfUserCanCompareTwoProduct() {
		camerasPage = (CamerasPage) new TopNavBar(wd, false).OpenPageByClickOnTopNavBar(TopNavigationBar.CAMERAS);
		productComparisonPage = (ProductComparisonPage) camerasPage.clickProductComparison();
		Assert.assertEquals(productComparisonPage.getComparisonBannerText(), "Product Comparison",
				"User able to add the item to cart");

	}

	@Test
	@Ignore
	public void validateCartAfterAdjustingProductQuantity() {
		camerasPage = (CamerasPage) new TopNavBar(wd, false).OpenPageByClickOnTopNavBar(TopNavigationBar.CAMERAS);
		nikonCameraPage = (NikonD300Page) camerasPage.clickOnNikonCamera();
		nikonCameraPage.clickAddToCart();
		nikonCameraPage.changingProductQuantity("3");
		nikonCameraPage.clickAddToCart();
		Assert.assertEquals(nikonCameraPage.cartTotalBannerText(), " 3 item(s) - $240.00",
				"User not able to change the quantity");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
