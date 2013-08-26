/**
 * 
 */
package com.adani.games.puzzleme.models;

import android.graphics.Canvas;

import com.adani.games.puzzleme.models.core.RenderCycle;
import com.adani.games.puzzleme.models.core.Vector2D;

/**
 * 
 * @author Imran Adan
 *
 */
public class Game implements RenderCycle {
	
	private static Game game;
	
	private GameMap map;
	private Ball ball;
	
	
	public static Game createNewGame(int mapWidth, int mapHeight){
		if(game == null)
			game = new Game(mapWidth, mapHeight);
		return game;
	}
	
	public static Game getInstance(){
		return game;
	}
	
	private Game(int mapWidth, int mapHeight){
		map = new GameMap(mapWidth, mapHeight);
		
		float cx = map.getMAP_WIDTH() / 2;
		float cy = map.getMAP_HEIGHT() / 2;
		
		ball = new Ball(new Vector2D(cx, cy));
	}
	

	@Override
	public void update() {
		ball.update();
	}

	@Override
	public void draw(Canvas canvas) {
		map.draw(canvas);
		ball.draw(canvas);
	}
	
	public void updateBallCoordinates(float... values){
		ball.getVector2D().x = values[0];
		ball.getVector2D().y = values[1];
	}
}
