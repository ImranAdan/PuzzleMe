/**
 * 
 */
package com.adani.games.puzzleme.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.adani.games.puzzleme.R;
import com.adani.games.puzzleme.models.core.Vector2D;
import com.adani.games.puzzleme.util.Debuggable;
import com.adani.games.puzzleme.util.GameResources;

/**
 * 
 * Ball.
 * 
 * @author Imran Adan
 * 
 */

public class Ball extends DrawableAsset implements Debuggable {

	public static final String TAG = Ball.class.getSimpleName();

	/* Set up bitmap properties */
	private static final float BALL_RADIUS = 32f;
	public static final Bitmap BALL_BITMAP = Bitmap.createScaledBitmap(
			BitmapFactory.decodeResource(GameResources.resources,
					R.drawable.ball), (int) BALL_RADIUS, (int) BALL_RADIUS,
			true);

	public static final float SPEED = 4f;

	public Ball(Vector2D v) {
		super(v);
		bitmap = BALL_BITMAP;
		velocity = new Vector2D(0, 0);

		paint.setColor(Color.BLUE);
		paint.setStyle(Paint.Style.FILL);
	}

	@Override
	public <T> void update(T... properties) {
		resolveMapBoundsCollisions();
		if (properties.length > 0) {
			position.x += ((Float) properties[0] * (Ball.SPEED));
			position.y += ((Float) properties[1] * (Ball.SPEED));
		}
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawCircle(position.x, position.y, BALL_RADIUS, paint);
	}

	private void resolveMapBoundsCollisions() {

		// At right edge
		if (position.x > GameMap.MAP_WIDTH / 2
				&& position.x + (bitmap.getWidth()) >= GameMap.MAP_WIDTH)
			position.x = GameMap.MAP_WIDTH - bitmap.getWidth();

		// At left edge
		if (position.x < GameMap.MAP_WIDTH / 2
				&& position.x - bitmap.getWidth() <= 0)
			position.x = 0 + bitmap.getWidth();

		// At the upper edge
		if (position.y < GameMap.MAP_HEIGHT / 2
				&& position.y - bitmap.getHeight() <= 0)
			position.y = 0 + bitmap.getHeight();

		// At the bottom edge
		if (position.y > GameMap.MAP_HEIGHT / 2
				&& position.y + (bitmap.getHeight()) >= GameMap.MAP_HEIGHT)
			position.y = GameMap.MAP_HEIGHT - bitmap.getHeight();

	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ball [position=" + position.toString() + ", velocity="
				+ position.toString() + "]";
	}

	@Override
	public void print(String message) {
		Log.d(DEBUG + TAG, message);
	}
}
