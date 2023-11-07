package com.naveenautomation.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.naveenautomation.proxydriver.ProxyDriver;

public class WishListPage extends Page {

	public WishListPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/opencart/index.php?route=account/wishlist";

	private static By continueBtn = By.xpath("//a[text()='Continue']");

	public AccountPage getDataFromWishListTable() {
		List<WebElement> noOfRows = wd
				.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
		List<WebElement> noOfColumns = wd
				.findElements(By.xpath("//table[@class='table table-bordered table-hover']//thead//td"));

		// table[@class='table table-bordered table-hover']//tbody//tr[2]//td[6]

		String beforeXpath = "//table[@class='table table-bordered table-hover']//tbody//tr[";
		String afterXpath = "]//td[";

		for (int i = 1; i <= noOfRows.size(); i++) {
			for (int j = 2; j <= noOfColumns.size() - 1; j++) {
				WebElement finalWebElement = wd.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]"));
				if (finalWebElement.getText().equals("Samsung SyncMaster 941BW")) {
					((ProxyDriver) wd).click(continueBtn);
					return new AccountPage(wd, true);
				}
			}

		}

		return null;
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
	public WishListPage get() {
		return (WishListPage) super.get();
	}

}
