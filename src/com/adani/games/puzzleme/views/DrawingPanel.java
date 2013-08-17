/**
 * 
 */
package com.adani.games.puzzleme.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.adani.games.puzzleme.util.MainThread;

/**
 * @author Imran Adan
 *
 */
public class DrawingPanel extends SurfaceView implements SurfaceHolder.Callback{
	
	public static final String TAG = DrawingPanel.class.getSimpleName();
	
	private MainThread gameThread;

	public DrawingPanel(Context context) {
		super(context);
		getHolder().addCallback(this);
		gameThread = new MainThread(getHolder(), this);
		setFocusable(true);
	}

	public DrawingPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);
		gameThread = new MainThread(getHolder(), this);
		setFocusable(true);
	}

	public DrawingPanel(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		getHolder().addCallback(this);
		gameThread = new MainThread(getHolder(), this);
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
		//TODO Update models
	}

	public void render(Canvas canvas){
		//TODO Render Models
	}
	
	public void initiate(){
        if (gameThread.getState() == Thread.State.TERMINATED) {
    		p("Thread was terminated... creating new thread");
        	gameThread = new MainThread(getHolder(), this);
        	gameThread.setRunning(true);
        	gameThread.start();
        }
        else {
    		p("continuing thread");
        	gameThread.setRunning(true);
        	gameThread.start();
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
}
