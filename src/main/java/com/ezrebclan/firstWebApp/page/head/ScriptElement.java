package com.ezrebclan.firstWebApp.page.head;

import com.ezrebclan.firstWebApp.HTMLElement;

public class ScriptElement extends HTMLElement {

	private ScriptFunction[] functions = new ScriptFunction[0];
	private String autorun = "";
	
	/**
	 * @return the functions
	 */
	public ScriptFunction[] getFunctions() {
		return functions;
	}

	/**
	 * @param functions the functions to set
	 */
	public void setFunctions(ScriptFunction[] functions) {
		this.functions = functions;
	}

	/**
	 * @return the autorun
	 */
	public String getAutorun() {
		return autorun;
	}

	/**
	 * @param autorun the autorun to set
	 */
	public void setAutorun(String autorun) {
		this.autorun = autorun;
	}

	@Override
	public String toHTML() {
		String html = "<script>\n";
		for (int i = 0; i < this.functions.length; i++) {
			if(i == 0) {
				html += this.functions[i].toString()+"\n";
			} else {
				html += this.functions[i].toString()+"\n";
			}
		}
		html += this.autorun+"\n</script>";
		return html;
	}

	
}
