package com.ezrebclan.firstWebApp.page.head;

public class StyleBlock {

	private String identifiers = "";
	private String block = "";
	
	@Override
	public String toString() {
		return identifiers+" {\n"+block+"\n}";
	}
}
