package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.proxydriver.ProxyDriver;

public class CamerasPage extends Page {
	
	private static final String PAGE_URL = "/opencart/index.php?route=product/category&path=33";

	public CamerasPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private static By canonComparisonButton = By.cssSelector("div.button-group>button:nth-of-type(3)");
	private static By nikonComparisonButton = By.cssSelector("#content>div:nth-of-type(2)>div:last-of-type>div>div:nth-of-type(2)>div.button-group>button:last-of-type");
	private static By productComparison = By.xpath("//a[text()='product comparison']");
	private static By nikonCameraTextLink  = By.cssSelector("#content>div:nth-of-type(2)>div:last-of-type>div>div:nth-of-type(2)>div>h4>a");
	
	public GeneralPage clickProductComparison() {
		((ProxyDriver) wd).click(canonComparisonButton);
		((ProxyDriver) wd).click(nikonComparisonButton);
		((ProxyDriver) wd).click(productComparison);
		return this.waitForPageToLoad(ProductComparisonPage.class,CamerasPage.class);
	}

	public GeneralPage clickOnNikonCamera() {
		((ProxyDriver) wd).click(nikonCameraTextLink);
		return this.waitForPageToLoad(NikonD300Page.class, CamerasPage.class);
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
	public CamerasPage get() {
		return (CamerasPage) super.get();
	}

}
