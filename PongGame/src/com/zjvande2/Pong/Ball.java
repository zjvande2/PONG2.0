package com.zjvande2.Pong;

import java.awt.Graphics;

public class Ball {
	private int xSize;
	private int ySize;
	private int xPos;
	private int yPos;

	private int ballSpeed;

	private boolean wasInit = false;
	
	public Ball(int x, int y, int xs, int ys, int bs) {
		this.xPos = x;
		this.yPos = y;
		this.xSize = xs;
		this.ySize = ys;
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

	public void drawBall(Graphics g) {
		g.fillArc(getXPos(), getYPos(), getXSize(), getYSize(), 0, 360);
		drawCollider(true, g);

		if (!wasInit) {
			initMoving(g);
			wasInit = true;
		} else {
			moveBall(g);
		}
	}

	public void initMoving(Graphics g) {
		g.fillArc(this.getXPos() + this.getMoveSpeed(), this.getYPos() + this.getMoveSpeed(), this.getXSize(), this.getYSize(), 0, 360);
	}

	public void moveBall(Graphics g) {
		g.fillArc(getXPos() + getMoveSpeed(), getYPos() + getMoveSpeed(), getXSize(), getYSize(), 0, 360);
	}

	public void drawCollider(boolean draw, Graphics g) {
		if (draw) {
			g.drawRect(getXPos(), getYPos(), getXSize(), getYSize());
		} else {
			return;

		}
	}
}
