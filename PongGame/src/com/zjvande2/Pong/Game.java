package com.zjvande2.Pong;

import com.zjvande2.input.Keyboard;

public class Game {

	public Ball ball;
	public Paddle paddle1;
	public Paddle paddle2;
	
	//Paddle Variables
	private final int paddleSizeX = Pong.WIDTH / 50;
	private final int paddleSizeY = Pong.HEIGHT / 10;
	private final int paddle1PosX = 0;
	private final int paddle1PosY = Pong.HEIGHT / 2 - paddleSizeY;
	private int paddle2XOffset = Pong.WIDTH - (paddleSizeX + 6);

	//Ball Variables
	private int xSize = Pong.WIDTH / 50;
	private int ySize = xSize;
	private int xPos = Pong.WIDTH  / 2;
	private int yPos = Pong.HEIGHT / 2;
	private int ballSpeed = 20;
	
	
	public Game() {
		CreatePaddles();
		CreateBall();
	}

	public void CreatePaddles() {

		paddle1 = new Paddle(paddle1PosX, paddle1PosY, paddleSizeX, paddleSizeY);
		paddle1.getInfo();

		paddle2 = new Paddle(paddle2XOffset, paddle1PosY, paddleSizeX, paddleSizeY);
		paddle2.getInfo();
	}
	
	public void CreateBall() {
		
		ball = new Ball(xPos, yPos, xSize, ySize, ballSpeed);
		
		ball.getInfo();
	}

	public void update(Keyboard key) {
		int p1y = 0;
		int moveSpeed = 10;
		int p2y = 0;

		key.update();
		
		if (key.upp1) {
			this.paddle1.moveY(p1y - moveSpeed);
		}
		
		if (key.downp1) {
			this.paddle1.moveY(p1y + moveSpeed);
		}
		
		if (key.upp2) {
			this.paddle2.moveY(p2y - moveSpeed);
		}
		
		if (key.downp2) {
			this.paddle2.moveY(p2y + moveSpeed);
		}
	}
}
