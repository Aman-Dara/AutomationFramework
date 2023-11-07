package com.naveenautomation.environment;

public enum Environment {

	DEV("https://naveenautomationlabs.com/opencart/index.php?route=account/login"), 
	STAGE("https://naveenautomationlabs.com/opencart/index.php?route=account/login"), 
	QA("https://naveenautomationlabs.com/opencart/index.php?route=account/login"), 
	PROD("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

	private String url;

	Environment(String url) {
		this.url = url;
	}

	public String getURL() {
		return url;
	}

}
