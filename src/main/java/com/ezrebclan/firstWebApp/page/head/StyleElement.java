package com.ezrebclan.firstWebApp.page.head;

import com.ezrebclan.firstWebApp.HTMLElement;

public class StyleElement extends HTMLElement {

	private StyleBlock[] styles = new StyleBlock[0];
	@Override
	public String toHTML() {
		String html = "<style>";
		for (StyleBlock style : styles) {
			html += "\n"+style.toString();
		}
		html += "\n</style>";
		return html;
	}

}
