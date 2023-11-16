package com.naveenautomation.pagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountLoginPage;
import com.naveenautomation.page.AccountPage;
import com.naveenautomation.page.LaptopsAndNotebooksPage;
import com.naveenautomation.page.TopNavBar;
import com.naveenautomation.page.TopNavigationBar;

public class LaptopsAndNotebooksPageTest extends TestBase{
	
	private AccountLoginPage accountLoginPage;
	private AccountPage accountPage;
	private LaptopsAndNotebooksPage laptopAndNotebooksPage;
	
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd,false).get();
		accountPage = (AccountPage) accountLoginPage.submitLogin("andreas@email.com", "qwerty");
	}


}
