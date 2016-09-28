package com.zjvande2.pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener {

	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;

	private static final long serialVersionUID = 1L;
	private Thread thread;

	public boolean gameStarted;
	public Graphics gfx;
	public Image img;

	public Console console;
	public HumanPaddle p1;
	public AIPaddle p2;
	public Ball b1;

	public void init() {
		this.resize(WIDTH, HEIGHT);
		gameStarted = false;
		this.addKeyListener(this);
		p1 = new HumanPaddle(1);
		b1 = new Ball();
		p2 = new AIPaddle(2, b1);
		console = new Console(true);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();

	}

	public void paint(Graphics g) {

		gfx.setColor(Color.black);

		gfx.fillRect(0, 0, WIDTH, HEIGHT);

		if (b1.getX() < -10 || b1.getX() > 710) {
			gfx.setColor(Color.red);
			gfx.drawString("Game Over", 350, 250);
		} else {
			p1.draw(gfx);
			b1.draw(gfx);
			p2.draw(gfx);
		}

		if (!gameStarted) {
			gfx.setColor(Color.white);
			gfx.drawString("PONG", 340, 100);
			gfx.drawString("Press 'Enter' to being. . .", 310, 130);
		}
		g.drawImage(img, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		for (;;) {

			if (gameStarted) {
				p1.move();
				p2.move();
				b1.move();
				b1.checkPaddleCollision(p1, p2);

			}

			repaint();

			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			console.log("We have pressed the 'W' Key");
			p1.setUpAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			console.log("We have pressed the 'S' Key");
			p1.setDownAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			console.log("Game has been started");
			gameStarted = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			p1.setUpAccel(false);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			p1.setDownAccel(false);
		}
	}

	public void keyTyped(KeyEvent e) {
		// Unused
	}

}
