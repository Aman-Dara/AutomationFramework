package com.naveenautomation.page;

public enum RightNavigationBar {

	MYACCOUNT("My Account",AccountPage.class),
	EDITACCOUNT("Edit Account",EditPage.class),
	PASSWORD("Password",ChangePasswordPage.class),
	ADDRESSBOOK("Address Book",AddressPage.class),
	WISHLIST("Wish List",WishListPage.class),
	ORDERHISTORY("Order History",OrderHistoryPage.class),
	DOWNLOADS("Downloads",DownloadPage.class),
	RECURRINGPAYMENTS("Recurring payments",RecurringPaymentsPage.class),
	REWARDPOINTS("Reward Points",RewardPage.class),
	RETURNS("Returns",ReturnPage.class),
	TRANSACTIONS("Transactions",TransactionPage.class),
	NEWSLETTER("Newsletter",NewsletterPage.class),
	LOGOUT("Logout",LogoutPage.class);

	private String elementName;

	RightNavigationBar(String elementName,Class<? extends Page> pageClass) {
		this._pageClass = pageClass;
		this.elementName = elementName;
		
	}

	public String getItem() {
		return elementName;
	}
	
	private Class<? extends Page> _pageClass;

	public Class<? extends Page> getpageClass() {
		return _pageClass;
	}
	

	public static RightNavigationBar getItemByText(String text) {
		RightNavigationBar[] all = RightNavigationBar.values();
		for (int i = 0; i < all.length; i++) {
			if (all[i].name().toLowerCase().equalsIgnoreCase(text)) {
				return all[i];
			}
		}
		return null;
	}


}
