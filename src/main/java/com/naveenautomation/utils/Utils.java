package com.naveenautomation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.naveenautomation.base.TestBase;


public class Utils extends TestBase {

	/* Method to take the screenshot of the failed test */
	public static void takeFailedTestScreenShot(String testMethodName) {

		String timeStamp = getCurrentDateTimeStamp();
		File screenShotFfile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFfile,
					new File("./FailedTestCasesScreenShot\\" + "_" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}

	}

	/* Method to get the current date and time of the system */
	public static String getCurrentDateTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	}

	public static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* Method to generate the random numbers, Strings and alphabets */
	public static String generateRandomString(int cnCht) {
		return RandomStringUtils.randomAlphabetic(cnCht);
	}

	public static String generatetRandonNumbers(int cnt) {
		return RandomStringUtils.randomNumeric(cnt);
	}

	public static String generatetRandonAlphaNumeric(int cnCht) {
		return RandomStringUtils.randomAlphanumeric(cnCht);
	}

}
