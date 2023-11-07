package com.naveenautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.naveenautomation.proxydriver.ProxyDriver;

public class OrderHistoryPage extends Page {
	
	public OrderHistoryPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/opencart/index.php?route=account/order";
	
	private static By orderHistoryBanner = By.cssSelector("#content>h1");
	private static By continueBtn = By.xpath("//a[text()='Continue']");


	public String getOrderHistoryBanner() {
		return ((ProxyDriver)wd).getText(orderHistoryBanner);	
	}

	public AccountPage clickContinue() {
		((ProxyDriver) wd).click(continueBtn);
		return new AccountPage(wd,true);
	}

	public OrderInformationPage getOrderHistoryTableData() {
		//List<WebElement> noOfRows = wd.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tr"));
		//List<WebElement> noOfColumns = wd.findElements(By.xpath("//table[@class='table table-bordered table-hover']//thead//td"));

		// table[@class='table table-bordered table-hover']//tbody//tr[1]//td[4]

				WebElement orderStatus = wd.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[1]//td[4]"));
				WebElement viewElement = wd.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[1]//td[7]"));
				if (orderStatus.getText().equals("Pending")) {
					viewElement.click();

			}
		return new OrderInformationPage(wd,true);
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
	public OrderHistoryPage get() {
		return (OrderHistoryPage) super.get();
	}

}
