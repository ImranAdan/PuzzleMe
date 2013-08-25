package com.adani.games.puzzleme.views;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.adani.games.puzzleme.R;
import com.adani.games.puzzleme.util.Debuggable;

public class MainMenuActivity extends Activity implements Debuggable {

	public static final String TAG = MainMenuActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main_menu);
		print("Main Menu Started...");
	}

	public void onBtnPlayPressed(View v) {
		print("Starting new game");
	}

	public void onBtnLevelsPressed(View v) {
		print("Starting Levels Activity...");
	}

	public void onBtnAboutPressed(View v) {
		print("Starting About Activity");
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

	public void print(String message) {
		Log.d(DEBUG, TAG + ":" + message);
	}
}
