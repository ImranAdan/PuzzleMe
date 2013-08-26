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
	
	private Vector2D vector2D;
	private Bitmap bitmap;
	
	
	public DrawableAsset(Vector2D v) {
		this.setVector2D(v);
	}

	public Vector2D getVector2D() {
		return vector2D;
	}

	public void setVector2D(Vector2D vector2D) {
		this.vector2D = vector2D;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}	
}
