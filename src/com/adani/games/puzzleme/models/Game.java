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
	}

	@Override
	public <T> void update(T... properties){
		ball.update(properties);
	}

	@Override
	public void draw(Canvas canvas) {
		map.draw(canvas);
		ball.draw(canvas);
	}

	public void updateBallCoordinates(float... values) {
		ball.update(-values[0], values[1]);
		//DrawingPanel.priorityRender(ball.getBitmap(), ball.getPosition().x, ball.getPosition().y, null);
	}
}
