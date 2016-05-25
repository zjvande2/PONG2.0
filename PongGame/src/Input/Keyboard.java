package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
	private boolean[] keys = new boolean[120];
	public boolean upp1, downp1, upp2, downp2;

	public void update() {
		// Player 1 controls
		upp1 = keys[KeyEvent.VK_W];
		downp1 = keys[KeyEvent.VK_S];

		// Player 2 Controls
		upp2 = keys[KeyEvent.VK_UP];
		downp2 = keys[KeyEvent.VK_DOWN];

	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {

	}

}