/**
 * 
 */
package com.adani.games.puzzleme.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.adani.games.puzzleme.models.Game;


/**
 * @author Imran Adan
 *
 */
public class DrawingPanel extends SurfaceView implements SurfaceHolder.Callback{
	
	public static final String TAG = DrawingPanel.class.getSimpleName();
	
	private static Canvas c;
	private Game game;
	private GameThread gameThread;

	public DrawingPanel(Context context) {
		super(context);
		getHolder().addCallback(this);
		gameThread = new GameThread(getHolder(), this);
		setFocusable(true);
	}

	public DrawingPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);
		gameThread = new GameThread(getHolder(), this);
		setFocusable(true);
	}

	public DrawingPanel(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		getHolder().addCallback(this);
		gameThread = new GameThread(getHolder(), this);
		setFocusable(true);
	}
	
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {} /* Surface will not change */ 

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		p("Calling initiate");
		initiate();
		p("END Calling initiate");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		p("Calling Shutdown");
		stop();
		p("END Calling Shutdown");
	}
	
	
	public void update(){
		if (game != null){
			game.update();
		}
	}

	public void render(Canvas canvas){
		if(canvas != null && game != null){
			c = canvas;
			game.draw(canvas);
		}
	}
	
	public void initiate(){
        if (gameThread.getState() == Thread.State.TERMINATED) {
    		p("Thread was terminated... creating new thread");
        	gameThread = new GameThread(getHolder(), this);
        	gameThread.setRunning(true);
        	gameThread.start();
        	
        	game = Game.createNewGame(getWidth(), getHeight());
        }
        else {
    		p("continuing thread");
        	gameThread.setRunning(true);
        	gameThread.start();
        	
        	game = Game.createNewGame(getWidth(), getHeight());
        }
	} 
	public void stop() {
		gameThread.setRunning(false);
		boolean retry = true;
		while (retry) {
			try {
				gameThread.join();
				retry = false;
			} catch (InterruptedException e) {}
		}
	}

	public void p(String message){
		Log.d(TAG, "Debug -- " + message);
	}
	
	public static void priorityRender(Bitmap bitmap, float left, float top, Paint paint){
		if(c != null)
			c.drawBitmap(bitmap, left, top, paint);
	}
}
