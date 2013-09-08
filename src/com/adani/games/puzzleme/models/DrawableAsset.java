/**
 * 
 */
package com.adani.games.puzzleme.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;

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
	
	/* Geometric properties */
	protected Vector2D position;
	protected Vector2D velocity;
	protected float angle;
	
	/* Bitmap properties */
	protected Bitmap bitmap;
	
	
	/* Paint properties */
	protected Paint paint;
	
	DrawableAsset(Vector2D v) {
		position = v;
		
		paint = new Paint();
	}
}
