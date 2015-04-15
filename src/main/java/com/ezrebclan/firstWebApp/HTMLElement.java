package com.ezrebclan.firstWebApp;

public abstract class HTMLElement {

	private String id;
	private String className;
	private String[] classNames;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets the full className, then seperates the given className into individual classes, and uses that to set the element's classNames.
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
		char[] chars = className.toCharArray();
		String[] classNames = new String[0];
		int lastWord = 0;
		for (int i = 0; i < chars.length; i++) {
			if(chars[i] == ' ') {
				String className2 = "";
				for(int i2 = lastWord; i2 < i; i2++) {
					className2 += chars[i2];
				}
				lastWord = i+1;
				String[] classNames2 = new String[classNames.length + 1];
				System.arraycopy(classNames, 0, classNames2, 0, classNames.length);
				classNames2[classNames.length] = className2;
				classNames = classNames2;
			} else if(i == (chars.length-1)) {
				String className2 = "";
				for(int i2 = lastWord; i2 < i; i2++) {
					className2 += chars[i2];
				}
				String[] classNames2 = new String[classNames.length + 1];
				System.arraycopy(classNames, 0, classNames2, 0,
						classNames.length);
				classNames2[classNames.length] = className2;
				classNames = classNames2;
			}
		}
	}

	/**
	 * @return the classNames
	 */
	public String[] getClassNames() {
		return classNames;
	}

	/**
	 * Sets the classNames array, then combines the values in the given classNames into one className, and uses that to set the element's className.
	 * @param classNames the classNames to set
	 */
	public void setClassNames(String[] classNames) {
		this.classNames = classNames;
	}

	public abstract String toHTML();
}
