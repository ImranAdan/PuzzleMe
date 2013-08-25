package com.adani.games.puzzleme.views;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.adani.games.puzzleme.R;
import com.adani.games.puzzleme.util.Debuggable;

/**
 * Splash Screen, used to introduce the game and load any heavy resources.
 * 
 * @author Imran Adan
 * 
 */
public class SplachScreenActivity extends Activity implements Debuggable {
	
	public static final String TAG = SplachScreenActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splach_screen);

		load();
		print("Splash Screen Started...");
	}

	private void load() {
		Runnable delay = new Runnable() {
			@Override
			public void run() {
				finish();
				Intent intent = new Intent(SplachScreenActivity.this, MainMenuActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
			}

		};
		
		Handler handler = new Handler();
		handler.postDelayed(delay, 3000);
	}

	@Override
	public void print(String message) {
		Log.d(Debuggable.DEBUG, TAG + ":" +  message);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		print("Restarting Activity");

	}
	
	@Override
	protected void onStart() {
		super.onStart();
		print("Starting Activity");

	}

	@Override
	protected void onResume() {
		super.onResume();
		print("Resuming Activity");
	}


	@Override
	protected void onPause() {
		super.onPause();
		print("Pausing Activity");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		print("Stoping Activity");

	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		print("Destroying Activity");
	}
}
