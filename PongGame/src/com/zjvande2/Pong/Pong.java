package com.zjvande2.Pong;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Input.Keyboard;

/**
 * 
 * @author Jason Vanderslice Pong Main Class 5/25/16
 *
 */
public class Pong extends JComponent implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static String TITLE = "PONG";

	private JFrame frame;

	private boolean running = false;
	private Thread thread;
	private Keyboard key;

	private Paddle paddle1;

	public Pong() {
		paddle1 = new Paddle(0, 0, WIDTH / 50, HEIGHT / 10);
		
		key = new Keyboard();
		// Paddle paddle2 = new Paddle();
		// setBackground(Color.black);
		
		addKeyListener(key);
	}

	public static void main(String[] args) {
		Pong pong = new Pong(); // Initialize Game Constructor

		// pong.canvas = new Canvas(); // Initialize Canvas
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

	private void start() {
		if (running) {
			return;
		} else {
			running = true;
			thread = new Thread(this);
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
		//int p2y = 0;
		key.update();
		//System.out.println("Game updated");
		if (key.upp1) {
			System.out.println("we have pressed the key");
			paddle1.setY(p1y + 1);
		}

	}

	public void paint(Graphics g) {
		// drawing player1
		g.drawRect(paddle1.getX(), paddle1.getY(), paddle1.getSizeX(), paddle1.getSizeY());

		
		// draw p2
		g.dispose();
	}
}
