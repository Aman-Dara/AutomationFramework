package com.naveenautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.naveenautomation.base.TestBase;
import com.titusfortner.logging.SeleniumLogger;

public class WebdriverEvents extends TestBase implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		SeleniumLogger.enable("Before accepting Alerts");

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		SeleniumLogger.enable("Accepted Alerts");

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		SeleniumLogger.enable("Dismissed Alerts");

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		SeleniumLogger.enable("Navigating to " + url);

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		SeleniumLogger.enable("Navigated to " + url);

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		SeleniumLogger.enable("Page Refresh");

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		SeleniumLogger.enable("Finding element using " + by);

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		SeleniumLogger.enable("Found element using " + by);

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		SeleniumLogger.enable("Clicking on " + element.getText());

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		SeleniumLogger.enable("Clicked on " +element);

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		SeleniumLogger.enable("Getting text on " + element.getText());

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		SeleniumLogger.enable("Got text on " + element.getText());

	}

}