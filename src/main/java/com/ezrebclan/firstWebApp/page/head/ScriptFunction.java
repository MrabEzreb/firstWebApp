package com.ezrebclan.firstWebApp.page.head;

public class ScriptFunction {

	private String name = "";
	private String args = "";
	private String func = "";

	@Override
	public String toString() {
		return "function "+name+"("+args+") {\n"+func+"\n}";
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the args
	 */
	public String getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public void setArgs(String args) {
		this.args = args;
	}

	/**
	 * @return the func
	 */
	public String getFunc() {
		return func;
	}

	/**
	 * @param func the func to set
	 */
	public void setFunc(String func) {
		this.func = func;
	}
	
}
