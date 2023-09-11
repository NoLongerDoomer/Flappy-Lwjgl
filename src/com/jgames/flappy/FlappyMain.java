package com.jgames.flappy;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class FlappyMain implements Runnable {

	// game resolution
	private final int width = 1280;
	private final int height = 720;

	private boolean running = false;
	private long window;

	public void start() {

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
		}
	}

	private void render() {
		// TODO Auto-generated method stub

	}

	private void update() {
		// TODO Auto-generated method stub

	}

	// initialize game and openGL thread
	private void init() {
		if (!GLFW.glfwInit()) {
			// handle if cannot be initiated
		}

		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GL11.GL_TRUE);

		// long window = pointer to window in native so we can use it later to
		// manipulate or tweak it
		window = GLFW.glfwCreateWindow(width, height, "Flappy", MemoryUtil.NULL, MemoryUtil.NULL);

		if (window == MemoryUtil.NULL) {
			// handle
		}

		GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());

	}

	public static void main(String[] args) {
		FlappyMain flappyMain = new FlappyMain();
		flappyMain.start();
	}

}
