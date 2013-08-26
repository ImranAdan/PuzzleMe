/**
 * 
 */
package com.adani.games.puzzleme.models.core;

/**
 * Class that represents a 2D Vector.
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
	
	
	public Vector2D multiplyByScalar(Vector2D v, float scalar) {
		return new Vector2D(v.x * scalar, v.y * scalar);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vector2D [x=" + x + ", y=" + y + "]";
	}
}
