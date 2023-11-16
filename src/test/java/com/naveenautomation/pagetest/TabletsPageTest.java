package com.naveenautomation.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountLoginPage;
import com.naveenautomation.page.AccountPage;
import com.naveenautomation.page.ProductComparisonPage;
import com.naveenautomation.page.TabletsPage;
import com.naveenautomation.page.TopNavBar;
import com.naveenautomation.page.TopNavigationBar;

public class TabletsPageTest extends TestBase {

	private AccountLoginPage accountLoginPage;
	private AccountPage accountPage;
	private TabletsPage tabletsPage;
	private ProductComparisonPage productComparisonPage;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd, false).get();
		accountPage = (AccountPage) accountLoginPage.submitLogin("andreas@email.com", "qwerty");
	}

	@Test
	public void validateIfUserCanNavigateToTabletsPage() {
		tabletsPage = (TabletsPage) new TopNavBar(wd, false).OpenPageByClickOnTopNavBar(TopNavigationBar.TABLETS);
		Assert.assertEquals(tabletsPage.getTabletBannerText(), "Tablets", "User can see the list of Tablets");

	}

	@Test
	public void validateIfUserCanAddTabletToCart() {
		tabletsPage = (TabletsPage) new TopNavBar(wd, false).OpenPageByClickOnTopNavBar(TopNavigationBar.TABLETS);
		tabletsPage.clickAddToCart();
		Assert.assertEquals(tabletsPage.getTabletBannerText(),"Success: You have added Samsung Galaxy Tab 10.1 to your shopping cart!", "User able to add the item to cart");

	}
	
	@Test
	public void validateIfUserCanCompareTheProduct() {
		tabletsPage = (TabletsPage) new TopNavBar(wd, false).OpenPageByClickOnTopNavBar(TopNavigationBar.TABLETS);
		tabletsPage.clickComparison();
		productComparisonPage = (ProductComparisonPage) tabletsPage.clickProductComparison();
		Assert.assertEquals(productComparisonPage.getComparisonBannerText(),"Product Comparison", "User able to add the item to cart");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
