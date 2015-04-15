package com.ezrebclan.firstWebApp.page;

import com.ezrebclan.firstWebApp.HTMLElement;
import com.ezrebclan.firstWebApp.page.head.ScriptElement;

public class Page extends HTMLElement {
	
	public HeadElement head;
	public String body;
	
	@Override
	public String toHTML() {
		return "<html>\n"+head.toHTML()+"\n"+"<body>\n\n\n</body>"+"\n</html>";
	}
	
	public static void main(String[] args) {
		Page p = new Page();
		p.head.scriptSection = new ScriptElement[] {new ScriptElement()};
		p.head.getScriptSection()[0].
	}
	
}
