package com.naveenautomation.pagetest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountLoginPage;
import com.naveenautomation.page.AccountPage;
import com.naveenautomation.page.AddAddressPage;
import com.naveenautomation.page.AddressPage;
import com.naveenautomation.page.RightNavigationBar;
import com.naveenautomation.page.SideNavBar;

public class AddressPageTest extends TestBase {
	
	private AccountLoginPage accountLoginPage;
	private AccountPage accountPage;
	private AddressPage addressPage;
	private AddAddressPage addAddress;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd, false).get();
		accountPage = (AccountPage) accountLoginPage.submitLogin("andreas@email.com", "qwerty");
	}

	// This Page contains 2 test cases

	@Test
	public void validateIfUserCanAddNewAddress() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "Huber", "CC", "133 San Andreas ", "Street", "Toronto", "L6Z3Y3", "Canada",
				"Nunavut");
		Assert.assertEquals(addressPage.getAddAddressSuccessMessage(), " Your address has been successfully added",
				"User not able to add the address");
	}
	
	@Test
	public void validateIfUserCanEditTheAddress() {
		addressPage = (AddressPage) new SideNavBar(wd, false).OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.clickEditBtn();
		addAddress.clickContinue("Aman", "Kaur", "CC", "Stanwell", "Drive", "Brampton", "L6Z3U3", "Canada", "Nunavut");
		Assert.assertEquals(addressPage.getAddressUpdateSuccessMessage(), " Your address has been successfully updated",
				"User not able to add the address");
		
		
	}

}
