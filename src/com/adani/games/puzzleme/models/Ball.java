/**
 * 
 */
package com.adani.games.puzzleme.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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
	public static final int BALL_WIDTH = 64;
	public static final int BALL_HEIGHT = 64;
	public static final Bitmap BALL_BITMAP = Bitmap.createScaledBitmap(
			BitmapFactory.decodeResource(GameResources.resources,
					R.drawable.ball), BALL_WIDTH, BALL_HEIGHT, true);

	public static final float SPEED = 3f;

	public Ball(Vector2D v) {
		super(v);
		setBitmap(BALL_BITMAP);
		setVelocity(new Vector2D(0, 0));
	}

	@Override
	public <T> void update(T... properties) {
		resolveMapBoundsCollisions();
		if (properties.length > 0) {
			getPosition().x += ((Float) properties[0] * (Ball.SPEED));
			getPosition().y += ((Float) properties[1] * (Ball.SPEED));
		}

	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(getBitmap(), getPosition().x, getPosition().y, null);
	}

	private void resolveMapBoundsCollisions() {
		if (atRightEdge())
			getPosition().x = GameMap.MAP_WIDTH - (getBitmap().getWidth() / 2);
		else if (atLeftEdge())
			getPosition().x = 0 + (getBitmap().getWidth() / 2);
		else if (atTopEdge())
			getPosition().y = 0 + (getBitmap().getHeight() / 2);
		else if (atBottomEdge())
			getPosition().y = GameMap.MAP_HEIGHT
					- (getBitmap().getHeight() / 2);
	}

	/*
	 * TODO: Correct the collisions.
	 */
	private boolean atRightEdge() {
		return getPosition().x + (getBitmap().getWidth() / 2) > GameMap.MAP_WIDTH;
	}

	private boolean atBottomEdge() {
		return getPosition().y + (getBitmap().getHeight() / 2) >= GameMap.MAP_HEIGHT;
	}

	private boolean atTopEdge() {
		return getPosition().y + (getBitmap().getHeight() / 2) < 0;
	}

	private boolean atLeftEdge() {
		return getPosition().x + (getBitmap().getWidth() / 2) < 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ball [getPosition()=" + getPosition().toString()
				+ ", getVelocity()=" + getVelocity().toString() + "]";
	}

	@Override
	public void print(String message) {
		Log.d(DEBUG + TAG, message);
	}

}
