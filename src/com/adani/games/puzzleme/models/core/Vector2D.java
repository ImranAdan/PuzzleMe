/**
 * 
 */
package com.adani.games.puzzleme.models.core;

/**
 * Class that represents a 2D Vector.
 * 
 * @author Imran Adan
 * 
 */
public class Vector2D {

	public float x;
	public float y;

	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D subtract(Vector2D v) {
		return new Vector2D(this.x - v.x, this.y - v.y);
	}

	public void normalise() {
		final float length = length();
		this.x = this.x / length;
		this.y = this.y / length;
	}

	public float length() {
		return (float) Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public Vector2D multiplyByScalarCons(Vector2D v, int scalar) {
		return new Vector2D(v.x * scalar, v.y * scalar);
	}

	public void multiplyByScalarDest(float scalar) {
		this.x *= scalar;
		this.y *= scalar;
	}

	/**
	 * Constructive add to a given vector.
	 * @param vector2d The vector to add this vector to.
	 * @return A the sum of both vectors.
	 */
	public Vector2D addCons(Vector2D vector2d) {
		return new Vector2D(this.x + vector2d.x, this.y + vector2d.y);
	}

	/**
	 * Destructive add to a given vector.
	 * @param vector2d The vector to add to.
	 */
	public void addDest(Vector2D vector2d) {
		this.x += vector2d.x;
		this.y += vector2d.y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vector2D [x=" + x + ", y=" + y + "]";
	}
}
