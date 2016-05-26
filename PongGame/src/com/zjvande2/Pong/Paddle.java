package com.zjvande2.Pong;

import java.awt.Graphics;

public class Paddle {
	private int x;
	private int y;

	public int paddleSizeX; //
	public int paddleSizeY; //

	// private Paddle blankSpaceP2T;
	// private Paddle blankSpaceP2B;

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

	public int getXSize() {
		return paddleSizeX;
	}

	public int getYSize() {
		return paddleSizeY;
	}

	public void setY(int y) {
		this.y += y;
	}

	public void move(Graphics g) {

		clearOldTop(g);
		clearOldBottem(g);
		g.fillRect(this.getXPos(), this.getYPos(), this.getXSize(), this.getYSize());

	}

	public void clearOldBottem(Graphics g) {
		int topBlank = Pong.HEIGHT - (Pong.HEIGHT - getYPos());
		int bottemBlank = Pong.HEIGHT - (topBlank + getYSize());
		g.clearRect(getXPos(), Pong.HEIGHT, getXSize(), bottemBlank);
	}

	public void clearOldTop(Graphics g) {
		int topBlank = Pong.HEIGHT - (Pong.HEIGHT - getYPos());
		g.clearRect(getXPos(), 0, getXSize(), topBlank);

	}

	public void getInfo() {
		System.out.println("Paddle XPOS: " + getXPos() + " Paddle YPOS: " + getYPos() + ", XSize: " + getXSize() + ", YSIZE: " + getYSize());
	}
}
