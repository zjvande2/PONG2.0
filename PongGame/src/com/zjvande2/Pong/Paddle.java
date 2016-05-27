package com.zjvande2.Pong;

import java.awt.Graphics;
/***
 * 
 * @author Jason Vanderslice
 * Creates the Paddle and calculates the graphics associated in moving it.
 *
 */
public class Paddle {

	public int paddleSizeX; //
	public int paddleSizeY; //
	
	private int x;
	private int y;

	private int topBlank;
	private int bottemBlank;
	
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

	//Calculates and returns the current position of the bottem left corner of the paddle
	public int getBottemOfPaddlePos() {
		int bottemOfPad = this.topBlank + this.getYSize();
		return bottemOfPad;
	}
	
	public void setY(int y) {
		this.y += y;
	}

	public void move(Graphics g) {
		//Calls the ClearArea Method to clear thse positions above and below the paddle
		g.fillRect(this.getXPos(), this.getYPos(), this.getXSize(), this.getYSize());
		clearArea(g);
	}

	
	public void clearArea(Graphics g) {
		this.topBlank = Pong.HEIGHT - (Pong.HEIGHT - this.getYPos());
		this.bottemBlank = Pong.HEIGHT - (topBlank + this.getYSize());
		
		//Clear the top rectangle
		g.clearRect(this.getXPos(), 0, this.getXSize(), this.topBlank);
		
		//Clears the bottem of the rectangle
		g.clearRect(this.getXPos(), this.getBottemOfPaddlePos(), this.getXSize(), this.bottemBlank);
			
	}

	public void getInfo() {
		System.out.println("Paddle XPOS: " + getXPos() + " Paddle YPOS: " + getYPos() + ", XSize: " + getXSize() + ", YSIZE: " + getYSize());
	}
}
