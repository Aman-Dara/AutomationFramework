package com.naveenautomation.pagetest;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.page.AccountLoginPage;
import com.naveenautomation.page.AccountPage;
import com.naveenautomation.page.LaptopsAndNotebooksPage;

public class LaptopsAndNotebooksPageTest extends TestBase{
	
	private AccountLoginPage accountLoginPage;
	private AccountPage accountPage;
	private LaptopsAndNotebooksPage laptopAndNotebooksPage;
	
	public void launchBrowser() {
		initialisation();
		accountLoginPage = new AccountLoginPage(wd,false).get();
	
	}


}
