package com.naveenautomation.browsers;

public enum Browser {

	CHROME("chrome"),
	FIREFOX("firefox"),
	EDGE("edge"),
	SAFARI("safari");

	private String browser;

	Browser(String browser) {
		this.browser = browser;
	}

	public String getBrowser() {
		return browser;
	}

}
