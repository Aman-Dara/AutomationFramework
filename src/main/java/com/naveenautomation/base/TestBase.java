package com.naveenautomation.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.BeforeClass;
import com.naveenautomation.browsers.Browser;
import com.naveenautomation.environment.Environment;
import com.naveenautomation.proxydriver.ProxyDriver;
import com.naveenautomation.utils.WebdriverEvents;



public class TestBase {

	public static WebDriver wd;
	private final Browser DEFAULT_BROWSER = Browser.CHROME;
	private final Environment URL = Environment.PROD;
	private static final boolean RUN_ON_GRID = false;


	public static Logger logger;
	public WebdriverEvents events;
	public EventFiringDecorator<WebDriver> e_driver;

	@BeforeClass
	public void loggerSteup() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public void initialisation() {
		if (RUN_ON_GRID) {
			try {
				wd = new RemoteWebDriver(new URL(" http://192.168.99.1:4444"),getOptions());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
		
		switch (DEFAULT_BROWSER) {
		case CHROME:
			wd = new ProxyDriver(new ChromeDriver());
			
		case EDGE:
			wd = new ProxyDriver(new EdgeDriver());
			break;
		case FIREFOX:
			wd = new ProxyDriver(new FirefoxDriver());
			break;
		default:
			throw new IllegalArgumentException();
		}}

		// Wrap the instance
		/*e_driver = new EventFiringDecorator(wd);

		// Events which need to be captured
		events = new WebdriverEvents();
		e_driver.register(events);

		// Assigning back the value to Web driver
		wd = e_driver;*/
		/* Loading the page 
		//wd.get(URL.name());

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
