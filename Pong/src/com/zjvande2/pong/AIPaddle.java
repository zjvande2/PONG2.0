package com.zjvande2.pong;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle {
	private double y;
	private double yVel;
	private int x;
	
	private Ball b1;

	public AIPaddle(int player, Ball b) {
		b1 = b;
		y = 210;
		yVel = 0;
		if (player == 1) {
			x = 20;
		} else {
			x = 660;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, (int) y, 20, 80);

	}

	
	
	public void move() {
		y = b1.getY() - 40;
		
		//Controlling the position of the paddle
		if (y < 0) {
			//System.out.println("We have hit the top of the screen");
			y = 0;
		}
		if(y > 420) {
			//System.out.println("We have hit the bottom of the screen");
			y = 420;
		}
		
		y += yVel;
	}



	public int getY() {

		return (int) y;
	}

}
