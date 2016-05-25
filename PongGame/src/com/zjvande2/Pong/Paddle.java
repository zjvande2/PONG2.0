package com.zjvande2.Pong;

import java.awt.Graphics;

public class Paddle {
	private int x;
	private int y;

	public int paddleSizeX; //
	public int paddleSizeY; //

	private Paddle blankSpaceT;
	private Paddle blankSpaceB;
	
	//private Paddle blankSpaceP2T;
	//private Paddle blankSpaceP2B;
	
	public Paddle(int x, int y, int sizeX, int sizeY) {
		this.x = x;
		this.y = y;

		this.paddleSizeX = sizeX;
		this.paddleSizeY = sizeY;

	}

	public int getXPos() {
		return this.x;
	}

	public int getYPos() {
		return this.y;
	}

	public int getSizeX() {
		return paddleSizeX;
	}

	public int getSizeY() {
		return paddleSizeY;
	}

	public void setY(int y) {
		this.y += y;
	}

	public void move(Graphics g) {
		
		g.fillRect(this.getXPos(), this.getYPos(), this.getSizeX(), this.getSizeY());
		clearOldRect(g);
	}

	public void clearOldRect(Graphics g) {
		//for the top of the paddle
		g.clearRect(getXPos(), getYPos() - getSizeY(), getSizeX(), getSizeY());
		
		//for the bottom of the paddle
		g.clearRect(getXPos(), getYPos() , getSizeX(), getYPos() - getSizeY());
	}
}
