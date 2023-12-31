package com.naveenautomation.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomation.base.TestBase;
import com.titusfortner.logging.SeleniumLogger;

public class RetryFailedTestsListener extends TestBase implements IRetryAnalyzer {

	int cnt = 1;
	int maxCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		SeleniumLogger.enable("Retrying failed test : " + result.getMethod().getMethodName() + "for " + cnt);
		if (cnt < maxCount) {
			cnt++;
			return true;
		}

		return false;
	}

}
