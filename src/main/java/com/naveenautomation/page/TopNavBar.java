package com.naveenautomation.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.proxydriver.ProxyDriver;

public class TopNavBar extends Page {
	
	public TopNavBar(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

	public Page OpenPageByClickOnSideNavBar(TopNavigationBar item) {
		List<WebElement> sideBarItems = wd.findElements(By.cssSelector("ul.nav>li"));

		for (WebElement webElement : sideBarItems) {
			if (webElement.getText().trim().equalsIgnoreCase(item.getElement())) {
				((ProxyDriver) wd).click(webElement);
				return (Page) this.waitForPageToLoad(item.getpageClass());
			}
		}
		return null;
	}

}
