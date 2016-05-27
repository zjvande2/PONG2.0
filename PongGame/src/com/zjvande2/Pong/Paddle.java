package com.zjvande2.Pong;

import java.awt.Graphics;

/***
 * 
 * @author Jason Vanderslice Creates the Paddle and calculates the graphics
 *         associated in moving it.
 *
 */
public class Paddle {

	public int paddleSizeX = 0; //
	public int paddleSizeY = 0; //

	private int x = 0;
	private int y = 0;

	private int topBlank = 0;
	private int bottemBlank = 0;

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

	// Calculates and returns the current position of the bottem left corner of
	// the paddle
	public int getBottemOfPaddlePos() {
		int bottemOfPad = this.topBlank + this.getYSize();
		return bottemOfPad;
	}

	public void moveY(int y) {
		this.y += y;
	}

	public void setYPos(int y) {
		this.y = y;
	}

	public void move(Graphics g) {
		// Calls the ClearArea Method to clear the positions above and below the
		// paddle
		// System.out.println(this.getYPos() + this.getYSize() + " | " +
		// Pong.HEIGHT);
		if (canMove()) {
			g.fillRect(getXPos(), getYPos(), getXSize(), getYSize());
			clearArea(g);
		} else {
			return;
		}

	}

	public void clearArea(Graphics g) {
		this.topBlank = Pong.HEIGHT - (Pong.HEIGHT - this.getYPos());
		this.bottemBlank = Pong.HEIGHT - (topBlank + this.getYSize());

		// Clear the top rectangle
		g.clearRect(this.getXPos(), 0, this.getXSize(), this.topBlank);

		// Clears the bottem of the rectangle
		g.clearRect(this.getXPos(), this.getBottemOfPaddlePos(), this.getXSize(), this.bottemBlank);

	}

	public boolean canMove() {
		if (this.getYPos() < 0) {
			this.setYPos(0);
			return false;

		} else if (this.getYPos() + this.getYSize() >= (Pong.HEIGHT - 20)) {
			int maxPos = Pong.HEIGHT - 20 - this.getYSize() - 2;
			this.setYPos(maxPos);
			return false;
		} else {
			return true;
		}
	}

	public String getInfo() {
		String paddleInfo = ("Paddle XPOS: " + this.getXPos() + " Paddle YPOS: " + this.getYPos() + ", XSize: "
				+ this.getXSize() + ", YSIZE: " + this.getYSize());
		return paddleInfo;
	}

}
