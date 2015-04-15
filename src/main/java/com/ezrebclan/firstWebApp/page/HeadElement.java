package com.ezrebclan.firstWebApp.page;

import com.ezrebclan.firstWebApp.HTMLElement;
import com.ezrebclan.firstWebApp.page.head.ScriptElement;
import com.ezrebclan.firstWebApp.page.head.StyleElement;

public class HeadElement extends HTMLElement {

	private ScriptElement[] scriptSection = new ScriptElement[0];
	private StyleElement[] styleSection = new StyleElement[0];

	
	@Override
	public String toHTML() {
		String html = "<head>\n";
		for (int i = 0; i < scriptSection.length; i++) {
			if(i==0) {
				html += scriptSection[i].toHTML();
			} else {
				html += "\n"+scriptSection[i].toHTML();
			}
		}
		html += "\n\n";
		for (int i = 0; i < styleSection.length; i++) {
			if(i==0) {
				html += styleSection[i].toHTML();
			} else {
				html += "\n"+styleSection[i].toHTML();
			}
		}
		html += "\n</head>";
		return html;
	}


	/**
	 * @return the scriptSection
	 */
	public ScriptElement[] getScriptSection() {
		return scriptSection;
	}


	/**
	 * @param scriptSection the scriptSection to set
	 */
	public void setScriptSection(ScriptElement[] scriptSection) {
		this.scriptSection = scriptSection;
	}


	/**
	 * @return the styleSection
	 */
	public StyleElement[] getStyleSection() {
		return styleSection;
	}


	/**
	 * @param styleSection the styleSection to set
	 */
	public void setStyleSection(StyleElement[] styleSection) {
		this.styleSection = styleSection;
	}
}
