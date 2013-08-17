/**
 * 
 */
package com.adani.games.puzzleme.util;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.adani.games.puzzleme.views.DrawingPanel;

/**
 * Main game thread class, used to render and update objects in real time.
 * 
 * @author Imran Adan
 */
public class MainThread extends Thread {

	public static final String TAG = MainThread.class.getSimpleName();

	public final static int MAX_FPS = 60;
	public final static int MAX_FRAME_SKIPS = 5;
	public final static int FRAME_PERIOD = 1000 / MAX_FPS;
	private final SurfaceHolder SURFACE_HOLDER;
	private final DrawingPanel DRAWING_PANEL;

	private boolean running;

	public MainThread(SurfaceHolder holder, DrawingPanel drawingPanel) {
		SURFACE_HOLDER = holder;
		DRAWING_PANEL = drawingPanel;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() { // Run the update,render cycle
		Canvas canvas;
		long startTime, timeDelta;
		int sleepTime, framesSkipped;
		sleepTime = 0;
		while (running) {
			canvas = null;
			try {
				canvas = SURFACE_HOLDER.lockCanvas();
				synchronized (SURFACE_HOLDER) {
					startTime = System.currentTimeMillis();
					framesSkipped = 0;
					DRAWING_PANEL.render(canvas);
					timeDelta = System.currentTimeMillis() - startTime;
					sleepTime = (int) (FRAME_PERIOD - timeDelta);

					if (sleepTime > 0) {
						try {
							Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
						}
					}

					while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
						DRAWING_PANEL.update();
						sleepTime += FRAME_PERIOD;
						framesSkipped++;
					}
				}
			} finally {
				if (canvas != null) {
					SURFACE_HOLDER.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
}
