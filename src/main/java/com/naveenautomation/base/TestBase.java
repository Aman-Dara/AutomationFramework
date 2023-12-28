package com.naveenautomation.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import com.naveenautomation.browsers.Browser;
import com.naveenautomation.environment.Environment;
import com.naveenautomation.proxydriver.ProxyDriver;

public class TestBase {

	public static WebDriver wd;
	private final Browser DEFAULT_BROWSER = Browser.CHROME;
	// public String browserType = System.getProperty("Browser");

	private final Environment URL = Environment.PROD;
	private static final boolean RUN_ON_GRID = false;
	// public static Logger logger;

	@BeforeClass
	public void loggerSteup() {

		/*
		 * logger = Logger.getLogger(TestBase.class);
		 * PropertyConfigurator.configure("log4j.properties");
		 * BasicConfigurator.configure(); // logger.setLevel(Level.INFO);
		 */

	}

	public void initialisation() {
		// String browser = System.getProperty("browser");
		if (RUN_ON_GRID) {
			try {
				wd = new RemoteWebDriver(new URL("http://10.0.0.183:4444"), getOptions());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			// switch(browser.toLowerCase()) {
			switch (DEFAULT_BROWSER) {
			// case "chrome":
			case CHROME:
				wd = new ProxyDriver(new ChromeDriver());
				break;
			// case "edge":
			case EDGE:
				wd = new ProxyDriver(new EdgeDriver());
				break;
			// case "firefox":
			case FIREFOX:
				wd = new ProxyDriver(new FirefoxDriver());
				break;
			default:
				throw new IllegalArgumentException();
			}
		}

		/* Maximize the window */
		wd.manage().window().maximize();

		wd.manage().deleteAllCookies();
	}

	public WebDriver getDriver() {
		return wd;
	}

	public MutableCapabilities getOptions() {
		return new ManageOptions().getOption(DEFAULT_BROWSER);
	}

	public void tearDown() {
		wd.quit();
	}
}
