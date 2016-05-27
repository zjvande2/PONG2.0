package com.zjvande2.graphics;

import java.awt.Graphics;
import com.zjvande2.Pong.Pong;

/***
 * @author Jason Vanderslice Screen class handles rendering
 *
 */

public class Screen {


	public Screen() {
	
	}

	public void renderPaddles() {

	}

	public void renderMap(Graphics g) {
		g.drawLine(Pong.WIDTH / 2, 0, Pong.WIDTH / 2, Pong.HEIGHT);
	}

	public void showPaddleInfo(boolean draw) {
		if (draw) {
			// g.drawString(game.paddle1.getInfo(), 100, 200);
		} else {
			return;
		}
	}
}
