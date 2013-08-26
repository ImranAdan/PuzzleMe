package com.adani.games.puzzleme.models;

import android.graphics.Canvas;
import android.util.Log;

import com.adani.games.puzzleme.models.core.RenderCycle;
import com.adani.games.puzzleme.util.Debuggable;

public class GameMap implements Debuggable, RenderCycle {

	private final int MAP_WIDTH;
	private final int MAP_HEIGHT;
	
	
	public GameMap(int width, int height){
		MAP_WIDTH = width;
		MAP_HEIGHT = height;
	}

	public int getMAP_WIDTH() {
		return MAP_WIDTH;
	}

	public int getMAP_HEIGHT() {
		return MAP_HEIGHT;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Canvas canvas) {
		print("Drawing Background...");
		canvas.drawBitmap(DrawableAsset.GAME_BACKGROUND, 0, 0, null);
	}

	@Override
	public void print(String message) {
		Log.d(DEBUG, message);
	}
	
	public static boolean atWorldEdge(float x, float y){
		return x < 0 || x > 0;
	}
}
