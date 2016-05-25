package com.zjvande2.Pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 * 
 * @author Jason Vanderslice Pong Main Class 5/25/16
 *
 */
public class Pong extends Canvas implements Runnable {

	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final String TITLE = "PONG";

	private JFrame frame;
	
	private boolean running = false;
	private Thread thread;
	
	public Pong() {
		//Paddle paddle1 = new Paddle();
		//Paddle paddle2 = new Paddle();

	}

	public static void main(String[] args) {
		Pong pong = new Pong(); 							//Initialize Game Constructor
		
		Canvas canvas = new Canvas();						//Initialize Canvas
		pong.frame = new JFrame();							//Initialize JFrame
		
		pong.frame.add(canvas);
		pong.frame.setSize(WIDTH, HEIGHT);
		pong.frame.setTitle(TITLE);
		pong.frame.setResizable(false);
		pong.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pong.frame.setVisible(true);

		pong.start();
	}

	private void start() {
		if (running) {
			return;
		} else {
			thread = new Thread(this);
			thread.start();
			running = true;
		}
	}

	public void run() {
		while (running) {
			System.out.println("We are running");
			draw();
		}
	}
	
	private void draw() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		
		System.out.println("We have got to the first stage");
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, WIDTH, HEIGHT);
		g.dispose();
		bs.show();
	}
}
