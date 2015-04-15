package com.ezrebclan.firstWebApp.page;

import com.ezrebclan.firstWebApp.HTMLElement;
import com.ezrebclan.firstWebApp.page.head.ScriptElement;
import com.ezrebclan.firstWebApp.page.head.ScriptFunction;

public class Page extends HTMLElement {
	
	public HeadElement head = new HeadElement();
	public String body = "";
	
	@Override
	public String toHTML() {
		return "<html>\n"+head.toHTML()+"\n"+"<body>\n\n\n</body>"+"\n</html>";
	}
	
	public static void main(String[] args) {
		Page p = new Page();
		p.head.setScriptSection(new ScriptElement[] {new ScriptElement()});
		p.head.getScriptSection()[0].setFunctions(new ScriptFunction[] {new ScriptFunction()});
		p.head.getScriptSection()[0].getFunctions()[0].setName("test");
		p.head.getScriptSection()[0].getFunctions()[0].setFunc("print(\"testr\");");
		p.head.getScriptSection()[0].getFunctions()[0].setArgs("");
		System.out.println(p.toHTML());
	}
	
}
