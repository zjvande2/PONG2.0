package com.zjvande2.Pong;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.zjvande2.console.Console;
import com.zjvande2.graphics.Screen;
import com.zjvande2.input.Keyboard;

/**
 * 
 * @author Jason Vanderslice Pong Main Class 5/25/16
 *
 */
public class Pong extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static String TITLE = "PONG";
	
	private boolean running = false;
	
	public Game game;
	
	private JFrame frame;
	private Thread thread;
	private Keyboard key;
	private Screen screen;
	private Console console;
	
	
	public Pong() {
		console = new Console();
		game = new Game();
		screen = new Screen(game);
		game.CreatePaddles();
		

		key = new Keyboard();
		addKeyListener(key);
	}

	public static void main(String[] args) {
		Pong pong = new Pong(); // Initialize Game Constructor

		pong.frame = new JFrame(); // Initialize JFrame

		pong.frame.setResizable(false);
		pong.frame.setTitle(TITLE);
		pong.frame.add(pong);
		pong.frame.pack();
		pong.frame.setSize(WIDTH, HEIGHT);
		pong.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pong.frame.setLocationRelativeTo(null);
		pong.frame.setVisible(true);

		pong.start();
	}

	public synchronized void start() {
		if (running) {
			return;
		} else {
			running = true;
			thread = new Thread(this, "Game");
			thread.start();

		}
	}

	String _title = "";

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
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
		int p1y = 0;
		int moveSpeed = 10;
		int p2y = 0;
		
		key.update();
		if (key.upp1) {
			game.paddle1.setY(p1y - moveSpeed);
		}
		if (key.downp1) {
			game.paddle1.setY(p1y + moveSpeed);
		}
		if (key.upp2) {
			game.paddle2.setY(p2y - moveSpeed);
		}
		if (key.downp2) {
			game.paddle2.setY(p2y + moveSpeed);
		}
		
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		screen.renderPaddles(g);
		screen.renderMap(g);
		
		g.dispose();
		bs.show();
	}
}
