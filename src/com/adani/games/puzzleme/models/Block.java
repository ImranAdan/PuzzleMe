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
public class Block extends DrawableAsset {

	public static final String TAG = Block.class.getSimpleName();
	public static final Bitmap BLOCK_BITMAP;
	
	static{
		Bitmap b = BitmapFactory.decodeResource(GameResources.resources, R.drawable.block);
		BLOCK_BITMAP = Bitmap.createScaledBitmap(b, 256, 64, true);
	}
	
	public Block(Vector2D v) {
		super(v);
		setBitmap(BLOCK_BITMAP);
	}

	@Override
	public <T> void update(T... properties){
		// TODO Auto-generated method stub
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(getBitmap(), getPosition().x, getPosition().y, null);
	}
}
