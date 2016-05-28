package com.zjvande2.Pong;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.zjvande2.graphics.Screen;
import com.zjvande2.input.Keyboard;

/**
 * 
 * @author Jason Vanderslice Pong Main Class 5/25/16
 *
 */
public class Pong extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private boolean running = false;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static String TITLE = "PONG";
	
	public Game game;
	
	private JFrame frame;
	private Thread thread;
	private Keyboard key;
	private Screen screen;
	
	
	public Pong() {
		game = new Game();
		screen = new Screen();

		key = new Keyboard();
		addKeyListener(key);
	}

	public static void main(String[] args) {
		Pong pong = new Pong(); 									// Initialize Game Constructor
		
		pong.frame = new JFrame(); 									// Initialize JFrame
		pong.frame.setResizable(false);
		pong.frame.setTitle(TITLE);
		pong.frame.add(pong);
		pong.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pong.frame.pack();
		pong.frame.setSize(WIDTH, HEIGHT);
		pong.frame.setLocationRelativeTo(null);		
		pong.frame.setVisible(true);

		
		pong.start(); 												// Start the program
	}

	public synchronized void start() {
		if (running) {
			return;
		} else {
			running = true;											//set running to true so runnable initiates
			thread = new Thread(this, "Game"); 						//Create the thread
			thread.start();											//start the thread

		}
	}

	String _title = "";												//Temporary title that allows the FPS to be in the title bar

	public void run() {
		long lastTime = System.nanoTime();							//Get the current time of the computer
		long timer = System.currentTimeMillis();					//Get the exact time in milliseconds 
		final double ns = 1000000000.0 / 60.0;						//Convert the mills seconds to seconds
		double delta = 0;
		int frames = 0;
		int updates = 0;

		while (running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				update();									
				updates++;
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				_title = (TITLE + "  |  " + updates + "ups, " + frames + " fps");
				frame.setTitle(_title);
				updates = 0;
				frames = 0;
			}
		}

	}

	public void update() {
		game.update(key);
		
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		
		game.paddle1.move(g);
		game.paddle2.move(g);
		game.ball.drawBall(g);

		screen.renderMap(g);
		
		g.dispose();
		bs.show();
	}
}
