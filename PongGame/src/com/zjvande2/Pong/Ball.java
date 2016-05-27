package com.zjvande2.Pong;

import java.awt.Graphics;

public class Ball extends Game {
	private int xSize;
	private int ySize;
	private int xPos;
	private int yPos;
	private int angleStart;
	private int angleEnd;
	private int ballSpeed;

	public Ball(int x, int y, int xp, int yp, int bs) {
		this.xSize = x;
		this.ySize = y;
		this.xPos = xp;
		this.yPos = yp;
		this.ballSpeed = bs;

	}

	public int getXPos() {
		return this.xPos;
	}

	public int getYPos() {
		return this.yPos;
	}

	public int getXSize() {
		return this.xSize;
	}

	public int getYSize() {
		return this.ySize;
	}

	public int getMoveSpeed() {
		return ballSpeed;
	}

	public void setXPos(int x) {
		this.xPos = x;
	}

	public void setYPos(int y) {
		this.yPos = y;
	}

	public String getInfo() {
		String ballInfo = ("This is a ball for now ");
		return ballInfo;
	}

	public void move(Graphics g) {
		g.drawArc(getXPos(), getYPos(), getXSize(), getYSize(), angleStart, angleEnd);
	}
}
