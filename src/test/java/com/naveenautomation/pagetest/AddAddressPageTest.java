package com.naveenautomation.pagetest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountLoginPage;
import com.naveenautomation.page.AccountPage;
import com.naveenautomation.page.AddAddressPage;
import com.naveenautomation.page.AddressPage;
import com.naveenautomation.page.RightNavigationBar;
import com.naveenautomation.page.SideNavBar;

public class AddAddressPageTest extends TestBase {

	private AddressPage addressPage;
	private AddAddressPage addAddress;
	private AccountLoginPage accountLoginPage;
	private AccountPage accountPage;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd, false).get();
		accountPage = (AccountPage) accountLoginPage.submitLogin("andreas@email.com", "qwerty");
	}

	// This Page contains 12 test cases

	@Test
	@Ignore
	public void validateIfUserCanAddAddressWithoutFirstName() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue(" ", "Huber", "CC", "133 San Andreas ", "Street", "Toronto", "L6Z3Y3",
				"United Kingdom", "Angus");
		Assert.assertEquals(addAddress.getFirstNameErrorText(), "First Name must be between 1 and 32 characters!",
				"First Name can't be empty");
	}

	@Test
	@Ignore
	public void validateIfUserCanAddMorehan32CharInFirstName() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("ABCDEFGHIJKLMNOPQRSTUVWXYZQWERTYU ", "Huber", "CC", "133 San Andreas ", "Street",
				"Toronto", "L6Z3Y3", "United Kingdom", "Angus");
		Assert.assertEquals(addAddress.getFirstNameErrorText(), "First Name must be between 1 and 32 characters!",
				"First Name can't be more than 32 characters");
	}

	@Test
	@Ignore
	public void validateIfUserCanAddAddressWithoutLastName() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "", "CC", "133 San Andreas ", "Street", "Toronto", "L6Z3Y3",
				"United Kingdom", "Angus");
		Assert.assertEquals(addAddress.getLastNameErrorText(), "Last Name must be between 1 and 32 characters!",
				"Last Name can't be empty");
	}

	@Test
	@Ignore
	public void validateIfUserCanAddMorethan32CharsInLastName() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "ABCDEFGHIJKLMNOPQRSTUVWXYZQWERTYU", "CC", "133 San Andreas ", "Street",
				"Toronto", "L6Z3Y3", "United Kingdom", "Angus");
		Assert.assertEquals(addAddress.getLastNameErrorText(), "Last Name must be between 1 and 32 characters!",
				"Last Name can't be more than 32 characters");
	}

	@Test
	@Ignore
	public void validateIfUserCanAddAddressWithoutStreetName() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "Huber", "CC", "", "Street", "Toronto", "L6Z3Y3", "United Kingdom",
				"Angus");
		Assert.assertEquals(addAddress.getAddressErrorText(), "Address must be between 3 and 128 characters!",
				"Address can't be empty");
	}

	@Test
	@Ignore
	public void validateIfUserCanAddAddressWithoutCityName() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "Huber", "CC", "133 San Andreas", "Street", "", "L6Z3Y3", "United Kingdom",
				"Angus");
		Assert.assertEquals(addAddress.getCityErrorText(), "City must be between 2 and 128 characters!",
				"City can't be empty");
	}

	@Test
	@Ignore
	public void validateIfUserCanAddCityWithLessThan2Char() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "Huber", "CC", "133 San Andreas", "Street", "T", "L6Z3Y3", "United Kingdom",
				"Angus");
		Assert.assertEquals(addAddress.getCityErrorText(), "City must be between 2 and 128 characters!",
				"City name can't be less than 2 characters");
	}

	@Test
	@Ignore
	public void validateIfUserCanAddAddressWithoutPostalCode() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "Huber", "CC", "133 San Andreas", "Street", "Toronto", "", "United Kingdom",
				"Angus");
		Assert.assertEquals(addAddress.getPostalCodeErrorText(), "Postcode must be between 2 and 10 characters!",
				"Postal code can't be empty");
	}

	@Test
	@Ignore
	public void validateIfUserCanAdd11CharsInPostalCode() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "Huber", "CC", "133 San Andreas", "Street", "Toronto", "L223FG12345",
				"United Kingdom", "Angus");
		Assert.assertEquals(addAddress.getPostalCodeErrorText(), "Postcode must be between 2 and 10 characters!",
				"Postal code can't be more than 10 digits");
	}

	@Test
	@Ignore
	public void validateIfUserCanAdd1CharInPostalCode() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "Huber", "CC", "133 San Andreas", "Street", "Toronto", "L",
				"United Kingdom", "Angus");
		Assert.assertEquals(addAddress.getPostalCodeErrorText(), "Postcode must be between 2 and 10 characters!",
				"Postal code can't be less than 1 character");
	}

	@Test
	@Ignore
	public void validateIfUserCanAddAddressWithoutRegion() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("Andreas", "Huber", "CC", "133 San Andreas", "Street", "Toronto", "L6Z3Y3",
				"United Kingdom", "");
		Assert.assertEquals(addAddress.getRegionErrorText(), "Please select a region / state!",
				"Select region from dropDown");
	}

	@Test
	@Ignore
	public void validateIfUserCanContinueWithoutEnteringAnyField() {
		addressPage = (AddressPage) new SideNavBar(wd, false)
				.OpenPageByClickOnSideNavBar(RightNavigationBar.ADDRESSBOOK);
		addAddress = (AddAddressPage) addressPage.addAddress();
		Assert.assertEquals(addAddress.getAddAddressBannerText(), "Add Address", "Add Address Page not loaded");
		addAddress.clickContinue("", "", "", "", "", "", "", "United Kingdom", "");
		Assert.assertEquals(addAddress.getFirstNameErrorText(), "First Name must be between 1 and 32 characters!",
				"First Name can't be empty");
		Assert.assertEquals(addAddress.getLastNameErrorText(), "Last Name must be between 1 and 32 characters!",
				"Last Name can't be empty");
		Assert.assertEquals(addAddress.getAddressErrorText(), "Address must be between 3 and 128 characters!",
				"Address can't be empty");
		Assert.assertEquals(addAddress.getCityErrorText(), "City must be between 2 and 128 characters!",
				"City can't be empty");
		Assert.assertEquals(addAddress.getPostalCodeErrorText(), "Postcode must be between 2 and 10 characters!",
				"Postal code can't be empty");
		Assert.assertEquals(addAddress.getRegionErrorText(), "Please select a region / state!",
				"Select region from dropDown");
	}

}
