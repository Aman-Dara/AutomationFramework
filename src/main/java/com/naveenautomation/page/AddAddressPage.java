package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.proxydriver.ProxyDriver;

public class AddAddressPage extends Page {

	public AddAddressPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/opencart/index.php?route=account/address/add";

	private static By firstNameInput = By.id("input-firstname");
	private static By lastNameInput = By.id("input-lastname");
	private static By companyInput = By.id("input-company");
	private static By address1Input = By.id("input-address-1");
	private static By address2Input = By.id("input-address-2");
	private static By cityInput = By.id("input-city");
	private static By postCodeInput = By.id("input-postcode");
	private static By selectCountry = By.id("input-country");
	private static By selectRegion = By.id("input-zone");
	private static By continueBtn = By.cssSelector("input[type='submit']");
	private static By addAddressBanner = By.cssSelector("#content>h2");
	
	
	// Error Message Locators
	private static By enterFNameErrorMsg = By.xpath("//div[text()='First Name must be between 1 and 32 characters!']");
	private static By enterLNameErrorMsg = By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']");
	private static By enterAddressErrorMsg = By.xpath("//div[text()='Address must be between 3 and 128 characters!']");
	private static By enterCityErrorMsg = By.xpath("//div[text()='City must be between 2 and 128 characters!']");
	private static By enterPostalErrorMsg = By.xpath("//div[text()='Postcode must be between 2 and 10 characters!']");
	private static By selectRegionErrorMsg = By.xpath("//div[text()='Please select a region / state!']");

	public GeneralPage clickContinue(String firstName, String lastName, String company, String address, String address2,
			String city, String postCode, String country, String region) {
		((ProxyDriver) wd).sendKeys(firstNameInput, firstName);
		((ProxyDriver) wd).sendKeys(lastNameInput, lastName);
		((ProxyDriver) wd).sendKeys(companyInput, company);
		((ProxyDriver) wd).sendKeys(address1Input, address);
		((ProxyDriver) wd).sendKeys(address2Input, address2);
		((ProxyDriver) wd).sendKeys(cityInput, city);
		((ProxyDriver) wd).sendKeys(postCodeInput, postCode);
		((ProxyDriver) wd).selectItemFromDropDown(selectCountry, country);
		((ProxyDriver) wd).selectItemFromDropDown(selectRegion, region);
		//((ProxyDriver) wd).click(radioBtn);
		((ProxyDriver) wd).click(continueBtn);
		return this.waitForPageToLoad(AddAddressPage.class,AddressPage.class);
	}
	
	public String getAddAddressBannerText() {
		return((ProxyDriver) wd).getText(addAddressBanner);
	}
	public String getFirstNameErrorText() {
		return((ProxyDriver) wd).getText(enterFNameErrorMsg);
	}
	public String getLastNameErrorText() {
		return((ProxyDriver) wd).getText(enterLNameErrorMsg);
	}
	public String getAddressErrorText() {
		return((ProxyDriver) wd).getText(enterAddressErrorMsg);
	}
	public String getCityErrorText() {
		return((ProxyDriver) wd).getText(enterCityErrorMsg);
	}
	public String getPostalCodeErrorText() {
		return((ProxyDriver) wd).getText(enterPostalErrorMsg);
	}
	public String getRegionErrorText() {
		return((ProxyDriver) wd).getText(selectRegionErrorMsg);
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
	public AddAddressPage get() {
		return (AddAddressPage) super.get();
	}

}
