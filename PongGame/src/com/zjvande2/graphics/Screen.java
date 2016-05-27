package com.zjvande2.graphics;

import java.awt.Graphics;

import com.zjvande2.Pong.Game;
import com.zjvande2.Pong.Pong;

/***
 * @author Jason Vanderslice
 * Screen class handles rendering
 *
 */
public class Screen {
	private Game game;
	
	public Screen(Game game) {
		this.game = game;
	}
	
	public void renderPaddles(Graphics g) {
		game.paddle1.move(g);
		game.paddle2.move(g);
	}
	
	public void renderMap(Graphics g) {
		g.drawLine(Pong.WIDTH / 2, 0, Pong.WIDTH / 2, Pong.HEIGHT);
	}
}
