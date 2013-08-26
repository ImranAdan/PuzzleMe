/**
 * 
 */
package com.adani.games.puzzleme.models.core;

import android.graphics.Canvas;

/**
 * Renders object to the surface.
 * @author Imran Adan
 *
 */
public interface RenderCycle {

	/**
	 * Update the internal properties of this object.
	 */
	void update();
	/**
	 * Draw to the canvas surface.
	 * @param canvas The canvas to be drawn to.
	 */
	void draw(Canvas canvas);
}
