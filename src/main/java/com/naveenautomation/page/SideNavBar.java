package com.naveenautomation.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.proxydriver.ProxyDriver;

public class SideNavBar extends Page{

	public SideNavBar(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

	public Page OpenPageByClickOnSideNavBar(RightNavigationBar item) {
		List<WebElement> sideBarItems = wd.findElements(By.cssSelector("div.list-group a"));

		for (WebElement webElement : sideBarItems) {
			if (webElement.getText().trim().equalsIgnoreCase(item.getItem())) {
				((ProxyDriver) wd).click(webElement);
				return (Page) this.waitForPageToLoad(item.getpageClass());
			}
		}
		return null;
	}
}
