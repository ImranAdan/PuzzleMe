package com.adani.games.puzzleme.models;

import android.graphics.Canvas;
import android.util.Log;

import com.adani.games.puzzleme.models.core.RenderCycle;
import com.adani.games.puzzleme.util.Debuggable;

public class GameMap implements Debuggable, RenderCycle {

	private static GameMap instance;
	private static int MAP_WIDTH;
	private static int MAP_HEIGHT;
	
	public static GameMap createGameMap(int width, int height){
		if(instance == null){
			instance = new GameMap(width, height);
		}
		return instance;
	}
	public static GameMap getInstance() {
		return instance;
	}
	
	private GameMap(int width, int height){
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
		return x < 0 || x > MAP_WIDTH || y < 0 || y > MAP_HEIGHT;
	}
}
