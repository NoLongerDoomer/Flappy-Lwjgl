package com.jgames.flappy;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWVidMode;

import com.jgames.flappy.input.Input;

public class FlappyMain implements Runnable {

	// game resolution
	private final int width = 1280;
	private final int height = 720;

	private boolean running = false;
	private long window;

	public void start() {
		running = true;
		Thread thread = new Thread(this, "FlappyMain");
		thread.start();
	}

	@Override
	public void run() {

		// init, update and render basically all openGL methods should be in one single
		// thread
		init();
		while (running) {
			update();
			render();

			if (glfwWindowShouldClose(window)) {
				running = false;
			}
		}
	}

	private void render() {
		glfwSwapBuffers(window);

	}

	private void update() {
		glfwPollEvents();

	}

	// initialize game and openGL thread
	private void init() {
		if (glfwInit()) {
			// handle if cannot be initiated
		}

		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

		// long window = pointer to window in native so we can use it later to
		// manipulate or tweak it
		window = glfwCreateWindow(width, height, "Flappy", NULL, NULL);

		if (window == NULL) {
			// TODO handle
		}

		GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

		// get to the center in windowed mode
		glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);

		if (window == NULL) {
			// TODO handle
		}

		glfwSetKeyCallback(window, new Input());

		glfwMakeContextCurrent(window);
		glfwShowWindow(window);

	}

	public static void main(String[] args) {
		FlappyMain flappyMain = new FlappyMain();
		flappyMain.start();
	}

}
