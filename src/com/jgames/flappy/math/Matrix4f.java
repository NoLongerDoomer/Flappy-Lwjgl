package com.jgames.flappy.math;

public class Matrix4f {

	public static final int SIZE = 4 * 4;

	public float[] elements = new float[SIZE];

	public Matrix4f() {

	}

	public static Matrix4f identity() {
		Matrix4f matrix4f = new Matrix4f();

		for (int i = 0; i < SIZE; i++) {
			matrix4f.elements[i] = 0.0f;
		}

		matrix4f.elements[0 + 0 * 4] = 1.0f;
		matrix4f.elements[1 + 1 * 4] = 1.0f;
		matrix4f.elements[2 + 2 * 4] = 1.0f;
		matrix4f.elements[3 + 3 * 4] = 1.0f;

		return matrix4f;
	}
}
