/**
 * 
 */
package com.adani.games.puzzleme.models;

/**
 * A {@link DrawableAsset} is any asset which can be updated and rendered 
 * to the canvas.
 * @author Imran Adan
 *
 */
public class DrawableAsset {

	private float x;
	private float y;
	
	public DrawableAsset(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
}
