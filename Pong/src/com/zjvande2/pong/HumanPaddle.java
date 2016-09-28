package com.zjvande2.pong;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle {
	private final double GRAVITY = 0.94;
	private double y;
	private double yVel;

	private boolean upAccel;
	private boolean downAccel;

	private int Player;
	private int x;

	public HumanPaddle(int player) {
		upAccel = false;
		downAccel = false;
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
		//Creating constants for paddle speed
		if (upAccel) {
			yVel -= 2;
		} else if (downAccel) {
			yVel += 2;
		} else if (!upAccel && !downAccel) {
			yVel *= GRAVITY;
		}
		
		//Setting max Speed of the paddle
		if (yVel >= 5) {
			yVel = 5;
		} else if (yVel <= -5) {
			yVel = -5;
		}
		
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

	public void setUpAccel(boolean input) {
		upAccel = input;
	}

	public void setDownAccel(boolean input) {
		downAccel = input;
	}

	public int getY() {

		return (int) y;
	}

}
