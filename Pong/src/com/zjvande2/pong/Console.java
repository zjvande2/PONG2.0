package com.zjvande2.pong;

public class Console {
	private boolean enabled;
	public Console(boolean enabled) {
		if (enabled == true) {
			this.enabled = true;
		}
	}
	
	public void log(String message) {
		if (enabled) {
			System.out.println("Console: " +  message);
		} else {
			return;
		}
	}
	
	public void errorOut(String message) {
		if (enabled) {
			System.out.println("Console Error --> " + message );
		} else {
			return;
		}
	}
}
