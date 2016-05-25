package com.zjvande2.Pong;


public class Paddle {
	private int x;
	private int y;

	public int paddleSizeX; //
	public int paddleSizeY; //

	public Paddle(int x, int y, int sizeX, int sizeY) {
		this.x = x;
		this.y = y;

		this.paddleSizeX = sizeX;
		this.paddleSizeY = sizeY;
		
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getSizeX() {
		return paddleSizeX;
	}

	public int getSizeY() {
		return paddleSizeY;
	}

	public void setY(int y) {
		this.y = y;
	}
}
