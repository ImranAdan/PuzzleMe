/**
 * 
 */
package com.adani.games.puzzleme.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.adani.games.puzzleme.R;
import com.adani.games.puzzleme.models.core.RenderCycle;
import com.adani.games.puzzleme.models.core.Vector2D;
import com.adani.games.puzzleme.util.GameResources;

/**
 * A {@link DrawableAsset} is any asset which can be updated and rendered 
 * to the canvas.
 * @author Imran Adan
 *
 */
public abstract class DrawableAsset implements RenderCycle {

	public static final Bitmap GAME_BACKGROUND = BitmapFactory.decodeResource(GameResources.resources, R.drawable.bg);
	
	private Vector2D position;
	private Vector2D velocity;
	
	private Bitmap bitmap;
	
	
	public DrawableAsset(Vector2D v) {
		this.setPosition(v);
	}

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public Vector2D getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}	
}
