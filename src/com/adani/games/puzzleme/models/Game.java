/**
 * 
 */
package com.adani.games.puzzleme.models;

import android.graphics.Canvas;
import android.util.Log;

import com.adani.games.puzzleme.models.core.RenderCycle;
import com.adani.games.puzzleme.models.core.Vector2D;
import com.adani.games.puzzleme.util.DrawingPanel;

/**
 * 
 * @author Imran Adan
 * 
 */
public class Game implements RenderCycle {

	public static final String TAG = Game.class.getSimpleName();
	private static Game game;

	private GameMap map;
	private Ball ball;
	private Block block;

	public static Game createNewGame(int mapWidth, int mapHeight) {
		if (game == null)
			game = new Game(mapWidth, mapHeight);
		return game;
	}

	public static Game getInstance() {
		return game;
	}

	private Game(int mapWidth, int mapHeight) {
		map = GameMap.createGameMap(mapWidth, mapHeight);
		int cx = map.getMAP_WIDTH() / 2;
		int cy = map.getMAP_HEIGHT() / 2;
		ball = new Ball(new Vector2D(cx, cy));
		block = new Block(new Vector2D(cx + 100, cy + 100));
	}

	@Override
	public <T> void update(T... properties){
		ball.update(properties);
		block.update(properties);
	}

	@Override
	public void draw(Canvas canvas) {
		map.draw(canvas);
		ball.draw(canvas);
		block.draw(canvas);
	}

	public void updateBallCoordinates(float... values) {
		ball.update(-values[0], values[1]);
	}
}
