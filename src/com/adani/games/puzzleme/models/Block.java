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
 * Block.
 * @author Imran Adan
 * 
 */
public class Block extends DrawableAsset {

	public static final String TAG = Block.class.getSimpleName();

	public static final int BLOCK_WIDTH = 256;
	public static final int BLOCK_HEIGHT = 64;
	public static final Bitmap BLOCK_BITMAP = Bitmap.createScaledBitmap(
			BitmapFactory.decodeResource(GameResources.resources,
					R.drawable.block), BLOCK_WIDTH, BLOCK_HEIGHT, true);

	public Block(Vector2D v) {
		super(v);
		bitmap = BLOCK_BITMAP;
		velocity = new Vector2D(1, 0);
	}

	@Override
	public <T> void update(T... properties) {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, position.x, position.y, null);
	}
}
