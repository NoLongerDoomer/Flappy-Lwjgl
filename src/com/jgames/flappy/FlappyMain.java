package com.jgames.flappy;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class FlappyMain implements Runnable {

	private final int width = 1280;
	private final int height = 720;

	private final String title = "Flappy-Lwjgl";

	private Thread thread;

	private boolean running = false;

	public void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();

	}

	@Override
	public void run() {

		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);

			ContextAttribs contextAttribs = new ContextAttribs(3, 3);

			Display.create(new PixelFormat(), contextAttribs.withProfileCore(true));
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		while (running) {
			Display.update();
			if (Display.isCloseRequested()) {
				running = false;
			}
		}

		Display.destroy();
	}

	public static void main(String[] args) {
		FlappyMain flappyMain = new FlappyMain();
		flappyMain.start();
	}

}
