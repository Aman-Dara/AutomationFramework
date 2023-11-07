package com.naveenautomation.page;

public enum TopNavigationBar {

	DESKTOPS("Desktops", MacDesktopPage.class),
	// LAPTOPSANDNOTEBOOKS("Laptops & Notebooks"),
	COMPONENTS("Components", MonitorsPage.class);
	//TABLETS("Tablets"),
	// SOFTWARE("Software"),
	// PHONESANDPDAS("Phones & PDAs"),
	// CAMERAS("Cameras"),
	// MP3PLAYERS("MP3 Players");

	private String elementName;

	TopNavigationBar(String elementName, Class<? extends Page> pageClass) {
		this.elementName = elementName;
		this._pageClass = pageClass;
	}

	public String getElement() {
		return elementName;
	}

	private Class<? extends Page> _pageClass;

	public Class<? extends Page> getpageClass() {
		return _pageClass;
	}

	public static TopNavigationBar getItemByText(String text) {
		TopNavigationBar[] all = TopNavigationBar.values();
		for (int i = 0; i < all.length; i++) {
			if (all[i].name().toLowerCase().equalsIgnoreCase(text)) {
				return all[i];
			}
		}
		return null;
	}

}
