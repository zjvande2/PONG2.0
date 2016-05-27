package com.zjvande2.Pong;

public class Game {

	public Paddle paddle1;
	public Paddle paddle2;
	
	private final int paddleSizeX = Pong.WIDTH / 50;
	private final int paddleSizeY = Pong.HEIGHT / 10;

	private final int paddle1PosX = 10;
	private final int paddle1PosY = 10;

	private int paddle2XOffset = 750 ;
	
	//private int paddle2PosX = 10;
	//private int paddle2PosY = (HEIGHT / 2) - (paddle2.getYSize() / 2);

	public Game() {
		//CreatePaddles();
		//System.out.println("Creating Paddles...");
	}

	public void CreatePaddles() {

		paddle1 = new Paddle(paddle1PosX, paddle1PosY, paddleSizeX, paddleSizeY);
		paddle1.getInfo();

		paddle2 = new Paddle(paddle2XOffset, paddle1PosY, paddleSizeX, paddleSizeY);
		paddle2.getInfo();
	}
}
