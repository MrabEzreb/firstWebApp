package com.ezrebclan.firstWebApp;

public class Chat {

	public static String[] messages = new String[0];
	public static void addMessage(String message) {
		String[] messages2 = new String[messages.length + 1];
		System.arraycopy(messages, 0, messages2, 0, messages.length);
		messages2[messages.length] = message;
		messages = messages2;
	}
	public static String[] getMessages() {
		String[] messages2 = new String[messages.length];
		int i2 = 0;
		for (int i = messages.length; i > -1; i--) {
			messages2[i2] = messages[i];
			i2++;
		}
		return messages2;
	}
}
