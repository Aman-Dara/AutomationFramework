package com.naveenautomation.pagetest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;

public class HandlingWebTables extends TestBase {

	@Test
	public void testingWebTable() {
		initialisation();

		List<WebElement> noOfRows = wd.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
		List<WebElement> noOfColumns = wd.findElements(By.xpath("//table[@id='customers']//tbody//tr//th"));
		System.out.println("No of rows: " + noOfRows.size());
		System.out.println("No of colums: " + noOfColumns.size());

		String beforeXpath = "//table[@id='customers']//tbody//tr[";
		//table[@id='customers']//tbody//tr[4]//td[2]
		String afterXapth = "]//td[";

		for (int i = 2; i <= noOfRows.size(); i++) {
			for (int j = 1; j <= noOfColumns.size(); j++) {
				WebElement finalWebElement = wd.findElement(By.xpath(beforeXpath + i + afterXapth + j + "]"));
				if (finalWebElement.getText().equals("Canada")) {
					Assert.assertEquals(finalWebElement.getText(), "Canada");
					break;
				}
			}

		}
		wd.quit();

	}
}