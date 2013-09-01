/**
 * 
 */
package com.adani.games.puzzleme.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.adani.games.puzzleme.R;
import com.adani.games.puzzleme.models.core.Vector2D;
import com.adani.games.puzzleme.util.GameResources;

/**
 * @author Imran Adan
 *
 */

public class Ball extends DrawableAsset {

	public static final Bitmap BALL_BITMAP;
	
	static {
		Bitmap b = BitmapFactory.decodeResource(GameResources.resources, R.drawable.ball);
		BALL_BITMAP = Bitmap.createScaledBitmap(b, 64, 64, true);
	}

	public Ball(Vector2D v) {
		super(v);
		setBitmap(BALL_BITMAP);
	}

	@Override
	public void update() {
		//TODO: Update the state of the ball depending on the loaction.
		
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(getBitmap(), getVector2D().x, getVector2D().y, null);
	}


}
